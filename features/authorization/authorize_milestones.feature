@nightly
Feature: Authorize Milestones Feature

  Background:
    Given I am logged in as a Department Schedule Coordinator

  Scenario:Department Schedule Coordinator Carol does not have access to delete AO's After the first day of class
    Given I am working on a term in "Published" SOC state
    And It is "After" the first day of classes
    And there is a "Draft" course in my department
    Then I do not have access to delete an activity offering in a "Draft" state
    Then I do not have access to delete a course offering in a "Draft" state

  Scenario: Department Schedule Coordinator Carol has access to delete AO's Before the first day of class
    Given I am working on a term in "Published" SOC state
    And It is "Before" the first day of classes
    And there is a "Draft" course in my department
    Then I have access to delete an activity offering in a "Draft" state
    And I have access to delete a course offering in a "Draft" state