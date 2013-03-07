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

  Scenario:  As a Schedule Coordinator I have access to Activity Offerings for a term in Draft SOC state
    Given I am in working on a term in "Draft" SOC state
    When I manage a course offering
    Then I can view the activity offering details
    And the next, previous and list all course offering links are enabled
    And I can add a new activity offering
    And I can delete an activity offering
    And I can edit an activity offering
    And I can copy activity offering

  Scenario:  As a Schedule Coordinator I have access to Course Offerings for a term in Draft SOC state
    Given I am in working on a term in "Draft" SOC state
    When I manage course offerings for a subject code
    Then I can view course offering details
    And I can add new course offerings
    And I can approve course offerings for scheduling
    And I can delete course offerings
    And I can edit course offerings
    And I can copy course offerings

  Scenario: Schedule Coordinator has access to edit course offering grading option for a term with SOC State Open
    Given I am in working on a term in "Open" SOC state
    When I edit a course offering in my department
    Then I can edit the grading options

  Scenario: Schedule Coordinator has access to edit course offering grading option for a term with SOC State Final Edits
    Given I am in working on a term in "Final Edits" SOC state
    When I edit a course offering in my department
    Then I can edit the grading options

  Scenario:Schedule Coordinator has access to edit course offering grading option for a term with SOC State Published
    Given I am in working on a term in "Published" SOC state
    When I edit a course offering in my department
    Then I can edit the grading options