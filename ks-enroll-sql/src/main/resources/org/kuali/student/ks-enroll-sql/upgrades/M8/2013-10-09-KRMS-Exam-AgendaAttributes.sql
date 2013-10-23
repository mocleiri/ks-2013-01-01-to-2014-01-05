--Attribute Definition for RDL Action.
INSERT INTO KRMS_ATTR_DEFN_T (ATTR_DEFN_ID,ACTV,CMPNT_NM,DESC_TXT,LBL,NM,NMSPC_CD,VER_NBR)
  VALUES ('KS-KRMS-ATTR-DEFN-10005','Y',null,'Master Term Type for Agenda','Master Term Type', 'kuali.krms.agenda.attribute.owner.term.type','KS-SYS',1)
/

INSERT INTO KRMS_TYP_ATTR_T (TYP_ATTR_ID,ATTR_DEFN_ID,TYP_ID,ACTV,SEQ_NO,VER_NBR)
  VALUES ('KS-KRMS-TYP_ATTR-10000','KS-KRMS-ATTR-DEFN-10005','KS-KRMS-TYP-55668','Y',1,1)
/

INSERT INTO KRMS_TYP_ATTR_T (TYP_ATTR_ID,ATTR_DEFN_ID,TYP_ID,ACTV,SEQ_NO,VER_NBR)
  VALUES ('KS-KRMS-TYP_ATTR-10001','KS-KRMS-ATTR-DEFN-10005','KS-KRMS-TYP-55671','Y',1,1)
/

INSERT INTO KRMS_TYP_ATTR_T (TYP_ATTR_ID,ATTR_DEFN_ID,TYP_ID,ACTV,SEQ_NO,VER_NBR)
  VALUES ('KS-KRMS-TYP_ATTR-10002','KS-KRMS-ATTR-DEFN-10005','KS-KRMS-TYP-55669','Y',1,1)
/

--Fall Standard Final Exam Rules
INSERT INTO KRMS_AGENDA_ATTR_T (AGENDA_ATTR_ID, AGENDA_ID, ATTR_DEFN_ID, ATTR_VAL, VER_NBR)
  VALUES ('KS-KRMS-AGENDA-ATTR-10000', 'KS-KRMS-AGENDA-11923', 'KS-KRMS-ATTR-DEFN-10005', 'kuali.atp.type.Fall', 1)
/

--Fall Common Final Exam Rules
INSERT INTO KRMS_AGENDA_ATTR_T (AGENDA_ATTR_ID, AGENDA_ID, ATTR_DEFN_ID, ATTR_VAL, VER_NBR)
  VALUES ('KS-KRMS-AGENDA-ATTR-10001', 'KS-KRMS-AGENDA-11924', 'KS-KRMS-ATTR-DEFN-10005', 'kuali.atp.type.Fall', 1)
/

--Spring Common Final Exam Rules
INSERT INTO KRMS_AGENDA_ATTR_T (AGENDA_ATTR_ID, AGENDA_ID, ATTR_DEFN_ID, ATTR_VAL, VER_NBR)
  VALUES ('KS-KRMS-AGENDA-ATTR-10002', 'KS-KRMS-AGENDA-11925', 'KS-KRMS-ATTR-DEFN-10005', 'kuali.atp.type.Spring', 1)
/

--Spring Standard Final Exam Rules
INSERT INTO KRMS_AGENDA_ATTR_T (AGENDA_ATTR_ID, AGENDA_ID, ATTR_DEFN_ID, ATTR_VAL, VER_NBR)
  VALUES ('KS-KRMS-AGENDA-ATTR-10003', 'KS-KRMS-AGENDA-11926', 'KS-KRMS-ATTR-DEFN-10005', 'kuali.atp.type.Spring', 1)
/
