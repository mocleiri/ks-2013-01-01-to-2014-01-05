

ALTER TABLE
    KSLU_CLU_LO_RELTN ADD CONSTRAINT KSLU_CLU_LO_RELTN_FK2 FOREIGN KEY (TYPE) REFERENCES
    KSLU_CLU_LO_RELTN_TYPE (TYPE_KEY)
/

CREATE
    INDEX "KSLU_CLU_LO_RELTN_I2" ON "KSLU_CLU_LO_RELTN"
    ("TYPE")
/