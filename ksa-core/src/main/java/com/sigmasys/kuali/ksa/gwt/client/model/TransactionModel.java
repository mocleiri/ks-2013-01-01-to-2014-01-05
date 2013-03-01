package com.sigmasys.kuali.ksa.gwt.client.model;

import java.util.*;

/**
 * Transaction model
 *
 * @author dmulderink, mivanov
 *         Date: 5/11/12
 *         Time: 1:20 PM
 */
public class TransactionModel extends AbstractModel {

    // The search criteria keys
    public static final String ID = "transaction.id";
    public static final String TYPE = "trans_type";

    public static final String TYPE_ID = "type.id.id";
    public static final String TYPE_SUB_CODE = "type.id.subCode";
    public static final String CURRENCY_CODE = "currency.code";
    public static final String ACCOUNT_ID = "account.id";

    public static final String AMOUNT = "transaction.amount";
    public static final String ALLOCATED_AMOUNT = "transaction.allocatedAmount";
    public static final String LOCKED_ALLOCATED_AMOUNT = "transaction.lockedAllocatedAmount";
    public static final String NATIVE_AMOUNT = "transaction.nativeAmount";


    public static final String EFFECTIVE_DATE = "transaction.effectiveDate";
    public static final String ORIGINATION_DATE = "transaction.originationDate";
    public static final String CREATION_DATE = "transaction.creationDate";

    public static final String EXTERNAL_ID = "transaction.externalId";
    public static final String GL_ENTRY_GENERATED = "transaction.glEntryGenerated";
    public static final String INTERNAL = "transaction.internal";


    public static final String RESPONSIBLE_ENTITY = "transaction.creatorId";
    public static final String STATEMENT_TEXT = "transaction.statementText";
    public static final String REFUND_RULE = "transaction.refundRule";


    // The real column names
    public static final String COLUMN_ID = "trans_id";
    public static final String COLUMN_TYPE_ID = "trans_type_id";
    public static final String COLUMN_TYPE_SUB_CODE = "trans_type_sub_code";

    public static final String COLUMN_CURRENCY_CODE = "currency_code";
    public static final String COLUMN_ACCOUNT_ID = "account_id";

    public static final String COLUMN_AMOUNT = "trans_amount";
    public static final String COLUMN_ALLOCATED_AMOUNT = "trans_allocated_amount";
    public static final String COLUMN_LOCKED_ALLOCATED_AMOUNT = "trans_locked_allocated_amount";
    public static final String COLUMN_NATIVE_AMOUNT = "trans_native_amount";


    public static final String COLUMN_EFFECTIVE_DATE = "trans_effective_date";
    public static final String COLUMN_ORIGINATION_DATE = "trans_orig_date";
    public static final String COLUMN_CREATION_DATE = "trans_ledger_date";

    public static final String COLUMN_EXTERNAL_ID = "trans_external_id";
    public static final String COLUMN_GL_ENTRY_GENERATED = "trans_gl_entry_generated";
    public static final String COLUMN_INTERNAL = "trans_internal";


    public static final String COLUMN_RESPONSIBLE_ENTITY = "trans_responsible_entity";
    public static final String COLUMN_STATEMENT_TEXT = "trans_statement_text";
    public static final String COLUMN_REFUND_RULE = "trans_refund_rule";

    // That's necessary for GWT internal serialization
    private TransactionType _transactionType;


    public Long getId() {
        return get(COLUMN_ID);
    }

    public void setId(Long id) {
        set(COLUMN_ID, id);
    }

    public String getTypeId() {
        return get(COLUMN_TYPE_ID);
    }

    public void setTypeId(String id) {
        set(COLUMN_TYPE_ID, id);
    }

    public Integer getTypeSubCode() {
        return get(COLUMN_TYPE_SUB_CODE);
    }

    public void setTypeSubCode(Integer subCode) {
        set(COLUMN_TYPE_SUB_CODE, subCode);
    }

    public Double getAllocatedAmount() {
        return get(COLUMN_ALLOCATED_AMOUNT);
    }

    public void setAllocatedAmount(Double allocatedAmount) {
        set(COLUMN_ALLOCATED_AMOUNT, allocatedAmount);
    }

    public Double getAmount() {
        return get(COLUMN_AMOUNT);
    }

    public void setAmount(Double amount) {
        set(COLUMN_AMOUNT, amount);
    }

    public Date getEffectiveDate() {
        return get(COLUMN_EFFECTIVE_DATE);
    }

    public void setEffectiveDate(Date effectiveDate) {
        set(COLUMN_EFFECTIVE_DATE, effectiveDate);
    }

    public String getExternalId() {
        return get(COLUMN_EXTERNAL_ID);
    }

    public void setExternalId(String externalId) {
        set(COLUMN_EXTERNAL_ID, externalId);
    }

    public Boolean isGlEntryGenerated() {
        return get(COLUMN_GL_ENTRY_GENERATED);
    }

    public void setGlEntryGenerated(Boolean glEntryGenerated) {
        set(COLUMN_GL_ENTRY_GENERATED, glEntryGenerated);
    }

    public Boolean isInternal() {
        return get(COLUMN_INTERNAL);
    }

    public void setInternal(Boolean internal) {
        set(COLUMN_INTERNAL, internal);
    }

    public Date getCreationDate() {
        return get(COLUMN_CREATION_DATE);
    }

    public void setCreationDate(Date creationDate) {
        set(COLUMN_CREATION_DATE, creationDate);
    }

    public Double getLockedAllocatedAmount() {
        return get(COLUMN_LOCKED_ALLOCATED_AMOUNT);
    }

    public void setLockedAllocatedAmount(Double lockedAllocatedAmount) {
        set(COLUMN_LOCKED_ALLOCATED_AMOUNT, lockedAllocatedAmount);
    }

    public Double getNativeAmount() {
        return get(COLUMN_NATIVE_AMOUNT);
    }

    public void setNativeAmount(Double nativeAmount) {
        set(COLUMN_NATIVE_AMOUNT, nativeAmount);
    }

    public Date getOriginationDate() {
        return get(COLUMN_ORIGINATION_DATE);
    }

    public void setOriginationDate(Date date) {
        set(COLUMN_ORIGINATION_DATE, date);
    }

    public String getRefundRule() {
        return get(COLUMN_REFUND_RULE);
    }

    public void setRefundRule(String refundRule) {
        set(COLUMN_REFUND_RULE, refundRule);
    }

    public String getResponsibleEntity() {
        return get(COLUMN_RESPONSIBLE_ENTITY);
    }

    public void setResponsibleEntity(String entityId) {
        set(COLUMN_RESPONSIBLE_ENTITY, entityId);
    }

    public String getStatementText() {
        return get(COLUMN_STATEMENT_TEXT);
    }

    public void setStatementText(String statementText) {
        set(COLUMN_STATEMENT_TEXT, statementText);
    }

    public String getCurrencyCode() {
        return get(COLUMN_CURRENCY_CODE);
    }

    public void setCurrencyCode(String code) {
        set(COLUMN_CURRENCY_CODE, code);
    }

    public String getAccountId() {
        return get(COLUMN_ACCOUNT_ID);
    }

    public void setAccountId(String accountId) {
        set(COLUMN_ACCOUNT_ID, accountId);
    }

    public TransactionType getType() {
        return get(TYPE);
    }

    public void setType(TransactionType type) {
        set(TYPE, type);
    }
}
