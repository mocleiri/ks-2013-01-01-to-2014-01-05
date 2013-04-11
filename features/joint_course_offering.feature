@draft
@adam.campbell
Feature: Jointly-defined Course Offering

  Background:
    Given I am logged in as a Schedule Coordinator

  @draft
  @adam.campbell
  Scenario Outline: Delete jointly-defined Course Offering with NO shared AOs
    When I create a new jointly defined Course Offering
    And I attempt to "<delete>" a joint Course Offering
    Then the Course Offering is "<deleted>"
    Examples:
      | delete            | deleted     |
      | delete            | deleted     |
      | delete and cancel | not deleted |


#   CCO 2.1 -- we cannot complete this ATM due to faulty implementation (see KSENROLL-6364)
#  @wip
#  @adam.campbell
#  Scenario: Create from Catalog a Course Offering which is defined in the CLU as Joint
#    When I remove a joint course offering from the reference data in order to enable this test
#    And I create a joint course offering from catalog while creating a new course offering
#    Then I can add activity offerings to the joint Course Offerings


