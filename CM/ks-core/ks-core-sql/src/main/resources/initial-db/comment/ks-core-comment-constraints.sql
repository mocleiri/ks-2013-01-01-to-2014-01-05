
ALTER TABLE KSCO_COMMENT
    ADD CONSTRAINT KSCO_COMMENT_FK1 FOREIGN KEY (TYPE)
    REFERENCES KSCO_COMMENT_TYPE (TYPE_KEY)
/

ALTER TABLE KSCO_COMMENT
    ADD CONSTRAINT KSCO_COMMENT_FK2 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSCO_RICH_TEXT_T (ID)
/

ALTER TABLE KSCO_COMMENT
    ADD CONSTRAINT KSCO_COMMENT_FK3 FOREIGN KEY (REFERENCE)
    REFERENCES KSCO_REFERENCE (ID)
/


ALTER TABLE KSCO_COMMENT_ATTR
    ADD CONSTRAINT KSCO_COMMENT_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSCO_COMMENT (ID)
/



ALTER TABLE KSCO_COMMENT_TYPE_ATTR
    ADD CONSTRAINT KSCO_COMMENT_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSCO_COMMENT_TYPE (TYPE_KEY)
/


ALTER TABLE KSCO_REFERENCE
    ADD CONSTRAINT KSCO_REFERENCE_FK1 FOREIGN KEY (REFERENCE_TYPE)
    REFERENCES KSCO_REFERENCE_TYPE (TYPE_KEY)
/



ALTER TABLE KSCO_REFERENCE_TYPE_ATTR
    ADD CONSTRAINT KSCO_REFERENCE_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSCO_REFERENCE_TYPE (TYPE_KEY)
/



ALTER TABLE KSCO_TAG
    ADD CONSTRAINT KSCO_TAG_FK1 FOREIGN KEY (REFERENCE)
    REFERENCES KSCO_REFERENCE (ID)
/

ALTER TABLE KSCO_TAG
    ADD CONSTRAINT KSCO_TAG_FK2 FOREIGN KEY (TYPE)
    REFERENCES KSCO_TAG_TYPE (TYPE_KEY)
/


ALTER TABLE KSCO_TAG_ATTR
    ADD CONSTRAINT KSCO_TAG_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSCO_TAG (ID)
/



ALTER TABLE KSCO_TAG_TYPE_ATTR
    ADD CONSTRAINT KSCO_TAG_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSCO_TAG_TYPE (TYPE_KEY)
/
