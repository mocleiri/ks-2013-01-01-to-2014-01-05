begin execute immediate 'drop table KSPL_LRNG_PI_RICH_TEXT CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PI_RICH_TEXT
(
  ID VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, VER_NBR DECIMAL(19, 0)
, FORMATTED VARCHAR2(2000)
, PLAIN VARCHAR2(2000)
, CONSTRAINT KSPL_LRNG_PI_RICH_TEXTP1 PRIMARY KEY
  (
    ID
  )
)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_TYPE CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_TYPE
(
  TYPE_KEY VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, VER_NBR DECIMAL(19, 0)
, TYPE_DESC VARCHAR2(2000)
, EFF_DT TIMESTAMP
, EXPIR_DT TIMESTAMP
, NAME VARCHAR2(255)
, REF_OBJECT_URI VARCHAR2(255)
, CONSTRAINT KSPL_LRNG_PLAN_TYPEP1 PRIMARY KEY
  (
    TYPE_KEY
  )
)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_RICH_TEXT CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_RICH_TEXT
(
  ID VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, VER_NBR DECIMAL(19, 0)
, FORMATTED VARCHAR2(2000)
, PLAIN VARCHAR2(2000)
, CONSTRAINT KSPL_LRNG_PLAN_RICH_TEXTP1 PRIMARY KEY
  (
    ID
  )
)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN 
(
  ID VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, VER_NBR DECIMAL(19, 0) 
, CREATEID VARCHAR2(255)
, CREATETIME TIMESTAMP
, UPDATEID VARCHAR2(255)
, UPDATETIME TIMESTAMP
, STUDENT_ID VARCHAR2(255)
, RT_DESCR_ID VARCHAR2(255)
, TYPE_ID VARCHAR2(255) NOT NULL
, STATE VARCHAR2(255)
, SHARED DECIMAL(1, 0) DEFAULT 1 NOT NULL 
, CONSTRAINT KSPL_LRNG_PLANP1 PRIMARY KEY 
  (
    ID 
  ) ,
  CONSTRAINT KSPL_LRNG_PLAN_FK1
    FOREIGN KEY (TYPE_ID )
    REFERENCES KSPL_LRNG_PLAN_TYPE (TYPE_KEY ),
  CONSTRAINT KSPL_LRNG_PLAN_FK2
    FOREIGN KEY (RT_DESCR_ID )
    REFERENCES KSPL_LRNG_PLAN_RICH_TEXT (ID )
)
/
CREATE INDEX KSPL_LRNG_PLAN_I1 ON KSPL_LRNG_PLAN (TYPE_ID)
/
CREATE INDEX KSPL_LRNG_PLAN_I2 ON KSPL_LRNG_PLAN (RT_DESCR_ID) ;
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_ATTR CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_ATTR 
(
  ID VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, ATTR_KEY VARCHAR2(255)
, ATTR_VALUE VARCHAR2(2000)
, OWNER_ID VARCHAR2(255)
, CONSTRAINT KSPL_LRNG_PLAN_ATTRP1 PRIMARY KEY 
  (
    ID 
  ) ,
  CONSTRAINT KSPL_LRNG_PLAN_ATTR_FK1
    FOREIGN KEY (OWNER_ID )
    REFERENCES KSPL_LRNG_PLAN (ID )
)
/
CREATE INDEX KSPL_LRNG_PLAN_ATTR_I1 ON KSPL_LRNG_PLAN_ATTR (OWNER_ID)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_ITEM_TYPE CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_ITEM_TYPE
(
  TYPE_KEY VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, VER_NBR DECIMAL(19, 0)
, TYPE_DESC VARCHAR2(2000)
, EFF_DT TIMESTAMP
, EXPIR_DT TIMESTAMP
, NAME VARCHAR2(255)
, REF_OBJECT_URI VARCHAR2(255)
, CONSTRAINT KSPL_LRNG_PLAN_ITEM_TYPEP1 PRIMARY KEY
  (
    TYPE_KEY
  )
)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_ITEM CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_ITEM 
(
  ID VARCHAR2(255) NOT NULL
, CREATEID VARCHAR2(255)
, CREATETIME TIMESTAMP
, UPDATEID VARCHAR2(255)
, UPDATETIME TIMESTAMP
, VER_NBR DECIMAL(19, 0) NOT NULL 
, REF_OBJ_ID VARCHAR2(255)
, REF_OBJ_TYPE_KEY VARCHAR2(255)
, OBJ_ID VARCHAR2(36)
, TYPE_ID VARCHAR2(255) NOT NULL
, PLAN_ID VARCHAR2(255) NOT NULL
, RT_DESCR_ID VARCHAR2(255)
, STATE VARCHAR2(255)
, CREDIT DECIMAL(5, 2) 
, CONSTRAINT KSPL_LRNG_PLAN_ITEMP1 PRIMARY KEY 
  (
    ID 
  ) ,
  CONSTRAINT KSPL_LRNG_PLAN_ITEM_FK1
    FOREIGN KEY (PLAN_ID )
    REFERENCES KSPL_LRNG_PLAN (ID ),
  CONSTRAINT KSPL_LRNG_PLAN_ITEM_FK2
    FOREIGN KEY (TYPE_ID )
    REFERENCES KSPL_LRNG_PLAN_ITEM_TYPE (TYPE_KEY ),
  CONSTRAINT KSPL_LRNG_PLAN_ITEM_FK3
    FOREIGN KEY (RT_DESCR_ID )
    REFERENCES KSPL_LRNG_PI_RICH_TEXT (ID )
)
/
CREATE INDEX KSPL_LRNG_PLAN_ITEM_I1 ON KSPL_LRNG_PLAN_ITEM (PLAN_ID)
/
CREATE INDEX KSPL_LRNG_PLAN_ITEM_I2 ON KSPL_LRNG_PLAN_ITEM (TYPE_ID)
/
CREATE INDEX KSPL_LRNG_PLAN_ITEM_I3 ON KSPL_LRNG_PLAN_ITEM (RT_DESCR_ID)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_ITEM_ATP_ID CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_ITEM_ATP_ID
(
  PLAN_ITEM_ID VARCHAR2(255) NOT NULL
, ATP_ID VARCHAR2(255) NOT NULL
, CONSTRAINT KSPL_LRNG_PLAN_ITEM_ATP_IDP1 PRIMARY KEY
  (
    PLAN_ITEM_ID
,   ATP_ID
  ) ,
  CONSTRAINT KSPL_LRNG_PLAN_ITEM_ATP_ID_FK1
    FOREIGN KEY (PLAN_ITEM_ID )
    REFERENCES KSPL_LRNG_PLAN_ITEM (ID )
/*
, CONSTRAINT KSPL_LRNG_PLAN_ITEM_ATP_ID_FK2
    FOREIGN KEY (ATP_ID )
    REFERENCES KSEN_ATP (ID )
*/
)
/
CREATE INDEX KSPL_LRNG_PLAN_ITEM_ATP_ID_I1 ON KSPL_LRNG_PLAN_ITEM_ATP_ID (PLAN_ITEM_ID)
/
CREATE INDEX KSPL_LRNG_PLAN_ITEM_ATP_ID_I2 ON KSPL_LRNG_PLAN_ITEM_ATP_ID (ATP_ID)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_ITEM_ATTR CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_ITEM_ATTR 
(
  ID VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, ATTR_KEY VARCHAR2(255)
, ATTR_VALUE VARCHAR2(2000)
, OWNER_ID VARCHAR2(255)
, CONSTRAINT KSPL_LRNG_PLAN_ITEM_ATTRP1 PRIMARY KEY 
  (
    ID 
  )    ,
  CONSTRAINT KSPL_LRNG_PLAN_ITEM_ATTR_FK1
    FOREIGN KEY (OWNER_ID )
    REFERENCES KSPL_LRNG_PLAN_ITEM (ID )
)
/
begin execute immediate 'drop index KSPL_LRNG_PLAN_ITEM_ATTR_I1 CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE INDEX KSPL_LRNG_PLAN_ITEM_ATTR_I1 ON KSPL_LRNG_PLAN_ITEM_ATTR (OWNER_ID)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_ITEM_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_ITEM_TYPE_ATTR 
(
  ID VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, ATTR_KEY VARCHAR2(255)
, ATTR_VALUE VARCHAR2(2000)
, OWNER_ID VARCHAR2(255)
, CONSTRAINT KSPL_LRNG_PLAN_ITEM_TYPE_ATP1 PRIMARY KEY 
  (
    ID 
  ) ,
  CONSTRAINT KSPL_LRNG_PI_TYPE_ATTR_FK
    FOREIGN KEY (OWNER_ID )
    REFERENCES KSPL_LRNG_PLAN_ITEM_TYPE (TYPE_KEY )
)
/
CREATE INDEX KSPL_LRNG_PI_TYPE_ATTR_I1 ON KSPL_LRNG_PLAN_ITEM_TYPE_ATTR (OWNER_ID)
/

begin execute immediate 'drop table KSPL_LRNG_PLAN_TYPE_ATTR CASCADE CONSTRAINTS PURGE'; exception when others then null; end;
/
CREATE TABLE KSPL_LRNG_PLAN_TYPE_ATTR 
(
  ID VARCHAR2(255) NOT NULL
, OBJ_ID VARCHAR2(36)
, ATTR_KEY VARCHAR2(255)
, ATTR_VALUE VARCHAR2(2000)
, OWNER_ID VARCHAR2(255)
, CONSTRAINT KSPL_LRNG_PLAN_TYPE_ATTRP1 PRIMARY KEY 
  (
    ID 
  ) ,
  CONSTRAINT KSPL_LRNG_PLAN_TYPE_ATTR_FK1
    FOREIGN KEY (OWNER_ID )
    REFERENCES KSPL_LRNG_PLAN_TYPE (TYPE_KEY )
)
/
CREATE INDEX KSPL_LRNG_PLAN_TYPE_ATTR_I1 ON KSPL_LRNG_PLAN_TYPE_ATTR (OWNER_ID)
/