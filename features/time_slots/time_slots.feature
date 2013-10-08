@draft
@bjg
Feature: WC.Create standard Time Slots

  TODO: NEED TO PUT THE USER-STORY DESCRIPTION HERE!

  Background:
    Given I am logged in as a Schedule Coordinator

  @draft
  @bjg
  Scenario: Adding a standard time slot for a single time slot type
    When I add 2 different time slots to a single term type
    Then the timeslots are saved

  @draft
  @bjg
  Scenario: Adding a standard time slot for multiple time slot types
    When I add a single time slot per 2 different term types
    Then the timeslots are saved

  @draft
  @bjg
  Scenario: Adding a non-unique standard time slot
    When I add a duplicate time slot
    Then an error message is displayed about the duplicate timeslot

  #@draft
  #@bjg
  #Scenario: test some stuff
  #  When I test some timeslot stuff





