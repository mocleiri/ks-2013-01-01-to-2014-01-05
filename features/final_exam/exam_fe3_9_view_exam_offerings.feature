Feature: SA.FE3-9 View Exam Offerings
  FE 3.9: As a Central Administrator I want to view exam offerings so that I know their state and properties

  Background:
    Given I am logged in as admin
    And I have ensured that the Fall Term of the Calender is setup with a Final Exam Period

  #FE3.9.EB1 (KSENROLL-9788)
  @pending
  Scenario: Test that the CO table is shown when viewing the exam offerings and that it's state is draft
    When I view the Exam Offerings for a CO created from an existing CO with a standard final exam driven by Course Offering
    Then there should be a Course Offering table that is in the Draft state

  #FE3.9.EB2 (KSENROLL-9788)
  @pending
  Scenario: Test that the AO table is shown when viewing the exam offerings and that it's state is draft
    When I view the Exam Offerings for a CO created from an existing CO with a standard final exam driven by Activity Offering
    Then the default cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state

  #FE3.9.EB3 (KSENROLL-9788)
  @pending
  Scenario: Test that the AO table is shown with all AOs when viewing the exam offerings and that it's state is draft
    When I view the Exam Offerings for a CO created from an existing CO with multiple AOs and a standard final exam driven by Activity Offering
    Then the default cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state
    And the leftover cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state
