--------------------------------------------------------
--  File created - Tuesday-April-10-2012   
--------------------------------------------------------

-- INSERTING SEQUENCE VALUES


insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ACCOUNT_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ACTIVITY_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ACTIVITY_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ALLOCATION_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('BANK_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('CREDIT_PERMISSION_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('CURRENCY_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('DOCUMENT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ELECTRONIC_CONTACT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('FLAG_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('GL_BREAKDOWN_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('GL_BREAKDOWN_OVERRIDE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('GL_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('INFORMATION_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('LATE_PERIOD_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('PERSON_NAME_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ADDRESS_NAME_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ROLLUP_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('TAG_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('TAX_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ID_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('TRANSACTION_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('LANGUAGE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('REFUND_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('REFUND_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('REFUND_MANIFEST_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('BATCH_RECEIPT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('TRANSACTION_MASK_ROLE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('GL_TRANSACTION_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('GL_TRANSMISSION_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('EXT_STATEMENT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('BILL_AUTHORITY_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('LEARNING_UNIT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('LEARNING_PERIOD_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('GL_RECOGNITION_PERIOD_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('RULE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('RULE_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('RULE_SET_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('IRS_1098T_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ALLOWABLE_GL_ACCOUNT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('CASH_LIMIT_EVENT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('CASH_LIMIT_SUM_ELEMENT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('CASH_LIMIT_PARAMETER_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('GL_BATCH_BASELINE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('RATE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('RATE_TYPE_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('RATE_CATALOG_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('RATE_AMOUNT_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('KYPR_SEQ', 1001);
insert into KSSA_SEQUENCE_TABLE (SEQ_NAME, SEQ_VALUE) values ('ACCESS_LEVEL_SEQ', 1001);

--  SYSTEM CONFIGURATION PARAMETERS --
-- Rice-specific parameters --
insert into KSSA_CONFIG (NAME, VALUE) values ('application.host', 'localhost');

-- KSA-specific parameters --
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.locale.lang', 'en');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.locale.country', 'US');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.import.single.batch.failure', 'false');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.logging.operation', 'true');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.deferment.type.id', 'DEF');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.payment.contest.type.id', 'cash');

-- General Ledger settings
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.general.ledger.type', 'SAR');
-- The GL mode can be Individual, Batch, BatchRollup
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.general.ledger.mode', 'Batch');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.general.ledger.payment.application.statement', 'PA Transaction');


-- Combined Cash Limit Tracking Settings
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.cash.tracking.system', 'ON');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.cash.tracking.amount', '10000');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.cash.tracking.days', '365');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.cash.tracking.tag', 'Cash');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.cash.tracking.email.address.from', 'ksa.sigmasys@gmail.com');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.cash.tracking.email.recipient', 'mivanov@sigmasys.com');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.cash.tracking.email.subject', 'Cash Limit Event');

-- SMTP service parameters
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.host', 'smtp.gmail.com');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.port', '587');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.protocol', 'smtp');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.auth', 'true');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.user', 'ksa.sigmasys');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.password', 'sigmasys2013');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.tls.enabled', 'true');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.mail.address.from', 'ksa.sigmasys@gmail.com');

-- Memo settings
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.memo.level', 'DEF_MEMO_LEVEL_CD');

-- Account settings
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.account.status.type', 'N/A');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.account.credit.limit', '20000');
-- Age Debt method can either be "BALANCE_FORWARD" or "OPEN_ITEM"
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.account.age.debt.method', 'BALANCE_FORWARD');


-- KFS constants
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.coa.code', '01');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.organization.code', 'KS');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.document.number.prefix', 'KSAJV');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.email.address', 'bursar@sigmauniversity.edu');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.postal.address', '1000 Campus ave UMD 20009');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.phone.number', '8882345678');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.campus.code', '01');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.department.name', 'Bursar');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.balance.type.code', 'TR');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.document.type.code', 'JV');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.object.type.code', '');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.origination.code', 'KS');
insert into KSSA_CONFIG (NAME, VALUE) values ('kfs.transaction.gl.entry.description', 'KSA General Ledger Transaction');

-- KSA Transaction settings
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.transaction.recognition.year', '2014');

-- IRS 1098T report settings
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.name', 'Sigma University');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.address1', '2305 S Colorado Blvd');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.address2', '');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.address3', '');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.city', 'Denver');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.state', 'CO');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.country', 'US');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.zip', '80222');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.fein', '55-5555555');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.filer.phone', '703-555-5555');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.reporting.method.change', 'false');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.tag.amount.billed', 'Billed1098');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.tag.insurance.refund', 'InsRef1098');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.tag.grants', 'Scholarship1098');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.us.ssn.tax.type', 'SSN');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.1098.us.ssn.display.digits', '4');

-- IRS 8300 report settings
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.name', 'Sigma University');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.address1', '2305 S Colorado Blvd');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.address2', '');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.address3', '');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.city', 'Denver');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.state', 'CO');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.country', 'US');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.zip', '80222');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.filer.fein', '55-5555555');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.business.nature', 'Soul trading');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.us.ssn.tax.type', 'SSN');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.8300.default.type', 'PERSONAL_SERVICE');

-- Refund constants
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.refund.ach.bank.type', 'ACH');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.refund.source.type', 'cash');
insert into KSSA_CONFIG (NAME, VALUE) values ('ksa.refund.method', 'RefundMethod1');

-- BRM (Drools) rule types
insert into KSSA_RULE_TYPE (ID, NAME, DESCRIPTION) values (1, 'DSL', 'Drools DSL');
insert into KSSA_RULE_TYPE (ID, NAME, DESCRIPTION) values (2, 'DRL', 'Drools Rule Language');
insert into KSSA_RULE_TYPE (ID, NAME, DESCRIPTION) values (3, 'DSLR', 'Drools DSL Rule');
insert into KSSA_RULE_TYPE (ID, NAME, DESCRIPTION) values (4, 'XDRL', 'Drools XML Rule Language');

-- Allowable GL account values --
insert into KSSA_ALLOWABLE_GL_ACCOUNT (ID, PATTERN) values (1, '.*');




--- INSERTING RULE SETS ---
set sqlblanklines on
set sqlterminator '!'

insert into KSSA_RULE (ID, NAME, RULE_TYPE_ID_FK, PRIORITY, HEADER, LHS, RHS) values
(99, 'Payment Application Rule', 3, 0, null, '(Context is initialized)',
'
Initialize list of GL transactions as "glTransactions"
Initialize list of GL transactions as "glTransactionsForRemovedAllocations"

Get list of transactions from "01/01/2011" to "12/31/2013", store result in "transactions"

Remove allocations from "transactions", add result to "glTransactionsForRemovedAllocations"

Allocate reversals for "transactions"  , add result to "glTransactions"

Get payments from "transactions", store result in "allPayments"
Get charges from "transactions", store result in "allCharges"
Sort "allCharges" by effective date in ascending order

Get payments from "allPayments" for 2011 year, store result in "payments2011"
Get payments from "allPayments" for 2012 year, store result in "payments2012"
Get payments from "allPayments" for 2013 year, store result in "payments2013"

Get charges from "allCharges" for 2011 year, store result in "charges2011"
Sort "charges2011" by priority in descending order

Get charges from "allCharges" for 2012 year    , store result in "charges2012"
Sort "charges2012" by priority in descending order

Get charges from "allCharges" for 2013 year    , store result in "charges2013"
Sort "charges2013" by priority in descending order

Get payments with tag "FinAid" from "allPayments" for 2011 year, store result in "finaidPayments2011"
Sort "finaidPayments2011" by effective date in ascending order
Sort "finaidPayments2011" by priority in descending order
Get payments with tag "FinAid" from "allPayments" for 2012 year, store result in "finaidPayments2012"
Sort "finaidPayments2012" by effective date in ascending order
Sort "finaidPayments2012" by priority in descending order
Get payments with tag "FinAid" from "allPayments" for 2013 year, store result in "finaidPayments2013"
Sort "finaidPayments2013" by effective date in ascending order
Sort "finaidPayments2013" by priority in descending order

Apply payments for "finaidPayments2011, charges2011", add result          to "glTransactions"
Apply payments for "finaidPayments2012, charges2012", add result to "glTransactions"
Apply payments for "finaidPayments2013, charges2013", add result to "glTransactions"

Apply payments with maximum amount $200 for "finaidPayments2012, allCharges", add result to "glTransactions"
Apply payments with maximum amount $200 for "finaidPayments2011,allCharges", add result to "glTransactions"
Apply payments with maximum amount $200 for "finaidPayments2013,allCharges", add result to "glTransactions"

Remove "finaidPayments2011, finaidPayments2012, finaidPayments2013" from "transactions"

Calculate matrix scores for "transactions"
Sort "transactions" by matrix score in ascending order

Apply payments for "transactions", add result to "glTransactions"

Summarize GL transactions "glTransactions"

Set global variable "resultList" to "glTransactions"

')!

insert into KSSA_RULE_SET (ID, NAME, RULE_TYPE_ID_FK, HEADER) values (99, 'Payment Application', 3,
'
import java.util.*;
import java.math.*;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.rule.*;
import com.sigmasys.kuali.ksa.service.brm.*;
import com.sigmasys.kuali.ksa.util.*;

expander ksa.dsl

global List resultList;

')!

insert into KSSA_RULE_SET_RULE ( RULE_SET_ID_FK, RULE_ID_FK ) values (99, 99)!

set sqlterminator ';'








