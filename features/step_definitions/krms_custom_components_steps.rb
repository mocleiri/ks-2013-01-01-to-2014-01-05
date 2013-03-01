When /^I search for (?:a|an) "(.*)" with text "(.*)"$/ do |section, code|
  fields = {"Single Course"=>:course, "Department"=>:department, "Organization"=>:organization, "Test Name"=>:test_name}
  go_to_krms_components
  on CustomComponents do |page|
    page.send(fields[section]).set code
  end
  sleep 1
end

Then /^the text "(.*)" should exist in the results$/ do |code|
  on CustomComponents do |page|
    page.auto_message.text.should == code
    page.execute_script("window.confirm = function() {return true}")
  end
  sleep 1
end

Then /^the text "(.*)" should not exist in the results$/ do |code|
  on CustomComponents do |page|
    if page.auto_message.exists?
      page.auto_message.text.should_not == code
    end
    page.execute_script("window.confirm = function() {return true}")
  end
  sleep 1
end

When /^I enter "(.*)" in the "(.*)" text field$/ do |num, section|
  fields = {"GPA"=>:gpa, "Test Score"=>:test_score}
  go_to_krms_components
  on CustomComponents do |page|
    page.send(fields[section]).set num
  end
  sleep 1
end

Then /^the "(.*)" should have an error message$/ do |section|
  fields = {"GPA"=>:gpa, "Test Score"=>:test_score}
  on CustomComponents do |page|
    page.send_keys :tab
    page.send(fields[section]).click
    sleep 2
    if page.error_message.exists?
      if fields[section] == "gpa"
        if page.send(fields[section]).text == /^\d$/
          page.error_message.text.should eq "Please enter at least 3 characters."
        elsif page.send(fields[section]).text == /^\d\d\d$/
          page.error_message.text.should eq "Must be a non-zero positive fixed point number, with 2 max digits and 1 digits to the right of the decimal point"
        end
      elsif fields[section] == "test_score"
        page.error_message.text.should eq "Must be a positive whole number"
      end
    else
      false
    end
    page.execute_script("window.confirm = function() {return true}")
    sleep 1
  end
end

Then /^the "(.*)" should have no error message$/ do |section|
  fields = {"GPA"=>:gpa, "Test Score"=>:test_score}
  on CustomComponents do |page|
    page.send_keys :tab
    page.send(fields[section]).click
    sleep 2
    if page.error_message.exists?
      page.error_message.text.should eq ""
    else
      true
    end
    page.execute_script("window.confirm = function() {return true}")
  end
  sleep 1
end

When /^I select "(.*)" for grade$/ do |select|
  go_to_krms_components
  on CustomComponents do |page|
    page.label(:value=>" #{select} ").click
  end
  sleep 1
end

Then /^there should be (\d*) options for grade$/ do |num|
  on CustomComponents do |page|
    select_list = page.grade_select
    array = select_list.options.map(&:text)
    count = 0
    array.each do |content|
      if content == ""
      else
        count += 1
      end
    end
    count.should eq num.to_i
  end
end