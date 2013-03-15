@nightly
Feature: Authorize Milestones Feature

  Background:
    Given I am logged in as a Department Schedule Coordinator

  Scenario:Department Schedule Coordinator Carol does not have access to delete AO's After the first day of class
    Given I am working on a term in "Published" SOC state
    And It is "After" the first day of classes
    And there is a "Draft" course in my admin org
    Then I do not have access to delete an activity offering in a "Draft" state
    And I do not have access to delete a course offering in a "Draft" state
    And there is a "Offered" course in my admin org
    And I do not have access to delete a course offering in a "Offered" state
    And I do not have access to delete an activity offering in a "Offered" state

  Scenario: Department Schedule Coordinator Carol has access to delete AO's Before the first day of class
    Given I am working on a term in "Published" SOC state
    And It is "Before" the first day of classes
    And there is a "Draft" course in my admin org
    Then I have access to delete an activity offering in a "Draft" state
    And I have access to delete a course offering in a "Draft" state
    And there is a "Offered" course in my admin org
    And I do not have access to delete a course offering in a "Offered" state
    And I do not have access to delete an activity offering in a "Offered" state

  Scenario: Department Schedule Coordinator Carol Access Verification for Manage course offering List
    Given I am working on a term in "Published" SOC state
    And It is "After" the first day of classes
    Then I manage course offerings for a subject code in my admin org
    And I have access to manage course offerings
    And I do not have access to copy the listed course offering
    And I do not have access to edit the listed course offering
    Given It is "Before" the first day of classes
    Then I manage course offerings for a subject code in my admin org
    And I have access to manage course offerings
    And I do not have access to copy the listed course offering
    And I do not have access to edit the listed course offering

  Scenario: Department Schedule Coordinator Carol Access Verification for Create course offerings
    Given I am working on a term in "Published" SOC state
    And It is "After" the first day of classes
    Then I attempt to create a course not in my admin org
    And I do not have access to create the course offering
    Given It is "Before" the first day of classes
    Then I attempt to create a course not in my admin org
    And I do not have access to create the course offering

  Scenario: Department Schedule Coordinator Carol Access Verification for Manage Course Offerings
    Given I am working on a term in "Published" SOC state
    And It is "After" the first day of classes
    Then I manage a course offering in my admin org
    And I have access to view the activity offering details
    And I do not have access to copy an activity offering
    And I have access to edit an activity offering
    Given It is "Before" the first day of classes
    Then I manage a course offering in my admin org
    And I have access to view the activity offering details
    And I do not have access to copy an activity offering
    And I have access to edit an activity offering

  Scenario: Department Schedule Coordinator Carol Access Verification for Rollover
    Given I am working on a term in "Published" SOC state
    And It is "After" the first day of classes
    Then I attempt to perform a rollover
    Then I do not have access to the page
    Given It is "Before" the first day of classes
    Then I attempt to perform a rollover
    Then I do not have access to the page

  @draft
  Scenario: Department Schedule Coordinator Carol Access Verification for Edit Activity Offerings
    Given I am working on a term in "Published" SOC state
    And It is "After" the first day of classes
    Then I edit an activity offering in my department