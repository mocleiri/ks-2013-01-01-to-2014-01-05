When /^I go to the Edit Agenda page for "(.*)"$/ do |test|
  puts test
  @editAgenda = make EditAgendaData
  go_to_krms_edit_agenda
end

When /^I select node "(.*)" in the tree$/ do |letter|
  on EditAgenda do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(letter)}.*/).click
  end
  sleep 5
end

Then /^the background color should change to "(.*)"$/ do |color|
  colors = {"blue"=>"rgba(231,244,249,1)", "red"=>"rgba(255,0,0,1)"}
  on EditAgenda do |page|
    page.background_div.style('background-color').should == colors[color]
  end
  sleep 5
end

When /^I click the "(.*)" button$/ do |btn|
  buttons = {"Add Requisite"=>:add_btn, "Group"=>:group_btn, "Update"=>:update_btn}
  on EditAgenda do |page|
    page.send(buttons[btn]).click
  end
  sleep 7
end

Then /^there should be nothing selected in the node "(.*)" rule dropdown in parent node "(.*)"$/ do |node, parent|
  on EditAgenda do |page|
    id_val = @editAgenda.find_krms_element("edit_tree",'select',node, parent)
    page.edit_tree_section.select(:id => id_val).option(selected: "selected").text.should == ""
  end
  sleep 5
end

Then /^the "(.*)" field in node "(.*)" in parent node "(.*)" should be empty$/ do |field,node,parent|
  types = {"course"=>'input', "free form text"=>'textarea'}
  on EditAgenda do |page|
    id = @editAgenda.find_krms_element("edit_tree",types[field],node,parent)
    page.edit_tree_section.text_field(:id => id).text.should == ""
  end
  sleep 5
end

Then /^there should be a new node with text "(.*)"$/ do |text|
  on EditAgenda do |page|
    page.edit_tree_section.text.should match /.*#{Regexp.escape(text)}.*/
  end
  sleep 2
end

Then /^there should be a dropdown with value "(.*)" before node "(.*)"$/ do |drop, node|
  on EditAgenda do |page|
    id = @editAgenda.find_krms_before_element("edit_tree",'select',node)
    page.edit_tree_section.select(:id => id).option(selected: "selected").text.should == drop
  end
  sleep 5
end

Then /^I click the "(.*)" tab$/ do |tab|
  tabs = {"Logic"=>:logic_tab}
  on EditAgenda do |page|
    page.send(tabs[tab]).click
  end
  sleep 3
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
  sleep 5
end

Then /^the word "(.*)" should exist before node "(.*)"$/ do |text, node|
  on EditAgenda do |page|
    page.preview_tree_section.text.should match /.*#{Regexp.escape(text)}\n#{Regexp.escape(node)}.*/
  end
  sleep 5
end

When /^I select "(.*)" from the dropdown before node "(.*)"$/ do |cond, node|
  on EditAgenda do |page|
    id = @editAgenda.find_krms_before_element("edit_tree",'select',node)
    page.edit_tree_section.select(:id => id).select cond
  end
  sleep 3
end

When /^I select the "(.*)" option from the node "(.*)" rule dropdown in parent node "(.*)"$/ do |rule, node, parent_node|
  on EditAgenda do |page|
    id = @editAgenda.find_krms_element("edit_tree",'select',node,parent_node)
    page.edit_tree_section.select(:id => id).select /#{Regexp.escape(rule)}/
  end
  sleep 5
end

When /^I enter "(.*)" in the "(.*)" field in node "(.*)" in parent node "(.*)"$/ do |cors, field, node, parent_node|
  types = {"course"=>'input', "free form text"=>'textarea'}
  on EditAgenda do |page|
    id = @editAgenda.find_krms_element("edit_tree",types[field],node,parent_node)
    page.edit_tree_section.text_field(:id => id).set cors
  end
  sleep 5
end

Then /^there should be a child node "(.*)" inside node "(.*)"$/ do |child,parent|
  on EditAgenda do |page|
    page.edit_tree_section.text.should match /.*#{Regexp.escape(parent)}\..+#{Regexp.escape(child)}\..*/m #
  end
  sleep 5
end

When /^I change the conditional operator for node "(\d+)" in parent node "(\d+)" to "(.*)"$/ do |node, parent, cond|
  on EditAgenda do |page|
    page.edit_tree_section.select(:id => /.*_node_#{Regexp.escape(node)}_parent_node_#{Regexp.escape(parent)}.*/).select cond
  end
  sleep 3
end

Then /^the first node should match "(.*)"$/ do |text|
  on EditAgenda do |page|
    page.edit_tree_section.text.should match /.*A\..*#{Regexp.escape(text)}.*/
  end
end