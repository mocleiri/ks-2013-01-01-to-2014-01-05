@nightly
Feature: SA.FE7-1 Academic Time Period
  FE 7.1: As a Central Administrator I want a final exam Academic Time Period associated with a term so that final
  examinations for the term can be scheduled and offered

  Background:
    Given I am logged in as admin

  #FE7.1.EB1 (KSENROLL-8829)
  Scenario: Test whether an error message is given when the exam start date is changed to before term start date
    When I change the final exam start date to be before the term start date and save
    Then a warning in the Final Exam section is displayed stating "Final Exam Period doesn't fall within the dates of Fall 2012."

  #FE7.1.EB2 (KSENROLL-8829)
  Scenario: Test whether an error message is given when the exam end date is changed to after term end date
    When I change the final exam end date to be after the term end date and save
    Then a warning in the Final Exam section is displayed stating "Final Exam Period doesn't fall within the dates of Fall 2012."

  #FE7.1.EB3 (KSENROLL-8829)
  Scenario: Test whether a final exam period can be added to a newly created academic calender
    When I add a final exam period within the dates of the fall term of the new academic calender and save
    Then the final exam for the Fall Term is listed when I view the Academic Calendar

  #FE7.1.EB4 (KSENROLL-8830)
  Scenario: Test whether the copied calender's exam period is blank
    When I copy a newly created academic calender that has a defined final exam period
    Then there should be no final exam period

  #FE7.1.EB5 (KSENROLL-8830)
  Scenario: Test whether the exam period is blank when copying from an existing calender
    When I copy an existing academic calender that has a defined final exam period
    Then there should be no final exam period