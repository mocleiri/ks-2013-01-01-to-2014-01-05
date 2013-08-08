
-- This Oracle script drops database objects in KSA schema.
-- It needs to be run by the schema owner

drop table KSSA_CONFIG cascade constraints;

-- KSA tables dropping

drop table KSSA_ACCESS_LEVEL cascade constraints;
drop table KSSA_ACNT cascade constraints;
drop table KSSA_ACNT_AUTHZ cascade constraints;
drop table KSSA_ACNT_ELECTRONIC_CONTACT cascade constraints;
drop table KSSA_ACNT_KEY_PAIR cascade constraints;
drop table KSSA_ACNT_PERSON_NAME cascade constraints;
drop table KSSA_ACNT_POSTAL_ADDRESS cascade constraints;
drop table KSSA_ACNT_PROTECTED_INFO cascade constraints;
drop table KSSA_ACNT_STATUS_TYPE cascade constraints;
drop table KSSA_ACNT_TYPE cascade constraints;
drop table KSSA_ACTIVITY cascade constraints;
drop table KSSA_ACTIVITY_TYPE cascade constraints;
drop table KSSA_ALLOCATION cascade constraints;
drop table KSSA_ALLOWABLE_GL_ACCOUNT cascade constraints;
drop table KSSA_BANK_TYPE cascade constraints;
drop table KSSA_BATCH_RECEIPT cascade constraints;
drop table KSSA_BILL_AUTHORITY cascade constraints;
drop table KSSA_BILL_RECEIVER cascade constraints;
drop table KSSA_CASH_LIMIT_EVENT cascade constraints;
drop table KSSA_CASH_LIMIT_EVENT_TRANS cascade constraints;
drop table KSSA_CASH_LIMIT_PARAMETER cascade constraints;
drop table KSSA_COLLECTION_ACNT cascade constraints;
drop table KSSA_CREDIT_PERMISSION cascade constraints;
drop table KSSA_CURRENCY cascade constraints;
drop table KSSA_DOCUMENT cascade constraints;
drop table KSSA_ELECTRONIC_CONTACT cascade constraints;
drop table KSSA_EXTERNAL_STATEMENT cascade constraints;
drop table KSSA_FLAG_TYPE cascade constraints;
drop table KSSA_FM_MANIFEST cascade constraints;
drop table KSSA_FM_MANIFEST_KEY_PAIR cascade constraints;
drop table KSSA_FM_MANIFEST_TAG cascade constraints;
drop table KSSA_FM_SESSION cascade constraints;
drop table KSSA_FM_SESSION_KEY_PAIR cascade constraints;
drop table KSSA_FM_SESSION_LOG cascade constraints;
drop table KSSA_FM_SIGNUP cascade constraints;
drop table KSSA_FM_SIGNUP_KEY_PAIR cascade constraints;
drop table KSSA_FM_SIGNUP_RATE cascade constraints;
drop table KSSA_FM_SIGNUP_RATE_AMOUNT cascade constraints;
drop table KSSA_GL_BATCH_BASELINE cascade constraints;
drop table KSSA_GL_BREAKDOWN cascade constraints;
drop table KSSA_GL_BREAKDOWN_OVERRIDE cascade constraints;
drop table KSSA_GL_RECOGNITION_PERIOD cascade constraints;
drop table KSSA_GL_TRANSACTION cascade constraints;
drop table KSSA_GL_TRANSMISSION cascade constraints;
drop table KSSA_GL_TRANS_TRANSACTION cascade constraints;
drop table KSSA_GL_TYPE cascade constraints;
drop table KSSA_ID_TYPE cascade constraints;
drop table KSSA_INFORMATION cascade constraints;
drop table KSSA_IRS_1098T cascade constraints;
drop table KSSA_KEY_PAIR cascade constraints;
drop table KSSA_LANGUAGE cascade constraints;
drop table KSSA_LATE_PERIOD cascade constraints;
drop table KSSA_NAME cascade constraints;
drop table KSSA_PB_ALLOWABLE_CHARGE cascade constraints;
drop table KSSA_PB_DATE cascade constraints;
drop table KSSA_PB_PLAN cascade constraints;
drop table KSSA_PB_QUEUE cascade constraints;
drop table KSSA_PB_SCHEDULE cascade constraints;
drop table KSSA_PB_TRANSACTION cascade constraints;
drop table KSSA_PB_TRANSFER_DETAIL cascade constraints;
drop table KSSA_POSTAL_ADDRESS cascade constraints;
drop table KSSA_RATE cascade constraints;
drop table KSSA_RATE_AMOUNT cascade constraints;
drop table KSSA_RATE_CATALOG cascade constraints;
drop table KSSA_RATE_CATALOG_ATP cascade constraints;
drop table KSSA_RATE_CATALOG_KEY_PAIR cascade constraints;
drop table KSSA_RATE_KEY_PAIR cascade constraints;
drop table KSSA_RATE_TYPE cascade constraints;
drop table KSSA_REFUND cascade constraints;
drop table KSSA_REFUND_MANIFEST cascade constraints;
drop table KSSA_REFUND_TYPE cascade constraints;
drop table KSSA_ROLLUP cascade constraints;
drop table KSSA_RULE cascade constraints;
drop table KSSA_RULE_SET cascade constraints;
drop table KSSA_RULE_SET_RULE cascade constraints;
drop table KSSA_RULE_TYPE cascade constraints;
drop table KSSA_TAG cascade constraints;
drop table KSSA_TAX_TYPE cascade constraints;
drop table KSSA_TP_ALLOWABLE_CHARGE cascade constraints;
drop table KSSA_TP_PLAN cascade constraints;
drop table KSSA_TP_PLAN_MEMBER cascade constraints;
drop table KSSA_TP_TRANSFER_DETAIL cascade constraints;
drop table KSSA_TRANSACTION cascade constraints;
drop table KSSA_TRANSACTION_MASK_ROLE cascade constraints;
drop table KSSA_TRANSACTION_TAG cascade constraints;
drop table KSSA_TRANSACTION_TRANSFER cascade constraints;
drop table KSSA_TRANSACTION_TYPE cascade constraints;
drop table KSSA_TRANSACTION_TYPE_TAG cascade constraints;
drop table KSSA_TRANSFER_TYPE cascade constraints;
drop table KSSA_UI_STRING cascade constraints;
drop table KSSA_USER_PREF cascade constraints;
drop table KSSA_XML cascade constraints;
drop table KSSA_SEQUENCE_TABLE cascade constraints;
