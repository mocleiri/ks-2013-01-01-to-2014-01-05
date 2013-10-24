Then /^I am using the schedule of classes page$/ do
  @schedule_of_classes_landing_page = go_to_display_schedule_of_classes
end

Then /^the nearest valid future Term is chosen in the Term select list$/ do
  #
  #  The term selector should default to the "nearest valid future term" where "future" is derived from comparing the
  #  start date of the term to "now". So, this test will break when "now" is past the start date of Winter 2015. Also,
  #  the test susceptible to changes in the term data. However, it didn't seem quite worth while to try and reproduce
  #  the algorithm to prevent the breakage.
  #
  #  For now just make sure a term was selected.
  @schedule_of_classes_landing_page.term.value.should match /kuali\.atp\.20/
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
  #icon_title_text = "This activity is in Half Fall 1 - 08/28/2012 - 10/20/2012"  # local env
  icon_title_text = "This activity is in Half Fall 1 - 08/29/2012 - 10/21/2012"   # env2
  #TODO: look up text above (term name & dates) from CO & ACal pages
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[1..-1].each do |row|
        # check only rows with data in them
        if row.cells[DisplayScheduleOfClasses::AO_CODE_COLUMN].text =~ /[A-B]/
          row.cells[DisplayScheduleOfClasses::ICON_COLUMN].image.attribute_value("src").should match /subterm_icon\.png/
          row.cells[DisplayScheduleOfClasses::ICON_COLUMN].image.title.should == icon_title_text
        end
      end
    end
  end
end

Then /^the course offering details for all offerings can be shown$/ do
  @schedule_of_classes.expand_all_course_details
end

When /^I search for course offerings by course by entering a course offering code$/ do
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => "ENGL206", :exp_course_list => ["ENGL206"], :exp_cluster_list => ["CL 101","CL Leftovers"], :exp_reg_group_list => ["1001","1002","1003","1004"]
  @schedule_of_classes.display
end

Then /^a list of course offerings with that course offering code is displayed$/ do
  @schedule_of_classes.check_expected_results_by_course
end

When /^I search for course offerings by instructor$/ do
  @schedule_of_classes = make ScheduleOfClasses, :type_of_search => "Instructor", :instructor_principal_name => "B.JOHND", :instructor_long_name => "BRITT, JOHN", :exp_course_list => ["BSCI399","CHEM241","ENGL390","HIST708"]
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
  @schedule_of_classes = make ScheduleOfClasses, :type_of_search => "Title or Description", :keyword => "computer", :exp_course_list => ["PHYS485"]
  @schedule_of_classes.display
end

Then /^a list of course offerings with that keyword is displayed$/ do
  @schedule_of_classes.check_expected_results_by_course
end

When /^I add an Activity Offering in draft status to an existing Course Offering$/ do
  @course_offering = make CourseOffering, :term => "201208", :course=>"ENGL222"
  @course_offering.manage_and_init
  @new_ao = @course_offering.create_ao(make ActivityOffering, :format => "Lecture Only")
end

And /^I search for the Course Offering in the schedule of classes$/ do
  @schedule_of_classes = make ScheduleOfClasses, :term => "Fall 2012", :course_search_parm => @course_offering.course, :exp_course_list => ["ENGL222"]
  @schedule_of_classes.display
end

Then /^the added Activity Offering is not displayed in the expanded listing rendered by (AO Cluster|Registration Group)$/  do |rendering|
  rendering_param = (rendering=="AO Cluster") ? DisplayScheduleOfClasses::AO_CLUSTER_RENDERING : DisplayScheduleOfClasses::REG_GROUP_RENDERING
  @schedule_of_classes.choose_rendering rendering_param
  @schedule_of_classes.expand_course_details
  on DisplayScheduleOfClasses do |page|
    page.get_ao_list(rendering_param).should_not include @new_ao.code
  end
end

Then /^the course offering details displays a listing of AO clusters$/ do
  @schedule_of_classes.choose_rendering DisplayScheduleOfClasses::AO_CLUSTER_RENDERING
  @schedule_of_classes.expand_course_details
  on DisplayScheduleOfClasses do |page|
    page.get_cluster_headers.should == @schedule_of_classes.exp_cluster_list
  end
end

Then /^the course offering details displays a listing of registration groups$/ do
  @schedule_of_classes.choose_rendering DisplayScheduleOfClasses::REG_GROUP_RENDERING
  @schedule_of_classes.expand_course_details
  on DisplayScheduleOfClasses do |page|
    page.get_reg_group_list.should == @schedule_of_classes.exp_reg_group_list
  end
end

When /^I search for course offerings by course by entering a course offering code to view the course offering requisites$/ do
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => "ENGL304", :exp_course_list => ["ENGL304"],
                              :term => "Fall 2012"
  @schedule_of_classes.display
  @schedule_of_classes.expand_course_details
end

When /^I search for course offerings by course to view the course offering requisites$/ do
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => "PHYS272", :exp_course_list => ["PHYS272","PHYS272H"],
                              :term => "Fall 2012"
  @schedule_of_classes.display
  @schedule_of_classes.expand_course_details
end

When /^I search for course offerings by course in the CHEM subject group to view the course offering requisites$/ do
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => "CHEM272", :exp_course_list => ["CHEM272"],
                              :term => "Fall 2012"
  @schedule_of_classes.display
  @schedule_of_classes.expand_course_details
end

When /^I search for course offerings by course in the CHEM subject group to view the registration group$/ do
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => "CHEM272", :exp_course_list => ["CHEM272"],
                              :term => "Fall 2012"
  @schedule_of_classes.display
  @schedule_of_classes.choose_rendering DisplayScheduleOfClasses::REG_GROUP_RENDERING
  @schedule_of_classes.expand_course_details
end

Then /^the course offering requisites should be displayed stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    page.get_requisites_message_text.should match /#{exp_msg}/m
  end
end

Then /^the course offering requisites should be displayed not stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    page.get_requisites_message_text.should_not match /#{exp_msg}/m
  end
end

Then /^the Activity A of the Course Offering has Activity Offering Requisites displayed stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[2].text.should match /#{exp_msg}/m
    end
  end
end

Then /^the Activity A of the Course Offering has Activity Offering Requisites displayed not stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[2].text.should_not match /#{exp_msg}/m
    end
  end
end

Then /^the Activity B of the Course Offering has Activity Offering Requisites displayed stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[4].text.should match /#{exp_msg}/m
    end
  end
end

Then /^the Activity L of the Course Offering has Activity Offering Requisites displayed stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[4].text.should match /#{exp_msg}/m
    end
  end
end

Then /^the Activity C of the Course Offering has Activity Offering Requisites displayed stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[10].text.should match /#{exp_msg}/m
    end
  end
end

Then /^Activity J in the Registration Group has Activity Offering Requisites displayed stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[4].text.should match /#{exp_msg}/m
    end
  end
end

Then /^Activity J in the Registration Group has Activity Offering Requisites displayed not stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[4].text.should_not match /#{exp_msg}/m
    end
  end
end

Then /^Activity C in the Registration Group has Activity Offering Requisites displayed stating "([^"]+)"$/ do |exp_msg|
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[12].text.should match /#{exp_msg}/m
    end
  end
end

When /^I loaded the list of Schedule of Classes for term "(.*?)" and Course "(.*?)"$/ do |arg1, arg2|
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => arg2,
                                                 :exp_course_list => ["CHEM131S"],
                                                 :term => arg1
  @schedule_of_classes.display
end

Then /^the activity A of the course offering "(.*?)" has a colocated icon$/ do |arg1|
  @schedule_of_classes.display
  @schedule_of_classes.expand_course_details
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      page.details_table.rows[1].cells[DisplayScheduleOfClasses::AO_CODE_COLUMN].image(src: /colocate_icon/).present?.should be_true
      before_popup_style = @browser.divs(:class=>"jquerybubblepopup jquerybubblepopup-black" )[0].style
      (before_popup_style == "").should == true
      page.details_table.rows[1].cells[DisplayScheduleOfClasses::AO_CODE_COLUMN].image(src: /colocate_icon/).hover
      popup_style = @browser.divs(:class=>"jquerybubblepopup jquerybubblepopup-black" )[0].style
      (popup_style.include? "display: block").should == true
    end
  end
end

And /^the activity A of the course offering "(.*?)" has tooltip text "(.*?)"$/ do |arg1, arg2|
  @schedule_of_classes.display
  @schedule_of_classes.expand_course_details
  on DisplayScheduleOfClasses do |page|
    if !page.details_table.exists?
      raise "activities table not found"
    else
      colocated_tooltip_text = page.details_table.rows[1].cells[DisplayScheduleOfClasses::AO_CODE_COLUMN].image(src: /colocate_icon/).alt.upcase
      colocated_tooltip_text.should == arg2.upcase
    end
  end
end


When /^I loaded the Schedule of Classes for term "(.*?)" and Course "(.*?)"$/ do |arg1, arg2|
  @schedule_of_classes = make ScheduleOfClasses, :course_search_parm => arg2,
                              :exp_course_list => ["ENGL250"],
                              :term => arg1
  @schedule_of_classes.display
end

Then /^the course offering "(.*?)" has cross listed icon$/ do |arg1|
  @schedule_of_classes.display
  on DisplayScheduleOfClasses do |page|
    page.target_course_row(arg1)[DisplayScheduleOfClasses::COURSE_CODE_COLUMN].image(src: /cross-listed/).present?.should be_true
    before_popup_style = @browser.divs(:class=>"jquerybubblepopup jquerybubblepopup-black" )[0].style
    (before_popup_style == "").should == true
    page.target_course_row(arg1)[DisplayScheduleOfClasses::COURSE_CODE_COLUMN].image(src: /cross-listed/).hover
    popup_style = @browser.divs(:class=>"jquerybubblepopup jquerybubblepopup-black" )[0].style
    (popup_style.include? "display: block").should == true
  end
end

And /^the course offering "(.*?)" has tooltip text "(.*?)"$/ do |arg1, arg2|
  @schedule_of_classes.display
  on DisplayScheduleOfClasses do |page|
    cross_listed_tooltip_text = page.target_course_row(arg1)[DisplayScheduleOfClasses::COURSE_CODE_COLUMN].image(src: /cross-listed/).alt.upcase
    cross_listed_tooltip_text.should == arg2.upcase
  end
end

Then /^the course offering "(.*?)" has Audit grading option icon and tooltip popped up$/ do |arg1|
  @schedule_of_classes.display
  on DisplayScheduleOfClasses do |page|
    page.target_course_row(arg1)[DisplayScheduleOfClasses::ADDITIONAL_INFO].image(src: /a/).present?.should be_true
    display_style = @browser.divs(:class=>"jquerybubblepopup jquerybubblepopup-black")[0].style
    (result = display_style == "").should == true

    page.target_course_row(arg1)[DisplayScheduleOfClasses::ADDITIONAL_INFO].image(src: /a/).hover
    display_style1 = @browser.divs(:class=>"jquerybubblepopup jquerybubblepopup-black")[0].style
    (display_style1.include? "display: block").should == true
  end
end