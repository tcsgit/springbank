package com.springbank.service.core;

import com.springbank.entity.Operator;

public interface AuthenticationService {
	
	public Operator authenticateOperator(String operatorAlias, String operatorPassword) throws ServiceException;

}
