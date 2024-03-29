


-----------------------------------------------------------------------------
-- KSDO_DOCUMENT
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_DOCUMENT';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_DOCUMENT CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_DOCUMENT
(
      DOC_ID VARCHAR2(255)
        , CREATEID VARCHAR2(255)
        , CREATETIME TIMESTAMP
        , UPDATEID VARCHAR2(255)
        , UPDATETIME TIMESTAMP
        , VER_NBR NUMBER(19) NOT NULL
        , DOCUMENT CLOB
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , FILE_NAME VARCHAR2(255)
        , NAME VARCHAR2(255)
        , STATE VARCHAR2(255)
        , RT_DESCR_ID VARCHAR2(255)
        , TYPE VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
    

)
/

ALTER TABLE KSDO_DOCUMENT
    ADD CONSTRAINT KSDO_DOCUMENTP1
PRIMARY KEY (DOC_ID)
/


CREATE INDEX KSDO_DOCUMENT_I1 
  ON KSDO_DOCUMENT 
  (RT_DESCR_ID)
/
CREATE INDEX KSDO_DOCUMENT_I2 
  ON KSDO_DOCUMENT 
  (TYPE)
/





-----------------------------------------------------------------------------
-- KSDO_DOCUMENT_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_DOCUMENT_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_DOCUMENT_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_DOCUMENT_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_DOCUMENT_ATTR
    ADD CONSTRAINT KSDO_DOCUMENT_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_DOCUMENT_ATTR_I1 
  ON KSDO_DOCUMENT_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSDO_DOCUMENT_CATEGORY
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_DOCUMENT_CATEGORY';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_DOCUMENT_CATEGORY CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_DOCUMENT_CATEGORY
(
      CATEGORY_ID VARCHAR2(255)
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , NAME VARCHAR2(255)
        , RT_DESCR_ID VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_DOCUMENT_CATEGORY
    ADD CONSTRAINT KSDO_DOCUMENT_CATEGORYP1
PRIMARY KEY (CATEGORY_ID)
/


CREATE INDEX KSDO_DOCUMENT_CATEGORY_I1 
  ON KSDO_DOCUMENT_CATEGORY 
  (RT_DESCR_ID)
/





-----------------------------------------------------------------------------
-- KSDO_DOCUMENT_CATEGORY_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_DOCUMENT_CATEGORY_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_DOCUMENT_CATEGORY_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_DOCUMENT_CATEGORY_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_DOCUMENT_CATEGORY_ATTR
    ADD CONSTRAINT KSDO_DOCUMENT_CATEGORY_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_DOC_CATEGORY_ATTR_I1 
  ON KSDO_DOCUMENT_CATEGORY_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSDO_DOCUMENT_JN_DOC_CATEGORY
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_DOCUMENT_JN_DOC_CATEGORY';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_DOCUMENT_JN_DOC_CATEGORY CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_DOCUMENT_JN_DOC_CATEGORY
(
      DOC_ID VARCHAR2(255) NOT NULL
        , CATEGORY_ID VARCHAR2(255) NOT NULL
    

)
/



CREATE INDEX KSDO_DOC_JN_DOC_CATEGORY_I1 
  ON KSDO_DOCUMENT_JN_DOC_CATEGORY 
  (DOC_ID)
/
CREATE INDEX KSDO_DOC_JN_DOC_CATEGORY_I2 
  ON KSDO_DOCUMENT_JN_DOC_CATEGORY 
  (CATEGORY_ID)
/





-----------------------------------------------------------------------------
-- KSDO_DOCUMENT_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_DOCUMENT_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_DOCUMENT_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_DOCUMENT_TYPE
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

ALTER TABLE KSDO_DOCUMENT_TYPE
    ADD CONSTRAINT KSDO_DOCUMENT_TYPEP1
PRIMARY KEY (TYPE_KEY)
/







-----------------------------------------------------------------------------
-- KSDO_DOCUMENT_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_DOCUMENT_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_DOCUMENT_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_DOCUMENT_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_DOCUMENT_TYPE_ATTR
    ADD CONSTRAINT KSDO_DOCUMENT_TYPE_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_DOCUMENT_TYPE_ATTR_I1 
  ON KSDO_DOCUMENT_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSDO_REF_DOC_RELTN
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_DOC_RELTN';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_DOC_RELTN CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_DOC_RELTN
(
      ID VARCHAR2(255)
        , CREATEID VARCHAR2(255)
        , CREATETIME TIMESTAMP
        , UPDATEID VARCHAR2(255)
        , UPDATETIME TIMESTAMP
        , VER_NBR NUMBER(19) NOT NULL
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , REF_OBJ_ID VARCHAR2(255)
        , ST VARCHAR2(255)
        , TITLE VARCHAR2(255)
        , RT_DESCR_ID VARCHAR2(255)
        , DOC_ID VARCHAR2(255)
        , TYPE_KEY VARCHAR2(255)
        , REF_OBJ_TYPE_KEY VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
    

)
/

ALTER TABLE KSDO_REF_DOC_RELTN
    ADD CONSTRAINT KSDO_REF_DOC_RELTNP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_REF_DOC_RELTN_I1 
  ON KSDO_REF_DOC_RELTN 
  (TYPE_KEY)
/
CREATE INDEX KSDO_REF_DOC_RELTN_I2 
  ON KSDO_REF_DOC_RELTN 
  (REF_OBJ_TYPE_KEY)
/
CREATE INDEX KSDO_REF_DOC_RELTN_I3 
  ON KSDO_REF_DOC_RELTN 
  (RT_DESCR_ID)
/
CREATE INDEX KSDO_REF_DOC_RELTN_I4 
  ON KSDO_REF_DOC_RELTN 
  (DOC_ID)
/





-----------------------------------------------------------------------------
-- KSDO_REF_DOC_RELTN_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_DOC_RELTN_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_DOC_RELTN_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_DOC_RELTN_TYPE
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

ALTER TABLE KSDO_REF_DOC_RELTN_TYPE
    ADD CONSTRAINT KSDO_REF_DOC_RELTN_TYPEP1
PRIMARY KEY (TYPE_KEY)
/







-----------------------------------------------------------------------------
-- KSDO_REF_DOC_RELTN_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_DOC_RELTN_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_DOC_RELTN_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_DOC_RELTN_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_REF_DOC_RELTN_TYPE_ATTR
    ADD CONSTRAINT KSDO_REF_DOC_RELTN_TYPE_ATTP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_REF_DOC_REL_TYP_ATTR_I1 
  ON KSDO_REF_DOC_RELTN_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSDO_REF_DOC_REL_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_DOC_REL_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_DOC_REL_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_DOC_REL_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_REF_DOC_REL_ATTR
    ADD CONSTRAINT KSDO_REF_DOC_REL_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_REF_DOC_REL_ATTR_I1 
  ON KSDO_REF_DOC_REL_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSDO_REF_OBJ_SUB_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_OBJ_SUB_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_OBJ_SUB_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_OBJ_SUB_TYPE
(
      TYPE_KEY VARCHAR2(255)
        , TYPE_DESC VARCHAR2(2000)
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , NAME VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , REF_OBJ_TYPE_KEY VARCHAR2(255)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_REF_OBJ_SUB_TYPE
    ADD CONSTRAINT KSDO_REF_OBJ_SUB_TYPEP1
PRIMARY KEY (TYPE_KEY)
/


CREATE INDEX KSDO_REF_OBJ_SUB_TYPE_I1 
  ON KSDO_REF_OBJ_SUB_TYPE 
  (REF_OBJ_TYPE_KEY)
/





-----------------------------------------------------------------------------
-- KSDO_REF_OBJ_SUB_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_OBJ_SUB_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_OBJ_SUB_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_OBJ_SUB_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_REF_OBJ_SUB_TYPE_ATTR
    ADD CONSTRAINT KSDO_REF_OBJ_SUB_TYPE_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_REF_OBJ_SUB_TYPE_ATTR_I1 
  ON KSDO_REF_OBJ_SUB_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSDO_REF_OBJ_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_OBJ_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_OBJ_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_OBJ_TYPE
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

ALTER TABLE KSDO_REF_OBJ_TYPE
    ADD CONSTRAINT KSDO_REF_OBJ_TYPEP1
PRIMARY KEY (TYPE_KEY)
/







-----------------------------------------------------------------------------
-- KSDO_REF_OBJ_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_OBJ_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_OBJ_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_OBJ_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_REF_OBJ_TYPE_ATTR
    ADD CONSTRAINT KSDO_REF_OBJ_TYPE_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSDO_REF_OBJ_TYPE_ATTR_I1 
  ON KSDO_REF_OBJ_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSDO_REF_REL_TYP_JN_SUB_TYP
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_REF_REL_TYP_JN_SUB_TYP';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_REF_REL_TYP_JN_SUB_TYP CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_REF_REL_TYP_JN_SUB_TYP
(
      REF_DOC_RELTN_TYPE_KEY VARCHAR2(255) NOT NULL
        , REF_OBJ_SUB_TYPE_KEY VARCHAR2(255) NOT NULL
    

)
/



CREATE INDEX KSDO_REF_REL_TYP_JN_SUBTYP_I1 
  ON KSDO_REF_REL_TYP_JN_SUB_TYP 
  (REF_OBJ_SUB_TYPE_KEY)
/
CREATE INDEX KSDO_REF_REL_TYP_JN_SUBTYP_I2 
  ON KSDO_REF_REL_TYP_JN_SUB_TYP 
  (REF_DOC_RELTN_TYPE_KEY)
/





-----------------------------------------------------------------------------
-- KSDO_RICH_TEXT_T
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSDO_RICH_TEXT_T';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSDO_RICH_TEXT_T CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSDO_RICH_TEXT_T
(
      ID VARCHAR2(255)
        , FORMATTED VARCHAR2(2000)
        , PLAIN VARCHAR2(2000)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSDO_RICH_TEXT_T
    ADD CONSTRAINT KSDO_RICH_TEXT_TP1
PRIMARY KEY (ID)
/




