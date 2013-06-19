When /^I run the State Propagation test$/ do
  go_to_state_propagation
  @state_propagation = make StatePropagation
  on StatePropagation do |page|
    page.perform_propagation_test
  end
end

Then /^all State Propagation test rows should have status pass$/ do
  on StatePropagation do |page|
    page.read_results_tables.should be_true
  end
end