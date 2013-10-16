When /^I edit the TH at 06:00 AM Standard Final Exam rule on the matrix$/ do
  @matrix = make FinalExamMatrix
  @matrix.edit :defer_save => true
end

When /^I add a new rule to the TH at 04:30 AM Standard Final Exam rule on the matrix$/ do
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

When /^I add a Common Final Exam course rule to the Final Exam Matrix of the Fall Term$/ do
  @matrix = create FinalExamMatrix, :exam_type => "Common", :rule => "Course must be <Course>"
end

When /^I submit and return to see my changes$/ do
  on FEMatrixView do |page|
    page.submit
  end
  @matrix.manage
end

Then /^I should be able to choose any one of Day 1 to 6 for the rule$/ do
  on FEMatrixEdit do |page|
    page.fe_days_select.option( value: "1").text.should == "Day 1"
    page.fe_days_select.option( value: "2").text.should == "Day 2"
    page.fe_days_select.option( value: "3").text.should == "Day 3"
    page.fe_days_select.option( value: "4").text.should == "Day 4"
    page.fe_days_select.option( value: "5").text.should == "Day 5"
    page.fe_days_select.option( value: "6").text.should == "Day 6"
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