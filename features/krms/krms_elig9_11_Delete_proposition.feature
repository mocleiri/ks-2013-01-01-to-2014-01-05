# cucumber -r features features/krms/krms_elig9_11_Delete_proposition.feature
Feature: KRMS ELIG9.11 Delete proposition

  Background:
    Given I am logged in as admin

  #ELIG9.11.EB1 (KSENROLL-7084)
  Scenario: Confirm that the Delete button works as expected
    When I am busy with "ELIG9.11.EB1 (KSENROLL-7084)"
    And I set up the data for "Student Eligibility & Prerequisite" for the course "HIST110" with Advanced Search
    And I navigate to the agenda page for "HIST110"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "F" in the tree
    And I click the "Delete" button
    Then there should be no node with letter "F."
    And I click the "Edit Rule Logic" tab
    Then the text "A(B(C AND D(E) AND G) OR H OR I)" should be present in the text area

  #ELIG9.11.EB2 (KSENROLL-7084)
  Scenario: Confirm that the Submit button persists the data after Delete
    When I am busy with "ELIG9.11.EB2 (KSENROLL-7084)"
    And I set up the data for "Student Eligibility & Prerequisite" for the course "HIST110" with Advanced Search
    And I navigate to the agenda page for "HIST110"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "F" in the tree
    And I click the "Delete" button
    And I click the "Update Rule" button
    And I click the "submit" button on Manage CO Agendas page
    And I go to the Main Menu from Manage CO Agendas
    And I navigate to the agenda page for "HIST110"
    And I click on the "Student Eligibility & Prerequisite" section
    Then the "agenda" preview section should not have the text "Must have successfully completed a minimum of 1 course from,HIST210,HIST395"
    When I click on the "Edit Rule" link
    Then the "edit" preview section should not have the text "Must have successfully completed a minimum of 1 course from (HIST210, HIST395)"
    When I click the "Edit Rule Logic" tab
    Then the "logic" preview section should not have the text "Must have successfully completed a minimum of 1 course from,HIST210,HIST395"
