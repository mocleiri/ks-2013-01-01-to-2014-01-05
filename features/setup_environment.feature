@data_setup
Feature: Setup Environment

  Setup required data for test run

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Successfully rollover courses to put target term in open state
    When I initiate a rollover to create a term in open state
    Then the results of the rollover are available
    And the rollover can be released to departments
