When /^I go to the Manage Course Offering Agendas page for "(.*)"$/ do |test|
  puts test
  @editAgenda = make EditAgendaData
  go_to_manage_co_agendas
end

When /^I go to the Manage Course Offerings page for "(.*)"$/ do |test|
  puts test
  @editAgenda = make EditAgendaData
  go_to_manage_course_offerings
end

When /^I enter "(.*)" in the "(.*)" field on Manage CO page$/ do |input,field|
  fields = {"term"=>:term, "course"=>:input_code}
  on ManageCourseOfferings do |page|
    page.send(fields[field]).set input
  end
end

When /^I click the "(.*)" button on Manage CO page$/ do |btn|
  buttons = {"Show"=>:show}
  on ManageCourseOfferings do |page|
    page.send(buttons[btn])
  end
end

When /^I click the "(.*)" link for course "(.*)"$/ do |link,cours|
  on ManageCourseOfferingList do |page|
    page.target_row(cours).link(text: link).click
  end
  sleep 5
end

When /^I click on the "(.*)" link on Manage CO page$/ do |link|
  on ManageCourseOfferings do |page|
    #link does not exist yet
    #page.link(text: link).click
  end
end

When /^I click on the "(.*)" section$/ do |sect|
  on ManageCOAgendas do |page|
    page.agenda_management_section.span(text: sect).when_present.click
  end
  sleep 2
end

When /^I click on the "(.*)" link$/ do |link|
  on ManageCOAgendas do |page|
    page.rule_edit_links.a(text: link).when_present.click
  end
  sleep 2
end

When /^I select node "(.*)" in the tree$/ do |letter|
  on EditAgenda do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(letter)}\..*/).when_present.click
  end
end

Then /^the background color should change to "(.*)"$/ do |color|
  colors = {"blue"=>"rgba(231,244,249,1)", "red"=>"rgba(255,0,0,1)"}
  on EditAgenda do |page|
    page.background_div.style('background-color').should == colors[color]
  end
  sleep 5
end

When /^I click the "(.*)" button$/ do |btn|
  buttons = {"Add Requisite"=>:add_btn, "Group"=>:group_btn, "Update Rule"=>:update_rule_btn, "Move Down"=>:down_btn,
             "Move Up"=>:up_btn, "Preview Change"=>:preview_btn, "Move Left"=>:left_btn}
  on EditAgenda do |page|
    page.send(buttons[btn]).when_present.click
  end
  sleep 5
end

Then /^there should be nothing selected in the rule dropdown$/ do
  on EditAgenda do |page|
    page.edit_tree_section.select(:name => /.*editTree.*proposition\.typeId/).option(selected: "selected").text.should == ""
  end
  sleep 5
end

Then /^the "(.*)" field should be empty$/ do |field|
  types = {"course"=>"courseInfo.code", "free form text"=>"termParameter"}
  on EditAgenda do |page|
    page.edit_tree_section.text_field(:name => /.*editTree.*proposition\.#{Regexp.escape(types[field])}/).text.should == ""
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
    page.edit_tree_section.text.should match /.*#{Regexp.escape(drop)}.*#{Regexp.escape(node)}.*/m
  end
  sleep 5
end

When /^I click the "(.*)" tab$/ do |tab|
  tabs = {"Logic"=>:logic_tab, "Object"=>:object_tab}
  on EditAgenda do |page|
    page.send(tabs[tab]).when_present.click
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
    page.edit_tree_section.when_present.select(:id => id).select cond
  end
  sleep 3
end

When /^I select the "(.*)" option from the rule dropdown$/ do |rule|
  on EditAgenda do |page|
    page.edit_tree_section.select(:name => /.*editTree.*proposition\.typeId/).when_present.select /#{Regexp.escape(rule)}/
  end
  sleep 10
end

When /^I enter "(.*)" in the "(.*)" field$/ do |cors, field|
  types = {"course"=>:course_field, "free form text"=>:free_text_field}
  on EditAgenda do |page|
    page.edit_tree_section.send(types[field]).when_present.set cors
  end
end

Then /^the first node should match "(.*)"$/ do |text|
  on EditAgenda do |page|
    page.edit_tree_section.text.should match /.*A\..*#{Regexp.escape(text)}.*/
  end
end

When /^I change the preview text area to "(.*)"$/ do |prev|
  on EditAgenda do |page|
    page.logic_text.clear
    page.logic_text.when_present.set prev
  end
end

Then /^the node "(.*)" should be a primary node in the tree$/ do |node|
  on EditAgenda do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).id.should match /u\d+_node_\d+_parent_node_\d+_parent_root_span/
  end
end

Then /^node "(.*)" should be after node "(.*)"$/ do |second,first|
  on EditAgenda do |page|
    page.edit_tree_section.text.should match /.*#{Regexp.escape(first)}\..+#{Regexp.escape(second)}\..*/m
  end
end

Then /^the node "(.*)" should be a secondary node in the tree$/ do |node|
  on EditAgenda do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).id.should match /u\d+_node_\d+_parent_node_\d+_parent_node_\d+_parent_root_span/
  end
end