
-- This Oracle script creates database objects in KSA schema.
-- It needs to be run by the schema owner
-- Creating sequence table

create table KSSA_SEQUENCE_TABLE ( SEQ_NAME varchar2(255 char) not null,  SEQ_VALUE number(10,0) not null, primary key (SEQ_NAME) ) ;

-- KSA config table

create table KSSA_CONFIG ( NAME varchar2(512) not null,  VALUE varchar2(1024), LOCKED varchar2(1), primary key (NAME) ) ;

-- KSA association tables for non-annotated associations

create table KSSA_ACNT_KYPR ( ACNT_ID_FK varchar2(45 char) not null, KYPR_ID_FK number(19,0) not null, primary key (ACNT_ID_FK, KYPR_ID_FK) );

-- Creating base tables
create table KSSA_ACNT (TYPE varchar2(31 char) not null, ID varchar2(45 char) not null, CAN_AUTHENTICATE char(1 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), CREDIT_LIMIT number(19,2), EDITOR_ID varchar2(45 char), ENTITY_ID varchar2(45 char), IS_KIM_ACNT char(1 char), LAST_KIM_UPDATE timestamp, LAST_UPDATE timestamp, LATE1 number(19,2), LATE2 number(19,2), LATE3 number(19,2), DUE number(19,2), LATE_LAST_UPDATE timestamp, OUTSTANDING number(19,2), DATE_OF_BIRTH date, LATE_PERIOD_ID_FK number(19,0), ACNT_STATUS_TYPE_ID_FK number(19,0), primary key (ID));
create table KSSA_ACNT_PROTECTED_INFO (ID varchar2(45 char) not null, BANK_DETAILS varchar2(100 char), ID_ISSUER varchar2(100 char), ID_SERIAL varchar2(100 char), TAX_REFERENCE varchar2(45 char), BANK_TYPE_ID_FK number(19,0), ID_TYPE_ID_FK number(19,0), TAX_TYPE_ID_FK number(19,0), primary key (ID));
create table KSSA_ACNT_STATUS_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_ACTIVITY (id number(19,0) not null, ALTERED_ACNT_ID varchar2(45 char), CREATOR_ID varchar2(45 char), ALTERED_ENTITY_ID varchar2(255 char), ALTERED_ENTITY_PROPERTY varchar2(100 char), ALTERED_ENTITY_TYPE varchar2(255 char), IP varchar2(32 char), LOG_DETAIL varchar2(1024 char), NEW_ATTRIBUTE varchar2(4000 char), OLD_ATTRIBUTE varchar2(4000 char), CREATION_DATE timestamp, ACTIVITY_TYPE_ID number(19,0) not null, primary key (id));
create table KSSA_ACTIVITY_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_ALLOCATION (ID number(19,0) not null, ACNT_ID_FK varchar2(45 char), AMOUNT number(19,2), IS_INTERNALLY_LOCKED char(1 char), IS_LOCKED char(1 char), TRN_ID_1_FK number(19,0), TRN_ID_2_FK number(19,0), primary key (ID));
create table KSSA_ALLOWABLE_GL_ACCOUNT (ID number(19,0) not null, PATTERN varchar2(128 char) not null unique, primary key (ID));
create table KSSA_BANK_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_BATCH_RECEIPT (ID number(19,0) not null, ACNT_ID_FK varchar2(45 char), BATCH_DATE timestamp, TOTAL_ACCEPTED_CREDITS number(19,2), TOTAL_ACCEPTED_DEBITS number(19,2), EXTERNAL_ID varchar2(255 char), TOTAL_ACCEPTED number(10,0), TOTAL_REJECTED number(10,0), TOTAL_TRANS number(10,0), RECEIPT_DATE timestamp, STATUS varchar2(1 char), TOTAL_VOLUME number(19,2), TOTAL_VOLUME_REJECTED number(19,2), INCOMING_XML_ID_FK number(19,0), OUTGOING_XML_ID_FK number(19,0), primary key (ID));
create table KSSA_BILL_AUTHORITY (ID number(19,0) not null, ACNT_ID_FK varchar2(45 char), CREATOR_ID varchar2(45 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, PREFERRED_METHOD varchar2(1 char), RELEASE_AGREED_BY varchar2(45 char), RELEASE_AGREED_DATE timestamp, ELECTRONIC_CONTACT_ID_FK number(19,0), PERSON_NAME_ID_FK number(19,0), POSTAL_ADDRESS_ID_FK number(19,0), primary key (ID));
create table KSSA_CASH_LIMIT_EVENT (ID number(19,0) not null, ACCOUNT_ID varchar2(45 char), TOTAL_CHARGE_AMOUNT number(19,2), CREATOR_ID varchar2(45 char), EVENT_DATE timestamp, IS_MULTIPLE char(1 char), NOTIF_DATE timestamp, TOTAL_PAYMENT_AMOUNT number(19,2), NOTIF_RECIPIENT varchar2(255 char), REPORT_DATE timestamp, SERIALS varchar2(1 char), STATUS varchar2(1 char), XML_ID_FK number(19,0), primary key (ID));
create table KSSA_CASH_LIMIT_EVENT_TRANS (CASH_LIMIT_EVENT_ID_FK number(19,0) not null, TRANSACTION_ID_FK number(19,0) not null, primary key (CASH_LIMIT_EVENT_ID_FK, TRANSACTION_ID_FK), unique (TRANSACTION_ID_FK));
create table KSSA_CASH_LIMIT_PARAMETER (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), IS_ACTIVE char(1 char), AUTHORITY_NAME varchar2(255 char), LOWER_LIMIT number(19,2), UPPER_LIMIT number(19,2), XML_ELEMENT varchar2(45 char), TAG_ID_FK number(19,0), primary key (ID));
create table KSSA_CREDIT_PERMISSION (ID number(19,0) not null, ALLOWABLE_DEBIT_TYPE_MASK varchar2(20 char), PRIORITY number(10,0), TRANSACTION_TYPE_ID_FK varchar2(20 char), TRANSACTION_TYPE_SUB_CODE_FK number(10,0), primary key (ID));
create table KSSA_CURRENCY (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_DOCUMENT (ID number(19,0) not null, DOCUMENT long, CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), EDIT_REASON varchar2(512 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, primary key (ID));
create table KSSA_ELECTRONIC_CONTACT (ID number(19,0) not null, CREATOR_ID varchar2(45 char), IS_DEFAULT char(1 char), EDITOR_ID varchar2(45 char), EMAIL_ADDRESS varchar2(255 char), KIM_EMAIL_ADDRESS_TYPE varchar2(45 char), KIM_PHONE_TYPE varchar2(45 char), LAST_UPDATE timestamp, PHONE_COUNTRY varchar2(5 char), PHONE_EXTN varchar2(10 char), PHONE_NUMBER varchar2(20 char), primary key (ID));
create table KSSA_ELECTRONIC_CONTACT_ACNT (ACNT_ID_FK varchar2(45 char) not null, ELECTRONIC_CONTACT_ID_FK number(19,0) not null, primary key (ACNT_ID_FK, ELECTRONIC_CONTACT_ID_FK));
create table KSSA_EXTERNAL_STATEMENT (ID number(19,0) not null, CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), EDITOR_ID varchar2(45 char), FROM_DATE timestamp, LAST_UPDATE timestamp, MIME_TYPE varchar2(45 char), IS_REDIRECT char(1 char), TO_DATE timestamp, UNIQUE_KEY varchar2(255 char), URI varchar2(255 char), ACNT_ID_FK varchar2(45 char), primary key (ID));
create table KSSA_FD_KYPR (FD_ID_FK number(19,0) not null, KYPR_ID_FK number(19,0) not null, primary key (FD_ID_FK, KYPR_ID_FK), unique (KYPR_ID_FK));
create table KSSA_FEE_DETAIL (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), DEFAULT_RECOG_DATE date, DEFAULT_TRN_AMOUNT number(19,2), DEFAULT_TRN_DATE date, DEFAULT_TRN_TYPE_ID varchar2(45 char), END_DATE date, START_DATE date, SUB_CODE number(10,0), FEE_TYPE_ID_FK number(19,0), primary key (ID));
create table KSSA_FEE_DETAIL_AMOUNT (ID number(19,0) not null, AMOUNT number(19,2), CODE number(10,0), SUB_CODE number(10,0), FEE_DETAIL_ID_FK number(19,0), primary key (ID));
create table KSSA_FEE_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_FLAG_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), ACCESS_LEVEL number(10,0), primary key (ID));
create table KSSA_GL_BATCH_BASELINE (ID number(19,0) not null, AMOUNT number(19,2) not null, BATCH_ID varchar2(45 char) not null, TYPE varchar2(1 char) not null, GL_TYPE_ID_FK number(19,0), primary key (ID));
create table KSSA_GL_BREAKDOWN (ID number(19,0) not null, BREAKDOWN number(19,10), GL_ACCOUNT varchar2(45 char), GL_OPERATION varchar2(1 char), TRANSACTION_TYPE_ID_FK varchar2(20 char), TRANSACTION_TYPE_SUB_CODE_FK number(10,0), GL_TYPE_ID_FK number(19,0), primary key (ID));
create table KSSA_GL_BREAKDOWN_OVERRIDE (ID number(19,0) not null, BREAKDOWN number(19,10), GL_ACCOUNT varchar2(45 char), TRANSACTION_ID_FK number(19,0), primary key (ID));
create table KSSA_GL_RECOGNITION_PERIOD (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), END_DATE timestamp not null, FISCAL_YEAR number(10,0) not null, START_DATE timestamp not null, primary key (ID));
create table KSSA_GL_TRANSACTION (ID number(19,0) not null, AMOUNT number(19,2), GL_ACCOUNT_ID varchar2(45 char), GL_OPERATION varchar2(1 char), STATUS varchar2(1 char), TRANSACTION_DATE timestamp, STATEMENT varchar2(1024 char), GL_RECOGNITION_PERIOD_ID_FK number(19,0), GL_TRANSMISSION_ID_FK number(19,0), primary key (ID));
create table KSSA_GL_TRANSMISSION (ID number(19,0) not null, AMOUNT number(19,2), GL_ACCOUNT_ID varchar2(45 char), GL_OPERATION varchar2(1 char), STATUS varchar2(1 char), BATCH_ID varchar2(100 char), TRANSMISSION_DATE timestamp, EARLIEST_DATE timestamp, LATEST_DATE timestamp, GL_RECOGNITION_PERIOD_ID_FK number(19,0), primary key (ID));
create table KSSA_GL_TRANS_TRANSACTION (GL_TRANSACTION_ID_FK number(19,0) not null, TRANSACTION_ID_FK number(19,0) not null, primary key (GL_TRANSACTION_ID_FK, TRANSACTION_ID_FK));
create table KSSA_GL_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), GL_ASSET_ACCOUNT varchar2(45 char) not null, GL_OPERATION_ON_CHARGE varchar2(1 char) not null, primary key (ID));
create table KSSA_ID_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_INFORMATION (TYPE varchar2(31 char) not null, ID number(19,0) not null, ACNT_ID_FK varchar2(45 char), ACCESS_LEVEL number(10,0), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), EDITOR_ID varchar2(45 char), EFFECTIVE_DATE date, EXPIRATION_DATE date, LAST_UPDATE timestamp, TEXT varchar2(4000 char), SEVERITY number(10,0), TRN_ID_FK number(19,0), NEXT_ID number(19,0), PREV_ID number(19,0), FLAG_TYPE_ID_FK number(19,0), primary key (ID));
create table KSSA_IRS_1098T (ID number(19,0) not null, BILLED_AMOUNT number(19,2), IS_CORRECTED char(1 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), END_DATE timestamp, FILER_ADDRESS_CITY varchar2(100 char), FILER_ADDRESS_COUNTRY varchar2(100 char), FILER_FEIN varchar2(10 char), FILER_NAME varchar2(100 char), FILER_PHONE_NUMBER varchar2(45 char), FILER_ADDRESS_POSTAL_CODE varchar2(10 char), FILER_ADDRESS_STATE varchar2(10 char), FILER_ADDRESS_LINE_1 varchar2(100 char), FILER_ADDRESS_LINE_2 varchar2(100 char), FILER_ADDRESS_LINE_3 varchar2(100 char), FORM_YEAR varchar2(4 char), INCLUDES_NEXT_QUARTER char(1 char), INS_REFUND_AMOUNT number(19,2), PRIOR_YEAR_ADJ_AMOUNT number(19,2), RECEIVED_PAYMENTS number(19,2), IS_REPORTING_METHOD_CHG char(1 char), SCHOLARSHIP_ADJ_AMOUNT number(19,2), SCHOLARSHIP_AMOUNT number(19,2), START_DATE timestamp, STUDENT_ACNT_NUMBER varchar2(45 char), IS_STUDENT_GRADUATE char(1 char), IS_STUDENT_HALF_TIME char(1 char), STUDENT_NAME varchar2(100 char), STUDENT_SSN varchar2(12 char), IS_VOID char(1 char), ACNT_ID_FK varchar2(45 char), STUDENT_POSTAL_ADDRESS_ID_FK number(19,0), XML_ID_FK number(19,0), primary key (ID));
create table KSSA_KYPR (TYPE varchar2(31 char) not null, ID number(19,0) not null, NAME varchar2(45 char), PREV_VALUE varchar2(256 char), VALUE varchar2(256 char), LEARNING_PERIOD_ID_FK number(19,0), primary key (ID));
create table KSSA_LANGUAGE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), LOCALE varchar2(20 char) not null unique, primary key (ID));
create table KSSA_LATE_PERIOD (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), DAYS_LATE1 number(10,0), DAYS_LATE2 number(10,0), DAYS_LATE3 number(10,0), IS_DEFAULT char(1 char), primary key (ID));
create table KSSA_LEARNING_PERIOD (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), END_DATE timestamp not null, START_DATE timestamp not null, primary key (ID));
create table KSSA_LU (ID number(19,0) not null, ACNT_ID_FK varchar2(45 char), ADD_DATE timestamp, CAMPUS varchar2(45 char), CREDIT number(5,2), DROP_DATE timestamp, LU_LEVEL varchar2(256 char), STATUS varchar2(45 char), UNIT_CODE varchar2(45 char), UNIT_SECTION varchar2(45 char), LEARNING_PERIOD_ID_FK number(19,0), primary key (ID));
create table KSSA_LU_KYPR (LU_ID_FK number(19,0) not null, KYPR_ID_FK number(19,0) not null, primary key (LU_ID_FK, KYPR_ID_FK), unique (KYPR_ID_FK));
create table KSSA_PERSON_NAME (ID number(19,0) not null, CREATOR_ID varchar2(45 char), IS_DEFAULT char(1 char), EDITOR_ID varchar2(45 char), FIRST_NAME varchar2(100 char), KIM_NAME_TYPE varchar2(45 char), LAST_NAME varchar2(100 char), LAST_UPDATE timestamp, MIDDLE_NAME varchar2(100 char), SUFFIX varchar2(10 char), TITLE varchar2(10 char), primary key (ID));
create table KSSA_PERSON_NAME_ACNT (ACNT_ID_FK varchar2(45 char) not null, PERSON_NAME_ID_FK number(19,0) not null, primary key (ACNT_ID_FK, PERSON_NAME_ID_FK));
create table KSSA_POSTAL_ADDRESS (ID number(19,0) not null, CITY varchar2(100 char), COUNTRY_CODE varchar2(10 char), CREATOR_ID varchar2(45 char), IS_DEFAULT char(1 char), EDITOR_ID varchar2(45 char), KIM_ADDRESS_TYPE varchar2(45 char), LAST_UPDATE timestamp, POSTAL_CODE varchar2(12 char), STATE_CODE varchar2(5 char), LINE1 varchar2(100 char), LINE2 varchar2(100 char), LINE3 varchar2(100 char), primary key (ID));
create table KSSA_POSTAL_ADDRESS_ACNT (ACNT_ID_FK varchar2(45 char) not null, POSTAL_ADDRESS_ID_FK number(19,0) not null, primary key (ACNT_ID_FK, POSTAL_ADDRESS_ID_FK));
create table KSSA_RATE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), IS_AMOUNT_FINAL char(1 char), ATP_ID varchar2(45 char), RECOGNITION_DATE date, TRANSACTION_DATE date, TRANS_DATE_TYPE varchar2(10 char), IS_TRANS_TYPE_FINAL char(1 char), TRANSACTION_TYPE_ID varchar2(20 char), RATE_CATALOG_ID_FK number(19,0), primary key (ID));
create table KSSA_RATE_AMOUNT (ID number(19,0) not null, AMOUNT number(19,2), TRANSACTION_TYPE_ID varchar2(20 char), UNIT number(10,0), UNIT_FRACTION number(10,0), RATE_ID_FK number(19,0), primary key (ID));
create table KSSA_RATE_CATALOG_ATP (ATP_ID varchar2(45 char) not null, RATE_CATALOG_CODE varchar2(20 char) not null, RATE_CATALOG_ID_FK number(19,0), primary key (ATP_ID, RATE_CATALOG_CODE));
create table KSSA_RATE_CATALOG_KYPR (RATE_CATALOG_ID_FK number(19,0) not null, KYPR_ID_FK number(19,0) not null, primary key (RATE_CATALOG_ID_FK, KYPR_ID_FK));
create table KSSA_RATE_KYPR (RATE_ID_FK number(19,0) not null, KYPR_ID_FK number(19,0) not null, primary key (RATE_ID_FK, KYPR_ID_FK));
create table KSSA_RATE_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), IS_AMOUNT_CAPPED char(1 char), CAPPED_AMOUNT number(19,2), IS_KEYPAIR_FINAL char(1 char), LOWER_BOUND_AMOUNT number(19,2), IS_RECOG_DATE_DEFINABLE char(1 char), TRANS_DATE_TYPE varchar2(10 char), IS_TRANS_DATE_TYPE_FINAL char(1 char), IS_TRANS_TYPE_FINAL char(1 char), TRANSACTION_TYPE_ID varchar2(20 char), UPPER_BOUND_AMOUNT number(19,2), RATE_TYPE_ID_FK number(19,0), primary key (ID));
create table KSSA_REFUND (ID number(19,0) not null, AMOUNT number(10,2) not null, ATTRIBUTE varchar2(1000 char), BATCH_ID varchar2(100 char), REFUND_DATE timestamp, REFUND_GROUP_ID varchar2(100 char), REQUEST_DATE timestamp, OVERRIDE_STATEMENT varchar2(1024 char), STATUS varchar2(1 char), SYSTEM varchar2(100 char), AUTHORIZED_BY_ID_FK varchar2(45 char), REFUND_MANIFEST_ID_FK number(19,0), REFUND_TRANSACTION_ID_FK number(19,0), REFUND_TYPE_ID_FK number(19,0), REQUESTED_BY_ID_FK varchar2(45 char), TRANSACTION_ID_FK number(19,0) not null, primary key (ID));
create table KSSA_REFUND_MANIFEST (ID number(19,0) not null, BANK_TRANSFER_ID varchar2(45 char), CHECK_IDENTIFIER varchar2(45 char), CREDIT_CARD_ID varchar2(45 char), OTHER_ID varchar2(45 char), REFUND_ACCOUNT_ID_FK varchar2(45 char), REFUND_TRANSACTION_ID_FK number(19,0), primary key (ID));
create table KSSA_REFUND_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), CREDIT_TYPE_ID varchar2(20 char), DEBIT_TYPE_ID varchar2(20 char), primary key (ID));
create table KSSA_ROLLUP (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_RULE (ID number(19,0) not null, DESCRIPTION varchar2(512 char), HEADER varchar2(4000 char), NAME varchar2(128 char) not null unique, LHS varchar2(4000 char) not null, PRIORITY number(10,0), RHS varchar2(4000 char) not null, RULE_TYPE_ID_FK number(19,0) not null, primary key (ID));
create table KSSA_RULE_SET (ID number(19,0) not null, DESCRIPTION varchar2(512 char), HEADER varchar2(4000 char), NAME varchar2(128 char) not null unique, RULE_TYPE_ID_FK number(19,0) not null, primary key (ID));
create table KSSA_RULE_SET_RULE (RULE_SET_ID_FK number(19,0) not null, RULE_ID_FK number(19,0) not null, primary key (RULE_SET_ID_FK, RULE_ID_FK));
create table KSSA_RULE_TYPE (ID number(19,0) not null, DESCRIPTION varchar2(512 char) not null, NAME varchar2(16 char) not null unique, primary key (ID));
create table KSSA_TAG (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), ACCESS_LEVEL number(10,0), IS_ADMINISTRATIVE char(1 char), primary key (ID));
create table KSSA_TAX_TYPE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), primary key (ID));
create table KSSA_TRANSACTION (TYPE varchar2(31 char) not null, ID number(19,0) not null, ACNT_ID_FK varchar2(45 char), ALLOCATED number(19,2), AMOUNT number(19,2), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), EFFECTIVE_DATE date, EXTN_ID varchar2(45 char), GL_ENTRY_GENERATED char(1 char), IS_GL_OVERRIDDEN char(1 char), IS_INTERNAL_TRN char(1 char), LOCKED_ALLOCATED number(19,2), NATIVE_AMOUNT number(19,2), ORIG_DATE date, RECOGNITION_DATE date, STATEMENT_TXT varchar2(100 char), STATUS varchar2(30 char), CANCELLATION_RULE varchar2(2000 char), EXPIRATION_DATE date, ORIG_AMOUNT number(19,2), CLEAR_DATE date, REFUND_RULE varchar2(2000 char), IS_REFUNDABLE char(1 char), CURRENCY_ID_FK number(19,0), DOCUMENT_ID_FK number(19,0), GL_TYPE_ID_FK number(19,0), ROLLUP_ID_FK number(19,0), TRANSACTION_TYPE_ID_FK varchar2(20 char), TRANSACTION_TYPE_SUB_CODE_FK number(10,0), primary key (ID));
create table KSSA_TRANSACTION_MASK_ROLE (ID number(19,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), ROLE_NAME varchar2(255 char), TYPE_MASK varchar2(255 char), primary key (ID));
create table KSSA_TRANSACTION_TAG (TRANSACTION_ID_FK number(19,0) not null, TAG_ID_FK number(19,0) not null, unique (TRANSACTION_ID_FK, TAG_ID_FK));
create table KSSA_TRANSACTION_TYPE (TYPE varchar2(31 char) not null, ID varchar2(20 char) not null, SUB_CODE number(10,0) not null, CODE varchar2(50 char), CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), DESCRIPTION varchar2(2000 char), EDITOR_ID varchar2(45 char), LAST_UPDATE timestamp, NAME varchar2(100 char), DEFAULT_TRN_TXT varchar2(100 char), END_DATE date, PRIORITY number(10,0), START_DATE date, AUTH_TXT varchar2(1000 char), CLEAR_PERIOD number(10,0), UNALLOCATED_GL_OPERATION varchar2(1 char), REFUND_RULE varchar2(2000 char), IS_REFUNDABLE char(1 char), UNALLOCATED_GL_ACCOUNT varchar2(45 char), CANCELLATION_RULE varchar2(2000 char), DEF_ROLLUP_ID_FK number(19,0), primary key (ID, SUB_CODE));
create table KSSA_TRANSACTION_TYPE_TAG (TRANSACTION_TYPE_ID_FK varchar2(20 char) not null, TRANSACTION_TYPE_SUB_CODE_FK number(10,0) not null, TAG_ID_FK number(19,0) not null, unique (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK, TAG_ID_FK));
create table KSSA_UI_STRING (ID varchar2(128 char) not null, LOCALE varchar2(20 char) not null, MAX_LENGTH number(10,0), IS_OVERRIDDEN char(1 char), TEXT varchar2(4000 char), primary key (ID, LOCALE));
create table KSSA_USER_PREF (ACNT_ID_FK varchar2(45 char) not null, NAME varchar2(255 char) not null, VALUE varchar2(1024 char), OVRD_VALUE varchar2(1024 char), primary key (ACNT_ID_FK, NAME));
create table KSSA_XML (ID number(19,0) not null, CREATION_DATE timestamp, CREATOR_ID varchar2(45 char), XML_DOCUMENT long not null, primary key (ID));
