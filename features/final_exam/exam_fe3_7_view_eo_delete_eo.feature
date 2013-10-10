@nightly
Feature: SA.FE3-7 View Exam Offerings only when the Exam Period is set to Standard
  FE 3.7 As a Central Admin I want existing exam offerings to be deleted if the CO setting changes to "No final Exam"
  or "Alternative final assessment" after bulk creation but before the SoC is published so that exam offerings match
  CO exam settings

  Background:
    Given I am logged in as admin
    And I have ensured that the Spring Term of the Calender is setup with a Final Exam Period

  #FE3.7.EB1 (KSENROLL-9791)
  Scenario: Test whether the View EO table is by Course Offering and that there is only one Exam Offering
    When I view the Exam Offerings for an open CO with a standard final exam driven by Activity Offering
    Then the first cluster's Activity Offering table should for all 6 Exam Offerings only show that it is in the Draft state
    And I view the Exam Offerings after updating the Final Exam to none
    And there should be no Standard Exam tables present
