@nightly
Feature: EC.Cancel Suspend Reinstate AOs

  As a user, I want to be able to cancel and suspend an activity offering so that it will no longer be offered, and reinstate it so that it will be offered.

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: CO 21.1.1 CSR Cancel draft, offered, and canceled Activity Offerings
    Given I manage a course offering with draft, offered, and canceled activity offerings present
    Then I am able to cancel an activity offering in Draft status
    And I am able to cancel an activity offering in Offered status
    And the cancel button is unavailable when I select an activity offering in Canceled status, unless I also select an activity offering in Draft status
    And after canceling, the registration group is shown as canceled
    And the Course Offering is shown as Canceled
    And the Course Offering is no longer shown in the Schedule of Classes

  Scenario: CO 21.1.2 CSR Cancel a suspended Activity Offering
    Given I manage a course offering with a suspended activity offering present
    Then I am able to cancel an activity offering in Suspended status
    And actual delivery logistics for the Suspended activity offering are no longer shown
    And the Suspended activity offering is no longer shown in the Schedule of Classes

  Scenario: CO 21.1.3 CSR Cancel an approved Activity Offering
    Given I manage a course offering with an approved activity offering present
    When I select an activity offering to work with in Approved status
    Then the Cancel button is "enabled"
    When I cancel the activity offering
    Then the Approved activity offering is shown as canceled
    And actual delivery logistics for the Approved activity offering are no longer shown

  Scenario: CO 21.1.4 CSR Cancel offered Activity Offering that is the only AO for the CO
    Given I manage a course offering with an offered activity offering present
    Then I am able to cancel an activity offering in Offered status

  Scenario: CO 23.1.1 CSR Check Reinstate button availability for canceled and offered AOs
    Given I manage a course offering with canceled and offered activity offerings present
    Then the reinstate button is available when I select an activity offering in Canceled status, but unavailable when I select an activity offering in Offered status

  Scenario: CO 23.1.2 CSR Check Reinstate button availability in all SOC states
    Given I manage a course offering with a canceled activity offering present in a published SOC state
    When I select the activity offering, which is in Canceled status
    Then the Reinstate button is "enabled"
    Then I deselect the activity offering, which is in Canceled status
    Given I manage a course offering with a canceled activity offering present in a draft SOC state
    When I select the activity offering, which is in a Canceled status
    Then the Reinstate button is "enabled"
    Then I deselect the activity offering, which is in a Canceled status
    Given I manage a course offering with a canceled activity offering present in an open SOC state
    When I select the activity offering, which is Canceled status
    Then the Reinstate button is "enabled"
    Then I deselect the activity offering, which is Canceled status
    Given I manage a course offering with a canceled activity offering present in a locked SOC state
    When I select the activity offering that is in Canceled status
    Then the Reinstate button is "enabled"
    Then I deselect the activity offering that is in Canceled status
    Given I manage a course offering with a canceled activity offering present in a final edits SOC state
    When I select the activity offering that is in a Canceled status
    Then the Reinstate button is "enabled"
    Then I deselect the activity offering that is in a Canceled status

  Scenario: CO 23.1.3 CSR Reinstate a canceled AO
    Given I manage a course offering with a canceled activity offering present in draft SOC state
    When I select the activity offering, which is a Canceled status
    And I reinstate the activity offering
    Then the Canceled activity offering is shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending
    And the Course Offering is shown as Draft

  #moved this up one compared to the order in the user story, because the test data works out better
  Scenario: CO 23.1.5 CSR Reinstate with multiple AOs selected, one canceled and one Draft
    Given I manage a course offering with canceled and draft activity offerings present in draft SOC state
    When I select the Canceled and Draft activity offerings
    And I reinstate the activity offering, verifying that one of the two selections is eligible for this action
    Then the Canceled and Draft activity offerings are both shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the Canceled activity offerings
    And registration group is shown as pending

  Scenario: CO 23.1.4 CSR Reinstate multiple canceled AOs in draft SOC state
    Given I manage a course offering with multiple canceled activity offerings present in draft SOC state
    When I select the Canceled activity offerings
    And I reinstate the activity offering
    Then the Canceled activity offerings are shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for both activity offerings
    And registration group is shown as pending

  Scenario: CO 23.3A.1 CSR Check Reinstate button availability for suspended AOs
    Given I manage a course offering with suspended activity offering present
    When I select the Suspended activity offering
    Then the Reinstate button is "enabled"
    Then I deselect the Suspended activity offering

  Scenario: CO 23.3A.2 CSR Reinstate suspended AOs with ADLs in locked, final edits, published SOC states
    Given I manage a course offering with suspended activity offerings present in a locked SOC state
    When I select a Suspended activity offering
    Then the Reinstate button is "enabled"
    Then I deselect Suspended activity offering
    Given I manage a course offering with suspended activity offerings present in a final edits SOC state
    When I select Suspended activity offering
    Then the Reinstate button is "enabled"
    Then I deselect a Suspended activity offering
    Given I manage a course offering with suspended activity offerings present in a published SOC state
    When I select the first Suspended activity offering
    Then the Reinstate button is "enabled"
    Then I deselect the first Suspended activity offering

  Scenario: CO 23.3A.8 CSR Reinstate an AO with ADLs that is the only AO in the CO, in published SOC state
    Given I manage a course offering with a suspended activity offering present in a published SOC state
    When I select activity offering, which is Suspended
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as offered
    And actual delivery logistics for the Suspended activity offering are still shown
    And the registration group is shown as offered
    And the Course Offering is shown as Offered

  Scenario: CO 23.3A.9 CSR Reinstate an AO with ADLs in final edits SOC state
    Given I manage a course offering with a suspended activity offering present in a final edits SOC state
    When I select the activity offering, which is Suspended
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as approved
    And actual delivery logistics for the Suspended activity offering are still shown
    And the registration group is shown as pending
    And the Course Offering is shown as Planned

  # requires an MSE here to turn RDLs into ADLs ... need to create a custom term so can do it safely
  @wip
  Scenario: CO 23.3A.5 CSR Reinstate an AO with ADLs in locked SOC state
    Given I manage a course offering with a suspended activity offering present in a locked SOC state
    When I select this activity offering, which is Suspended
    And I reinstate the activity offering
    Then this Suspended activity offering is shown as approved
    And actual delivery logistics for the Suspended activity offering are still shown
    And registration group is shown as pending
    And the Course Offering is now shown as Planned

  Scenario: CO 23.3A.6 CSR Reinstate multiple suspended AOs with ADLs in published SOC state
    Given I manage a course offering with multiple suspended activity offerings present in a published SOC state
    When I select the Suspended activity offerings
    And I reinstate the activity offering
    Then the Suspended activity offerings are shown as offered
    And actual delivery logistics for the Suspended activity offering are still shown
    And actual delivery logistics for the second Suspended activity offering are still shown
    And both registration groups are shown as offered

  Scenario: CO 23.3A.7 CSR Reinstate suspended and offered AOs in published SOC state
    Given I manage a course offering with suspended and offered activity offerings present in a published SOC state
    When I select the Suspended and Offered activity offerings
    And I reinstate the activity offering, verifying that one of the two selections is eligible for this action
    Then the Suspended and Offered activity offerings are both shown as offered
    And actual delivery logistics for the Suspended activity offering are still shown
    And actual delivery logistics for the Offered activity offering are still shown

  Scenario: CO 23.3B.1 CSR Reinstate suspended AO with RDLs in published SOC state
    Given I manage a course offering with one suspended activity offering present in a published SOC state
    When I select activity offering, which is Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the second activity offering
    And the second registration group is shown as pending

  Scenario: CO 23.3B.2 CSR Reinstate an AO with RDLs in final edits SOC state
    Given I manage a course offering with suspended activity offering present in a final edits SOC state
    When I select activity offering, which is in Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the fourth activity offering
    And the fourth registration group is shown as pending

  Scenario: CO 23.3B.3 CSR Reinstate an AO with RDLs in locked SOC state
    Given I manage a course offering with suspended activity offering present in a locked SOC state
    When I select activity offering, which is in a Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as a draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending

  Scenario: CO 23.3B.4 CSR Reinstate multiple suspended AOs with RDLs in published SOC state
    Given I manage a course offering with two suspended activity offerings present in a published SOC state
    When I select both Suspended activity offerings
    And I reinstate the activity offering
    Then both Suspended activity offerings are shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the second activity offering
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the third activity offering
    And the second registration group is shown as pending
    And the third registration group is shown as pending

  Scenario: CO 23.3B.5 CSR Reinstate suspended and draft AOs with RDLs in published SOC state
    Given I manage a course offering with a suspended and a draft activity offering present in a published SOC state
    When I select the suspended and draft activity offerings
    And I reinstate the activity offering, verifying that one of the two selections is eligible for this action
    Then the Suspended activity offering is shown as draft and the draft activity offering is shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the second activity offering

  Scenario: CO 23.3B.6 CSR Reinstate a single AO with RDLs in published SOC state
    Given I manage a course offering with a single suspended activity offering present in a published SOC state
    When I select the activity offering, which is in Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown in draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending
    And the Course Offering is now shown as Draft

  Scenario: CO 23.3B.7 CSR Reinstate a single AO with RDLs in final edits SOC state
    Given I manage a course offering with a single suspended activity offering present in a final edits SOC state
    When I select the only activity offering, which is in Suspended status
    And I reinstate the activity offering
    Then the only Suspended activity offering is shown in draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending
    And the Course Offering is now shown as Draft status

