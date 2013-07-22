@wip
Feature: EC.Subterms CRED

  S16: Ability to manage academic subterms within academic calendars and terms

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: CAL 4.2A Successfully create a subterm in an Academic calendar
    Given I create an Academic Calendar that supports subterms
    When I add a subterm
    Then the subterm is listed when I view the Academic Calendar

  Scenario: CAL 4.1 Successfully copy an Academic Calendar with subterms
    Given I create Academic Calendar with subterms
    When I copy the Academic Calendar
    Then the subterms are successfully copied

  Scenario: CAL 4.2B Successfully search for and view and subterm
    Given I create Academic Calendar with subterms
    Then I can search and view the subterm in read only mode

  Scenario: CAL 4.3 Successfully edit a subterm
    Given I create Academic Calendar with subterms
    When I edit the subterm information
    Then the subterm in updated successfully

  Scenario: CAL 4.10 Successfully delete a subterm
    Given I create Academic Calendar with subterms
    When I delete a subterm
    Then the subterm is no longer listed on the calendar

   @draft
  Scenario: CAL 4.7 Successfully verify the instruction dates calculation for a subterm
    Given I create an Academic Calendar
    And I add a new subterm to the Academic Calendar with a defined instructional period
    Then the instructional days calculation is correct
    When I add a Holiday Calendar with holidays in the term
    Then the instructional days calculation is correct