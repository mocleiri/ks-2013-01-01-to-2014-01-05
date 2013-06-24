@nightly
Feature: EC.Calendar Authorization

  Background:
    Given I am logged in as a Department Schedule Coordinator

  Scenario: Edit and Copy Academic Calendar
    When I search for academic calendars
    Then I should not be able to edit a calendar
    And I should not be able to copy a calendar

  Scenario: Edit and Copy Holiday Calendar
    When I search for holiday calendars
    Then I should not be able to edit a calendar
    And I should not be able to copy a calendar

  Scenario: Edit Academic Term
    When I search for academic terms
    Then I should not be able to edit a term

