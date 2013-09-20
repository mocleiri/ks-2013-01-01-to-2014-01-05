@wip
Feature: EC.Cancel Suspend Reinstate Colocated AOs

  CO 21.1: As an Administrator, I want to cancel one or more Colocated activity offerings so that they are no longer offered for the term

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: CO 21.1B: CSR Verify that a user cannot cancel, suspend or reinstate a co-located AO
    Given I manage a course offering with colocated activity offerings
    Then I am unable cancel or suspend the activity offerings

  Scenario: CO 21.1C1: CSR Verify that a user cannot colocate a suspended activity offering
    Given I manage a course offering with a cancelled activity offering
    Then I am unable to colocate the activity offering

  Scenario: CO 21.1C2: CSR Verify that a user cannot colocate a suspended activity offering
    Given I manage a course offering with a suspended activity offering
    Then I am unable to colocate the activity offering

  Scenario: CO 21.1D: CSR Verify that a user cannot submit a cancelled activity offering to the scheduler
    Given I manage a course offering with a cancelled activity offering
    Then I am unable submit the activity offering to the scheduler

  Scenario: CO 21.1E1: CSR Verify when a course offering in cancelled status is copied, the copy is in draft status
    When I copy a course offering in cancelled status
    Then the course offering copy is in draft status

  Scenario: CO 21.1E2: CSR Verify when an activity offering in cancelled status is copied, the copy is in draft status
    When I copy an activity offering in cancelled status
    Then the activity offering copy is in draft status

  Scenario: CO 21.1F: CSR Verify Course and Activity Offerings in a rollover source term are changed to draft status in the rollover target term
    Given a new academic term has course and activity offerings in cancelled and suspended status
    When I rollover the term to a new academic term
    Then the course and activity offerings in the rollover target term are in draft status
    #And the activity offerings in the rollover target term are in draft status

