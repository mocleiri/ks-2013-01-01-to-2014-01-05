package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.model.CreditType;
import com.sigmasys.kuali.ksa.model.DebitType;
import com.sigmasys.kuali.ksa.model.Pair;
import com.sigmasys.kuali.ksa.service.TransactionTypeVisitor;

/**
 * TransactionTypeVisitor's default implementation. Prototype.
 *
 * @author Michael Ivanov
 */
public class DefaultTransactionTypeVisitor implements TransactionTypeVisitor {

    private final Pair<CreditType, DebitType> typeValues;


    private DefaultTransactionTypeVisitor() {
        typeValues = new Pair<CreditType, DebitType>();
    }

    public static DefaultTransactionTypeVisitor getInstance() {
        return new DefaultTransactionTypeVisitor();
    }

    @Override
    public void visit(CreditType creditType) {
        typeValues.setA(creditType);
    }

    @Override
    public void visit(DebitType debitType) {
        typeValues.setB(debitType);
    }

    public CreditType getCreditType() {
        return typeValues.getA();
    }

    public DebitType getDebitType() {
        return typeValues.getB();
    }

}
