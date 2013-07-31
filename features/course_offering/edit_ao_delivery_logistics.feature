@nightly
Feature: WC.Edit AO delivery logistics

  As a schedule coordinator, I want to edit the requested delivery logistics of an AO
  and then confirm that those changes have been persisted

  Background:
    Given I am logged in as a Schedule Coordinator
    And I am editing an AO with RDLs

  Scenario: Revise an AO's requested delivery logistics
    When I revise an AO's requested delivery logistics
    Then the AO's delivery logistics shows the new schedule

#KSENROLL-8080
  @pending
  Scenario: Add RDLs for an AO
    When I add RDLs for an AO
    Then the AO's delivery logistics shows the new schedule

#KSENROLL-8080
  @pending
  Scenario: Add TBA RDLs for an AO
    When I add RDLs for an AO checking the TBA flag
    Then the AO's delivery logistics shows the new schedule as TBA

#KSENROLL-8080
  @pending
  Scenario: Delete RDLs for an AO
    When I add RDLs for an AO
    And I delete the original RDLs
    Then the AO's delivery logistics shows the new schedule
