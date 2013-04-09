@wip
@brandon.gresham
Feature: Co-location of Activity Offerings

Background:
  Given I am logged in as a Schedule Coordinator
  And I create a number of COs with an AO in each

  @wip
  @brandon.gresham
  Scenario Outline: Colocate Activity Offerings
    When I manage a jointly offered CO
    And I indicate multiple activities for colocation, selecting to "<manage>" enrollments
    And I manage a jointly offered CO
    Then the AO indicates it is colocated
    Examples:
      |     manage        |
      | jointly share     |
      | separately manage |


