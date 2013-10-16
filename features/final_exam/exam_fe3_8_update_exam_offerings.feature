Feature: FE 3.8 Update Exam Offerings
  FE 3.8 As a Central Administrator I want exam offerings to be created if the course offering setting changes to
  "Final Exam" after the bulk creation so that exam offerings are appropriate to exam settings on the course offering

  Background:
    Given I am logged in as admin

  #FE3.8.EB1 (KSENROLL-9543)
  @pending
  Scenario: Update Course Offering to No final exam or assessment and back again to Standard FE with FE Driver as Course Offering
    When I view the Exam Offerings for a CO where the Course Offering Standard FE is changed to No Final Exam
    Then the Exam Offering table should be in a Canceled state
    When I view the Exam Offerings after changing the Final Exam Driver to Course Offering
    Then the Course Offering table should only show that it is in the Draft state

  #FE3.8.EB2 (KSENROLL-9543)
  @pending
  Scenario: Update Course Offering to Alternate final exam or assessment and back again to Standard FE with FE Driver as Activity Offering
    When I view the Exam Offerings for a CO where the Activity Offering Standard FE is changed to Alternate Final Exam
    Then there should be an Activity Offering table header explaining that the Exam Offerings have been canceled
    When I view the Exam Offerings after changing the Final Exam Driver to Activity Offering
    Then the default cluster's Activity Offering table should for all 1 Exam Offerings only show that it is in the Draft state