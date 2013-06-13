When /^I (?:|setup|edit|have setup) the data for "(.*?)" for term "(.*?)" and course "(.*?)"$/ do |section, term, course|
  @manageCOR = make ManageCORequisitesData
  @courseOR = make CORequisitesData, :section => section
  @courseOR.data_setup(section, term, course)
end

When /^I (?:|navigate|have navigated) to the agenda page for "(.*?)" for term "(.*?)" and course "(.*?)"$/ do |section, term, course|
  @manageCOR = make ManageCORequisitesData
  @courseOR = make CORequisitesData, :section => section
  @courseOR.navigate(term, course)
end

Then /^the "(.*?)" link should exist on the Course Offering Requisites page$/ do |link|
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    if page.agenda_management_section.a(:text => /#{Regexp.escape(link)}/).exists?
      true
    else
      false
    end
  end
end

Then /^the CO and CLU should both have text "(.*?)"/ do |text|
  @manageCOR.test_text("compare", text, true)
end

Then /^the CO and CLU should differ with text "(.*?)"/ do |text|
  @manageCOR.test_text("compare", text, false)
end

Then /^the info message "(.*?)" should be present$/ do |mess|
  on ManageCORequisites do |page|
    page.info_message.text.should match /#{Regexp.escape(mess)}/
  end
end

When /^I want to edit the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_edit
  end
end

When /^I want to add a new statement to the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_add
  end
end

When /^I delete node "(.)" in the tree$/ do |node|
  on ManageCORequisites do |page|
    page.edit_tree_section.span(:text => /.*#{Regexp.escape(node)}\..*/).when_present.click
    page.del_btn
  end
end

When /^I edit node "(.*?)" in the tree by changing the "(.*?)" to "(.*?)"$/ do |node, field, change|
  @manageCOR.edit_existing_node(node, field, change)
end

When /^I add a "(.*?)" statement after node "(.*?)" with courses "([^\"]+)" and course set "(.*?)"$/ do |field, node, course, set|
  @manageCOR.add_new_node(@courseOR.section, field, node, course, set)
end

When /^I add a "(.*?)" statement after node "(.*?)" with (?:|courses|course|text) "([^\"]+)"$/ do |field, node, course|
  @manageCOR.add_new_node(@courseOR.section, field, node, course, "")
end

When /^I add a new "(.*?)" statement with courses "([^\"]+)" and course set "(.*?)"$/ do |field, course, set|
  @manageCOR.add_new_node(@courseOR.section, field, "", course, set)
end

When /^I add a new "(.*?)" statement with course sets "([^\"]+)"$/ do |field, set|
  @manageCOR.add_new_node(@courseOR.section, field, "", "", set)
end

When /^I add a new "(.*?)" statement with (?:|courses|course|text) "([^\"]+)"$/ do |field, course|
  @manageCOR.add_new_node(@courseOR.section, field, "", course, "")
end

When /^I create a group with node "(.*?)" by adding a "(.*?)" statement with courses "([^\"]+)" and course set "(.*?)"$/ do |node, field, course, set|
  @manageCOR.create_new_group(@courseOR.section, field, node, course, set)
end

When /^I create a group with node "(.*?)" by adding a "(.*?)" statement with (?:|courses|course|text) "([^\"]+)"$/ do |node, field, course|
  @manageCOR.create_new_group(@courseOR.section, field, node, course, "")
end

When /^I commit and return to see the changes made to the proposition$/ do
  @courseOR.commit_changes( true)
end

When /^I commit changes made to the proposition$/ do
  @courseOR.commit_changes( false)
end

Then /^the tree in the selected agenda section should be empty$/ do
  @courseOR.assert_agenda_tree_contents
end

Then /^there should be no node "(.*?)" on both tabs$/ do |node|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should_not =~ /.*#{Regexp.escape(node)}\..*/
    page.logic_tab
    page.edit_loading.wait_while_present
    page.logic_text.text.should_not =~ /.*#{Regexp.escape(node)}.*/
  end
end

When /^I delete the tree in the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_delete
  end
end

Then /^the "(.*?)" (?:|page|tab) should have the text "(.*)"$/ do |page,text|
  if page == "agenda"
    @courseOR.open_agenda_section
  end
  @manageCOR.test_text(page, text, true)
end

Then /^the "(.*?)" (?:|page|tab) should not have the text "(.*)"$/ do |page,text|
  if page == "agenda"
    @courseOR.open_agenda_section
  end
  @manageCOR.test_text(page, text, false)
end

When /^I switch to the other tab on the page$/ do
  @manageCOR.switch_tabs
end

Then /^the text "(.*)" should be present in the text area$/ do |text|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.logic_text.text.should == text
  end
end

When /^I want to compare the CO to the CLU for the selected agenda section$/ do
  @courseOR.open_agenda_section
  on CourseOfferingRequisites do |page|
    page.rule_compare
  end
end

Then /^the text "(.*?)" should show correctly on all pages$/ do |text|
  @manageCOR.check_text_correct( text, true, @courseOR.section)
end

When /^I update the manage course offering agendas page$/ do
  on ManageCORequisites do |page|
    page.update_rule_btn
  end
end

When /^I move node "(.)" down$/ do |node|
  @manageCOR.move_around(node, "down")
end

When /^I move node "(.)" up$/ do |node|
  @manageCOR.move_around(node, "up")
end

When /^I move node "(.)" out of the group$/ do |node|
  @manageCOR.move_around(node, "out")
end

When /^I move node "(.)" into the group$/ do |node|
  @manageCOR.move_around(node, "in")
end

When /^I move node "(.)" out of and into the group$/ do |node|
  @manageCOR.move_around(node, "out up in")
end

When /^I move node "(.)" out and in$/ do |node|
  @manageCOR.move_around(node, "out in")
end

Then /^node "(.*)" should be after node "(.*)"$/ do |second,first|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(first)}\..+#{Regexp.escape(second)}\..*/m
  end
end

When /^I change a "(.*?)" logical operator to "(.*?)"$/ do |level, operator|
  @manageCOR.change_operator(level, operator)
end

Then /^the first node should match "(.*)"$/ do |text|
  on ManageCORequisites do |page|
    page.loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(text)}.*/
  end
end

Then /^node "(.*)" should be a "(.*)" node in the tree$/ do |node, level|
  @manageCOR.test_node_level(level, node)
end

Then /^there should be a dropdown with value "(.*)" before node "(.*)"$/ do |drop, node|
  on ManageCORequisites do |page|
    page.edit_loading.wait_while_present
    page.edit_tree_section.text.should match /.*#{Regexp.escape(drop)}.*#{Regexp.escape(node)}.*/m
  end
end

When /^I copy node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @manageCOR.copy_cut_paste( node, node_after, "copy")
end

When /^I cut node "(.)" and paste it after node "(.)"$/ do |node, node_after|
  @manageCOR.copy_cut_paste( node, node_after, "cut")
end