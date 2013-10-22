@nightly
Feature: WC.Edit AO delivery logistics

  As a schedule coordinator, I want to edit the requested delivery logistics of an AO
  and then confirm that those changes have been persisted

  Background:
    Given I am logged in as a Schedule Coordinator
    And I am editing an AO with RDLs

  #fix for intelligent time entry
  @pending
  Scenario: Revise an AO's requested delivery logistics
    When I revise an AO's requested delivery logistics
    Then the AO's delivery logistics shows the new schedule

  #fix for intelligent time entry
  @pending
  Scenario: Add RDLs for an AO
    When I add RDLs for an AO
    Then the AO's delivery logistics shows the new schedule

  #fix for intelligent time entry
  @pending
  Scenario: Add an RDL using incomplete logistics - times only
    When I add RDLs for an AO specifying times only
    Then the AO's delivery logistics shows the new schedule

  #fix for intelligent time entry
  @pending
  Scenario: Add an RDL using incomplete logistics - times and facility
    When I add RDLs for an AO specifying times and facility only
    Then the AO's delivery logistics shows the new schedule

  #fix for intelligent time entry
  @pending
  Scenario: Add an RDL using incomplete logistics - times and room
    When I add RDLs for an AO specifying times and room only
    Then an error message is displayed about the required RDL fields

  #fix for intelligent time entry
  @pending
  Scenario: Add TBA RDLs for an AO
    When I add RDLs for an AO checking the TBA flag
    Then the AO's delivery logistics shows the new schedule as TBA

  #fix for intelligent time entry
  @pending
  Scenario: Delete RDLs for an AO
    When I add RDLs for an AO
    And I delete the original RDLs
    Then the AO's delivery logistics shows the new schedule

  #KSENROLL-10147
  @pending
  Scenario: Add standard RDLs for an AO
    When I add standard RDLs for an AO
    Then the AO's delivery logistics shows the new schedule

  #KSENROLL-10147
  @pending
  Scenario: Add ad hoc RDLs for an AO
    When I add ad hoc RDLs for an AO
    Then the AO's delivery logistics shows the new schedule

