@wip
@brandon.gresham
Feature: Co-location of Activity Offerings

Background:
  Given I am logged in as a Schedule Coordinator
  And I create a number of COs with an AO in each

  @wip
  @brandon.gresham
  Scenario: Enter valid Course Offering and Activity Offering Codes - shared Maximum Enrollment - ALL colocation check boxes selected
    When I manage a jointly offered CO
    And I indicate multiple activities for colocation, selecting to "jointly share" enrollments
    And I manage a jointly offered CO
    Then the AO indicates it is colocated

  @wip
  @brandon.gresham
  Scenario: Enter valid Course Offering and Activity Offering Codes - separately managed Maximum Enrollment - ALL colocation check boxes selected
    When I manage a jointly offered CO
    And I indicate multiple activities for colocation, selecting to "separately manage" enrollments
    And I manage a jointly offered CO
    Then the AO indicates it is colocated


