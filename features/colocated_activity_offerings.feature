@draft
@brandon.gresham
Feature: Co-location of Activity Offerings

Background:
  Given I am logged in as a Schedule Coordinator
#  And I create "3" COs with an AO in each
When I create some dummy test data to speed up AFT development

  @draft
  @brandon.gresham
  Scenario Outline: Colocate Activity Offerings
    When I colocate multiple activities, selecting to "<Manage>" enrollments
    # And I (deselect|select) all colocated AOs <-- this step cannot be developed yet due to partial-colocation not being implemented in the app
    Then the activities indicate they are colocated
    Examples:
      | Manage            |
      | share             |
      | separately manage |


  Scenario: Delete a fully colocated AO
    When I designate a valid term and Course Offering Code with a fully colocated AO
    And I delete the fully colcated AO
    Then The AO is successfully deleted

  @wip
  @brandon.gresham
  Scenario Outline: Break an AOs colocation relationship
    When I colocate multiple activities, selecting to "<Manage>" enrollments
    And I break colocation on the first colocated AO, "<Remanaging>" max-enrollment
    Then the first colocated AO is not colocated with the remaining AO(s)

    Examples:
    | Manage            | Remanaging              |
    | share             | supplying new           |
    | separately manage | acknowledging retained  |















