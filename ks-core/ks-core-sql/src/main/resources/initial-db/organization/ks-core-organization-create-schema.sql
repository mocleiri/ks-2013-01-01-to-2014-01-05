

-----------------------------------------------------------------------------
-- KSOR_ORG
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG
(
      ID VARCHAR2(255)
        , CREATEID VARCHAR2(255)
        , CREATETIME TIMESTAMP
        , UPDATEID VARCHAR2(255)
        , UPDATETIME TIMESTAMP
        , VER_NBR NUMBER(19) NOT NULL
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , LNG_DESCR VARCHAR2(2000)
        , LNG_NAME VARCHAR2(255)
        , SHRT_DESCR VARCHAR2(500)
        , SHRT_NAME VARCHAR2(255)
        , ST VARCHAR2(255)
        , TYPE VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
    

)
/

ALTER TABLE KSOR_ORG
    ADD CONSTRAINT KSOR_ORGP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_I1 
  ON KSOR_ORG 
  (TYPE)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_ATTR
    ADD CONSTRAINT KSOR_ORG_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_ATTR_I1 
  ON KSOR_ORG_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_HIRCHY
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_HIRCHY';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_HIRCHY CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_HIRCHY
(
      ID VARCHAR2(255)
        , DESCR VARCHAR2(2000)
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , NAME VARCHAR2(255)
        , ROOT_ORG VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_HIRCHY
    ADD CONSTRAINT KSOR_ORG_HIRCHYP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_HIRCHY_I1 
  ON KSOR_ORG_HIRCHY 
  (ROOT_ORG)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_HIRCHY_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_HIRCHY_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_HIRCHY_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_HIRCHY_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_HIRCHY_ATTR
    ADD CONSTRAINT KSOR_ORG_HIRCHY_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_HIRCHY_ATTR_I1 
  ON KSOR_ORG_HIRCHY_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_HIRCHY_JN_ORG_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_HIRCHY_JN_ORG_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_HIRCHY_JN_ORG_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_HIRCHY_JN_ORG_TYPE
(
      ORG_HIRCHY_ID VARCHAR2(255) NOT NULL
        , ORG_TYPE_ID VARCHAR2(255) NOT NULL
    

)
/



CREATE INDEX KSOR_ORG_HIRCHY_JN_ORG_TYP_I1 
  ON KSOR_ORG_HIRCHY_JN_ORG_TYPE 
  (ORG_HIRCHY_ID)
/
CREATE INDEX KSOR_ORG_HIRCHY_JN_ORG_TYP_I2 
  ON KSOR_ORG_HIRCHY_JN_ORG_TYPE 
  (ORG_TYPE_ID)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_JN_ORG_PERS_REL_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_JN_ORG_PERS_REL_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_JN_ORG_PERS_REL_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_JN_ORG_PERS_REL_TYPE
(
      ORG_ID VARCHAR2(255) NOT NULL
        , ORG_PERS_RELTN_TYPE_ID VARCHAR2(255) NOT NULL
    

)
/



CREATE INDEX KSOR_ORG_JN_ORG_PERREL_TYP_I1 
  ON KSOR_ORG_JN_ORG_PERS_REL_TYPE 
  (ORG_PERS_RELTN_TYPE_ID)
/
CREATE INDEX KSOR_ORG_JN_ORG_PERREL_TYP_I2 
  ON KSOR_ORG_JN_ORG_PERS_REL_TYPE 
  (ORG_ID)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_ORG_RELTN
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_ORG_RELTN';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_ORG_RELTN CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_ORG_RELTN
(
      ID VARCHAR2(255)
        , CREATEID VARCHAR2(255)
        , CREATETIME TIMESTAMP
        , UPDATEID VARCHAR2(255)
        , UPDATETIME TIMESTAMP
        , VER_NBR NUMBER(19) NOT NULL
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , ST VARCHAR2(255)
        , ORG VARCHAR2(255)
        , RELATED_ORG VARCHAR2(255)
        , TYPE VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
    

)
/

ALTER TABLE KSOR_ORG_ORG_RELTN
    ADD CONSTRAINT KSOR_ORG_ORG_RELTNP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_ORG_RELTN_I1 
  ON KSOR_ORG_ORG_RELTN 
  (ORG)
/
CREATE INDEX KSOR_ORG_ORG_RELTN_I2 
  ON KSOR_ORG_ORG_RELTN 
  (RELATED_ORG)
/
CREATE INDEX KSOR_ORG_ORG_RELTN_I3 
  ON KSOR_ORG_ORG_RELTN 
  (TYPE)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_ORG_RELTN_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_ORG_RELTN_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_ORG_RELTN_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_ORG_RELTN_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_ORG_RELTN_ATTR
    ADD CONSTRAINT KSOR_ORG_ORG_RELTN_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_ORG_RELTN_ATTR_I1 
  ON KSOR_ORG_ORG_RELTN_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_ORG_RELTN_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_ORG_RELTN_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_ORG_RELTN_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_ORG_RELTN_TYPE
(
      TYPE_KEY VARCHAR2(255)
        , TYPE_DESC VARCHAR2(2000)
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , NAME VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , REV_DESCR VARCHAR2(255)
        , REV_NAME VARCHAR2(255)
        , ORG_HIRCHY VARCHAR2(255)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_ORG_RELTN_TYPE
    ADD CONSTRAINT KSOR_ORG_ORG_RELTN_TYPEP1
PRIMARY KEY (TYPE_KEY)
/


CREATE INDEX KSOR_ORG_ORG_RELTN_TYPE_I1 
  ON KSOR_ORG_ORG_RELTN_TYPE 
  (ORG_HIRCHY)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_ORG_RELTN_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_ORG_RELTN_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_ORG_RELTN_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_ORG_RELTN_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_ORG_RELTN_TYPE_ATTR
    ADD CONSTRAINT KSOR_ORG_ORG_RELTN_TYPE_ATTP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_ORG_REL_TYP_ATTR_I1 
  ON KSOR_ORG_ORG_RELTN_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_PERS_RELTN
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_PERS_RELTN';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_PERS_RELTN CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_PERS_RELTN
(
      ID VARCHAR2(255)
        , CREATEID VARCHAR2(255)
        , CREATETIME TIMESTAMP
        , UPDATEID VARCHAR2(255)
        , UPDATETIME TIMESTAMP
        , VER_NBR NUMBER(19) NOT NULL
        , EFF_DT TIMESTAMP
        , EXPIR_DT TIMESTAMP
        , PERS_ID VARCHAR2(255)
        , ST VARCHAR2(255)
        , ORG VARCHAR2(255)
        , ORG_PERS_RELTN_TYPE VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
    
    , CONSTRAINT SYS_C0011691 UNIQUE (ORG_PERS_RELTN_TYPE, ORG, PERS_ID)

)
/

ALTER TABLE KSOR_ORG_PERS_RELTN
    ADD CONSTRAINT KSOR_ORG_PERS_RELTNP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_PERS_RELTN_I1 
  ON KSOR_ORG_PERS_RELTN 
  (ORG)
/
CREATE INDEX KSOR_ORG_PERS_RELTN_I2 
  ON KSOR_ORG_PERS_RELTN 
  (ORG_PERS_RELTN_TYPE)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_PERS_RELTN_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_PERS_RELTN_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_PERS_RELTN_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_PERS_RELTN_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_PERS_RELTN_ATTR
    ADD CONSTRAINT KSOR_ORG_PERS_RELTN_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_PERS_RELTN_ATTR_I1 
  ON KSOR_ORG_PERS_RELTN_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_PERS_RELTN_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_PERS_RELTN_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_PERS_RELTN_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_PERS_RELTN_TYPE
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

ALTER TABLE KSOR_ORG_PERS_RELTN_TYPE
    ADD CONSTRAINT KSOR_ORG_PERS_RELTN_TYPEP1
PRIMARY KEY (TYPE_KEY)
/







-----------------------------------------------------------------------------
-- KSOR_ORG_PERS_RELTN_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_PERS_RELTN_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_PERS_RELTN_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_PERS_RELTN_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_PERS_RELTN_TYPE_ATTR
    ADD CONSTRAINT KSOR_ORG_PERS_RELTN_TYPE_ATP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_PERS_REL_TYP_ATTR_I1 
  ON KSOR_ORG_PERS_RELTN_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_POS_RESTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_POS_RESTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_POS_RESTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_POS_RESTR
(
      ID VARCHAR2(255)
        , CREATEID VARCHAR2(255)
        , CREATETIME TIMESTAMP
        , UPDATEID VARCHAR2(255)
        , UPDATETIME TIMESTAMP
        , VER_NBR NUMBER(19) NOT NULL
        , DESCR VARCHAR2(2000)
        , MAX_NUM_RELTN VARCHAR2(255)
        , MIN_NUM_RELTN NUMBER(10)
        , ATP_DUR_TYP_KEY VARCHAR2(255)
        , TM_QUANTITY NUMBER(10)
        , TTL VARCHAR2(255)
        , ORG VARCHAR2(255)
        , PERS_RELTN_TYPE VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
    
    , CONSTRAINT SYS_C0011701 UNIQUE (ORG, PERS_RELTN_TYPE)

)
/

ALTER TABLE KSOR_ORG_POS_RESTR
    ADD CONSTRAINT KSOR_ORG_POS_RESTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_POS_RESTR_I1 
  ON KSOR_ORG_POS_RESTR 
  (PERS_RELTN_TYPE)
/
CREATE INDEX KSOR_ORG_POS_RESTR_I2 
  ON KSOR_ORG_POS_RESTR 
  (ORG)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_POS_RESTR_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_POS_RESTR_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_POS_RESTR_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_POS_RESTR_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_POS_RESTR_ATTR
    ADD CONSTRAINT KSOR_ORG_POS_RESTR_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_POS_RESTR_ATTR_I1 
  ON KSOR_ORG_POS_RESTR_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_TYPE
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_TYPE';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_TYPE CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_TYPE
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

ALTER TABLE KSOR_ORG_TYPE
    ADD CONSTRAINT KSOR_ORG_TYPEP1
PRIMARY KEY (TYPE_KEY)
/







-----------------------------------------------------------------------------
-- KSOR_ORG_TYPE_ATTR
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_TYPE_ATTR';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_TYPE_ATTR
(
      ID VARCHAR2(255)
        , ATTR_NAME VARCHAR2(255)
        , ATTR_VALUE VARCHAR2(2000)
        , OWNER VARCHAR2(255)
        , OBJ_ID VARCHAR2(36)
        , VER_NBR NUMBER(19)
    

)
/

ALTER TABLE KSOR_ORG_TYPE_ATTR
    ADD CONSTRAINT KSOR_ORG_TYPE_ATTRP1
PRIMARY KEY (ID)
/


CREATE INDEX KSOR_ORG_TYPE_ATTR_I1 
  ON KSOR_ORG_TYPE_ATTR 
  (OWNER)
/





-----------------------------------------------------------------------------
-- KSOR_ORG_TYPE_JN_ORG_PERRL_TYP
-----------------------------------------------------------------------------
DECLARE temp NUMBER;
BEGIN
	SELECT COUNT(*) INTO temp FROM user_tables WHERE table_name = 'KSOR_ORG_TYPE_JN_ORG_PERRL_TYP';
	IF temp > 0 THEN EXECUTE IMMEDIATE 'DROP TABLE KSOR_ORG_TYPE_JN_ORG_PERRL_TYP CASCADE CONSTRAINTS PURGE'; END IF;
END;
/

CREATE TABLE KSOR_ORG_TYPE_JN_ORG_PERRL_TYP
(
      ORG_TYPE_ID VARCHAR2(255) NOT NULL
        , ORG_PERS_RELTN_TYPE_ID VARCHAR2(255) NOT NULL
    

)
/



CREATE INDEX KSOR_ORGTYP_JN_ORGPREL_TYP_I1 
  ON KSOR_ORG_TYPE_JN_ORG_PERRL_TYP 
  (ORG_PERS_RELTN_TYPE_ID)
/
CREATE INDEX KSOR_ORGTYP_JN_ORGPREL_TYP_I2 
  ON KSOR_ORG_TYPE_JN_ORG_PERRL_TYP 
  (ORG_TYPE_ID)
/
