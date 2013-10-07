@wip @mw
Feature: EC.Waitlists Colocation

  WL 1.17 - As a Central Administrator I want colocated activities to utilize a single waitlist
  when they share max enrollment so that students are processed in order

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: WL 1.17.1 confirm the shared WL settings for colocated AOs with shared max enrollment
    Given there is an activity offering with waitlists enabled and a waitlist limit size of 100
    And there are two other activity offering with waitlists enabled and no waitlist limit
    When I colocate the activity offering with other two offerings and select shared maximum enrolment
    Then all three activity offerings have the same waitlist limit size

  Scenario: WL 1.17.2 Update waitlist settings for colocated activity offerings with shared max enrollment - verify changes are made to colocated set
    Given I create three colocated activity offerings with shared enrolment and waitlists enabled
    When I make changes to the default activity offering waitlist configuration
    Then all three colocated activity offerings have the same waitlist configuration

  Scenario:  WL 1.17.3 Verify waitlist configuration copied during rollover for colocated activity offerings
    Given I create an Academic Calender and add an official term
    And I create three colocated activity offerings with shared enrolment and waitlists enabled
    And I make changes to the default activity offering waitlist configuration
    When I rollover the term to a new academic term
    Then the waitlist configuration is copied to the new colocated activity offerings in the target term

  Scenario: WL 1.17.4 Verify waitlist information is copied (within the same term) when copying a course offering with a colocated activity offering
    Given I create three colocated activity offerings with shared enrolment and waitlists enabled
    And I make changes to activity offering waitlist configuration
    When I copy the course offering
    Then the waitlist configuration is copied to the colocated activity offering in the new course offering

  Scenario: WL 1.17.5 Verify waitlist information is copied when copying a colocated activity offering
    Given I create three colocated activity offerings with shared enrolment and waitlists enabled
    And I make changes to activity offering waitlist configuration
    When I copy one of the colocated activity offerings
    Then the activity offering copy is added to the colocated set
    Then the waitlist configuration is copied to the new colocated activity offering

  Scenario: WL 1.17.6 when creating a new CO by copy of an Existing CO, and the existing CO has AO with a colo-shared enrollment set up, ensure that the AO in the new CO is NOT coloed and has default WL settings
    And I create three colocated activity offerings with shared enrolment and waitlists enabled
    And I make changes to activity offering waitlist configuration
    When I copy one of the colocated activity offerings
    Then the activity offering copy is added to the colocated set
    Then the waitlist configuration is copied to the new colocated activity offering


