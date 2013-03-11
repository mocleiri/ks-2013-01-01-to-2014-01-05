<%--
 Copyright 2007-2009 The Kuali Foundation
 
 Licensed under the Educational Community License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
 http://www.opensource.org/licenses/ecl2.php
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>
<%@ include file="/rice-portal/jsp/sys/riceTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="MyPlan Applications" />
<div class="body">
  <strong>MyPlan -- Find Courses</strong>
  <ul class="chan">
  	<li><a href="${ConfigProperties.application.url}/myplan/course?methodToCall=start&viewId=CourseSearch-FormView" target="_new">Course Search</a></li>
	<li><a href="${ConfigProperties.application.url}/myplan/audit?methodToCall=audit&viewId=DegreeAudit-FormView" target="_new">Degree Audit</a></li>
	<li><a href="${ConfigProperties.application.url}/myplan/plan?methodToCall=start&viewId=PlannedCourses-FormView" target="_new">Your Plan</a></li>
    <li><a href="${ConfigProperties.application.url}/myplan/advise/${UserSession.principalId}" target="_new">Adviser Access</a></li>

  </ul>
</div>
<channel:portalChannelBottom />
