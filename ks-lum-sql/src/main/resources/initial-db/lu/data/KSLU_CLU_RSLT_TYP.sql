TRUNCATE TABLE KSLU_CLU_RSLT_TYP DROP STORAGE
/
INSERT ALL
  INTO KSLU_CLU_RSLT_TYP (EFF_DT,NAME,OBJ_ID,TYPE_DESC,TYPE_KEY,VER_NBR)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),'Certificate','812939CF237F4457BED0A6135AB739C9','Final learning result for a Certificate Program.','kuali.resultType.certificate',0)
  INTO KSLU_CLU_RSLT_TYP (EFF_DT,NAME,OBJ_ID,TYPE_DESC,TYPE_KEY,VER_NBR)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),'Final Credits','B76D726C8C184E0D9594F2A6FA4993F5','Final learning result for an LU. A stereotypical usage is the course credits.','kuali.resultType.creditCourseResult',0)
  INTO KSLU_CLU_RSLT_TYP (EFF_DT,NAME,OBJ_ID,TYPE_DESC,TYPE_KEY,VER_NBR)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),'Degree','A7EC40518F954C818C97A6D3EC8768A9','Final learning result for a degree','kuali.resultType.degree',0)
  INTO KSLU_CLU_RSLT_TYP (EFF_DT,NAME,OBJ_ID,TYPE_DESC,TYPE_KEY,VER_NBR)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),'Final Grade','10C75FAB3EB24D1DA7D0C87E63260C90','Final learning result for an LU. A stereotypical usage is the final grade in a course.','kuali.resultType.gradeCourseResult',0)
SELECT * FROM DUAL
/
