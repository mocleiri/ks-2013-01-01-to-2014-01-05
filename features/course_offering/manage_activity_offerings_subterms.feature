@wip
Feature: EC.Manage Activity Offerings - subterms

  CO 26 - As a Departmental administrator, I want to be able to manage AOs in subterms

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: CO 26.1 Successfully change the subterm for an AO
    Given I edit an Activity Offering that has available subterms
    When I set a subterm for the activity offering
    Then the AO subterm change is successful
    When I update the subterm for the activity offering
    Then the AO subterm change is successful
    When I remove the subterm for the activity offering
    Then the AO subterm is successfully removed

  Scenario: CO 26.8A Successfully copy an AO attached to a subterm
    Given I edit an Activity Offering that has available subterms
    And I set a subterm for the activity offering
    When I copy the activity offering
    Then the AO subterm indicator is successfully copied

