Feature: SA.FE3-5 Update Exam Offerings based on Final Exam Driver
  FE 3-5 As a Central Adminstrator I want existing exam offerings to be deleted if the exam driver changes after the bulk creation but before the SoC is published so that exam offerings are in sync with their drivers
  to "No final Exam" or "Alternative final assessment" after bulk creation and after the SoC is published so that exam offerings match CO exam settings

Background:
  Given I am logged in as admin
  #How to ensure that the term is still open and not published?

  #FE3.5.EB1 (KSENROLL-10214)
  @pending
  Scenario:
    When I view the Exam Offerings for a CO with a standard final exam driven by Activity Offering
    Then the default cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Course Offering
    And the Course Offering table should only show that it is in the Draft state
    And I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    And the default cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state
