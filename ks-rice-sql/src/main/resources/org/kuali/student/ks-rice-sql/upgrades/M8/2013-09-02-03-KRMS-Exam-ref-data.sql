--Context
INSERT INTO KRMS_CNTXT_T (ACTV,CNTXT_ID,DESC_TXT,NM,NMSPC_CD,TYP_ID,VER_NBR)
  VALUES ('Y','KS-KRMS-CNTXT-10002','FinalExamMatrix','Final Exam Matrix Rules','KS-SYS',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.agenda.type.final.exam'),0)
/

--Agendas and References
INSERT INTO KRMS_AGENDA_T (ACTV,AGENDA_ID,CNTXT_ID,INIT_AGENDA_ITM_ID,NM,TYP_ID,VER_NBR)
  VALUES ('Y','KS-KRMS-AGENDA-11923','KS-KRMS-CNTXT-10002',null,'Fall Standard Final Exam Rules',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.agenda.type.final.exam.standard'),0)
/
INSERT INTO KRMS_REF_OBJ_KRMS_OBJ_T (ACTV,COLLECTION_NM,KRMS_DSCR_TYP,KRMS_OBJ_ID,NMSPC_CD,REF_DSCR_TYP,REF_OBJ_ID,REF_OBJ_KRMS_OBJ_ID,VER_NBR)
  VALUES ('Y','FinalExamMatrix','Agenda','KS-KRMS-AGENDA-11923','KS-SYS','kuali.atp.type.group.term','kuali.atp.type.Fall','KS-KRMS-REF-OBJ-KRMS-OBJ-11914',0)
/

INSERT INTO KRMS_AGENDA_T (ACTV,AGENDA_ID,CNTXT_ID,INIT_AGENDA_ITM_ID,NM,TYP_ID,VER_NBR)
  VALUES ('Y','KS-KRMS-AGENDA-11924','KS-KRMS-CNTXT-10002',null,'Fall Common Final Exam Rules',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.agenda.type.final.exam.common'),0)
/
INSERT INTO KRMS_REF_OBJ_KRMS_OBJ_T (ACTV,COLLECTION_NM,KRMS_DSCR_TYP,KRMS_OBJ_ID,NMSPC_CD,REF_DSCR_TYP,REF_OBJ_ID,REF_OBJ_KRMS_OBJ_ID,VER_NBR)
  VALUES ('Y','FinalExamMatrix','Agenda','KS-KRMS-AGENDA-11924','KS-SYS','kuali.atp.type.group.term','kuali.atp.type.Fall','KS-KRMS-REF-OBJ-KRMS-OBJ-11915',0)
/

--Rules
Insert into KRMS_RULE_T (ACTV,DESC_TXT,NM,NMSPC_CD,PROP_ID,RULE_ID,TYP_ID,VER_NBR) values ('Y',null,concat(concat('kuali.atp.type.Fall:',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.rule.type.final.exam.standard')), ':1'),'KS-SYS',null,'KS-KRMS-RULE-12037',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.rule.type.final.exam.standard'),1)
/
Insert into KRMS_RULE_T (ACTV,DESC_TXT,NM,NMSPC_CD,PROP_ID,RULE_ID,TYP_ID,VER_NBR) values ('Y',null,concat(concat('kuali.atp.type.Fall:',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.rule.type.final.exam.common')), ':1'),'KS-SYS',null,'KS-KRMS-RULE-12038',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.rule.type.final.exam.common'),1)
/

--Agenda Items
INSERT INTO KRMS_AGENDA_ITM_T (AGENDA_ID,AGENDA_ITM_ID,RULE_ID,VER_NBR)
  VALUES ('KS-KRMS-AGENDA-11923','KS-KRMS-AGENDA-ITM-12031','KS-KRMS-RULE-12037',1)
/
UPDATE KRMS_AGENDA_T set INIT_AGENDA_ITM_ID = 'KS-KRMS-AGENDA-ITM-12031' WHERE AGENDA_ID = 'KS-KRMS-AGENDA-11923'
/
INSERT INTO KRMS_AGENDA_ITM_T (AGENDA_ID,AGENDA_ITM_ID,RULE_ID,VER_NBR)
  VALUES ('KS-KRMS-AGENDA-11924','KS-KRMS-AGENDA-ITM-12032','KS-KRMS-RULE-12038',1)
/
UPDATE KRMS_AGENDA_T set INIT_AGENDA_ITM_ID = 'KS-KRMS-AGENDA-ITM-12032' WHERE AGENDA_ID = 'KS-KRMS-AGENDA-11924'
/

--Propositions
Insert into KRMS_PROP_T (CMPND_OP_CD,DESC_TXT,PROP_ID,RULE_ID,TYP_ID,VER_NBR,DSCRM_TYP_CD,CMPND_SEQ_NO) values (null,'Final exam timeslot','KS-KRMS-PROP-14726','KS-KRMS-RULE-12037',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.proposition.type.final.exam.timeslot'),1,'S',1)
/
UPDATE KRMS_RULE_T set PROP_ID = 'KS-KRMS-PROP-14726' where RULE_ID like 'KS-KRMS-RULE-12037'
/
Insert into KRMS_PROP_T (CMPND_OP_CD,DESC_TXT,PROP_ID,RULE_ID,TYP_ID,VER_NBR,DSCRM_TYP_CD,CMPND_SEQ_NO) values (null,'Final exam for course offering','KS-KRMS-PROP-14727','KS-KRMS-RULE-12038',(SELECT TYP_ID FROM KRMS_TYP_T WHERE NM = 'kuali.krms.proposition.type.final.exam.course.offering'),1,'S',1)
/
UPDATE KRMS_RULE_T set PROP_ID = 'KS-KRMS-PROP-14727' where RULE_ID like 'KS-KRMS-RULE-12038'
/

--Proposition Parameters
Insert into KRMS_PROP_PARM_T (PARM_TYP_CD,PARM_VAL,PROP_ID,PROP_PARM_ID,SEQ_NO,VER_NBR) values ('T','1','KS-KRMS-PROP-14726','KS-KRMS-PROP-PARM-20258',1,2)
/
Insert into KRMS_PROP_PARM_T (PARM_TYP_CD,PARM_VAL,PROP_ID,PROP_PARM_ID,SEQ_NO,VER_NBR) values ('C','1','KS-KRMS-PROP-14726','KS-KRMS-PROP-PARM-20259',2,2)
/
Insert into KRMS_PROP_PARM_T (PARM_TYP_CD,PARM_VAL,PROP_ID,PROP_PARM_ID,SEQ_NO,VER_NBR) values ('O','=','KS-KRMS-PROP-14726','KS-KRMS-PROP-PARM-20260',3,2)
/

Insert into KRMS_PROP_PARM_T (PARM_TYP_CD,PARM_VAL,PROP_ID,PROP_PARM_ID,SEQ_NO,VER_NBR) values ('T','1','KS-KRMS-PROP-14727','KS-KRMS-PROP-PARM-20261',1,2)
/
Insert into KRMS_PROP_PARM_T (PARM_TYP_CD,PARM_VAL,PROP_ID,PROP_PARM_ID,SEQ_NO,VER_NBR) values ('C','1','KS-KRMS-PROP-14727','KS-KRMS-PROP-PARM-20262',2,2)
/
Insert into KRMS_PROP_PARM_T (PARM_TYP_CD,PARM_VAL,PROP_ID,PROP_PARM_ID,SEQ_NO,VER_NBR) values ('O','=','KS-KRMS-PROP-14727','KS-KRMS-PROP-PARM-20263',3,2)
/