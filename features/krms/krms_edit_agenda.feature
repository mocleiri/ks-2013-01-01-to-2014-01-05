@draft
Feature: KRMS Edit Agenda

  Background:
    Given I am logged in as admin

    #KSENROLL-5774
  Scenario: Confirm when selecting proposition in tree that the color changes to blue
    When I go to the Edit Agenda page
    And I select the "Must meet 1 of the following" node in the tree
    Then the background color should change to "blue"