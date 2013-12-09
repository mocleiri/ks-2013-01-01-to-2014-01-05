@nightly @green_team
Feature: WC.Edit AO delivery logistics for "Needs Approval" institutional configuration

  As a schedule coordinator or department schedule coordinator, I want to edit the requested delivery
  logistics of an AO and then confirm that those changes are saved

  #CO 20.2 (KSENROLL-10318)
  @draft
  Scenario: Set non-standard TS approval flag
    Given I am logged in as a Schedule Coordinator
    And I am editing an AO with RDLs
    When I check the "approved for non-standard time slots" flag
    Then the "approved for non-standard time slots" flag is set

  #CO 20.2 (KSENROLL-10318)
  @draft
  Scenario: As DSC, add schedule request with non-std time slots not allowed
    Given I am logged in as a Department Schedule Coordinator
    And I am editing an AO with RDLs in an open term
    When I add RDLs for an AO as a DSC
    Then the AO's delivery logistics shows the new schedule

  #CO 20.2 (KSENROLL-10318)
  @draft
  Scenario: As DSC, add schedule request with non-std time slots allowed
    Given I am logged in as a Schedule Coordinator
    And I am editing an AO with RDLs in an open term
    Then I check the "approved for non-standard time slots" flag
    Given I am logged in as a Department Schedule Coordinator
    And I edit the Activity Offering with non-standard time slots approved
    When I add non-standard RDLs for an AO
    Then the AO's delivery logistics shows the new schedule

