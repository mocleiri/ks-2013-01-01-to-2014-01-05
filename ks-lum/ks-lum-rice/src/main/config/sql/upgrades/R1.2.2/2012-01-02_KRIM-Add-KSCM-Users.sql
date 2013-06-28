-- Create principal for KS system user
INSERT INTO KRIM_ENTITY_T (ACTV_IND,ENTITY_ID,OBJ_ID,VER_NBR)
  VALUES ('Y','5',SYS_GUID(),1)
/
INSERT INTO KRIM_PRNCPL_T (ACTV_IND,ENTITY_ID,OBJ_ID,PRNCPL_ID,PRNCPL_NM,VER_NBR)
  VALUES ('Y','5',SYS_GUID(),'5','ks',1)
/
INSERT INTO KRIM_ENTITY_ENT_TYP_T (ACTV_IND,ENTITY_ID,ENT_TYP_CD,OBJ_ID,VER_NBR)
  VALUES ('Y','5','SYSTEM',SYS_GUID(),1)
/

--Add KS System user to the Student System User Role
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('5','P',SYS_GUID(),(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM='Student System User Role'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/

-- Add admin user to KS-CM Admin and KS-CM User Roles
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('admin','P','KS_SYS_KS_CM_ROLE_MEMBER_26',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('admin','P','KS_SYS_KS_CMA_ROLE_MEMBER_27',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM='Kuali Student CM Admin'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/

--Add users to the KS-CM User Role
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('fred','P','KS_SYS_KS_CM_ROLE_MEMBER_1',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('fran','P','KS_SYS_KS_CM_ROLE_MEMBER_2',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('eric','P','KS_SYS_KS_CM_ROLE_MEMBER_3',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('edna','P','KS_SYS_KS_CM_ROLE_MEMBER_4',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('dev1','P','KS_SYS_KS_CM_ROLE_MEMBER_5',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('dev2','P','KS_SYS_KS_CM_ROLE_MEMBER_6',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('test1','P','KS_SYS_KS_CM_ROLE_MEMBER_7',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('test2','P','KS_SYS_KS_CM_ROLE_MEMBER_8',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser1','P','KS_SYS_KS_CM_ROLE_MEMBER_9',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser2','P','KS_SYS_KS_CM_ROLE_MEMBER_10',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser3','P','KS_SYS_KS_CM_ROLE_MEMBER_11',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser4','P','KS_SYS_KS_CM_ROLE_MEMBER_12',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser5','P','KS_SYS_KS_CM_ROLE_MEMBER_13',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser6','P','KS_SYS_KS_CM_ROLE_MEMBER_14',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser7','P','KS_SYS_KS_CM_ROLE_MEMBER_15',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser8','P','KS_SYS_KS_CM_ROLE_MEMBER_16',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('testuser9','P','KS_SYS_KS_CM_ROLE_MEMBER_17',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user1','P','KS_SYS_KS_CM_ROLE_MEMBER_18',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user2','P','KS_SYS_KS_CM_ROLE_MEMBER_19',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user3','P','KS_SYS_KS_CM_ROLE_MEMBER_20',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user4','P','KS_SYS_KS_CM_ROLE_MEMBER_21',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user5','P','KS_SYS_KS_CM_ROLE_MEMBER_22',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user6','P','KS_SYS_KS_CM_ROLE_MEMBER_23',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user7','P','KS_SYS_KS_CM_ROLE_MEMBER_24',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/
INSERT INTO KRIM_ROLE_MBR_T (MBR_ID,MBR_TYP_CD,OBJ_ID,ROLE_ID,ROLE_MBR_ID,VER_NBR) 
  VALUES ('user8','P','KS_SYS_KS_CM_ROLE_MEMBER_25',(SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD='KS-SYS' AND ROLE_NM='Kuali Student CM User'),KRIM_ROLE_MBR_ID_S.NEXTVAL,1)
/

