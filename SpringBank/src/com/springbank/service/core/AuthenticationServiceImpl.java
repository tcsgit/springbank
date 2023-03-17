package com.springbank.service.core;

import com.springbank.entity.Operator;

public class AuthenticationServiceImpl extends AbstractService implements AuthenticationService {

	public Operator authenticateOperator(String operatorAlias, String operatorPassword) throws ServiceException {
		return (Operator) persistenceManager.findUniqueResultByQuery(
				"FROM Operator operator where operator.operatorAlias = '"+ operatorAlias +
				"' AND operator.operatorPassword = '"+ operatorPassword +"'");
	}
	
}
