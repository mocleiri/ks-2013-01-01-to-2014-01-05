@draft
@brandon.gresham
Feature: Co-location of Activity Offerings

Background:
  Given I am logged in as a Schedule Coordinator
  And I create "3" COs with an AO in each

  @draft
  @brandon.gresham
  Scenario Outline: Colocate Activity Offerings
    When I colocate multiple activities, selecting to "<manage>" enrollments
    # And I (deselect|select) all colocated AOs <-- this step cannot be developed yet due to partial-colocation not being implemented in the app
    Then the activities indicate they are colocated
    Examples:
      |     manage        |
      | share             |
      | separately manage |


  Scenario: Delete a fully colocated AO
    When I designate a valid term and Course Offering Code with a fully colocated AO
    And I delete the fully colcated AO
    Then The AO is successfully deleted

  @wip
  @brandon.gresham
  Scenario Outline: Break an AOs colocation relationship
    When I colocate multiple activities, selecting to "<manage>" enrollments
    Examples:
      |     manage        |
      | share             |
      | separately manage |













