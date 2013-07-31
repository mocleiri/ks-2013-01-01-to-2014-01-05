@wip
Feature: EC.AZ Manage Course Offerings with subterms

  CO 26.6: As an administrator I want authorization applied to AOs associated with sub terms

  Background:
    Given I am logged in as a Schedule Coordinator
    And I create an Academic Calendar with subterms
    And I make the subterms official
    And I create a Course Offering from catalog with Activity Offerings assigned to subterms
    And I rollover the subterms' parent term to a target term with those subterms setup

  Scenario: CO 26.6A Carol has access to add/remove/update the subterm for an AO (in admin org) when SOC=OPEN
    And I approve the Course Offering for scheduling in the target term
    #When I advance the SOC state from open to published state

  Scenario: CO 26.6B Carol has access to add/remove/update the subterm for an AO (in admin org) when SOC=FINAL EDITS

  Scenario: CO 26.6C Carol does not have access to add/remove/update the subterm for an AO (in admin org) when SOC=PUBLISHED

