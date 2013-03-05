When /^I go to the Edit Agenda page for "(.*)"$/ do |test|
  puts test
  @editAgenda = make EditAgendaData
  go_to_krms_edit_agenda
end

When /^I select node "(.*)" in the tree$/ do |letter|
  on EditAgenda do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(letter)}.*/).click
  end
end

Then /^the background color should change to "(.*)"$/ do |color|
  colors = {"blue"=>"rgba(231,244,249,1)", "red"=>"rgba(255,0,0,1)"}
  on EditAgenda do |page|
    page.background_div.style('background-color').should == colors[color]
  end
end

When /^I click the "(.*)" button$/ do |btn|
  buttons = {"Add Requisite"=>:add_btn, "Update"=>:update_btn}
  on EditAgenda do |page|
    page.send(buttons[btn]).click
  end
  sleep 3
end

Then /^there should be nothing selected in the node "(.*)" rule dropdown$/ do |node|
  on EditAgenda do |page|
    id_val = @editAgenda.find_krms_element("edit_tree",'select',node)
    page.edit_tree_section.select(:id => id_val).option(selected: "selected").text.should == ""
  end
end

When /^I select the "(.*)" option from the node "(.*)" rule dropdown$/ do |rule,node|
  on EditAgenda do |page|
    id_val = @editAgenda.find_krms_element("edit_tree",'select',node)
    page.edit_tree_section.select(:id => id_val).select rule
  end
  sleep 5
end

Then /^the course field in node "(.*)" should be empty$/ do |node|
  on EditAgenda do |page|
    course_id = @editAgenda.find_krms_element("edit_tree",'input',node)
    page.edit_tree_section.text_field(:id => course_id).text.should == ""
  end
end

When /^I enter "(.*)" in the course field in node "(.*)"$/ do |cors, node|
  on EditAgenda do |page|
    course_id = @editAgenda.find_krms_element("edit_tree",'input',node)
    page.edit_tree_section.text_field(:id => course_id).set cors
  end
end

Then /^there should be a new node with text "(.*)"$/ do |text|
  on EditAgenda do |page|
    page.edit_tree_section.text.should match /.*#{Regexp.escape(text)}.*/
  end
  sleep 2
end

Then /^there should be a dropdown prefilled with "(.*)" before node "(.*)"$/ do |drop, node|
  on EditAgenda do |page|
    @editAgenda.find_krms_before_element("edit_tree",'select',node).should == drop
  end
end

Then /^I click the "(.*)" tab$/ do |tab|
  tabs = {"Logic"=>:logic_tab}
  on EditAgenda do |page|
    page.send(tabs[tab]).click
  end
end

Then /^the text "(.*)" should be present in the text area$/ do |text|
  on EditAgenda do |page|
    page.logic_text.text.should == text
  end
  sleep 3
end

Then /^the preview section should have the text "(.*)"$/ do |text|
  on EditAgenda do |page|
    page.preview_tree_section.text.should match /.*#{Regexp.escape(text)}.*/
  end
end

Then /^the word "(.*)" should exist before node "(.*)"$/ do |text, node|
  on EditAgenda do |page|
    page.preview_tree_section.text.should match /.*#{Regexp.escape(text)}\n#{Regexp.escape(node)}.*/
  end
end