Feature: SA.FE3-2 View Exam Offerings for AO not created when no Activity Offerings are defined
  FE 3.2 As a Central Administrator I want to create CO driven exam offerings dynamically after the bulk exam offering
  creation so that new exam offerings will be created as new Course Offerings are created

  Background:
    Given I am logged in as admin
    And I have ensured that the Fall Term of the Calender is setup with a Final Exam Period

  #FE3.2.EB1 (KSENROLL-9534)
  @pending
  Scenario: Test whether the EO table only shows Eos by AO when Activity Offerings are configured
    When I view the Exam Offerings for a CO created from catalog with a standard final exam driven by Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state
    When I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    Then there should be no Activity Offering table present
    And the Exam Offering table should be in a Canceled state

  #FE3.2.EB2 (KSENROLL-9536)
  @pending
  Scenario: Test whether the Exam Offering is in Draft state when the exam driver is set to Course Offering
    When I view the Exam Offerings for a CO created from an existing CO with a standard final exam driven by Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state

  #FE3.2.EB3 (KSENROLL-9536)
  @pending
  Scenario: Test whether each Exam Offering is in Draft state when the exam driver is set to Activity Offering
    When I view the Exam Offerings for a CO created from an existing CO with a standard final exam driven by Activity Offering
    Then the default cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state
