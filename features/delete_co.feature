@pending
Feature: Delete COs and all associated AOs

  As a user, I want to Delete Course Offerings from the Subject Code display of the Manage Course Offerings process
  by means of a Toolbar Button so I can more easily manage my Course Offerings.

  Background:
    Given I am logged in as a Schedule Coordinator

  @pending
  Scenario: Cancel deletion and deletion of CO-COC view with single CO
    When I create a Course Offering with Draft Activity Offerings
    And I cancel the deletion of a Course Offering in Course Offering Code view
    And the Course Offering is not deleted
    And I delete this Course Offering
    Then the deleted course offering does not appear on the list of available Course Offerings

  @pending
  Scenario: Cancel deletion and deletion of CO-COC view with multiple COs
    When I create multiple Course Offerings with Draft Activity Offerings
    And I cancel the deletion of the Course Offerings in Course Offering Code view
    And the Course Offerings are not deleted
    And I delete these Course Offerings
    Then the deleted course offerings do not appear on the list of available Course Offerings

  @pending
  Scenario: Cancel deletion and deletion of CO - Subject Code view
    When I create a Course Offering with Draft Activity Offerings
    And I cancel the deletion of a Course Offering in Subject Code view
    And the Course Offering is not deleted
    And I delete this Course Offering in Subject Code view
    Then the deleted course offering does not appear on the list of available Course Offerings