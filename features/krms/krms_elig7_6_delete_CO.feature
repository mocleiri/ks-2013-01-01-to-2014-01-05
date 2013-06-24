Feature: KRMS ELIG7.2 Delete statement or compound statement of CO copied from CLU

  Background:
    Given I am logged in as admin

  #ELIG7.6.EB1 (KSENROLL-7243)
  @pending
  Scenario: Test whether statement deleted in compound is removed from the tree
    When I edit the data for "Student Eligibility & Prerequisite" for term "201208" and course "PHYS275"
    And I want to edit the selected agenda section
    And I delete node "G" in the tree
    Then there should be no node "G" on both tabs
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should not have the text "Must have successfully completed a minimum of 1 course from,HIST210,HIST395"

  #ELIG7.6.EB2 (KSENROLL-7243)
  @pending
  Scenario: Test whether compound deleted is removed from the tree
    When I edit the data for "Student Eligibility & Prerequisite" for term "201208" and course "PHYS275"
    And I want to edit the selected agenda section
    And I delete node "G" in the tree
    Then there should be no node "G" on both tabs
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should not have the text "Must meet all of the following,Must have successfully completed ENGL101,free form text input value"

  #ELIG7.6.EB3 (KSENROLL-7244)
  @pending
  Scenario: Test whether clicking delete rule deletes the whole tree
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201208" and course "PHYS275"
    And I delete the tree in the selected agenda section
    And I commit and return to see the changes made to the proposition
    Then the tree in the selected agenda section should be empty
