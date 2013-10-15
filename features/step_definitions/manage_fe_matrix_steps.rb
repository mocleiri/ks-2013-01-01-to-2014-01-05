When /^I edit the TH at 06:00 AM Standard Final Exam rule on the matrix$/ do
  @matrix = make FinalExamMatrix, :rule_requirements => "TH at 06:00 AM"
  @matrix.edit :defer_save => true
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