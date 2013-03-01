@pending
Feature: Add Activity Offering Toolbar Button

  As a user, I want to Add Activity Offerings from the Manage Course Offerings process by means of a Toolbar Button
  so I can more easily manage my Course Offerings.

Background:
  Given I am logged in as admin

Scenario: Add Activity Offering via toolbar button
  Given I manage a single course offering
  And I prepare Activity Offering data
  When I click the "Add Activity Offering" toolbar button
  Then the Activity Offering should be added to the list
