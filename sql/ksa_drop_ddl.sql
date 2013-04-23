
-- This Oracle script drops database objects in KSA schema.
-- It needs to be run by the schema owner

drop table KSA.KSSA_ACNT_KYPR cascade constraints;

drop table KSA.KSSA_CONFIG cascade constraints;

-- KSA tables dropping

drop table KSA.CASH_LIMIT_EVENT_TRANS cascade constraints;
drop table KSA.KSSA_ACNT cascade constraints;
drop table KSA.KSSA_ACNT_PROTECTED_INFO cascade constraints;
drop table KSA.KSSA_ACNT_STATUS_TYPE cascade constraints;
drop table KSA.KSSA_ACTIVITY cascade constraints;
drop table KSA.KSSA_ACTIVITY_TYPE cascade constraints;
drop table KSA.KSSA_ALLOCATION cascade constraints;
drop table KSA.KSSA_ALLOWABLE_GL_ACCOUNT cascade constraints;
drop table KSA.KSSA_BANK_TYPE cascade constraints;
drop table KSA.KSSA_BATCH_RECEIPT cascade constraints;
drop table KSA.KSSA_BILL_AUTHORITY cascade constraints;
drop table KSA.KSSA_CASH_LIMIT_EVENT cascade constraints;
drop table KSA.KSSA_CASH_LIMIT_PARAMETER cascade constraints;
drop table KSA.KSSA_CREDIT_PERMISSION cascade constraints;
drop table KSA.KSSA_CURRENCY cascade constraints;
drop table KSA.KSSA_DOCUMENT cascade constraints;
drop table KSA.KSSA_ELECTRONIC_CONTACT cascade constraints;
drop table KSA.KSSA_ELECTRONIC_CONTACT_ACNT cascade constraints;
drop table KSA.KSSA_EXTERNAL_STATEMENT cascade constraints;
drop table KSA.KSSA_FD_KYPR cascade constraints;
drop table KSA.KSSA_FEE_DETAIL cascade constraints;
drop table KSA.KSSA_FEE_DETAIL_AMOUNT cascade constraints;
drop table KSA.KSSA_FEE_TYPE cascade constraints;
drop table KSA.KSSA_FLAG_TYPE cascade constraints;
drop table KSA.KSSA_GL_BREAKDOWN cascade constraints;
drop table KSA.KSSA_GL_BREAKDOWN_OVERRIDE cascade constraints;
drop table KSA.KSSA_GL_RECOGNITION_PERIOD cascade constraints;
drop table KSA.KSSA_GL_TRANSACTION cascade constraints;
drop table KSA.KSSA_GL_TRANSMISSION cascade constraints;
drop table KSA.KSSA_GL_TRANS_TRANSACTION cascade constraints;
drop table KSA.KSSA_GL_TYPE cascade constraints;
drop table KSA.KSSA_ID_TYPE cascade constraints;
drop table KSA.KSSA_INFORMATION cascade constraints;
drop table KSA.KSSA_IRS_1098T cascade constraints;
drop table KSA.KSSA_KYPR cascade constraints;
drop table KSA.KSSA_LANGUAGE cascade constraints;
drop table KSA.KSSA_LATE_PERIOD cascade constraints;
drop table KSA.KSSA_LEARNING_PERIOD cascade constraints;
drop table KSA.KSSA_LU cascade constraints;
drop table KSA.KSSA_LU_KYPR cascade constraints;
drop table KSA.KSSA_PERSON_NAME cascade constraints;
drop table KSA.KSSA_PERSON_NAME_ACNT cascade constraints;
drop table KSA.KSSA_POSTAL_ADDRESS cascade constraints;
drop table KSA.KSSA_POSTAL_ADDRESS_ACNT cascade constraints;
drop table KSA.KSSA_REFUND cascade constraints;
drop table KSA.KSSA_REFUND_MANIFEST cascade constraints;
drop table KSA.KSSA_REFUND_TYPE cascade constraints;
drop table KSA.KSSA_ROLLUP cascade constraints;
drop table KSA.KSSA_RULE cascade constraints;
drop table KSA.KSSA_RULE_SET cascade constraints;
drop table KSA.KSSA_RULE_SET_RULE cascade constraints;
drop table KSA.KSSA_RULE_TYPE cascade constraints;
drop table KSA.KSSA_TAG cascade constraints;
drop table KSA.KSSA_TAX_TYPE cascade constraints;
drop table KSA.KSSA_TRANSACTION cascade constraints;
drop table KSA.KSSA_TRANSACTION_MASK_ROLE cascade constraints;
drop table KSA.KSSA_TRANSACTION_TAG cascade constraints;
drop table KSA.KSSA_TRANSACTION_TYPE cascade constraints;
drop table KSA.KSSA_TRANSACTION_TYPE_TAG cascade constraints;
drop table KSA.KSSA_UI_STRING cascade constraints;
drop table KSA.KSSA_USER_PREF cascade constraints;
drop table KSA.KSSA_XML cascade constraints;
drop table KSA.KSSA_SEQUENCE_TABLE cascade constraints;
