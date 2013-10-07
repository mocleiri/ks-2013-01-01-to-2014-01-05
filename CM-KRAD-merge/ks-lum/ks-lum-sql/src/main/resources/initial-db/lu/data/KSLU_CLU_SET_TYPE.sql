TRUNCATE TABLE KSLU_CLU_SET_TYPE DROP STORAGE
/
INSERT INTO KSLU_CLU_SET_TYPE (EFF_DT,NAME,TYPE_DESC,TYPE_KEY,VER_NBR)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),'Course Clu Set','Clu set for Courses','kuali.cluSet.type.CreditCourse',0)
/
INSERT INTO KSLU_CLU_SET_TYPE (EFF_DT,NAME,TYPE_DESC,TYPE_KEY,VER_NBR)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),'Program Clu Set','Clu set for programs','kuali.cluSet.type.Program',0)
/
INSERT INTO KSLU_CLU_SET_TYPE (EFF_DT,NAME,TYPE_DESC,TYPE_KEY,VER_NBR)
  VALUES (TO_DATE( '20100101000000', 'YYYYMMDDHH24MISS' ),'Test Clu Set','Clu set for Tests','kuali.cluSet.type.Test',0)
/
