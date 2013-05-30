package com.sigmasys.bsinas.service.jta;

import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * Custom version of JtaTransactionManager that overrides a few Spring's methods.
 * @author Michael Ivanov
 * 
 */
public class JtaTransactionManager extends org.springframework.transaction.jta.JtaTransactionManager {

    @Override
    protected void doCommit(DefaultTransactionStatus status) {
        TransactionManagerHelper.doCommit(status);
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) {
        TransactionManagerHelper.doRollback(status);
    }

    @Override
    protected void doSetRollbackOnly(DefaultTransactionStatus status) {
        super.doSetRollbackOnly(status);
        doRollback(status);
    }


}

