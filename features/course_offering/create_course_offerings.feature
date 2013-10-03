@nightly
Feature: EC.Create Course Offerings
Background:
  Given I am logged in as a Schedule Coordinator

  Scenario: Create Course Offerings with random delivery formats
    When I create a Course Offering with random Delivery Formats
    Then the new Course Offering should contain only the selected delivery formats

  Scenario: Create Course Offerings with lecture delivery formats
    When I create a Course Offering with "selected lecture" delivery Formats
    Then the new Course Offering should contain only the selected delivery formats

  Scenario: Create Course Offerings with 2 delivery formats
    When I create a Course Offering with "2" delivery Formats
    Then the new Course Offering should contain only the selected delivery formats

  Scenario: Copy existing Course Offering
    When I copy a course offering from an existing offering
    Then the new Course Offering should be displayed in the list of available offerings

  Scenario: Copy existing Course Offering excluding instructor information
    When I copy a course offering from an existing offering and choose to exclude instructor information
    Then the new Course Offering should be displayed in the list of available offerings
    And the new Course Offering should not contain any instructor information in its activity offerings
