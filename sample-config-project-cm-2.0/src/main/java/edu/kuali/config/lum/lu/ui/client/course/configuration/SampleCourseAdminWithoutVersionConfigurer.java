/*
 * Copyright 2009 The Kuali Foundation Licensed under the
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
package edu.kuali.config.lum.lu.ui.client.course.configuration;

import org.kuali.student.common.ui.client.configurable.mvc.FieldDescriptor;
import org.kuali.student.common.ui.client.configurable.mvc.sections.Section;
import org.kuali.student.common.ui.client.widgets.KSCharCount;
import org.kuali.student.lum.common.client.lu.LUUIConstants;
import org.kuali.student.lum.lu.ui.course.client.configuration.CourseAdminWithoutVersionConfigurer;
import org.kuali.student.lum.lu.ui.course.client.configuration.CourseProposalConfigurer.KeyListModelWigetBinding;


/**
 * This is the configuration factory class for creating a proposal.
 *
 * @author Kuali Student Team
 */
public class SampleCourseAdminWithoutVersionConfigurer extends CourseAdminWithoutVersionConfigurer {
   
	@Override
	public Section generateCourseInfoSection(Section section) {
        addField(section, COURSE + "/" + TRANSCRIPT_TITLE, generateMessageInfo(LUUIConstants.SHORT_TITLE_LABEL_KEY));
        addField(section, COURSE + "/" + COURSE_TITLE, generateMessageInfo(LUUIConstants.COURSE_TITLE_LABEL_KEY));
        section.addSection(generateCourseNumberSection());
    	FieldDescriptor instructorsFd = addField(section, COURSE + "/" + INSTRUCTORS, generateMessageInfo(LUUIConstants.INSTRUCTORS_LABEL_KEY));
        instructorsFd.setWidgetBinding(new KeyListModelWigetBinding("personId"));

        section.addSection(generateDescriptionRationaleSection());
        
        return section;
	}

}


