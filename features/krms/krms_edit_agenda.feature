@draft
Feature: KRMS Edit Agenda

  Background:
    Given I am logged in as admin

  #KSENROLL-5774
  #ELIG9.1.1
  Scenario: Confirm when selecting proposition in tree that the color changes to blue
    When I go to the Edit Agenda page for "ELIG9.1.1 (KSENROLL-5774)"
    And I select node "A" in the tree
    Then the background color should change to "blue"

  #KESENROLL-5776
  #ELIG9.1.2.EB1
  Scenario: UI must change to allow the user to select rule type
    When I go to the Edit Agenda page for "ELIG9.1.2.EB1 (KSENROLL-5776)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    Then there should be nothing selected in the node "2" rule dropdown

  #ELIG9.1.2.EB2
  Scenario: UI must change to allow the user to fill in the course
    When I go to the Edit Agenda page for "ELIG9.1.2.EB2 (KSENROLL-5776)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the node "2" rule dropdown
    Then the "course" field in node "2" should be empty

  #ELIG9.1.2.EB3
  Scenario: A new item with the selected rule and new node identifier should appear
    When I go to the Edit Agenda page for "ELIG9.1.2.EB3 (KSENROLL-5776)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the node "2" rule dropdown
    And I enter "ENGL101" in the "course" field in node "2"
    And I click the "Update" button
    Then there should be a new node with text "D. Must have successfully completed <course>"
    And there should be a dropdown with value "AND" before node "2"

  #ELIG9.1.2.EB4
  Scenario: Changes should be viewable in the Edit with Logic tab
    When I go to the Edit Agenda page for "ELIG9.1.2.EB4 (KSENROLL-5776)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the node "2" rule dropdown
    And I enter "ENGL101" in the "course" field in node "2"
    And I click the "Update" button
    And I click the "Logic" tab
    Then the text "A(B AND D AND C)" should be present in the text area
    And the preview section should have the text "D. Must have successfully completed <course>"
    And the word "AND" should exist before node "D"

  #KSENROLL-5818
  #ELIG9.5.1.EB1
  Scenario: UI must change to allow the user to fill in text
    When I go to the Edit Agenda page for "ELIG9.5.1.EB1 (KSENROLL-5818)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the node "2" rule dropdown
    Then the "free form text" field in node "2" should be empty

  #ELIG9.5.1.EB2
  Scenario: A new item with the Free Form text description should appear
    When I go to the Edit Agenda page for "ELIG9.5.1.EB2 (KSENROLL-5818)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the node "2" rule dropdown
    And I enter "xyz" in the "free form text" field in node "2"
    And I click the "Update" button
    Then there should be a new node with text "D. Free Form Text"
    And there should be a dropdown with value "AND" before node "2"

  #KSENROLL-5777
  #ELIG9.7.1.EB1
  Scenario: The droplist value should be able to be changed
    When I go to the Edit Agenda page for "ELIG9.7.1.EB1 (KSENROLL-5777)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the node "2" rule dropdown
    And I enter "ENGL101" in the "course" field in node "2"
    And I click the "Update" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the node "2" rule dropdown
    And I enter "free form text input value" in the "free form text" field in node "2"
    And I click the "Update" button
    And I select "OR" from the dropdown before node "2"
    And I click the "Update" button
    Then there should be a dropdown with value "OR" before node "2"

  #ELIG9.7.1.EB2
  Scenario: The changes should be applied to the rule view on the Edit with Logic tab
    When I go to the Edit Agenda page for "ELIG9.7.1.EB2 (KSENROLL-5777)"
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the node "2" rule dropdown
    And I enter "ENGL101" in the "course" field in node "2"
    And I click the "Update" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the node "2" rule dropdown
    And I enter "free form text input value" in the "free form text" field in node "2"
    And I click the "Update" button
    And I select "OR" from the dropdown before node "2"
    And I click the "Update" button
    And I click the "Logic" tab
    Then the text "A(B OR E AND D AND C)" should be present in the text area
