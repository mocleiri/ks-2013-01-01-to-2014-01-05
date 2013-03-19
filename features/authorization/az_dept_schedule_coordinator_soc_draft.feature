@nightly
Feature: Department Schedule Coordinator Authorization SOC state Draft

  Background:
    Given I am logged in as a Department Schedule Coordinator
    And I am working on a term in "Draft" SOC state

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

  Scenario: AZ 6.2/Full.12 Verify Department Schedule Coordinator Carol edit course offering access (in admin org) for a term with SOC State Draft (single CO view)
    Given I am working on a term in "Draft" SOC state
    When I manage a course offering in my admin org
    Then I do not have access to view the course offering list
#And I do not have access to edit activity offerings