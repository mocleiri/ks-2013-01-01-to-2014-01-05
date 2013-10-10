Feature: FE 3.13: As a Central Admin I want existing exam offerings to be Cancelled if the CO setting changes
  to "No final Exam" or "Alternative final assessment" after bulk creation and after the SoC is published so that exam offerings match CO exam settings

  Background:
    Given I am logged in as admin


#FE3.13 (KSENROLL-9801 Scenario 1)
  @pending
  Scenario: Update Course Offering with Exam Driver to CO and confirm Exam Offering created is in a Cancelled state.
    When I view the Exam Offerings for a CO where the Course Offering Standard FE is changed to No Final Exam
    Then the Canceled Exam Offering table should only show that it is in the Canceled state

#FE3.13 (KSENROLL-9801 Scenario 2)
  Scenario: Update Course Offering with Exam Driver to CO and confirm Exam Offering created in a Draft state
    When I view the Exam Offerings for a CO where the Activity Offering No Final Exam or Assessment is changed to Standard Final Exam
    Then the Course Offering table should only show that it is in the Draft state