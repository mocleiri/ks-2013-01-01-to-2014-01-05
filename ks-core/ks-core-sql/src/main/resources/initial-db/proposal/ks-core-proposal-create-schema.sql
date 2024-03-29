

-----------------------------------------------------------------------------
-- KSPR_PROPOSAL
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL
(
      PROPOSAL_ID VARCHAR2(255)
        , CREATEID VARCHAR2(255)
        , CREATETIME TIMESTAMP
        , UPDATEID VARCHAR2(255)
        , UPDATETIME TIMESTAMP
        , VER_NBR NUMBER(19) NOT NULL
        , DETAIL_DESC VARCHAR2(255)
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , NAME VARCHAR2(255)
        , RATIONALE VARCHAR2(255)
        , STATE VARCHAR2(255)
        , WORKFLOW_ID VARCHAR2(255)
        , TYPE VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
    

)
/

ALTER TABLE KSPR_PROPOSAL
    ADD CONSTRAINT KSPR_PROPOSALP1
PRIMARY KEY (PROPOSAL_ID)
/


CREATE INDEX KSPR_PROPOSAL_I1 
  ON KSPR_PROPOSAL 
  (TYPE)
/





-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_ATTR
    ADD CONSTRAINT KSPR_PROPOSAL_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSPR_PROPOSAL_ATTR_I1 
  ON KSPR_PROPOSAL_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_JN_ORG
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_JN_ORG';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_JN_ORG CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_JN_ORG
(
      ORGREF_ID VARCHAR2(255)
        , ORG_ID VARCHAR2(255)
        , PROPOSAL_ID VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_JN_ORG
    ADD CONSTRAINT KSPR_PROPOSAL_JN_ORGP1
PRIMARY KEY (ORGREF_ID)
/


CREATE INDEX KSPR_PROPOSAL_JN_ORG_I1 
  ON KSPR_PROPOSAL_JN_ORG 
  (PROPOSAL_ID)
/





-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_JN_PERSON
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_JN_PERSON';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_JN_PERSON CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_JN_PERSON
(
      ID VARCHAR2(255)
        , PERSONREF_ID VARCHAR2(255)
        , PROPOSAL_ID VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_JN_PERSON
    ADD CONSTRAINT KSPR_PROPOSAL_JN_PERSONP1
PRIMARY KEY (ID)
/


CREATE INDEX KSPR_PROPOSAL_JN_PERSON_I1 
  ON KSPR_PROPOSAL_JN_PERSON 
  (PROPOSAL_ID)
/





-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_JN_REFERENCE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_JN_REFERENCE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_JN_REFERENCE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_JN_REFERENCE
(
      PROPOSAL_ID VARCHAR2(255) NOT NULL
        , REFERENCE_ID VARCHAR2(255) NOT NULL
    

)
/



CREATE INDEX KSPR_PROPOSAL_JN_REFERENCE_I1 
  ON KSPR_PROPOSAL_JN_REFERENCE 
  (REFERENCE_ID)
/
CREATE INDEX KSPR_PROPOSAL_JN_REFERENCE_I2 
  ON KSPR_PROPOSAL_JN_REFERENCE 
  (PROPOSAL_ID)
/





-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_REFERENCE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_REFERENCE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_REFERENCE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_REFERENCE
(
      REFERENCE_ID VARCHAR2(255)
        , OBJECT_REFERENCE_ID VARCHAR2(255)
        , TYPE VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_REFERENCE
    ADD CONSTRAINT KSPR_PROPOSAL_REFERENCEP1
PRIMARY KEY (REFERENCE_ID)
/


CREATE INDEX KSPR_PROPOSAL_REFERENCE_I1 
  ON KSPR_PROPOSAL_REFERENCE 
  (TYPE)
/





-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_REFTYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_REFTYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_REFTYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_REFTYPE
(
      TYPE_KEY VARCHAR2(255)
        , TYPE_DESC VARCHAR2(2000)
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , NAME VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_REFTYPE
    ADD CONSTRAINT KSPR_PROPOSAL_REFTYPEP1
PRIMARY KEY (TYPE_KEY)
/







-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_REFTYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_REFTYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_REFTYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_REFTYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_REFTYPE_ATTR
    ADD CONSTRAINT KSPR_PROPOSAL_REFTYPE_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSPR_PROPOSAL_REFTYPE_ATTR_I1 
  ON KSPR_PROPOSAL_REFTYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_TYPE
(
      TYPE_KEY VARCHAR2(255)
        , TYPE_DESC VARCHAR2(2000)
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , NAME VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_TYPE
    ADD CONSTRAINT KSPR_PROPOSAL_TYPEP1
PRIMARY KEY (TYPE_KEY)
/







-----------------------------------------------------------------------------
-- KSPR_PROPOSAL_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_PROPOSAL_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_PROPOSAL_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_PROPOSAL_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_PROPOSAL_TYPE_ATTR
    ADD CONSTRAINT KSPR_PROPOSAL_TYPE_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSPR_PROPOSAL_TYPE_ATTR_I1 
  ON KSPR_PROPOSAL_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSPR_RICH_TEXT_T
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSPR_RICH_TEXT_T';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSPR_RICH_TEXT_T CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSPR_RICH_TEXT_T
(
      ID VARCHAR2(255)
        , FORMATTED VARCHAR2(500)
        , PLAIN VARCHAR2(2000)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSPR_RICH_TEXT_T
    ADD CONSTRAINT KSPR_RICH_TEXT_TP1
PRIMARY KEY (ID)
/


