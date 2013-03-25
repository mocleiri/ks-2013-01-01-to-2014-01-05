package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.AuditableEntity;
import com.sigmasys.kuali.ksa.model.Rollup;
import com.sigmasys.kuali.ksa.model.TransactionType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: tbornholtz
 * Date: 3/25/13
 */
public class TransactionTypeGroupModel {

    private List<TransactionTypeModel> transactionTypes;

    private TransactionTypeModel currentTransactionType;

    public <T extends AuditableEntity> void addTransactionType(T entity) {

        TransactionTypeModel m;
        if (entity instanceof TransactionType) {
            m = new TransactionTypeModel((TransactionType) entity);
        } else if(entity instanceof  TransactionTypeModel) {
            m = (TransactionTypeModel) entity;
        } else {
            throw new RuntimeException("Unexpected type passed to addTransactionType: " + entity.getClass().getName());
        }

        if(transactionTypes == null){
            transactionTypes = new ArrayList<TransactionTypeModel>();
        }
        transactionTypes.add(m);

        // there can be only one with the null end date.  That's the current one.
        if(currentTransactionType == null || m.getTransactionType().getEndDate() == null){
            currentTransactionType = m;
        } else {
            Date currentEndDate = currentTransactionType.getTransactionType().getEndDate();
            Date newEndDate = m.getTransactionType().getEndDate();

            if(currentEndDate != null && newEndDate.after(currentEndDate)){
                currentTransactionType = m;
            }
        }
    }


    public List<TransactionTypeModel> getTransactionTypes() {
        if(transactionTypes == null){
            transactionTypes = new ArrayList<TransactionTypeModel>();
        }
        return transactionTypes;
    }

    public void setTransactionTypes(List<TransactionTypeModel> transactionTypes) {
        this.transactionTypes = transactionTypes;
    }

    public TransactionTypeModel getCurrentTransactionType() {
        return currentTransactionType;
    }

    public void setCurrentTransactionType(TransactionTypeModel currentTransactionType) {
        this.currentTransactionType = currentTransactionType;
    }
}
