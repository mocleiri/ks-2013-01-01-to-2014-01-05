@wip
Feature: EC.Cancel Suspend Reinstate Colocated AOs

  CO 21.1: As an Administrator, I want to cancel one or more Colocated activity offerings so that they are no longer offered for the term

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: CO 21.1B: CSR Verify that a user cannot cancel, suspend or reinstate a co-located AO
    Given I manage a course offering with an activity offering in cancelled status
    Then I am unable cancel or suspend the activity offering

  Scenario: CO 21.1C1: CSR Verify that a user cannot colocate a suspended activity offering
    Given I manage a course offering with an activity offering in cancelled status
    Then I am unable to colocate the activity offering

  Scenario: CO 21.1C2: CSR Verify that a user cannot colocate a suspended activity offering
    Given I manage a course offering with an activity offering in suspended status
    Then I am unable to colocate the activity offering

  Scenario: CO 21.1D: CSR Verify that a user cannot submit a cancelled activity offering to the scheduler
    Given I manage a course offering with an activity offering in cancelled status
    Then I am unable submit the activity offering to the scheduler

  Scenario: CO 21.1E1: CSR Verify when a course offering in cancelled status is copied, the copy is in draft status
    Given I manage a course offering in cancelled status
    When I copy the course offering
    Then the course offering copy is in draft status


  Scenario: CO 21.1E2: CSR Verify when an activity offering in cancelled status is copied, the copy is in draft status
    Given I manage a course offering with an activity offering in cancelled status
    When I copy the activity offering
    Then the activity offering copy is in draft status

  @pending
  Scenario: CO 21.1F: CSR Verify Course and Activity Offerings in a rollover source term are changed to draft status in the rollover target term
    Given a new academic term has course and activity offerings in cancelled and suspended status
    When I rollover the term to a new academic term
    Then the course and activity offerings in the rollover target term are in draft status

  @draft @not_delivered
  Scenario: CO 21.1G: CSR Verify a cancelled Activity Offerings can be excluded in Course Offering create from existing
    Given I manage a course offering with an activity offering in cancelled status
    When the course offering is copied to a subsequent term excluding cancelled activity offerings
    Then the cancelled activity offering is not copied

  Scenario: CO 22.1A CSR Check Suspend option availability in draft open and locked SOC states
    Given I am working on a term in "Draft" SOC state
    Then an activity offering in draft status cannot be suspended
    Given I am working on a term in "Open" SOC state
    Then an activity offering in draft status cannot be suspended
    Given I am working on a term in "Locked" SOC state
    Then an activity offering in draft status can be suspended

  Scenario: CO 22.1B CSR Suspend a draft Activity Offering in a published SOC state
    Given I am working on a term in "Published" SOC state
    When I manage a course offering with a draft activity offering
    Then I can suspend the activity offering

  Scenario: CO 22.1.C CSR Suspend approved Activity Offering with ADLs
    Given I am working on a term in "Final Edits" SOC state
    When I manage a course offering with an approved activity offering
    Then I can suspend the activity offering
    And actual delivery logistics for the Approved activity offering are still shown

  Scenario: CO 22.1.D CSR Suspend a canceled Activity Offering in a published SOC state
    Given I am working on a term in "Published" SOC state
    When I manage a course offering with a canceled activity offering
    Then I am not able to suspend the activity offering


