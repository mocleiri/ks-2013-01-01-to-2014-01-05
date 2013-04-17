Feature: KRMS Edit Agenda

  Background:
    Given I am logged in as admin

  #ELIG9.1.1 (KSENROLL-5774)
  @pending
  Scenario: Confirm when selecting proposition in tree that the color changes to blue
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.1 (KSENROLL-5774)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "A" in the tree
    Then the background color should change to "blue"

  #ELIG9.1.2.EB1 (KSENROLL-5776)
  @pending
  Scenario: UI must change to allow the user to select rule type
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB1 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    Then there should be nothing selected in the rule dropdown

  #ELIG9.1.2.EB2 (KSENROLL-5776)
  @pending
  Scenario: UI must change to allow the user to fill in the course
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB2 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    Then the "course" field should be empty

  #ELIG9.1.2.EB3 (KSENROLL-5776)
  Scenario: A new item with the selected rule and new node identifier should appear
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB3 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    Then there should be a new node with text "G. Must have successfully completed ENGL101"
    And there should be a dropdown with value "AND" before node "G"

  #ELIG9.1.2.EB4 (KSENROLL-5776)
  Scenario: Changes should be viewable in the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB4 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Logic" tab
    Then the text "A(B AND G AND C(D OR E) AND F)" should be present in the text area
    And the preview section should have the text "G. Must have successfully completed ENGL101"
    And the word "AND" should exist before node "G"

  #ELIG9.5.1.EB1 (KSENROLL-5818)
  @pending
  Scenario: UI must change to allow the user to fill in text
    When I go to the Manage Course Offering Agendas page for "ELIG9.5.1.EB1 (KSENROLL-5818)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    Then the "free form text" field should be empty

  #ELIG9.5.1.EB2 (KSENROLL-5818)
  Scenario: A new item with the Free Form text description should appear
    When I go to the Manage Course Offering Agendas page for "ELIG9.5.1.EB2 (KSENROLL-5818)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "xyz" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "G. xyz"
    And there should be a dropdown with value "AND" before node "G"

  #ELIG9.7.1.EB1 (KSENROLL-5777)
  Scenario: The droplist value should be able to be changed
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.1.EB1 (KSENROLL-5777)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select "OR" from the dropdown before node "2"
    Then there should be a dropdown with value "OR" before node "H"

  #ELIG9.7.1.EB2 (KSENROLL-5777
  Scenario: The changes should be applied to the rule view on the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.1.EB2 (KSENROLL-5777)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select "OR" from the dropdown before node "2"
    And I click the "Logic" tab
    Then the text "A(B OR H OR G OR C(D OR E) OR F)" should be present in the text area

  #ELIG9.7.2.EB1 (KSENROLL-5861)
  Scenario: Confirm that the Group Button is working as expected
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.2.EB1 (KSENROLL-5861)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "E" in the tree
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "F. Must meet all of the following"
    And node "E" should be after node "F"
    And node "G" should be after node "F"

  #ELIG9.7.2.EB2 (KSENROLL-5861)
  Scenario: The newly created group should be visible in the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.2.EB2 (KSENROLL-5861)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "I" in the tree
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Logic" tab
    Then the text "A(B AND F(E AND H AND G) AND D AND C)" should be present in the text area

  #KSENROLL-5880
  Scenario: The group should change depending on the AND/OR operator
    When I go to the Manage Course Offering Agendas page for "KSENROLL-5880"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select "OR" from the dropdown before node "2"
    Then the first node should match "Must meet 1 of the following"

  #ELIG9.7.3.EB1 (KSENROLL-6308)
  Scenario: Confirm changes to the tree is shown in the sections of the Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.3.EB1 (KSENROLL-6308)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "I" in the tree
    And I click the "Move Down" button
    And I select node "F" in the tree
    And I click the "Move Up" button
    And I select "OR" from the dropdown before node "8"
    And I click the "Logic" tab
    Then the text "A(G OR I(B AND J) OR H OR F OR C(D OR E))" should be present in the text area

  #ELIG9.7.4.EB1 (KSENROLL-6309)
  Scenario: Confirm changes to the preview text area are made successfully after clicking the preview button
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.4.EB1 (KSENROLL-6309)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "F" in the tree
    And I click the "Group" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "BSCI207" in the "course" field
    And I click the "Preview Change" button
    And I click the "Logic" tab
    And I change the preview text area to "A(G OR H OR I(B AND J) OR C(D OR E) OR K(F AND L))"
    And I click the "Preview Change" button
    And I click the "Object" tab
    Then node "H" should be after node "G"
    And node "C" should be after node "I"
    And node "K" should be after node "C"

  #ELIG9.7.5.EB1 (KSENROLL-6310)
  Scenario: Move a node in a group left and confirm that it leaves the group
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB1 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    Then the node "J" should be a primary node in the tree

  #ELIG9.7.5.EB2 (KSENROLL-6310)
  Scenario: Move a node right and confirm that nothing happens
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB2 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Right" button
    Then the node "J" should be a primary node in the tree

  #ELIG9.7.5.EB3 (KSENROLL-6310)
  Scenario: Move a node up and confirm that node is moved one position up
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB3 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    Then node "H" should be after node "J"

  #ELIG9.7.5.EB4 (KSENROLL-6310)
  Scenario: Move a node up then right and confirm that it moves into the group below
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB4 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Requisite" button
    And I select the "Must have successfully completed <course>" option from the rule dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Requisite" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Group" button
    And I select the "Free Form Text" option from the rule dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    And I click the "Move Right" button
    Then the node "J" should be a secondary node in the tree

  #ELIG8.19 EB1 (KSENROLL-6332)
  @bug @KSENROLL-6332
  Scenario: Navigate to the Activity Offering - Manage Rules link
    When I go to the Manage Course Offerings page for "ELIG8.19 EB1 (KSENROLL-6332)"
    And I enter "201301" in the "term" field on Manage CO page
    And I enter "ENGL101" in the "course" field on Manage CO page
    And I click the "Show" button on Manage CO page
    And I click the "Manage" link for course "ENGL101H"
    And I click on the "Manage Rules" link on Manage CO page
