@nightly
Feature: WC.Edit Activity Offering Attributes

  Background:
    Given I am logged in as a Schedule Coordinator
    And I manage a given Course Offering
    And I edit an Activity Offering

  Scenario: Edit Activity Offering Information attributes
    When I change Activity Offering Information attributes
    Then I am able to submit the changes
    And verify that the changes of Information attributes have persisted

  Scenario: Edit Activity Offering Personnel attributes
    When I change Personnel attributes
    Then I am able to submit the changes
    And verify that the changes of the Personnel attributes have persisted

  Scenario: Edit Miscellaneous Activity Offering attributes
    When I change Miscellaneous Activity Offering attributes
    Then I am able to submit the changes
    And verify that the changes of Miscellaneous have persisted

  @pending
  Scenario: Change Activity Offering Information attributes without submitting
    When I change Activity Offering Information attributes
    Then I am able to save the changes and remain on the Edit AO page
    And verify that the changes have persisted

  @pending
  Scenario: Change Activity Offering Information attributes, save and jump to previous AO
    When I change Activity Offering Information attributes
    Then I am able to save the changes and jump to the previous AO
    And verify that the changes of Information attributes have persisted

  @pending
  Scenario: Change Activity Offering Information attributes, save and jump to previous AO
    When I change Activity Offering Information attributes
    Then I am able to save the changes and jump to the next AO
    And verify that the changes of Information attributes have persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump to previous AO without saving
    When I change Activity Offering Information attributes
    Then I am able to jump to the previous AO without saving the changes
    And verify that the changes of Information attributes have not persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump to next AO without saving
    When I change Activity Offering Information attributes
    Then I am able to jump to the next AO without saving the changes
    And verify that the changes of Information attributes have not persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump an arbitrary AO
    When I change Activity Offering Information attributes
    Then I am able to jump to an arbitrary AO without saving the changes
    And verify that the changes of Information attributes have not persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump an arbitrary AO
    When I change Activity Offering Information attributes
    Then I am able to save the changes and jump to an arbitrary AO
    And verify that the changes of Information attributes have persisted

  @pending
  Scenario: Change Activity Offering Information attributes and cancel
    When I change Activity Offering Information attributes
    Then I am able to jump to an arbitrary AO but cancel the change
    And verify that the changes of Information attributes have not persisted
