package com.sigmasys.bsinas.service.jta;


import com.atomikos.icatch.jta.UserTransactionManager;
import org.hibernate.transaction.TransactionManagerLookup;

import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import java.util.Properties;


/**
 * AtomikosTransactionManagerLookup.
 *
 * @author Michael Ivanov
 */
public class AtomikosTransactionManagerLookup implements TransactionManagerLookup {


    private static final UserTransactionManager transactionManager = new UserTransactionManager();

    static {
        transactionManager.setForceShutdown(false);
    }

    public static TransactionManager getTransactionManager() {
       return transactionManager;
    }

    @Override
    public TransactionManager getTransactionManager(Properties props) {
       return transactionManager;
    }

    @Override
    public String getUserTransactionName() {
        //return "java:comp/UserTransaction";
        return null;
    }


    /**
    	 * Determine an identifier for the given transaction appropriate for use in caching/lookup usages.
    	 * <p/>
    	 * Generally speaking the transaction itself will be returned here.  This method was added specifically
    	 * for use in WebSphere and other unfriendly JEE containers (although WebSphere is still the only known
    	 * such brain-dead, sales-driven impl).
    	 *
    	 * @param transaction The transaction to be identified.
    	 * @return An appropriate identifier
    	 */
    @Override
    public Object getTransactionIdentifier(Transaction transaction) {
        return transaction;
    }
}
