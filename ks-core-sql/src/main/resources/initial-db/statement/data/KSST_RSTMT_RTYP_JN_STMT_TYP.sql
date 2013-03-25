TRUNCATE TABLE KSST_RSTMT_RTYP_JN_STMT_TYP DROP STORAGE
/
INSERT ALL
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.antirequisites','kuali.statement.type.course.academicReadiness.antireq')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.corequisites','kuali.statement.type.course.academicReadiness.coreq')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.prerequisites','kuali.statement.type.course.academicReadiness.prereq')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.eligibilitiesandprerequisites','kuali.statement.type.course.academicReadiness.studentEligibilityPrereq')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.credit.repeatable','kuali.statement.type.course.credit.repeatable')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.credit.restriction','kuali.statement.type.course.credit.restriction')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.recommendedpreparation','kuali.statement.type.course.recommendedPreparation')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.completion','kuali.statement.type.program.completion')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.entrance','kuali.statement.type.program.entrance')
  INTO KSST_RSTMT_RTYP_JN_STMT_TYP (REF_STMT_REL_TYPE_ID,STMT_TYPE_ID)
  VALUES ('clu.satisfactoryprogress','kuali.statement.type.program.satisfactoryProgress')
SELECT * FROM DUAL
/
