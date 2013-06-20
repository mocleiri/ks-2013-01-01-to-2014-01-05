
ALTER TABLE KSLU_CLU
    ADD CONSTRAINT KSLU_CLU_FK1 FOREIGN KEY (PRI_INSTR_ID)
    REFERENCES KSLU_CLU_INSTR (ID)
/

ALTER TABLE KSLU_CLU
    ADD CONSTRAINT KSLU_CLU_FK2 FOREIGN KEY (LUTYPE_ID)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/

ALTER TABLE KSLU_CLU
    ADD CONSTRAINT KSLU_CLU_FK3 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSLU_RICH_TEXT_T (ID)
/

ALTER TABLE KSLU_CLU
    ADD CONSTRAINT KSLU_CLU_FK4 FOREIGN KEY (FEE_ID)
    REFERENCES KSLU_CLU_FEE (ID)
/

ALTER TABLE KSLU_CLU
    ADD CONSTRAINT KSLU_CLU_FK5 FOREIGN KEY (OFFIC_CLU_ID)
    REFERENCES KSLU_CLU_IDENT (ID)
/

ALTER TABLE KSLU_CLU
    ADD CONSTRAINT KSLU_CLU_FK6 FOREIGN KEY (ACCT_ID)
    REFERENCES KSLU_CLU_ACCT (ID)
/


ALTER TABLE KSLU_CLUCLU_RELTN
    ADD CONSTRAINT KSLU_CLUCLU_RELTN_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/

ALTER TABLE KSLU_CLUCLU_RELTN
    ADD CONSTRAINT KSLU_CLUCLU_RELTN_FK2 FOREIGN KEY (RELATED_CLU_ID)
    REFERENCES KSLU_CLU (ID)
/

ALTER TABLE KSLU_CLUCLU_RELTN
    ADD CONSTRAINT KSLU_CLUCLU_RELTN_FK3 FOREIGN KEY (LU_RELTN_TYPE_ID)
    REFERENCES KSLU_LULU_RELTN_TYPE (ID)
/


ALTER TABLE KSLU_CLUCLU_RELTN_ATTR
    ADD CONSTRAINT KSLU_CLUCLU_RELTN_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLUCLU_RELTN (ID)
/


ALTER TABLE KSLU_CLURES_JN_RESOPT
    ADD CONSTRAINT KSLU_CLURES_JN_RESOPT_FK1 FOREIGN KEY (CLU_RES_ID)
    REFERENCES KSLU_CLU_RSLT (ID)
/

ALTER TABLE KSLU_CLURES_JN_RESOPT
    ADD CONSTRAINT KSLU_CLURES_JN_RESOPT_FK2 FOREIGN KEY (RES_OPT_ID)
    REFERENCES KSLU_RSLT_OPT (ID)
/



ALTER TABLE KSLU_CLU_ACCRED_ATTR
    ADD CONSTRAINT KSLU_CLU_ACCRED_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_ACCRED (ID)
/



ALTER TABLE KSLU_CLU_ACCT_ATTR
    ADD CONSTRAINT KSLU_CLU_ACCT_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_ACCT (ID)
/


ALTER TABLE KSLU_CLU_ACCT_JN_AFFIL_ORG
    ADD CONSTRAINT KSLU_CLU_ACCT_JN_AFFIL_ORG_FK1 FOREIGN KEY (AFFIL_ORG_ID)
    REFERENCES KSLU_CLU_AFFIL_ORG (ID)
/

ALTER TABLE KSLU_CLU_ACCT_JN_AFFIL_ORG
    ADD CONSTRAINT KSLU_CLU_ACCT_JN_AFFIL_ORG_FK2 FOREIGN KEY (CLU_ACCT_ID)
    REFERENCES KSLU_CLU_ACCT (ID)
/


ALTER TABLE KSLU_CLU_ADMIN_ORG
    ADD CONSTRAINT KSLU_CLU_ADMIN_ORG_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_CLU_ADMIN_ORG_ATTR
    ADD CONSTRAINT KSLU_CLU_ADMIN_ORG_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_ADMIN_ORG (ID)
/



ALTER TABLE KSLU_CLU_ATP_TYPE_KEY
    ADD CONSTRAINT KSLU_CLU_ATP_TYPE_KEY_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_CLU_ATTR
    ADD CONSTRAINT KSLU_CLU_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU (ID)
/



ALTER TABLE KSLU_CLU_FEE
    ADD CONSTRAINT KSLU_CLU_FEE_FK1 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSLU_RICH_TEXT_T (ID)
/


ALTER TABLE KSLU_CLU_FEEREC_JN_AFFIL_ORG
    ADD CONSTRAINT KSLU_CLU_FEEREC_JN_AFF_ORG_FK1 FOREIGN KEY (AFFIL_ORG_ID)
    REFERENCES KSLU_CLU_AFFIL_ORG (ID)
/

ALTER TABLE KSLU_CLU_FEEREC_JN_AFFIL_ORG
    ADD CONSTRAINT KSLU_CLU_FEEREC_JN_AFF_ORG_FK2 FOREIGN KEY (CLU_FEE_REC_ID)
    REFERENCES KSLU_CLU_FEE_REC (ID)
/


ALTER TABLE KSLU_CLU_FEE_AMOUNT
    ADD CONSTRAINT KSLU_CLU_FEE_AMOUNT_FK1 FOREIGN KEY (CLUE_FEE_REC_ID)
    REFERENCES KSLU_CLU_FEE_REC (ID)
/


ALTER TABLE KSLU_CLU_FEE_ATTR
    ADD CONSTRAINT KSLU_CLU_FEE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_FEE (ID)
/


ALTER TABLE KSLU_CLU_FEE_JN_CLU_FEE_REC
    ADD CONSTRAINT KSLU_CLUFEE_JN_CLUFEE_REC_FK1 FOREIGN KEY (CLU_FEE_REC_ID)
    REFERENCES KSLU_CLU_FEE_REC (ID)
/

ALTER TABLE KSLU_CLU_FEE_JN_CLU_FEE_REC
    ADD CONSTRAINT KSLU_CLUFEE_JN_CLUFEE_REC_FK2 FOREIGN KEY (CLU_FEE_ID)
    REFERENCES KSLU_CLU_FEE (ID)
/


ALTER TABLE KSLU_CLU_FEE_REC
    ADD CONSTRAINT KSLU_CLU_FEE_REC_FK1 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSLU_RICH_TEXT_T (ID)
/


ALTER TABLE KSLU_CLU_FEE_REC_ATTR
    ADD CONSTRAINT KSLU_CLU_FEE_REC_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_FEE_REC (ID)
/




ALTER TABLE KSLU_CLU_INSTR_ATTR
    ADD CONSTRAINT KSLU_CLU_INSTR_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_INSTR (ID)
/


ALTER TABLE KSLU_CLU_JN_ACCRED
    ADD CONSTRAINT KSLU_CLU_JN_ACCRED_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/

ALTER TABLE KSLU_CLU_JN_ACCRED
    ADD CONSTRAINT KSLU_CLU_JN_ACCRED_FK2 FOREIGN KEY (CLU_ACCRED_ID)
    REFERENCES KSLU_CLU_ACCRED (ID)
/


ALTER TABLE KSLU_CLU_JN_CAMP_LOC
    ADD CONSTRAINT KSLU_CLU_JN_CAMP_LOC_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_CLU_JN_CLU_IDENT
    ADD CONSTRAINT KSLU_CLU_JN_CLU_IDENT_FK1 FOREIGN KEY (ALT_CLU_ID)
    REFERENCES KSLU_CLU_IDENT (ID)
/

ALTER TABLE KSLU_CLU_JN_CLU_IDENT
    ADD CONSTRAINT KSLU_CLU_JN_CLU_IDENT_FK2 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_CLU_JN_CLU_INSTR
    ADD CONSTRAINT KSLU_CLU_JN_CLU_INSTR_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/

ALTER TABLE KSLU_CLU_JN_CLU_INSTR
    ADD CONSTRAINT KSLU_CLU_JN_CLU_INSTR_FK2 FOREIGN KEY (CLU_INSTR_ID)
    REFERENCES KSLU_CLU_INSTR (ID)
/


ALTER TABLE KSLU_CLU_JN_SUBJ_ORG
    ADD CONSTRAINT KSLU_CLU_JN_SUBJ_ORG_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_CLU_LO_ALOW_RELTN_TYPE
    ADD CONSTRAINT KSLU_CLU_LO_ALOW_REL_TYPE_FK1 FOREIGN KEY (LU_TYPE_ID)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/

ALTER TABLE KSLU_CLU_LO_ALOW_RELTN_TYPE
    ADD CONSTRAINT KSLU_CLU_LO_ALOW_REL_TYPE_FK2 FOREIGN KEY (CLULO_RELTN_TYPE_ID)
    REFERENCES KSLU_CLU_LO_RELTN_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_CLU_LO_RELTN
    ADD CONSTRAINT KSLU_CLU_LO_RELTN_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_CLU_LO_RELTN_ATTR
    ADD CONSTRAINT KSLU_CLU_LO_RELTN_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_LO_RELTN (ID)
/



ALTER TABLE KSLU_CLU_LO_RELTN_TYPE_ATTR
    ADD CONSTRAINT KSLU_CLU_LO_REL_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_LO_RELTN_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_CLU_PUBL
    ADD CONSTRAINT KSLU_CLU_PUBL_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/

ALTER TABLE KSLU_CLU_PUBL
    ADD CONSTRAINT KSLU_CLU_PUBL_FK2 FOREIGN KEY (CLU_PUB_TYPE_ID)
    REFERENCES KSLU_CLU_PUBL_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_CLU_PUBL_ATTR
    ADD CONSTRAINT KSLU_CLU_PUBL_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_PUBL (ID)
/




ALTER TABLE KSLU_CLU_PUBL_TYPE_ATTR
    ADD CONSTRAINT KSLU_CLU_PUBL_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_PUBL_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_CLU_PUBL_VARI
    ADD CONSTRAINT KSLU_CLU_PUBL_VARI_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_PUBL (ID)
/



ALTER TABLE KSLU_CLU_PUB_TYPE_ATTR
    ADD CONSTRAINT KSLU_CLU_PUB_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_PUB_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_CLU_RESULT_TYPE_ATTR
    ADD CONSTRAINT KSLU_CLU_RESULT_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_RSLT_TYP (TYPE_KEY)
/


ALTER TABLE KSLU_CLU_RSLT
    ADD CONSTRAINT KSLU_CLU_RSLT_FK1 FOREIGN KEY (TYPE_KEY_ID)
    REFERENCES KSLU_CLU_RSLT_TYP (TYPE_KEY)
/

ALTER TABLE KSLU_CLU_RSLT
    ADD CONSTRAINT KSLU_CLU_RSLT_FK2 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/

ALTER TABLE KSLU_CLU_RSLT
    ADD CONSTRAINT KSLU_CLU_RSLT_FK3 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSLU_RICH_TEXT_T (ID)
/


ALTER TABLE KSLU_CLU_RSLT_LU_ALOW_TYPE
    ADD CONSTRAINT KSLU_CLU_RSLT_LU_ALOW_TYPE_FK1 FOREIGN KEY (CLU_RSLT_TYPE_ID)
    REFERENCES KSLU_CLU_RSLT_TYP (TYPE_KEY)
/

ALTER TABLE KSLU_CLU_RSLT_LU_ALOW_TYPE
    ADD CONSTRAINT KSLU_CLU_RSLT_LU_ALOW_TYPE_FK2 FOREIGN KEY (LU_TYPE_ID)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/



ALTER TABLE KSLU_CLU_SET
    ADD CONSTRAINT KSLU_CLU_SET_FK1 FOREIGN KEY (MEM_QUERY_ID)
    REFERENCES KSLU_MEMSHIP (ID)
/

ALTER TABLE KSLU_CLU_SET
    ADD CONSTRAINT KSLU_CLU_SET_FK2 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSLU_RICH_TEXT_T (ID)
/


ALTER TABLE KSLU_CLU_SET_ATTR
    ADD CONSTRAINT KSLU_CLU_SET_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_SET (ID)
/


ALTER TABLE KSLU_CLU_SET_JN_CLU
    ADD CONSTRAINT KSLU_CLU_SET_JN_CLU_FK1 FOREIGN KEY (CLU_SET_ID)
    REFERENCES KSLU_CLU_SET (ID)
/

ALTER TABLE KSLU_CLU_SET_JN_CLU
    ADD CONSTRAINT KSLU_CLU_SET_JN_CLU_FK2 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_CLU_SET_JN_CLU_SET
    ADD CONSTRAINT KSLU_CLU_SET_JN_CLU_SET_FK1 FOREIGN KEY (CLU_SET_PARENT_ID)
    REFERENCES KSLU_CLU_SET (ID)
/

ALTER TABLE KSLU_CLU_SET_JN_CLU_SET
    ADD CONSTRAINT KSLU_CLU_SET_JN_CLU_SET_FK2 FOREIGN KEY (CLU_SET_CHILD_ID)
    REFERENCES KSLU_CLU_SET (ID)
/



ALTER TABLE KSLU_CLU_SET_TYPE_ATTR
    ADD CONSTRAINT KSLU_CLU_SET_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_CLU_SET_TYPE (TYPE_KEY)
/



ALTER TABLE KSLU_DLVMTHD_TYPE_ATTR
    ADD CONSTRAINT KSLU_DLVMTHD_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_DLVMTHD_TYPE (TYPE_KEY)
/



ALTER TABLE KSLU_INSTFRMT_TYPE_ATTR
    ADD CONSTRAINT KSLU_INSTFRMT_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_INSTFRMT_TYPE (TYPE_KEY)
/


--ALTER TABLE KSLU_LUI
--    ADD CONSTRAINT KSLU_LUI_FK1 FOREIGN KEY (CLU_ID)
--    REFERENCES KSLU_CLU (ID)
--/


--ALTER TABLE KSLU_LUILUI_RELTN
--    ADD CONSTRAINT KSLU_LUILUI_RELTN_FK1 FOREIGN KEY (RELATED_LUI_ID)
--    REFERENCES KSLU_LUI (ID)
--/

--ALTER TABLE KSLU_LUILUI_RELTN
--    ADD CONSTRAINT KSLU_LUILUI_RELTN_FK2 FOREIGN KEY (LULU_RELTN_TYPE_ID)
--    REFERENCES KSLU_LULU_RELTN_TYPE (ID)
--/

--ALTER TABLE KSLU_LUILUI_RELTN
--    ADD CONSTRAINT KSLU_LUILUI_RELTN_FK3 FOREIGN KEY (LUI_ID)
--    REFERENCES KSLU_LUI (ID)
--/


--ALTER TABLE KSLU_LUILUI_RELTN_ATTR
--    ADD CONSTRAINT KSLU_LUILUI_RELTN_ATTR_FK1 FOREIGN KEY (OWNER)
--    REFERENCES KSLU_LUILUI_RELTN (ID)
--/


--ALTER TABLE KSLU_LUI_ATTR
--    ADD CONSTRAINT KSLU_LUI_ATTR_FK1 FOREIGN KEY (OWNER)
--    REFERENCES KSLU_LUI (ID)
--/



ALTER TABLE KSLU_LULU_RELTN_TYPE_ATTR
    ADD CONSTRAINT KSLU_LULU_RELTN_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_LULU_RELTN_TYPE (ID)
/


ALTER TABLE KSLU_LULU_RELTN_TYPE_JN_LU_TYP
    ADD CONSTRAINT KSLU_LULU_RELTYP_JN_LUTYP_FK1 FOREIGN KEY (LULU_RELTN_TYPE_ID)
    REFERENCES KSLU_LULU_RELTN_TYPE (ID)
/

ALTER TABLE KSLU_LULU_RELTN_TYPE_JN_LU_TYP
    ADD CONSTRAINT KSLU_LULU_RELTYP_JN_LUTYP_FK2 FOREIGN KEY (LU_TYPE_ID)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/




ALTER TABLE KSLU_LU_CD_TYPE_ATTR
    ADD CONSTRAINT KSLU_LU_CD_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_LU_CD_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_LU_CODE
    ADD CONSTRAINT KSLU_LU_CODE_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/


ALTER TABLE KSLU_LU_CODE_ATTR
    ADD CONSTRAINT KSLU_LU_CODE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_LU_CODE (ID)
/


ALTER TABLE KSLU_LU_LU_ALOW_RELTN_TYPE
    ADD CONSTRAINT KSLU_LU_LU_ALOW_RELTN_TYPE_FK1 FOREIGN KEY (LU_REL_TYPE_ID)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/

ALTER TABLE KSLU_LU_LU_ALOW_RELTN_TYPE
    ADD CONSTRAINT KSLU_LU_LU_ALOW_RELTN_TYPE_FK2 FOREIGN KEY (LU_LU_RELTN_TYPE_ID)
    REFERENCES KSLU_LULU_RELTN_TYPE (ID)
/

ALTER TABLE KSLU_LU_LU_ALOW_RELTN_TYPE
    ADD CONSTRAINT KSLU_LU_LU_ALOW_RELTN_TYPE_FK3 FOREIGN KEY (LU_TYPE_ID)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/



ALTER TABLE KSLU_LU_PUBL_TYPE_ATTR
    ADD CONSTRAINT KSLU_LU_PUBL_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_LU_PUBL_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_LU_TYPE_ATTR
    ADD CONSTRAINT KSLU_LU_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/



ALTER TABLE KSLU_MEMSHIP_KSLU_SPARAM
    ADD CONSTRAINT KSLU_MEMSHIP_KSLU_SPARAM_FK1 FOREIGN KEY (KSLU_MEMSHIP_ID)
    REFERENCES KSLU_MEMSHIP (ID)
/

ALTER TABLE KSLU_MEMSHIP_KSLU_SPARAM
    ADD CONSTRAINT KSLU_MEMSHIP_KSLU_SPARAM_FK2 FOREIGN KEY (SEARCHPARAMETERS_ID)
    REFERENCES KSLU_SPARAM (ID)
/



ALTER TABLE KSLU_RSLTUSAGE_LU_ALOW_TYPE
    ADD CONSTRAINT KSLU_RSLTUSAGE_LU_ALOW_TYP_FK1 FOREIGN KEY (CLU_RSLT_USAGE_TYPE_ID)
    REFERENCES KSLU_RSLT_USG_TYPE (TYPE_KEY)
/

ALTER TABLE KSLU_RSLTUSAGE_LU_ALOW_TYPE
    ADD CONSTRAINT KSLU_RSLTUSAGE_LU_ALOW_TYP_FK2 FOREIGN KEY (LU_TYPE_ID)
    REFERENCES KSLU_LUTYPE (TYPE_KEY)
/


ALTER TABLE KSLU_RSLT_COMP_USG_ALOW_TYPE
    ADD CONSTRAINT KSLU_RSLTCOMP_USG_ALOW_TYP_FK1 FOREIGN KEY (RSLT_USG_TYPE_ID)
    REFERENCES KSLU_RSLT_USG_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_RSLT_OPT
    ADD CONSTRAINT KSLU_RSLT_OPT_FK1 FOREIGN KEY (RES_USAGE_ID)
    REFERENCES KSLU_RSLT_USG_TYPE (TYPE_KEY)
/

ALTER TABLE KSLU_RSLT_OPT
    ADD CONSTRAINT KSLU_RSLT_OPT_FK2 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSLU_RICH_TEXT_T (ID)
/



ALTER TABLE KSLU_RSLT_USG_TYPE_ATTR
    ADD CONSTRAINT KSLU_RSLT_USG_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSLU_RSLT_USG_TYPE (TYPE_KEY)
/


ALTER TABLE KSLU_RSRC
    ADD CONSTRAINT KSLU_RSRC_FK1 FOREIGN KEY (CLU_ID)
    REFERENCES KSLU_CLU (ID)
/



ALTER TABLE KSLU_SPARAM_KSLU_SPVALUE
    ADD CONSTRAINT KSLU_SPARAM_KSLU_SPVALUE_FK1 FOREIGN KEY (KSLU_SPARAM_ID)
    REFERENCES KSLU_SPARAM (ID)
/

ALTER TABLE KSLU_SPARAM_KSLU_SPVALUE
    ADD CONSTRAINT KSLU_SPARAM_KSLU_SPVALUE_FK2 FOREIGN KEY (VALUES_ID)
    REFERENCES KSLU_SPVALUE (ID)
/

