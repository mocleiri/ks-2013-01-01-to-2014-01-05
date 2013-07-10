When /^I (?:|setup|edit|have setup) the Antirequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Antirequisite", :course => course
  @courseOR.data_setup
end

When /^I (?:|setup|edit|have setup) the Antirequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Antirequisite", :term => "201301", :course => course
  @courseOR.data_setup
end

When /^I (?:|navigate|have navigated) to the Antirequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Antirequisite", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Antirequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Antirequisite", :term => "201301", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|setup|edit|have setup) the Corequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Corequisite", :course => course
  @courseOR.data_setup
end

When /^I (?:|setup|edit|have setup) the Corequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Corequisite", :term => "201301", :course => course
  @courseOR.data_setup
end

When /^I (?:|navigate|have navigated) to the Corequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Corequisite", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Corequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Corequisite", :term => "201301", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|setup|edit|have setup) the Recommended Preparation section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Recommended Preparation", :course => course
  @courseOR.data_setup
end

When /^I (?:|setup|edit|have setup) the Recommended Preparation section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Recommended Preparation", :term => "201301", :course => course
  @courseOR.data_setup
end

When /^I (?:|navigate|have navigated) to the Recommended Preparation section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Recommended Preparation", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Recommended Preparation section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Recommended Preparation", :term => "201301", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|setup|edit|have setup) the Student Eligibility & Prerequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Student Eligibility & Prerequisite", :course => course
  @courseOR.data_setup
end

When /^I (?:|setup|edit|have setup) the Student Eligibility & Prerequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Student Eligibility & Prerequisite", :term => "201301", :course => course
  @courseOR.data_setup
end

When /^I (?:|navigate|have navigated) to the Student Eligibility & Prerequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Student Eligibility & Prerequisite", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Student Eligibility & Prerequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Student Eligibility & Prerequisite", :term => "201301", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|setup|edit|have setup) the Repeatable for Credit section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Repeatable for Credit", :course => course
  @courseOR.data_setup
end

When /^I (?:|setup|edit|have setup) the Repeatable for Credit section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Repeatable for Credit", :term => "201301", :course => course
  @courseOR.data_setup
end

When /^I (?:|navigate|have navigated) to the Repeatable for Credit section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Repeatable for Credit", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Repeatable for Credit section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Repeatable for Credit", :term => "201301", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|setup|edit|have setup) the Course that Restricts Credits section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Course that Restricts Credits", :course => course
  @courseOR.data_setup
end

When /^I (?:|setup|edit|have setup) the Course that Restricts Credits section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Course that Restricts Credits", :term => "201301", :course => course
  @courseOR.data_setup
end

When /^I (?:|navigate|have navigated) to the Course that Restricts Credits section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Course that Restricts Credits", :course => course
  @courseOR.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Course that Restricts Credits section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData, :section => "Course that Restricts Credits", :term => "201301", :course => course
  @courseOR.navigate_to_mco_requisites
end

Then /^the "(.*?)" link should exist on the Course Offering Requisites page$/ do |link|
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    if page.agenda_management_section.a(:text => /#{Regexp.escape(link)}/).exists?
      true
    else
      false
    end
  end
end

Then /^the info message "(.*?)" should be present$/ do |mess|
  on ManageCORequisites do |page|
    page.info_message.text.should match /#{Regexp.escape(mess)}/
  end
end

When /^I want to edit the selected agenda section$/ do
  begin
    @courseOR.open_agenda_section
    on CourseOfferingRequisites do |page|
      page.rule_edit
    end
  rescue Watir::Wait::TimeoutError
    #means Data setup was not needed
  end
end

When /^I want to add a new statement to the selected agenda section$/ do
  begin
    @courseOR.open_agenda_section
    on CourseOfferingRequisites do |page|
      page.rule_add
    end
  rescue Watir::Wait::TimeoutError
    #means Data setup was not needed
  end
end

When /^I delete the tree$/ do
  on ManageCORequisites do |page|
    page.edit_tree_section.span(:id => /u\d+_node_0_parent_root_span/).when_present.click
    page.del_btn
  end
end

When /^I delete node "(.)" in the tree$/ do |node|
  on ManageCORequisites do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
    page.del_btn
  end
end

When /^I edit node "(.*?)" by changing course to "(.*?)"$/ do |node, change|
  @courseOR.edit_existing_node(node, "course", change)
end

When /^I edit node "(.*?)" by adding course "(.*?)"$/ do |node, change|
  @courseOR.edit_existing_node(node, "courses", change)
end

When /^I edit node "(.*?)" by changing text to "(.*?)"$/ do |node, change|
  @courseOR.edit_existing_node(node, "text", change)
end

When /^I add a course statement after node "(.)" with course "([^\"]+)"$/ do |node, course|
  @courseOR.create_course_rule( "add", node, course)
end

When /^I add a free form text statement after node "(.)" with text "([^\"]+)"$/ do |node, text|
  @courseOR.create_text_rule( "add", node, text)
end

When /^I add a courses statement after node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @courseOR.create_all_courses_rule( "add", node, course, set, "")
end

When /^I add a courses statement after node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @courseOR.create_all_courses_rule( "add", node, course, "", "")
end

When /^I add a courses statement after node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @courseOR.create_all_courses_rule( "add", node, "", set, "")
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, number, course, set|
  @courseOR.create_number_courses_rule( "add", node, number, course, set, "")
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @courseOR.create_number_courses_rule( "add", node, number, course, "", "")
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @courseOR.create_number_courses_rule( "add", node, number, "", set, "")
end

When /^I add a repeated for credits statement after node "(.)" with "(\d+)" credits$/ do |node, number|
  @courseOR.create_repeated_credit_rule( "add", node, number)
end

When /^I add a grade and courses statement after node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @courseOR.create_grade_courses_rule( "add", node, course, "", "", type, grade)
end

When /^I add a grade and courses statement after node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @courseOR.create_grade_courses_rule( "add", node, "", set, "", type, grade)
end

When /^I add a grade and number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, course, type, grade|
  @courseOR.create_grade_number_courses_rule( "add", node, course, "", "", type, grade, number)
end

When /^I add a grade and number of courses statement after node "(.)" with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, set, type, grade|
  @courseOR.create_grade_number_courses_rule( "add", node, "", set, "", type, grade, number)
end

When /^I add a gpa and courses statement after node "(.)" with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, course, gpa|
  @courseOR.create_gpa_courses_rule( "add", node, course, "", "", gpa)
end

When /^I add a gpa and courses statement after node "(.)" with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, set, gpa|
  @courseOR.create_gpa_courses_rule( "add", node, "", set, "", gpa)
end

When /^I add a gpa and duration statement after node "(.)" with GPA of "([\d\.]+)" and duration type "([^\"]+)" with duration "(\d+)"$/ do |node, gpa, type, duration|
  @courseOR.create_gpa_duration_rule( "add", node, gpa, type, duration)
end

When /^I add a minimum number of credits and org rule after node "(.)" with "([\d\.]+)" credits and org "(.*?)"$/ do |node, credit, org|
  @courseOR.create_min_credits_org_rule( "add", node, org, credit)
end

When /^I add a course and as of term statement after node "(.)" with course "(.*?)" and term "(.*?)"$/ do |node, course, term|
  @courseOR.create_course_term_rule( "add", node, course, term)
end

When /^I add a course and prior to term statement after node "(.)" with course "(.*?)" and term "(.*?)"$/ do |node, course, term|
  @courseOR.create_course_term_rule( "add", node, course, term, "prior to")
end

When /^I add a no more than number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @courseOR.create_less_number_courses_rule( "add", node, number, course, "", "")
end

When /^I add a new course statement with course "([^\"]+)"$/ do |course|
  @courseOR.create_course_rule( "add", "", course)
end

When /^I add a new free form text statement with text "([^\"]+)"$/ do |text|
  @courseOR.create_text_rule( "add", "", text)
end

When /^I add a new courses statement with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |course, set|
  @courseOR.create_all_courses_rule( "add", "", course, set, "")
end

When /^I add a new courses statement with courses "([^\"]+)"$/ do |course|
  @courseOR.create_all_courses_rule( "add", "", course, "", "")
end

When /^I add a new courses statement with course sets "([^\"]+)"$/ do |set|
  @courseOR.create_all_courses_rule( "add", "", "", set, "")
end

When /^I add a new number of courses statement with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |number, course, set|
  @courseOR.create_number_courses_rule( "add", "", number, course, set, "")
end

When /^I add a new number of courses statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @courseOR.create_number_courses_rule( "add", "", number, course, "", "")
end

When /^I add a new number of courses statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @courseOR.create_number_courses_rule( "add", "", number, "", set, "")
end

When /^I add a new no more than number of courses statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @courseOR.create_less_number_courses_rule( "add", "", number, course, "", "")
end

When /^I add a new no more than number of courses statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @courseOR.create_less_number_courses_rule( "add", "", number, "", set, "")
end

When /^I add a new no more than credits statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @courseOR.create_less_credits_rule( "add", "", number, course, "", "", "<")
end

When /^I add a new no more than credits statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @courseOR.create_less_credits_rule( "add", "", number, "", set, "", "<")
end

When /^I add a new minimum credits statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @courseOR.create_less_credits_rule( "add", "", number, course, "", "", ">")
end

When /^I add a new minimum credits statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @courseOR.create_less_credits_rule( "add", "", number, "", set, "", ">")
end

When /^I add a new any credits statement with courses "([^\"]+)"$/ do |course|
  @courseOR.create_any_credits_rule( "add", "", course, "", "")
end

When /^I add a new any credits statement with course sets "([^\"]+)"$/ do |set|
  @courseOR.create_any_credits_rule( "add", "", "", set, "")
end

When /^I add a new repeated for credits statement with "(\d+)" credits$/ do |number|
  @courseOR.create_repeated_credit_rule( "add", "", number)
end

When /^I add a new grade and courses statement with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |course, type, grade|
  @courseOR.create_grade_courses_rule( "add", "", course, "", "", type, grade)
end

When /^I add a new grade and courses statement with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |set, type, grade|
  @courseOR.create_grade_courses_rule( "add", "", "", set, "", type, grade)
end

When /^I add a new grade and number of courses statement with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |number, course, type, grade|
  @courseOR.create_grade_number_courses_rule( "add", "", course, "", "", type, grade, number)
end

When /^I add a new grade and number of courses statement with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |number, set, type, grade|
  @courseOR.create_grade_number_courses_rule( "add", "", "", set, "", type, grade, number)
end

When /^I add a new gpa and courses statement with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |course, gpa|
  @courseOR.create_gpa_courses_rule( "add", "", course, "", "", gpa)
end

When /^I add a new gpa and courses statement with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |set, gpa|
  @courseOR.create_gpa_courses_rule( "add", "", "", set, "", gpa)
end

When /^I add a new gpa and duration statement with GPA of "([\d\.]+)" and duration type "([^\"]+)" with duration "(\d+)"$/ do |gpa, type, duration|
  @courseOR.create_gpa_duration_rule( "add", "", gpa, type, duration)
end

When /^I add a new gpa statement with GPA of "([\d\.]+)"$/ do |gpa|
  @courseOR.create_gpa_rule( "add", "", gpa)
end

When /^I add a new program statement with program code "(.*?)"$/ do |program|
  @courseOR.create_program_rule( "add", "", program)
end

When /^I add a new any program statement$/ do
  @courseOR.create_any_program_rule( "add", "")
end

When /^I add a new permission of instructor required statement$/ do
  @courseOR.create_permission_instructor_rule( "add", "")
end

When /^I add a new course and as of term statement with course "(.*?)" and term "(.*?)"$/ do |course, term|
  @courseOR.create_course_term_rule( "add", "", course, term)
end

When /^I add a new course and prior to term statement with course "(.*?)" and term "(.*?)"$/ do |course, term|
  @courseOR.create_course_term_rule( "add", "", course, term, "prior to")
end

When /^I add a new course and two terms statement with course "(.*?)" between terms one "(.*?)" and two "(.*?)"$/ do |course, term1, term2|
  @courseOR.create_course_between_terms_rule( "add", "", course, term1, term2)
end

When /^I add a new program and class standing statement with program code "(.*?)" and class standing "(.*?)"$/ do |program, stand|
  @courseOR.create_program_class_standing_rule( "add", "", program, stand)
end

When /^I add a new program offered by org statement with "(.*?)"$/ do |org|
  @courseOR.create_program_org_rule( "add", "", org)
end

When /^I add a new class standing or greater statement with class standing "(.*?)"$/ do |standing|
  @courseOR.create_class_standing_rule( "add", "", standing, ">")
end

When /^I add a new class standing or less statement with class standing "(.*?)"$/ do |standing|
  @courseOR.create_class_standing_rule( "add", "", standing, "<")
end

When /^I add a new class standing statement with class standing "(.*?)"$/ do |standing|
  @courseOR.create_class_standing_rule( "add", "", standing, "=")
end

When /^I add a new permission of administering org statement with org "(.*?)"$/ do |org|
  @courseOR.create_admin_org_rule( "add", "", org)
end

When /^I add a new minimum number of credits and org rule with "([\d\.]+)" credits and org "(.*?)"$/ do |credit, org|
  @courseOR.create_min_credits_org_rule( "add", "", org, credit)
end

When /^I add a new minimum total credits statement with "([\d]+)" credits$/ do |credits|
  @courseOR.create_min_total_credits_rule( "add", "", credits)
end

When /^I group course statement with node "(.)" with course "([^\"]+)"$/s do |node, course|
  @courseOR.create_course_rule( "group", node, course)
end

When /^I group free form text statement with node "(.)" with text "([^\"]+)"$/ do |node, text|
  @courseOR.create_text_rule( "group", node, text)
end

When /^I group courses statement with node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @courseOR.create_all_courses_rule( "group", node, course, "", "")
end

When /^I group courses statement with node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @courseOR.create_all_courses_rule( "group", node, "", set, "")
end

When /^I group number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @courseOR.create_number_courses_rule( "group", node, number, course, "", "")
end

When /^I group number of courses statement with node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @courseOR.create_number_courses_rule( "group", node, number, "", set, "")
end

When /^I group repeated for credits statement with node "(.)" with "(\d+)" credits$/ do |node, number|
  @courseOR.create_repeated_credit_rule( "group", node, number)
end

When /^I group grade and courses statement with node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @courseOR.create_grade_courses_rule( "group", node, course, "", "", type, grade)
end

When /^I group grade and courses statement with node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @courseOR.create_grade_courses_rule( "group", node, "", set, "", type, grade)
end

When /^I group grade and number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, course, type, grade|
  @courseOR.create_grade_number_courses_rule( "group", node, course, "", "", type, grade, number)
end

When /^I group grade and number of courses statement with node "(.)" with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, set, type, grade|
  @courseOR.create_grade_number_courses_rule( "group", node, "", set, "", type, grade, number)
end

When /^I group gpa and courses statement with node "(.)" with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, course, gpa|
  @courseOR.create_gpa_courses_rule( "group", node, course, "", "", gpa)
end

When /^I group gpa and courses statement with node "(.)" with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, set, gpa|
  @courseOR.create_gpa_courses_rule( "group", node, "", set, "", gpa)
end

When /^I commit and return to see the changes made to the proposition$/ do
  @courseOR.commit_changes( true)  #:return_to_edit_page =>
end

When /^I commit changes made to the proposition$/ do
  @courseOR.commit_changes
end

Then /^the tree in the selected agenda section should be empty$/ do
  section_regex = {"Antirequisite"=>"Corequisite", "Corequisite"=>"Recommended Preparation",
                   "Recommended Preparation"=>"Student Eligibility & Prerequisite",
                   "Student Eligibility & Prerequisite"=>"Credit Constraints",
                   "Repeatable for Credit"=>"Course that Restricts Credits", "Course that Restricts Credits"=>""}
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    @courseOR.open_agenda_section
    page.agenda_management_section.text.should =~ /.*#{@courseOR.section}.*Rule.*\.\n#{section_regex[@courseOR.section]}.*/m
  end
end

Then /^there should be no node "(.*?)" on both tabs$/ do |node|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should_not match /.*#{Regexp.escape(node)}\..*/
    page.logic_tab
    page.edit_loading.wait_while_present
    page.logic_text.text.should_not match /.*#{Regexp.escape(node)}.*/
  end
end

When /^I delete the tree in the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_delete
  end
end

Then /^the agenda page's text should match "(.*)"$/ do |text|
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", text)
  end
end

Then /^the agenda page's text should not match "(.*)"$/ do |text|
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.agenda_management_section.text.should_not match @courseOR.test_text("agenda", text)
  end
end

Then /^the edit tab's text should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should match @courseOR.test_text(@courseOR.section, text)
  end
end

Then /^the edit tab's text should not match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should_not match @courseOR.test_text(@courseOR.section, text)
  end
end

Then /^the logic tab's text should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should match @courseOR.test_text(@courseOR.section, text)
  end
end

Then /^the logic tab's text should not match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should_not match @courseOR.test_text(@courseOR.section, text)
  end
end

Then /^the CO and CLU should both have text "(.*?)"/ do |text|
  on CourseOfferingRequisites do |page|
    page.compare_tree.text.should match @courseOR.test_text("compare", text)
  end
end

Then /^the CO and CLU should differ with text "(.*?)"/ do |text|
  on CourseOfferingRequisites do |page|
    page.compare_tree.text.should_not match @courseOR.test_text("compare", text)
  end
end

When /^I switch to the other tab on the page$/ do
  @courseOR.switch_tabs
end

Then /^the text area should contain "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.logic_text.text.should == text
  end
end

When /^I want to compare the CO to the CLU for the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_compare
  end
end

Then /^both tabs' text should match "(.*?)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_tree_section.text.should match @courseOR.test_text("edit", text)
    page.logic_tab.click
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should match @courseOR.test_text("logic", @courseOR.convert_text( text, "logic"))
  end
end

Then /^the agenda page should before and after the submit have the text "(.*?)"$/ do |text|
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", @courseOR.convert_text( text, "agenda"))
  end
  @courseOR.commit_changes( true)
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", @courseOR.convert_text( text, "agenda"))
  end
end

Then /^all pages' text should match "(.*?)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_tree_section.text.should match @courseOR.test_text("edit", text)
    page.logic_tab.click
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should match @courseOR.test_text("logic", @courseOR.convert_text( text, "logic"))
    page.update_rule_btn
  end
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", @courseOR.convert_text( text, "agenda"))
  end
  @courseOR.commit_changes( true)
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", @courseOR.convert_text( text, "agenda"))
    page.rule_edit
  end
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match @courseOR.test_text("edit", text)
    page.logic_tab.click
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should match @courseOR.test_text("logic", @courseOR.convert_text( text, "logic"))
  end
end

When /^I update the manage course offering agendas page$/ do
  on ManageCORequisites do |page|
    page.update_rule_btn
  end
end

When /^I move node "(.)" down$/ do |node|
  @courseOR.move_around(node, "down")
end

When /^I move node "(.)" up$/ do |node|
  @courseOR.move_around(node, "up")
end

When /^I move node "(.)" out of the group$/ do |node|
  @courseOR.move_around(node, "out")
end

When /^I move node "(.)" into the group$/ do |node|
  @courseOR.move_around(node, "in")
end

When /^I move node "(.)" out of and into the group$/ do |node|
  @courseOR.move_around(node, "out up in")
end

When /^I move node "(.)" out and in$/ do |node|
  @courseOR.move_around(node, "out in")
end

Then /^node "(.*)" should be after node "(.*)"$/ do |second,first|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(first)}\..+#{Regexp.escape(second)}\..*/m
  end
end

When /^I change the operator before node "(.*?)" to "(.*?)"$/ do |node, operator|
  @courseOR.change_operator(node, operator)
end

Then /^the first node should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /^Click on rule statement to edit\n[\s\t]*#{Regexp.escape(text)}.*/
  end
end

Then /^node "(.*)" should be a "(.*)" node in the tree$/ do |node, level|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.span(:text => /.*#{node}\..*/).id.should match @courseOR.test_node_level(level)
  end
end

Then /^there should be a dropdown with value "(.*)" before node "(.*)"$/ do |drop, node|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(drop)}.*#{Regexp.escape(node)}.*/m
  end
end

When /^I copy node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @courseOR.copy_cut_paste( node, node_after, "copy")
end

When /^I cut node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @courseOR.copy_cut_paste( node, node_after, "cut")
end

Then /^the Move In button should be disabled$/ do
  on ManageCORequisites do |page|
    if page.right_btn_element.attribute_value('disabled')
      page.right_btn_element.attribute_value('disabled').should == "true"
    end
  end
end

When /^I copy the group containing node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @courseOR.copy_cut_paste_group( node, node_after, "copy")
end

When /^I cut the group containing node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @courseOR.copy_cut_paste_group( node, node_after, "cut")
end

When /^I delete the group containing node "(.)"$/ do |node|
  @courseOR.delete_group( node)
end