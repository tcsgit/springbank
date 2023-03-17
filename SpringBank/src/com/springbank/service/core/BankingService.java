package com.springbank.service.core;

import java.util.List;

import com.springbank.entity.Account;
import com.springbank.entity.Customer;

public interface BankingService {
	
	public List getCustomerList() throws ServiceException;
	public Customer getCustomer(long customerId) throws ServiceException;
	public Customer searchCustomer(String customerNumber) throws ServiceException;	
	public void removeCustomer(long customerId) throws ServiceException;
	public void saveCustomer(Customer customer) throws ServiceException;
	public Account getAccount(long accountId) throws ServiceException;
	public void removeAccount(long accountId) throws ServiceException;
	public void saveAccount(Account account) throws ServiceException;
	public List getOtherAccountsOfCustomer(long accountId, long customerId) throws ServiceException;
	public void transferMoney(long currentAccountId, long transferAccountId, double transferAmount);

}
