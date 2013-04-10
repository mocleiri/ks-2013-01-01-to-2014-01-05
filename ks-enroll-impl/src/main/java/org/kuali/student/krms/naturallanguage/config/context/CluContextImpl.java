/**
 * Copyright 2010 The Kuali Foundation Licensed under the
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

package org.kuali.student.krms.naturallanguage.config.context;

import org.kuali.rice.krms.api.repository.term.TermDefinitionContract;
import org.kuali.student.r2.core.krms.naturallanguage.TermParameterTypes;
import org.kuali.student.krms.naturallanguage.config.context.util.NLCluSet;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.core.versionmanagement.dto.VersionDisplayInfo;
import org.kuali.student.r2.lum.clu.dto.CluInfo;
import org.kuali.student.r2.lum.clu.dto.CluSetInfo;
import org.kuali.student.r2.lum.clu.dto.CluSetTreeViewInfo;
import org.kuali.student.r2.lum.clu.service.CluService;
import org.kuali.student.r2.lum.util.constants.CluServiceConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * This class creates the template context for course list types.
 */
public class CluContextImpl extends BasicContextImpl {
    /**
     * Learning unit service.
     */
    private CluService cluService;

    /**
     * <code>clu</code> token (key) references a Clu object used in templates.
     * e.g. 'Student must have completed all of
     * $clu.getOfficialIdentifier().getShortName()'
     */
    public final static String CLU_TOKEN = "clu";
    public final static String COURSE_CLU_TOKEN = "courseClu";
    public final static String PROGRAM_CLU_TOKEN = "programClu";
    public final static String TEST_CLU_TOKEN = "testClu";

    /**
     * <code>cluSet</code> token (key) references a Clu set object
     * used in templates.
     * e.g. 'Student must have completed all of $cluSet.getCluSetAsCode()'
     */
    public final static String CLU_SET_TOKEN = "cluSet";
    public final static String COURSE_CLU_SET_TOKEN = "courseCluSet";
    public final static String PROGRAM_CLU_SET_TOKEN = "programCluSet";
    public final static String TEST_CLU_SET_TOKEN = "testCluSet";

    /**
     * Sets the LU service.
     *
     * @param cluService CLU service
     */
    public void setCluService(CluService cluService) {
        this.cluService = cluService;
    }

    /**
     * Gets a CLU.
     *
     * @param cluId CLU id
     * @return CLU
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          If retrieving CLU fails
     */
    public CluInfo getCluInfo(String cluId, ContextInfo contextInfo) throws OperationFailedException {
        if (cluId == null) {
            return null;
        }
        try {
            VersionDisplayInfo versionInfo = cluService.getCurrentVersion(CluServiceConstants.CLU_NAMESPACE_URI, cluId, null);
            CluInfo clu = this.cluService.getClu(versionInfo.getId(), contextInfo);
            return clu;
        } catch (Exception e) {
            throw new OperationFailedException(e.getMessage(), e);
        }
    }

    private CluInfo getClu(Map<String, String> map, String key, ContextInfo contextInfo) throws OperationFailedException {
        if (map.containsKey(key)) {
            String cluId = map.get(key);
            return getCluInfo(cluId, contextInfo);
        }
        return null;
    }

    /**
     * Gets a CLU set.
     *
     * @param cluSetId CLU set id
     * @return CLU set
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          If retrieving CLU set fails
     */
    public CluSetInfo getCluSetInfo(String cluSetId, ContextInfo contextInfo) throws OperationFailedException {
        if (cluSetId == null) {
            return null;
        }
        try {
            CluSetInfo cluSet = this.cluService.getCluSet(cluSetId, contextInfo);
            return cluSet;
        } catch (Exception e) {
            throw new OperationFailedException(e.getMessage(), e);
        }
    }

    private static void findClusInCluSet(CluSetTreeViewInfo tree, List<CluInfo> cluList) {
        if (tree.getCluSets() != null) {
            for (CluSetTreeViewInfo cluSet : tree.getCluSets()) {
                findClusInCluSet(cluSet, cluList);
            }
        } else {
            for (CluInfo clu : tree.getClus()) {
                if (!containsClu(cluList, clu)) {
                    cluList.add(clu);
                }
            }
        }
    }

    private static boolean containsClu(List<CluInfo> cluList, CluInfo clu) {
        return containsClu(cluList, clu.getId());
    }

    private static boolean containsClu(List<CluInfo> cluList, String cluId) {
        for (CluInfo clu2 : cluList) {
            if (clu2.getId().equals(cluId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a custom CLU set from a requirement component.
     *
     * @param map Requirement component
     * @return custom CLU set
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          If building a custom CLU set fails
     */
    public NLCluSet getCluSet(Map<String, String> map, String key, ContextInfo contextInfo) throws OperationFailedException {
        NLCluSet cluSet = null;
        if (map.containsKey(key)) {
            String cluSetId = map.get(key);

            CluSetInfo cluSetInfo = null;
            if (cluSetId != null) {
                cluSetInfo = getCluSetInfo(cluSetId, contextInfo);
            } else {
                cluSetInfo = new CluSetInfo();
            }

            List<CluInfo> list = new ArrayList<CluInfo>();
            if (map.containsKey("kuali.term.parameter.type.course.nl.clu.list")) {
                String idList = map.get("kuali.term.parameter.type.course.nl.clu.list");
                String [] ids = idList.split(",");
                for (String id : ids) {
                    if (!containsClu(list, id)) {
                        list.add(this.getCluInfo(id, contextInfo));
                    }
                }
            } else {
                if (cluSetId != null) {
                    try {
                        CluSetTreeViewInfo tree = cluService.getCluSetTreeView(cluSetId, contextInfo);
                        findClusInCluSet(tree, list);
                    } catch (Exception e) {
                        throw new OperationFailedException(e.getMessage(), e);
                    }
                }else {
                    return null;
                }
            }

            return new NLCluSet(cluSetInfo.getId(), list, cluSetInfo);

        }
        return cluSet;
    }

    /**
     * Creates the context map (template data) for the requirement component.
     *
     * @param term Requirement component
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          Creating context map fails
     */
    @Override
    public Map<String, Object> createContextMap(TermDefinitionContract term, ContextInfo contextInfo) throws OperationFailedException {
        Map<String, Object> contextMap = super.createContextMap(term, contextInfo);

        Map<String, String> parmMap = getTermParameterMap(term);

        CluInfo clu = getClu(parmMap, TermParameterTypes.CLU_KEY.getId(), contextInfo);
        if (clu != null) {
            contextMap.put(CLU_TOKEN, clu);
        }
        CluInfo courseClu = getClu(parmMap, TermParameterTypes.COURSE_CLU_KEY.getId(), contextInfo);
        if (courseClu != null) {
            contextMap.put(COURSE_CLU_TOKEN, courseClu);
        }
        CluInfo programClu = getClu(parmMap, TermParameterTypes.PROGRAM_CLU_KEY.getId(), contextInfo);
        if (programClu != null) {
            contextMap.put(PROGRAM_CLU_TOKEN, programClu);
        }
        CluInfo testClu = getClu(parmMap, TermParameterTypes.TEST_CLU_KEY.getId(), contextInfo);
        if (testClu != null) {
            contextMap.put(TEST_CLU_TOKEN, testClu);
        }

        NLCluSet cluSet = getCluSet(parmMap, TermParameterTypes.CLUSET_KEY.getId(), contextInfo);
        if (cluSet != null) {
            contextMap.put(CLU_SET_TOKEN, cluSet);
        }
        NLCluSet courseCluSet = getCluSet(parmMap, TermParameterTypes.COURSE_CLUSET_KEY.getId(), contextInfo);
        if (courseCluSet != null) {
            contextMap.put(COURSE_CLU_SET_TOKEN, courseCluSet);
        }
        NLCluSet programCluSet = getCluSet(parmMap, TermParameterTypes.PROGRAM_CLUSET_KEY.getId(), contextInfo);
        if (programCluSet != null) {
            contextMap.put(PROGRAM_CLU_SET_TOKEN, programCluSet);
        }
        NLCluSet testCluSet = getCluSet(parmMap, TermParameterTypes.TEST_CLUSET_KEY.getId(), contextInfo);
        if (testCluSet != null) {
            contextMap.put(TEST_CLU_SET_TOKEN, testCluSet);
        }

        return contextMap;
    }
}
