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

    // Cash limit permissions
    CREATE_CASH_LIMIT_PARAMETER,

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
    VIEW_ACCOUNT,
    AGE_ACCOUNT,
    VIEW_BALANCE,
    WRITE_OFF_ACCOUNT,
    VIEW_PROTECTED_INFORMATION,

    // Currency permissions
    EDIT_CURRENCY,
    VIEW_CURRENCY,

    // General Ledger permissions
    EDIT_GL_SETTINGS,
    VIEW_GL_REPORT,
    CREATE_GL_TRANSMISSION,
    EXPORT_GL_TRANSMISSION,

    // Memo permissions
    VIEW_MEMO,
    CREATE_MEMO,
    EDIT_MEMO,
    EDIT_MEMO_TEXT,

    // Alert permissions
    VIEW_ALERT,
    CREATE_ALERT,
    EDIT_ALERT,
    EDIT_ALERT_TEXT,

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
    VIEW_TRANSACTION,
    TRANSFER_TRANSACTION,
    REVERSE_TRANSFER_TRANSACTION,
    EXPORT_CASH_LIMIT_EVENT,

    // Transaction Type permissions
    CREATE_TRANSACTION_TYPE,
    EDIT_TRANSACTION_TYPE,
    ASSIGN_TRANSACTION_TYPE_TO_ROLE,

    // Rollup permissions
    CREATE_ROLLUP,
    EDIT_ROLLUP,

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

    // General Ledger type permissions
    CREATE_GL_TYPE,
    EDIT_GL_TYPE,

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
    GENERATE_1098_T,
    VIEW_1098_T,

    // Report permissions
    GENERATE_AGED_BALANCE_REPORT,
    VIEW_BATCH_FAILED_REPORT,
    VIEW_ACCOUNT_REPORT,
    VIEW_RECEIPT,

    // Third party permissions
    GENERATE_THIRD_PARTY_BILLING,
    REVERSE_THIRD_PARTY_BILLING

}
