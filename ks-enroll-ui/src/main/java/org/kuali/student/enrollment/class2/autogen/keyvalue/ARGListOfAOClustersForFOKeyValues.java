/**
 * Copyright 2011 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.enrollment.class2.autogen.keyvalue;

import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.kuali.student.enrollment.class2.autogen.form.ARGCourseOfferingManagementForm;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingClusterWrapper;
import org.kuali.student.enrollment.class2.courseoffering.dto.ActivityOfferingWrapper;
import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingClusterInfo;
import org.kuali.student.enrollment.courseoffering.dto.FormatOfferingInfo;
import org.kuali.student.enrollment.courseoffering.service.CourseOfferingService;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.util.ContextUtils;
import org.kuali.student.r2.common.util.constants.CourseOfferingServiceConstants;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

/**
 * Decision for M6 - Garey wants to have logic on the Move To dropdown such that the user would not be shown a cluster
 * that has a different FO than the one in which the AO currently sits.
 * This can always be revisited in the future if the POs think it should be addressed in another manner.
 *
 */
public class ARGListOfAOClustersForFOKeyValues extends UifKeyValuesFinderBase implements Serializable {
    private transient CourseOfferingService courseOfferingService;
    private static final long serialVersionUID = 1L;
    @Override
    public List<KeyValue> getKeyValues(ViewModel model) {
        ARGCourseOfferingManagementForm rgForm = (ARGCourseOfferingManagementForm) model;
        ContextInfo contextInfo = ContextUtils.createDefaultContextInfo();
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        List<ActivityOfferingClusterInfo> clusterInfos = new ArrayList<ActivityOfferingClusterInfo>();
                
        String coInfoID = rgForm.getCurrentCourseOfferingWrapper().getCourseOfferingInfo().getId();
        try {
            List<FormatOfferingInfo> foInfos = getCourseOfferingService().getFormatOfferingsByCourseOffering(coInfoID, contextInfo);
            if(foInfos.size() < 1) {
                keyValues.add(new ConcreteKeyValue("", "No Format Offering and No Clusters"));
                rgForm.setDisableMoveButtonForMoveAOCPopOver(true);
            }
            else if(foInfos.size() == 1){
                keyValues = populateClusterList(foInfos.get(0).getId());
                rgForm.setDisableMoveButtonForMoveAOCPopOver(false);
            }
            else if (foInfos.size()>1){
                boolean aoChecked = false;
                HashSet foSet = new HashSet(foInfos.size());
                //check if selected AOs belong to different FOs
                List<ActivityOfferingClusterWrapper> clusterResultList = rgForm.getClusterResultList();
                for(ActivityOfferingClusterWrapper clusterWrapper: clusterResultList) {
                    List<ActivityOfferingWrapper> aoWrapperList = clusterWrapper.getAoWrapperList();
                    for(ActivityOfferingWrapper aoWrapper: aoWrapperList){
                        if (aoWrapper.getIsCheckedByCluster()){
                            aoChecked = true;
                            String slectedFoID = clusterWrapper.getFormatOffering().getId();
                            if(foSet.isEmpty() || !foSet.contains(slectedFoID)) {
                                foSet.add(slectedFoID);
                            }
                            break;//expect this break only jump out of the aoWrapper loop and stay within clusterWrapper loop 
                        }
                    }
                }
                if(foSet.isEmpty()){
                    //no AO has been selected
                    rgForm.setDisableMoveButtonForMoveAOCPopOver(true);  
                }
                else if(foSet.size()==1){
                    //all selected AOs belong to one FO
                    String foId = (String)foSet.iterator().next();
                    keyValues = populateClusterList(foId);
                    rgForm.setDisableMoveButtonForMoveAOCPopOver(false);
                }
                else if (foSet.size()>1){
                    //all selected AOs belong to more than one FO
                    keyValues.add(new ConcreteKeyValue("", "Cannot move between format offerings"));
                    rgForm.setDisableMoveButtonForMoveAOCPopOver(true);
                }
            }
        }catch (Exception e) {
            throw new RuntimeException("Error getting clusters for format offering", e);
        }

//        List<KeyValue> keyValues = new ArrayList<KeyValue>();
//        List<ActivityOfferingClusterInfo> clusterInfos = new ArrayList<ActivityOfferingClusterInfo>();
//        keyValues.add(new ConcreteKeyValue("", "Select activity offering cluster..."));
//
//        try {
//
//            for (String formatOfferingId : rgForm.getFormatOfferingIds()) {
//                clusterInfos = getCourseOfferingService().getActivityOfferingClustersByFormatOffering(formatOfferingId, contextInfo);
//            }
//            for (ActivityOfferingClusterInfo clusterInfo : clusterInfos) {
//                keyValues.add(new ConcreteKeyValue(clusterInfo.getId(), clusterInfo.getPrivateName()));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Error getting clusters for format offering", e);
//        }
        return keyValues;
    }
    
    private List<KeyValue> populateClusterList(String foId)throws Exception{
        ContextInfo contextInfo = ContextUtils.createDefaultContextInfo();
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        List<ActivityOfferingClusterInfo> clusterInfos = getCourseOfferingService().getActivityOfferingClustersByFormatOffering(foId, contextInfo);
//        keyValues.add(new ConcreteKeyValue("", "Select activity offering cluster..."));
        for (ActivityOfferingClusterInfo clusterInfo : clusterInfos) {
            keyValues.add(new ConcreteKeyValue(clusterInfo.getId(), clusterInfo.getPrivateName()));
        }
        return keyValues;
    }
    protected CourseOfferingService getCourseOfferingService() {
        if (courseOfferingService == null) {
            courseOfferingService = (CourseOfferingService) GlobalResourceLoader.getService(new QName(CourseOfferingServiceConstants.NAMESPACE, "CourseOfferingService"));
        }
        return courseOfferingService;
    }

}
