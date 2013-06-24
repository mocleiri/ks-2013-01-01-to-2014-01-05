Feature: KRMS ELIG9.1 Data Setup

  Background:
    Given I am logged in as admin

  #ELIG9.1.EB1 (KSENROLL-6953)
  @pending
  Scenario: Test whether data is created and persisted to the DB
    When I setup the data for "Student Eligibility & Prerequisite" for term "201301" and course "HIST110"
    Then the "agenda" page should have the text "Must have successfully completed all courses from,ENGL478,HIST416"
    When I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 1 course from (HIST210, HIST395)"
    When I switch to the other tab on the page
    Then the text "(A AND (B OR C) AND D) OR E OR F OR G" should be present in the text area