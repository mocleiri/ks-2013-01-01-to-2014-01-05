Feature: SA.FE3-6 View Exam Offerings table renedered depending on FE Driver
  FE 3.10: As a Central Administrator I want to create AO driven exam offerings dynamically after the bulk creation
  so that new exam offerings will be created as new Activity Offerings are created

  Background:
    Given I am logged in as admin
    And I have ensured that the Fall Term of the Calender is setup with a Final Exam Period

  #FE3.6.EB1 (KSENROLL-9790)
  @pending
  Scenario: Test whether the View EO table is by Course Offering and that there is only one Exam Offering
    When I view the Exam Offerings for a CO with a standard final exam driven by Course Offering
    Then the Course Offering table should only show that it is in the Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    And the Activity Offering table should for all 5 Exam Offerings only show that it is in the Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Course Offering
    And the Course Offering table should only show that it is in the Draft state
