Feature: SA.ELIG8-18 View changes made to AO or CO Requisites on Schedule of Classes
  ELIG 8.18 : As a Central Administrator I want to have Rules display in the Schedule of Classes so that students are
  able to see whether or not they will qualify for enrolment in a course prior to trying to enrol

  Background:
    Given I am logged in as admin

  #ELIG8.18.EB1 (KSENROLL-9795)
  @pending
  Scenario: Test that the Schedule of Classes shows the ref data when no changes are made to the CO Requisites
    Given I am using the schedule of classes page
    When I search for course offerings by course to view the course offering requisites
    Then the course offering requisites should be displayed stating "Prerequisite.*1 course from PHYS161 or PHYS171.*BSCI399.*Corequisite.*ENGL101 and HIST106"

  #ELIG8.18.EB2 (KSENROLL-9795)
  @pending
  Scenario: Test that adding an AO Requisite will add detail to the SoC AO table
    Given I add a text rule to the Antirequisite section
    And I am using the schedule of classes page
    When I search for course offerings by course to view the course offering requisites
    Then the Activity A of the Course Offering has Activity Offering Requisites displayed stating "Antirequisite.*Add Antirequisite specific to AO A"

  #ELIG8.18.EB3 (KSENROLL-9795)
  @pending
  Scenario: Test that suppressing the Corequisite rule for AO A is displayed on the Schedule of Classes
    Given I suppress the rule in the Corequisite section
    And I am using the schedule of classes page
    When I search for course offerings by course to view the course offering requisites
    Then the course offering requisites should be displayed stating "Prerequisite.*1 course from PHYS161 or PHYS171.*BSCI399"
    And the Activity A of the Course Offering has Activity Offering Requisites displayed stating "Corequisite:"
    And the Activity B of the Course Offering has Activity Offering Requisites displayed stating "Corequisite.*ENGL101 and HIST106"

  #ELIG8.18.EB4 (KSENROLL-9795)
  @pending
  Scenario: Test that editing the SE & Prerequisite rule is displayed on the Schedule of Classes
    Given I edit the Prerequisite section by adding a new text statement
    And I am using the schedule of classes page
    When I search for course offerings by course to view the course offering requisites
    And the Activity A of the Course Offering has Activity Offering Requisites displayed stating "Prerequisite.*1 course from PHYS161 or PHYS171.*BSCI399"
    And the Activity B of the Course Offering has Activity Offering Requisites displayed stating "Corequisite.*ENGL101 and HIST106.*Prerequisite.*1 course from PHYS161 or PHYS171.*And BSCI399.*And Changed the SE & Prerequisite on AO B only"

  #ELIG8.18.EB5 (KSENROLL-9795)
  @pending
  Scenario: Test that adding CO Requisites is displayed on the Schedule of Classes
    Given I add a new text statement to the Recommended Preparation section
    And I am using the schedule of classes page
    When I search for course offerings by course to view the course offering requisites
    Then the course offering requisites should be displayed stating "Recommended Preparation.*Added Recommended Prep on CO level"
