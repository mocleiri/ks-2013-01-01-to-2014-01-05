When /^I go to the Manage Course Offering Agendas page for "(.*)"$/ do |test|
  puts test
  @editAgenda = make EditAgendaData
  go_to_manage_co_agendas
end

When /^I go to the Manage Course Offerings page for "(.*)"$/ do |test|
  puts test
  @editAgenda = make EditAgendaData
  go_to_krms_manage_course_offerings
end

When /^I enter "(.*)" in the "(.*)" field on Manage CO page$/ do |input,field|
  fields = {"term"=>:term, "course"=>:input_code}
  on KRMSManageCourseOfferings do |page|
    page.send(fields[field]).when_present.set input
  end
end

When /^I click the "(.*)" button on Manage CO page$/ do |btn|
  buttons = {"Show"=>:show}
  on KRMSManageCourseOfferings do |page|
    page.send(buttons[btn])
  end
end

When /^I click the "(.*)" link for course "(.*)"$/ do |link,cours|
  on KRMSManageCourseOfferingList do |page|
    page.target_row(cours).link(text: link).when_present.click
  end
end

When /^I click on the "(.*)" link on Manage CO page$/ do |link|
  on KRMSManageCourseOfferings do |page|
    #link does not exist yet
    page.manage_course_offering_requisites
  end
end

When /^I click on the "(.*)" section$/ do |sect|
  on ManageCOAgendas do |page|
    page.agenda_management_section.span(text: sect).when_present.click
  end
end

When /^I click on the "(.*)" link$/ do |link|
  on ManageCOAgendas do |page|
    page.agenda_management_section.a(:text => /#{Regexp.escape(link)}/).when_present.click
  end
end

When /^I select node "(.*)" in the tree$/ do |letter|
  on EditAgenda do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(letter)}\..*/).when_present.click
  end
end

Then /^the background color should change to "(.*)"$/ do |color|
  colors = {"blue"=>"rgba(231,244,249,1)", "red"=>"rgba(255,0,0,1)"}
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.background_div.style('background-color').should == colors[color]
  end
end

When /^I click the "(.*)" button$/ do |btn|
  buttons = {"Add Rule Statement"=>:add_btn, "Add Parent"=>:group_btn, "Update Rule"=>:update_rule_btn, "Move Down"=>:down_btn,
             "Move Up"=>:up_btn, "Preview Change"=>:preview_btn, "Move Left"=>:left_btn, "Copy"=>:copy_btn,
             "Cut"=>:cut_btn, "Paste"=>:paste_btn, "Delete"=>:del_btn, "add"=>:add_line_btn, "Edit"=>:edit_btn}
  on EditAgenda do |page|
    page.send(buttons[btn])
  end
end

Then /^there should be nothing selected in the rule dropdown$/ do
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.select(:name => /.*editTree.*proposition\.typeId/).option(selected: "selected").text.should == ""
  end
end

Then /^the "(.*)" field should be empty$/ do |field|
  types = {"course"=>"courseInfo.code", "free form text"=>"termParameter"}
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text_field(:name => /.*editTree.*proposition\.#{Regexp.escape(types[field])}/).text.should == ""
  end
end

Then /^there should be a new node with text "(.*)"$/ do |text|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(text)}.*/
  end
end

Then /^there should be a dropdown with value "(.*)" before node "(.*)"$/ do |drop, node|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(drop)}.*#{Regexp.escape(node)}.*/m
  end
end

When /^I click the "(.*)" tab$/ do |tab|
  tabs = {"Edit Rule Logic"=>:logic_tab, "Edit Rule"=>:object_tab}
  on EditAgenda do |page|
    page.send(tabs[tab]).when_present.click
  end
end

Then /^the text "(.*)" should be present in the text area$/ do |text|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.logic_text.text.should == text
  end
end

Then /^the "(.*?)" preview section should have the text "(.*)"$/ do |section,text|
  sect = {"edit"=>:edit_tree_section, "logic"=>:preview_tree_section}

  test_text = @editAgenda.create_string_for_testing(section,text)
  if( section == "agenda")
    on ManageCOAgendas do |page|
      page.loading.wait_while_present
      page.agenda_management_section.text.should match /.*#{Regexp.escape(test_text)}.*/
    end
  else
    on EditAgenda do |page|
      page.loading.wait_while_present
      page.send(sect[section]).text.should match /.*#{Regexp.escape(test_text)}.*/
    end
  end
end

Then /^the word "(.*)" should exist before node "(.*)"$/ do |text, node|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.preview_tree_section.text.should match /.*#{Regexp.escape(text)}\n#{Regexp.escape(node)}.*/
  end
end

When /^I select "(.*)" from the dropdown before node "(.*)" on the "(.*)"$/ do |cond, node, comp|
  on EditAgenda do |page|
    id = @editAgenda.find_krms_before_element("edit_tree",'select',node, comp)
    page.edit_tree_section.select(:id => id).when_present.select cond
  end
end

When /^I select the "(.*)" option from the "(.*)" dropdown$/ do |rule, type|
  dropdown = {"rule"=>"proposition.typeId", "courses"=>"proposition.multipleCourseType"}
  on EditAgenda do |page|
    page.edit_tree_section.select(:name => /.*editTree.*#{Regexp.escape(dropdown[type])}/).when_present.select /#{Regexp.escape(rule)}/
  end
end

When /^I enter "(.*)" in the "(.*)" field$/ do |cors, field|
  types = {"course"=>:course_field, "free form text"=>:free_text_field, "courses"=>:courses_field,
            "number of courses"=>:number_courses_field}
  on EditAgenda do |page|
    page.send(types[field]).when_present.set cors
  end
end

Then /^the first node should match "(.*)"$/ do |text|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(text)}.*/
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
    page.loading.wait_while_present
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).id.should match /u\d+_node_\d+_parent_node_\d+_parent_root_span/
  end
end

Then /^node "(.*)" should be after node "(.*)"$/ do |second,first|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(first)}\..+#{Regexp.escape(second)}\..*/m
  end
end

Then /^the node "(.*)" should be a secondary node in the tree$/ do |node|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).id.should match /u\d+_node_\d+_parent_node_\d+_parent_node_\d+_parent_root_span/
  end
end

Then /^the loaded page should have "(.*)" as a heading$/ do |head|
  on ManageCOAgendas do |page|
    page.loading.wait_while_present
    page.agenda_management_section.html.should match /.*#{Regexp.escape(head)}.*/
  end
end

When /^I click the "(.*)" button on Manage CO Agendas page$/ do |btn|
  buttons = {"submit"=>:submit, "cancel"=>:cancel}
  on ManageCOAgendas do |page|
    page.send(buttons[btn])
  end
end

When /^I go to the Main Menu from Manage CO Agendas$/ do
  on ManageCOAgendas do |page|
    page.main_menu
  end
end

Then /^the new node "(.*)" should be after an "(.*)" operator$/ do |node, operator|
  on ManageCOAgendas do |page|
    page.loading.wait_while_present
    page.preview_tree.text.should match /.*#{Regexp.escape(operator)}\n#{Regexp.escape(node)}.*/m
  end
end

Then /^there should be no node with letter "(.*)"$/ do |letter|
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should_not match /.*#{Regexp.escape(letter)}.*/
  end
end

Then /^there should be no node "(.*)" before an "(.*)" operator$/ do |text, operator|
  on ManageCOAgendas do |page|
    page.loading.wait_while_present
    page.preview_tree.text.should_not match /.*#{Regexp.escape(text)}\n#{Regexp.escape(operator)}.*/
  end
end

When /^I search for the "(.*)" "(.*)"$/ do |field, code|
  @editAgenda.advanced_search(field, code)
end

When /^I click on the "(.*)" link on the Edit Agenda page$/ do |link|
  sect = {"Compare to Canonical"=>:preview_rule_section, "Cancel"=>:rule_maintenance_section}
  on EditAgenda do |page|
    page.send(sect[link]).a(:text => /#{Regexp.escape(link)}/).when_present.click
  end
end

Then /^the old and new rule should be compared$/ do
  on EditAgenda do |page|
    page.loading.wait_while_present
    page.compare_rule_section.text.should match /Compare CLU and CO Rules/
  end
end

When /^I set up the data for "(.*?)" for the course "(.*?)" with Advanced Search$/ do |section, course|
  @editAgenda = make EditAgendaData
  go_to_krms_manage_course_offerings
  @editAgenda.create_data_advanced_search(section, course)
end

When /^I navigate to the agenda page for "(.*?)"$/ do |course|
  go_to_krms_manage_course_offerings
  @editAgenda.navigate(course)
end

Then /^the "(.*?)" rule should still exist$/ do |sect|
  sections_click = {"Student Eligibility & Prerequisite"=>:eligibility_prereq, "Antirequisite"=>:antirequisite,
              "Corequisite"=>:corequisite, "Recommended Preparation"=>:recommended_prep,
              "Repeatable for Credit"=>:repeatable_credit, "Restricted for Credit"=>:resctricted_credit}
  on ManageCOAgendas do |page|
    page.send(sections_click[sect])
    puts page.agenda_management_section.div(id:"u100081").div(id: "KRMS-PreviewTree-Group").text
  end
end

When /^I am busy with "(.*?)"$/ do |scenario|
  puts "Testing: " + scenario
end