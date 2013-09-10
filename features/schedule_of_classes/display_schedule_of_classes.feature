@nightly
Feature: WC.Schedule of Classes

  As an Admin I want to display a published schedule of classes for a specific term in order to
  understand the courses being offered, including both descriptive and scheduling info

  Background:
    Given I am logged in as a Schedule Coordinator
#    And I am using the schedule of classes page

#KSENROLL-8584
  @pending
  Scenario: Successfully display schedule of classes by subject code and display individual course details
    Given I am using the schedule of classes page
    When I search for course offerings by course by entering a subject code
    Then a list of course offerings with that subject code is displayed
    And the course offering details for a particular offering can be shown

#KSENROLL-8584
  @pending
  Scenario: CO 26.9 Successfully display schedule of classes by subject code and display subterm information
    Given I am using the schedule of classes page
    When I search for a course offering that has activity offerings assigned to subterms by course code
    And the course offering details for a particular offering can be shown
    And the subterm icon appears with the subterm information

#KSENROLL-8584
  @pending
  Scenario: Successfully display schedule of classes for a particular course and display course details
    Given I am using the schedule of classes page
    When I search for course offerings by course by entering a course offering code
    Then a list of course offerings with that course offering code is displayed
    And the course offering details for a particular offering can be shown

#KSENROLL-8584
  @pending
  Scenario: Successfully display schedule of classes for a particular instructor and display course details
    Given I am using the schedule of classes page
    When I search for course offerings by instructor
    Then a list of course offerings with activity offerings with that instructor is displayed

#KSENROLL-8584
  @pending
  Scenario: Successfully display schedule of classes for a particular department and display course details
    Given I am using the schedule of classes page
    When I search for course offerings by department
    Then a list of course offerings for that department is displayed
    And the course offering details for a particular offering can be shown

#KSENROLL-8584
  @pending
  Scenario: Successfully display schedule of classes for a particular keyword for a course title or description search
    Given I am using the schedule of classes page
    When I search for course offerings by title and department by entering a keyword
    Then a list of course offerings with that keyword is displayed
    And the course offering details for a particular offering can be shown

#KSENROLL-8584
  @pending
  Scenario: Display schedule of classes for a particular course and verify that AO clusters are displayed
    Given I am using the schedule of classes page
    When I search for course offerings by course by entering a course offering code
    Then a list of course offerings with that course offering code is displayed
    And the course offering details displays a listing of AO clusters

#KSENROLL-9199
  @pending
  Scenario: Display schedule of classes for a particular course and verify that registration groups are displayed
    Given I am using the schedule of classes page
    When I search for course offerings by course by entering a course offering code
    Then a list of course offerings with that course offering code is displayed
    And the course offering details displays a listing of registration groups

#KSENROLL-9346
  @pending
  Scenario: Ensure that only courses in offered state are displayed in AO Cluster rendering
    When I add an Activity Offering in draft status to an existing Course Offering
    And I am using the schedule of classes page
    And I search for the Course Offering in the schedule of classes
    Then the added Activity Offering is not displayed in the expanded listing rendered by AO Cluster

#KSENROLL-9347
  @pending
#  Scenario: Ensure that only courses in offered state are displayed in Registration Group rendering
#    When I add an Activity Offering in draft status to an existing Course Offering
#    And I am using the schedule of classes page
#    And I search for the Course Offering in the schedule of classes
#    Then the added Activity Offering is not displayed in the expanded listing rendered by Registration Group

# Scenario: Verify that an appropriate message is displayed if no data is returned by the search
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Course
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Department
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Instructor
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Title & Description