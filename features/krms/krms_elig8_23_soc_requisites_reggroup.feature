Feature: SA.ELIG8-23 Ensure that changes made to AO or CO Requisites displays differently on S0C Reg Group
  ELIG 8.23 : As a Central Administrator I want to have Rules display in the Schedule of Classes Registration Group
  View so that students are able to see whether or not they will qualify for enrolment in a course prior to trying
  to enrol

  Background:
    Given I am logged in as admin

  #ELIG8.22.EB1 (KSENROLL-10123)
  @pending
  Scenario: Test that suppressing the Corequisite rule for AO A only displays on the Schedule of Classes for the AO
    Given I suppress the rule in the Student Eligibilty & Prerequisite section
    And I am using the schedule of classes page
    When I search for course offerings by course in the CHEM subject group to view the registration group
    Then the course offering requisites should be displayed not stating "Prerequisite.*CHEM241 and CHEM242.*CHEM247.*A grade of C- or better"
    And Activity J in the Registration Group has Activity Offering Requisites displayed stating "Prerequisite.*CHEM241 and CHEM242.*CHEM247.*A grade of C- or better"

  #ELIG8.22.EB2 (KSENROLL-10123)
  @pending
  Scenario: Test that editing the Corequisite rule is displayed on the Schedule of Classes
    Given I edit the Corequisite section by adding a new text statement
    And I am using the schedule of classes page
    When I search for course offerings by course in the CHEM subject group to view the registration group
    Then the course offering requisites should be displayed not stating "Corequisite.*CHEM271.*Changed the Corequisite on AO V only"
    And Activity C in the Registration Group has Activity Offering Requisites displayed stating "Corequisite.*CHEM271.*Changed the Corequisite on AO V only"

  #ELIG8.22.EB3 (KSENROLL-10123)
  @pending
  Scenario: Test that adding CO Requisites is displayed on the Schedule of Classes
    Given I add a new text statement to the Antirequisite section
    And I am using the schedule of classes page
    When I search for course offerings by course in the CHEM subject group to view the registration group
    Then the course offering requisites should be displayed stating "Antirequisite.*Added Antirequisite on CO level"
    And Activity J in the Registration Group has Activity Offering Requisites displayed not stating "Antirequisite.*Added Antirequisite on CO level"
