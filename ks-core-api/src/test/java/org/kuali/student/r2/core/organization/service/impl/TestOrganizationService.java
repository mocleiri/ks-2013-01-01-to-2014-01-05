/*
 * Copyright 2013 The Kuali Foundation
 *
 * Licensed under the the Educational Community License, Version 1.0
 * (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.r2.core.organization.service.impl;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.kuali.student.r2.common.dto.ContextInfo;

import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.core.organization.dto.OrgOrgRelationInfo;
import org.kuali.student.r2.core.organization.dto.OrgPersonRelationInfo;
import org.kuali.student.r2.core.organization.dto.OrgPositionRestrictionInfo;
import org.kuali.student.r2.core.organization.dto.OrgTreeViewInfo;
import org.kuali.student.r2.core.organization.service.OrganizationService;
import org.kuali.student.r2.core.organization.service.impl.util.constants.OrganizationServiceConstants;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Kuali Student Team
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:org-test-with-mock-context.xml"})
public class TestOrganizationService {

    @Resource
    public OrganizationService orgService;
    @Resource
    protected OrganizationServiceDataLoader dataLoader;

    public ContextInfo callContext = null;
    public static String principalId = "123";

    @Before
    public void setUp() throws Exception {
        callContext = new ContextInfo();
        callContext.setPrincipalId(principalId);
        dataLoader.beforeTest();
    }

    @After
    public void tearDown() throws Exception {
            dataLoader.afterTest();
    }

    public OrganizationService getOrgService() {
        return orgService;
    }

    public void setOrgService(OrganizationService orgService) {
        this.orgService = orgService;
    }

    public OrganizationServiceDataLoader getDataLoader() {
        return dataLoader;
    }

    public void setDataLoader(OrganizationServiceDataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Test
    public void testGetOrgRelationsByOrg() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        //org with no relations
        List<OrgOrgRelationInfo> orgRelations = orgService.getOrgOrgRelationsByOrg("14", callContext);
        assertTrue(orgRelations.isEmpty());

        //org with one relation
        orgRelations = orgService.getOrgOrgRelationsByOrg("1", callContext);
        assertEquals(1, orgRelations.size());
        OrgOrgRelationInfo info = getOrgOrgRelationInfoByRelatedOrgIdAndType("2", OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "1", "2", OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE);

        //org with multiple relations of different types.
        orgRelations = orgService.getOrgOrgRelationsByOrg("4", callContext);
        assertEquals(4, orgRelations.size());
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("12", OrganizationServiceDataLoader.ORG_RELATION_ACAD_COLABORATES_WITH_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "12", OrganizationServiceDataLoader.ORG_RELATION_ACAD_COLABORATES_WITH_TYPE);
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("7", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "7", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE);
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("10", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "10", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE);
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("10", OrganizationServiceDataLoader.ORG_RELATION_ACAD_COLABORATES_WITH_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "10", OrganizationServiceDataLoader.ORG_RELATION_ACAD_COLABORATES_WITH_TYPE);
    }

    @Test
    public void testGetOrgRelationsByOrgs() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        //no relations
        List<OrgOrgRelationInfo> orgRelations = orgService.getOrgOrgRelationsByOrgs("14", "15", callContext);
        assertTrue(orgRelations.isEmpty());

        orgRelations = orgService.getOrgOrgRelationsByOrgs("1", "3", callContext);
        assertTrue(orgRelations.isEmpty());

        //org with one relation
        orgRelations = orgService.getOrgOrgRelationsByOrgs("1", "2", callContext);
        assertEquals(1, orgRelations.size());
        OrgOrgRelationInfo info = getOrgOrgRelationInfoByRelatedOrgIdAndType("2", OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "1", "2", OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE);

        //org with multiple relations of different types.
        orgRelations = orgService.getOrgOrgRelationsByOrgs("4", "10", callContext);
        assertEquals(2, orgRelations.size());
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("10", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "10", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE);
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("10", OrganizationServiceDataLoader.ORG_RELATION_ACAD_COLABORATES_WITH_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "10", OrganizationServiceDataLoader.ORG_RELATION_ACAD_COLABORATES_WITH_TYPE);


    }

    @Test
    public void testGetOrgRelationsByTypeAndOrg() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        //no relations
        List<OrgOrgRelationInfo> orgRelations = orgService.getOrgOrgRelationsByTypeAndOrg("14",
                OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE, callContext);
        assertTrue(orgRelations.isEmpty());

        orgRelations = orgService.getOrgOrgRelationsByTypeAndOrg("1", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, callContext);
        assertTrue(orgRelations.isEmpty());

        //org with one relation
        orgRelations = orgService.getOrgOrgRelationsByTypeAndOrg("1", OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE, callContext);
        assertEquals(1, orgRelations.size());
        OrgOrgRelationInfo info = getOrgOrgRelationInfoByRelatedOrgIdAndType("2", OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "1", "2", OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE);

        //org with multiple relations of different types.
        orgRelations = orgService.getOrgOrgRelationsByTypeAndOrg("4", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, callContext);
        assertEquals(2, orgRelations.size());
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("7", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "7", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE);
        info = getOrgOrgRelationInfoByRelatedOrgIdAndType("10", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "10", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE);
    }

    @Test
    public void testGetOrgRelationsByTypeAndRelatedOrg() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        //no relations
        List<OrgOrgRelationInfo> orgRelations = orgService.getOrgOrgRelationsByTypeAndRelatedOrg("14",
                OrganizationServiceDataLoader.ORG_RELATION_ACAD_PARENT_TYPE, callContext);
        assertTrue(orgRelations.isEmpty());

        //org with one relation
        orgRelations = orgService.getOrgOrgRelationsByTypeAndRelatedOrg("1", OrganizationServiceDataLoader.ORG_RELATION_ACAD_CHILD_TYPE, callContext);
        assertEquals(1, orgRelations.size());
        OrgOrgRelationInfo info = getOrgOrgRelationInfoByOrgIdAndType("2", OrganizationServiceDataLoader.ORG_RELATION_ACAD_CHILD_TYPE, orgRelations);
        validateOrgOrgRelation(info, "2", "1", OrganizationServiceDataLoader.ORG_RELATION_ACAD_CHILD_TYPE);


        //org with multiple relations of different types.
        orgRelations = orgService.getOrgOrgRelationsByTypeAndRelatedOrg("7", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, callContext);
        assertEquals(1, orgRelations.size());
        info = getOrgOrgRelationInfoByOrgIdAndType("4", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE, orgRelations);
        validateOrgOrgRelation(info, "4", "7", OrganizationServiceDataLoader.ORG_RELATION_FIN_PARENT_TYPE);
    }

    @Test
    public void testGetOrgPersonRelationsByOrg() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        //only one person id
        List<OrgPersonRelationInfo> relations = orgService.getOrgPersonRelationsByOrg("1", callContext);
        assertEquals(2, relations.size());
        OrgPersonRelationInfo relation = getOrgPersonRelationInfoByPersonAndType(relations, "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE);
        validateOrgPersonRelation(relation, "1", "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE);
        relation = getOrgPersonRelationInfoByPersonAndType(relations, "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);
        validateOrgPersonRelation(relation, "1", "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);


        //lots of people one duplicate
        relations = orgService.getOrgPersonRelationsByOrg("20", callContext);
        assertEquals(21, relations.size());
        relation = getOrgPersonRelationInfoByPersonAndType(relations, "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE);
        validateOrgPersonRelation(relation, "20", "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE);
        for(int i = 1; i <= 20; i++) {
            relation = getOrgPersonRelationInfoByPersonAndType(relations, String.valueOf(i), OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);
            validateOrgPersonRelation(relation, "20", String.valueOf(i), OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);
        }

        //no relations
        relations = orgService.getOrgPersonRelationsByOrg("50", callContext);
        assertTrue(relations.isEmpty());
    }

    @Test
    public void testGetOrgPersonRelationsByOrgAndPerson() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        //person with two relations to an org
        List<OrgPersonRelationInfo> relations = orgService.getOrgPersonRelationsByOrgAndPerson("10", "1", callContext);
        assertEquals(2, relations.size());
        OrgPersonRelationInfo relation = getOrgPersonRelationInfoByPersonAndType(relations, "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE);
        validateOrgPersonRelation(relation, "10", "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE);
        relation = getOrgPersonRelationInfoByPersonAndType(relations, "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);
        validateOrgPersonRelation(relation, "10", "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);


        //person with only one relation to an org
        relations = orgService.getOrgPersonRelationsByOrgAndPerson("2", "2", callContext);
        assertEquals(1, relations.size());
        relation = getOrgPersonRelationInfoByPersonAndType(relations, "2", OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);
        validateOrgPersonRelation(relation, "2", "2", OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE);

        //no relations
        relations = orgService.getOrgPersonRelationsByOrgAndPerson("50", "2", callContext);
        assertTrue(relations.isEmpty());
    }

    @Test
    public void testGetOrgPersonRelationsByTypeAndPerson() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        //one relation of this type in all orgs.
        List<OrgPersonRelationInfo> relations = orgService.getOrgPersonRelationsByTypeAndPerson(OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE, "1", callContext);
        assertEquals(20, relations.size());
        for(int i = 1; i <= 20; i++) {
            OrgPersonRelationInfo relation = getOrgPersonRelationInfoByOrg(relations, String.valueOf(i));
            validateOrgPersonRelation(relation, String.valueOf(i), "1", OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE);
        }

        //no relations
        relations = orgService.getOrgPersonRelationsByTypeAndPerson(OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE, "50", callContext);
        assertTrue(relations.isEmpty());
    }

    @Test
    public void testGetOrgPositionRestrictionIdsByOrg() throws PermissionDeniedException, MissingParameterException, InvalidParameterException, OperationFailedException, DoesNotExistException {
        //no restrictions
        List<String> restrictions = orgService.getOrgPositionRestrictionIdsByOrg("50", callContext);
        assertTrue(restrictions.isEmpty());

        //multiple restrictions
        restrictions = orgService.getOrgPositionRestrictionIdsByOrg("20", callContext);
        assertEquals(2, restrictions.size());
        assertTrue(restrictions.contains("20"));
        assertTrue(restrictions.contains("40"));
    }

    @Test
    public void testGetOrgPositionRestrictionIdsByType() throws PermissionDeniedException, MissingParameterException, InvalidParameterException, OperationFailedException, DoesNotExistException {
        //multiple restrictions
        List<String> restrictions = orgService.getOrgPositionRestrictionIdsByType(OrganizationServiceDataLoader.ORG_PERSON_RELATION_PRESIDENT_TYPE, callContext);
        assertEquals(20, restrictions.size());

        for(int i = 1; i <= 20; i++) {
            assertTrue(restrictions.contains(String.valueOf(i)));
        }

        restrictions = orgService.getOrgPositionRestrictionIdsByType(OrganizationServiceDataLoader.ORG_PERSON_RELATION_MEMBER_TYPE, callContext);
        assertEquals(20, restrictions.size());

        for(int i = 21; i <= 40; i++) {
            assertTrue(restrictions.contains(String.valueOf(i)));
        }
    }

    @Test
    public void testIsDescendant() throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        assertTrue(orgService.isDescendant("1", "2", "A", callContext));
        assertTrue(orgService.isDescendant("1", "10", "A", callContext));
        assertFalse(orgService.isDescendant("3", "4", "A", callContext));
        assertFalse(orgService.isDescendant("3", "2", "A", callContext));

        assertFalse(orgService.isDescendant("1", "2", "B", callContext));
        assertTrue(orgService.isDescendant("4", "10", "B", callContext));
        assertTrue(orgService.isDescendant("11", "8", "B", callContext));
        assertFalse(orgService.isDescendant("11", "3", "B", callContext));

        assertFalse(orgService.isDescendant("1", "20", "A", callContext));

        assertTrue(orgService.isDescendant("4", "10", "B", callContext));

        assertTrue(orgService.isDescendant("13", "13", "B", callContext));
        assertFalse(orgService.isDescendant("11", "11", "B", callContext));
    }

    @Test
    public void testGetOrgTree() throws PermissionDeniedException, MissingParameterException, InvalidParameterException, OperationFailedException, DoesNotExistException {
        //pull the entire tree from the root
        OrgTreeViewInfo treeFromOrgOne = orgService.getOrgTree("1", "A", 0, callContext);
        validateTree(treeFromOrgOne, "1", 1, 1);
        OrgTreeViewInfo treeFromOrgTwo = treeFromOrgOne.getChildren().get(0);
        validateTree(treeFromOrgTwo, "2", 1, 3);
        assertTrue(treeFromOrgTwo.getParents().get(0) == treeFromOrgOne);
        OrgTreeViewInfo treeFromOrgThree = getOrgTreeViewInfoById("3", treeFromOrgTwo.getChildren());
        validateTree(treeFromOrgThree, "3", 1, 3);
        OrgTreeViewInfo treeFromOrgFive = getOrgTreeViewInfoById("5", treeFromOrgThree.getChildren());
        validateTree(treeFromOrgFive, "5", 1, 0);
        OrgTreeViewInfo treeFromOrgSix = getOrgTreeViewInfoById("6", treeFromOrgThree.getChildren());
        validateTree(treeFromOrgSix, "6", 1, 0);
        OrgTreeViewInfo treeFromOrgSeven = getOrgTreeViewInfoById("7", treeFromOrgThree.getChildren());
        validateTree(treeFromOrgSeven, "7", 2, 3);
        OrgTreeViewInfo treeFromOrgEight = getOrgTreeViewInfoById("8", treeFromOrgSeven.getChildren());
        validateTree(treeFromOrgEight, "8", 2, 1);
        OrgTreeViewInfo treeFromOrgNine = getOrgTreeViewInfoById("9", treeFromOrgEight.getChildren());
        validateTree(treeFromOrgNine, "9", 2, 1);
        treeFromOrgNine = getOrgTreeViewInfoById("9", treeFromOrgSeven.getChildren());
        validateTree(treeFromOrgNine, "9", 2, 1);
        OrgTreeViewInfo treeFromOrgTen = getOrgTreeViewInfoById("10", treeFromOrgSeven.getChildren());
        validateTree(treeFromOrgTen, "10", 2, 0);
        OrgTreeViewInfo treeFromOrgFour = getOrgTreeViewInfoById("4", treeFromOrgTwo.getChildren());
        validateTree(treeFromOrgFour, "4", 1, 3);
        treeFromOrgFour = getOrgTreeViewInfoById("4", treeFromOrgSeven.getParents());
        validateTree(treeFromOrgFour, "4", 1, 3);
        OrgTreeViewInfo treeFromOrgTwelve = getOrgTreeViewInfoById("12", treeFromOrgFour.getChildren());
        validateTree(treeFromOrgTwelve, "12", 1, 0);

        //Test pulling with an org that is not in the tree.
        treeFromOrgTwo = orgService.getOrgTree("2", "B", 0, callContext);
        assertNull(treeFromOrgTwo);

        //Test pulling one level of parents.
        treeFromOrgFour = orgService.getOrgTree("4", "B", -1, callContext);
        validateTree(treeFromOrgFour, "4", 1, 0);
        OrgTreeViewInfo treeFromOrgEleven = treeFromOrgFour.getParents().get(0);
        validateTree(treeFromOrgEleven, "11", 0, 1);

        //Test pulling one level of children.
        treeFromOrgFour = orgService.getOrgTree("4", "B", 1, callContext);
        validateTree(treeFromOrgFour, "4", 0, 3);
        treeFromOrgSeven = getOrgTreeViewInfoById("7", treeFromOrgFour.getChildren());
        validateTree(treeFromOrgSeven, "7", 1, 0);
        treeFromOrgTen = getOrgTreeViewInfoById("10", treeFromOrgFour.getChildren());
        validateTree(treeFromOrgTen, "10", 1, 0);
        treeFromOrgTwelve = getOrgTreeViewInfoById("12", treeFromOrgFour.getChildren());
        validateTree(treeFromOrgTwelve, "12", 1, 0);

        //pull entire tree from the perspective of 9.
        treeFromOrgNine = orgService.getOrgTree("9", "A", 0, callContext);
        validateTree(treeFromOrgNine, "9", 2, 1);
        treeFromOrgSeven = getOrgTreeViewInfoById("7", treeFromOrgNine.getParents());
        validateTree(treeFromOrgSeven, "7", 2, 2);
        treeFromOrgFour = getOrgTreeViewInfoById("4", treeFromOrgSeven.getParents());
        validateTree(treeFromOrgFour, "4", 1, 1);
        treeFromOrgTwo = getOrgTreeViewInfoById("2", treeFromOrgFour.getParents());
        validateTree(treeFromOrgTwo, "2", 1, 3);
        treeFromOrgOne = getOrgTreeViewInfoById("1", treeFromOrgTwo.getParents());
        validateTree(treeFromOrgOne, "1", 1, 1);

        //pull a node that is its own parent.
        OrgTreeViewInfo treeFromOrgThirteen = orgService.getOrgTree("13", "B", 0, callContext);
        validateTree(treeFromOrgThirteen, "13", 1, 1);
    }

    private void validateTree(OrgTreeViewInfo orgTreeViewInfo, String orgId, int parentCount, int childCount) {
        assertNotNull(orgTreeViewInfo);
        assertEquals(orgId, orgTreeViewInfo.getOrg().getId());
        assertEquals(parentCount, orgTreeViewInfo.getParents().size());
        assertEquals(childCount, orgTreeViewInfo.getChildren().size());
    }


    private OrgTreeViewInfo getOrgTreeViewInfoById(String orgId, List<OrgTreeViewInfo> orgTrees) {
        for(OrgTreeViewInfo currentTree : orgTrees) {
            if(currentTree.getOrg().getId().equals(orgId)) {
                return currentTree;
            }
        }
        return null;
    }

    private void validateOrgOrgRelation(OrgOrgRelationInfo info, String orgId, String relatedOrgId, String type) {
        assertNotNull(info);
        assertEquals(orgId, info.getOrgId());
        assertEquals(relatedOrgId, info.getRelatedOrgId());
        assertEquals(type, info.getTypeKey());
    }

    private OrgOrgRelationInfo getOrgOrgRelationInfoByRelatedOrgIdAndType(String id, String type, List<OrgOrgRelationInfo> relations) {
        for(OrgOrgRelationInfo info : relations) {
            if(info.getRelatedOrgId().equals(id) && info.getTypeKey().equals(type)) {
                return info;
            }
        }
        return null;
    }

    private OrgOrgRelationInfo getOrgOrgRelationInfoByOrgIdAndType(String id, String type, List<OrgOrgRelationInfo> relations) {
        for(OrgOrgRelationInfo info : relations) {
            if(info.getOrgId().equals(id) && info.getTypeKey().equals(type)) {
                return info;
            }
        }
        return null;
    }

    private OrgPersonRelationInfo getOrgPersonRelationInfoByPersonAndType(List<OrgPersonRelationInfo> relations, String personId, String type) {
        for(OrgPersonRelationInfo info : relations) {
            if(info.getPersonId().equals(personId) && info.getTypeKey().equals(type)) {
                return info;
            }
        }
        return null;
    }

    private OrgPersonRelationInfo getOrgPersonRelationInfoByOrg(List<OrgPersonRelationInfo> relations, String id) {
        for(OrgPersonRelationInfo info : relations) {
            if(info.getOrgId().equals(id)) {
                return info;
            }
        }
        return null;
    }

    private void validateOrgPersonRelation(OrgPersonRelationInfo info, String orgId, String personId, String type) {
        assertNotNull(info);
        assertEquals(orgId, info.getOrgId());
        assertEquals(personId, info.getPersonId());
        assertEquals(type, info.getTypeKey());
    }

}
