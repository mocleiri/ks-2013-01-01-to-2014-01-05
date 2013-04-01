@nightly
Feature: delete activity offerings

  CO 24.12, As a user, I want to Delete Activity Offerings from the Manage Course Offerings process
            by means of a Toolbar Button so I can more easily manage my Course Offerings.

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Delete multiple AOs
    When I designate a valid term and a Course Offering Code
    And I delete the selected multiple AOs
    Then The AOs are Successfully deleted

  Scenario: Delete an AO in cross-listed course offering
    When I designate a valid term and cross-listed Course Offering Code
    And I delete the AO with Draft state
    Then The AO is Successfully deleted
