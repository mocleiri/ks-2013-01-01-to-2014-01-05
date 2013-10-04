@wip
@nelson.leduc
Feature: WC.Delete and edit standard Time Slots

  As a Scheduling Coordinator, I want to edit existing Standard Time Slots for
  a particular Time Slot Type so that university scheduling policies will be enforced.

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Filtering term type for time slot editing
    When I specify Term Type FallFull
    Then only time slots of Term Type FallFull appear.

  Scenario: Deleting a time slot that has not been used
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days H, Start time 10:00 PM, End time 10:50 PM
    Then the changes are saved.
    And I attempt to delete the Time Slot added above
    Then the Time Slot is deleted.

  Scenario: Deleting a time slot that has been used
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days H, Start time 11:00 PM, End time 11:50 PM
    Then the changes are saved.
    And I add an RDL using the Time Slot added above
    And I attempt to delete the Time Slot added above
    Then the Time Slot is not deleted.

  Scenario: Deleting multiple time slots, some of which have been used
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days H, Start time 09:00 PM, End time 09:50 PM
    And I add Time Slot with Term Type FallFull, Days H, Start time 09:05 PM, End time 09:55 PM
    Then the changes are saved.
    And I add an RDL using the first Time Slot added above
    And I attempt to delete both the Time Slots added above in the same action
    Then a message is displayed on the time slot page
    And the first Time Slot is not deleted
    And the second Time Slot is deleted.

  Scenario: Ability to edit a time slot that has not been used
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days S, Start time 10:00 PM, End time 10:50 PM
    Then the changes are saved.
    And I attempt to edit the Time Slot added above
    Then the Time Slot edits are saved.

  Scenario: Ability to edit a time slot that has been used
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days S, Start time 11:00 PM, End time 11:50 PM
    Then the changes are saved.
    And I add an RDL using the Time Slot added above
    And I attempt to edit the Time Slot added above
    Then the Time Slot edits are not saved.

  Scenario: Editing a time slot that has not been used
    When I specify Term Types FallFull and SpringFull
    And I add Time Slot with Term Type FallFull, Days U, Start time 10:00 PM, End time 10:50 PM
    Then the changes are saved.
    And I edit the Time Slot added above to be SpringFull, Days S, Start time 10:01 PM, End time 10:51 PM
    Then the Time Slot edits are saved.

  Scenario: Editing a standard time slot using incomplete data - omitting start time
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days T, Start time 10:00 PM, End time 10:50 PM
    Then the changes are saved.
    And I attempt to edit the Time Slot added above to be FallFull, Days T, Start time blank, End time 10:50 PM
    Then an error message is displayed on the time slot page.

  Scenario: Editing a standard time slot using incomplete data - omitting end time
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days T, Start time 10:05 PM, End time 10:55 PM
    Then the changes are saved.
    And I attempt to edit the Time Slot added above to be FallFull, Days T, Start time 10:05 PM, End time blank
    Then an error message is displayed on the time slot page

  Scenario: Editing a standard time slot using incomplete data - omitting days
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days T, Start time 10:10 PM, End time 10:59 PM
    Then the changes are saved.
    And I attempt to edit the Time Slot added above to be FallFull, Days blank, Start time 10:10 PM, End time 10:59 PM
    Then an error message is displayed on the time slot page

  Scenario: Editing an existing time slot that results in duplication
    When I specify Term Type FallFull
    And I add Time Slot with Term Type FallFull, Days U, Start time 11:00 PM, End time 11:50 PM
    And I add Time Slot with Term Type FallFull, Days U, Start time 11:05 PM, End time 11:55 PM
    Then the changes are saved.
    And I edit the second Time Slot added above to be FallFull, Days U, Start time 11:00 PM, End time 11:50 PM
    Then an error message is displayed on the time slot page

