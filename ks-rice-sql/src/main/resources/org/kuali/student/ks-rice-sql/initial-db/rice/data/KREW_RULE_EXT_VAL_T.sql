TRUNCATE TABLE KREW_RULE_EXT_VAL_T DROP STORAGE
/

-- all of these roes refer to RULE_EXT_ID rows that have bad data

INSERT INTO KREW_RULE_EXT_VAL_T (KEY_CD,RULE_EXT_ID,RULE_EXT_VAL_ID,VAL,VER_NBR)
  VALUES ('destination','1047','1048','las vegas',1)
/
INSERT INTO KREW_RULE_EXT_VAL_T (KEY_CD,RULE_EXT_ID,RULE_EXT_VAL_ID,VAL,VER_NBR)
  VALUES ('campus','1104','1105','IUB',1)
/
INSERT INTO KREW_RULE_EXT_VAL_T (KEY_CD,RULE_EXT_ID,RULE_EXT_VAL_ID,VAL,VER_NBR)
  VALUES ('campus','1107','1108','IUPUI',1)
/
