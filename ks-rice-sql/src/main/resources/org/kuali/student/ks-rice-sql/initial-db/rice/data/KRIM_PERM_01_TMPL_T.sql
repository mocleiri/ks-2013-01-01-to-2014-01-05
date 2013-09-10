INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Field Permission Type' AND NMSPC_CD = 'KS-SYS'), 'Field Access', 'KS-SYS', 'DCBA154A16824CA4B4575E7501F213D7', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', 'Used to create KS screen permissions', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'KS Use Screen' AND NMSPC_CD = 'KS-SYS'), 'Use Screen', 'KS-SYS', 'B1B7AF348A774BBAB697DC96484024E4', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', 'Used to define what actions a user can assign to collaborators', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Default' AND NMSPC_CD = 'KUALI'), 'Add Collaborator Action', 'KS-SYS', '2DB829B5913844329EE3807EEDF775A1', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Document Type and Route Node' AND NMSPC_CD = 'KS-SYS'), 'Open Document', 'KS-SYS', '7F4307DC63294E1395A1F3BA0224A19B', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', 'View/Maintain Agenda', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Namespace' AND NMSPC_CD = 'KR-NS'), 'KRMS Agenda Permission', 'KS-SYS', 'D2F07FCB2D6EFFC9E040760A4A45207E', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Field Permission Type' AND NMSPC_CD = 'KS-SYS'), 'Access Permission', 'KS-SYS', 'AC27A267ET5CAA7E0404F81EEOO30AA', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Section Maintenance Permission Type' AND NMSPC_CD = 'KS-SYS'), 'Section Maintenance', 'KS-SYS', 'AC27A267ET5CAA7E0404F81EE3O30AA', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Reference Type Permission' AND NMSPC_CD = 'KS-SYS'), 'Comment on Document', 'KS-SYS', '5ADF18B6D4857954W0404F818SD85002', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Default' AND NMSPC_CD = 'KUALI'), 'Edit Document', 'KS-SYS', '5ADF18B6D4857S54EW404F8189D85002', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Reference Type Permission' AND NMSPC_CD = 'KS-SYS'), 'Upload to Document', 'KS-SYS', '50DF1801D4857954W0404F818SD85002', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Default' AND NMSPC_CD = 'KUALI'), 'Add Adhoc Reviewer', 'KS-SYS', '50DF1801D4857954W0404F818SD85033', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Document Type & Routing Node or State' AND NMSPC_CD = 'KR-SYS'), 'Withdraw Document', 'KS-SYS', 'A0DF1801D4857954W0404F818SD85033', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Document Type (Permission)' AND NMSPC_CD = 'KR-SYS'), 'Remove Reviewers', 'KS-SYS', 'A0DF1801D4857954W0404F818SDA5033', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
INSERT INTO KRIM_PERM_TMPL_T (ACTV_IND, DESC_TXT, KIM_TYP_ID, NM, NMSPC_CD, OBJ_ID, PERM_TMPL_ID, VER_NBR)
  VALUES ('Y', null, (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM = 'Document Type & Routing Node or State' AND NMSPC_CD = 'KR-SYS'), 'Blanket Approve', 'KS-SYS', 'A0DF1801D4857954W0404F818SDB5033', CONCAT('KS-', KS_RICE_ID_S.NEXTVAL), 1)
/
