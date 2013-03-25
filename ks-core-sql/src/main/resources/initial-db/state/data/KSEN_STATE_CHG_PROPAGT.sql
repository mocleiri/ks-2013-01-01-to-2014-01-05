TRUNCATE TABLE KSEN_STATE_CHG_PROPAGT DROP STORAGE
/
INSERT ALL
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.activityoffering.approved.draft','kuali.statepropagation.aotofo.approved.draft')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.activityoffering.approved.offered','kuali.statepropagation.aotofo.approved.offered')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.activityoffering.approved.offered','kuali.statepropagation.aotorg.approved.offered')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.activityoffering.draft.approved','kuali.statepropagation.aotofo.draft.approved')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.atp.draft.official','kuali.statepropagation.atpToMilestone.draft.official')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.formatoffering.draft.planned','kuali.statepropagation.fotoco.draft.planned')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.formatoffering.planned.draft','kuali.statepropagation.fotoco.planned.draft')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.formatoffering.planned.offered','kuali.statepropagation.fotoco.planned.offered')
  INTO KSEN_STATE_CHG_PROPAGT (STATE_CHG_ID,STATE_PROPAGT_ID)
  VALUES ('kuali.statechange.soc.publishing.published','kuali.statepropagation.soctoao.published.offered')
SELECT * FROM DUAL
/
