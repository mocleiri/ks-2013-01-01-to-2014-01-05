@nightly
@brandon.gresham
Feature: WC.Co-location of Activity Offerings

Background:
  Given I am logged in as a Schedule Coordinator

#KSENROLL-9442
  Scenario: Colocate Activity Offerings using shared enrollments
    When I create "3" COs with an AO in each
    And I colocate multiple activities, selecting to "share" enrollments
    Then the activities indicate they are colocated
    And I break colocation on the first colocated AO
    Then the first colocated AO is not colocated with any remaining AOs

#KSENROLL-9442
  Scenario: Colocate Activity Offerings using separately managed enrollments
    When I create "3" COs with an AO in each
    And I colocate multiple activities, selecting to "separately manage" enrollments
    Then the activities indicate they are colocated
    And I break colocation on the first colocated AO
    Then the first colocated AO is not colocated with any remaining AOs

  Scenario: Delete a fully colocated AO
    When I designate a valid term and Course Offering Code with a fully colocated AO
    And I delete the fully colocated AO
    Then The AO is successfully deleted

  #Scenario: CCO 2.12A Verify colocation is copied when a Course Offering is copied within the same term

  #Scenario: CCO 2.12B Verify colocation is NOT copied when a Course Offering is copied from a prior term

  Scenario: CCO 2.13 Successfully rollover a course offering with colocated Activity Offerings
    Given I create an Academic Calendar
    And I add a new term to the Academic Calendar
    And I edit the term and make it official
    And I create three Course Offerings with colocated AOs in the new term
    And I rollover the term to a new academic term
    Then the Activity Offerings are colocated in the rollover target

