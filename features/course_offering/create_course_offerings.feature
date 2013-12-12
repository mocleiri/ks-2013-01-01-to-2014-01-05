@nightly @red_team
Feature: EC.Create Course Offerings
Background:
  Given I am logged in as a Schedule Coordinator

  @smoke_test
  Scenario: Create Course Offerings with random delivery formats
    When I create a Course Offering with random Delivery Formats
    Then the new Course Offering should contain only the selected delivery formats

  Scenario: Create Course Offerings with lecture delivery formats
    When I create a Course Offering with "selected lecture" delivery Formats
    Then the new Course Offering should contain only the selected delivery formats

  Scenario: Create Course Offerings with 2 delivery formats
    When I create a Course Offering with "2" delivery Formats
    Then the new Course Offering should contain only the selected delivery formats

  @smoke_test
  Scenario: CO 6.1 Create Course Offering from existing Course Offering
    When I create a course offering from an existing offering
    Then the new Course Offering should be displayed in the list of available offerings

  Scenario: CO 6.2A Create Course Offering from existing Course Offering in different term excluding instructor information
    When I create a course offering from an existing offering in a different term and choose to exclude instructor information
    Then the new Course Offering should be displayed in the list of available offerings
    And the new Course Offering should not contain any instructor information in its activity offerings

  @draft
  Scenario: CO 6.2B Create Course Offering from existing Course Offering within same term excluding instructor information
    When I create a course offering from an existing offering within same term and choose to exclude instructor information
    Then the new Course Offering should be displayed in the list of available offerings
    And the new Course Offering should not contain any instructor information in its activity offerings
