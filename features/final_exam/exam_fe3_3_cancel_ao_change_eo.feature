Feature: SA.FE3-3 Cancelling an AO should cancel the EO depending on all the exam settings
  FE 3.3 As a Central Administrator I want exam offerings to be Cancelled if the governing course offering or activity
  offering is cancelled after the bulk creation so that unnecessary exam offerings are removed

  Background:
    Given I am logged in as admin
    And I have ensured that the Fall Term of the Calender is setup with a Final Exam Period

  #FE3.3.EB1 (KSENROLL-10220)
  @bug @KSENROLL-10217
  Scenario: Test that cancelling an AO does not effect the EOs when the FE Driver is set to CO
    When I cancel an Activity Offering for a CO with a standard final exam driven by Course Offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offerings for Course Offering should be in a Draft state

  #FE3.3.EB2 (KSENROLL-10220)
  @pending
  Scenario: Test that cancelling a lecture AO does not create an EO for that AO
    When I cancel an Activity Offering for a CO with a standard final exam driven by Activity Offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offering table for the canceled AO should also be in the same state

  #FE3.3.EB3 (KSENROLL-10220)
  @pending
  Scenario: Test that cancelling a discussion AO does create an EO for AO table
    When I cancel a discussion Activity Offering for a CO with a standard final exam driven by Activity Offering
    And I view the Exam Offerings for the Course Offering
    Then the default cluster's Activity Offering table should for all 1 Exam Offering only show that it is in the Draft state

  #FE3.3.EB4 (KSENROLL-10220)
  @pending
  Scenario: Test that cancelling all AOs does cancel the EO when the FE Driver is set to CO
    When I cancel all Activity Offerings for a CO with a standard final exam driven by Course Offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offering table should be in a Canceled state

  #FE3.3.EB5 (KSENROLL-10220)
  @pending
  Scenario: Test that cancelling all AOs does cancel the EO when the FE Driver is set to AO
    When I cancel all Activity Offerings for a CO with a standard final exam driven by Activity Offering
    And I view the Exam Offerings for the Course Offering
    Then the Exam Offering table should be in a Canceled state
