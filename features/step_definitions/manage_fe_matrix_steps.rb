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

When /^I open the Final Exam Matrix for ([^"]*)$/ do |term|
  @matrix = make FinalExamMatrix, :term_type => term
  @matrix.manage
end

When /^I add a Common Final Exam course rule to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :rule => "Course must be <Course>",
                   :exam_type => "Common", :courses => "CHEM272"
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

Given /^I have added two Standard Final Exam rules to the Final Exam Matrix$/ do
  @matrix_rule_list = []
  @matrix_rule_list << (create FinalExamMatrix, :term_type => "Winter Term", :days => "TH", :start_time => "06:00",
                   :end_time => "07:00", :time_ampm => "am", :rule_requirements => "TH at 06:00 AM - 07:00 AM")
  on FEMatrixView do |page|
    page.submit
  end

  @matrix_rule_list << (create FinalExamMatrix, :term_type => "Winter Term", :rule => "Free Form Text",
                               :free_text => "To test the editing of the statement",
                               :rule_requirements => "To test the editing of the statement")
  on FEMatrixView do |page|
    page.submit
  end
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

When /^I submit after editing the newly created Standard Final Exam rules$/ do
  @matrix_rule_list[0].edit :edit_statement => true, :days => "TWH",
                            :rule_requirements => @matrix_rule_list[0].rule_requirements
  on FEMatrixView do |page|
    page.loading.wait_while_present
    page.submit
  end
  @matrix_rule_list[0].manage

  @matrix_rule_list[1].edit :edit_statement => true, :free_text => "This statement has been edited",
               :rule_requirements => @matrix_rule_list[1].rule_requirements
  on FEMatrixView do |page|
    page.loading.wait_while_present
    page.submit
  end
  @matrix_rule_list[1].manage
end

When /^I delete a statement in the Standard Final Exam text rule$/ do
  @matrix.delete_statement :rule_requirements => @matrix.rule_requirements
end

When /^I delete an existing Standard Final Exam text rule to the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :term_type => "Winter Term", :rule => "Free Form Text",
                   :free_text => "To test whether rule is deleted",
                   :rule_requirements => "To test whether rule is deleted"

  on FEMatrixView do |page|
    page.submit
  end

  @matrix.manage
  on(FEMatrixView).delete( @matrix.rule_requirements, @matrix.exam_type)
end

When /^I add multiple statements to a Common Final Exam rule on the Final Exam Matrix$/ do
  @matrix = create FinalExamMatrix, :term_type => "Winter Term", :rule => "if course is <Course>",
                   :exam_type => "Common", :courses => "HIST111",
                   :rule_requirements => "To test the editing of the statement", :add_more_statements => true
end

When /^I view the Standard Final Exam rules on the Final Exam Matrix$/ do
  @matrix = make FinalExamMatrix
  @matrix.manage
end

When /^there is an Academic Term associated with a Final Exam matrix$/ do
  @matrix_term = make FinalExamMatrix, :term_type => "Fall Term"
end

When /^there is a second Academic Term that is not associated with any final exam matrix$/ do
  @matrix_second_term = make FinalExamMatrix, :term_type => "Summer Term"
end

When /^there is a third Academic Term associated with a Final Exam matrix$/ do
  @matrix_third_term = make FinalExamMatrix, :term_type => "Spring Term"
end

When /^there is an Academic Half Term that is not associated with any final exam matrix$/ do
  @matrix_halfterm = make FinalExamMatrix, :term_type => "Summer 1"
end

When /^I associate the second Term with the Final Exam matrix of the initial Term$/ do
  @matrix_second_term.manage
  on FEMatrixView do |page|
    page.term_type_select.select @matrix_term.term_type
    page.submit
  end
end

When /^I view the second term$/ do
  @matrix_second_term.manage
end

When /^I view the half term$/ do
  @matrix_halfterm.manage
end

When /^I associate the second Term with the Final Exam matrix of the third Term$/ do
  @matrix_second_term.manage
  on FEMatrixView do |page|
    page.term_type_select.select @matrix_third_term.term_type
    page.submit
  end
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
    page.get_common_fe_requirements( @matrix.courses).should match /#{@matrix.courses}/
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

Then /^I should be able to see the Common Final Exam rule with the multiple statements$/ do
  on FEMatrixView do |page|
    page.get_common_fe_day( @matrix.courses).should match /#{@matrix.rdl_days}/
    page.get_common_fe_time( @matrix.courses).should match /#{@matrix.start_time} #{@matrix.time_ampm.upcase}-#{@matrix.end_time} #{@matrix.time_ampm.upcase}/
  end
end

Then /^I should be able to see all the changes I have made on the Final Exam Matrix$/ do
  on FEMatrixView do |page|
    page.standard_final_exam_table.present?.should be_true
    requirements = page.get_standard_fe_requirements( @matrix_rule_list[0].days)
    requirements.should match /#{@matrix_rule_list[0].days} at #{@matrix_rule_list[0].start_time} #{@matrix_rule_list[0].time_ampm.upcase} - #{@matrix_rule_list[0].end_time} #{@matrix_rule_list[0].time_ampm.upcase}\./
    page.get_standard_fe_requirements( @matrix_rule_list[1].free_text).should match /#{@matrix_rule_list[1].free_text}/
  end
end

Then /^the deleted text rule should not exist on the Final Exam Matrix$/ do
  on FEMatrixView do |page|
    page.standard_fe_target_row( @matrix.free_text).should == nil
  end
end

Then /^the rules should be sorted on the Days and Time columns$/ do
  on FEMatrixView do |page|
    table_text = page.standard_final_exam_table.text
    table_text.should match /Day 1.*Day 2.*Day 3.*Day 4.*Day 5.*Day 6/m
    day_one_text = []
    day_one_text << page.standard_fe_target_row( "TH at 06:00 AM - 07:15 AM.").text
    day_one_text << page.standard_fe_target_row( "MWF at 03:00 AM - 03:50 AM. Or MW at 03:00 AM - 04:15 AM.").text
    table_text.should match /#{day_one_text[0]}.*#{day_one_text[1]}/m
    day_six_text = []
    day_six_text << page.standard_fe_target_row( "MWF at 05:00 AM - 05:50 AM. Or MW at 04:30 AM - 05:45 AM.").text
    day_six_text << page.standard_fe_target_row( "TH at 10:30 AM - 11:45 AM.").text
    table_text.should match /#{day_six_text[0]}.*#{day_six_text[1]}/m
  end
end

Then /^the option to set the Exam Location should be disabled and selected$/ do
  on FEMatrixView do |page|
    page.set_exam_locations_toggle.attribute_value('disabled').should == "true"
    page.set_exam_locations_toggle.attribute_value('checked').should == "true"
  end
end

Then /^there is a message indicating that the final exam matrix for the initial term is used$/ do
  on FEMatrixView do |page|
    page.term_type_select.option(selected: "selected").text.should == "Fall Term"
  end
end

Then /^there is a message indicating that the final exam matrix for the initial term is not used$/ do
  on FEMatrixView do |page|
    page.term_type_select.option(selected: "selected").text.should_not == "Fall Term"
  end
end

Then /^no Standard Final Exam or Common Final Exam rules are listed$/ do
  on FEMatrixView do |page|
    page.standard_final_exam_section.visible?.should == false
    page.common_final_exam_section.visible?.should == false
  end
end

Then /^Standard Final Exam or Common Final Exam rules are listed$/ do
  on FEMatrixView do |page|
    page.standard_final_exam_section.visible?.should == true
    page.common_final_exam_section.visible?.should == true
  end
end

Then /^I should have a choice of terms from which to associate the Final Exam Matrix$/ do
  on FEMatrixView do |page|
    page.term_type_select.option(value: "kuali.atp.type.Fall").text.should == "Fall Term"
    page.term_type_select.option(value: "kuali.atp.type.Spring").text.should == "Spring Term"
  end
end