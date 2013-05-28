Feature: KRMS Data Setup

  Background:
    Given I am logged in as admin

  #KSENROLL-6953
  @pending
  Scenario: Test whether data is created and persisted to the DB
    When I set up the data for "Student Eligibility & Prerequisite" for the course "HIST110" with Advanced Search
    And I navigate to the agenda page for "HIST110"
    And I click on the "Student Eligibility & Prerequisite" section
    Then the "agenda" preview section should have the text "Must have successfully completed all courses from,ENGL478,HIST416"
    When I click on the "Edit Rule" link
    Then the "edit" preview section should have the text "Must have successfully completed a minimum of 1 course from (HIST210, HIST395)"
    When I click the "Edit Rule Logic" tab
    Then the text "A(B(C AND D(E OR F) AND G) OR H OR I OR J)" should be present in the text area