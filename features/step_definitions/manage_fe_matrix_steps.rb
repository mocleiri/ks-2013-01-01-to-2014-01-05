When /^I edit a Standard Final Exam rule on the matrix$/ do
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