Feature: SA.FE1-5 Associate Final Exam Matrix with more than one term
  FE 1.2: As a Central Administrator I want to associate a matrix with one or more term types so that a matrix
  specific to a time of year or to an organization is matched to the appropriate term or subterm

  Background:
    Given I am logged in as admin

  #FE1.2.EB1 (KSENROLL-9797)
  @pending
  Scenario: Test that there is more than one option from which to choose the association of the FE Matrix
    Given there is an Academic Half Term that is not associated with any final exam matrix
    When I view the half term
    Then I should have a choice of terms from which to associate the Final Exam Matrix

  #FE1.2.EB2 (KSENROLL-9797)
  @pending
  Scenario: Test that more than one term can be associated with the same Final Exam Matrix
    Given there is an Academic Term associated with a Final Exam matrix
    And there is a second Academic Term that is not associated with any final exam matrix
    When I associate the second Term with the Final Exam matrix of the initial Term
    And I view the second term
#    Then there is a message indicating that the final exam matrix for the initial term is used
    And no Standard Final Exam or Common Final Exam rules are listed

    Then the Fall Term's Final Exam Matrix should be used

  #FE1.2.EB3 (KSENROLL-9797)
  @pending
  Scenario: Test that only one matrix can be assigned to a term
    Given there is an Academic Term associated with a Final Exam matrix
    And there is a second Academic Term that is not associated with any final exam matrix
    And there is a third Academic Term associated with a Final Exam matrix
    And I associate the second Term with the Final Exam matrix of the initial Term
    When I associate the second Term with the Final Exam matrix of the third Term
    And I view the second term
#    Then the Fall Term's Final Exam Matrix should not be used
    And no Standard Final Exam or Common Final Exam rules are listed