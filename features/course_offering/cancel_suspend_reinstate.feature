@nightly
Feature: EC.Cancel Suspend Reinstate AOs

  As a user, I want to be able to cancel and suspend an activity offering so that it will no longer be offered, and reinstate it so that it will be offered.

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: CO 21.1 CSR Cancel Activity Offerings in various states
    Given I manage a course offering with offered and canceled activity offerings present
    When I select the first activity offering in Draft status
    Then the Cancel button is "enabled"
    When I cancel the activity offering
    Then the first Draft activity offering is shown as canceled
    When I select an activity offering to work with in Offered status
    Then the Cancel button is "enabled"
    When I cancel the activity offering
    Then the Offered activity offering is shown as canceled
    When I select an activity offering to work with in Canceled status
    Then the Cancel button is "disabled"
    When I select the second activity offering in Draft status
    Then the Cancel button is "enabled"
    When I cancel the activity offering, verifying that one of the two selections is eligible for this action
    Then the second Draft activity offering is shown as canceled
    And the registration group is shown as canceled
    And the Course Offering is shown as Canceled
    And the Course Offering is no longer shown in the Schedule of Classes

  Scenario: CO 21.1 CSR Cancel a suspended Activity Offering
    Given I manage a course offering with a suspended activity offering present
    When I select an activity offering to work with in Suspended status
    Then the Cancel button is "enabled"
    When I cancel the activity offering
    Then the Suspended activity offering is shown as canceled
    And actual delivery logistics for the Suspended activity offering are no longer shown
    And the Suspended activity offering is no longer shown in the Schedule of Classes

  Scenario: CO 21.1 CSR Cancel an approved Activity Offering
    Given I manage a course offering with an approved activity offering present
    When I select an activity offering to work with in Approved status
    Then the Cancel button is "enabled"
    When I cancel the activity offering
    Then the Approved activity offering is shown as canceled
    And actual delivery logistics for the Approved activity offering are no longer shown

  Scenario: CO 21.1 CSR Cancel offered Activity Offering that is the only AO for the CO
    Given I manage a course offering with an offered activity offering present
    When I select the activity offering, which is in Offered status
    Then the Cancel button is "enabled"
    When I cancel the activity offering
    Then the Offered activity offering is displayed as canceled

  Scenario: CO 22.1 CSR Check Suspend button based on SOC state
    Given I manage a course offering with a draft activity offering present in a draft SOC state
    When I select the activity offering, which is in Draft status
    Then the Suspend button is "disabled"
    Then I deselect the activity offering, which is in Draft status
    Given I manage a course offering with a draft activity offering present in an open SOC state
    When I select the activity offering, which is in a Draft status
    Then the Suspend button is "disabled"
    Then I deselect the activity offering, which is in a Draft status
    Given I manage a course offering with an approved activity offering present in a locked SOC state
    When I select the activity offering, which is in Approved status
    Then the Suspend button is "enabled"
    Then I deselect the activity offering, which is in Approved status

#  Scenario: CO 22.1  BSCI421 in 201208  this one has problems because uses the same ref. data as a Cancel test (and gets changed)

  Scenario: CO 22.1 CSR Suspend approved Activity Offering with ADLs
    Given I manage a course offering with an approved activity offering present in a final edits SOC state
    When I select the activity offering, which is in approved status
    Then the Suspend button is "enabled"
    When I suspend the activity offering
    Then a suspended success message is displayed
    Then the Approved activity offering is displayed as suspended
    And actual delivery logistics for the Approved activity offering are still shown

  Scenario: CO 22.1 CSR Suspend Activity Offerings based on AO state and SOC state
    Given I manage a course offering with a canceled activity offering present
    When I select an activity offering that is in Canceled status
    Then the Suspend button is "disabled"
    Then I deselect Canceled activity offering

  Scenario: CO 23.1 CSR Reinstate button active only for canceled/suspended AOs
    Given I manage a course offering with canceled and offered activity offerings present
    When I select the Canceled activity offering
    Then the Reinstate button is "enabled"
    Then I deselect the Canceled activity offering
    When I select the Offered activity offering
    Then the Reinstate button is "disabled"
    Then I deselect the Offered activity offering

  Scenario: CO 23.1 CSR Reinstate is possible in any SOC state
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

  Scenario: CO 23.1 CSR Reinstate a canceled AO
    Given I manage a course offering with a canceled activity offering present in draft SOC state
    When I select the activity offering, which is a Canceled status
    And I reinstate the activity offering
    Then the Canceled activity offering is shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending
    And the Course Offering is shown as Draft

  #moved this up one compared to the order in the user story, because the test data works out better
  Scenario: CO 23.1 CSR Reinstate canceled AO with multiple AOs selected, but only one is canceled
    Given I manage a course offering with canceled and draft activity offerings present in draft SOC state
    When I select the Canceled and Draft activity offerings
    And I reinstate the activity offering, verifying that one of the two selections is eligible for this action
    Then the Canceled and Draft activity offerings are both shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the Canceled activity offerings
    And registration group is shown as pending

  Scenario: CO 23.1 CSR Reinstate multiple canceled AOs
    Given I manage a course offering with multiple canceled activity offerings present in draft SOC state
    When I select the Canceled activity offerings
    And I reinstate the activity offering
    Then the Canceled activity offerings are shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for both activity offerings
    And registration group is shown as pending

  Scenario: CO 23.3 CSR Reinstate button active only for suspended/canceled AOs
    Given I manage a course offering with suspended activity offering present
    When I select the Suspended activity offering
    Then the Reinstate button is "enabled"
    Then I deselect the Suspended activity offering

  Scenario: CO 23.3 CSR Reinstate is possible for suspended AOs with ADLs in several SOC states
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

  Scenario: CO 23.3 for Scenario 8a CSR Reinstate an AO with ADLs that is the only AO in the CO in published SOC state
    Given I manage a course offering with a suspended activity offering present in a published SOC state
    When I select activity offering, which is Suspended
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as offered
    And actual delivery logistics for the Suspended activity offering are still shown
    And the registration group is shown as offered
    And the Course Offering is shown as Offered

  Scenario: CO 23.3 for Scenario 9a CSR Reinstate an AO with ADLs in final edits SOC state
    Given I manage a course offering with a suspended activity offering present in a final edits SOC state
    When I select the activity offering, which is Suspended
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as approved
    And actual delivery logistics for the Suspended activity offering are still shown
    And the registration group is shown as pending
    And the Course Offering is shown as Planned

  Scenario: CO 23.3 for Scenario 5a CSR Reinstate an AO with ADLs in locked SOC state
    Given I manage a course offering with a suspended activity offering present in a locked SOC state
    When I select this activity offering, which is Suspended
    And I reinstate the activity offering
    Then this Suspended activity offering is shown as approved
    And actual delivery logistics for the Suspended activity offering are still shown
    And registration group is shown as pending
    And the Course Offering is now shown as Planned

  Scenario: CO 23.3 CSR for Scenario 6a Reinstate multiple suspended AOs in published SOC state
    Given I manage a course offering with multiple suspended activity offerings present in a published SOC state
    When I select the Suspended activity offerings
    And I reinstate the activity offering
    Then the Suspended activity offerings are shown as offered
    And actual delivery logistics for the Suspended activity offering are still shown
    And actual delivery logistics for the second Suspended activity offering are still shown
    And both registration groups are shown as offered

  Scenario: CO 23.3 for Scenario 7a CSR Reinstate suspended and offered AOs in published SOC state
    Given I manage a course offering with suspended and offered activity offerings present in a published SOC state
    When I select the Suspended and Offered activity offerings
    And I reinstate the activity offering, verifying that one of the two selections is eligible for this action
    Then the Suspended and Offered activity offerings are both shown as offered
    And actual delivery logistics for the Suspended activity offering are still shown
    And actual delivery logistics for the Offered activity offering are still shown

  Scenario: CO 23.3 for Scenario 1b CSR Reinstate suspended AO with RDLs in published SOC state
    Given I manage a course offering with one suspended activity offering present in a published SOC state
    When I select activity offering, which is Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the second activity offering
    And the second registration group is shown as pending

  Scenario: CO 23.3 for Scenario 2b CSR Reinstate an AO with RDLs in final edits SOC state
    Given I manage a course offering with suspended activity offering present in a final edits SOC state
    When I select activity offering, which is in Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the fourth activity offering
    And the fourth registration group is shown as pending

  Scenario: CO 23.3 CSR for Scenario 3b Reinstate an AO with RDLs in locked SOC state
    Given I manage a course offering with suspended activity offering present in a locked SOC state
    When I select activity offering, which is in a Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown as a draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending

  Scenario: CO 23.3 CSR for Scenario 4b Reinstate multiple suspended AOs with RDLs in published SOC state
    Given I manage a course offering with two suspended activity offerings present in a published SOC state
    When I select both Suspended activity offerings
    And I reinstate the activity offering
    Then both Suspended activity offerings are shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the second activity offering
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the third activity offering
    And the second registration group is shown as pending
    And the third registration group is shown as pending

  Scenario: CO 23.3 CSR for Scenario 5b Reinstate suspended and draft AOs with RDLs in published SOC state
    Given I manage a course offering with a suspended and a draft activity offering present in a published SOC state
    When I select the suspended and draft activity offerings
    And I reinstate the activity offering, verifying that one of the two selections is eligible for this action
    Then the Suspended activity offering is shown as draft and the draft activity offering is shown as draft
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the second activity offering

  Scenario: CO 23.3 CSR for Scenario 6b Reinstate a single AO with RDLs in published SOC state
    Given I manage a course offering with a single suspended activity offering present in a published SOC state
    When I select the activity offering, which is in Suspended status
    And I reinstate the activity offering
    Then the Suspended activity offering is shown in draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending
    And the Course Offering is now shown as Draft

  Scenario: CO 23.3 CSR for Scenario 7b Reinstate a single AO with RDLs in final edits SOC state
    Given I manage a course offering with a single suspended activity offering present in a final edits SOC state
    When I select the only activity offering, which is in Suspended status
    And I reinstate the activity offering
    Then the only Suspended activity offering is shown in draft status
    And requested delivery logistics are still shown and actual delivery logistics are not shown for the activity offering
    And registration group is shown as pending
    And the Course Offering is now shown as Draft status

