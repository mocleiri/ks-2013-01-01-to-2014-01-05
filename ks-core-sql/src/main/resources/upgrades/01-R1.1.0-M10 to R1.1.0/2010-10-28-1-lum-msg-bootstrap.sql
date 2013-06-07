update KSMG_MESSAGE set MSG_VALUE='Propose a new course, start a new program, or find and review submitted proposals.' 
where MSG_ID='createDesc'
/
INSERT INTO KSMG_MESSAGE (GRP_NAME,ID,LOCALE,MSG_ID,MSG_VALUE,VER_NBR,OBJ_ID)
  VALUES ('validation','F541324F-BD0D-A2CC-1874-E7F36B73D8FD','en','reqActivate','Required for Activate','1','F541325E-D4A2-FAD3-52A6-129460B02DAB')
/
INSERT INTO KSMG_MESSAGE (GRP_NAME,ID,LOCALE,MSG_ID,MSG_VALUE,VER_NBR,OBJ_ID)
  VALUES ('validation','F542A334-9605-DF43-A3DB-8219006C138D','en','reqApproval','Required for Approval','1','F542A373-B5DF-7210-8FD8-1A60BC955FF5')
/
INSERT INTO KSMG_MESSAGE (GRP_NAME,ID,LOCALE,MSG_ID,MSG_VALUE,VER_NBR,OBJ_ID)
  VALUES ('validation','F542A344-E26D-2F2D-33E8-AC3EE8B9FC4B','en','reqDeactivate','Require for Deactivate','1','F542A382-FF7F-7F17-B97A-A52E203BDF65')
/