@nightly
Feature: Create and remove cross-listings

  Background:
    Given I am logged in as a Schedule Coordinator

  #KSENROLL-5398
  Scenario: Remove cross-listing confirm owner

      Create a cross-listed CO and set the cross-listed checkbox, then clear the cross-listed checkbox.
      Make sure the checkbox is not set.
      Manage and edit the owner course offering.
      Make sure it does not specify "Crosslisted as:"

    When I create a cross-listed Course Offering
    And I remove a cross-listed Course Offering
    Then the edit page should not indicate a cross-listing
    And I manage the owner Course Offering
    Then the owner course offering is not indicated as cross-listed with the alias CO
#
  Scenario: Remove cross-listing confirm alias

      Create a cross-listed CO and set the cross-listed checkbox, then clear the cross-listed checkbox.
      Manage and edit the alias course offering.
      Should get a "Cannot find any course offering" message

    When I create a cross-listed Course Offering
    And I remove a cross-listed Course Offering
    And I manage the alias Course Offering
    Then the alias Course Offering does not exist

  Scenario: Create cross-listing confirm alias

      Create a cross-listed CO and set the cross-listed checkbox.
      Manage and edit the alias course offering.
      The alias should state that it is cross-listed with the owner.

    When I create a cross-listed Course Offering
    And I manage the alias Course Offering
    Then the alias is indicated as cross-listed with the owner CO

  Scenario: Create cross-listing confirm owner (Pathway II)

      Create a cross-listed CO and set the cross-listed checkbox.
      Manage and edit the owner course offering.
      The owner should state that it is cross-listed with the alias.

    When I create a cross-listed Course Offering
    And I manage the owner Course Offering
    And I edit the course offering
    Then the edit page should indicate a cross-listing
