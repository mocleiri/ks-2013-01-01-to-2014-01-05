TRUNCATE TABLE KSDO_REF_REL_TYP_JN_SUB_TYP DROP STORAGE
/
INSERT ALL
  INTO KSDO_REF_REL_TYP_JN_SUB_TYP (REF_DOC_RELTN_TYPE_KEY,REF_OBJ_SUB_TYPE_KEY)
  VALUES ('kuali.org.DocRelation.allObjectTypes','kuali.org.RefObjectSubType.Program')
  INTO KSDO_REF_REL_TYP_JN_SUB_TYP (REF_DOC_RELTN_TYPE_KEY,REF_OBJ_SUB_TYPE_KEY)
  VALUES ('kuali.org.DocRelation.allObjectTypes','kuali.org.RefObjectSubType.Course')
  INTO KSDO_REF_REL_TYP_JN_SUB_TYP (REF_DOC_RELTN_TYPE_KEY,REF_OBJ_SUB_TYPE_KEY)
  VALUES ('kuali.org.DocRelation.allObjectTypes','kuali.org.RefObjectSubType.Proposal')
SELECT * FROM DUAL
/
