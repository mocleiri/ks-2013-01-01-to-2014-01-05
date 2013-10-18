@nightly
Feature: SA.FE7-4 Validation Message should show if Number of Exam Days is less than Matrix Days
  FE 7.4: As a Central Administrator I want the dates of a new exam period to be validated against the examination
  matrix when I create the exam period so that I do not create an exam period with fewer days than the matrix

  Background:
    Given I am logged in as admin
    And I copy an existing academic calender that has a defined final exam period

  #FE7.4.EB1 (KSENROLL-9794)
  Scenario: Test that a warning message is shown when the FE Period is less than the FE Matrix days
    When I edit the Fall Term Exam Period to have less days than the Final Exam Matrix days
    Then a warning in the Final Exam section is displayed stating "days in the exam period are less than the number of exam days"

  #FE7.4.EB2 (KSENROLL-9794)
  Scenario: Test that no warning message is shown when the FE Period is less than the FE Matrix days but non-active days are included
    When I edit the Fall Term Exam Period to have less days than the Final Exam Matrix days and include non-active days
    Then no warning in the Final Exam section is displayed