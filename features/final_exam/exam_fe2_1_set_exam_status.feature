@nightly
Feature: SA.FE2-1 Set Exam Status
  FE 2.1: As a Central Administrator I want to override the exam settings on a course offering inherited from the
  canonical version so that a final examination can be set to be offered or not in a particular course offering

  Background:
    Given I am logged in as admin

  #FE2.1.EB1 (KSENROLL-9242)
  Scenario: Test whether the Final Exam Driver Activity column changes depending on the chosen exam status
    When I create a Course Offering from catalog with a final exam period
    Then the Final Exam Driver Activity value should change each time I choose another type of Final Exam

  #FE2.1.EB2 (KSENROLL-9242)
  Scenario: Test whether a warning is displayed on the edit CO page that exam status differs from catalog
    When I create and then edit a Course Offering from catalog with an alternate final exam period
    Then a warning about the FE on the Edit CO page is displayed stating "Course exam data differs from Catalog."