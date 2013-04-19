@draft
@brandon.gresham
Feature: Co-location of Activity Offerings

Background:
  Given I am logged in as a Schedule Coordinator
    
  Scenario: Colocate Activity Offerings using "shared" enrollments
    When I create "3" COs with an AO in each
#When I create some dummy test data to speed up AFT development
    And I colocate multiple activities, selecting to "share" enrollments
    Then the activities indicate they are colocated
#not-impl#    And I break colocation on the first colocated AO, "supplying new" max-enrollment
#not-impl#    Then the first colocated AO is not colocated with any remaining AOs

  Scenario: Colocate Activity Offerings using "separately managed" enrollments
    When I create "3" COs with an AO in each
#When I create some dummy test data to speed up AFT development
    And I colocate multiple activities, selecting to "separately manage" enrollments
    Then the activities indicate they are colocated
#not-impl#    And I break colocation on the first colocated AO, "acknowledging retained" max-enrollment
#not-impl#    Then the first colocated AO is not colocated with any remaining AOs

  Scenario: Delete a fully colocated AO
    When I designate a valid term and Course Offering Code with a fully colocated AO
    And I delete the fully colcated AO
#broken#    Then The AO is successfully deleted


















