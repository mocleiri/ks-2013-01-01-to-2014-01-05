--
-- Copyright 2011 The Kuali Foundation Licensed under the
-- Educational Community License, Version 2.0 (the "License"); you may
-- not use this file except in compliance with the License. You may
-- obtain a copy of the License at
--
-- http://www.osedu.org/licenses/ECL-2.0
--
-- Unless required by applicable law or agreed to in writing,
-- software distributed under the License is distributed on an "AS IS"
-- BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
-- or implied. See the License for the specific language governing
-- permissions and limitations under the License.
--


//AtpEntity
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testAtpId1', 'testAtp1', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Draft', 'Desc 101', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testAtpId2', 'testAtp2', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.HolidayCalendar', 'kuali.atp.state.Draft', 'Desc 102', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testDeleteAtpId1', 'testDeleteAtp1', {ts '2012-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.HolidayCalendar', 'kuali.atp.state.Draft', 'Desc 103', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testDeleteAtpId2', 'testDeleteAtp2', {ts '2012-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.HolidayCalendar', 'kuali.atp.state.Draft', 'Desc 104', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testTermId1', 'testTerm1', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.Fall', 'kuali.atp.state.Draft', 'Desc 2', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testTermId2', 'testTerm2', {ts '2000-01-01 00:00:00.0'}, {ts '2100-12-31 00:00:00.0'}, 'kuali.atp.type.Spring', 'kuali.atp.state.Draft', 'Desc 3', 0)


// AtpAttributeEntity - can''t get this to execute for some reason
INSERT INTO KSEN_ATP_ATTR (ID, ATTR_KEY, ATTR_VALUE, OWNER_ID) VALUES ('testAtpAttr1', 'CredentialProgramType', 'kuali.lu.type.credential.Baccalaureate', 'testAtpId1')

// AtpAtpRelationEntity
//INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPATPREL-1', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.associated', 'testAtpId2')
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPATPREL-2', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.includes', 'testTermId1')
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPATPREL-3', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testTermId1', 'kuali.atp.atp.relation.includes', 'testTermId2')
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPATPREL-4', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.includes', 'testDeleteAtpId1')
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPATPREL-5', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'testAtpId1', 'kuali.atp.atp.relation.includes', 'testDeleteAtpId2')

// MilestoneEntity
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testId', 'testId', {ts '2011-07-10 00:00:00.0'}, {ts '2011-07-20 00:00:00.0'}, 'kuali.atp.milestone.AdvanceRegistrationPeriod', 'kuali.milestone.state.Draft', 0, 0, 1, 0, NULL, 'Desc 105', 0)
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testId2', 'testId2', {ts '2011-08-01 00:00:00.0'}, {ts '2011-10-01 00:00:00.0'}, 'kuali.atp.milestone.RegistrationPeriod', 'kuali.milestone.state.Draft', 0, 0, 1, 0, NULL, 'Desc 106', 0)
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testId3', 'testId3', {ts '2011-11-01 00:00:00.0'}, {ts '2011-11-01 00:00:00.0'}, 'kuali.atp.milestone.DropDate', 'kuali.milestone.state.Draft', 0, 1, 0, 1, NULL, 'Desc 107', 0)
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testDeleteId', 'testDeleteId', {ts '2011-11-01 00:00:00.0'}, {ts '2011-12-01 00:00:00.0'}, 'kuali.atp.milestone.RegistrationPeriod', 'kuali.milestone.state.Draft',0, 0, 0, 0, NULL, 'Desc 108', 0)

// AtpMilestoneRelationEntity
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPMSTONEREL-1', 0, 'testAtpId1', 'testId')
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPMSTONEREL-2', 0, 'testAtpId2', 'testId2')
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPMSTONEREL-3', 0, 'testDeleteAtpId1', 'testId')
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ATPMSTONEREL-4', 0, 'testDeleteAtpId2', 'testId2')

// Term Atps for testing
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingTerm1', 'testingTerm1', {ts '2000-09-01 00:00:00.0'}, {ts '2000-12-31 00:00:00.0'}, 'kuali.atp.type.Fall', 'kuali.atp.state.Draft', 'Desc term rich text 1', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingTerm2', 'testingTerm2', {ts '2001-01-01 00:00:00.0'}, {ts '2001-05-31 00:00:00.0'}, 'kuali.atp.type.Spring', 'kuali.atp.state.Draft', 'Desc term rich text 2', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingTerm3', 'testingTerm3', {ts '2000-09-01 00:00:00.0'}, {ts '2000-12-31 00:00:00.0'}, 'kuali.atp.type.Fall', 'kuali.atp.state.Official', 'Desc term rich text 7', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingTerm4', 'testingTerm4', {ts '2011-01-01 00:00:00.0'}, {ts '2011-05-31 00:00:00.0'}, 'kuali.atp.type.HalfFall1', 'kuali.atp.state.Draft', 'Desc term rich text 8', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingTermDelete', 'testingTermDelete', {ts '2031-01-01 00:00:00.0'}, {ts '2031-05-31 00:00:00.0'}, 'kuali.atp.type.HalfFall1', 'kuali.atp.state.Draft', 'Desc term rich text 9', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingTerm5', 'testingTerm3', {ts '2000-09-01 00:00:00.0'}, {ts '2000-12-31 00:00:00.0'}, 'kuali.atp.type.Fall', 'kuali.atp.state.Official', 'Desc term rich text 10', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingTerm6', 'testingTerm4', {ts '2011-01-01 00:00:00.0'}, {ts '2011-05-31 00:00:00.0'}, 'kuali.atp.type.HalfFall2', 'kuali.atp.state.Draft', 'Desc term rich text 11', 0)

INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingAcal1', 'testingAcal1', {ts '2000-09-01 00:00:00.0'}, {ts '2001-06-01 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Draft', 'Desc term rich text 3', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'termRelationTestingAcal2', 'testingAcal2', {ts '2001-09-01 00:00:00.0'}, {ts '2002-06-01 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Draft', 'Desc term rich text 4', 0)

INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testKeyDate1', 'testKeyDate1', {ts '2001-09-10 00:00:00.0'}, {ts '2001-09-20 00:00:00.0'}, 'kuali.atp.milestone.AdvanceRegistrationPeriod', 'kuali.milestone.state.Draft', 0, 0, 1, 0, NULL, 'Desc term rich text 5', 0)
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'testKeyDate2', 'testKeyDate2', {ts '2001-08-01 00:00:00.0'}, {ts '2001-10-01 00:00:00.0'}, 'kuali.atp.milestone.RegistrationPeriod', 'kuali.milestone.state.Draft', 0, 0, 1, 0, NULL, 'Desc term rich text 6', 0)

// Term to Term AtpAtpRelations for testing
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'termRelationTestingRel-TermTerm-1', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'termRelationTestingTerm1', 'kuali.atp.atp.relation.includes', 'termRelationTestingTerm2')
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'termRelationTestingRel-TermTerm-2', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'termRelationTestingTerm3', 'kuali.atp.atp.relation.includes', 'termRelationTestingTerm4')

// Acal to Term AtpAtpRelations for testing
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'termRelationTestingRel-AcalTerm-1', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'termRelationTestingAcal1', 'kuali.atp.atp.relation.includes', 'termRelationTestingTerm1')
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, EXPIR_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'termRelationTestingRel-AcalTerm-2', 0, {ts '2011-01-01 00:00:00.0'}, {ts '2100-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'termRelationTestingAcal2', 'kuali.atp.atp.relation.includes', 'termRelationTestingTerm2')

// Term to KeyDate AtpMilestoneRelations for testing
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'termRelationTestingRel-TermDate-1', 0, 'termRelationTestingTerm1', 'testKeyDate1')

// Acedemic calendars for range testing
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId1', 'testEdgeAtpId1', {ts '1980-06-01 00:00:00.0'}, {ts '1980-06-30 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2001', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId2', 'testEdgeAtpId2', {ts '1979-12-01 00:00:00.0'}, {ts '1981-01-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2002', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId3', 'testEdgeAtpId3', {ts '1979-12-01 00:00:00.0'}, {ts '1980-01-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2003', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId4', 'testEdgeAtpId4', {ts '1980-12-01 00:00:00.0'}, {ts '1981-01-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2004', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId5', 'testEdgeAtpId5', {ts '1979-12-01 00:00:00.0'}, {ts '1980-01-01 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2005', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId6', 'testEdgeAtpId6', {ts '1980-12-31 00:00:00.0'}, {ts '1981-01-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2006', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId7', 'testEdgeAtpId7', {ts '1980-01-01 00:00:00.0'}, {ts '1980-06-30 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2007', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId8', 'testEdgeAtpId8', {ts '1980-06-01 00:00:00.0'}, {ts '1980-12-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2008', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId9', 'testEdgeAtpId9', {ts '1979-12-01 00:00:00.0'}, {ts '1979-12-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2009', 0)
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'testEdgeAtpId10', 'testEdgeAtpId10', {ts '1981-01-01 00:00:00.0'}, {ts '1981-01-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', 'Desc 2010', 0)



// Academic Calendar
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'ACADEMICCALENDAR1990', '1990 Academic Calendar', {ts '1990-08-01 00:00:00.0'}, {ts '1991-12-31 00:00:00.0'}, 'kuali.atp.type.AcademicCalendar', 'kuali.atp.state.Official', '1990 Academic Calendar', 0)
// Fall Term
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'FALLTERM1990', 'Fall Term 1990', {ts '1990-08-01 00:00:00.0'}, {ts '1990-12-31 00:00:00.0'}, 'kuali.atp.type.Fall', 'kuali.atp.state.Official', 'Fall Term 1990', 0)
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ACADEMICCALENDAR1990FALLTERM1990RELATION', 0, {ts '1988-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'ACADEMICCALENDAR1990', 'kuali.atp.atp.relation.includes', 'FALLTERM1990')
// Term Key Dates
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990COMMENCEMENT', 'Fall Commencement 1990', {ts '1990-12-15 10:00:00.0'}, {ts '1990-12-15 11:00:00.0'}, 'kuali.atp.milestone.Commencement', 'kuali.milestone.state.Official',  0, 0, 0, 0, NULL, 'Commencement', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990COMMENCEMENTRELATION', 0, 'FALLTERM1990', 'FALLTERM1990COMMENCEMENT')
// Term Registration Date Group
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990REGISTRATION', 'Fall Term Registration Period', {ts '1990-08-01 00:00:00.0'}, {ts '1990-09-09 00:00:00.0'}, 'kuali.atp.milestone.RegistrationPeriod', 'kuali.milestone.state.Official', 0, 0, 1, 0, NULL, 'Fall 1990 Registration', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990REGISTRATIONRELATION', 0, 'FALLTERM1990', 'FALLTERM1990REGISTRATION')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990COURSESELECTIONEND', 'Fall Term Course Selection Period Ends', {ts '1990-09-10 00:00:00.0'}, {ts '1990-09-10 00:00:00.0'}, 'kuali.atp.milestone.CourseSelectionPeriodEnd', 'kuali.milestone.state.Official', 0, 0, 0, 0, NULL, 'Fall Course Selection', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990COURSESELECTIONENDRELATION', 0, 'FALLTERM1990', 'FALLTERM1990COURSESELECTIONEND')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990INSTRUCTIONPERIOD', 'Fall Term Instructional Period', {ts '1990-09-03 00:00:00.0'}, {ts '1990-12-01 00:00:00.0'}, 'kuali.atp.milestone.InstructionalPeriod', 'kuali.milestone.state.Official', 0, 0, 1, 0, NULL, 'Instruction Period', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990INSTRUCTIONPERIODRELATION', 0, 'FALLTERM1990', 'FALLTERM1990INSTRUCTIONPERIOD')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990DROPDATE', 'Drop Deadlin', {ts '1990-09-10 00:00:00.0'}, {ts '1990-09-10 00:00:00.0'}, 'kuali.atp.milestone.DropDate', 'kuali.milestone.state.Official',0, 0, 0, 0, NULL, 'Deadline to Drop Fall Term Classes', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR,  ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990DROPDATERELATION', 0, 'FALLTERM1990', 'FALLTERM1990DROPDATE')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FINALS', 'Fall Finals', {ts '1990-12-10 00:00:00.0'}, {ts '1990-12-15 00:00:00.0'}, 'kuali.atp.milestone.FinalExamPeriod', 'kuali.milestone.state.Official', 0, 1, 1, 0, NULL, 'Fall Finals', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990FINALSRELATION', 0, 'FALLTERM1990', 'FALLTERM1990FINALS')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990GRADESDUE', 'Fall Grades Due', {ts '1990-12-15 00:00:00.0'}, {ts '1990-12-22 00:00:00.0'}, 'kuali.atp.milestone.GradesDue', 'kuali.milestone.state.Official', 0, 0, 1, 0, NULL, 'Grades Due', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990GRADESDUERELATION', 0, 'FALLTERM1990', 'FALLTERM1990GRADESDUE')
// Census Date (relative milestone, last business day of the second week of the quarter, based on Term Start)
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990CENSUS', 'Fall Term Census', {ts '1990-09-24 00:00:00.0'}, {ts '1990-09-25 00:00:00.0'}, 'kuali.atp.milestone.FinancialAidCensus', 'kuali.milestone.state.Official', 0, 1, 0, 1, 'FALLTERM1990INSTRUCTIONPERIOD', 'Census', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLTERM1990FALLTERM1990CENSUSRELATION', 0, 'FALLTERM1990', 'FALLTERM1990CENSUS')
// Holiday Calendar
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'CAMPUSCALENDAR19901991', 'Holiday Calendar 1990-1991', {ts '1990-08-01 00:00:00.0'}, {ts '1991-12-31 00:00:00.0'}, 'kuali.atp.type.HolidayCalendar', 'kuali.atp.state.Official', '1990-1991 Holiday Calendar', 0)
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'ACADEMICCALENDAR1990CAMPUSCALENDAR19901991RELATION', 0, {ts '1988-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'ACADEMICCALENDAR1990', 'kuali.atp.atp.relation.associated', 'CAMPUSCALENDAR19901991')
// Holidays
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'THANKSGIVING1990', 'Thanksgiving 1990', {ts '1990-11-21 00:00:00.0'}, {ts '1990-11-26 00:00:00.0'}, 'kuali.atp.milestone.ThanksgivingBreak', 'kuali.milestone.state.Official', 0, 1, 1, 0, NULL, 'Thanksgiving Break', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'CAMPUSCALENDAR19901991THANKSGIVING1990RELATION', 0, 'CAMPUSCALENDAR19901991', 'THANKSGIVING1990' )

-- -----------------------------------------------------------------------------------------------
-- incomplete RegistrationDateGroup for testUpdateRegistrationDateGroup
-- -----------------------------------------------------------------------------------------------
// Fall First Block
INSERT INTO KSEN_ATP (CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, ATP_TYPE, ATP_STATE, DESCR_PLAIN, VER_NBR) VALUES ('SYSLOADER', {ts '2000-09-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990', 'Fall First Block 1990', {ts '1990-08-01 00:00:00.0'}, {ts '1990-12-31 00:00:00.0'}, 'kuali.atp.type.HalfFall1', 'kuali.atp.state.Official', 'Fall First Block 1990', 0)
INSERT INTO KSEN_ATPATP_RELTN(CREATEID, CREATETIME, ID, VER_NBR, EFF_DT, ATP_STATE, ATP_ID, ATP_TYPE, RELATED_ATP_ID) VALUES ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990FALLFIRSTBLOCK1990RELATION', 0, {ts '1988-01-01 00:00:00.0'}, 'kuali.atp.atp.relation.state.active', 'FALLFIRSTBLOCK1990', 'kuali.atp.atp.relation.includes', 'FALLFIRSTBLOCK1990')
// Fall First Block Registration Date Group
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990REGISTRATION', 'Fall First Block Registration Period', {ts '1990-08-01 00:00:00.0'}, {ts '1990-09-09 00:00:00.0'}, 'kuali.atp.milestone.RegistrationPeriod', 'kuali.milestone.state.Official', 0, 0, 1, 0, NULL, 'Fall First Block 1990 Registration', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990FALLFIRSTBLOCK1990REGISTRATIONRELATION', 0, 'FALLFIRSTBLOCK1990', 'FALLFIRSTBLOCK1990REGISTRATION')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990COURSESELECTIONEND', 'Fall First Block Course Selection Period Ends', {ts '1990-09-10 00:00:00.0'}, {ts '1990-09-10 00:00:00.0'}, 'kuali.atp.milestone.CourseSelectionPeriodEnd', 'kuali.milestone.state.Official',0, 0, 0, 0, NULL, 'Fall First Block Course Selection', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990FALLFIRSTBLOCK1990COURSESELECTIONENDRELATION', 0, 'FALLFIRSTBLOCK1990', 'FALLFIRSTBLOCK1990COURSESELECTIONEND')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990INSTRUCTIONPERIOD', 'Fall First Block Instructional Period', {ts '1990-09-03 00:00:00.0'}, {ts '1990-11-01 00:00:00.0'}, 'kuali.atp.milestone.InstructionalPeriod', 'kuali.milestone.state.Official', 0, 1, 1, 0, NULL, 'Instruction Period', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990FALLFIRSTBLOCK1990INSTRUCTIONPERIODRELATION', 0, 'FALLFIRSTBLOCK1990', 'FALLFIRSTBLOCK1990INSTRUCTIONPERIOD')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990DROPDATE', 'Drop Deadlin', {ts '1990-09-10 00:00:00.0'}, {ts '1990-09-10 00:00:00.0'}, 'kuali.atp.milestone.DropDate', 'kuali.milestone.state.Official',0, 0, 0, 0, NULL, 'Deadline to Drop Fall First Block Classes', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990FALLFIRSTBLOCK1990DROPDATERELATION', 0, 'FALLFIRSTBLOCK1990', 'FALLFIRSTBLOCK1990DROPDATE')
INSERT INTO KSEN_MSTONE(CREATEID, CREATETIME, ID, NAME, START_DT, END_DT, MSTONE_TYPE, MSTONE_STATE, IS_INSTRCT_DAY, IS_ALL_DAY, IS_DATE_RANGE, IS_RELATIVE, RELATIVE_ANCHOR_MSTONE_ID, DESCR_PLAIN , VER_NBR) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990GRADESDUE', 'Fall Grades Due', {ts '1990-11-01 00:00:00.0'}, {ts '1990-11-05 00:00:00.0'}, 'kuali.atp.milestone.GradesDue', 'kuali.milestone.state.Official', 0, 0, 1, 0, NULL, 'First Block Grades Due', 0)
INSERT INTO KSEN_ATPMSTONE_RELTN (CREATEID, CREATETIME, ID, VER_NBR, ATP_ID, MSTONE_ID) values ('SYSLOADER', {ts '2000-01-01 00:00:00.0'}, 'FALLFIRSTBLOCK1990FALLFIRSTBLOCK1990GRADESDUERELATION', 0, 'FALLFIRSTBLOCK1990', 'FALLFIRSTBLOCK1990GRADESDUE')

