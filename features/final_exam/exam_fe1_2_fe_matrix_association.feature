Feature: SA.FE1-5 Associate Final Exam Matrix with more than one term
  FE 1.2: As a Central Administrator I want to associate a matrix with one or more term types so that a matrix
  specific to a time of year or to an organization is matched to the appropriate term or subterm

  Background:
    Given I am logged in as admin

  #FE1.2.EB1 (KSENROLL-9797)
  @pending
  Scenario: Test that there is more than one option from which to choose the association of the FE Matrix
    When I open the Final Exam Matrix for Summer 1
    Then I should have a choice of terms from which to associate the Final Exam Matrix

  #FE1.2.EB2 (KSENROLL-9797)
  @pending
  Scenario: Test that more than one term can be associated with the same Final Exam Matrix
    When I associate the Summer Term's FE Matrix to that of the Fall Term
    Then the Fall Term's Final Exam Matrix should be used
    And there should be no Standard or Common rules on the page

  #FE1.2.EB3 (KSENROLL-9797)
  @bug @KSENROLL-10311
  Scenario: Test that only one matrix can be assigned to a term
    Given I associate the Summer Term's FE Matrix to that of the Fall Term
    When I associate the Summer Term's FE Matrix to that of the Spring Term
    Then the Fall Term's Final Exam Matrix should not be used