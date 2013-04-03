@nightly
Feature: Simple Rollover


  As a central administrator, I want to manually trigger the rollover process so that eligible course
  offering data from the source term will be copied over to create new course offerings in the target term.

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Successfully rollover courses to target term
    Given I have created an activity offering cluster and there are registration groups for a course offering
    When I initiate a rollover by specifying source and target terms
    Then the results of the rollover are available
    And the rollover can be released to departments
    And course offerings are copied to the target term
    And the activity offering clusters, assigned AOs and reg groups are rolled over with the course offering



