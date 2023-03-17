package com.springbank.service.ws.endpoint;

import org.jdom.JDOMException;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import com.springbank.entity.Customer;
import com.springbank.service.core.BankingService;
import com.springbank.service.ws.schema.SearchCustomerRequest;
import com.springbank.service.ws.schema.SearchCustomerResponse;

public class SearchCustomerEndpoint extends AbstractMarshallingPayloadEndpoint {

    private BankingService bankingService;

    public SearchCustomerEndpoint(BankingService bankingService, Marshaller marshaller) throws JDOMException {
    	super(marshaller);
        this.bankingService = bankingService;
    }

	protected Object invokeInternal(Object request) throws Exception {
		SearchCustomerRequest searchCustomerRequest = (SearchCustomerRequest) request;
		String customerNumber =  searchCustomerRequest.getCustomerNumber();
		Customer customer = bankingService.searchCustomer(customerNumber);
		SearchCustomerResponse searchCustomerResponse = new SearchCustomerResponse();
		searchCustomerResponse.setCustomer(customer);
		return searchCustomerResponse;
	}

}
