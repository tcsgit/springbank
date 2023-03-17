package com.springbank.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import com.springbank.service.core.BusinessException;
import com.springbank.service.core.ServiceException;


public class LoggingAspect {
	
	private static Log log = LogFactory.getLog("ServiceExceptions");

	public void doAfterThrowingLog(JoinPoint jp, Exception ex) {
		if (!(ex instanceof BusinessException)) {
	        Signature signature = jp.getSignature();
			log.error("Logging Aspect ["
					+ signature.getDeclaringTypeName() + "." + signature.getName()
					+ "] : " + ex.getMessage());
			throw new ServiceException(ex);			
		}
	}

}
