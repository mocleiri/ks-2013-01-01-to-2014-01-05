@nightly
Feature: WC.Edit Course Offerings
  Background:
    Given I am logged in as a Schedule Coordinator

  #KSENROLL-1499
  Scenario: Verify course offering pages are accessible
    When I search course offerings by subject code
    Then I view the course offering details
    And I can edit the course offering
    And I can return to search using the cancel button

  #KSENROLL-1503.1
  Scenario: Edit an existing course offering deactivating final examinations and update the grade roster level
    When I edit a course offering with multiple format types
    And I select a final exam type of "No final exam or assessment"
    And I change the delivery format options
    Then I can submit and the course offering is updated

  #KSENROLL-1503.2
  Scenario: Edit an existing course offering activating final examinations and update the grade roster level
    When I edit a course offering with multiple format types
    And I select a final exam type of "Standard final Exam"
    And I change the delivery format options
    Then I can submit and the course offering is updated

#KSENROLL-8076
  @pending
  Scenario: Edit an existing course offering and add a delivery format line
    Given I edit a course offering with multiple delivery format types
    And I add a delivery format option
    Then I can submit and the delivery formats are updated

#KSENROLL-8076
  @pending
  Scenario: Edit an existing course offering and modify a delivery format line
    Given I edit a course offering with multiple delivery format types
    And I modify a delivery format option
    Then I can submit and the modified delivery formats are updated

#KSENROLL-8076
  @pending
  Scenario: Edit an existing course offering and delete a delivery format line
    Given I edit a course offering with multiple delivery format types
    And I add a delivery format option
    Then I can submit and the delivery formats are updated
    When I delete the added delivery format option
    Then I can submit and the added delivery format is not present

  #KSENROLL-1504
  Scenario: Edit an existing course offering's wait list options
    When I edit a course offering
    And I activate a wait list with a level of "Course Offering" and type of "Manual"
    Then I can submit and the course offering is updated

  #KSENROLL-1505
  Scenario: Edit an existing course offering's affiliated personnel
    When I edit a course offering
    And I add an affiliated person
    Then I can submit and the course offering is updated

  #KSENROLL- 1506
  Scenario: Edit an existing course offering's administering organizations and honors flag
    When I edit a course offering
    And I add an administering organization and activate the honors flag
    Then I can submit and the course offering is updated

# KSENROLL-2860/3022
  Scenario: Test that user is unable to manage course offerings when SOC is in certain states
    When I manually change a given soc-state to "Publishing"
    Then I verify that I "cannot" manage course offerings
    And I manually change a given soc-state to "In Progress"
    Then I verify that I "cannot" manage course offerings
    And I manually change a given soc-state to "Open"
    Then I verify that I "can" manage course offerings
