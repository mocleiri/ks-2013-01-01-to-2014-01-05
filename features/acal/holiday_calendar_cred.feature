@nightly
Feature: EC.Holiday Calendar CRED

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Create and save Holiday Calendar from blank
    When I create a Holiday Calendar
    Then The Make Official button of this Holiday Calendar should become active

  Scenario: Search for newly created Holiday Calendar
    Given I create a Holiday Calendar
    When I search for the Holiday Calendar
    And the holiday calendar should appear in search results

  Scenario: Make Holiday Calendar Official
    Given I create a Holiday Calendar
    When I make the Holiday Calendar official
    And I search for the Holiday Calendar
    And the holiday calendar should appear in search results

  @draft
  Scenario: Copy a Holiday Calendar from search
    Given I create a Holiday Calendar
    When I create a holiday calendar by copying an existing calendar form search
    Then I search for the copied Holiday Calendar
    And all holidays were copied successfully
