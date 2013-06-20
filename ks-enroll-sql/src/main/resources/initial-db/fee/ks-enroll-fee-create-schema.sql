DECLARE TEMP NUMBER;
BEGIN
  SELECT COUNT(*) INTO TEMP FROM USER_TABLES WHERE TABLE_NAME = 'KSEN_ENROLLMENT_FEE';
	IF TEMP > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSEN_ENROLLMENT_FEE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/




CREATE TABLE KSEN_ENROLLMENT_FEE
(
	ID                   VARCHAR2(255) NOT NULL ,
	OBJ_ID               VARCHAR2(36) NULL ,
	ENRL_FEE_TYPE        VARCHAR2(255) NOT NULL ,
	ENRL_FEE_STATE       VARCHAR2(255) NOT NULL ,
	DESCR_PLAIN          VARCHAR2(4000) NULL ,
	DESCR_FORMATTED      VARCHAR2(4000) NULL ,
	CURRENCY_TYPE        VARCHAR2(255) NULL ,
	CURRENCY_QUANTITY    NUMBER NULL ,
	ORG_ID               VARCHAR2(255) NULL ,
	REF_OBJECT_URI       VARCHAR2(255) NULL ,
	REF_OBJECT_ID        VARCHAR2(255) NULL ,
	VER_NBR              NUMBER(19) NOT NULL ,
	CREATETIME           TIMESTAMP(6) NOT NULL ,
	CREATEID             VARCHAR2(255) NOT NULL ,
	UPDATETIME           TIMESTAMP(6) NULL ,
	UPDATEID             VARCHAR2(255) NULL 
)
/


CREATE UNIQUE INDEX KSEN_ENRL_FEE_P ON KSEN_ENROLLMENT_FEE
(ID   ASC)
/


ALTER TABLE KSEN_ENROLLMENT_FEE
	ADD CONSTRAINT  KSEN_ENRL_FEE_P PRIMARY KEY (ID)   USING INDEX KSEN_ENRL_FEE_P
/


DECLARE TEMP NUMBER;
BEGIN
  SELECT COUNT(*) INTO TEMP FROM USER_TABLES WHERE TABLE_NAME = 'KSEN_ENROLLMENT_FEE_ATTR';
	IF TEMP > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSEN_ENROLLMENT_FEE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/




CREATE TABLE KSEN_ENROLLMENT_FEE_ATTR
(
	ID                   VARCHAR2(255) NOT NULL ,
	OBJ_ID               VARCHAR2(36) NULL ,
	ATTR_KEY             VARCHAR2(255) NULL ,
	ATTR_VALUE           VARCHAR2(2000) NULL ,
	OWNER_ID             VARCHAR2(255) NULL 
)
/


CREATE UNIQUE INDEX KSEN_ENRL_FEE_ATTR_P ON KSEN_ENROLLMENT_FEE_ATTR
(ID   ASC)
/


ALTER TABLE KSEN_ENROLLMENT_FEE_ATTR
	ADD CONSTRAINT  KSEN_ENRL_FEE_ATTR_P PRIMARY KEY (ID)   USING INDEX KSEN_ENRL_FEE_ATTR_P
/


