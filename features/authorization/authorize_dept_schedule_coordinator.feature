@nightly
Feature: Department Schedule Coordinator Authorization

  Background:
    Given I am logged in as a Department Schedule Coordinator

  Scenario: Department Schedule Coordinator has read only access to seat pools
    Given I am in working on a term in "Final Edits" SOC state
    When I attempt to edit an activity offering for a course offering in my department
    Then I have access to revise delivery logistics
    And I do not have access to add or edit seat pools

  Scenario: Department Schedule Coordinator does not have edit access to courses not in their department
    Given I am in working on a term in "Open" SOC state
    When I attempt to edit a course not in my department
    Then an authorization error is displayed when I attempt to edit the course offering

  #to do inconsistent with other test
  Scenario: AZ4.2 Department Schedule Coordinator has read access to course offerings not in their department
    Given I am in working on a term in "Open" SOC state
    When I manage course offerings for a subject code not in my department
    Then I can view course offering details
    And  I can manage the course offering

  Scenario: Department Schedule Coordinator Carol can access the Manage CO set of pages for COs for her own admin org
    Given I am in working on a term in "Open" SOC state
    When I manage course offerings for a subject code in my department
    Then I can view course offering details
    And I can add new course offerings
    And I can approve course offerings for scheduling
    And I can delete course offerings
    And I can edit course offerings
    And I can copy course offerings

  Scenario: Department Schedule Coordinator Carol can access the Manage AO set of pages for COs for her own admin org
    Given I am in working on a term in "Open" SOC state
    When I manage a course offering in my department
    Then I can view the activity offering details
    And the next, previous and list all course offering links are enabled
    And I can add a new activity offering
    And I can delete an activity offering
    And I can edit an activity offering
    And I can copy activity offering

  Scenario: Department Schedule Coordinator Carol does not have access to create CO's not in her admin org
    Given I am in working on a term in "Open" SOC state
    When I attempt to create a course not in my department
    Then I do not have access to create the course offering

  Scenario: Department Schedule Coordinator Carol has access to create CO's in her admin org
    Given I am in working on a term in "Open" SOC state
    When I attempt to create a course in my department
    Then I have access to create the course offering from catalog
    And I have access to create the course from an existing offering

  Scenario: Department Schedule Coordinator Carol has limited access to delete AOs in a Final Edits State
    Given I am in working on a term in "Final Edits" SOC state
    Then I have access delete an activity offering in a "Draft" state for a course in my department
    And  I have access delete an activity offering in a "Approved" state for a course in my department

  Scenario: Department Schedule Coordinator Carol has limited access to delete AOs in a Published State
    Given I am in working on a term in "Published" SOC state
    And there is a draft course in my department
    When I am logged in as a Department Schedule Coordinator
    Then I have access delete an activity offering in a "Draft" state for a course in my department

  Scenario: Department Schedule Coordinator Carol has limited access to delete AOs in a Open State
    Given I am in working on a term in "Open" SOC state
    Then I have access delete an activity offering in a "Draft" state for a course in my department
    And  I have access delete an activity offering in a "Approved" state for a course in my department

  Scenario: Department Schedule Coordinator Carol has limited access to delete Co's in an Open State
    Given I am in working on a term in "Open" SOC state
    And I copy and approve a course offering
    Then I have access to delete a course offering in a "Draft" state for a course in my department
    And I have access to delete a course offering in a "Planned" state for a course in my department
    #not yet implemented - limited access to suspended and cancelled states

  Scenario: AZ 6.1 Department Schedule Coordinator Carol has no access to manage course offerings for a term with SOC State Draft
    Given I am in working on a term in "Draft" SOC state
    When I manage course offerings for a subject code in my department
    Then I do not have access to manage the course offering

  Scenario: AZ 6.1 Department Schedule Coordinator Carol has no access to manage activity offerings for a term with SOC State Draft
    Given I am in working on a term in "Draft" SOC state
    When I manage a course offering in my department
    Then I do not have access to view the activity offerings

  Scenario: AZ 6.2 Department Schedule Coordinator Carol has access edit course offering grading option for a term with SOC State Open
    Given I am in working on a term in "Open" SOC state
    When I edit a course offering in my department
    Then I can edit the grading options

  Scenario: AZ 6.2 Department Schedule Coordinator Carol has access edit course offering grading option for a term with SOC State Final Edits
    Given I am in working on a term in "Final Edits" SOC state
    When I edit a course offering in my department
    Then I can edit the grading options

  Scenario: AZ 6.2 Department Schedule Coordinator Carol does not have access to edit course offering grading option for a term with SOC State Published
    Given I am in working on a term in "Published" SOC state
    When I manage a course offering in my department
    Then I do not have access to edit the course offering

