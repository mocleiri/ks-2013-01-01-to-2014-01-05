# cucumber -r features features/krms/krms_elig9_10_copy_and_paste.feature
Feature: KRMS ELIG 9-10 Copy and paste

  Background:
    Given I am logged in as admin

## Start data setup for AFT
#  #KSENROLL-6953
#  @pending
#  Scenario: Temporary scenario to test the setup of the data for every other scenario
#    When I set up the data for "Student Eligibility & Prerequisite" for the course "HIST111" with Advanced Search
#    And I navigate to the agenda page for "HIST111"
#    Then the "Student Eligibility & Prerequisite" rule should still exist
## End data setup for AFT

  #krms_elig9_10_copy_and_paste
  @pending
  Scenario: Confirm the copy and paste of rule statement is working as expected
    When I set up the data for "Student Eligibility & Prerequisite" for the course "HIST111" with Advanced Search
    And I navigate to the agenda page for "HIST111"
    Then the "Student Eligibility & Prerequisite" rule should still exist
#    When I navigate to the agenda page for "HIST111"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    Then there should be a new node with text "A. Must meet 1 of the following"
    And I select node "G" in the tree
    And I click the "Copy" button
    And I select node "I" in the tree
    And I click the "Paste" button
    Then there should be a new node with text "J. Text"
    And there should be a dropdown with value "OR" before node "J."
    And I click the "Edit Rule Logic" tab
    Then the text "A(B(C AND D(E OR F) AND G) OR H OR I OR J)" should be present in the text area

    # Edit existing prop type and change the value
    And I select node "J" in the tree
    And I click the "Edit" button
    And I enter "edit copied prop type 1" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "J. edit copied prop type 1"
	Then there should be a new node with text "G. Text"

	#Submit changes
    When I click the "Update Rule" button
    When I click the "submit" button on Manage CO Agendas page
    
  #krms_elig9_10_copy_and_paste
  @pending
  Scenario: Confirm the copy and paste of compound (group) rule statement is working as expected
   When I navigate to the agenda page for "HIST111"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    Then there should be a new node with text "A. Must meet 1 of the following"
    And I select node "D" in the tree
    And I click the "Copy" button
    And I select node "I" in the tree
    And I click the "Paste" button
    Then there should be a new node with text "K. Must meet 1 of the following"
    Then there should be a new node with text "L. Must have successfully completed all courses from (ENGL478, HIST416)"
    Then there should be a new node with text "M. Must have successfully completed a minimum of 1 course from (HIST210, HIST395)"
    And there should be a dropdown with value "OR" before node "K."
    And I click the "Edit Rule Logic" tab
    Then the text "A(B(C AND D(E OR F) AND G) OR H OR I OR K(L OR M) OR J)" should be present in the text area

    #Submit changes
    When I click the "Update Rule" button
    When I click the "submit" button on Manage CO Agendas page
    
#    #krms_elig9_10_copy_and_paste
#    @pending
#    Scenario: Confirm the copy and paste reflect correclty on the Edit Rule Logic tab after the submit
#    When I navigate to the agenda page for "ENGL301"
#    And I click on the "Corequisite" section
#    And I click on the "Edit Rule" link
#    And I click the "Edit Rule Logic" tab
#    # Issue with this, not sure why - seems like it has todo with the way the text string is copied
#    Then the text "A(B(C AND D(E AND F)) AND G AND H(I AND J AND K(L AND M) AND N))" should be present in the text area