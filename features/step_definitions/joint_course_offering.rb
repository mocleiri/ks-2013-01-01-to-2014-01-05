When /^I create joint Course Offerings$/ do
  pending # need to define :joint_select method in course_offering_object.rb
  @course_offering = create CourseOffering, :term=> Rollover::OPEN_SOC_TERM, :course => "BSCI181", :joint_select => "CHEM181", :grade_format => "Lab", :delivery_format => "Lab"
end

Then /^I can add activity offerings to the joint Course Offerings$/ do
  pending # express the regexp above with the code you wish you had
  on ManageCourseOfferings do |page|
    format = page.format.options[1].text
    page.add_ao format, 1
  end
end

When /^I attempt to delete a joint Course Offering$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^I can cancel the deletion$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^I can complete the deletion$/ do
  pending # express the regexp above with the code you wish you had
end

Then /^the Course Offering is deleted$/ do
  pending # express the regexp above with the code you wish you had
end