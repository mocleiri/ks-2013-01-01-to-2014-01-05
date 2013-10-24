--
-- KSLAB-2698 KS Permissions Config Bug: defaultPermissionTypeService being incorrectly used 
--
--
-- 
-- This SQL has been reviewed and vetted by UMD Rice team (wgomes) and UMD CM team (mikemcd) 
-- it performs several corrections to the KS-SYS krim types, perms, and perm_templates:
--
-- #0 Performing KS-SYS, KRIM TYP Service Name is null fix 
--    Sets defaultPermissionTypeService for all ks custom types where they are currently incorrectly null.
--     only Kuali Default krim type should have a null service name.
--    
-- This was only applied to enrollment but CM requires it.
-- https://jira.kuali.org/browse/KSENROLL-9987
--
--  Mike McD talked with Larry S. about this on Skype on Oct 24, '13
--  Will Gomes thought he had given this patch to Larry for CM but apparently we never actually 
--  filed a Jira (or it may have gotten rejected because by itself it breaks certain things).
--  However, when performed with the additional fixes below everything works.
--
-- #1 Renames some type names for greater clarity
--     At request of Will Gomes.
--
-- #2 Points KS Default Permission Type to defaultPermissionTypeService instead of permissionPermissionTypeService 
--    The later service does not appear to be implemented and defaultPermType works for what we need.
--
-- #3 Points the following permission templates at the Kuali Student defaultPermissionType 
--   (instead of Kuali default type which needs to have a null service name):
--    Comment on Document
--    Edit Document
--    Add Adhoc Reviewer
--    Add Collaborator Action
--
-- #4 Cleanup - updates some krim_perm_attr_data_t all the KS permissions screenComponent attrib_data that 
--    incorrectly claim they are associated with kim_typ 1 default type, they 
--    should be aligned with the kim type "KS Use Screen"  which is the same kim type the template 
--    they all are associated with ('Use Screen' perm template) uses.  This mapping is not creating 
--    an issue that we know of but is just wrong and should be corrected.
--
-- #5 Creates a New KS Edit Document Type
--    This type should have been in KS from the start.
--    Creates Permission Details for this type (documentTypeName and routeStatusCode)
--    Updates the KS edit Doc template to use our new KS Edit Document type   


-- #0
-- Set a service name for KS-SYS KRIM types that are currently Null
-- only Kuali Default type should be null.
--
UPDATE  KRIM_TYP_T SET SRVC_NM = 'defaultPermissionTypeService' WHERE NMSPC_CD = 'KS-SYS' and SRVC_NM IS NULL
/

-- #1
-- update name of kim type "Adhoc Permissions Type" for clarity
update krim_typ_t set nm = 'Adhoc Role Type: To give adhoc permissions' where nm='Adhoc Permissions Type' and nmspc_cd='KS-SYS'
/
-- update name of Kim type "KS permission" for clarity
update krim_typ_t set nm = 'KS Default Permission Type' where nm='KS Permission' and nmspc_cd='KS-SYS'
/

-- #2
update krim_typ_t set srvc_nm = 'defaultPermissionTypeService' where nm='KS Default Permission Type'  and nmspc_cd='KS-SYS'
/

-- #3
-- point these templates at the KS default perm Type instead of the Kuali default perm type.
update krim_perm_tmpl_t set kim_typ_id =(select kim_typ_id from krim_typ_t where nm = 'KS Default Permission Type') where nm in ('Comment on Document','Add Adhoc Reviewer','Add Collaborator Action') and nmspc_cd='KS-SYS'
/

-- #4  update perm attr data's link to kim_typ_id to "KS Use Screen" type where "screenComponent" is the krim_attr_defn
update krim_perm_attr_data_t perm_attr
set perm_attr.kim_typ_id = (select kim_typ_id from krim_typ_t where nm = 'KS Use Screen' and nmspc_cd='KS-SYS')
WHERE  perm_attr.kim_attr_defn_id = 
(select kim_attr_defn_id from krim_attr_defn_t where nm = 'screenComponent' and nmspc_cd = 'KS-SYS') 
AND perm_attr.perm_id in 
(select perm_id from krim_perm_t perm where 
  (perm.perm_id = perm_attr.perm_id) and 
  (perm.NMSPC_CD='KS-SYS'))
/

-- #5
-- New KS Edit Document Type, Attribs and re-pointing edit perm template

-- Create a new KS Edit Document type pointed at defaultPermissionTypeService Service
INSERT INTO KRIM_TYP_T (KIM_TYP_ID, OBJ_ID, VER_NBR, NM, SRVC_NM, ACTV_IND, NMSPC_CD) VALUES 
(KRIM_TYP_ID_S.NEXTVAL,  sys_guid(), 1, 'KS Edit Document Type', 'defaultPermissionTypeService', 'Y', 'KS-SYS')
/
-- Create a documentTypeName Permission Detail associated with our KS Edit Document Type
INSERT INTO KRIM_TYP_ATTR_T (ACTV_IND,KIM_ATTR_DEFN_ID,KIM_TYP_ATTR_ID,KIM_TYP_ID,OBJ_ID,SORT_CD,VER_NBR) VALUES 
('Y',(SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='documentTypeName' AND NMSPC_CD='KR-WKFLW'),
KRIM_TYP_ATTR_ID_S.NEXTVAL,(SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='KS Edit Document Type' AND NMSPC_CD='KS-SYS'),sys_guid(),'a',1)
/
-- Create a routeStatusCode Permission Detail associated with our KS Edit Document Type
INSERT INTO KRIM_TYP_ATTR_T (ACTV_IND,KIM_ATTR_DEFN_ID,KIM_TYP_ATTR_ID,KIM_TYP_ID,OBJ_ID,SORT_CD,VER_NBR) VALUES 
('Y',(SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NM='routeStatusCode' AND NMSPC_CD='KR-WKFLW'),
KRIM_TYP_ATTR_ID_S.NEXTVAL,(SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='KS Edit Document Type' AND NMSPC_CD='KS-SYS'),sys_guid(),'a',1)
/
-- Update the edit Doc template to use our new KS Edit Document type
UPDATE KRIM_PERM_TMPL_T SET KIM_TYP_ID=(SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NM='KS Edit Document Type' AND NMSPC_CD='KS-SYS') 
WHERE NM='Edit Document' AND NMSPC_CD='KS-SYS'
/

