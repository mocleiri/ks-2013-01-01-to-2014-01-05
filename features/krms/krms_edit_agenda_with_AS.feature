Feature: KRMS Edit Agenda with Advanced Search (AS)

  Background:
    Given I am logged in as admin

  #ELIG9.1.2.EB3 (KSENROLL-5776)
  @bug @KSENROLL-6483
  Scenario: AS - A new item with the selected rule and new node identifier should appear
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB3 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    Then there should be a new node with text "G. Must have successfully completed ENGL101"
    And there should be a dropdown with value "AND" before node "G"

  #ELIG9.1.2.EB4 (KSENROLL-5776)
  @bug @KSENROLL-6483
  Scenario: AS - Changes should be viewable in the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB4 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Logic" tab
    Then the text "A(B AND G AND C(D OR E) AND F)" should be present in the text area
    And the preview section should have the text "G. Must have successfully completed ENGL101"
    And the word "AND" should exist before node "G"

  #ELIG9.7.1.EB1 (KSENROLL-5777)
  @bug @KSENROLL-6483
  Scenario: AS - The droplist value should be able to be changed
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.1.EB1 (KSENROLL-5777)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select "OR" from the dropdown before node "2"
    Then there should be a dropdown with value "OR" before node "F"

  #ELIG9.7.1.EB2 (KSENROLL-5777)
  @bug @KSENROLL-6483
  Scenario: AS - The changes should be applied to the rule view on the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.1.EB2 (KSENROLL-5777)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select "OR" from the dropdown before node "2"
    And I click the "Edit Rule Logic" tab
    Then the text "A(B OR H OR G OR C(D OR E) OR F)" should be present in the text area

  #ELIG9.7.2.EB1 (KSENROLL-5861)
  @bug @KSENROLL-6483
  Scenario: AS - Confirm that the Group Button is working as expected
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.2.EB1 (KSENROLL-5861)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "E" in the tree
    And I click the "Create Group" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "F. Must meet all of the following"
    And node "E" should be after node "F"
    And node "G" should be after node "F"

  #ELIG9.7.2.EB2 (KSENROLL-5861)
  @bug @KSENROLL-6483
  Scenario: AS - The newly created group should be visible in the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.2.EB2 (KSENROLL-5861)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "I" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Edit Rule Logic" tab
    Then the text "A(B AND F(E AND H AND G) AND D AND C)" should be present in the text area

  #ELIG9.7.3.EB1 (KSENROLL-6308)
  @bug @KSENROLL-6483
  Scenario: AS - Confirm changes to the tree is shown in the sections of the Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.3.EB1 (KSENROLL-6308)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "I" in the tree
    And I click the "Move Down" button
    And I select node "F" in the tree
    And I click the "Move Up" button
    And I select "OR" from the dropdown before node "8"
    And I click the "Edit Rule Logic" tab
    Then the text "A(G OR I(B AND J) OR H OR F OR C(D OR E))" should be present in the text area

  #ELIG9.7.4.EB1 (KSENROLL-6309)
  @bug @KSENROLL-6483
  Scenario: AS - Confirm changes to the preview text area are made successfully after clicking the preview button
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.4.EB1 (KSENROLL-6309)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "F" in the tree
    And I click the "Add Parent" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "BSCI207"
    And I click the "Preview Change" button
    And I click the "Edit Rule Logic" tab
    And I change the preview text area to "A(G OR H OR I(B AND J) OR C(D OR E) OR K(F AND L))"
    And I click the "Preview Change" button
    And I click the "Edit Rule" tab
    Then node "H" should be after node "G"
    And node "C" should be after node "I"
    And node "K" should be after node "C"

  #ELIG9.7.5.EB1 (KSENROLL-6310)
  @bug @KSENROLL-6483
  Scenario: AS - Move a node in a group left and confirm that it leaves the group
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB1 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    Then the node "J" should be a primary node in the tree

  #ELIG9.7.5.EB2 (KSENROLL-6310)
  @bug @KSENROLL-6483
  Scenario: AS - Move a node right and confirm that nothing happens
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB2 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Right" button
    Then the node "J" should be a primary node in the tree

  #ELIG9.7.5.EB3 (KSENROLL-6310)
  @bug @KSENROLL-6483
  Scenario: AS - Move a node up and confirm that node is moved one position up
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB3 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    Then node "H" should be after node "J"

  #ELIG9.7.5.EB4 (KSENROLL-6310)
  @bug @KSENROLL-6483
  Scenario: AS - Move a node up then right and confirm that it moves into the group below
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB4 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    And I click the "Move Right" button
    Then the node "J" should be a secondary node in the tree

  #KSENROLL-6383
  @pending
  Scenario: Test with AS whether the Preview Change button works for Antirequisites
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6383"
    And I click on the "Antirequisite" section
    And I click on the "Add Rule" link
    And I click the "Add Rule Statement" button
    And I select the "Must not have successfully completed any courses from <courses>" option from the "rule" dropdown
    And I select the "Approved Courses" option from the "courses" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "add" button
    And I click the "Preview Change" button
    Then there should be a new node with text "A. Must not have successfully completed ENGL101"

  #KSENROLL-6387
  @bug @KSENROLL-6483
  Scenario: Confirm by using AS whether the changes made with the Edit button persists
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6387"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "C" in the tree
    And I click the "Edit" button
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    Then there should be a new node with text "G. Must have successfully completed ENGL101"
