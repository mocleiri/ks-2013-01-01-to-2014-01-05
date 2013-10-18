When /^I edit a Standard Final Exam rule on the matrix$/ do
  @matrix = make FinalExamMatrix
  @matrix.edit :defer_save => true
end

When /^I add a new statement to the TH at 04:30 AM Standard Final Exam rule on the matrix$/ do
  @matrix = make FinalExamMatrix, :rule_requirements => "TH at 04:30 AM"
  @matrix.edit :add_statement => true
end

When /^I edit an existing TH at 04:30 AM Standard Final Exam rule on the matrix$/ do
  @matrix = make FinalExamMatrix, :rule_requirements => "TH at 04:30 AM"
  @matrix.edit :edit_statement => true, :rule => "Free Form Text", :free_text => "This is a test"
  sleep 10
end

When /^I open the Final Exam Matrix for the Fall Term$/ do
  @matrix = make FinalExamMatrix
  @matrix.manage
end

When /^I add a Common Final Exam course rule to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix
end

When /^I add a Standard Final Exam timeslot rule to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :term_type => "Winter Term"
end

When /^I add a Standard Final Exam text rule to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :term_type => "Winter Term", :rule => "Free Form Text",
                   :free_text => "Course needs to match this text"
end

When /^I submit and return to see my changes$/ do
  on FEMatrixView do |page|
    page.loading.wait_while_present
    page.submit
  end
  @matrix.manage
end

Given /^I have added a Standard Final Exam timeslot rule to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :term_type => "Winter Term", :days => "TH", :start_time => "06:00",
                   :end_time => "07:00", :time_ampm => "am", :rule_requirements => "TH at 06:00 AM - 07:00 AM"

  on FEMatrixView do |page|
    page.submit
  end
end

Given /^I have added a Standard Final Exam text rule to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :term_type => "Winter Term", :rule => "Free Form Text",
                   :free_text => "To test the editing of the statement",
                   :rule_requirements => "To test the editing of the statement"

  on FEMatrixView do |page|
    page.submit
  end
end

When /^I edit a Standard Final Exam rule$/ do
  @matrix.edit :edit_statement => true, :days => "TWH", :rule_requirements => @matrix.rule_requirements
end

When /^I edit a Standard Final Exam text rule$/ do
  @matrix.edit :edit_statement => true, :free_text => "This statement has been edited",
               :rule_requirements => @matrix.rule_requirements
end

When /^I delete a statement in the Standard Final Exam text rule$/ do
  @matrix.delete_statement :rule_requirements => @matrix.rule_requirements
end

When /^I add multiple Common Final Exam rules to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :term_type => "Winter Term", :rule => "Course must be <Course>",
                   :exam_type => "Common", :courses => "HIST111",
                   :rule_requirements => "To test the editing of the statement", :add_more_statements => true
end

Then /^I should be able to choose any one of Day 1 to 6 for the rule$/ do
  on FEMatrixEdit do |page|
    for i in 1..6
      page.rdl_days.option( value: "#{i}").text.should == "Day #{i}"
    end
  end
end

Then /^I can only view all the rules in the Final Exam Matrix$/ do
  on FEMatrixView do |page|
    page.standard_final_exam_section.text.should_not match /Edit/
    page.standard_final_exam_section.text.should_not match /Delete/
    page.common_final_exam_section.text.should_not match /Edit/
    page.common_final_exam_section.text.should_not match /Delete/
  end
end

Then /^I cannot add a new rule to the Final Exam Matrix$/ do
  on FEMatrixView do |page|
    page.standard_final_exam_section.text.should_not match /Add/
    page.common_final_exam_section.text.should_not match /Add/
  end
end

Then /^I have the option of editing or deleting rules in the Final Exam Matrix$/ do
  on FEMatrixView do |page|
    page.standard_final_exam_section.text.should match /Edit/
    page.standard_final_exam_section.text.should match /Delete/
    page.common_final_exam_section.text.should match /Edit/
    page.common_final_exam_section.text.should match /Delete/
  end
end

Then /^I have the option to add a new rule to the Final Exam Matrix$/ do
  on FEMatrixView do |page|
    page.standard_final_exam_section.text.should match /Add/
    page.common_final_exam_section.text.should match /Add/
  end
end

Then /^I should be able to see the newly created course rule in the Common Final Exam table$/ do
  on FEMatrixView do |page|
    page.get_common_fe_requirements( @matrix.courses).should match /#{@matrix.courses}\./
  end
end

Then /^I should be able to see the newly created timeslot rule in the Standard Final Exam table$/ do
  on FEMatrixView do |page|
    requirements = page.get_standard_fe_requirements( @matrix.days)
    requirements.should match /#{@matrix.days} at #{@matrix.start_time} #{@matrix.time_ampm.upcase} - #{@matrix.end_time} #{@matrix.time_ampm.upcase}\./
    page.get_standard_fe_day( @matrix.days).should match /#{@matrix.rdl_days}/
    page.get_standard_fe_time( @matrix.days).should match /#{@matrix.start_time} #{@matrix.time_ampm.upcase}-#{@matrix.end_time} #{@matrix.time_ampm.upcase}/
  end
end

Then /^I should be able to see the newly created text rule in the Standard Final Exam table$/ do
  on FEMatrixView do |page|
    page.get_standard_fe_requirements( @matrix.free_text).should match /#{@matrix.free_text}/
    page.get_standard_fe_day( @matrix.free_text).should match /#{@matrix.rdl_days}/
    page.get_standard_fe_time( @matrix.free_text).should match /#{@matrix.start_time} #{@matrix.time_ampm.upcase}-#{@matrix.end_time} #{@matrix.time_ampm.upcase}/
  end
end

Then /^I should be able to see the edited timeslot rule in the Standard Final Exam table$/ do
  on FEMatrixView do |page|
    requirements = page.get_standard_fe_requirements( @matrix.days)
    requirements.should match /#{@matrix.days} at #{@matrix.start_time} #{@matrix.time_ampm.upcase} - #{@matrix.end_time} #{@matrix.time_ampm.upcase}\./
    page.get_standard_fe_day( @matrix.days).should match /#{@matrix.rdl_days}/
    page.get_standard_fe_time( @matrix.days).should match /#{@matrix.start_time} #{@matrix.time_ampm.upcase}-#{@matrix.end_time} #{@matrix.time_ampm.upcase}/
  end
end

Then /^I should be able to see the edited text rule in the Standard Final Exam table$/ do
  on FEMatrixView do |page|
    page.get_standard_fe_requirements( @matrix.free_text).should match /#{@matrix.free_text}/
    page.get_standard_fe_day( @matrix.free_text).should match /#{@matrix.rdl_days}/
    page.get_standard_fe_time( @matrix.free_text).should match /#{@matrix.start_time} #{@matrix.time_ampm.upcase}-#{@matrix.end_time} #{@matrix.time_ampm.upcase}/
  end
end

Then /^there should be a validation message displayed stating "([^"]+)"$/ do |exp_msg|
  on FEMatrixEdit do |page|
    page.loading.wait_while_present
    page.validation_message_text.should match /#{exp_msg}/
  end
end

Then /^I should be able to see the multiple statement Common Final Exam rule$/ do
  on FEMatrixView do |page|

  end
end