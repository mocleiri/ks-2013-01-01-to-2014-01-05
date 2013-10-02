@nightly
Feature: SA.FE2-5 Perform Simple Rollover
  FE 2.5: As a Central Administrator I want exam information to be copied in a rollover so that exam settings
  are retained session over session until modified

  Background:
    Given I am logged in as admin

  #FE2.5.EB1 (KSENROLL-9532)
  Scenario: Test whether setting up exam offerings for COs and then performing a rollover retains the exam information
    Given I create an Academic Calender and add an official term
    When I create multiple Course Offerings each with a different Exam Offering in the new term
    And I rollover the term to a new academic term
    Then all the exam settings and messages are retained after the rollover is completed