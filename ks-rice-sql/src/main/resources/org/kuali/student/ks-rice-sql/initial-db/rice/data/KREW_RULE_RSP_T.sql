-- should be deleted, no valid data in this file

TRUNCATE TABLE KREW_RULE_RSP_T DROP STORAGE
/
-- RSP_ID is supposed to match a "RSP_ID" value in a row of the KREW_DLGN_RSP_T table, but no rows exist in that table upon initial data load
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','org.kuali.rice.ken.kew.ChannelReviewerRoleAttribute!reviewers','6166CBA1BBFC644DE0404F8189D86C09',1,'2020','1044','2021','R',1)
/

-- The following rows refer to a RULE_ID that does not exist in the KREW_RULE_T table
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','user4','6166CBA1BBFD644DE0404F8189D86C09',1,'2022','1046','2023','F',1)
/
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','edu.sampleu.travel.workflow.EmployeeAttribute!employee','6166CBA1BBFE644DE0404F8189D86C09',1,'2024','1049','2025','R',1)
/
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','edu.sampleu.travel.workflow.EmployeeAttribute!supervisr','6166CBA1BBFF644DE0404F8189D86C09',1,'2026','1050','2027','R',1)
/
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('K','F','edu.sampleu.travel.workflow.EmployeeAttribute!director','6166CBA1BC00644DE0404F8189D86C09',1,'2028','1051','2029','R',1)
/
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','edu.sampleu.travel.workflow.AccountAttribute!FO','6166CBA1BC01644DE0404F8189D86C09',1,'2030','1052','2031','R',1)
/
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','2202','6166CBA1BC02644DE0404F8189D86C09',1,'2040','1103','2041','G',1)
/
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','2203','6166CBA1BC03644DE0404F8189D86C09',1,'2042','1106','2043','G',1)
/
INSERT INTO KREW_RULE_RSP_T (ACTN_RQST_CD,APPR_PLCY,NM,OBJ_ID,PRIO,RSP_ID,RULE_ID,RULE_RSP_ID,TYP,VER_NBR)
  VALUES ('A','F','9997','B1FCE360-EA7A-C2B8-9D70-88C39A982094',1,'2063','1642','2064','G',1)
/
