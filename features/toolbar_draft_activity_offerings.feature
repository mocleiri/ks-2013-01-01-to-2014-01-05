@pending
Feature: Set as Draft toolbar button

  As a user, I want to Set as Draft Activity Offerings from the Manage Course Offerings process by means of a Toolbar
  Button so I can more easily manage my Course Offerings

  Background:
    Given I am logged in as admin

  Scenario: Set single Activity Offering to Draft via toolbar button
    Given I manage a single course offering
    And I select an Activity Offering in Approved state
    When I click the "Set as Draft" toolbar button
    Then the Activity Offering is in "Draft" state

  Scenario: Set multiple Activity Offerings to Draft via toolbar button
    Given I manage a single course offering
    And I select multiple Activity Offerings in Approved state
    When I click the "Set as Draft" toolbar button
    Then the Activity Offerings are in "Draft" state
