TRUNCATE TABLE KRMS_NL_USAGE_T DROP STORAGE
/
INSERT INTO KRMS_NL_USAGE_T (ACTV,DESC_TXT,NL_USAGE_ID,NM,NMSPC_CD,VER_NBR)
  VALUES ('Y','Kuali Rule Edit','10000','kuali.krms.edit','KS-SYS',0)
/
INSERT INTO KRMS_NL_USAGE_T (ACTV,DESC_TXT,NL_USAGE_ID,NM,NMSPC_CD,VER_NBR)
  VALUES ('Y','Kuali Rule Composition','10001','kuali.krms.composition','KS-SYS',0)
/
INSERT INTO KRMS_NL_USAGE_T (ACTV,DESC_TXT,NL_USAGE_ID,NM,NMSPC_CD,VER_NBR)
  VALUES ('Y','Kuali Rule Example','10002','kuali.krms.example','KS-SYS',0)
/
INSERT INTO KRMS_NL_USAGE_T (ACTV,DESC_TXT,NL_USAGE_ID,NM,NMSPC_CD,VER_NBR)
  VALUES ('Y','Kuali Rule Preview','10003','kuali.krms.preview','KS-SYS',0)
/
INSERT INTO KRMS_NL_USAGE_T (ACTV,DESC_TXT,NL_USAGE_ID,NM,NMSPC_CD,VER_NBR)
  VALUES ('Y','Kuali Rule Type Description','10004','kuali.krms.type.description','KS-SYS',0)
/
Insert into KRMS_NL_USAGE_T (NL_USAGE_ID,NM,NMSPC_CD,DESC_TXT,ACTV,VER_NBR)
  values ('10005','kuali.krms.catalog','KS-SYS','Kuali Rule Catalog','Y',0)
/
