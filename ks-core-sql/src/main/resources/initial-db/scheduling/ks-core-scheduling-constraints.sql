

ALTER TABLE KSEN_SCHED_ATTR
    ADD CONSTRAINT KSEN_SCHED_ATTR_FK1 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_SCHED (ID)
/


ALTER TABLE KSEN_SCHED_CMP
    ADD CONSTRAINT KSEN_SCHED_CMP_FK1 FOREIGN KEY (SCHED_ID)
    REFERENCES KSEN_SCHED (ID)
/


ALTER TABLE KSEN_SCHED_CMP_TMSLOT
    ADD CONSTRAINT KSEN_SCHED_CMP_TMSLOT_FK2 FOREIGN KEY (TM_SLOT_ID)
    REFERENCES KSEN_SCHED_TMSLOT (ID)
/

ALTER TABLE KSEN_SCHED_CMP_TMSLOT
    ADD CONSTRAINT KSEN_SCHED_CMP_TMSLOT_KF1 FOREIGN KEY (SCHED_CMP_ID)
    REFERENCES KSEN_SCHED_CMP (ID)
/



ALTER TABLE KSEN_SCHED_RQST_ATTR
    ADD CONSTRAINT KSEN_SCHED_REQUEST_ATTR_FK1 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_SCHED_RQST (ID)
/


ALTER TABLE KSEN_SCHED_RQST_CMP
    ADD CONSTRAINT KSEN_SCHED_RQST_CMP_FK1 FOREIGN KEY (SCHED_RQST_ID)
    REFERENCES KSEN_SCHED_RQST (ID)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_BLDG
    ADD CONSTRAINT KSEN_SCHED_RQST_CMP_BLDG_FK1 FOREIGN KEY (CMP_ID)
    REFERENCES KSEN_SCHED_RQST_CMP (ID)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_CAMPUS
    ADD CONSTRAINT KSEN_SCHED_RQST_CMP_CAMPUS_FK1 FOREIGN KEY (CMP_ID)
    REFERENCES KSEN_SCHED_RQST_CMP (ID)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_ORG
    ADD CONSTRAINT KSEN_SCHED_RQST_CMP_ORG_FK1 FOREIGN KEY (CMP_ID)
    REFERENCES KSEN_SCHED_RQST_CMP (ID)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_ROOM
    ADD CONSTRAINT KSEN_SCHED_RQST_CMP_ROOM_FK1 FOREIGN KEY (CMP_ID)
    REFERENCES KSEN_SCHED_RQST_CMP (ID)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_RT
    ADD CONSTRAINT KSEN_SCHED_RQST_RT_FK1 FOREIGN KEY (CMP_ID)
    REFERENCES KSEN_SCHED_RQST_CMP (ID)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_TMSLOT
    ADD CONSTRAINT KSEN_SCHED_RQST_CMP_TMSLOT_FK1 FOREIGN KEY (CMP_ID)
    REFERENCES KSEN_SCHED_RQST_CMP (ID)
/



ALTER TABLE KSEN_SCHED_TMSLOT_ATTR
    ADD CONSTRAINT KSEN_SCHED_TMSLOT_ATTR_FK1 FOREIGN KEY (OWNER_ID)
    REFERENCES KSEN_SCHED_TMSLOT (ID)
/

