@wip
Feature: EC.State Propagation

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Test State Propagation
    When I run the State Propagation test
    Then all State Propagation test rows should have status pass

  Scenario Outline: Test that user is unable to manage course offerings when SOC is in certain states
    When I manually change a given soc-state to "<BlockingSocState>"
    Then I verify that I cannot manage course offerings
  Examples:
    | BlockingSocState |
    | Publishing       |
    | In Progress      |


