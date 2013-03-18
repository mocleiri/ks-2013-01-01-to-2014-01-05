@pending
Feature: Delete cross-listed COs

  As a user, I want to be able to delete a cross-listed course offering so that it will no longer be offered for the term.

  Background:
    Given I am logged in as a Schedule Coordinator

  @pending
  Scenario: Deletion of a cross-listing results in both the CLU and the non-CLU being deleted
    When I create a cross-listed Course Offering
    And I delete the alias Course Offering
    And I manage the owner Course Offering
    Then the 'course not found' message is displayed
    And I manage the alias Course Offering
    Then the 'course not found' message is displayed







