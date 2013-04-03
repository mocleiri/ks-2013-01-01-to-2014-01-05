Feature: Jointly-defined Course Offering
  Background: Given I am logged in as a Schedule Coordinator
  Scenario: Create from Catalog a Course Offering which is defined in the CLU as Joint
    When I create joint Course Offerings
    Then I can add activity offerings to the joint Course Offerings
  Scenario: Delete jointly-defined Course Offering with NO shared AOs - CANCEL operation
    When I create joint Course Offerings
    And I attempt to delete a joint Course Offering
    Then I can cancel the deletion
    And the Course Offering is not deleted
  Scenario: Delete jointly-defined Course Offering with NO shared AOs - COMPLETE operation
    When I create joint Course Offerings
    And I attempt to delete a joint Course Offering
    Then I can complete the deletion
    And the Course Offering is deleted