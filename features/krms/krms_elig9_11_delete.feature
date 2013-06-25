Feature: KRMS ELIG9.11 Delete

  Background:
    Given I am logged in as admin
    And I have setup the data for "Student Eligibility & Prerequisite" for term "201301" and course "ENGL101S"

  #ELIG9.11.EB1 (KSENROLL-7084)
  @pending
  Scenario: Confirm that the Delete button works as expected
    When I want to edit the selected agenda section
    And I delete node "F" in the tree
    Then there should be no node "F" on both tabs

  #ELIG9.11.EB2 (KSENROLL-7084)
  @pending
  Scenario: Confirm that the Submit button persists the data after Delete
    When I want to edit the selected agenda section
    And I delete node "G" in the tree
    And I commit and return to see the changes made to the proposition
    Then the agenda page should not have the text "Must have successfully completed a minimum of 1 course from,HIST210,HIST395"
    When I want to edit the selected agenda section
    Then there should be no node "G" on both tabs

  #ELIG9.11.EB3 (KSENROLL-7089)
  @pending
  Scenario: Confirm that the Delete Rule link on Agenda Preview page deletes the tree
    When I delete the tree in the selected agenda section
    And I commit and return to see the changes made to the proposition
    Then the tree in the selected agenda section should be empty
