@draft
@bjg
Feature: WC.Create standard Time Slots

  TODO: NEED TO PUT THE USER-STORY DESCRIPTION HERE!

  Background:
    Given I am logged in as a Schedule Coordinator

  @draft
  @bjg
  Scenario: Adding a standard time slot for a single time slot type
    When I show time slots for a single term type
    And I add 2 different time slots for the same time slot type
    Then the timeslots are saved





