@data_setup
Feature: Setup Environment

  Setup required data for test run

  Background:
    Given I am logged in as admin

#  Scenario: Successfully rollover courses to put target term in open state
#    When I initiate a rollover to create a term in open state
#    Then the results of the rollover are available
#    And the rollover can be released to departments

  @wip
  Scenario: Set up a term in closed state
    When I initiate a rollover to create a term in closed state EC
    Then the results of the rollover are available
    And the rollover can be released to departments
    And I approve the "CHEM" subject code for scheduling in the target term
    And I approve the "ENGL" subject code for scheduling in the target term
    And I manage SOC for the target term
    Given the SOC is valid for "Lock"
    When I "Lock" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Schedule" button is there for next action
    Given the SOC is valid for "Schedule"
    When I "Schedule" the SOC and press "Yes" on the confirm dialog
    Then I verify that "FinalEdit" button is there for next action
    And I verify the related object state changes for "Schedule" action
    Given the SOC is valid for "FinalEdit"
    When I "FinalEdit" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Publish" button is there for next action
    Given the SOC is valid for "Publish"
    When I "Publish" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Close" button is there for next action
    And I verify the related object state changes for "Publish" action

  Scenario: Set up a term in published state
    When I initiate a rollover to create a term in published state EC
    Then the results of the rollover are available
    And the rollover can be released to departments
    And I approve the "CHEM" subject code for scheduling in the target term
    And I approve the "ENGL" subject code for scheduling in the target term
    And I manage SOC for the target term
    Given the SOC is valid for "Lock"
    When I "Lock" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Schedule" button is there for next action
    Given the SOC is valid for "Schedule"
    When I "Schedule" the SOC and press "Yes" on the confirm dialog
    Then I verify that "FinalEdit" button is there for next action
    And I verify the related object state changes for "Schedule" action
    Given the SOC is valid for "FinalEdit"
    When I "FinalEdit" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Publish" button is there for next action
    Given the SOC is valid for "Publish"
    When I "Publish" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Close" button is there for next action
    And I verify the related object state changes for "Publish" action

  Scenario: Set up a term in final edits state
    When I initiate a rollover to create a term in final edits state EC
    Then the results of the rollover are available
    And the rollover can be released to departments
    And I approve the "CHEM" subject code for scheduling in the target term
    And I approve the "ENGL" subject code for scheduling in the target term
    And I manage SOC for the target term
    Given the SOC is valid for "Lock"
    When I "Lock" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Schedule" button is there for next action
    Given the SOC is valid for "Schedule"
    When I "Schedule" the SOC and press "Yes" on the confirm dialog
    Then I verify that "FinalEdit" button is there for next action
    And I verify the related object state changes for "Schedule" action
    Given the SOC is valid for "FinalEdit"
    When I "FinalEdit" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Publish" button is there for next action

  Scenario: Set up a term in locked state
    When I initiate a rollover to create a term in locked state EC
    Then the results of the rollover are available
    And the rollover can be released to departments
    And I approve the "CHEM" subject code for scheduling in the target term
    And I approve the "ENGL" subject code for scheduling in the target term
    And I manage SOC for the target term
    Given the SOC is valid for "Lock"
    When I "Lock" the SOC and press "Yes" on the confirm dialog
    Then I verify that "Schedule" button is there for next action

  Scenario: Set up a term in open state
    When I initiate a rollover to create a term in open state EC
    Then the results of the rollover are available
    And the rollover can be released to departments

  Scenario: Set up a term in draft state
    When I initiate a rollover to create a term in default state EC
    Then the results of the rollover are available
