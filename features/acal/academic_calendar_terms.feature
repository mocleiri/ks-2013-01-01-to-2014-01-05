@wip
Feature: EC.Academic Calendar Terms
  CO 2.14

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Successfully create a new term for a new academic calendar
    Given I create an Academic Calendar
    When I add a new term to the Academic Calendar
    Then the term is listed when I view the Academic Calendar

  Scenario: Successfully create a new term for an academic calendar copy
    Given I copy an existing Academic Calendar
    When I add a new term to the Academic Calendar
    Then the term is listed when I view the Academic Calendar

  Scenario: Successfully edit term information for an academic calendar
    Given I copy an existing Academic Calendar
    When I edit the information for a term
    Then the updated term information is listed when I view the Academic Calendar

  Scenario: Successfully delete a term from a new academic calendar
    Given I create an Academic Calendar
    And I have added a new term to the Academic Calendar
    When I delete the term
    Then the term is not listed when I view the Academic Calendar

  Scenario: Make an academic term official
    Given I create an Academic Calendar in Official status
    And I have added a new term to the Academic Calendar
    When I make the term official
    Then the term is listed in official status when I view the Academic Calendar

  Scenario: Add a Key Date to an academic term
    Given I copy an existing Academic Calendar
    And I have added a new term to the Academic Calendar
    When I add an instructional Key Date
    Then the Key Date is listed with the academic term information

  Scenario: Modify a Key Date for an academic term
    Given I copy an existing Academic Calendar
    And I have added a new academic term with an instructional key date
    When I edit the instructional Key Date
    Then the updated Key Date is listed with the academic term information

  Scenario: Delete a Key Date for an academic term
    Given I copy an existing Academic Calendar
    And I have added a new academic term with an instructional key date
    When I delete an instructional Key Date
    Then the Key Date is not listed with the academic term information

  Scenario: Delete a Key Date Group for an academic term
    Given I copy an existing Academic Calendar
    And I have added a new academic term with an instructional key date group
    When I delete an instructional Key Date Group
    Then the Key Date Group is not listed with the academic term information

  Scenario: Copy a Key Dates for an academic term
    Given I copy an existing Academic Calendar that has instructional key dates
    Then the Key Dates are copied without date values

  Scenario: Verify instructional days calculation for an academic term
    Given I create an Academic Calendar with an academic term
    Then the instructional days calculation is correct
    When I add holidays within the term
    Then the instructional days calculation is correct

  @draft
  Scenario: debug terms page/data objects
    Given I debug the 2012-2013 Academic Calendar
    When I debug the Winter Term
    And I debug the key date groups
    And I debug the key dates
#  @draft
#  Scenario: Add a term to the academic calendar (acad calender must be official before can make term official)
#    When I add a spring term and save
#    Then I verify that the term added to the calendar
#    And Make Official button for the term is enabled
#
#  @draft
#  Scenario: Make Academic Term Official
#    When I add a winter term and save
#    And I make the term official
#    Then the term should be set to Official on edit
#
#  @draft
#  Scenario: Delete Draft Academic Term
#    When I add a summer term and save
#    And I delete the Academic Term draft
#    Then the term should not appear in search results
