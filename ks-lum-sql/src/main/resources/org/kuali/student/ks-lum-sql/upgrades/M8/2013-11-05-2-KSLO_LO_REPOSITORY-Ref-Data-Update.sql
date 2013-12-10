--
-- **************************************
-- **************************************
--	This is just a custom test script that is being used while developing Learning Objectives in the Curriculum Management KRAD Conversion project.
--	This is NOT an official sql script.
-- **************************************
-- **************************************
--

--TRUNCATE TABLE KSLO_LO_REPOSITORY DROP STORAGE
--/
INSERT INTO KSLO_LO_REPOSITORY (EFF_DT,ID,NAME,OBJ_ID,RT_DESCR_ID,VER_NBR)
  VALUES (TO_DATE( '20080101000000', 'YYYYMMDDHH24MISS' ),'kuali.loRepository.key.institution','Institution','AFDB79EC47CA4B949DB4E3D4002BAD7E','RICHTEXT-18',0)
/
INSERT INTO KSLO_LO_REPOSITORY (EFF_DT,ID,NAME,OBJ_ID,RT_DESCR_ID,VER_NBR)
  VALUES (TO_DATE( '20080101000000', 'YYYYMMDDHH24MISS' ),'kuali.loRepository.key.singleUse','singleUse','16A480F0E36F49D9AC5E645B7554387B','RICHTEXT-10',0)
/
INSERT INTO KSLO_LO_REPOSITORY (EFF_DT,ID,NAME,OBJ_ID,RT_DESCR_ID,VER_NBR)
  VALUES (TO_DATE( '20080101000000', 'YYYYMMDDHH24MISS' ),'kuali.loRepository.key.state','State','0FCE13F58BB84C4585056792E251B151','RICHTEXT-22',0)
/