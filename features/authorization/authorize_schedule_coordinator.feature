@nightly
Feature: Schedule Coordinator Authorization

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario:As a Schedule Coordinator I have access to delete Activity Offerings in a Final Edits state
    Given I am in working on a term in "Final Edits" SOC state
    Then I have access delete an activity offering in a "Draft" state
    And  I have access delete an activity offering in a "Approved" state

  Scenario: As a Schedule Coordinator I have access to delete Activity Offerings in a Published state
    Given I am in working on a term in "Published" SOC state
    And there is a draft course in my department
    Then I have access delete an activity offering in a "Draft" state

  Scenario:  As a Schedule Coordinator I have access to delete Activity Offerings in a Open state
    Given I am in working on a term in "Open" SOC state
    Then I have access delete an activity offering in a "Draft" state
    And  I have access delete an activity offering in a "Approved" state

  Scenario:  As a Schedule Coordinator I have access to delete Course Offerings in a Open state
    Given I am in working on a term in "Open" SOC state
    And I copy and approve a course offering
    Then I have access to delete a course offering in a "Draft" state
    And I have access to delete a course offering in a "Planned" state