insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values ('KS-KRIM-PERM-1067', SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KS-ENR'), 'KS-ENR', 'View Search Result Group for manageCourseOfferingsPage', 'Allows the user to View Search Result Group for manageCourseOfferingsPage', 'Y')
/
insert into KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND) values ('KS-KRIM-PERM-1068', SYS_GUID(), 1, (SELECT perm_tmpl_id FROM krim_perm_tmpl_t where nm = 'View Group' and nmspc_cd = 'KS-ENR'), 'KS-ENR', 'View Search Result Group for manageCourseOfferingsPage Admin', 'Allows the user to View Search Result Group for manageCourseOfferingsPage Admin', 'Y')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values ('KS-KRIM-PERM-ATTR-DATA-1156', SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT kim_attr_defn_id from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'searchResultSection')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values ('KS-KRIM-PERM-ATTR-DATA-1157', SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT kim_attr_defn_id from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'courseOfferingManagementView')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values ('KS-KRIM-PERM-ATTR-DATA-1158', SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT kim_attr_defn_id from krim_attr_defn_t where nm = 'permissionExpression' and nmspc_cd = 'KS-ENR'), '#socState!="draft"')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values ('KS-KRIM-PERM-ATTR-DATA-1159', SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage Admin' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT kim_attr_defn_id from krim_attr_defn_t where nm = 'groupId' and nmspc_cd = 'KR-KRAD'), 'searchResultSection')
/
insert into KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL) values ('KS-KRIM-PERM-ATTR-DATA-1160', SYS_GUID(), 1, (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage Admin' and nmspc_cd = 'KS-ENR'), (SELECT kim_typ_id from krim_typ_t where nm = 'Default' and nmspc_cd = 'KUALI'), (SELECT kim_attr_defn_id from krim_attr_defn_t where nm = 'viewId' and nmspc_cd = 'KR-KRAD'), 'courseOfferingManagementView')
/
insert into KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND) values ('KS-KRIM-ROLE-PERM-1071', SYS_GUID(), 1, (SELECT ROLE_ID FROM KRIM_ROLE_T where ROLE_NM = 'KS Department Schedule Coordinator - Org' and nmspc_cd = 'KS-ENR'), (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage' and nmspc_cd = 'KS-ENR'), 'Y')
/
insert into KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND) values ('KS-KRIM-ROLE-PERM-1072', SYS_GUID(), 1, (SELECT ROLE_ID FROM KRIM_ROLE_T where ROLE_NM = 'KS Department Schedule Coordinator - Org View Only' and nmspc_cd = 'KS-ENR'), (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage' and nmspc_cd = 'KS-ENR'), 'Y')
/
insert into KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND) values ('KS-KRIM-ROLE-PERM-1073', SYS_GUID(), 1, (SELECT ROLE_ID FROM KRIM_ROLE_T where ROLE_NM = 'KS Schedule Coordinator' and nmspc_cd = 'KS-ENR'), (SELECT perm_id from krim_perm_t where nm = 'View Search Result Group for manageCourseOfferingsPage Admin' and nmspc_cd = 'KS-ENR'), 'Y')
/
