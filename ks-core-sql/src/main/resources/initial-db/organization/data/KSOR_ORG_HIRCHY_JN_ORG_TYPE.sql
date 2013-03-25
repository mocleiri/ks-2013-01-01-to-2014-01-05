TRUNCATE TABLE KSOR_ORG_HIRCHY_JN_ORG_TYPE DROP STORAGE
/
INSERT ALL
  INTO KSOR_ORG_HIRCHY_JN_ORG_TYPE (ORG_HIRCHY_ID,ORG_TYPE_ID)
  VALUES ('kuali.org.hierarchy.Curriculum','kuali.org.COC')
  INTO KSOR_ORG_HIRCHY_JN_ORG_TYPE (ORG_HIRCHY_ID,ORG_TYPE_ID)
  VALUES ('kuali.org.hierarchy.Curriculum','kuali.org.College')
  INTO KSOR_ORG_HIRCHY_JN_ORG_TYPE (ORG_HIRCHY_ID,ORG_TYPE_ID)
  VALUES ('kuali.org.hierarchy.Curriculum','kuali.org.Department')
  INTO KSOR_ORG_HIRCHY_JN_ORG_TYPE (ORG_HIRCHY_ID,ORG_TYPE_ID)
  VALUES ('kuali.org.hierarchy.Curriculum','kuali.org.Division')
  INTO KSOR_ORG_HIRCHY_JN_ORG_TYPE (ORG_HIRCHY_ID,ORG_TYPE_ID)
  VALUES ('kuali.org.hierarchy.Curriculum','kuali.org.Program')
  INTO KSOR_ORG_HIRCHY_JN_ORG_TYPE (ORG_HIRCHY_ID,ORG_TYPE_ID)
  VALUES ('kuali.org.hierarchy.Curriculum','kuali.org.Senate')
SELECT * FROM DUAL
/
