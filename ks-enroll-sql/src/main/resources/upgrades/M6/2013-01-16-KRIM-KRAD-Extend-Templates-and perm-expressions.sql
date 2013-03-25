
--Redefine the types and point them to new custom ks services
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View', 'ksViewPermissionTypeService', 'Y', 'KS-ENR')
/
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View Edit Mode', 'ksViewEditModePermissionTypeService', 'Y', 'KS-ENR')
/
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View Field', 'ksViewFieldPermissionTypeService', 'Y', 'KS-ENR')
/
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View Group', 'ksViewGroupPermissionTypeService', 'Y', 'KS-ENR')
/
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View Widget', 'ksViewWidgetPermissionTypeService', 'Y', 'KS-ENR')
/
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View Action', 'ksViewActionPermissionTypeService', 'Y', 'KS-ENR')
/
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View Line Field', 'ksViewLineFieldPermissionTypeService', 'Y', 'KS-ENR')
/
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'View Line Action', 'ksViewLineActionPermissionTypeService', 'Y', 'KS-ENR')
/

--Redefine the type attributes to our new types
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='actionEvent' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='actionId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Edit Mode' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='editMode' and NMSPC_CD='KR-NS'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Edit Mode' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='fieldId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='propertyName' and NMSPC_CD='KR-NS'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Group' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Group' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='fieldId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Group' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='groupId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='actionEvent' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='collectionPropertyName' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='groupId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Action' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='actionId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='collectionPropertyName' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='fieldId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='groupId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Field' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='propertyName' and NMSPC_CD='KR-NS'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Widget' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='viewId' and NMSPC_CD='KR-KRAD'), 'Y')
/
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'b', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Widget' AND NMSPC_CD='KS-ENR'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='widgetId' and NMSPC_CD='KR-KRAD'), 'Y')
/


--Duplicate all the permission templates with a new namespace
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Open View', 'Open View', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Edit View', 'Edit View', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Use View', 'Use View', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Edit Mode' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'View Field', 'View Field', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Field' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Edit Field', 'Edit Field', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Field' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'View Group', 'View Group', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Group' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Edit Group', 'Edit Group', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Group' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'View Widget', 'View Widget', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Widget' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Edit Widget', 'Edit Widget', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Widget' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Perform Action', 'Perform Action', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Action' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'View Line', 'View Line', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Field' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Edit Line', 'Edit Line', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Field' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'View Line Field', 'View Line Field', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Field' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Edit Line Field', 'Edit Line Field', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Field' AND NMSPC_CD='KS-ENR'), 'Y')
/
insert into KRIM_PERM_TMPL_T (PERM_TMPL_ID, OBJ_ID, VER_NBR, NMSPC_CD, NM, DESC_TXT, KIM_TYP_ID, ACTV_IND) values (KRIM_PERM_TMPL_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS-ENR', 'Perform Line Action', 'Perform Line Action', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='View Line Action' AND NMSPC_CD='KS-ENR'), 'Y')
/

--New KIM Type (note no kim type service)
insert into KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) values (KRIM_TYP_ID_S.NEXTVAL, SYS_GUID(), 1, 'KS ENR Permission Expression', '', 'Y', 'KS-ENR')
/
--New Attribute Definition
insert into KRIM_ATTR_DEFN_T (KIM_ATTR_DEFN_ID, OBJ_ID, VER_NBR, NM, LBL, ACTV_IND, NMSPC_CD, CMPNT_NM) values (KRIM_ATTR_DEFN_ID_S.NEXTVAL, SYS_GUID(), 1, 'permissionExpression', 'Permission Expression', 'Y', 'KS-ENR', 'org.kuali.rice.student.bo.KualiStudentKimAttributes')
/
--Join attribute to type
insert into KRIM_TYP_ATTR_T (KIM_TYP_ATTR_ID, OBJ_ID, VER_NBR, SORT_CD, KIM_TYP_ID, KIM_ATTR_DEFN_ID,ACTV_IND) values (KRIM_TYP_ATTR_ID_S.NEXTVAL, SYS_GUID(), 1, 'a', (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='KS ENR Permission Expression'), (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='permissionExpression' and NMSPC_CD='KS-ENR'), 'Y')
/

--update existing KRAD permissions to use new templates
UPDATE
    KRIM_PERM_T up
SET
    up.PERM_TMPL_ID =
    (
        SELECT
            pt_new.PERM_TMPL_ID
        FROM
            KRIM_PERM_TMPL_T pt_old,
            KRIM_PERM_TMPL_T pt_new
        WHERE
            pt_old.PERM_TMPL_ID=up.PERM_TMPL_ID
        AND pt_old.NMSPC_CD='KR-KRAD' --Old Template namespace
        AND pt_new.NM=pt_old.NM
        AND pt_new.NMSPC_CD='KS-ENR' --New Template namespace
        AND up.NMSPC_CD='KS-ENR' --permission namespace
    )
WHERE
    EXISTS
    (
        SELECT
            pt_old.PERM_TMPL_ID
        FROM
            KRIM_PERM_TMPL_T pt_old
        WHERE
            pt_old.PERM_TMPL_ID=up.PERM_TMPL_ID
        AND pt_old.NMSPC_CD='KR-KRAD'--Old Template namespace
        AND up.NMSPC_CD='KS-ENR'--permission namespace
    )
/
