@nightly
Feature: KRMS.ELIG9-1 Data Setup

  Background:
    Given I am logged in as admin

  #ELIG9.1.EB1 (KSENROLL-6953)
  Scenario: Test whether data is created and persisted to the DB
    When I setup the Student Eligibility & Prerequisite section for course "HIST110" in the future term
    Then the agenda page's text should match "all courses from,ENGL478,HIST416"
    When I want to edit the selected agenda section
    Then the edit tab's text should match "minimum of 1 course from (HIST210, HIST395)"
    When I switch to the other tab on the page
    Then the text area should contain "(A AND (B OR C) AND D) OR E OR F OR G"