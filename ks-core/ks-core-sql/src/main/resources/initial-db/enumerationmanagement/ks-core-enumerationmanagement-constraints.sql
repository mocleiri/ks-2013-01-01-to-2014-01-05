

ALTER TABLE KSEM_CTX_JN_ENUM_VAL_T
    ADD CONSTRAINT KSEM_CTX_JN_ENUM_VAL_T_FK1 FOREIGN KEY (CTX_ID)
    REFERENCES KSEM_CTX_T (ID)
/

ALTER TABLE KSEM_CTX_JN_ENUM_VAL_T
    ADD CONSTRAINT KSEM_CTX_JN_ENUM_VAL_T_FK2 FOREIGN KEY (ENUM_VAL_ID)
    REFERENCES KSEM_ENUM_VAL_T (ID)
/




ALTER TABLE KSEM_ENUM_VAL_T
    ADD CONSTRAINT KSEM_ENUM_VAL_T_FK1 FOREIGN KEY (ENUM_KEY)
    REFERENCES KSEM_ENUM_T (ENUM_KEY)
/