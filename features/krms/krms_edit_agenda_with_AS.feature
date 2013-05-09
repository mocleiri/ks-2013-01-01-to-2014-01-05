Feature: KRMS Edit Agenda with Advanced Search (AS)

  Background:
    Given I am logged in as admin

  #ELIG9.1.2.EB3 (KSENROLL-5776)
  @pending
  Scenario: AS - A new item with the selected rule and new node identifier should appear
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB3 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    Then there should be a new node with text "E. Must have successfully completed ENGL101"
    And there should be a dropdown with value "AND" before node "E"

  #ELIG9.1.2.EB4 (KSENROLL-5776)
  @pending
  Scenario: AS - Changes should be viewable in the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB4 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    And I click the "Edit Rule Logic" tab
    Then the text "A(B(C OR D) AND E)" should be present in the text area
    And the preview section should have the text "E. Must have successfully completed ENGL101"
    And the word "AND" should exist before node "E"

  #ELIG9.7.1.EB1 (KSENROLL-5777)
  @bug @KSENROLL-6609
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
    And I select "OR" from the dropdown before node "2" on the "outer compound"
    Then there should be a dropdown with value "OR" before node "F"

  #ELIG9.7.1.EB2 (KSENROLL-5777)
  @bug @KSENROLL-6609
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
    And I select "OR" from the dropdown before node "2" on the "outer compound"
    And I click the "Edit Rule Logic" tab
    Then the text "A(B(C OR D) OR F OR E)" should be present in the text area

  #ELIG9.7.3.EB1 (KSENROLL-6308)
  @bug @KSENROLL-6609 @KSENROLL-6779
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Move Down" button
    And I select node "H" in the tree
    And I click the "Move Up" button
    And I select "OR" from the dropdown before node "4" on the "outer compound"
    And I click the "Edit Rule Logic" tab
    Then the text "A(E OR B(C OR D) OR G(H OR F))" should be present in the text area

  #ELIG9.7.4.EB1 (KSENROLL-6309)
  @bug @KSENROLL-6609
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "E" in the tree
    And I click the "Add Parent" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I search for the "course code" "BSCI207"
    And I click the "Preview Change" button
    And I click the "Edit Rule Logic" tab
    And I change the preview text area to "A(I(E OR J) OR B(D OR C) OR G(F OR H))"
    And I click the "Preview Change" button
    And I click the "Edit Rule" tab
    Then node "B" should be after node "I"
    And node "C" should be after node "D"
    And node "G" should be after node "B"

  #ELIG9.7.5.EB1 (KSENROLL-6310)
  @bug @KSENROLL-6609
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    Then the node "H" should be a primary node in the tree

  #ELIG9.7.5.EB2 (KSENROLL-6310)
  @bug @KSENROLL-6609
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Right" button
    Then the node "H" should be a primary node in the tree

  #ELIG9.7.5.EB3 (KSENROLL-6310)
  @bug @KSENROLL-6609
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    Then node "G" should be after node "H"

  #ELIG9.7.5.EB4 (KSENROLL-6310)
  @bug @KSENROLL-6609
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    And I click the "Move Right" button
    Then the node "H" should be a secondary node in the tree

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
    And I search for the "course code" "BSCI207"
    And I click the "add" button
    And I click the "Preview Change" button
    Then there should be a new node with text "A. Must not have successfully completed any courses from (BSCI207, ENGL101)"

  #KSENROLL-6387
  @pending
  Scenario: Confirm by using AS whether the changes made with the Edit button persists
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6387"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "C" in the tree
    And I click the "Edit" button
    And I search for the "course code" "ENGL101"
    And I click the "Preview Change" button
    Then there should be a new node with text "C. Must have successfully completed ENGL101"
