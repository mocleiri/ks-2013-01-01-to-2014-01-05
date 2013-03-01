When /^I go to the Edit Agenda page$/ do
  go_to_krms_edit_agenda
end

When /^I select the "(.*)" node in the tree$/ do |node|
  on EditAgenda do |page|
    page.tree_section.span(:text => /.*#{Regexp.escape(node)}.*/).click
  end
end

Then /^the background color should change to "(.*)"$/ do |color|
  colors = {"blue"=>"rgba(231,244,249,1)"}
  on EditAgenda do |page|
    page.background_div.style('background-color').should == colors[color]
  end
end

