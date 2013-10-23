Feature: SA.ELIG8-22 Ensure that changes made to AO or CO Requisites displays differently on Schedule of Classes
  ELIG 8.22 : As a Central Administrator I want to have Rules display in the Schedule of Classes Cluster View so
  that students are able to see whether or not they will qualify for enrolment in a course prior to trying to enrol

  Background:
    Given I am logged in as admin

  #ELIG8.22.EB1 (KSENROLL-10123)
  @pending
  Scenario: Test that suppressing the Corequisite rule for AO A only displays on the Schedule of Classes for the AO
    Given I suppress the rule in the Student Eligibilty & Prerequisite section
    And I am using the schedule of classes page
    When I search for course offerings by course in the CHEM subject group to view the course offering requisites
    Then the course offering requisites should be displayed not stating "Corequisite.*CHEM271"
    And the Activity L of the Course Offering has Activity Offering Requisites displayed stating "Corequisite.*CHEM271"

  #ELIG8.22.EB2 (KSENROLL-10123)
  @pending
  Scenario: Test that editing the Corequisite rule is displayed on the Schedule of Classes
    Given I edit the Corequisite section by adding a new text statement
    And I am using the schedule of classes page
    When I search for course offerings by course in the CHEM subject group to view the course offering requisites
    Then the course offering requisites should be displayed not stating "Changed the Corequisite on AO V only"
    And the Activity C of the Course Offering has Activity Offering Requisites displayed stating "Changed the Corequisite on AO V only"

  #ELIG8.22.EB3 (KSENROLL-10123)
  @pending
  Scenario: Test that adding CO Requisites is displayed on the Schedule of Classes
    Given I add a new text statement to the Antirequisite section
    And I am using the schedule of classes page
    When I search for course offerings by course in the CHEM subject group to view the course offering requisites
    Then the course offering requisites should be displayed stating "Added Antirequisite on CO level"
    And the Activity A of the Course Offering has Activity Offering Requisites displayed not stating "Added Antirequisite on CO level"
