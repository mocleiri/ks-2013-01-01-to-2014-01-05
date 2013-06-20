

ALTER TABLE KSEN_LRR
    ADD CONSTRAINT FK1BE15Q7B1D2EA121 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSEN_RICH_TEXT_T (ID)
/

ALTER TABLE KSEN_LRR
    ADD CONSTRAINT FK1BE15Q7B1D2EF131 FOREIGN KEY (TYPE_ID)
    REFERENCES KSEN_LRR_TYPE (TYPE_KEY)
/

ALTER TABLE KSEN_LRR
    ADD CONSTRAINT FK1BE2597A61E975Q1 FOREIGN KEY (STATE_ID)
    REFERENCES KSEN_COMM_STATE (ID)
/


ALTER TABLE KSEN_LRR_ATTR
    ADD CONSTRAINT FKSF4BE635DC3CD510 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_LRR (ID)
/
