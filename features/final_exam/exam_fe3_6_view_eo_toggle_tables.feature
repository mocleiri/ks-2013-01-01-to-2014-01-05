@nightly
Feature: SA.FE3-6 View Exam Offerings table renedered depending on FE Driver
  FE 3.6 As a Central Administrator I want new exam offerings to be created if the exam driver changes after the
  bulk creation so that exam offerings are in sync with their drivers

  Background:
    Given I am logged in as admin

  #FE3.6.EB1 (KSENROLL-9790)
  Scenario: Test whether the View EO table is by Course Offering and that there is only one Exam Offering
    When I view the Exam Offerings for a CO with a standard final exam driven by Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state
    When I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    Then the Exam Offering for Activity Offering should be in a Draft state
    When I view the Exam Offerings after changing the Final Exam Driver to Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state


  #FE3.6 EB2 (KSENROLL-9876)
  @pending
  Scenario: Test whether the View EO table is by Course Offering when a delivery format "Lecture" is selected
    When I create a Course Offering with standard final exam driven by Course Offering and "Lecture" as delivery format
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state