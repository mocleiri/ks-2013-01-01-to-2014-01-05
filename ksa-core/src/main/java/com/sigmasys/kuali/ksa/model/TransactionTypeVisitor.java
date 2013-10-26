package com.sigmasys.kuali.ksa.model;

/**
 * TransactionType visitor. Typically used to avoid class casting problems with Hibernate proxies.
 *
 * @author Michael Ivanov
 */
public interface TransactionTypeVisitor {

    void visit(CreditType creditType);

    void visit(DebitType debitType);

}
