Feature: SA.FE2-2 Create Exam from AO or CO
  FE 2.2: As a Central Administrator I want to indicate for a course offering what entities determine the creation
  of an exam offering so that the exam offering can be created according to the intended scenario or pattern

  Background:
    Given I am logged in as admin

  #FE2.2.EB1 (KSENROLL-9243)
  @pending
  Scenario: Test whether the Final Exam Driver dropdown is only available for Standard FE
    When I create a Course Offering from catalog with a final exam period
    Then the Final Exam Driver dropdown should only be present for the Standard Final Exam

  #FE2.2.EB2 (KSENROLL-9243)
  @pending
  Scenario: Test whether the FE Driver column's value changes when changing the Driver
    When I create a Course Offering from catalog with a final exam period
    Then the Final Exam Driver column should be populated with text corresponding to the chosen driver

  #FE2.3.EB2 (KSENROLL-9243)
  @pending
  Scenario: Test whether the new CO's FE can be edited on the Manage CO page
    When I create and then edit a Course Offering from catalog with an alternate final exam period
    Then I should be able to edit and update the Final Exam status