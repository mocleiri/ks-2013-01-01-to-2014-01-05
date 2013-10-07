@wip
@nelson.leduc
Feature: WC.Delete and edit standard Time Slots

  As a Scheduling Coordinator, I want to edit existing Standard Time Slots for
  a particular Time Slot Type so that university scheduling policies will be enforced.

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Filtering term type for time slot editing
    When I show time slots for a single term type
    Then only time slots of that term type appear.

  Scenario: Deleting a time slot that has not been used
    When I show time slots for a single term type
    And I add a Time Slot with the chosen Term Type
    Then the timeslots are saved
    And I attempt to delete the Time Slot added above
    Then the Time Slot is deleted.

  Scenario: Deleting a time slot that has been used
    When I show time slots for a single term type
    And I add a Time Slot with the chosen Term Type
    Then the timeslots are saved
    And I add an RDL using the Time Slot added above
    And I attempt to delete the Time Slot added above
    Then the Time Slot is not deleted.

  Scenario: Deleting multiple time slots, some of which have been used
    When I show time slots for a single term type
    And I add 2 different time slots to a single term type
    Then the timeslots are saved
    And I add an RDL using the first Time Slot added above
    And I attempt to delete both the Time Slots added above in the same action
    Then a message is displayed on the time slot page
    And the first Time Slot is not deleted
    And the second Time Slot is deleted.

  Scenario: Ability to edit a time slot that has not been used
    When I show time slots for a single term type
    And I add a Time Slot with the chosen Term Type
    Then the timeslots are saved
    And I attempt to edit the Time Slot added above
    Then the Time Slot edits are saved.

  Scenario: Ability to edit a time slot that has been used
    When I show time slots for a single term type
    And I add a Time Slot with the chosen Term Type
    Then the timeslots are saved
    And I add an RDL using the Time Slot added above
    And I attempt to edit the Time Slot added above
    Then the Time Slot edits are not saved.

  Scenario: Editing a time slot that has not been used
    When I show time slots for a multiple term types
    And I add a Time Slot with one of the chosen Term Types
    Then the timeslots are saved
    And I edit the Time Slot added above to use the other chosen Term Type
    Then the Time Slot edits are saved.

  Scenario: Editing a standard time slot using incomplete data - omitting start time
    When I show time slots for a single term type
    And I add a Time Slot with the chosen Term Type
    Then the timeslots are saved
    And I attempt to edit the Time Slot omitting the start time
    Then an error message is displayed on the time slot page.

  Scenario: Editing a standard time slot using incomplete data - omitting end time
    When I show time slots for a single term type
    And I add a Time Slot with the chosen Term Type
    Then the timeslots are saved
    And I attempt to edit the Time Slot omitting the end time
    Then an error message is displayed on the time slot page

  Scenario: Editing a standard time slot using incomplete data - omitting days
    When I show time slots for a single term type
    And I add a Time Slot with the chosen Term Type
    Then the timeslots are saved
    And I attempt to edit the Time Slot omitting the days
    Then an error message is displayed on the time slot page

  Scenario: Editing an existing time slot that results in duplication
    When I show time slots for a single term type
    And I add 2 different time slots to a single term type
    Then the timeslots are saved
    And I edit the second Time Slot to duplicate the first Time Slot
    Then an error message is displayed on the time slot page

