@nightly
Feature: EC.Academic Calendar Terms
  CO 2.17

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Successfully create a new term for a new academic calendar
    Given I create an Academic Calendar
    When I add a new term to the Academic Calendar
    Then the term is listed when I view the Academic Calendar

  Scenario: Successfully create a new term for an academic calendar copy
    Given I copy an existing Academic Calendar
    When I add a new term to the Academic Calendar
    Then the term is listed when I view the Academic Calendar

  Scenario: Successfully edit term information for an academic calendar
    Given I copy an existing Academic Calendar
    And I add a new term to the Academic Calendar
    When I edit the information for a term
    Then the updated term information is listed when I view the Academic Calendar

  Scenario: Successfully delete a term from a new academic calendar
    Given I create an Academic Calendar
    And I add a new term to the Academic Calendar
    When I delete the term
    Then the term is not listed when I view the Academic Calendar

  @bug @KSENROLL-8017
  Scenario: Make an academic term official
    Given I create an Academic Calendar in Official status
    And I add a new term to the Academic Calendar
    When I make the term official
    Then the term is listed in official status when I view the Academic Calendar

  Scenario: Add a Key Date to an academic term
    Given I create an Academic Calendar
    And I add a new term to the Academic Calendar
    When I add an instructional Key Date
    Then the Key Date is listed with the academic term information

  Scenario: Modify a Key Date for an academic term
    Given I create an Academic Calendar
    And I add a new term to the Academic Calendar with an instructional key date
    When I edit an instructional Key Date
    Then the updated Key Date is listed with the academic term information

  Scenario: Delete a Key Date for an academic term
    Given I copy an existing Academic Calendar
    When I delete an instructional Key Date
    Then the Key Date is not listed with the academic term information

  Scenario: Delete a Key Date Group for an academic term
    Given I copy an existing Academic Calendar
    When I delete an instructional Key Date Group
    Then the Key Date Group is not listed with the academic term information

  Scenario: Copy a Key Dates for an academic term
    Given I copy an existing Academic Calendar
    Then the Key Dates are copied without date values

  @bug @KSENROLL-8022
  Scenario: Verify instructional days calculation for an academic term
    Given I create an Academic Calendar
    And I add a new term to the Academic Calendar with a defined instructional period
    Then the instructional days calculation is correct
    When I add a Holiday Calendar with holidays in the term
    Then the instructional days calculation is correct