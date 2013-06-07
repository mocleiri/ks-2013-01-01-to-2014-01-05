package com.sigmasys.kuali.ksa.model.security;

/**
 * Access Control permission constants.
 *
 * @author Michael Ivanov
 */
public enum Permission {

    // Tag permissions
    CREATE_TAG,
    EDIT_TAG,
    CREATE_ADMIN_TAG,
    EDIT_ADMIN_TAG,
    ASSIGN_TAG_TO_TRANSACTION,
    ASSIGN_TAG_TO_TRANSACTION_TYPE,
    ASSIGN_ADMIN_TAG_TO_TRANSACTION,
    ASSIGN_ADMIN_TAG_TO_TRANSACTION_TYPE,

    // Allocation permissions
    CREATE_ALLOCATION,
    REMOVE_ALLOCATION,
    CREATE_LOCKED_ALLOCATION,
    REMOVE_LOCKED_ALLOCATION,
    CREATE_INTERNALLY_LOCKED_ALLOCATION,
    REMOVE_INTERNALLY_LOCKED_ALLOCATION,
    READ_ALLOCATION,

    // Cash limit permissions
    CREATE_CASH_LIMIT_PARAMETER,
    EDIT_CASH_LIMIT_PARAMETER,
    CHECK_CASH_LIMIT,

    // UI tab permissions
    VIEW_ADMINISTRATION_TAB,
    VIEW_REPORTING_TAB,
    VIEW_COLLECTIONS_TAB,
    VIEW_BATCH_TAB,
    VIEW_THIRD_PARTY_TAB,
    VIEW_SETTINGS_TAB,
    VIEW_ADVANCED_SEARCH,
    VIEW_QUICK_VIEW,

    // Account permissions
    CREATE_ACCOUNT,
    UPDATE_ACCOUNT,
    DELETE_ACCOUNT,
    READ_ACCOUNT,
    AGE_ACCOUNT,
    READ_BALANCE,
    WRITE_OFF_ACCOUNT,
    VIEW_ACCOUNT_PROTECTED_INFO,
    REBALANCE_ACCOUNT,
    READ_ACH,

    // Currency permissions
    EDIT_CURRENCY,
    READ_CURRENCY,

    // General Ledger permissions
    CREATE_GL_TYPE,
    EDIT_GL_TYPE,
    READ_GL_TYPE,
    CREATE_GL_TRANSACTION,
    EDIT_GL_TRANSACTION,
    READ_GL_TRANSACTION,
    SUMMARIZE_GL_TRANSACTIONS,
    EDIT_GL_SETTINGS,
    READ_GL_REPORT,
    CREATE_GL_TRANSMISSION,
    EXPORT_GL_TRANSMISSION,
    READ_GL_TRANSMISSION,
    CREATE_GL_BREAKDOWN,
    READ_GL_BREAKDOWN,

    // Memo permissions
    READ_MEMO,
    CREATE_MEMO,
    UPDATE_MEMO,
    DELETE_MEMO,
    EXPIRE_MEMO,

    // Alert permissions
    READ_ALERT,
    CREATE_ALERT,
    UPDATE_ALERT,
    DELETE_ALERT,
    EXPIRE_ALERT,

     // Flag permissions
    READ_FLAG,
    CREATE_FLAG,
    UPDATE_FLAG,
    DELETE_FLAG,
    EXPIRE_FLAG,

    // InformationAccessLevel permissions
    READ_ACCESS_LEVEL,
    CREATE_ACCESS_LEVEL,
    UPDATE_ACCESS_LEVEL,
    DELETE_ACCESS_LEVEL,

    // Transaction permissions
    IMPORT_TRANSACTIONS,
    CREATE_CHARGE,
    CREATE_PAYMENT,
    CREATE_DEFERMENT,
    REVERSE_TRANSACTION,
    EXPIRE_DEFERMENT,
    WRITE_OFF_TRANSACTION,
    BOUNCE_TRANSACTION,
    CONTEST_CHARGE,
    CANCEL_CHARGE,
    EDIT_TRANSACTION,
    READ_TRANSACTION,
    TRANSFER_TRANSACTION,
    REVERSE_TRANSFER_TRANSACTION,
    EXPORT_CASH_LIMIT_EVENT,

    // Transaction Type permissions
    CREATE_TRANSACTION_TYPE,
    EDIT_TRANSACTION_TYPE,
    READ_TRANSACTION_TYPE,
    ASSIGN_TRANSACTION_TYPE_TO_ROLE,

    // Rollup permissions
    CREATE_ROLLUP,
    EDIT_ROLLUP,
    READ_ROLLUP,

    // Ban type permissions
    CREATE_BANK_TYPE,
    EDIT_BANK_TYPE,

    // Identity type permissions
    CREATE_IDENTITY_TYPE,
    EDIT_IDENTITY_TYPE,

    // Tax type permissions
    CREATE_TAX_TYPE,
    EDIT_TAX_TYPE,

    // Account status type permissions
    CREATE_ACCOUNT_STATUS_TYPE,
    EDIT_ACCOUNT_STATUS_TYPE,

    // Account type permissions
    CREATE_ACCOUNT_TYPE,
    EDIT_ACCOUNT_TYPE,

    // Activity type permissions
    CREATE_ACTIVITY_TYPE,
    EDIT_ACTIVITY_TYPE,

    // Refund type permissions
    CREATE_REFUND_TYPE,
    EDIT_REFUND_TYPE,

    // Transfer type permissions
    CREATE_TRANSFER_TYPE,
    EDIT_TRANSFER_TYPE,

    // Refund permissions
    REQUEST_REFUND,
    CREATE_REFUND,
    VALIDATE_REFUND,
    CANCEL_REFUND,

    // Payment application permissions
    RUN_PAYMENT_APPLICATION,

    // Billing permissions
    CREATE_BILL,
    CREATE_PAYMENT_BILLING,
    REVERSE_PAYMENT_BILLING,

    // 1098T permissions
    GENERATE_IRS_1098_T,
    READ_IRS_1098_T,

    // 8300 permissions
    GENERATE_IRS_8300,
    READ_IRS_8300,

    // Report permissions
    GENERATE_AGED_BALANCE_REPORT,
    READ_BATCH_FAILED_REPORT,
    READ_ACCOUNT_REPORT,
    READ_RECEIPT,

    // Third party permissions
    GENERATE_THIRD_PARTY_BILLING,
    REVERSE_THIRD_PARTY_BILLING,

    // CreditPermission permissions
    READ_CREDIT_PERMISSION,

    // Rate permissions
    CREATE_RATE,
    UPDATE_RATE,
    DELETE_RATE,
    READ_RATE,
    CREATE_RATE_TYPE,
    UPDATE_RATE_TYPE,
    DELETE_RATE_TYPE,
    READ_RATE_TYPE,
    CREATE_RATE_CATALOG,
    UPDATE_RATE_CATALOG,
    DELETE_RATE_CATALOG,
    READ_RATE_CATALOG

}
