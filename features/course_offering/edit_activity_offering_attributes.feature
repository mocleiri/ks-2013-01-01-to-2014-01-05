@nightly
Feature: WC.Edit Activity Offering Attributes

  Background:
    Given I am logged in as a Schedule Coordinator
    And I manage a given Course Offering
    And I edit an Activity Offering

  Scenario: Edit Activity Offering Information attributes
    When I am editing the information attributes for an activity offering
    And I submit the Activity Offering changes
    Then the changes of information attributes are persisted

  Scenario: Edit Activity Offering Personnel attributes
    When I change Personnel attributes
    And I submit the Activity Offering changes
    Then the changes of the Personnel attributes are persisted

  Scenario: Edit Miscellaneous Activity Offering attributes
    When I change Miscellaneous Activity Offering attributes
    And I submit the Activity Offering changes
    Then the miscellaneous changes are persisted

  @pending
  Scenario: Change Activity Offering Information attributes without submitting
    Given I am editing the information attributes for an activity offering
    When I save the changes and remain on the Edit AO page
    Then the changes of Activity Offering attributes are persisted

  @pending
  Scenario: Change Activity Offering Information attributes, save and jump to previous AO
    Given I am editing the information attributes for an activity offering
    When I save the changes and jump to the previous AO
    Then the changes of information attributes are persisted

  @pending
  Scenario: Change Activity Offering Information attributes, save and jump to previous AO
    Given I am editing the information attributes for an activity offering
    When I save the changes and jump to the next AO
    Then the changes of information attributes are persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump to previous AO without saving
    Given I am editing the information attributes for an activity offering
    When I jump to the previous AO without saving the changes
    Then the changes of information attributes are not persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump to next AO without saving
    Given I am editing the information attributes for an activity offering
    When I jump to the next AO without saving the changes
    Then the changes of information attributes are not persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump to an arbitrary AO without saving
    Given I am editing the information attributes for an activity offering
    When I jump to an arbitrary AO without saving the changes
    Then the changes of information attributes are not persisted

  @pending
  Scenario: Change Activity Offering Information attributes and jump to an arbitrary AO
    Given I am editing the information attributes for an activity offering
    When I save the changes and jump to an arbitrary AO
    Then the changes of information attributes are persisted

  @pending
  Scenario: Change Activity Offering Information attributes and cancel
    Given I am editing the information attributes for an activity offering
    When I jump to an arbitrary AO but cancel the change
    Then the changes of information attributes are not persisted
