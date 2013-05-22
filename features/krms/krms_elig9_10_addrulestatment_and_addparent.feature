# cucumber -r features features/krms/krms_elig9_10_addrulestatment_and_addparent.feature
Feature: KRMS ELIG 9-10 Confirm Add Rule Statment and Add Parent is working as expected

  Background:
    Given I am logged in as admin

  #krms_elig9_10_addrulestatment_and_addparent (KSENROLL-7049)
  @pending
  Scenario: Setup one level of data using "Add Rule Statement" button
   When I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Add Rule" link
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Free Text 1" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Free Text 2" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Free Text 3" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "B. Must meet all of the following"
    Then there should be a new node with text "A. Free Text 1"
    Then there should be a new node with text "C. Free Text 2"
    Then there should be a new node with text "D. Free Text 3"
    
    # Submit the changes
    When I click the "Update Rule" button
    When I click the "submit" button on Manage CO Agendas page
    
  #krms_elig9_10_addrulestatment_and_addparent (KSENROLL-7049)
  @pending
  Scenario: Setup second level of data (Groups) using "Add Parent" button
   When I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Free Text 1b" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "D" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Free Text 2b" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "F" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Free Text 2c" in the "free form text" field
    And I click the "Preview Change" button
    
    # Submit the changes
    When I click the "Update Rule" button
    When I click the "submit" button on Manage CO Agendas page
    
  #krms_elig9_10_addrulestatment_and_addparent (KSENROLL-7049)
  @pending
  Scenario: Confirm the data was created correctly and persisted correctly
   When I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Edit Rule" link
    Then there should be a new node with text "A. Must meet all of the following"
    Then there should be a new node with text "B. Must meet all of the following"
    Then there should be a new node with text "D. Must meet all of the following"
    Then there should be a new node with text "H. Must meet all of the following"
    Then there should be a new node with text "E. Free Text 1b"
    Then there should be a new node with text "F. Free Text 2c"
    Then there should be a new node with text "J. Free Text 2b"
    
  #KSENROLL-6953
  @pending
  Scenario: Temporary scenario to test the setup of the data for every other scenario
    When I set up the data for "Student Eligibility & Prerequisite" for the course "HIST110" with Advanced Search
    And I navigate to the agenda page for "HIST110"
    Then the "Student Eligibility & Prerequisite" rule should still exist
    