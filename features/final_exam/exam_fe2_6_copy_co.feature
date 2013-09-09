Feature: SA.FE2-6 Create CO with FE and then copy
  FE 2.6: As a Central Administrator I want exam information to be copied when creating a course offering from copy
  so that exam settings are retained session over session until modified

  Background:
    Given I am logged in as admin

  #FE2.6.EB1 (KSENROLL-9246)
  @pending
  Scenario: Test whether the copied CO's FE is the same as that of the original
    When I create a Course Offering from an existing course offering with no final exam period
    Then the exam period for the copied course offering should match that of the original
    And a warning about the FE on the Edit CO page is displayed stating "Course exam data differs from Catalog."