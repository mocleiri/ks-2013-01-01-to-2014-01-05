Feature: SA.FE7-3 Manage Final Exam Matrix
  FE 7.3: As a Central Administrator I want days within the exam period labelled so that they are identifiable for
  scheduling and publication purposes

  Background:
    Given I am logged in as admin

  #FE7.3.EB1 (KSENROLL-9793)
  Scenario: Test when a rule is edited in the FE Matrix that the rule can be assigned more than one day
    When I edit a Thursday morning Standard Final Exam rule on the matrix