-- Add LPR instructor state lifecycle
insert into KSEN_STATE_LIFECYCLE (ID, OBJ_ID, NAME, DESCR_PLAIN, DESCR_FORMATTED, REF_OBJECT_URI, VER_NBR, CREATETIME, CREATEID, UPDATETIME, UPDATEID) values ('kuali.lpr.lifecycle.instructor.course.assignment', null, 'kuali.lpr.lifecycle.instructor.course.assignment', 'kuali.lpr.lifecycle.instructor.course.assignment state lifecycle', 'kuali.lpr.lifecycle.instructor.course.assignment state lifecycle', null, 1, TIMESTAMP '2012-03-01 00:00:00', 'SYSTEMLOADER', null, null)
/

-- Add LPR instructor states
insert into KSEN_STATE (ID, OBJ_ID, NAME, DESCR_PLAIN, DESCR_FORMATTED, LIFECYCLE_KEY, EFF_DT, EXPIR_DT, VER_NBR, CREATETIME, CREATEID, UPDATETIME, UPDATEID) values ('kuali.lpr.state.tentative', null, 'Tentative', 'The instructor is proposed to teach this course or section but it has not yet been confirmed', 'The instructor is proposed to teach this course or section but it has not yet been confirmed', 'kuali.lpr.lifecycle.instructor.course.assignment', null, null, 1, TIMESTAMP '1970-01-01 00:00:00', 'SYSTEMLOADER', TIMESTAMP '1970-01-01 00:00:00', 'SYSTEMLOADER')
/
insert into KSEN_STATE (ID, OBJ_ID, NAME, DESCR_PLAIN, DESCR_FORMATTED, LIFECYCLE_KEY, EFF_DT, EXPIR_DT, VER_NBR, CREATETIME, CREATEID, UPDATETIME, UPDATEID) values ('kuali.lpr.state.assigned', null, 'Assigned', 'The instructor is assigned to teach this course or section', 'The instructor is assigned to teach this course or section', 'kuali.lpr.lifecycle.instructor.course.assignment', null, null, 1, TIMESTAMP '1970-01-01 00:00:00', 'SYSTEMLOADER', TIMESTAMP '1970-01-01 00:00:00', 'SYSTEMLOADER')
/
insert into KSEN_STATE (ID, OBJ_ID, NAME, DESCR_PLAIN, DESCR_FORMATTED, LIFECYCLE_KEY, EFF_DT, EXPIR_DT, VER_NBR, CREATETIME, CREATEID, UPDATETIME, UPDATEID) values ('kuali.lpr.state.unassigned', null, 'Unassigned', 'The instructor had been assigned but then that assignment was removed', 'The instructor had been assigned but then that assignment was removed', 'kuali.lpr.lifecycle.instructor.course.assignment', null, null, 1, TIMESTAMP '1970-01-01 00:00:00', 'SYSTEMLOADER', TIMESTAMP '1970-01-01 00:00:00', 'SYSTEMLOADER')
/