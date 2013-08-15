Feature: KRMS.AO Requisites Temporary feature file

  Background:
    Given I am logged in as admin

  Scenario: Test whether the CO rule is copied to the AO
    When I copy the Course Offering rule to the Student Eligibility & Prerequisite section
    Then I should be able to compare the CO Rule to the AO in the Student Eligibility & Prerequisite section

  Scenario: Test whether reverting the copied rule works as expected
    When I revert the copied rule in the Student Eligibility & Prerequisite section
    Then there should be no rule in the Student Eligibility & Prerequisite section

  Scenario: Test whether a new rule specific to the activity offering level is created
    When I add a rule to the Student Eligibility & Prerequisite section
    Then the created rule should exist in the Student Eligibility & Prerequisite section

  Scenario: Test whether a new rule on the activity offering level is created and then deleted
    When I delete a newly added rule in the Student Eligibility & Prerequisite section
    Then the created rule should not exist in the Student Eligibility & Prerequisite section

  Scenario: Test whether the rule copied from the Course Offering rule is deleted
    When I delete the copied rule in the Student Eligibility & Prerequisite section
    Then the created rule should not exist in the Student Eligibility & Prerequisite section

  Scenario: Test whether the Course Offering rule can be copied and the edited
    When I copy and edit the Course Offering rule to the Student Eligibility & Prerequisite section
    Then the edited rule should exist in the Student Eligibility & Prerequisite section

  Scenario: Test whether the rule that was copied and edited from the Course Offering rule is deleted
    When I delete the copied and edited rule in the Student Eligibility & Prerequisite section
    Then the edited rule should not exist in the Student Eligibility & Prerequisite section

  Scenario: Test whether the user can view catalog and course offering rules
    When I view the catalog and course offering rule for the Student Eligibility & Prerequisite section
    Then both rules for the Student Eligibility & Prerequisite section should be the same

  Scenario: Test whether user can compare the catalog, course offering and activity offering rules
    When I compare the rules in the Student Eligibility & Prerequisite section
    Then all three rules for the Student Eligibility & Prerequisite section should be the same

  Scenario: Test whether reverting the copied rule works as expected
    When I revert the copied and edited rule in the Student Eligibility & Prerequisite section
    Then there should be no rule in the Student Eligibility & Prerequisite section