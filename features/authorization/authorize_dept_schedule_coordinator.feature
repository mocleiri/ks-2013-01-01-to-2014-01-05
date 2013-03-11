@nightly
Feature: Department Schedule Coordinator Authorization

  Background:
    Given I am logged in as a Department Schedule Coordinator

  Scenario: AZ 3.1/AZ 4.1B Department Schedule Coordinator has read only access to seat pools
    Given I am working on a term in "Final Edits" SOC state
    When I attempt to edit an activity offering for a course offering in my department
    Then I have access to revise delivery logistics
    And I do not have access to add or edit seat pools
    #TODO - implement AZ 3.1 (seat pools) for other SOC states?

  @bug @KSENROLL-5888
  Scenario: AZ 4.1A Department Schedule Coordinator does not have edit access to a course not in their department (CO individual course)
    Given I am working on a term in "Open" SOC state
    When I manage a course offering for a subject code not in my department
    Then I do not have access to edit the course offering
    And I do not have access to manage registration groups

  Scenario: AZ4. 1A/4.2 Department Schedule Coordinator has read access to course offerings not in their department (CO subj list)
    Given I am working on a term in "Open" SOC state
    When I manage course offerings for a subject code not in my department
    Then I have access to view course offering details
    And I have access to manage course offerings
    But I do not have access to edit the listed course offering
    And I do not have access to delete the listed course offering
    And I do not have access to approve the listed course offering
    And I do not have access to copy the listed course offering

  Scenario: AZ 4.1A/4.2 Department Schedule Coordinator Carol have access to access the Manage CO set of pages for COs for her own admin org
    Given I am working on a term in "Open" SOC state
    When I manage course offerings for a subject code in my department
    Then I have access to view course offering details
    And I have access to add new course offerings
    And I have access to approve course offerings for scheduling
    And I have access to delete course offerings
    And I have access to edit course offerings
    And I have access to copy course offerings

  Scenario: AZ 4.1A/4.2 Department Schedule Coordinator Carol can access the Manage AO set of pages for COs for her own admin org
    Given I am working on a term in "Open" SOC state
    When I manage a course offering in my department
    Then I have access to view the activity offering details
    And the next, previous and list all course offering links are enabled
    And I have access to add a new activity offering
    And I have access to delete an activity offering
    And I have access to edit an activity offering
    And I have access to copy activity offering
    And I have access to manage registration groups

  Scenario: AZ 4.1C Department Schedule Coordinator Carol does not have access to create CO's not in her admin org
    Given I am working on a term in "Open" SOC state
    When I attempt to create a course not in my department
    Then I do not have access to create the course offering

  Scenario: AZ 4.1C Department Schedule Coordinator Carol has access to create CO's in her admin org
    Given I am working on a term in "Open" SOC state
    When I attempt to create a course in my department
    Then I have access to create the course offering from catalog
    And I have access to create the course from an existing offering

  Scenario: AZ 5.1A Department Schedule Coordinator Carol has limited access to delete AOs in a Final Edits State
    Given I am working on a term in "Final Edits" SOC state
    Then I have access to delete an activity offering in a "Draft" state for a course in my department
    And  I have access to delete an activity offering in a "Approved" state for a course in my department

  Scenario: AZ 5.1A Department Schedule Coordinator Carol has limited access to delete AOs in a Published State
    Given I am working on a term in "Published" SOC state before the first day of class
    And there is a "Draft" course in my department
    When I am logged in as a Department Schedule Coordinator
    Then I have access to delete an activity offering in a "Draft" state for a course in my department

  Scenario: AZ 5.1A Department Schedule Coordinator Carol has limited access to delete AOs in a Open State
    Given I am working on a term in "Open" SOC state
    Then I have access to delete an activity offering in a "Draft" state for a course in my department
    And  I have access to delete an activity offering in a "Approved" state for a course in my department


  Scenario: AZ 5.1B Department Schedule Coordinator Carol has limited access to delete Co's in an Open State
    Given I am working on a term in "Open" SOC state
    And there is a "Planned" course in my department
    Then I have access to delete a course offering in a "Draft" state for a course in my department
    And I have access to delete a course offering in a "Planned" state for a course in my department
    #not yet implemented - limited access to suspended and cancelled states
    # TODO AZ 5.1B - there should be tests for 'Final Edits' and 'Published' SOC states

  Scenario: AZ 6.1 Department Schedule Coordinator Carol has no access to manage course offerings for a term with SOC State Draft
    Given I am in working on a term in "Draft" SOC state
    When I manage course offerings for a subject code in my department
    Then I do not have access to manage the course offering

  Scenario: AZ 6.1 Department Schedule Coordinator Carol has no access to manage activity offerings for a term with SOC State Draft
    Given I am in working on a term in "Draft" SOC state
    When I manage a course offering in my department
    Then I do not have access to view the activity offerings

  Scenario: AZ 6.2 Department Schedule Coordinator Carol has access edit course offering grading option for a term with SOC State Open
    Given I am working on a term in "Open" SOC state
    When I edit a course offering in my department
    Then I have access to edit the grading options

  Scenario: AZ 6.2 Department Schedule Coordinator Carol has access edit course offering grading option for a term with SOC State Final Edits
    Given I am working on a term in "Final Edits" SOC state
    When I edit a course offering in my department
    Then I have access to edit the grading options

  Scenario: AZ 6.2 Department Schedule Coordinator Carol does not have access to edit course offering grading option for a term with SOC State Published
    Given I am working on a term in "Published" SOC state before the first day of class
    When I manage a course offering in my department
    Then I do not have access to edit the course offering

