
-- Creating constraints

alter table KSSA_ACNT add constraint FKB8F79251D358FA52 foreign key (ORG_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_ACNT add constraint FKB8F79251AC72F7E6 foreign key (ACNT_STATUS_TYPE_ID_FK) references KSSA_ACNT_STATUS_TYPE;
alter table KSSA_ACNT add constraint FKB8F7925156D383B8 foreign key (LATE_PERIOD_ID_FK) references KSSA_LATE_PERIOD;
alter table KSSA_ACNT_AUTHZ add constraint FK943314446726D312 foreign key (DEPENDENT_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_AUTHZ add constraint FK943314444B1F545F foreign key (AUTHZ_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_ELECTRONIC_CONTACT add constraint FKEC0321EB98518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_ELECTRONIC_CONTACT add constraint FKEC0321EBE5947A1E foreign key (ELECTRONIC_CONTACT_ID_FK) references KSSA_ELECTRONIC_CONTACT;
alter table KSSA_ACNT_PERSON_NAME add constraint FK7343E8477FD92EAC foreign key (PERSON_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_ACNT_PERSON_NAME add constraint FK7343E84798518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_POSTAL_ADDRESS add constraint FK4990940E98518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_POSTAL_ADDRESS add constraint FK4990940EF6AF9F26 foreign key (POSTAL_ADDRESS_ID_FK) references KSSA_POSTAL_ADDRESS;
alter table KSSA_ACNT_PROTECTED_INFO add constraint FKEF75726D2C28B62A foreign key (BANK_TYPE_ID_FK) references KSSA_BANK_TYPE;
alter table KSSA_ACNT_PROTECTED_INFO add constraint FKEF75726D73E6C8ED foreign key (ID_TYPE_ID_FK) references KSSA_ID_TYPE;
alter table KSSA_ACNT_PROTECTED_INFO add constraint FKEF75726DACFC7690 foreign key (TAX_TYPE_ID_FK) references KSSA_TAX_TYPE;
alter table KSSA_ALLOCATION add constraint FKC2912B0998518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ALLOCATION add constraint FKC2912B09ED7E538 foreign key (TRN_ID_2_FK) references KSSA_TRANSACTION;
alter table KSSA_ALLOCATION add constraint FKC2912B09ED770D9 foreign key (TRN_ID_1_FK) references KSSA_TRANSACTION;
alter table KSSA_BATCH_RECEIPT add constraint FK6961BF2A4861130D foreign key (INCOMING_XML_ID_FK) references KSSA_XML;
alter table KSSA_BATCH_RECEIPT add constraint FK6961BF2A98518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BATCH_RECEIPT add constraint FK6961BF2A8016ED3 foreign key (OUTGOING_XML_ID_FK) references KSSA_XML;
alter table KSSA_BILL_AUTHORITY add constraint FK2239C2947FD92EAC foreign key (PERSON_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_BILL_AUTHORITY add constraint FK2239C29498518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BILL_AUTHORITY add constraint FK2239C294F6AF9F26 foreign key (POSTAL_ADDRESS_ID_FK) references KSSA_POSTAL_ADDRESS;
alter table KSSA_BILL_AUTHORITY add constraint FK2239C294E5947A1E foreign key (ELECTRONIC_CONTACT_ID_FK) references KSSA_ELECTRONIC_CONTACT;
alter table KSSA_BILL_RECEIVER add constraint FKEF187C5E8752DE foreign key (OWNER_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BILL_RECEIVER add constraint FKEF187C5EAAE1BE22 foreign key (RECEIVER_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_CASH_LIMIT_EVENT add constraint FK6B695933F13B97E6 foreign key (XML_ID_FK) references KSSA_XML;
alter table KSSA_CASH_LIMIT_EVENT_TRANS add constraint FKB402C47C321DFEA1 foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_CASH_LIMIT_EVENT_TRANS add constraint FKB402C47CE0CEA4F3 foreign key (CASH_LIMIT_EVENT_ID_FK) references KSSA_CASH_LIMIT_EVENT;
alter table KSSA_CASH_LIMIT_PARAMETER add constraint FKEA9B9DC247AB5D71 foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_COLLECTION_ACNT add constraint FKF9BE25E098518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_COLLECTION_ACNT add constraint FKF9BE25E0CAA80A89 foreign key (AGENCY_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_CREDIT_PERMISSION add constraint FK1F74048CBC57B259 foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_EXTERNAL_STATEMENT add constraint FK818A3B0498518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_FLAG_TYPE add constraint FKC2EF34E4DC4F9C14 foreign key (ACCESS_LEVEL_ID_FK) references KSSA_ACCESS_LEVEL;
alter table KSSA_FM_MANIFEST add constraint FK496D0D9E32EC13CF foreign key (FM_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_MANIFEST add constraint FK496D0D9E233F505D foreign key (LINKED_MANIFEST_ID_FK) references KSSA_FM_MANIFEST;
alter table KSSA_FM_MANIFEST add constraint FK496D0D9EF7D721E7 foreign key (ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_FM_MANIFEST_KEY_PAIR add constraint FKD4F0165BD4D06A63 foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_FM_MANIFEST_KEY_PAIR add constraint FKD4F0165B87F1F7EF foreign key (FM_MANIFEST_ID_FK) references KSSA_FM_MANIFEST;
alter table KSSA_FM_MANIFEST_TAG add constraint FK8AFD815987F1F7EF foreign key (FM_MANIFEST_ID_FK) references KSSA_FM_MANIFEST;
alter table KSSA_FM_MANIFEST_TAG add constraint FK8AFD815947AB5D71 foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_FM_SESSION add constraint FKA9FAF52798518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_FM_SESSION add constraint FKA9FAF5276588BC3B foreign key (PREV_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SESSION add constraint FKA9FAF527CDE154FB foreign key (NEXT_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SESSION_KEY_PAIR add constraint FKC36398F2D4D06A63 foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_FM_SESSION_KEY_PAIR add constraint FKC36398F232EC13CF foreign key (FM_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SIGNUP add constraint FK7109644732EC13CF foreign key (FM_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SIGNUP_KEY_PAIR add constraint FK6D502DD2FCF18C1 foreign key (FM_SIGNUP_ID_FK) references KSSA_FM_SIGNUP;
alter table KSSA_FM_SIGNUP_KEY_PAIR add constraint FK6D502DD2D4D06A63 foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_FM_SIGNUP_RATE add constraint FKEFBE2DD8FCF18C1 foreign key (FM_SIGNUP_ID_FK) references KSSA_FM_SIGNUP;
alter table KSSA_FM_SIGNUP_RATE_AMOUNT add constraint FKCE20509FB935A3A0 foreign key (FM_SIGNUP_RATE_ID_FK) references KSSA_FM_SIGNUP_RATE;
alter table KSSA_GL_BATCH_BASELINE add constraint FK3C33E61BFA70171C foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;
alter table KSSA_GL_BREAKDOWN add constraint FKF48BE710AE27AC92 foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_GL_BREAKDOWN add constraint FKF48BE710FA70171C foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;
alter table KSSA_GL_BREAKDOWN_OVERRIDE add constraint FKD521481BD61AFDF9 foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_GL_TRANSACTION add constraint FK1009500DAF219853 foreign key (GL_RECOGNITION_PERIOD_ID_FK) references KSSA_GL_RECOGNITION_PERIOD;
alter table KSSA_GL_TRANSACTION add constraint FK1009500D103CB71E foreign key (GL_TRANSMISSION_ID_FK) references KSSA_GL_TRANSMISSION;
alter table KSSA_GL_TRANSMISSION add constraint FK761EEA75AF219853 foreign key (GL_RECOGNITION_PERIOD_ID_FK) references KSSA_GL_RECOGNITION_PERIOD;
alter table KSSA_GL_TRANS_TRANSACTION add constraint FK1A29A596D61AFDF9 foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_GL_TRANS_TRANSACTION add constraint FK1A29A596C852663A foreign key (GL_TRANSACTION_ID_FK) references KSSA_GL_TRANSACTION;
alter table KSSA_INFORMATION add constraint FKD2A2E003DBB2002A foreign key (FLAG_TYPE_ID_FK) references KSSA_FLAG_TYPE;
alter table KSSA_INFORMATION add constraint FKD2A2E00316BC312E foreign key (NEXT_ID) references KSSA_INFORMATION;
alter table KSSA_INFORMATION add constraint FKD2A2E00395ACD1EE foreign key (PREV_ID) references KSSA_INFORMATION;
alter table KSSA_INFORMATION add constraint FKD2A2E00398518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_INFORMATION add constraint FKD2A2E003DC4F9C14 foreign key (ACCESS_LEVEL_ID_FK) references KSSA_ACCESS_LEVEL;
alter table KSSA_INFORMATION add constraint FKD2A2E003FE6E074B foreign key (TRN_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_IRS_1098T add constraint FKCD8EF71887CB7AAA foreign key (STUDENT_POSTAL_ADDRESS_ID_FK) references KSSA_POSTAL_ADDRESS;
alter table KSSA_IRS_1098T add constraint FKCD8EF71898518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_IRS_1098T add constraint FKCD8EF718F13B97E6 foreign key (XML_ID_FK) references KSSA_XML;
alter table KSSA_NAME add constraint FKB8FD73747FD92EAC foreign key (PERSON_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_PB_ALLOWABLE_CHARGE add constraint FKA75DC914CAFA67ED foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_DATE add constraint FKEADDE852CAFA67ED foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_DATE add constraint FKEADDE852F7D721E7 foreign key (ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_PB_PLAN add constraint FKEAE383CD402524CA foreign key (TRANSFER_TYPE_ID_FK) references KSSA_TRANSFER_TYPE;
alter table KSSA_PB_QUEUE add constraint FK719F34CDCAFA67ED foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_QUEUE add constraint FK719F34CD3AB9A295 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_PB_QUEUE add constraint FK719F34CDDC6A8FE2 foreign key (PB_TRANSFER_DETAIL_ID_FK) references KSSA_PB_TRANSFER_DETAIL;
alter table KSSA_PB_SCHEDULE add constraint FK69D1913BDC6A8FE2 foreign key (PB_TRANSFER_DETAIL_ID_FK) references KSSA_PB_TRANSFER_DETAIL;
alter table KSSA_PB_TRANSACTION add constraint FKAFB7259A5E6B0A9F foreign key (CHARGE_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_PB_TRANSACTION add constraint FKAFB7259ADC6A8FE2 foreign key (PB_TRANSFER_DETAIL_ID_FK) references KSSA_PB_TRANSFER_DETAIL;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FKA4F8A401CAFA67ED foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FKA4F8A4013AB9A295 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FKA4F8A4017B6240D0 foreign key (VAR_FEE_CHARGE_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FKA4F8A401FD2576BE foreign key (FLAT_FEE_CHARGE_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_RATE add constraint FKB8FF45C912563F5 foreign key (DEFAULT_RATE_AMOUNT_ID_FK) references KSSA_RATE_AMOUNT;
alter table KSSA_RATE add constraint FKB8FF45C9D3B40CF2 foreign key (RATE_CATALOG_ATP_ID_FK, RATE_CATALOG_CODE_FK) references KSSA_RATE_CATALOG_ATP;
alter table KSSA_RATE add constraint FKB8FF45C913EF60F7 foreign key (RATE_TYPE_ID_FK) references KSSA_RATE_TYPE;
alter table KSSA_RATE_AMOUNT add constraint FK4FC2978EB1D17704 foreign key (RATE_ID_FK) references KSSA_RATE;
alter table KSSA_RATE_CATALOG add constraint FKFE1FFF8313EF60F7 foreign key (RATE_TYPE_ID_FK) references KSSA_RATE_TYPE;
alter table KSSA_RATE_CATALOG_ATP add constraint FKE76AB3C1BA6CDBA3 foreign key (RATE_CATALOG_ID_FK) references KSSA_RATE_CATALOG;
alter table KSSA_RATE_CATALOG_KEY_PAIR add constraint FKF1AE7616BA6CDBA3 foreign key (RATE_CATALOG_ID_FK) references KSSA_RATE_CATALOG;
alter table KSSA_RATE_CATALOG_KEY_PAIR add constraint FKF1AE7616D4D06A63 foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_RATE_KEY_PAIR add constraint FKE2B2DE90C9E82FA2 foreign key (RATE_KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_RATE_KEY_PAIR add constraint FKE2B2DE90B1D17704 foreign key (RATE_ID_FK) references KSSA_RATE;
alter table KSSA_REFUND add constraint FK76773E217FC9D8F2 foreign key (REFUND_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_REFUND add constraint FK76773E21D61AFDF9 foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_REFUND add constraint FK76773E21A0B2BA5 foreign key (AUTHORIZED_BY_ID_FK) references KSSA_ACNT;
alter table KSSA_REFUND add constraint FK76773E21C8C8E732 foreign key (REQUESTED_BY_ID_FK) references KSSA_ACNT;
alter table KSSA_REFUND add constraint FK76773E21FF0A3794 foreign key (REFUND_MANIFEST_ID_FK) references KSSA_REFUND_MANIFEST;
alter table KSSA_REFUND add constraint FK76773E21BC852B6A foreign key (REFUND_TYPE_ID_FK) references KSSA_REFUND_TYPE;
alter table KSSA_REFUND_MANIFEST add constraint FK621A668DA0AC5650 foreign key (REFUND_ACCOUNT_ID_FK) references KSSA_ACNT;
alter table KSSA_REFUND_MANIFEST add constraint FK621A668D7FC9D8F2 foreign key (REFUND_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_RULE add constraint FKB8FF8FE593E85A22 foreign key (RULE_TYPE_ID_FK) references KSSA_RULE_TYPE;
alter table KSSA_RULE_SET add constraint FKD6784E893E85A22 foreign key (RULE_TYPE_ID_FK) references KSSA_RULE_TYPE;
alter table KSSA_RULE_SET_RULE add constraint FKBF093F391A9A467 foreign key (RULE_ID_FK) references KSSA_RULE;
alter table KSSA_RULE_SET_RULE add constraint FKBF093F37FE8AA6A foreign key (RULE_SET_ID_FK) references KSSA_RULE_SET;
alter table KSSA_TP_ALLOWABLE_CHARGE add constraint FK9E01ADCA5AFB9A03 foreign key (TP_PLAN_ID_FK) references KSSA_TP_PLAN;
alter table KSSA_TP_PLAN add constraint FKD66049838D8E753 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TP_PLAN add constraint FKD6604983402524CA foreign key (TRANSFER_TYPE_ID_FK) references KSSA_TRANSFER_TYPE;
alter table KSSA_TP_PLAN_MEMBER add constraint FKC46B08D65AFB9A03 foreign key (TP_PLAN_ID_FK) references KSSA_TP_PLAN;
alter table KSSA_TP_PLAN_MEMBER add constraint FKC46B08D63AB9A295 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TP_TRANSFER_DETAIL add constraint FK208A508B5AFB9A03 foreign key (TP_PLAN_ID_FK) references KSSA_TP_PLAN;
alter table KSSA_TP_TRANSFER_DETAIL add constraint FK208A508B3AB9A295 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TRANSACTION add constraint FKDCED3DB598518DD2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TRANSACTION add constraint FKDCED3DB5FB9EC59 foreign key (CURRENCY_ID_FK) references KSSA_CURRENCY;
alter table KSSA_TRANSACTION add constraint FKDCED3DB590ED3EED foreign key (DOCUMENT_ID_FK) references KSSA_DOCUMENT;
alter table KSSA_TRANSACTION add constraint FKDCED3DB5CE008744 foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_TRANSACTION add constraint FKDCED3DB5F7D721E7 foreign key (ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_TRANSACTION add constraint FKDCED3DB5FA70171C foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;
alter table KSSA_TRANSACTION_TAG add constraint FK429CDF0D61AFDF9 foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TAG add constraint FK429CDF047AB5D71 foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK15F83735402524CA foreign key (TRANSFER_TYPE_ID_FK) references KSSA_TRANSFER_TYPE;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK15F8373518FC4427 foreign key (SOURCE_TRN_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK15F83735E54C0A9F foreign key (OFFSET_TRN_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK15F83735E6719DEE foreign key (DEST_TRN_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK15F83735A955E3E3 foreign key (DEST_RECIPROCAL_TRN_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK15F837354455500A foreign key (SOURCE_RECIPROCAL_TRN_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TYPE add constraint FK81104B8496077E1 foreign key (DEF_ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_TRANSACTION_TYPE_TAG add constraint FKA1635C3F47AB5D71 foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_TRANSACTION_TYPE_TAG add constraint FKA1635C3FCE008744 foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_TRANSFER_TYPE add constraint FKC595C845FA70171C foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;

