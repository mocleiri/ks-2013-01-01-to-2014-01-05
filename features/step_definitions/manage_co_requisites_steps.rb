#############################
#Antirequisite
When /^I (?:|setup|edit|have setup) the Antirequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @antireq = make AntirequisiteRule, :course => course
  @antireq.ar_data_setup
end

When /^I (?:|setup|edit|have setup) the Antirequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @antireq = make AntirequisiteRule, :term => "201301", :course => course
  @antireq.ar_data_setup
end

When /^I (?:|navigate|have navigated) to the Antirequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @antireq = make AntirequisiteRule, :course => course
  @antireq.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Antirequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @antireq = make AntirequisiteRule, :term => "201301", :course => course
  @antireq.navigate_to_mco_requisites
end

When /^I add a not completed course statement after node "(.)" with course "([^\"]+)"$/ do |node, course|
  @antireq.ar_course_rule( "add", node, course)
end

When /^I add an Antirequisite text statement after node "(.)" with text "([^\"]+)"$/ do |node, text|
  @antireq.ar_text_rule( "add", node, text)
end

When /^I add a not completed courses statement after node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @antireq.ar_all_courses_rule( "add", node, course, set, "")
end

When /^I add a not completed courses statement after node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @antireq.ar_all_courses_rule( "add", node, course, "", "")
end

When /^I add a not completed courses statement after node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @antireq.ar_all_courses_rule( "add", node, "", set, "")
end

When /^I add a not earned grade and courses statement after node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @antireq.ar_grade_courses_rule( "add", node, course, "", "", type, grade)
end

When /^I add a not earned grade and courses statement after node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @antireq.ar_grade_courses_rule( "add", node, "", set, "", type, grade)
end

When /^I add a new not completed course statement with course "([^\"]+)"$/ do |course|
  @antireq.ar_course_rule( "add", "", course)
end

When /^I add a new Antirequisite text statement with text "([^\"]+)"$/ do |text|
  @antireq.ar_text_rule( "add", "", text)
end

When /^I add a new not completed courses statement with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |course, set|
  @antireq.ar_all_courses_rule( "add", "", course, set, "")
end

When /^I add a new not completed courses statement with courses "([^\"]+)"$/ do |course|
  @antireq.ar_all_courses_rule( "add", "", course, "", "")
end

When /^I add a new not completed courses statement with course sets "([^\"]+)"$/ do |set|
  @antireq.ar_all_courses_rule( "add", "", "", set, "")
end

When /^I add a new not earned grade and courses statement with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |course, type, grade|
  @antireq.ar_grade_courses_rule( "add", "", course, "", "", type, grade)
end

When /^I add a new not earned grade and courses statement with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |set, type, grade|
  @antireq.ar_grade_courses_rule( "add", "", "", set, "", type, grade)
end

When /^I group a not completed course statement with node "(.)" with course "([^\"]+)"$/ do |node, course|
  @antireq.ar_course_rule( "group", node, course)
end

When /^I group an Antirequisite text statement with node "(.)" with text "([^\"]+)"$/ do |node, text|
  @antireq.ar_text_rule( "group", node, text)
end

When /^I group a not completed courses statement with node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @antireq.ar_all_courses_rule( "group", node, course, set, "")
end

When /^I group a not completed courses statement with node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @antireq.ar_all_courses_rule( "group", node, course, "", "")
end

When /^I group a not completed courses statement with node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @antireq.ar_all_courses_rule( "group", node, "", set, "")
end

When /^I group a not earned grade and courses statement with node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @antireq.ar_grade_courses_rule( "group", node, course, "", "", type, grade)
end

When /^I group a not earned grade and courses statement with node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @antireq.ar_grade_courses_rule( "group", node, "", set, "", type, grade)
end

When /^I want to edit the Antirequisite section$/ do
  @antireq.ar_edit_add( "edit")
end

When /^I want to add a new statement to the Antirequisite section$/ do
  @antireq.ar_edit_add( "add")
end

When /^I delete the tree in the Antirequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.antireq_delete
  end
end

When /^I want to compare the CO to the CLU for the Antirequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.antireq_compare
  end
end

When /^I add a new text statement to the Antirequisite section$/ do
  @courseOR = make CORequisitesData
  @antireq = make AntirequisiteRule, :section => "Antirequisite", :term => "201208", :course => "CHEM272"
  @antireq.navigate_to_mco_requisites
  @antireq.ar_edit_add( "add")
  @antireq.ar_text_rule( "add", "", "Added Antirequisite on CO level")
  @antireq.commit_changes
end

Then /^the tree in the Antirequisite section should be empty$/ do
  @antireq.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should =~ /.*Antirequisite.*Rule.*\.\nCredit Constraints.*/m
  end
end

Then /^the Compare to Catalog link should exist for the Antirequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.antireq_compare_link.should exist
  end
end
#############################
#Corequisite
When /^I (?:|setup|edit|have setup) the Corequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @coreq = make CorequisiteRule, :course => course
  @coreq.cr_data_setup
end

When /^I (?:|setup|edit|have setup) the Corequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @coreq = make CorequisiteRule, :term => "201301", :course => course
  @coreq.cr_data_setup
end

When /^I (?:|navigate|have navigated) to the Corequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @coreq = make CorequisiteRule, :course => course
  @coreq.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Corequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @coreq = make CorequisiteRule, :term => "201301", :course => course
  @coreq.navigate_to_mco_requisites
end

When /^I add a concurrently enrolled course statement after node "(.)" with course "([^\"]+)"$/ do |node, course|
  @coreq.cr_course_rule( "add", node, course)
end

When /^I add a Corequisite text statement after node "(.)" with text "([^\"]+)"$/ do |node, text|
  @coreq.cr_text_rule( "add", node, text)
end

When /^I add a concurrently enrolled courses statement after node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @coreq.cr_all_courses_rule( "add", node, course, set, "")
end

When /^I add a concurrently enrolled courses statement after node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @coreq.cr_all_courses_rule( "add", node, course, "", "")
end

When /^I add a concurrently enrolled courses statement after node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @coreq.cr_all_courses_rule( "add", node, "", set, "")
end

When /^I add a concurrently enrolled number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, number, course, set|
  @coreq.cr_number_courses_rule( "add", node, number, course, set, "")
end

When /^I add a concurrently enrolled number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @coreq.cr_number_courses_rule( "add", node, number, course, "", "")
end

When /^I add a concurrently enrolled number of courses statement after node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @coreq.cr_number_courses_rule( "add", node, number, "", set, "")
end

When /^I add a new concurrently enrolled course statement with course "([^\"]+)"$/ do |course|
  @coreq.cr_course_rule( "add", "", course)
end

When /^I add a new Corequisite text statement with text "([^\"]+)"$/ do |text|
  @coreq.cr_text_rule( "add", "", text)
end

When /^I add a new concurrently enrolled courses statement with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |course, set|
  @coreq.cr_all_courses_rule( "add", "", course, set, "")
end

When /^I add a new concurrently enrolled courses statement with courses "([^\"]+)"$/ do |course|
  @coreq.cr_all_courses_rule( "add", "", course, "", "")
end

When /^I add a new concurrently enrolled courses statement with course sets "([^\"]+)"$/ do |set|
  @coreq.cr_all_courses_rule( "add", "", "", set, "")
end

When /^I add a new concurrently enrolled number of courses statement with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |number, course, set|
  @coreq.cr_number_courses_rule( "add", "", number, course, set, "")
end

When /^I add a new concurrently enrolled number of courses statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @coreq.cr_number_courses_rule( "add", "", number, course, "", "")
end

When /^I add a new concurrently enrolled number of courses statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @coreq.cr_number_courses_rule( "add", "", number, "", set, "")
end

When /^I group a concurrently enrolled course statement with node "(.)" with course "([^\"]+)"$/ do |node, course|
  @coreq.cr_course_rule( "group", node, course)
end

When /^I group a Corequisite text statement with node "(.)" with text "([^\"]+)"$/ do |node, text|
  @coreq.cr_text_rule( "group", node, text)
end

When /^I group a concurrently enrolled courses statement with node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @coreq.cr_all_courses_rule( "group", node, course, set, "")
end

When /^I group a concurrently enrolled courses statement with node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @coreq.cr_all_courses_rule( "group", node, course, "", "")
end

When /^I group a concurrently enrolled courses statement with node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @coreq.cr_all_courses_rule( "group", node, "", set, "")
end

When /^I group a concurrently enrolled number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, number, course, set|
  @coreq.cr_number_courses_rule( "group", node, number, course, set, "")
end

When /^I group a concurrently enrolled number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @coreq.cr_number_courses_rule( "group", node, number, course, "", "")
end

When /^I group a concurrently enrolled number of courses statement with node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @coreq.cr_number_courses_rule( "group", node, number, "", set, "")
end

When /^I want to edit the Corequisite section$/ do
  @coreq.cr_edit_add( "edit")
end

When /^I want to add a new statement to the Corequisite section$/ do
  @coreq.cr_edit_add( "add")
end

When /^I delete the tree in the Corequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.coreq_delete
  end
end

When /^I want to compare the CO to the CLU for the Corequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.coreq_compare
  end
end

Then /^the tree in the Corequisite section should be empty$/ do
  @coreq.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should =~ /.*Corequisite.*Rule.*\.\nRecommended Preparation.*/m
  end
end

Then /^the Compare to Catalog link should exist for the Corequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.coreq_compare_link.should exist
  end
end
#############################
#Recommended Preparation AND Student Eligibility & Prerequisite
When /^I (?:|setup|edit|have setup) the Recommended Preparation section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :section => "Recommended Preparation", :course => course
  @prereq.rp_data_setup
end

When /^I (?:|setup|edit|have setup) the Recommended Preparation section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @recPrep = make PreparationPrerequisiteRule, :section => "Recommended Preparation", :term => "201301", :course => course
  @prereq.rp_data_setup
end

When /^I (?:|navigate|have navigated) to the Recommended Preparation section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :section => "Recommended Preparation", :course => course
  @prereq.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Recommended Preparation section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :section => "Recommended Preparation", :term => "201301", :course => course
  @prereq.navigate_to_mco_requisites
end

When /^I (?:|setup|edit|have setup) the Student Eligibility & Prerequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :course => course
  @prereq.sepr_data_setup
end

When /^I (?:|setup|edit|have setup) the Student Eligibility & Prerequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :term => "201301", :course => course
  @prereq.sepr_data_setup
end

When /^I (?:|navigate|have navigated) to the Student Eligibility & Prerequisite section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :course => course
  @prereq.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Student Eligibility & Prerequisite section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :term => "201301", :course => course
  @prereq.navigate_to_mco_requisites
end

When /^I add a course statement after node "(.)" with course "([^\"]+)"$/ do |node, course|
  @prereq.rp_sepr_course_rule( "add", node, course)
end

When /^I add a text statement after node "(.)" with text "([^\"]+)"$/ do |node, text|
  @prereq.rp_sepr_text_rule( "add", node, text)
end

When /^I add a courses statement after node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @prereq.rp_sepr_all_courses_rule( "add", node, course, set, "")
end

When /^I add a courses statement after node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @prereq.rp_sepr_all_courses_rule( "add", node, course, "", "")
end

When /^I add a courses statement after node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @prereq.rp_sepr_all_courses_rule( "add", node, "", set, "")
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, number, course, set|
  @prereq.rp_sepr_number_courses_rule( "add", node, number, course, set, "")
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @prereq.rp_sepr_number_courses_rule( "add", node, number, course, "", "")
end

When /^I add a number of courses statement after node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @prereq.rp_sepr_number_courses_rule( "add", node, number, "", set, "")
end

When /^I add a grade and courses statement after node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @prereq.rp_sepr_grade_courses_rule( "add", node, course, "", "", type, grade)
end

When /^I add a grade and courses statement after node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @prereq.rp_sepr_grade_courses_rule( "add", node, "", set, "", type, grade)
end

When /^I add a grade and number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, course, type, grade|
  @prereq.rp_sepr_grade_number_courses_rule( "add", node, course, "", "", type, grade, number)
end

When /^I add a grade and number of courses statement after node "(.)" with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, set, type, grade|
  @prereq.rp_sepr_grade_number_courses_rule( "add", node, "", set, "", type, grade, number)
end

When /^I add a gpa and courses statement after node "(.)" with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, course, gpa|
  @prereq.rp_sepr_gpa_courses_rule( "add", node, course, "", "", gpa)
end

When /^I add a gpa and courses statement after node "(.)" with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, set, gpa|
  @prereq.rp_sepr_gpa_courses_rule( "add", node, "", set, "", gpa)
end

When /^I add a gpa and duration statement after node "(.)" with GPA of "([\d\.]+)" and duration type "([^\"]+)" with duration "(\d+)"$/ do |node, gpa, type, duration|
  @prereq.rp_sepr_gpa_duration_rule( "add", node, gpa, type, duration)
end

When /^I add a minimum number of credits and org rule after node "(.)" with "([\d\.]+)" credits and org "(.*?)"$/ do |node, credit, org|
  @prereq.rp_sepr_min_credits_org_rule( "add", node, org, credit)
end

When /^I add a course and as of term statement after node "(.)" with course "(.*?)" and term "(.*?)"$/ do |node, course, term|
  @prereq.rp_sepr_course_term_rule( "add", node, course, term)
end

When /^I add a course and prior to term statement after node "(.)" with course "(.*?)" and term "(.*?)"$/ do |node, course, term|
  @prereq.rp_sepr_course_term_rule( "add", node, course, term, "prior to")
end

When /^I add a no more than number of courses statement after node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @prereq.rp_sepr_less_number_courses_rule( "add", node, number, course, "", "")
end

When /^I add a new course statement with course "([^\"]+)"$/ do |course|
  @prereq.rp_sepr_course_rule( "add", "", course)
end

When /^I add a new text statement with text "([^\"]+)"$/ do |text|
  @prereq.rp_sepr_text_rule( "add", "", text)
end

When /^I add a new courses statement with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |course, set|
  @prereq.rp_sepr_all_courses_rule( "add", "", course, set, "")
end

When /^I add a new courses statement with courses "([^\"]+)"$/ do |course|
  @prereq.rp_sepr_all_courses_rule( "add", "", course, "", "")
end

When /^I add a new courses statement with course sets "([^\"]+)"$/ do |set|
  @prereq.rp_sepr_all_courses_rule( "add", "", "", set, "")
end

When /^I add a new number of courses statement with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |number, course, set|
  @prereq.rp_sepr_number_courses_rule( "add", "", number, course, set, "")
end

When /^I add a new number of courses statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @prereq.rp_sepr_number_courses_rule( "add", "", number, course, "", "")
end

When /^I add a new number of courses statement with number "(\d+)" and course sets "([^\"]+)"$/ do |number, set|
  @prereq.rp_sepr_number_courses_rule( "add", "", number, "", set, "")
end

When /^I add a new grade and courses statement with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |course, type, grade|
  @prereq.rp_sepr_grade_courses_rule( "add", "", course, "", "", type, grade)
end

When /^I add a new grade and courses statement with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |set, type, grade|
  @prereq.rp_sepr_grade_courses_rule( "add", "", "", set, "", type, grade)
end

When /^I add a new grade and number of courses statement with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |number, course, type, grade|
  @prereq.rp_sepr_grade_number_courses_rule( "add", "", course, "", "", type, grade, number)
end

When /^I add a new grade and number of courses statement with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |number, set, type, grade|
  @prereq.rp_sepr_grade_number_courses_rule( "add", "", "", set, "", type, grade, number)
end

When /^I add a new gpa and courses statement with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |course, gpa|
  @prereq.rp_sepr_gpa_courses_rule( "add", "", course, "", "", gpa)
end

When /^I add a new gpa and courses statement with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |set, gpa|
  @prereq.rp_sepr_gpa_courses_rule( "add", "", "", set, "", gpa)
end

When /^I add a new gpa and duration statement with GPA of "([\d\.]+)" and duration type "([^\"]+)" with duration "(\d+)"$/ do |gpa, type, duration|
  @prereq.rp_sepr_gpa_duration_rule( "add", "", gpa, type, duration)
end

When /^I add a new minimum number of credits and org rule with "([\d\.]+)" credits and org "(.*?)"$/ do |credit, org|
  @prereq.rp_sepr_min_credits_org_rule( "add", "", org, credit)
end

When /^I add a new course and as of term statement with course "(.*?)" and term "(.*?)"$/ do |course, term|
  @prereq.rp_sepr_course_term_rule( "add", "", course, term)
end

When /^I add a new course and prior to term statement with course "(.*?)" and term "(.*?)"$/ do |course, term|
  @prereq.rp_sepr_course_term_rule( "add", "", course, term, "prior to")
end

When /^I add a new no more than number of courses statement with number "(\d+)" and courses "([^\"]+)"$/ do |number, course|
  @prereq.rp_sepr_less_number_courses_rule( "add", "", number, course, "", "")
end

When /^I group a course statement with node "(.)" with course "([^\"]+)"$/ do |node, course|
  @prereq.rp_sepr_course_rule( "group", node, course)
end

When /^I group a text statement with node "(.)" with text "([^\"]+)"$/ do |node, text|
  @prereq.rp_sepr_text_rule( "group", node, text)
end

When /^I group a courses statement with node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @prereq.rp_sepr_all_courses_rule( "group", node, course, set, "")
end

When /^I group a courses statement with node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @prereq.rp_sepr_all_courses_rule( "group", node, course, "", "")
end

When /^I group a courses statement with node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @prereq.rp_sepr_all_courses_rule( "group", node, "", set, "")
end

When /^I group a number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, number, course, set|
  @prereq.rp_sepr_number_courses_rule( "group", node, number, course, set, "")
end

When /^I group a number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @prereq.rp_sepr_number_courses_rule( "group", node, number, course, "", "")
end

When /^I group a number of courses statement with node "(.)" with number "(\d+)" and course sets "([^\"]+)"$/ do |node, number, set|
  @prereq.rp_sepr_number_courses_rule( "group", node, number, "", set, "")
end

When /^I group a grade and courses statement with node "(.)" with courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, course, type, grade|
  @prereq.rp_sepr_grade_courses_rule( "group", node, course, "", "", type, grade)
end

When /^I group a grade and courses statement with node "(.)" with course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, set, type, grade|
  @prereq.rp_sepr_grade_courses_rule( "group", node, "", set, "", type, grade)
end

When /^I group a grade and number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, course, type, grade|
  @prereq.rp_sepr_grade_number_courses_rule( "group", node, course, "", "", type, grade, number)
end

When /^I group a grade and number of courses statement with node "(.)" with number "(\d+)" and course sets "([^\"]+)" and grade type "([^\"]+)" with grade "([^\"]+)"$/ do |node, number, set, type, grade|
  @prereq.rp_sepr_grade_number_courses_rule( "group", node, "", set, "", type, grade, number)
end

When /^I group a gpa and courses statement with node "(.)" with courses "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, course, gpa|
  @prereq.rp_sepr_gpa_courses_rule( "group", node, course, "", "", gpa)
end

When /^I group a gpa and courses statement with node "(.)" with course sets "([^\"]+)" and GPA of "([^\"]+)"$/ do |node, set, gpa|
  @prereq.rp_sepr_gpa_courses_rule( "group", node, "", set, "", gpa)
end

When /^I group a gpa and duration statement with node "(.)" with GPA of "([\d\.]+)" and duration type "([^\"]+)" with duration "(\d+)"$/ do |node, gpa, type, duration|
  @prereq.rp_sepr_gpa_duration_rule( "group", node, gpa, type, duration)
end

When /^I group a minimum number of credits and org rule with node "(.)" with "([\d\.]+)" credits and org "(.*?)"$/ do |node, credit, org|
  @prereq.rp_sepr_min_credits_org_rule( "group", node, org, credit)
end

When /^I group a course and as of term statement with node "(.)" with course "(.*?)" and term "(.*?)"$/ do |node, course, term|
  @prereq.rp_sepr_course_term_rule( "group", node, course, term)
end

When /^I group a course and prior to term statement with node "(.)" with course "(.*?)" and term "(.*?)"$/ do |node, course, term|
  @prereq.rp_sepr_course_term_rule( "group", node, course, term, "prior to")
end

When /^I group a no more than number of courses statement with node "(.)" with number "(\d+)" and courses "([^\"]+)"$/ do |node, number, course|
  @prereq.rp_sepr_less_number_courses_rule( "group", node, number, course, "", "")
end

When /^I want to edit the Recommended Preparation section$/ do
  @prereq.rp_edit_add( "edit")
end

When /^I want to add a new statement to the Recommended Preparation section$/ do
  @prereq.rp_edit_add( "add")
end

When /^I want to edit the Student Eligibility & Prerequisite section$/ do
  @prereq.sepr_edit_add( "edit")
end

When /^I want to add a new statement to the Student Eligibility & Prerequisite section$/ do
  @prereq.sepr_edit_add( "add")
end

When /^I delete the tree in the Recommended Preparation section$/ do
  on CourseOfferingRequisites do |page|
    page.prep_delete
  end
end

When /^I delete the tree in the Student Eligibility & Prerequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.prereq_delete
  end
end

When /^I want to compare the CO to the CLU for the Recommended Preparation section$/ do
  on CourseOfferingRequisites do |page|
    page.prep_compare
  end
end

When /^I want to compare the CO to the CLU for the Student Eligibility & Prerequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.prereq_compare
  end
end

When /^I add a new text statement to the Recommended Preparation section$/ do
  @courseOR = make CORequisitesData
  @prereq = make PreparationPrerequisiteRule, :section => "Recommended Preparation", :term => "201208", :course => "PHYS272"
  @prereq.navigate_to_mco_requisites
  @prereq.rp_edit_add( "add")
  @prereq.rp_sepr_text_rule( "add", "", "Added Recommended Prep on CO level")
  @prereq.commit_changes
end

Then /^the tree in the Recommended Preparation section should be empty$/ do
  @prereq.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should =~ /.*Recommended Preparation.*Rule.*\.\nAntirequisite.*/m
  end
end

Then /^the tree in the Student Eligibility & Prerequisite section should be empty$/ do
  @prereq.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should =~ /.*Student Eligibility & Prerequisite.*Rule.*\.\nCorequisite.*/m
  end
end

Then /^the Compare to Catalog link should exist for the Student Eligibility & Prerequisite section$/ do
  on CourseOfferingRequisites do |page|
    page.prereq_compare_link.should exist
  end
end

Then /^the Compare to Catalog link should exist for the Recommended Preparation section$/ do
  on CourseOfferingRequisites do |page|
    page.prep_compare_link.should exist
  end
end
#############################
#Repeatable for Credit
When /^I (?:|setup|edit|have setup) the Repeatable for Credit section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @repeat = make RepeatCreditRule, :course => course
  @repeat.rc_data_setup
end

When /^I (?:|setup|edit|have setup) the Repeatable for Credit section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @repeat = make RepeatCreditRule, :term => "201301", :course => course
  @repeat.rc_data_setup
end

When /^I (?:|navigate|have navigated) to the Repeatable for Credit section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @repeat = make RepeatCreditRule, :course => course
  @repeat.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Repeatable for Credit section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @repeat = make RepeatCreditRule, :term => "201301", :course => course
  @repeat.navigate_to_mco_requisites
end

When /^I add a Repeated for credits statement after node "(.)" with "(\d+)" credits$/ do |node, number|
  @repeat.rc_repeated_credit_rule( "add", node, number)
end

When /^I add a Repeated text statement after node "(.)" with text "([^\"]+)"$/ do |node, text|
  @repeat.rc_text_rule( "add", node, text)
end

When /^I add a new Repeated for credits statement with "(\d+)" credits$/ do |number|
  @repeat.rc_repeated_credit_rule( "add", "", number)
end

When /^I add a new Repeated text statement with text "([^\"]+)"$/ do |text|
  @repeat.rc_text_rule( "add", "", text)
end

When /^I group a Repeated for credits statement with node "(.)" with "(\d+)" credits$/ do |node, number|
  @repeat.rc_repeated_credit_rule( "group", node, number)
end

When /^I group a Repeated text statement with node "(.)" with text "([^\"]+)"$/ do |node, text|
  @repeat.rc_text_rule( "group", node, text)
end

When /^I want to edit the Repeatable for Credit section$/ do
  @repeat.rc_edit_add( "edit")
end

When /^I want to add a new statement to the Repeatable for Credit section$/ do
  @repeat.rc_edit_add( "add")
end

When /^I delete the tree in the Repeatable for Credit section$/ do
  on CourseOfferingRequisites do |page|
    page.repeat_delete
  end
end

When /^I want to compare the CO to the CLU for the Repeatable for Credit section$/ do
  on CourseOfferingRequisites do |page|
    page.repeat_compare
  end
end

Then /^the tree in the Repeatable for Credit section should be empty$/ do
  @repeat.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should =~ /.*Repeatable for Credit.*Rule.*\.\nCourse that Restricts Credits.*/m
  end
end

Then /^the Compare to Catalog link should exist for the Repeatable for Credit section$/ do
  on CourseOfferingRequisites do |page|
    page.repeat_compare_link.should exist
  end
end
#############################
#Course that Restricts Credits
When /^I (?:|setup|edit|have setup) the Course that Restricts Credits section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @restrict = make RestrictCreditRule, :course => course
  @restrict.crc_data_setup
end

When /^I (?:|setup|edit|have setup) the Course that Restricts Credits section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @restrict = make RestrictCreditRule, :term => "201301", :course => course
  @restrict.crc_data_setup
end

When /^I (?:|navigate|have navigated) to the Course that Restricts Credits section for course "(.*?)" in the historic term$/ do |course|
  @courseOR = make CORequisitesData
  @restrict = make RestrictCreditRule, :course => course
  @restrict.navigate_to_mco_requisites
end

When /^I (?:|navigate|have navigated) to the Course that Restricts Credits section for course "(.*?)" in the future term$/ do |course|
  @courseOR = make CORequisitesData
  @restrict = make RestrictCreditRule, :term => "201301", :course => course
  @restrict.navigate_to_mco_requisites
end

When /^I add a Restricted course statement after node "(.)" with course "([^\"]+)"$/ do |node, course|
  @restrict.crc_course_rule( "add", node, course)
end

When /^I add a Restricted text statement after node "(.)" with text "([^\"]+)"$/ do |node, text|
  @restrict.crc_text_rule( "add", node, text)
end

When /^I add a Restricted courses statement after node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @restrict.crc_all_courses_rule( "add", node, course, set, "")
end

When /^I add a Restricted courses statement after node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @restrict.crc_all_courses_rule( "add", node, course, "", "")
end

When /^I add a Restricted courses statement after node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @restrict.crc_all_courses_rule( "add", node, "", set, "")
end

When /^I add a new Restricted course statement with course "([^\"]+)"$/ do |course|
  @restrict.crc_course_rule( "add", "", course)
end

When /^I add a new Restricted text statement with text "([^\"]+)"$/ do |text|
  @restrict.crc_text_rule( "add", "", text)
end

When /^I add a new Restricted courses statement with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |course, set|
  @restrict.crc_all_courses_rule( "add", "", course, set, "")
end

When /^I add a new Restricted courses statement with courses "([^\"]+)"$/ do |course|
  @restrict.crc_all_courses_rule( "add", "", course, "", "")
end

When /^I add a new Restricted courses statement with course sets "([^\"]+)"$/ do |set|
  @restrict.crc_all_courses_rule( "add", "", "", set, "")
end

When /^I group a Restricted course statement with node "(.)" with course "([^\"]+)"$/ do |node, course|
  @restrict.crc_course_rule( "group", node, course)
end

When /^I group a Restricted text statement with node "(.)" with text "([^\"]+)"$/ do |node, text|
  @restrict.crc_text_rule( "group", node, text)
end

When /^I group a Restricted courses statement with node "(.)" with courses "([^\"]+)" and course sets "([^\"]+)"$/ do |node, course, set|
  @restrict.crc_all_courses_rule( "group", node, course, set, "")
end

When /^I group a Restricted courses statement with node "(.)" with courses "([^\"]+)"$/ do |node, course|
  @restrict.crc_all_courses_rule( "group", node, course, "", "")
end

When /^I group a Restricted courses statement with node "(.)" with course sets "([^\"]+)"$/ do |node, set|
  @restrict.crc_all_courses_rule( "group", node, "", set, "")
end

When /^I want to edit the Course that Restricts Credits section$/ do
  @restrict.crc_edit_add( "edit")
end

When /^I want to add a new statement to the Course that Restricts Credits section$/ do
  @restrict.crc_edit_add( "add")
end

When /^I delete the tree in the Course that Restricts Credits section$/ do
  on CourseOfferingRequisites do |page|
    page.restrict_delete
  end
end

When /^I want to compare the CO to the CLU for the Course that Restricts Credits section$/ do
  on CourseOfferingRequisites do |page|
    page.restrict_compare
  end
end

Then /^the tree in the Course that Restricts Credits section should be empty$/ do
  @restrict.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    page.agenda_management_section.text.should =~ /.*Course that Restricts Credits.*Rule.*\.\n.*/m
  end
end

Then /^the Compare to Catalog link should exist for the Course that Restricts Credits section$/ do
  on CourseOfferingRequisites do |page|
    page.restrict_compare_link.should exist
  end
end
#############################
#Steps used by all rule types
When /^I commit and return to see the changes made to the proposition$/ do
  @courseOR.commit_changes( true)  #:return_to_edit_page =>
end

When /^I commit changes made to the proposition$/ do
  @courseOR.commit_changes
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

When /^I switch to the other tab on the page$/ do
  @courseOR.switch_tabs
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

When /^I change the operator before node "(.*?)" to "(.*?)"$/ do |node, operator|
  @courseOR.change_operator(node, operator)
end

When /^I copy node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @courseOR.copy_cut_paste( node, node_after, "copy")
end

When /^I cut node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @courseOR.copy_cut_paste( node, node_after, "cut")
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

Then /^the info message "(.*?)" should be present$/ do |mess|
  on ManageCORequisites do |page|
    page.info_message.text.should match /#{Regexp.escape(mess)}/
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

Then /^the agenda page's text should match "(.*)"$/ do |text|
  on CourseOfferingRequisites do |page|
    @courseOR.show_all_courses( "agenda")
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", text)
  end
end

Then /^the agenda page's text should not match "(.*)"$/ do |text|
  on CourseOfferingRequisites do |page|
    @courseOR.show_all_courses( "agenda")
    page.agenda_management_section.text.should_not match @courseOR.test_text("agenda", text)
  end
end

Then /^the edit tab's text should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should match @courseOR.test_text("edit", text)
  end
end

Then /^the edit tab's text should not match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should_not match @courseOR.test_text("edit", text)
  end
end

Then /^the logic tab's text should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    @courseOR.show_all_courses( "logic")
    page.preview_tree_section.text.should match @courseOR.test_text("logic", text)
  end
end

Then /^the logic tab's text should not match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    @courseOR.show_all_courses( "logic")
    page.preview_tree_section.text.should_not match @courseOR.test_text("logic", text)
  end
end

Then /^the CO and CLU should both have text "(.*?)"/ do |text|
  on CourseOfferingRequisites do |page|
    page.compare_tree.text.should match @courseOR.test_compare_text( text)
  end
end

Then /^the CO and CLU should differ with text "(.*?)"/ do |text|
  on CourseOfferingRequisites do |page|
    page.compare_tree.text.should_not match @courseOR.test_compare_text( text)
  end
end

Then /^the text area should contain "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.logic_text.text.should == text
  end
end

Then /^the text area should be populated with "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.logic_text.text.should == text
    page.update_rule_btn
  end
end

Then /^both tabs' text should match "(.*?)"$/ do |text|
  on ManageCORequisites do |page|
    page.edit_tree_section.text.should match @courseOR.test_text("edit", text)
    page.logic_tab.click
    page.edit_loading.wait_while_present
    @courseOR.show_all_courses( "logic")
    page.preview_tree_section.text.should match @courseOR.test_text("logic", text)
  end
end

Then /^the agenda page's text should before and after the submit match "(.*?)"$/ do |text|
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    @courseOR.show_all_courses( "agenda")
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", text)
  end
  @courseOR.commit_changes( true)
  on CourseOfferingRequisites do |page|
    page.loading.wait_while_present
    @courseOR.show_all_courses( "agenda")
    page.agenda_management_section.text.should match @courseOR.test_text("agenda", text)
  end
end

Then /^node "(.*)" should be after node "(.*)"$/ do |second,first|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(first)}\..+#{Regexp.escape(second)}\..*/m
    page.update_rule_btn
  end
end

#Then /^node "(.*)" should be moved after node "(.*)"$/ do |second,first|
#  on ManageCORequisites do |page|
#    page.loading.wait_while_present
#    page.edit_tree_section.text.should match /.*#{Regexp.escape(first)}\..+#{Regexp.escape(second)}\..*/m
#    page.update_rule_btn
#  end
#end

Then /^the first node should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /^Click on rule statement to move or modify\n[\s\t]*#{Regexp.escape(text)}.*/
    page.update_rule_btn
  end
end

Then /^node "(.*)" should be a "(.*)" node in the tree$/ do |node, level|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.span(:text => /.*#{node}\..*/).id.should match @courseOR.test_node_level(level)
    page.update_rule_btn
  end
end

Then /^there should be a dropdown with value "(.*)" before node "(.*)"$/ do |drop, node|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(drop)}.*#{Regexp.escape(node)}.*/m
  end
end

Then /^node "(.*)" should be preceded by an "(.*)" operator$/ do |drop, node|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(drop)}.*#{Regexp.escape(node)}.*/m
    page.update_rule_btn
  end
end

Then /^the Move In button should be disabled$/ do
  on ManageCORequisites do |page|
    if page.right_btn_element.attribute_value('disabled')
      page.right_btn_element.attribute_value('disabled').should == "true"
      page.update_rule_btn
    end
  end
end
