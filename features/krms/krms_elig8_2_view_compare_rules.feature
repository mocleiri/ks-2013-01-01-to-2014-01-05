Feature: KRMS.ELIG8-2 View the Catalog and Course Offering rule

  Background:
    Given I am logged in as admin

  @pending
  Scenario: Test whether warning messages are shown when agendas page is loaded
    When I navigate to the agendas page and open the Student Eligibility & Prerequisite section
    Then the CO warning message should be shown in the Student Eligibility & Prerequisite section

  @pending
  Scenario: Test whether the user can view catalog and course offering rules
    When I view the catalog and course offering rule for the Student Eligibility & Prerequisite section
    Then both rules for the Student Eligibility & Prerequisite section should be the same

  @pending
  Scenario: Test whether the AO icon appears after a rule is added to the Activity Offering
    When I commit the rule that replaced the CO rule in the Student Eligibility & Prerequisite section
    Then the AO icon should be shown for the edited Activity Offering

  @pending
  Scenario: Test whether the Activity Offering's unique rule can be compared to the CO rule
    When I compare the replaced rule with the CO and CLU rules in the Student Eligibility & Prerequisite section
    Then the AO rule should differ from the CO and CLU rules in the Student Eligibility & Prerequisite section

  @pending
  Scenario: Test whether the Activity Offering's unique rule can be reverted to the CO rule
    When I revert the rule that replaced the CO rule in the Student Eligibility & Prerequisite section
    Then there should be no rule in the Student Eligibility & Prerequisite section

  @pending
  Scenario: Test whether the AO icon disappears after a rule is reverted back to the Course Offering rule
    When I commit after reverting the rule that replaced the CO rule in the Student Eligibility & Prerequisite section
    Then the AO icon should not be shown for the edited Activity Offering