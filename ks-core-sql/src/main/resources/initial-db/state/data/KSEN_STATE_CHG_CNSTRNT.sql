TRUNCATE TABLE KSEN_STATE_CHG_CNSTRNT DROP STORAGE
/
INSERT ALL
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.activityoffering.approved.offered','kuali.stateconstraint.activityoffering.approved.offered')
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.courseoffering.draft.planned','kuali.stateconstraint.courseoffering.draft.planned')
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.courseoffering.planned.draft','kuali.stateconstraint.courseoffering.planned.draft')
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.courseoffering.planned.offered','kuali.stateconstraint.courseoffering.planned.offered')
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.formatoffering.draft.planned','kuali.stateconstraint.formatoffering.draft.planned')
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.formatoffering.planned.draft','kuali.stateconstraint.formatoffering.planned.draft')
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.formatoffering.planned.offered','kuali.stateconstraint.formatoffering.planned.offered')
  INTO KSEN_STATE_CHG_CNSTRNT (STATE_CHG_ID,STATE_CNSTRNT_ID)
  VALUES ('kuali.statechange.registrationgroup.pending.offered','kuali.stateconstraint.registrationgroup.pending.offered')
SELECT * FROM DUAL
/
