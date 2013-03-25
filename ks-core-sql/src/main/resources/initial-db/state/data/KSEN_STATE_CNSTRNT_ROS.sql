TRUNCATE TABLE KSEN_STATE_CNSTRNT_ROS DROP STORAGE
/
INSERT ALL
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.activity.offering.scheduling.state.exempt','kuali.stateconstraint.activityoffering.approved.offered')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.activity.offering.scheduling.state.scheduled','kuali.stateconstraint.activityoffering.approved.offered')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.activity.offering.state.approved','kuali.stateconstraint.formatoffering.draft.planned')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.activity.offering.state.approved','kuali.stateconstraint.formatoffering.planned.draft')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.activity.offering.state.offered','kuali.stateconstraint.formatoffering.planned.offered')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.activity.offering.state.offered','kuali.stateconstraint.registrationgroup.pending.offered')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.format.offering.state.offered','kuali.stateconstraint.courseoffering.planned.offered')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.format.offering.state.planned','kuali.stateconstraint.courseoffering.draft.planned')
  INTO KSEN_STATE_CNSTRNT_ROS (REL_OBJ_STATE_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.lui.format.offering.state.planned','kuali.stateconstraint.courseoffering.planned.draft')
SELECT * FROM DUAL
/
