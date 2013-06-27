When /^I (?:|setup|edit|have setup) the data for "(.*?)" for term "(.*?)" and course "(.*?)"$/ do |section, term, course|
  @manageCOR = make ManageCORequisitesData
  @courseOR = make CORequisitesData, :section => section
  @courseOR.data_setup(section, term, course)
end

When /^I (?:|navigate|have navigated) to the agenda page for "(.*?)" for term "(.*?)" and course "(.*?)"$/ do |section, term, course|
  @manageCOR = make ManageCORequisitesData
  @courseOR = make CORequisitesData, :section => section
  @courseOR.navigate(term, course)
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
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_edit
  end
end

When /^I want to add a new statement to the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_add
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
  @manageCOR.edit_existing_node(node, "course", change)
end

When /^I edit node "(.*?)" by adding course "(.*?)"$/ do |node, change|
  @manageCOR.edit_existing_node(node, "courses", change)
end

When /^I edit node "(.*?)" by changing text to "(.*?)"$/ do |node, change|
  @manageCOR.edit_existing_node(node, "text", change)
end

When /^I add a course statement after node "(.)" with course "([^\"]+)"$/ do |node, course|
  @manageCOR.create_course_rule( "add", node, course, @courseOR.section)
end

When /^I add a free form text statement after node "(.)" with text "([^\"]+)"$/ do |node, text|
  @manageCOR.create_text_rule( "add", node, text)
end

When /^I add a courses statement after node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @manageCOR.create_all_courses_rule( "add", node, course, set, "", @courseOR.section)
end

When /^I add a courses statement after node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @manageCOR.create_all_courses_rule( "add", node, course, "", "", @courseOR.section)
end

When /^I add a courses statement after node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @manageCOR.create_all_courses_rule( "add", node, "", set, "", @courseOR.section)
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, number, course, set|
  @manageCOR.create_number_courses_rule( "add", node, number, course, set, "", @courseOR.section)
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @manageCOR.create_number_courses_rule( "add", node, number, course, "", "", @courseOR.section)
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @manageCOR.create_number_courses_rule( "add", node, number, "", set, "", @courseOR.section)
end

When /^I add a repeated for credits statement after node "(.)" with "(\d+)" credits$/ do |node, number|
  @manageCOR.create_repeated_credit_rule( "add", node, number)
end

When /^I add a grade and courses statement after node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @manageCOR.create_grade_courses_rule( "add", node, course, "", "", type, grade, @courseOR.section)
end

When /^I add a grade and courses statement after node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @manageCOR.create_grade_courses_rule( "add", node, "", set, "", type, grade, @courseOR.section)
end

When /^I add a grade and number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, course, type, grade|
  @manageCOR.create_grade_number_courses_rule( "add", node, course, "", "", type, grade, number)
end

When /^I add a grade and number of courses statement after node "(.)" with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, set, type, grade|
  @manageCOR.create_grade_number_courses_rule( "add", node, "", set, "", type, grade, number)
end

When /^I add a gpa and courses statement after node "(.)" with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, course, gpa|
  @manageCOR.create_gpa_courses_rule( "add", node, course, "", "", gpa)
end

When /^I add a gpa and courses statement after node "(.)" with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, set, gpa|
  @manageCOR.create_gpa_courses_rule( "add", node, "", set, "", gpa)
end

When /^I add a new course statement with course "([^\"]+)"$/ do |course|
  @manageCOR.create_course_rule( "add", "", course, @courseOR.section)
end

When /^I add a new free form text statement with text "([^\"]+)"$/ do |text|
  @manageCOR.create_text_rule( "add", "", text)
end

When /^I add a new courses statement with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |course, set|
  @manageCOR.create_all_courses_rule( "add", "", course, set, "", @courseOR.section)
end

When /^I add a new courses statement with courses "([^\"]+)"$/ do |course|
  @manageCOR.create_all_courses_rule( "add", "", course, "", "", @courseOR.section)
end

When /^I add a new courses statement with course sets "([^\"]+)"$/ do |set|
  @manageCOR.create_all_courses_rule( "add", "", "", set, "", @courseOR.section)
end

When /^I add a new number of courses statement with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |number, course, set|
  @manageCOR.create_number_courses_rule( "add", "", number, course, set, "", @courseOR.section)
end

When /^I add a new number of courses statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @manageCOR.create_number_courses_rule( "add", "", number, course, "", "", @courseOR.section)
end

When /^I add a new number of courses statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @manageCOR.create_number_courses_rule( "add", "", number, "", set, "", @courseOR.section)
end

When /^I add a new no more than number of courses statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @manageCOR.create_less_number_courses_rule( "add", "", number, course, "", "", @courseOR.section)
end

When /^I add a new no more than number of courses statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @manageCOR.create_less_number_courses_rule( "add", "", number, "", set, "", @courseOR.section)
end

When /^I add a new repeated for credits statement with "(\d+)" credits$/ do |number|
  @manageCOR.create_repeated_credit_rule( "add", "", number)
end

When /^I add a new grade and courses statement with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |course, type, grade|
  @manageCOR.create_grade_courses_rule( "add", "", course, "", "", type, grade, @courseOR.section)
end

When /^I add a new grade and courses statement with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |set, type, grade|
  @manageCOR.create_grade_courses_rule( "add", "", "", set, "", type, grade, @courseOR.section)
end

When /^I add a new grade and number of courses statement with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |number, course, type, grade|
  @manageCOR.create_grade_number_courses_rule( "add", "", course, "", "", type, grade, number)
end

When /^I add a new grade and number of courses statement with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |number, set, type, grade|
  @manageCOR.create_grade_number_courses_rule( "add", "", "", set, "", type, grade, number)
end

When /^I add a new gpa and courses statement with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |course, gpa|
  @manageCOR.create_gpa_courses_rule( "add", "", course, "", "", gpa)
end

When /^I add a new gpa and courses statement with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |set, gpa|
  @manageCOR.create_gpa_courses_rule( "add", "", "", set, "", gpa)
end

When /^I add a new gpa and duration statement with GPA of "([\d\.]+)" and duration type "([^\"]+)" with duration "(\d+)"$/ do |gpa, type, duration|
  @manageCOR.create_gpa_duration_rule( "add", "", gpa, type, duration)
end

When /^I add a new program statement with program code "(.*?)"$/ do |program|
  @manageCOR.create_program_rule( "add", "", program, @courseOR.section)
end

When /^I add a new any program statement$/ do
  @manageCOR.create_any_program_rule( "add", "")
end

When /^I add a new permission of instructor required statement$/ do
  @manageCOR.create_permission_instructor_rule( "add", "")
end

When /^I add a new course and as of term statement with course "(.*?)" and term "(.*?)"$/ do |course, term|
  @manageCOR.create_course_term_rule( "add", "", course, term)
end

When /^I add a new course and prior to term statement with course "(.*?)" and term "(.*?)"$/ do |course, term|
  @manageCOR.create_course_term_rule( "add", "", course, term, "prior to")
end

When /^I add a new course and two terms statement with course "(.*?)" between terms one "(.*?)" and two "(.*?)"$/ do |course, term1, term2|
  @manageCOR.create_course_between_terms_rule( "add", "", course, term1, term2)
end

When /^I add a new program and class standing statement with program code "(.*?)" and class standing "(.*?)"$/ do |program, stand|
  @manageCOR.create_program_class_standing_rule( "add", "", program, stand)
end

When /^I add a new program offered by org statement with "(.*?)"$/ do |org|
  @manageCOR.create_program_org_rule( "add", "", org)
end

When /^I group course statement with node "(.)" with course "([^\"]+)"$/ do |node, course|
  @manageCOR.create_course_rule( "group", node, course, @courseOR.section)
end

When /^I group free form text statement with node "(.)" with text "([^\"]+)"$/ do |node, text|
  @manageCOR.create_text_rule( "group", node, text)
end

When /^I group courses statement with node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @manageCOR.create_all_courses_rule( "group", node, course, "", "", @courseOR.section)
end

When /^I group courses statement with node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @manageCOR.create_all_courses_rule( "group", node, "", set, "", @courseOR.section)
end

When /^I group number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @manageCOR.create_number_courses_rule( "group", node, number, course, "", "", @courseOR.section)
end

When /^I group number of courses statement with node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @manageCOR.create_number_courses_rule( "group", node, number, "", set, "", @courseOR.section)
end

When /^I group repeated for credits statement with node "(.)" with "(\d+)" credits$/ do |node, number|
  @manageCOR.create_repeated_credit_rule( "group", node, number)
end

When /^I group grade and courses statement with node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @manageCOR.create_grade_courses_rule( "group", node, course, "", "", type, grade, @courseOR.section)
end

When /^I group grade and courses statement with node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @manageCOR.create_grade_courses_rule( "group", node, "", set, "", type, grade, @courseOR.section)
end

When /^I group grade and number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, course, type, grade|
  @manageCOR.create_grade_number_courses_rule( "group", node, course, "", "", type, grade, number)
end

When /^I group grade and number of courses statement with node "(.)" with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, set, type, grade|
  @manageCOR.create_grade_number_courses_rule( "group", node, "", set, "", type, grade, number)
end

When /^I group gpa and courses statement with node "(.)" with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, course, gpa|
  @manageCOR.create_gpa_courses_rule( "group", node, course, "", "", gpa)
end

When /^I group gpa and courses statement with node "(.)" with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, set, gpa|
  @manageCOR.create_gpa_courses_rule( "group", node, "", set, "", gpa)
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
    page.edit_tree_section.text.should_not =~ /.*#{Regexp.escape(node)}\..*/
    page.logic_tab
    page.edit_loading.wait_while_present
    page.logic_text.text.should_not =~ /.*#{Regexp.escape(node)}.*/
  end
end

When /^I delete the tree in the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_delete
  end
end

Then /^the agenda page should have the text "(.*)"$/ do |text|
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.agenda_management_section.text.should match @manageCOR.test_text("agenda", text)
  end
end

Then /^the agenda page should not have the text "(.*)"$/ do |text|
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.agenda_management_section.text.should_not match @manageCOR.test_text("agenda", text)
  end
end

Then /^the "(.*?)" tab should have the text "(.*)"$/ do |section,text|
  sect = {"edit"=>:edit_tree_section, "logic"=>:preview_tree_section}
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.send(sect[section]).text.should match @manageCOR.test_text(section, text)
  end
end

Then /^the "(.*?)" tab should not have the text "(.*)"$/ do |section,text|
  sect = {"edit"=>:edit_tree_section, "logic"=>:preview_tree_section}
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.send(sect[section]).text.should_not match @manageCOR.test_text(section, text)
  end
end

Then /^the CO and CLU should both have text "(.*?)"/ do |text|
  on CourseOfferingRequisites do |page|
    page.compare_tree.text.should match @manageCOR.test_text("compare", text)
  end
end

Then /^the CO and CLU should differ with text "(.*?)"/ do |text|
  on CourseOfferingRequisites do |page|
    page.compare_tree.text.should_not match @manageCOR.test_text("compare", text)
  end
end

When /^I switch to the other tab on the page$/ do
  @manageCOR.switch_tabs
end

Then /^the text "(.*)" should be present in the text area$/ do |text|
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

Then /^both tabs should have the text "(.*?)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_tree_section.text.should match @manageCOR.test_text("edit", text)
    page.logic_tab.click
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should match @manageCOR.test_text("logic", @manageCOR.convert_text( text, "logic"))
  end
end

Then /^the agenda page should before and after the submit have the text "(.*?)"$/ do |text|
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @manageCOR.test_text("agenda", @manageCOR.convert_text( text, "agenda"))
  end
  @courseOR.commit_changes( true)
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @manageCOR.test_text("agenda", @manageCOR.convert_text( text, "agenda"))
  end
end

Then /^all pages should have the text "(.*?)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_tree_section.text.should match @manageCOR.test_text("edit", text)
    page.logic_tab.click
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should match @manageCOR.test_text("logic", @manageCOR.convert_text( text, "logic"))
    page.update_rule_btn
  end
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @manageCOR.test_text("agenda", @manageCOR.convert_text( text, "agenda"))
  end
  @courseOR.commit_changes( true)
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should match @manageCOR.test_text("agenda", @manageCOR.convert_text( text, "agenda"))
    page.rule_edit
  end
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match @manageCOR.test_text("edit", text)
    page.logic_tab.click
    page.edit_loading.wait_while_present
    page.preview_tree_section.text.should match @manageCOR.test_text("logic", @manageCOR.convert_text( text, "logic"))
  end
end

When /^I update the manage course offering agendas page$/ do
  on ManageCORequisites do |page|
    page.update_rule_btn
  end
end

When /^I move node "(.)" down$/ do |node|
  @manageCOR.move_around(node, "down")
end

When /^I move node "(.)" up$/ do |node|
  @manageCOR.move_around(node, "up")
end

When /^I move node "(.)" out of the group$/ do |node|
  @manageCOR.move_around(node, "out")
end

When /^I move node "(.)" into the group$/ do |node|
  @manageCOR.move_around(node, "in")
end

When /^I move node "(.)" out of and into the group$/ do |node|
  @manageCOR.move_around(node, "out up in")
end

When /^I move node "(.)" out and in$/ do |node|
  @manageCOR.move_around(node, "out in")
end

Then /^node "(.*)" should be after node "(.*)"$/ do |second,first|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(first)}\..+#{Regexp.escape(second)}\..*/m
  end
end

When /^I change a "(.*?)" logical operator to "(.*?)"$/ do |level, operator|
  @manageCOR.change_operator(level, operator)
end

Then /^the first node should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(text)}.*/
  end
end

Then /^node "(.*)" should be a "(.*)" node in the tree$/ do |node, level|
  @manageCOR.test_node_level(level, node)
end

Then /^there should be a dropdown with value "(.*)" before node "(.*)"$/ do |drop, node|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(drop)}.*#{Regexp.escape(node)}.*/m
  end
end

When /^I copy node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @manageCOR.copy_cut_paste( node, node_after, "copy")
end

When /^I cut node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @manageCOR.copy_cut_paste( node, node_after, "cut")
end

Then /^the Move In button should be disabled$/ do
  on ManageCORequisites do |page|
    if page.right_btn_element.attribute_value('disabled')
      puts page.right_btn_element.attribute_value('disabled') #.should == "disabled"
    end
  end
end

When /^I copy a "(.*?)" group and paste it after node "(.)"$/ do |level, node|
  @manageCOR.copy_cut_paste_group( level, node, "copy")
end

When /^I cut a "(.*?)" group and paste it after node "(.)"$/ do |level, node|
  @manageCOR.copy_cut_paste_group( level, node, "cut")
end