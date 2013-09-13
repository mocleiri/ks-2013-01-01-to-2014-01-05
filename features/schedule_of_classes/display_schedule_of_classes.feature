@nightly
Feature: WC.Schedule of Classes

  As an Admin I want to display a published schedule of classes for a specific term in order to
  understand the courses being offered, including both descriptive and scheduling info

  Background:
    Given I am logged in as a Schedule Coordinator
    And I am using the schedule of classes page

  Scenario: Successfully display schedule of classes by subject code and display individual course details
    When I search for course offerings by course by entering a subject code
    Then a list of course offerings with that subject code is displayed
    And the course offering details for a particular offering can be shown

  Scenario: CO 26.9 Successfully display schedule of classes by subject code and display subterm information
    When I search for a course offering that has activity offerings assigned to subterms by course code
    And the course offering details for a particular offering can be shown
    And the subterm icon appears with the subterm information

  Scenario: Successfully display schedule of classes for a particular course and display course details
    When I search for course offerings by course by entering a course offering code
    Then a list of course offerings with that course offering code is displayed
    And the course offering details for a particular offering can be shown

  Scenario: Successfully display schedule of classes for a particular instructor and display course details
    When I search for course offerings by instructor
    Then a list of course offerings with activity offerings with that instructor is displayed

  Scenario: Successfully display schedule of classes for a particular department and display course details
    When I search for course offerings by department
    Then a list of course offerings for that department is displayed
    And the course offering details for a particular offering can be shown

  Scenario: Successfully display schedule of classes for a particular keyword for a course title or description search
    When I search for course offerings by title and department by entering a keyword
    Then a list of course offerings with that keyword is displayed
    And the course offering details for a particular offering can be shown

#KSENROLL-9414
  @draft
  Scenario: Confirm requisites' natural language for a particular course is displayed correctly
    When I search for course offerings by course by entering a course offering code to view the course offering requisites
    Then the course offering requisites should be displayed stating "Student Eligibility & Prerequisite.*Two lower-level English courses.*Or permission of ARHU-English.*Antirequisite.*any courses from ENGL403 or ENGL404"

# Scenario: Verify that an appropriate message is displayed if no data is returned by the search
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Course
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Department
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Instructor
#  Scenario: Verify that an appropriate message is displayed if no criteria is entered for search by Title & Description