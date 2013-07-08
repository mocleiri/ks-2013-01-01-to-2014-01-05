Feature: KRMS.ELIG7-6 Delete statement or compound statement of CO copied from CLU

  Background:
    Given I am logged in as admin

  #ELIG7.6.EB1 (KSENROLL-7243)
  @pending
  Scenario: Test whether statement deleted in compound is removed from the tree
    When I edit the Student Eligibility & Prerequisite section for course "PHYS275" in the historic term
    And I want to edit the selected agenda section
    And I delete node "D" in the tree
    Then there should be no node "D" on both tabs
    When I commit and return to see the changes made to the proposition
    Then the agenda page should not have the text "HIST416,ENGL478"

  #ELIG7.6.EB2 (KSENROLL-7243)
  @pending
  Scenario: Test whether compound deleted is removed from the tree
    When I edit the Student Eligibility & Prerequisite section for course "PHYS275" in the historic term
    And I want to edit the selected agenda section
    And I delete the group containing node "C"
    Then there should be no node "C" on both tabs
    When I commit and return to see the changes made to the proposition
    Then the agenda page should not have the text "free form text input value,Text"

  #ELIG7.6.EB3 (KSENROLL-7244)
  @pending
  Scenario: Test whether clicking delete rule deletes the whole tree
    When I navigate to the Student Eligibility & Prerequisite section for course "PHYS375" in the historic term
    And I delete the tree in the selected agenda section
    And I commit and return to see the changes made to the proposition
    Then the tree in the selected agenda section should be empty
