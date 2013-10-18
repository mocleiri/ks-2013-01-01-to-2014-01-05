Feature: SA.FE3-12 View Exam Offerings table rendered depending on FE Driver
  FE 3-12 As a Central Administrator I want existing exam offerings to be Unscheduled and the records displayed
  if the exam driver changes changes to Course Offering or Activity Offering

  Background:
    Given I am logged in as admin
    And I have ensured that the Fall Term of the Calender is setup with a Final Exam Period

  #FE3.12.EB1(KSENROLL-10198)
  @pending
  Scenario: Test whether the View EO table is by Course Offering and that there is only one Exam Offering
    When I view the Exam Offerings for a CO with a standard final exam driven by Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    Then the 1 Exam Offering for Activity Offering should be in a Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state