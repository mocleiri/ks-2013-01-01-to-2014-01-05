@nightly
Feature: Department Schedule Coordinator Authorization SOC state Published

  Background:
    Given I am logged in as a Department Schedule Coordinator
    And I am working on a term in "Published" SOC state

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

  Scenario: AZ 5.1A/Full.7 Department Schedule Coordinator Carol has limited access to delete AOs in a SOC state Published
    Given I am working on a term in "Published" SOC state
    And there is a "Draft" course offering in my admin org
    When I am logged in as a Department Schedule Coordinator
    Then I have access to delete an activity offering in "Draft" status for the course offering

  Scenario: AZ 6.2/Full.14 Verify Department Schedule Coordinator Carol edit course offering access (in admin org) for a term with SOC State Published (single CO view)
    Given I am working on a term in "Published" SOC state
    When I manage a course offering in my admin org
    Then I do not have access to edit the course offering
    But I have access to edit activity offerings

