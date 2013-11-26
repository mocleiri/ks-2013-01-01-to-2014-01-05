@concurrency @yellow_team
Feature: EC.Course Offerings Concurrency
  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Verify VersionMismatchError is displayed on concurrent course offering edits
    Given two users are concurrently editing the same course offering
    When the first user updates the suffix and saves the course offering
    And the second user updates the suffix and saves the course offering
    Then the update for the first user is successful
    And the second user gets a VersionMismatchError

