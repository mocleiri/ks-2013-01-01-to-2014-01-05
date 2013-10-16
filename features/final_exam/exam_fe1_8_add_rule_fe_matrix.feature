Feature: SA.FE1-8 Add new rule to the Final Exam Matrix
  FE 1.8 As a Central Administrator I want to specify an exam location for one or more exam offerings for course
  offering driven exam time slots so that predetermined common exam locations are preslotted in the exam offering
  requested delivery logistics

  Background:
    Given I am logged in as admin

  #FE1.8.EB1 (KSENROLL-9799)
  @pending
  Scenario: Test whether a new Common Final Exam rule can be added to the FE Matrix
    When I add a Common Final Exam course rule to the Final Exam Matrix of the Fall Term
    Then I should be able to see the newly created course rule in the Common Final Exam table

  #FE1.8.EB2 (KSENROLL-9799)
  @pending
  Scenario: Test whether a new Common Final Exam rule can be added to the FE Matrix and then persisited to the DB
    When I add a Common Final Exam course rule to the Final Exam Matrix of the Fall Term
    And I submit and return to see my changes
    Then I should be able to see the newly created course rule in the Common Final Exam table
