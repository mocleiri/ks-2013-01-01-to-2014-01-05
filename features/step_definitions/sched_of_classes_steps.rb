Then /^I am using the schedule of classes page$/ do
  go_to_display_schedule_of_classes
end

When /^I search for course offerings by course by entering a subject code$/ do
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => "CHEM", :exp_course_list => ["CHEM135","CHEM425"]
  @schedule_of_classes.display
end

When /^I search for a course offering that has activity offerings assigned to subterms by course code/ do
  @schedule_of_classes = make ScheduleOfClasses, :term => "Fall 2012", :course_search_parm => "CHEM105", :exp_course_list => ["CHEM105"]
  @schedule_of_classes.display
end

When /^I search for course offerings by course by entering a subject code: (.*)$/ do |subject_code|
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => subject_code
  @schedule_of_classes.display
end



Then /^a list of course offerings with that subject code is displayed$/ do
  @schedule_of_classes.check_results_for_subject_code_match(@schedule_of_classes.course_search_parm)
end

Then /^the course offering details for a particular offering can be shown$/ do
  @schedule_of_classes.expand_course_details
end

And /^the subterm icon appears with the subterm information$/ do
  icon_title_text = "This activity is in Half Fall 1 - 08/29/2012 - 10/21/2012"
  #TODO: look up text above (term name & dates) from CO & ACal pages
  on DisplayScheduleOfClasses do |page|
    if !page.results_activities_table.exists?
      raise "activities table not found"
    else
      page.results_activities_table.rows[1..-1].each do |row|
        # check only rows with data in them
        if row.cells[DisplayScheduleOfClasses::CODE_COL].text =~ /[A-B]/
          row.cells[DisplayScheduleOfClasses::ICON_COL].image.attribute_value("src").should match /subterm_icon\.png/
          row.cells[DisplayScheduleOfClasses::ICON_COL].image.title.should == icon_title_text
        end
      end
    end
  end
end

Then /^the course offering details for all offerings can be shown$/ do
  @schedule_of_classes.expand_all_course_details
end

When /^I search for course offerings by course by entering a course offering code$/ do
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => "ENGL206", :exp_course_list => ["ENGL206"]
  @schedule_of_classes.display
end

Then /^a list of course offerings with that course offering code is displayed$/ do
  @schedule_of_classes.check_expected_results_by_course
end

When /^I search for course offerings by instructor$/ do
  @schedule_of_classes = make ScheduleOfClasses, :type_of_search => "Instructor", :instructor_principal_name => "B.JOHND", :exp_course_list => ["BIOL200","CHEM152","ENGL105"]
  @schedule_of_classes.display
end

Then /^a list of course offerings with activity offerings with that instructor is displayed$/ do
  @schedule_of_classes.check_results_for_instructor
end

When /^I search for course offerings by department$/ do
  @schedule_of_classes = make ScheduleOfClasses, :type_of_search => "Department", :department_long_name => "ARHU-English", :exp_course_list => ["ENGL206","ENGL377","ENGL899"]
  @schedule_of_classes.display
end

Then /^a list of course offerings for that department is displayed$/ do
   @schedule_of_classes.check_expected_results_by_course
end

When /^I search for course offerings by title and department by entering a keyword$/ do
  @schedule_of_classes = make ScheduleOfClasses, :type_of_search => "Title & Description", :keyword => "computer", :exp_course_list => ["PHYS485"]
  @schedule_of_classes.display
end

Then /^a list of course offerings with that keyword is displayed$/ do
  @schedule_of_classes.check_expected_results_by_course
end

When /^I search for course offerings that are in draft status$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the course is not displayed in the list of course offerings$/ do
  pending # express the regexp above with the code you wish you had
end