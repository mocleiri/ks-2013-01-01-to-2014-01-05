@nightly
Feature: Department Schedule Coordinator Authorization
#TODO - cover list vs single CO view
  Background:
    Given I am logged in as a Department Schedule Coordinator

  @bug
  Scenario: AZ 3.1/AZ 4.1B/Full.20 - Verify Department Schedule Coordinator edit activity offering access (within admin org) in SOC state Open
    Given I am working on a term in "Open" SOC state
    When I attempt to edit an activity offering for a course offering in my admin org
    Then I have access to edit the activity code
    And I have access to edit total maximum enrollment
    And I have access to add or edit affiliated personnel
    And I have access to revise delivery logistics
    And I have access to edit the evaluation flag
    And I have access to edit the honors flag
    But I do not have access to add or edit seat pools

  Scenario: AZ 3.1/AZ 4.1B/Full.3 - Verify Department Schedule Coordinator edit activity offering access (within admin org) in SOC state Final Edits
    Given I am working on a term in "Final Edits" SOC state
    When I attempt to edit an activity offering for a course offering in my admin org
    Then I have access to edit the activity code
    And I have access to edit total maximum enrollment
    And I have access to add or edit affiliated personnel
    And I have access to revise delivery logistics
    And I have access to edit the evaluation flag
    And I have access to edit the honors flag
    But I do not have access to add or edit seat pools

  Scenario: AZ 3.1/AZ 4.1B/Full.4 - Verify Department Schedule Coordinator edit activity offering access (within admin org) in SOC state Published
    Given I am working on a term in "Published" SOC state
    When I attempt to edit an activity offering for a course offering in my admin org
    And I have access to edit total maximum enrollment
    And I have access to add or edit affiliated personnel
    And I have access to edit the course url
    And I have access to edit the evaluation flag
    And I have access to edit the honors flag
    But I do not have access to add or edit seat pools
    And I do not have access to edit the activity code
    And I do not have access to revise delivery logistics

  @bug @KSENROLL-5888
  Scenario: AZ 4.1A/Full.1A Validate Department Schedule Coordinator access to a course offering not in their admin org (CO individual course)
    Given I am working on a term in "Open" SOC state
    When I manage a course offering for a subject code not in my admin org
    Then I have access to view the course offering details
    And I have access to view the activity offering details
    But I do not have access to edit the course offering
    And I do not have access to manage registration groups
    And I do not have access to select activity offerings for add, approve, delete


  #TODO - same for all SOCs except for Draft
  Scenario: AZ4. 1A/4.2/Full.1B Department Schedule Coordinator has read access to course offerings not in their admin org (CO subj list)
    Given I am working on a term in "Open" SOC state
    When I manage course offerings for a subject code not in my admin org
    Then I have access to view course offering details
    And I have access to manage course offerings
    But I do not have access to edit the listed course offering
    And I do not have access to delete the listed course offering
    And I do not have access to approve the listed course offering
    And I do not have access to copy the listed course offering

  Scenario: AZ 4.1A/4.2/Full.19 Department Schedule Coordinator Carol can access the Manage CO set of pages for COs for her own admin org (Open SOC)
    Given I am working on a term in "Open" SOC state
    When I manage course offerings for a subject code in my admin org
    Then I have access to view course offering details
    And I have access to add new course offerings
    And I have access to approve course offerings for scheduling
    And I have access to delete course offerings
    And I have access to edit course offerings
    And I have access to copy course offerings

  Scenario: AZ 4.1A/4.2/Full.18 Department Schedule Coordinator Carol can access the Manage AO set of pages for COs for her own admin org (Open SOC)
    Given I am working on a term in "Open" SOC state
    When I manage a course offering in my admin org
    Then I have access to view the activity offering details
    And the next, previous and list all course offering links are enabled
    And I have access to add a new activity offering
    And I have access to delete an activity offering
    And I have access to edit an activity offering
    And I have access to copy an activity offering
    And I have access to approve an activity offering
    And I have access to manage registration groups

  Scenario: AZ 4.1C/Full.5A Department Schedule Coordinator Carol does not have access to create CO's not in her admin org
    Given I am working on a term in "Open" SOC state
    When I attempt to create a course offering for a subject not in my admin org
    Then I do not have access to create the course offering

  Scenario: AZ 4.1C/Full.5 Department Schedule Coordinator Carol has access to create CO's in her admin org
    Given I am working on a term in "Open" SOC state
    When I attempt to create a course offering for a subject in my admin org
    Then I have access to create the course offering from catalog
    And I have access to create the course from an existing offering

  Scenario: AZ 5.1A/Full.6 Department Schedule Coordinator Carol has limited access to delete AOs in a SOC state Final Edits
    Given I am working on a term in "Final Edits" SOC state
    And there is a "Draft" course offering in my admin org
    Then I have access to delete an activity offering in "Draft" status for the course offering
    And  I have access to delete an activity offering in "Approved" status for the course offering

  Scenario: AZ 5.1A/Full.7 Department Schedule Coordinator Carol has limited access to delete AOs in a SOC state Published
    Given I am working on a term in "Published" SOC state
    And there is a "Draft" course offering in my admin org
    When I am logged in as a Department Schedule Coordinator
    Then I have access to delete an activity offering in "Draft" status for the course offering

  Scenario: AZ 5.1A/Full.8 Department Schedule Coordinator Carol has limited access to delete AOs in a Open State
    Given I am working on a term in "Open" SOC state
    And there is a "Draft" course offering in my admin org
    Then I have access to delete an activity offering in "Draft" status for the course offering
    And I have access to delete an activity offering in "Approved" status for the course offering

  Scenario: AZ 5.1B/Full.9 Department Schedule Coordinator Carol has limited access to delete Co's in an Open State
    Given I am working on a term in "Open" SOC state
    And there is a "Planned" course offering in my admin org
    Then I have access to delete a course offering in a "Draft" state for a course in my admin org
    And I have access to delete a course offering in a "Planned" state for a course in my admin org
    #not yet implemented - limited access to suspended and cancelled states
    # TODO AZ 5.1B - there should be tests for 'Final Edits' and 'Published' SOC states

  Scenario: AZ 6.1/Full.10 Department Schedule Coordinator Carol has no access to manage course offerings (in admin org) for a term with SOC State Draft
    Given I am working on a term in "Draft" SOC state
    When I manage course offerings for a subject code in my admin org
    Then I do not have access to manage the course offering

  Scenario: AZ 6.1//Full.11 Department Schedule Coordinator Carol has no access to manage activity offerings for a term with SOC State Draft
    Given I am working on a term in "Draft" SOC state
    When I manage a course offering in my admin org
    Then I do not have access to view the activity offerings

  Scenario: AZ 6.1/Full.10A Department Schedule Coordinator Carol has no access to manage activity offerings for a term with SOC State Draft
    Given I am working on a term in "Draft" SOC state
    When I manage a course offering for a subject code not in my admin org
    Then I do not have access to view the activity offerings

  Scenario: AZ 6.2/Full.1 Verify Department Schedule Coordinator Carol edit course offering (in admin org) for a term with SOC State Open
    Given I am working on a term in "Open" SOC state
    When I edit a course offering in my admin org
    Then I have access to edit the course code suffix
    And I have access to edit the grading options
    And I have access to edit the registration options
    And I have access to edit the credit type
    And I have access to edit the format type
    And I have access to edit the waitlists flag
    And I have access to edit the affiliated personnel
    And I have access to edit the administrating org
    And I have access to edit the CO honors flag
    But I do not have access to edit the final exam type

  Scenario: AZ 6.2/Full.2 Verify Department Schedule Coordinator Carol edit course offering (in admin org) for a term with SOC State Final Edits
    Given I am working on a term in "Final Edits" SOC state
    When I edit a course offering in my admin org
    Then I have access to edit the course code suffix
    And I have access to edit the grading options
    And I have access to edit the registration options
    And I have access to edit the credit type
    And I have access to edit the format type
    And I have access to edit the waitlists flag
    And I have access to edit the affiliated personnel
    And I have access to edit the administrating org
    And I have access to edit the CO honors flag
    But I do not have access to edit the final exam type

  Scenario: AZ 6.2/Full.12 Verify Department Schedule Coordinator Carol edit course offering access (in admin org) for a term with SOC State Draft (single CO view)
    Given I am working on a term in "Draft" SOC state
    When I manage a course offering in my admin org
    Then I do not have access to view the course offering list
    #And I do not have access to edit activity offerings

  Scenario: AZ 6.2/Full.13 Verify Department Schedule Coordinator Carol edit course offering access (in admin org) for a term with SOC State Locked (single CO view)
    Given I am working on a term in "Locked" SOC state
    When I manage a course offering in my admin org
    Then I do not have access to edit the course offering
    And I do not have access to edit activity offerings

  Scenario: AZ 6.2/Full.14 Verify Department Schedule Coordinator Carol edit course offering access (in admin org) for a term with SOC State Published (single CO view)
    Given I am working on a term in "Published" SOC state
    When I manage a course offering in my admin org
    Then I do not have access to edit the course offering
    And I do not have access to edit activity offerings

  Scenario: AZ 6.2/Full.15 Verify Department Schedule Coordinator Carol edit course offering access (in admin org) for a term with SOC State Closed (single CO view)
    Given I am working on a term in "Closed" SOC state
    When I manage a course offering in my admin org
    Then I do not have access to edit the course offering
    And I do not have access to edit activity offerings

  Scenario: AZ 10.1/Full.16 Department Schedule Coordinator Carol does not have access to perform rollovers
    When I attempt to perform a rollover
    Then I do not have access to the page

  Scenario: AZ 10.2/Full.17 Department Schedule Coordinator Carol does not have access to view rollover details
    When I attempt to view rollover details
    Then I do not have access to the page
