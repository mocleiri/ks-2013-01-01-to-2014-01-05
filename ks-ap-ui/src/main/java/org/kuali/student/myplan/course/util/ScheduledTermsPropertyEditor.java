package org.kuali.student.myplan.course.util;

/**
 * Copyright 2005-2012 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.beans.PropertyEditorSupport;

import org.kuali.student.ap.framework.config.KsapFrameworkServiceLocator;
import org.kuali.student.ap.framework.context.TermHelper;
import org.kuali.student.ap.framework.context.YearTerm;
import org.kuali.student.myplan.course.dataobject.CourseSummaryDetails;

public class ScheduledTermsPropertyEditor extends PropertyEditorSupport {
	protected CollectionListPropertyEditorHtmlListType listType = CollectionListPropertyEditorHtmlListType.DL;

	@Override
	public void setValue(Object value) {
		super.setValue(value);
	}

	// TODO: KULRICE-6286 Upgrade to list with rice 2.2.1 
	@Override
	public String getAsText() {
		CourseSummaryDetails courseSummaryDetails = (CourseSummaryDetails) super
				.getValue();
		StringBuffer formattedText = new StringBuffer();
		formattedText.append(String.format("<%s class=\"scheduled\">",
				listType.getListElementName()));
		TermHelper th = KsapFrameworkServiceLocator.getTermHelper();
		if (courseSummaryDetails != null
				&& courseSummaryDetails.getScheduledTerms() != null
				&& courseSummaryDetails.getScheduledTerms().size() > 0) {
			for (String termId : courseSummaryDetails.getScheduledTerms()) {
				YearTerm yt = th.getYearTerm(termId);
				String text = yt.getShortName();
				formattedText.append(String.format("<%s class=\"%s\">%s</%s>",
						listType.getListItemElementName(),
						text.replaceAll("\\d*$", "").trim(), text,
						listType.getListItemElementName()));
			}
		} else {
			formattedText.append("Not currently scheduled");
		}
		formattedText.append(String.format("</%s>",
				listType.getListElementName()));
		return formattedText.toString();
	}

}
