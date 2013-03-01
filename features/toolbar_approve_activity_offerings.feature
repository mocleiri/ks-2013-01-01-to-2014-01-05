@pending
Feature: Approve Activity Offering toolbar button

  Background:
    Given I am logged in as admin

  Scenario: Approve single Activity Offering via toolbar button
    Given I manage a single course offering
    And I select a Draft Activity Offering
    When I click the "Approve Activity Offering" toolbar button
    Then the Activity Offering is in "Approved" state
    And the Course Offering is in Planned state

  Scenario: Approve multiple Activity Offerings via toolbar button
    Given I manage a single course offering
    And I select multiple Draft Activity Offerings
    When I click the "Approve Activity Offering" toolbar button
    Then the Activity Offerings are in "Approved" state
    And the Course Offering is in Planned state
