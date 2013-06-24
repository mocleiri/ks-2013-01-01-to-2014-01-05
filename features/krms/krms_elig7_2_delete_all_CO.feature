@nightly
Feature: KRMS ELIG7.2 Delete all statements of CO copied from CLU

  Background:
    Given I am logged in as admin
    And I have navigated to the agenda page for "Student Eligibility & Prerequisite" for term "201208" and course "ENGL313"

  #ELIG7.2.EB1 (KSENROLL-7247)
  Scenario: Test whether tree deleted is removed from all tabs on the page
    When I want to edit the selected agenda section
    And I delete the tree
    And I commit and return to see the changes made to the proposition
    Then the tree in the selected agenda section should be empty
