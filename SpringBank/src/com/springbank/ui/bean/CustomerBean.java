package com.springbank.ui.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.springbank.entity.Account;
import com.springbank.entity.Customer;

public class CustomerBean {	
	private Customer customer = new Customer();
	private Account account = new Account();
	private List customers = new ArrayList();
	private SelectItem[] otherAccountsOfCustomer = new SelectItem[0];
	
	private long transferAccountId;
	private double transferAmount;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List getCustomers() {
		return customers;
	}
	public void setCustomers(List customers) {
		this.customers = customers;
	}
	public SelectItem[] getOtherAccountsOfCustomer() {
		return otherAccountsOfCustomer;
	}
	public void setOtherAccountsOfCustomer(List otherAccountsOfCustomer) {
		int size = otherAccountsOfCustomer.size();
		this.otherAccountsOfCustomer = new SelectItem[size];	
		for (int i = 0; i < size; i++) {
			Account account = (Account)otherAccountsOfCustomer.get(i);
			this.otherAccountsOfCustomer[i] = new SelectItem(new Long(account.getAccountId()), account.getAccountNumber()+"  ["+ account.getAccountBalance() +"]");
		}		
	}	
	public long getTransferAccountId() {
		return transferAccountId;
	}
	public void setTransferAccountId(long transferAccountId) {
		this.transferAccountId = transferAccountId;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}	

	public void resetCustomer() {
		customer = new Customer();
	}	

	public void resetAccount() {
		account = new Account();
		account.getCustomer().setCustomerId(customer.getCustomerId());
		otherAccountsOfCustomer = new SelectItem[0];		
	}	

	public void resetTransfer() {
		transferAccountId = 0;
		transferAmount = 0;
	}	

	public List getAccounts() {
		return new ArrayList(customer.getAccounts());
	}
	
	public boolean isCustomersRendered() {
		return customers.size() > 0;
	}	

	public boolean isAccountsRendered() {
		return customer.getAccounts().size() > 0;
	}	

	public boolean isOtherAccountsOfCustomerRendered() {
		return otherAccountsOfCustomer.length > 0;
	}

}
