Feature: KRMS ELIG7.2 Delete statement or compound statement of CO copied from CLU

  Background:
    Given I am logged in as admin

  #ELIG7.6.EB1 (KSENROLL-7243)
  @pending
  Scenario: Test whether statement deleted in compound is removed from the tree
    When I edit the data for "Student Eligibility & Prerequisite" for term "201208" and course "PHYS275"
    And I want to edit the "Student Eligibility & Prerequisite" section
    And I delete node "K" in the tree
    Then there should be no node "K" on both tabs
    When I commit and return to see the changes made to the proposition
    And I click on the "Student Eligibility & Prerequisite" section
    Then the "agenda" preview section should not have the text "Must have successfully completed a minimum of 1 course from,HIST210,HIST395"

  #ELIG7.6.EB2 (KSENROLL-7243)
  Scenario: Test whether compound deleted is removed from the tree
    When I edit the data for "Student Eligibility & Prerequisite" for term "201208" and course "PHYS275"
    And I want to edit the "Student Eligibility & Prerequisite" section
    And I delete node "H" in the tree
    Then there should be no node "H" on both tabs
    When I commit and return to see the changes made to the proposition
    And I click on the "Student Eligibility & Prerequisite" section
    Then the "agenda" preview section should not have the text "Must meet all of the following,Must have successfully completed ENGL101,free form text input value"
