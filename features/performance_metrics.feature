@performance
Feature: Performance.Metrics

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Login
    When I log in as a Schedule Coordinator
    Then the transaction takes less than "3" seconds

  Scenario: Academic Calendar Search and Edit
    When I search for an Academic Calendar
    Then the transaction takes less than "3" seconds
    And  I edit the Academic Calendar
    Then the transaction takes less than "3" seconds
    And  I update a field and save the Academic Calendar
    Then the transaction takes less than "3" seconds

  Scenario: Academic Calendar Create
    When I start a blank Academic Calendar
    Then the transaction takes less than "3" seconds
    And I create a new Academic Calendar
    Then the transaction takes less than "3" seconds

  Scenario: Holiday Calendar Search and Edit
    When I search for an Holiday Calendar
    Then the transaction takes less than "3" seconds
    And  I edit the Holiday Calendar
    Then the transaction takes less than "3" seconds
    And  I update a field and save the Holiday Calendar
    Then the transaction takes less than "3" seconds

  Scenario: Holiday Calendar Create
    When I start a blank Holiday Calendar
    And I create a new Holiday Calendar
    Then the transaction takes less than "3" seconds

   Scenario: Population Search and Edit
     When  I search for an existing population
     Then the transaction takes less than "3" seconds
     And I edit the population
     Then the transaction takes less than "3" seconds
     And  I update a field and save the population
     Then the transaction takes less than "3" seconds

   Scenario: Population Create
     When I create a new populations
     Then the transaction takes less than "3" seconds
     And I save the population
     Then the transaction takes less than "3" seconds

  Scenario: Registration Windows Search and Edit
    When I search for a registration Window
    Then the transaction takes less than "3" seconds
    And I select all registration periods
    Then the transaction takes less than "3" seconds
    And I add a registration window and save
    Then the transaction takes less than "3" seconds

  Scenario: Search Course Offering by Subject 100+
    When I search for a course by the "ENGL" subject code
    Then the transaction takes less than "3" seconds

  Scenario: Search Course Offering by Subject 50-100
    When I search for a course by the "BSCI" subject code
    Then the transaction takes less than "3" seconds

  Scenario: Search Course Offering by Course and edit
    When I search for a course by course code
    Then the transaction takes less than "3" seconds
    And I edit the course offering for performance
    Then the transaction takes less than "3" seconds
    And I save the course change
    Then the transaction takes less than "3" seconds

  Scenario: Create Course Offering
    When I create a basic course offering
    Then the transaction takes less than "3" seconds

  Scenario: Delete Course Offering
    When I search for a course by course code to delete
    And I delete the course offering
    Then the transaction takes less than "3" seconds

  Scenario: Copy Course Offering
    When I click copy for a course offering
    Then the transaction takes less than "3" seconds
    And I copy a course offering
    Then the transaction takes less than "3" seconds

  Scenario: Create a Jointly Defined Course Offering
    When I create a jointly defined course offering
    Then the transaction takes less than "3" seconds

  Scenario: Edit Activity Offering
    When I edit an Activity Offering for performance
    Then the transaction takes less than "3" seconds

  Scenario: Copy Activity Offering
    When I copy an Activity Offering for performance
    Then the transaction takes less than "3" seconds

  Scenario: Add Delivery Logistics
    When I add Delivery Logistics and save
    Then the transaction takes less than "3" seconds

  Scenario: Manage SOC
    When I search for a SOC
    Then the transaction takes less than "3" seconds

  Scenario: KRMS Requisites Manage Add Submit
    When I manage an AO's prerequisites
    Then the transaction takes less than "3" seconds
    And I add a rule to the Prerequisite section
    Then the transaction takes less than "3" seconds
    And then I submit the rule changes
    Then the transaction takes less than "3" seconds
    And I suppress a the new rule change
    Then the transaction takes less than "3" seconds
    And I revert the new rule change
    Then the transaction takes less than "3" seconds

  Scenario: Display Schedule of Classes
    When I search for a scheduled class
    Then the transaction takes less than "3" seconds
    When I view the detailed schedule of classes
    Then the transaction takes less than "3" seconds
