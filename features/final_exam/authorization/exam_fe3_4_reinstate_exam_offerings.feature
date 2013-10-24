#@nightly
Feature: SA.FE3-4 Reinstate Activity Offering will reinstate the Exam Offerings as well
  FE 3.4 As a Central Adminstrator I want to reinstate exam offerings if I reinstate the governing course offering
  or activity offering bulk creation so that exam offerings are available

  Background:
    Given I am logged in as admin

  #FE3.4.EB1 (KSENROLL-10322)
  @pending
  Scenario: Test that reinstating an AO does reinstate the EOs when the FE Driver is set to CO
    Given I suspend an Activity Offering for a CO with a standard final exam driven by Course Offering
    When I reinstate the activity offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state

  #FE3.4.EB2 (KSENROLL-10322)
  @pending
  Scenario: Test that suspending an AO does suspend the EO for that AO when the FE Driver is set to AO
    Given I suspend an Activity Offering for a CO with a standard final exam driven by Activity Offering
    When I reinstate the activity offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offering for Activity Offering should be in a Draft state

  #FE3.4.EB3 (KSENROLL-10322)
  @pending
  Scenario: Test that cancelling an AO does not effect the EOs when the FE Driver is set to CO
    Given I cancel an Activity Offering for a CO with a standard final exam driven by Course Offering
    When I reinstate the activity offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state

  #FE3.4.EB4 (KSENROLL-10322)
  @pending
  Scenario: Test that cancelling a lecture AO does not create an EO for that AO
    Given I cancel an Activity Offering for a CO with a standard final exam driven by Activity Offering
    When I reinstate the activity offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offering for Activity Offering should be in a Draft state
