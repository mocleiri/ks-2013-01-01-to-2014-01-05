Feature: KRMS.ELIG8-1 Add or Replace rules to Activity Offering whether CO exists or not

  Background:
    Given I am logged in as admin

  Scenario: Test whether CO rule is replaced by a new AO rule
    When I replace the CO rule in the Student Eligibility & Prerequisite section
    Then the AO warning message should be shown in the Student Eligibility & Prerequisite section
    And the AO rule should differ from the CO and CLU rules in the Student Eligibility & Prerequisite section

  Scenario: Test whether a new AO rule is created even if CO rule does not exist
    When I add a rule to the Student Eligibility & Prerequisite section
    Then the created rule should be shown in the Student Eligibility & Prerequisite section
