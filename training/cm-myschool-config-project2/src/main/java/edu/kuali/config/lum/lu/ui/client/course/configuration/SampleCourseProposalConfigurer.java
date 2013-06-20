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

import com.google.gwt.user.client.Window;
import org.kuali.student.common.assembly.data.ConstraintMetadata;
import org.kuali.student.common.ui.client.configurable.mvc.FieldDescriptor;
import org.kuali.student.common.ui.client.configurable.mvc.sections.GroupSection;
import org.kuali.student.common.ui.client.configurable.mvc.sections.Section;
import org.kuali.student.common.ui.client.widgets.KSCharCount;
import org.kuali.student.lum.common.client.lu.LUUIConstants;
import org.kuali.student.lum.lu.ui.course.client.configuration.CourseProposalConfigurer;

/**
 * This is the configuration factory class for creating a proposal.
 *
 * @author Kuali Student Team
 */
public class SampleCourseProposalConfigurer extends CourseProposalConfigurer {

    @Override
    public Section generateCourseInfoSection(Section section) {

        addField(section, PROPOSAL_TITLE_PATH, generateMessageInfo(LUUIConstants.PROPOSAL_TITLE_LABEL_KEY));
        addField(section, COURSE + "/" + TRANSCRIPT_TITLE, generateMessageInfo(LUUIConstants.SHORT_TITLE_LABEL_KEY), new KSCharCount(getMetaData(COURSE + "/" + TRANSCRIPT_TITLE)));
        FieldDescriptor fd = addField(section, COURSE + "/" + COURSE_TITLE, generateMessageInfo(LUUIConstants.COURSE_TITLE_LABEL_KEY));
//        dumpField (fd);
        section.addSection(generateCourseNumberSection());
        FieldDescriptor instructorsFd = addField(section, COURSE + "/" + INSTRUCTORS, generateMessageInfo(LUUIConstants.INSTRUCTORS_LABEL_KEY));
        instructorsFd.setWidgetBinding(new KeyListModelWigetBinding("personId"));

        section.addSection(generateDescriptionRationaleSection());

        return section;
    }

    @Override
    protected GroupSection generateCourseNumberSection() {

        //COURSE NUMBER
        GroupSection courseNumber = new GroupSection(getH4Title(""));
        courseNumber.addStyleName(LUUIConstants.STYLE_SECTION);
        courseNumber.addStyleName(LUUIConstants.STYLE_SECTION_DIVIDER);
        addField(courseNumber, COURSE + "/" + SUBJECT_AREA, generateMessageInfo(LUUIConstants.SUBJECT_CODE_LABEL_KEY));
        FieldDescriptor fd = addField(courseNumber, COURSE + "/" + COURSE_NUMBER_SUFFIX, generateMessageInfo(LUUIConstants.COURSE_NUMBER_LABEL_KEY));
//        dumpField (fd);
//        addField(courseNumber, COURSE + "/" + SUBJECT_AREA);
//        addField(courseNumber, COURSE + "/" + COURSE_NUMBER_SUFFIX);

        courseNumber.addSection(generateCrossListed_Ver_Joint_Section());


        return courseNumber;
    }

    private void dumpField(FieldDescriptor fd) {
        Window.alert("fieldKey=" + fd.getFieldKey());
        Window.alert("fieldLabel=" + fd.getFieldLabel());
        Window.alert("modelId=" + fd.getModelId());
        Window.alert("constraints.size=" + fd.getMetadata().getConstraints().size());
        for (ConstraintMetadata cons : fd.getMetadata().getConstraints()) {
            Window.alert("minLength=" + cons.getMinLength());
            Window.alert("maxLength=" + cons.getMaxLength());
            Window.alert("validChars=" + cons.getValidChars());
        }
    }
}
