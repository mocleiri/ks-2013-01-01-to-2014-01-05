@nightly
Feature: Department Schedule Coordinator Authorization SOC state Final Edits
#TODO - cover list vs single CO view
  Background:
    Given I am logged in as a Department Schedule Coordinator
    Given I am working on a term in "Final Edits" SOC state

  Scenario: AZ 3.1/AZ 4.1B/Full.3 - Verify Department Schedule Coordinator edit activity offering access (within admin org) in SOC state Final Edits
    When I attempt to edit an activity offering for a course offering in my admin org
    Then I have access to edit the activity code
    And I have access to edit total maximum enrollment
    And I have access to add or edit affiliated personnel
    And I have access to revise delivery logistics
    And I have access to edit the evaluation flag
    And I have access to edit the honors flag
    But I do not have access to add or edit seat pools

  @bug
  Scenario: AZ 5.1A/Full.6 Department Schedule Coordinator Carol has limited access to delete AOs in a SOC state Final Edits
  #can't approve AO -is that correct?
    Given I am working on a term in "Final Edits" SOC state
    And there is a "Draft" course offering in my admin org
    Then I have access to delete an activity offering in "Draft" status for the course offering
    And  I have access to delete an activity offering in "Approved" status for the course offering

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

