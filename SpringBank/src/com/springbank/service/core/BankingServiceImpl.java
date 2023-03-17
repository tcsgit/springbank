package com.springbank.service.core;

import java.util.List;

import com.springbank.entity.Account;
import com.springbank.entity.Customer;

public class BankingServiceImpl extends AbstractService implements BankingService{
	
	public List getCustomerList() {
		return persistenceManager.findAll(Customer.class);
	}

	public Customer getCustomer(long customerId) throws ServiceException {
		return (Customer) persistenceManager.findByIdWithRelation(Customer.class, customerId);
	}
	
	public Customer searchCustomer(String customerNumber) throws ServiceException {
		return (Customer) persistenceManager.findUniqueResultByQueryWithRelation("FROM Customer customer where customer.customerNumber  = '"+ customerNumber +"'");
	}

	public void removeCustomer(long customerId) throws ServiceException {
		Customer customer = (Customer) persistenceManager.findById(Customer.class, customerId);
		persistenceManager.delete(customer);
	}
	
	public void saveCustomer(Customer customer) throws ServiceException {
		persistenceManager.saveOrUpdate(customer);
	}
	
	public Account getAccount(long accountId) throws ServiceException {
		return (Account) persistenceManager.findById(Account.class, accountId);
	}
	
	public void removeAccount(long accountId) throws ServiceException {
		Account account = (Account) persistenceManager.findById(Account.class, accountId);
		persistenceManager.delete(account);
	}
	
	public void saveAccount(Account account) throws ServiceException {
		persistenceManager.saveOrUpdate(account);
	}

	public List getOtherAccountsOfCustomer(long accountId, long customerId) throws ServiceException {		
		return persistenceManager.findByQuery("FROM Account account where account.id <> "+ accountId +" AND account.customer.id = "+ customerId);
	}

	public void transferMoney(long currentAccountId, long transferAccountId, double transferAmount) throws ServiceException, BusinessException{
		Account currentAccount = (Account) persistenceManager.findById(Account.class, currentAccountId);
		Account transferAccount = (Account) persistenceManager.findById(Account.class, transferAccountId);
		transferAccount.setAccountBalance(transferAccount.getAccountBalance() + transferAmount);
		
		if(transferAmount > currentAccount.getAccountBalance())
			throw new BusinessException("No enough money in current account !");
		
		currentAccount.setAccountBalance(currentAccount.getAccountBalance() - transferAmount);		
	}
}
 