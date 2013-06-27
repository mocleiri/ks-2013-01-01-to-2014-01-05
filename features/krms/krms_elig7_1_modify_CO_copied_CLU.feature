@nightly
Feature: KRMS ELIG7.1 Modify CO copied from CLU

  Background:
    Given I am logged in as admin
    And I have navigated to the agenda page for "Student Eligibility & Prerequisite" for term "201208" and course "BSCI361"

  #ELIG7.1.EB1 (KSENROLL-7245)
  Scenario: Test whether editing existing statements persists to the database
    When I want to edit the selected agenda section
    And I edit node "A" by changing course to "BSCI329"
    And I commit and return to see the changes made to the proposition
    Then the agenda page should have the text "Must have successfully completed BSCI329"

  #ELIG7.1.EB2 (KSENROLL-7245)
  Scenario: Test whether adding new statement to existing statements persists to the database
    When I want to edit the selected agenda section
    And I add a courses statement after node "B" with courses "HIST110,ENGL313"
    And I commit and return to see the changes made to the proposition
    Then the agenda page should have the text "Must have successfully completed all courses from,ENGL313,HIST110"

  #ELIG7.1.EB3 (KSENROLL-7245)
  Scenario: Test whether editing newly added statements persists to the database
    When I want to edit the selected agenda section
    And I edit node "C" by adding course "BSCI103"
    And I commit and return to see the changes made to the proposition
    Then the agenda page should have the text "Must have successfully completed all courses from,BSCI103,ENGL313,HIST110"

  #ELIG7.1.EB4 (KSENROLL-7245)
  Scenario: Test whether deleting statements persists to the database
    When I want to edit the selected agenda section
    And I delete node "C" in the tree
    And I commit and return to see the changes made to the proposition
    Then the agenda page should not have the text "Must have successfully completed all courses from,BSCI103,ENGL313,HIST110"
