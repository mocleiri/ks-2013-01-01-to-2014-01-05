CREATE UNIQUE INDEX KSEN_STATE_P ON KSEN_STATE
(ID   ASC)
/


ALTER TABLE KSEN_STATE
	ADD CONSTRAINT  KSEN_STATE_P PRIMARY KEY (ID)
/


CREATE  INDEX KSEN_STATE_IF1 ON KSEN_STATE
(LIFECYCLE_KEY   ASC)
/




CREATE UNIQUE INDEX KSEN_STATE_ATTR_P ON KSEN_STATE_ATTR
(ID   ASC)
/


ALTER TABLE KSEN_STATE_ATTR
	ADD CONSTRAINT  KSEN_STATE_ATTR_P PRIMARY KEY (ID)
/


CREATE  INDEX KSEN_STATE_ATTR_IF1 ON KSEN_STATE_ATTR
(OWNER_ID   ASC)
/





CREATE UNIQUE INDEX KSEN_STATE_LIFECYCLE_P ON KSEN_STATE_LIFECYCLE
(ID   ASC)
/


ALTER TABLE KSEN_STATE_LIFECYCLE
	ADD CONSTRAINT  KSEN_STATE_LIFECYCLE_P PRIMARY KEY (ID)
/


CREATE  INDEX KSEN_STATE_LIFECYCLE_I1 ON KSEN_STATE_LIFECYCLE
(REF_OBJECT_URI   ASC)
/


CREATE UNIQUE INDEX KSEN_STATE_LIFECYCLE_ATTR_P ON KSEN_STATE_LIFECYCLE_ATTR
(ID   ASC)
/


ALTER TABLE KSEN_STATE_LIFECYCLE_ATTR
	ADD CONSTRAINT  KSEN_STATE_LIFECYCLE_ATTR_P PRIMARY KEY (ID)
/


CREATE  INDEX KSEN_STATE_LIFECYCLE_ATTR_IF1 ON KSEN_STATE_LIFECYCLE_ATTR
(OWNER_ID   ASC)
/


ALTER TABLE KSEN_STATE
	ADD (CONSTRAINT KSEN_STATE_FK1 FOREIGN KEY (LIFECYCLE_KEY) REFERENCES KSEN_STATE_LIFECYCLE (ID))
/


ALTER TABLE KSEN_STATE_ATTR
	ADD (CONSTRAINT KSEN_STATE_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_STATE (ID))
/


ALTER TABLE KSEN_STATE_LIFECYCLE_ATTR
	ADD (CONSTRAINT KSEN_STATE_LIFECYCLE_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_STATE_LIFECYCLE (ID))
/

 CREATE  INDEX KSEN_STATE_CHG_I1 ON KSEN_STATE_CHG
 (STATE_CHG_TYPE   ASC)
 /


 CREATE  INDEX KSEN_STATE_CHG_I2 ON KSEN_STATE_CHG
 (FROM_STATE_ID   ASC,TO_STATE_ID   ASC)
 /


 CREATE  INDEX KSEN_STATE_CHG_IF1 ON KSEN_STATE_CHG
 (FROM_STATE_ID   ASC)
 /


 CREATE  INDEX KSEN_STATE_CHG_IF2 ON KSEN_STATE_CHG
 (TO_STATE_ID   ASC)
 /


 CREATE  INDEX KSEN_STATE_CHG_ATTR_IF1 ON KSEN_STATE_CHG_ATTR
 (OWNER_ID   ASC)
 /

 ALTER TABLE KSEN_STATE_CHG
 	ADD (CONSTRAINT KSEN_STATE_CHG_FK1 FOREIGN KEY (FROM_STATE_ID) REFERENCES KSEN_STATE (ID))
 /


 ALTER TABLE KSEN_STATE_CHG
 	ADD (CONSTRAINT KSEN_STATE_CHG_IF2 FOREIGN KEY (TO_STATE_ID) REFERENCES KSEN_STATE (ID))
 /


 ALTER TABLE KSEN_STATE_CHG_ATTR
 	ADD (CONSTRAINT KSEN_STATE_CHG_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_STATE_CHG (ID))
 /