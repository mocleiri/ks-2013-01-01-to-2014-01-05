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

  Scenario: CO 26.8B Successfully copy a CO with an AO attached to a subterm
    Given I edit an Activity Offering that has available subterms
    And I set a subterm for the activity offering
    When I copy the parent course offering
    Then the AO subterm indicator is successfully copied with the parent CO

  Scenario: CO 26.8C Successfully copy an existing Course Offering which has an AO attached to a subterm
    Given I create an Academic Calendar with subterms
    And I make the subterms official
    And I setup the SOC for for the parent term
    And I create a Course Offering with an Activity Offerings assigned to subterms
#    #Then the new Course Offering should be displayed in the list of available offerings.

  Scenario: CO 26.4A Successfully rollover a term where a Course Offering has AOs attached to subterms
    Given I create an Academic Calendar with subterms
    And I make the subterms official
    And I create a Course Offering with an Activity Offerings assigned to subterms
    When I rollover the subterms' parent term to a target term with those subterms setup
    Then the Activity Offerings are assigned to the target subterms
