package org.kuali.student.myplan.plan.service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kuali.student.enrollment.academicrecord.dto.StudentCourseRecordInfo;
import org.kuali.student.myplan.plan.PlanConstants;
import org.kuali.student.myplan.plan.dataobject.AcademicRecordDataObject;
import org.kuali.student.myplan.plan.dataobject.PlannedCourseDataObject;
import org.kuali.student.myplan.plan.dataobject.PlannedTerm;
import org.kuali.student.myplan.plan.util.AtpHelper;
import org.kuali.student.myplan.plan.util.AtpHelper.YearTerm;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: hemanthg
 * Date: 5/16/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlannedTermsHelperBase {

    private static final Logger logger = Logger.getLogger(PlannedTermsHelperBase.class);

    public static List<PlannedTerm> populatePlannedTerms(List<PlannedCourseDataObject> plannedCoursesList, List<PlannedCourseDataObject> backupCoursesList, List<StudentCourseRecordInfo> studentCourseRecordInfos, String focusAtpId, boolean isServiceUp, int futureTerms, boolean fullPlanView) {

        String[] focusQuarterYear = new String[2];
        String globalCurrentAtpId = null;
        if (isServiceUp) {
            globalCurrentAtpId = AtpHelper.getCurrentAtpId();
        } else {
            globalCurrentAtpId = AtpHelper.populateAtpIdFromCalender().get(0).getId();
        }
        try {
            if (StringUtils.isEmpty(focusAtpId)) {
                focusQuarterYear = AtpHelper.atpIdToTermAndYear(AtpHelper.getFirstAtpIdOfAcademicYear(globalCurrentAtpId));
            } else {
                focusQuarterYear = AtpHelper.atpIdToTermAndYear(AtpHelper.getFirstAtpIdOfAcademicYear(focusAtpId));
            }
        } catch (Exception e) {
            //  Log and set the year to the current year.
            //  TODO: This logic isn't correct, but does position the quarter view pretty close.
            logger.error("Could not get the requested focus ATP, so using the current academic year.", e);
            String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - 1);
            focusQuarterYear[0] = PlanConstants.ATP_TERM_1;
            focusQuarterYear[1] = year;
        }

        /*
        *  Populating the PlannedTerm List.
        */
        List<PlannedTerm> plannedTerms = new ArrayList<PlannedTerm>();
        for (PlannedCourseDataObject plan : plannedCoursesList) {
            String atp = plan.getPlanItemDataObject().getAtp();
            boolean exists = false;
            for (PlannedTerm term : plannedTerms) {
                if (term.getAtpId().equalsIgnoreCase(atp)) {
                    term.getPlannedList().add(plan);
                    exists = true;
                }
            }
            if (!exists) {
                PlannedTerm term = new PlannedTerm();
                term.setAtpId(atp);
                String[] splitStr = AtpHelper.atpIdToTermNameAndYear(atp);
                StringBuilder sb = new StringBuilder();
                sb.append(splitStr[0]).append(" ").append(splitStr[1]);
                String QtrYear = sb.substring(0, 1).toUpperCase().concat(sb.substring(1));
                term.setQtrYear(QtrYear);
                term.getPlannedList().add(plan);
                plannedTerms.add(term);
            }
        }

        /*
         * Populating the backup list for the Plans
        */
        if (backupCoursesList != null) {
            int count = plannedTerms.size();
            for (PlannedCourseDataObject bl : backupCoursesList) {
                String atp = bl.getPlanItemDataObject().getAtp();

                boolean added = false;
                for (int i = 0; i < count; i++) {
                    if (atp.equalsIgnoreCase(plannedTerms.get(i).getAtpId())) {
                        plannedTerms.get(i).getBackupList().add(bl);
                        added = true;
                    }
                }
                if (!added) {
                    PlannedTerm plannedTerm = new PlannedTerm();
                    plannedTerm.setAtpId(atp);
                    StringBuffer str = new StringBuffer();
                    String[] splitStr = AtpHelper.atpIdToTermNameAndYear(atp);
                    str = str.append(splitStr[0]).append(" ").append(splitStr[1]);
                    String QtrYear = str.substring(0, 1).toUpperCase().concat(str.substring(1, str.length()));
                    plannedTerm.setQtrYear(QtrYear);
                    plannedTerm.getBackupList().add(bl);
                    plannedTerms.add(plannedTerm);
                    count++;
                }
            }
        }

        /*
        * Used for sorting the planItemDataobjects
        */
        List<AcademicRecordDataObject> academicRecordDataObjectList = new ArrayList<AcademicRecordDataObject>();

        Collections.sort(plannedTerms, new Comparator<PlannedTerm>() {
            @Override
            public int compare(PlannedTerm plannedTerm1, PlannedTerm plannedTerm2) {
                return plannedTerm1.getAtpId().compareTo(plannedTerm2.getAtpId());
            }
        });

        /*********** Implementation to populate the plannedTerm list with academic record and planned terms ******************/
        if (studentCourseRecordInfos.size() > 0 || plannedTerms.size() > 0) {
            Map<String, PlannedTerm> termsList = new HashMap<String, PlannedTerm>();
            String minTerm = null;
            if (studentCourseRecordInfos.size() > 0) {
                minTerm = studentCourseRecordInfos.get(0).getTermName();
            } else {
                minTerm = globalCurrentAtpId;
            }
            String maxTerm = null;
            if (plannedTerms.size() > 0 && fullPlanView) {
                maxTerm = plannedTerms.get(plannedTerms.size() - 1).getAtpId();
            } else {
                maxTerm = globalCurrentAtpId;
            }
            populateMockList(minTerm, maxTerm, termsList, futureTerms);
            if (plannedTerms.size() > 0) {
                for (PlannedTerm plannedTerm : plannedTerms) {
                    if (termsList.containsKey(plannedTerm.getAtpId())) {
                        if (plannedTerm.getPlannedList().size() > 0 || plannedTerm.getBackupList().size() > 0) {
                            termsList.get(plannedTerm.getAtpId());
                            termsList.put(plannedTerm.getAtpId(), plannedTerm);
                        }
                    }
                }
            }
            if (studentCourseRecordInfos.size() > 0) {
                for (StudentCourseRecordInfo studentInfo : studentCourseRecordInfos) {
                    if (termsList.containsKey(studentInfo.getTermName())) {
                        AcademicRecordDataObject academicRecordDataObject = new AcademicRecordDataObject();
                        academicRecordDataObject.setAtpId(studentInfo.getTermName());
                        academicRecordDataObject.setPersonId(studentInfo.getPersonId());
                        academicRecordDataObject.setCourseCode(studentInfo.getCourseCode());
                        /*TODO: StudentCourseRecordInfo does not have a courseId property so using Id to set the course Id*/
                        academicRecordDataObject.setCourseId(studentInfo.getId());
                        academicRecordDataObject.setCourseTitle(studentInfo.getCourseTitle());
                        academicRecordDataObject.setCredit(studentInfo.getCreditsEarned());
                        if (!AtpHelper.isAtpCompletedTerm(studentInfo.getTermName())) {
                            academicRecordDataObject.setActivityCode(studentInfo.getActivityCode());
                        }
                        if (!"X".equalsIgnoreCase(studentInfo.getCalculatedGradeValue())) {
                            academicRecordDataObject.setGrade(studentInfo.getCalculatedGradeValue());
                        } else if ("X".equalsIgnoreCase(studentInfo.getCalculatedGradeValue()) && AtpHelper.isAtpCompletedTerm(studentInfo.getTermName())) {
                            academicRecordDataObject.setGrade(studentInfo.getCalculatedGradeValue());
                        }
                        academicRecordDataObject.setRepeated(studentInfo.getIsRepeated());
                        academicRecordDataObjectList.add(academicRecordDataObject);
                        termsList.get(studentInfo.getTermName()).getAcademicRecord().add(academicRecordDataObject);
                    }
                }
            }
            List<PlannedTerm> perfectPlannedTerms = new ArrayList<PlannedTerm>();
            for (String key : termsList.keySet()) {
                perfectPlannedTerms.add(termsList.get(key));
            }

            Collections.sort(perfectPlannedTerms,
                    new Comparator<PlannedTerm>() {
                        @Override
                        public int compare(PlannedTerm plannedTerm1, PlannedTerm plannedTerm2) {
                            return plannedTerm1.getAtpId().compareTo(plannedTerm2.getAtpId());
                        }
                    });
            //  Can't do this step until the sort has been done else the index won't be correct.
            int i = 0;
            for (PlannedTerm pt : perfectPlannedTerms) {
                String[] qy = AtpHelper.atpIdToTermAndYear(pt.getAtpId());
                if (qy[0].equals(focusQuarterYear[0])
                        && qy[1].equals(focusQuarterYear[1])) {
                    pt.setIndex(i);
                    break;
                }
                i++;
            }


            /*Implementation to set the conditional flags based on each plannedTerm atpId*/
            for (PlannedTerm pl : perfectPlannedTerms) {

                if (AtpHelper.isAtpSetToPlanning(pl.getAtpId())) {
                    pl.setOpenForPlanning(true);
                }
                if (AtpHelper.isAtpCompletedTerm(pl.getAtpId())) {
                    pl.setCompletedTerm(true);
                }
                if (globalCurrentAtpId.equalsIgnoreCase(pl.getAtpId())) {
                    pl.setCurrentTermForView(true);
                }

            }

            populateHelpIconFlags(perfectPlannedTerms);
            return perfectPlannedTerms;
        }

        /*Implementation to populate the future terms till 6 years from current term if academic record data and planned term data are NOT present*/
        else {
            List<PlannedTerm> plannedTermList = new ArrayList<PlannedTerm>();
            populateFutureData(globalCurrentAtpId, plannedTermList, futureTerms);
            /*Implementation to set the conditional flags based on each plannedTerm atpId*/
            if (isServiceUp) {
                for (PlannedTerm pl : plannedTermList) {

                    if (AtpHelper.isAtpSetToPlanning(pl.getAtpId())) {
                        pl.setOpenForPlanning(true);
                    }
                    if (AtpHelper.isAtpCompletedTerm(pl.getAtpId())) {
                        pl.setCompletedTerm(true);
                    }
                    if (globalCurrentAtpId.equalsIgnoreCase(pl.getAtpId())) {
                        pl.setCurrentTermForView(true);
                    }

                }
            }
            populateHelpIconFlags(plannedTermList);
            return plannedTermList;


        }
    }

    /**
     * Aap with key as atpId and value as PlannedTerm is populated starting from minTerm to ((year Of maxTerm) + futureTermsCount)
     *
     * @param minTerm
     * @param maxTerm
     * @param map
     * @param futureTermsCount
     */
    private static void populateMockList(String minTerm, String maxTerm, Map<String, PlannedTerm> map, int futureTermsCount) {
        YearTerm minYearTerm = AtpHelper.atpToYearTerm(minTerm);
        YearTerm maxYearTerm = AtpHelper.atpToYearTerm(maxTerm);

        if (minYearTerm.getTerm() != Integer.parseInt(PlanConstants.ATP_TERM_4)) {
            minTerm = new YearTerm(minYearTerm.getYear() - 1, Integer.parseInt(PlanConstants.ATP_TERM_4)).toATP();
        }
        maxTerm = new YearTerm(maxYearTerm.getYear() + futureTermsCount, Integer.parseInt(PlanConstants.ATP_TERM_3)).toATP();
        List<YearTerm> futureAtpIds = AtpHelper.getFutureYearTerms(minTerm, maxTerm);
        for (YearTerm yearTerm : futureAtpIds) {
            PlannedTerm plannedTerm = new PlannedTerm();
            plannedTerm.setAtpId(yearTerm.toATP());
            plannedTerm.setQtrYear(yearTerm.toLabel());
            map.put(yearTerm.toATP(), plannedTerm);
        }
    }


    /**
     * PlannedTermList is populated starting from the given atpId to ((year of atpId) + futureTermsCount)
     * @param atpId
     * @param plannedTermList
     * @param futureTermsCount
     */
    private static void populateFutureData(String atpId, List<PlannedTerm> plannedTermList, int futureTermsCount) {
        YearTerm minYearTerm = AtpHelper.atpToYearTerm(atpId);
        if (minYearTerm.getTerm() != Integer.parseInt(PlanConstants.ATP_TERM_4)) {
            minYearTerm = new YearTerm(minYearTerm.getYear() - 1, Integer.parseInt(PlanConstants.ATP_TERM_4));
        }
        YearTerm maxYearTerm = new YearTerm(minYearTerm.getYear() + futureTermsCount, Integer.parseInt(PlanConstants.ATP_TERM_3));
        List<YearTerm> futureAtpIds = AtpHelper.getFutureYearTerms(minYearTerm.toATP(), maxYearTerm.toATP());
        for (YearTerm yearTerm : futureAtpIds) {
            PlannedTerm plannedTerm = new PlannedTerm();
            plannedTerm.setAtpId(yearTerm.toATP());
            plannedTerm.setQtrYear(yearTerm.toLabel());
            plannedTermList.add(plannedTerm);
        }

    }

    private static void populateHelpIconFlags(List<PlannedTerm> plannedTerms) {

        int index = plannedTerms.size() - 1;
        while (index >= 0) {
            for (int i = 4; i > 0; i--) {
                if (plannedTerms.get(index).isCurrentTermForView() || i == 1) {
                    plannedTerms.get(index).setDisplayBackupHelp(true);
                    plannedTerms.get(index).setDisplayPlannedHelp(true);
                    index = index - i;
                    break;
                }
                index--;
            }
        }
        index = 0;
        while (index < plannedTerms.size()) {
            for (int i = 1; i < 4; i++) {
                if (index < plannedTerms.size() && plannedTerms.get(index).isCompletedTerm() && i == 1) {
                    plannedTerms.get(index).setDisplayCompletedHelp(true);
                    index = index + (5 - i);
                    break;
                }
                index++;

            }
        }
        index = plannedTerms.size() - 1;
        while (index >= 0) {
            for (int i = 4; i > 0; i--) {
                if (plannedTerms.get(index).isCurrentTermForView() || !plannedTerms.get(index).isCompletedTerm() && (plannedTerms.get(index).getAcademicRecord().size() > 0 || !plannedTerms.get(index).isOpenForPlanning())) {
                    plannedTerms.get(index).setDisplayRegisteredHelp(true);
                    index = index - i;
                    break;
                }
                index--;
            }
        }


    }

}
