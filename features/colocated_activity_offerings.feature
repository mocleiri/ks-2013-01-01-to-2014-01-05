@wip
@brandon.gresham
Feature: Co-location of Activity Offerings

Background:
  Given I am logged in as a Schedule Coordinator
  And I create a number of COs with an AO in each

  @wip
  @brandon.gresham
  Scenario Outline: Colocate Activity Offerings
    When I indicate multiple activities for colocation, selecting to "<manage>" enrollments
    # And I (deselect|select) all colocated AOs <-- this step cannot be tested yet due to partial implementation not yet being implemented
    Then the AO indicates it is colocated
    Examples:
      |     manage        |
      | share             |
      | separately manage |


