@nightly
Feature: SA.FE3-6 View Exam Offerings table renedered depending on FE Driver
  FE 3.6 As a Central Administrator I want new exam offerings to be created if the exam driver changes after the
  bulk creation so that exam offerings are in sync with their drivers

  Background:
    Given I am logged in as admin
    And I have ensured that the Fall Term of the Calender is setup with a Final Exam Period

  #FE3.6.EB1 (KSENROLL-9790)
  Scenario: Test whether the View EO table is by Course Offering and that there is only one Exam Offering
    When I view the Exam Offerings for a CO with a standard final exam driven by Course Offering
    Then the Course Offering table should only show that it is in the Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    And the default cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Course Offering
    And the Course Offering table should only show that it is in the Draft state
