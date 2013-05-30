package com.sigmasys.bsinas.service.jta;

import javax.transaction.Status;
import javax.transaction.UserTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.jta.JtaTransactionObject;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * TransactionManagerHelper. 
 * Contains helper methods to manage JDBC and JTA transactions.
 * 
 * @author Michael Ivanov
 */
public class TransactionManagerHelper {

    private static final Log logger = LogFactory.getLog(TransactionManagerHelper.class);

    private TransactionManagerHelper() {
    }

    public static boolean isCommit(DefaultTransactionStatus status) {
        return !status.isCompleted() && !status.isRollbackOnly() &&
                !status.isLocalRollbackOnly() && !status.isGlobalRollbackOnly();
    }

    public static void doCommit(DefaultTransactionStatus status) {
        try {
            if (isCommit(status)) {
                JtaTransactionObject txObject = (JtaTransactionObject) status.getTransaction();
                UserTransaction userTransaction = txObject.getUserTransaction();
                if (userTransaction.getStatus() != Status.STATUS_NO_TRANSACTION) {
                    userTransaction.commit();
                    logger.debug("JTA transaction [" + userTransaction + "] is commited");
                }
            }
        } catch (Throwable t) {
            logger.error("Cannot commit transaction: " + t.getMessage(), t);
            throw new RuntimeException("Cannot commit transaction: " + t.getMessage(), t);
        }
    }

    public static void doRollback(DefaultTransactionStatus status) {
        try {
            if (!status.isCompleted()) {
                JtaTransactionObject txObject = (JtaTransactionObject) status.getTransaction();
                UserTransaction userTransaction = txObject.getUserTransaction();
                if (userTransaction.getStatus() != Status.STATUS_NO_TRANSACTION) {
                    userTransaction.rollback();
                    logger.debug("JTA transaction [" + userTransaction + "] is rolled back");
                }
            }
        } catch (Throwable t) {
            logger.error("Cannot rollback transaction: " + t.getMessage(), t);
            throw new RuntimeException("Cannot rollback transaction: " + t.getMessage(), t);
        }
    }

}

