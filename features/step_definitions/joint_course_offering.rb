When /^I create a new jointly defined Course Offering$/ do
  @bsci_co = create CourseOffering, :term => "201201", :course => "BSCI181", :delivery_format => "Lecture", :grade_format => "Lecture"
end

And /^I attempt to "(delete|delete and cancel)" a joint Course Offering$/ do |delete_flag|
  @bsci_co.search_by_subjectcode

  $should_confirm_delete = false
  if delete_flag == 'delete'
    $should_confirm_delete = true
  end

  @bsci_co.delete_co :code_list => [@bsci_co.course], :should_confirm_delete=>$should_confirm_delete
end

Then /^the Course Offering is "(deleted|not deleted)"$/ do |delete_flag|
  @bsci_co.search_by_coursecode

  on ManageCourseOfferings do |page|
    if delete_flag == 'deleted'
      page.error_message_course_not_found.should be_present
    else # "not deleted"
      page.error_message_course_not_found.should_not be_present
    end
  end
end


##################################################################################################################
# STEPS BELOW THIS LINE ARE NOT FINISHED -- THEY CANNOT BE BECAUSE THE APPLICATION
# HAS A BUG WHICH PREVENTS THE TEST FROM COMPLETING SUCCESSFULLY
# (see joint_course_offering.feature,
# "Scenario: Create from Catalog a Course Offering which is defined in the CLU as Joint"
# comment regarding "CCO 2.1")

# This step is required because if (for example) CHEM181 already exists then when you create a new
# linked CO (for example, BSCI181) the 'create new joint co'-link does not appear
When /^I remove a joint course offering from the reference data in order to enable this test$/ do

  # yes, we have to create 2 in order to delete all; sorry, caused by side-affect of
  # having unreliable ref-data plus the app shows different views depending on whether
  # the course-code has 1 or multiple offerings
  @ref_data_to_delete = create CourseOffering, :term => "201201", :course => "CHEM181"
  @ref_data_to_delete = create CourseOffering, :term => "201201", :course => "CHEM181"
  @ref_data_to_delete.course = "CHEM181"
  @ref_data_to_delete.search_by_coursecode
  on ManageCourseOfferingList do |page|
    page.select_all_cos
    page.delete_cos
  end
  on DeleteCourseOffering do |page|
    page.confirm_delete
  end

end

# This step is required because after running the delete-ref-data step (above), the ref-data is
# left in an unexpected state; this restores the state back to expected condition
And /^then I restore the joint course offering I removed from the reference data$/ do

end

When /^I create a joint course offering from catalog while creating a new course offering$/ do
  @bsci_co = create CourseOffering, :term => "201201", :course => "BSCI181", :joint_co_to_create => "CHEM181, PHYS181", :delivery_format => "Lecture", :grade_format => "Lecture"
end


#REFACTOR THIS STEP NAME TO SOMETHING BETTER
Then /^The joint course offerings are created.$/ do
  @bsci_co.search_by_subjectcode
  #delete
  @bsci_co.delete_co :code_list => [@bsci_co.course], :should_confirm_delete=>true
  # display the created
  @chem181_co = make CourseOffering
  @chem181_co.term="201201"
  @chem181_co.course="CHEM181"
  @phys181_co = make CourseOffering
  @phys181_co.term="201201"
  @phys181_co.course="PHYS181"

  @chem181_co.search_by_subjectcode
  #delete
  @chem181_co.delete_co :code_list => [@chem181_co.course], :should_confirm_delete=>true

  @phys181_co.search_by_subjectcode
  #delete
  @phys181_co.delete_co :code_list => [@phys181_co.course], :should_confirm_delete=>true


  puts 'Done'

end

