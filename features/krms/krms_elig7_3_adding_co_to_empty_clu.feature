Feature: KRMS ELIG7.3 Adding CO to empty CLU

  Background:
    Given I am logged in as admin

  #ELIG7.3.EB1 (KSENROLL-7177)
  Scenario: Test whether CO data persists if CLU was empty
    When I set up the data for "Student Eligibility & Prerequisite" for the course "HIST798" with Advanced Search
    Then the "agenda" preview section should have the text "Must have successfully completed all courses from,ENGL478,HIST416"
    When I click on the "Edit Rule" link
    Then the "edit" preview section should have the text "Must have successfully completed a minimum of 1 course from (HIST210, HIST395)"
    When I click the "Edit Rule Logic" tab
    Then the text "A(B(C AND D(E OR F) AND G) OR H OR I OR J)" should be present in the text area
