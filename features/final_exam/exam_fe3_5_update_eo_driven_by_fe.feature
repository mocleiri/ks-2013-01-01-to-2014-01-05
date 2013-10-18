Feature: SA.FE3-5 Update Exam Offerings based on Final Exam Driver
  FE 3-5 As a Central Adminstrator I want existing exam offerings to be deleted if the exam driver changes after the bulk creation but before the SoC is published so that exam offerings are in sync with their drivers
  to "No final Exam" or "Alternative final assessment" after bulk creation and after the SoC is published so that exam offerings match CO exam settings

  Background:
    Given I am logged in as admin

#FE3.5.EB1 (KSENROLL-10214)
  @pending
  Scenario: Update FE driver to Activity Offering and then change to Course Offering and back to Activity Offering again.
    When I view the Exam Offerings for a CO with a standard final exam driven by Activity Offering for a term that is open
    Then the default cluster's Activity Offering table should for all 2 Exam Offering only show that it is in the Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Course Offering
    And the Exam Offerings for Course Offering should be in a Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    And the default cluster's Activity Offering table should for all 2 Exam Offering only show that it is in the Draft state
