package com.springbank.service.core;

import com.springbank.service.persistence.PersistenceManager;

public abstract class AbstractService {
	
    protected PersistenceManager persistenceManager;

    public void setPersistenceManager(PersistenceManager persistenceManager) {
        this.persistenceManager = persistenceManager;
    }

}
