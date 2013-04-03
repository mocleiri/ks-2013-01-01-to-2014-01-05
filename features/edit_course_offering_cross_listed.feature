@nightly
Feature: Create and remove cross-listings

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Create cross-listing confirm alias (Pathway I)
    When I create a cross-listed Course Offering
    And I manage the alias Course Offering
    Then the alias is indicated as cross-listed with the owner CO

  Scenario: Create cross-listing confirm owner (Pathway I)
    When I create a cross-listed Course Offering
    And I manage the owner Course Offering
    Then the owner course offering is indicated as cross-listed with the alias CO

  #KSENROLL-5398
  Scenario: Remove cross-listing confirm owner (Pathway I)
    When I create a cross-listed Course Offering
    And I remove a cross-listed Course Offering
    Then the edit confirmation view should not indicate that a cross-listing exists
    And I manage the owner Course Offering
    Then the owner course offering is not indicated as cross-listed with the alias CO

  Scenario: Remove cross-listing confirm alias (Pathway I)
    When I create a cross-listed Course Offering
    And I remove a cross-listed Course Offering
    And I manage the alias Course Offering
    Then the alias Course Offering does not exist

  Scenario: Create cross-listing confirm alias (Pathway II)
    When I create a cross-listed Course Offering
    And I manage the alias Course Offering
    Then the alias is indicated as cross-listed with the owner CO

  Scenario: Create cross-listing confirm owner (Pathway II)
    When I create a cross-listed Course Offering
    And I manage the owner Course Offering
    Then the owner course offering is indicated as cross-listed with the alias CO

  Scenario: Remove cross-listing confirm owner (Pathway II)
    When I create a cross-listed Course Offering
    And I remove a cross-listed Course Offering
    And I manage the owner Course Offering
    Then the owner course offering is not indicated as cross-listed with the alias CO

  Scenario: Remove cross-listing confirm alias (Pathway II)
    When I create a cross-listed Course Offering
    And I remove a cross-listed Course Offering
    And I manage the alias Course Offering
    Then the alias Course Offering does not exist

  #KSENROLL-5398
  Scenario: Edit Course Offering to add cross list (Pathway I)
    When I create a Course Offering
    And I edit the course offering to add alias
    Then the edit confirmation view should indicate that a cross-listing exists
    And I manage the alias Course Offering
    Then the alias is indicated as cross-listed with the owner CO