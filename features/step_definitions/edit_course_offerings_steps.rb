When /^I search course offerings by subject code$/ do
  @course_offering = make CourseOffering, :course=>"CHEM132"
  @course_offering.search_by_subjectcode
end

Then /^I view the course offering details$/ do
  @course_offering.view_course_details
  on CourseOfferingInquiry do |page|
    page.close
  end
end

When /^I can edit the course offering$/ do
  on ManageCourseOfferingList do |page|
    page.edit @course_offering.course
  end
end

When /^I can return to search using the cancel button$/ do
   on CourseOfferingEdit do |page|
     page.cancel
   end
end

When /^I edit a course offering with multiple format types$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"CHEM132")
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I edit a course offering with 2 format types$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"ENGL271")
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I edit a course offering with multiple (\w+) options$/ do |opt|
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"CHEM399A", :pass_fail_flag=>true, :audit_flag=>true, :credit_type => "multiple")
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I edit a course offering with multiple delivery format types$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"ENGL222")
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I select a final exam type of "([^"]*)"$/ do |final_option|
     @course_offering.edit_offering :final_exam_type => final_option
end

And /^I clear the registration options checkboxes$/ do
  @course_offering.edit_offering :pass_fail_flag => false, :audit_flag => false
end

When /^I change the credit type from multiple to fixed$/ do
  @course_offering.edit_offering :credit_type => "fixed"
end

And /^I change the number of credits$/ do
  @course_offering.edit_offering :fixed_credit_count => "2.5"
end

And /^I change the multiple credit values$/ do
  credit_selections = {"1.0" => true, "1.5" => false, "2.0" => true, "2.5" => false, "3.0" => true}
  @course_offering.edit_offering :multiple_credit_list => credit_selections
end

Then /^I can submit and the credit options are changed$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end

  @course_offering.search_by_subjectcode
  @course_offering.view_course_details
  on CourseOfferingInquiry do  |page|
    page.course_credit_count.should == @course_offering.fixed_credit_count
  end
end

Then /^I can submit and the credit values are changed$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end

  @course_offering.search_by_subjectcode
  @course_offering.view_course_details

  on CourseOfferingInquiry do  |page|
    page.course_credit_count.should == @course_offering.formatted_multiple_credits_list
  end
end

When /^I change the delivery format options$/ do
  delivery_format_list = {}
  delivery_format_list[0] = make DeliveryFormat, :format=>"Lab Only"
  @course_offering.edit_offering :delivery_format_list => delivery_format_list
end

And /^I add a delivery format option$/ do
  on CourseOfferingEdit do |page|
    page.delivery_format_add
    delivery_format = make DeliveryFormat,
                           :format => "Lecture",
                           :grade_format => "Lecture",
                           #:grade_format => "Lecture",
                           :final_exam_activity => "Lecture"
    page.select_delivery_format(2,delivery_format)
  end
end

And /^I add a delivery format option of Discussion Lecture$/ do
  on CourseOfferingEdit do |page|
    page.delivery_format_add
    delivery_format = make DeliveryFormat,
                           :format => "Discussion/Lecture",
                           :grade_format => "Course Offering"
                           #:grade_format => "Course Offering",
                           #:final_exam_activity => "Discussion"
    page.select_delivery_format(2,delivery_format)
  end
end

And /^I modify a delivery format option$/ do
  delivery_format = make DeliveryFormat,
                         :format => "Lecture",
                         :grade_format => "Lecture",
                         :final_exam_activity => "Lecture"
  on CourseOfferingEdit do |page|
    page.select_delivery_format(1, delivery_format, false)
  end
end

Then /^I delete the added delivery format option$/ do
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
  on CourseOfferingEdit do |page|
    page.delete_delivery_format("Lecture Only")
  end
end
Then /^I can submit and the course offering is updated$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end

  #validate the success-growl is being shown
  on ManageCourseOfferings do |page|
    page.growl_text.should include "#{@course_offering.course} was successfully updated"
  end

  @course_offering.search_by_subjectcode
  @course_offering.view_course_details

  on CourseOfferingInquiry do  |page|
    page.registration_options.should == @course_offering.reg_options
    page.final_exam_type.should == @course_offering.final_exam_type
    page.waitlist_state.should == @course_offering.waitlist
    page.honors_flag.should == @course_offering.honors_flag
    page.close
  end
end

Then /^I can submit and the registration options are changed$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end
  @course_offering.search_by_subjectcode
  @course_offering.view_course_details
  on CourseOfferingInquiry do  |page|
    page.registration_options.should == @course_offering.reg_options
  end
end

Then /^I can submit and the delivery formats are updated$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end

  @course_offering.search_by_subjectcode
       @course_offering.view_course_details
       on CourseOfferingInquiry do  |page|
         page.get_delivery_format("Lecture Only").should == "Lecture Only"
         page.get_grade_roster_level("Lecture Only").should == "Lecture"
         page.get_final_exam_activity("Lecture Only").should == "Lecture"
  end
end

Then /^I can submit and the modified delivery formats are updated$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end

  @course_offering.search_by_subjectcode
       @course_offering.view_course_details
       on CourseOfferingInquiry do  |page|
         page.get_delivery_format("Lecture/Discussion").should == "Lecture/Discussion"
         page.get_grade_roster_level("Lecture/Discussion").should == "Lecture"
         #page.get_final_exam_activity("Lecture/Discussion").should == "Lecture"
  end
end

Then /^I can submit and the added delivery format is not present$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end

  @course_offering.search_by_subjectcode
  @course_offering.view_course_details
  on CourseOfferingInquiry do  |page|
    page.delivery_format_row("Lecture Only").should == nil
  end

end

Then /^I can submit the edited course offering$/ do
  on CourseOfferingEdit do |page|
    page.submit
  end
end

When /^a final exam driver of "([^"]*)"$/ do |final_driver|
    @course_offering.edit_offering :final_exam_activity => final_driver
end

Then /^I edit the same course offering$/ do
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I edit a course offering$/ do
  @course_offering = create CourseOffering, :create_by_copy=>(make CourseOffering, :course=>"CHEM132")

  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end
end

When /^I add an affiliated person$/ do
  personnel_list = {}
  personnel_list[0] = make Personnel, :id=> "admin", :affiliation =>"Instructor"

  @course_offering.edit_offering :affiliated_person_list => personnel_list
end

Then /^the changes of the affiliated person are persisted$/ do
  @course_offering.manage
  on ManageCourseOfferings do |page|
    page.edit_course_offering
  end

  on CourseOfferingEdit do |page|
    page.personnel_id.value.should == "admin"
    page.personnel_name.value.should == "admin, admin"
    page.personnel_affiliation.value.should == "kuali.lpr.type.instructor.main"
  end
end

When /^I "(activate|deactivate)" the wait list$/ do |activate|
    @course_offering.edit_offering :waitlist => true
end

When /^I add an administering organization and activate the honors flag$/ do
 organization_list = {}
 organization_list[0] = make AffiliatedOrg

 @course_offering.edit_offering  :honors_flag => "YES", :affiliated_org_list=> organization_list

end

When /^I manually change a given soc-state to "(Open|Publishing|In Progress)"$/ do |newSocState|
  @manage_soc = make ManageSoc, :term_code => Rollover::SOC_STATES_SOURCE_TERM
  @manage_soc.perform_manual_soc_state_change(newSocState)
end

Then /^I verify that I "(can|cannot)" manage course offerings$/ do |can_manage|
  course_offering = make CourseOffering, :term => @manage_soc.term_code
  course_offering.search_by_subjectcode

  case can_manage
    when "cannot"
      expected_errMsg = "Access to course offerings is not permitted while this term's Set of Courses (SOC) is"
      on(ManageCourseOfferings).first_msg.should match /.*#{Regexp.escape(expected_errMsg)}.*/
    else  # "can"
      on(ManageCourseOfferings).info_list.should_not be_present   # an error-message should not be displayed
  end
end

When /^I "(set|unset)" the Honors Course selection$/ do |shouldSetHonorsCourse|
  honors_flag = "NO"
  if shouldSetHonorsCourse == "set"
    honors_flag = "YES"
  end
  @course_offering.edit_offering :honors_flag => honors_flag
end

And /^I save the changes and remain on the Edit CO page$/ do
  on CourseOfferingEdit do |page|
    page.save_progress
  end
end

And /^I jump to "(the previous|the next|an arbitrary)" CO while "(saving|not saving)" changes$/ do |coDirection, shouldSaveChanges|

  on CourseOfferingEdit do |page|

    # which CO to navigate to
    case coDirection
      when "the previous"
        page.edit_previous_co
      when "the next"
        page.edit_next_co
      else    # nav to an arbitrary CO via the drop-down selector
        page.edit_relatedCos_dropdown_list.options[10].select
    end

    # whether changes should be saved
    if shouldSaveChanges == "saving"
      page.navigation_save_and_continue
    else
      page.navigation_cancel_and_continue
    end
  end

end

Then /^I can verify that the Honors Course setting is "(set|not set)"$/ do |shouldHonorsCourseBeSet|
  honors_flag = "NO"
  if shouldHonorsCourseBeSet == "set"
    honors_flag = "YES"
  end

  @course_offering.view_course_details
  on CourseOfferingInquiry do |page|
    page.honors_flag.should == honors_flag
  end
end


