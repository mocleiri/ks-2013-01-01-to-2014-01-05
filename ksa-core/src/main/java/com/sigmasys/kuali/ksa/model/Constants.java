package com.sigmasys.kuali.ksa.model;

/**
 * KSA commonly used constants.
 *
 * @author Michael Ivanov
 */
public interface Constants {

    // Generic constants
    String MODULE_NAME = "KSA";

    // Persistence units
    String KS_PERSISTENCE_UNIT = "ks";
    String KSA_PERSISTENCE_UNIT = "ksa";
    String RICE_PERSISTENCE_UNIT = "rice";

    // KSA parameter names
    String LOGGING_OPERATION = "ksa.logging.operation";

    String DEFAULT_WRITE_OFF_ROLLUP = "ksa.writeoff.rollup";
    String DEFAULT_MEMO_LEVEL = "ksa.memo.level";
    String LOCALE_LANG = "ksa.locale.lang";
    String LOCALE_COUNTRY = "ksa.locale.country";
    String IMPORT_SINGLE_BATCH_FAILURE = "ksa.import.single.batch.failure";
    String DEFAULT_GL_TYPE = "ksa.general.ledger.type";
    String DEFAULT_GL_MODE = "ksa.general.ledger.mode";
    String DEFAULT_GL_PA_STATEMENT = "ksa.general.ledger.payment.application.statement";
    String CONTEST_PAYMENT_TYPE = "ksa.payment.contest.type.id";


    // Drools parameters
    String DROOLS_CLASSPATH = "drools";
    String DROOLS_FM_RULE_SET_NAME = "Fee Management";
    String DROOLS_PA_RULE_SET_NAME = "Payment Application";

    // Quick View parameters
    String QUICKVIEW_INFORMATION_COUNT = "ksa.quickview.information.count";

    // WS constants
    String WS_NAMESPACE = "http://sigmasys.com/";

    // Rice constants
    String APPLICATION_HOST_PARAM_NAME = "application.host";

    // ---------------------------------------------------------------
    // DATE FORMATS
    // ---------------------------------------------------------------
    String DATE_FORMAT_US = "MM/dd/yyyy";
    String DATE_FORMAT_EXPORT = "yyyy-MM-dd";

    String TIMESTAMP_FORMAT = "MM/dd/yyyy HH:mm:ss.SSS";
    String TIMESTAMP_FORMAT_NO_MS = "MM/dd/yyyy HH:mm:ss";
    String DB_TIMESTAMP_FORMAT_NO_MS = "MM/dd/yyyy hh24:mi:ss";

    String TIME_FORMAT = "HH:mm:ss.SSS";
    String TIME_FORMAT_NO_MS = "HH:mm:ss";
    String TIME_FORMAT_MINUTES = "HH:mm";

    // URL mapping constants
    String CONFIG_SERVICE_URL = "config.service";
    String ACCOUNT_SERVICE_URL = "account.service";
    String TRANSACTION_SERVICE_URL = "transaction.service";

    // Refund constants:
    String REFUND_ACCOUNT_SYSTEM_NAME = "ksa.refund.account.system.name";
    String REFUND_ACCOUNT_TYPE = "ksa.refund.account.type";
    String REFUND_CHECK_GROUP = "ksa.refund.check.group";
    String REFUND_CHECK_SYSTEM_NAME = "ksa.refund.check.system.name";
    String REFUND_CHECK_TYPE = "ksa.refund.check.type";
    String REFUND_CHECK_GROUP_ROLLUP = "ksa.refund.check.group.rollup";
    String REFUND_ACH_GROUP = "ksa.refund.ach.group";
    String REFUND_ACH_TYPE = "ksa.refund.ach.type";
    String REFUND_ACH_SYSTEM_NAME = "ksa.refund.ach.system.name";
    String REFUND_ACH_BANK_TYPE = "ksa.refund.ach.bank.type";
    String REFUND_ACH_GROUP_ROLLUP = "ksa.refund.ach.group.rollup";
    String REFUND_METHOD = "ksa.refund.method";
    String OVERRIDE_REFUND_METHOD = "ksa.override.refund.method";
    String DEFAULT_REFUND_METHOD = "ksa.default.refund.method";
    String REFUND_SOURCE_TYPE = "ksa.refund.source.type";

    // KFS constants (mostly used by Transaction XML export services)
    String KFS_CHART_OF_ACCOUNTS_CODE_PARAM_NAME = "kfs.coa.code";
    String KFS_ORGANIZATION_CODE_PARAM_NAME = "kfs.organization.code";
    String KFS_BATCH_NUMBER_PREFIX_PARAM_NAME = "kfs.batch.number.prefix";
    String KFS_DOCUMENT_NUMBER_PREFIX_PARAM_NAME = "kfs.document.number.prefix";
    String KFS_EMAIL_ADDRESS_PARAM_NAME = "kfs.email.address";
    String KFS_POSTAL_ADDRESS_PARAM_NAME = "kfs.postal.address";
    String KFS_PHONE_NUMBER_PARAM_NAME = "kfs.phone.number";
    String KFS_CAMPUS_CODE_PARAM_NAME = "kfs.campus.code";
    String KFS_DEPARTMENT_NAME_PARAM_NAME = "kfs.department.name";
    String KFS_BALANCE_TYPE_CODE_PARAM_NAME = "kfs.balance.type.code";
    String KFS_DOCUMENT_TYPE_CODE_PARAM_NAME = "kfs.document.type.code";
    String KFS_OBJECT_TYPE_CODE_PARAM_NAME = "kfs.object.type.code";
    String KFS_ORIGINATION_CODE_PARAM_NAME = "kfs.origination.code";
    String KFS_TRANSACTION_GL_ENTRY_DESCRIPTION_PARAM_NAME = "kfs.transaction.gl.entry.description";

    // 1098T Report constants
    String KSA_1098_SSN_TAX_TYPE = "ksa.1098.us.ssn.tax.type";
    String KSA_1098_SSN_DISPLAY_DIGITS = "ksa.1098.us.ssn.display.digits";
    String KSA_1098_FILER_NAME = "ksa.1098.filer.name";
    String KSA_1098_FILER_ADDRESS1 = "ksa.1098.filer.address1";
    String KSA_1098_FILER_ADDRESS2 = "ksa.1098.filer.address2";
    String KSA_1098_FILER_ADDRESS3 = "ksa.1098.filer.address3";
    String KSA_1098_FILER_CITY = "ksa.1098.filer.city";
    String KSA_1098_FILER_STATE = "ksa.1098.filer.state";
    String KSA_1098_FILER_COUNTRY = "ksa.1098.filer.country";
    String KSA_1098_FILER_ZIP = "ksa.1098.filer.zip";
    String KSA_1098_FILER_FEIN = "ksa.1098.filer.fein";
    String KSA_1098_FILER_PHONE = "ksa.1098.filer.phone";
    String KSA_1098_TAG_BILLED_AMOUNT = "ksa.1098.tag.amount.billed";
    String KSA_1098_TAG_INSURANCE_REFUND = "ksa.1098.tag.insurance.refund";
    String KSA_1098_TAG_GRANTS = "ksa.1098.tag.grants";
    String KSA_1098_REPORTING_METHOD_CHANGE = "ksa.1098.reporting.method.change";

    // KSA Transaction constants
    String KSA_TRANSACTION_RECOGNITION_YEAR = "ksa.transaction.recognition.year";

}
