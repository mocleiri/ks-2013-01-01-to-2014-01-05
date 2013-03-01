@wip
Feature: Copy course offerings - activity offering clusters

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Copy course offering and ensure default activity offering cluster is copied
    Given I have created the default registration groups for a course offering
    When I copy the course offering
    Then the activity offering cluster and assigned AOs are copied over with the course offering
    And the registration groups are not copied

  Scenario: Copy course offering and ensure constrained activity offering clusters are copied
    Given I have created two activity offering clusters and generated registration groups for a course offering
    When I copy the course offering
    Then the activity offering clusters and assigned AOs are copied over with the course offering
    And the registration groups are not copied

  #use 201212 => 201712 BSCI425
  #  jira 5158 - need to delete BSCI425 from 201712 first or copy creates dup
  Scenario: Create course offering by copying from a previous term and ensure default activity offering cluster is copied
    Given I have created the default registration groups for a catalog course offering
    When I create a new course offering in a subsequent term by copying the catalog course offering
    Then the activity offering cluster and assigned AOs are copied over with the course offering
    And the registration groups are not copied

  Scenario: Create course offering by copying from a previous term and ensure constrained activity offering clusters are copied
    Given I have created two activity offering clusters and generated registration groups for a course offering
    When I create a new course offering in a subsequent term by copying the course offering
    Then the activity offering clusters and assigned AOs are copied over with the course offering
    And the registration groups are not copied