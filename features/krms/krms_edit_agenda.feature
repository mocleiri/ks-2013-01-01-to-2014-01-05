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
    And I click the "Add Rule Statement" button
    Then there should be nothing selected in the rule dropdown

  #ELIG9.1.2.EB2 (KSENROLL-5776)
  @pending
  Scenario: UI must change to allow the user to fill in the course
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB2 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    Then the "course" field should be empty

  #ELIG9.1.2.EB3 (KSENROLL-5776)
  @bug @KSENROLL-6381
  Scenario: A new item with the selected rule and new node identifier should appear
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB3 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    Then there should be a new node with text "G. Must have successfully completed ENGL101"
    And there should be a dropdown with value "AND" before node "G"

  #ELIG9.1.2.EB4 (KSENROLL-5776)
  @bug @KSENROLL-6381
  Scenario: Changes should be viewable in the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.1.2.EB4 (KSENROLL-5776)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
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
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    Then the "free form text" field should be empty

  #ELIG9.5.1.EB2 (KSENROLL-5818)
  @bug @KSENROLL-6381
  Scenario: A new item with the Free Form text description should appear
    When I go to the Manage Course Offering Agendas page for "ELIG9.5.1.EB2 (KSENROLL-5818)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "xyz" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "G. xyz"
    And there should be a dropdown with value "AND" before node "G"

  #ELIG9.7.1.EB1 (KSENROLL-5777)
  @bug @KSENROLL-6381
  Scenario: The droplist value should be able to be changed
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.1.EB1 (KSENROLL-5777)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select "OR" from the dropdown before node "2"
    Then there should be a dropdown with value "OR" before node "H"

  #ELIG9.7.1.EB2 (KSENROLL-5777)
  @bug @KSENROLL-6381
  Scenario: The changes should be applied to the rule view on the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.1.EB2 (KSENROLL-5777)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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
  @bug @KSENROLL-6381
  Scenario: Confirm that the Group Button is working as expected
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.2.EB1 (KSENROLL-5861)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "E" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "F. Must meet all of the following"
    And node "E" should be after node "F"
    And node "G" should be after node "F"

  #ELIG9.7.2.EB2 (KSENROLL-5861)
  @bug @KSENROLL-6381
  Scenario: The newly created group should be visible in the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.2.EB2 (KSENROLL-5861)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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

  #KSENROLL-5880
  Scenario: The group should change depending on the AND/OR operator
    When I go to the Manage Course Offering Agendas page for "KSENROLL-5880"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select "OR" from the dropdown before node "2"
    Then the first node should match "Must meet 1 of the following"

  #ELIG9.7.3.EB1 (KSENROLL-6308)
  @bug @KSENROLL-6381
  Scenario: Confirm changes to the tree is shown in the sections of the Logic tab
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.3.EB1 (KSENROLL-6308)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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
  @bug @KSENROLL-6381
  Scenario: Confirm changes to the preview text area are made successfully after clicking the preview button
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.4.EB1 (KSENROLL-6309)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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
    And I enter "BSCI207" in the "course" field
    And I click the "Preview Change" button
    And I click the "Edit Rule Logic" tab
    And I change the preview text area to "A(G OR H OR I(B AND J) OR C(D OR E) OR K(F AND L))"
    And I click the "Preview Change" button
    And I click the "Edit Rule" tab
    Then node "H" should be after node "G"
    And node "C" should be after node "I"
    And node "K" should be after node "C"

  #ELIG9.7.5.EB1 (KSENROLL-6310)
  @bug @KSENROLL-6381
  Scenario: Move a node in a group left and confirm that it leaves the group
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB1 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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
  @bug @KSENROLL-6381
  Scenario: Move a node right and confirm that nothing happens
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB2 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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
  @bug @KSENROLL-6381
  Scenario: Move a node up and confirm that node is moved one position up
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB3 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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
  @bug @KSENROLL-6381
  Scenario: Move a node up then right and confirm that it moves into the group below
    When I go to the Manage Course Offering Agendas page for "ELIG9.7.5.EB4 (KSENROLL-6310)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Must have successfully completed <course>" option from the "rule" dropdown
    And I enter "ENGL101" in the "course" field
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

  #ELIG8.19 EB1 (KSENROLL-6332)
  @bug @KSENROLL-6332
  Scenario: Navigate to the Activity Offering - Manage Rules link
    When I go to the Manage Course Offerings page for "ELIG8.19 EB1 (KSENROLL-6332)"
    And I enter "201301" in the "term" field on Manage CO page
    And I enter "ENGL101" in the "course" field on Manage CO page
    And I click the "Show" button on Manage CO page
    And I click the "Manage" link for course "ENGL101H"
    And I click on the "Manage Rules" link on Manage CO page

  #ELIG9.10.2.EB1 (KSENROLL-6335)
  @bug @KSENROLL-?
  Scenario: Confirm that the Copy and Paste buttons works as expected
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.2.EB1 (KSENROLL-6335)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Copy" button
    And I select node "B" in the tree
    And I click the "Paste" button
    Then there should be a new node with text "G. Some free text goes here."
    And there should be a dropdown with value "AND" before node "G."
    And I click the "Edit Rule Logic" tab
    Then the text "A(B AND G AND C(D OR E) AND F)" should be present in the text area

  #ELIG9.10.2.EB2 (KSENROLL-6335)
  @pending
  Scenario: Confirm that the Update Rule after Copy & Paste loads the Agenda Maintenance page
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.2.EB2 (KSENROLL-6335)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Copy" button
    And I select node "B" in the tree
    And I click the "Paste" button
    And I click the "Update Rule" button
    Then the loaded page should have "Enrollment Eligibility" as a heading

  #ELIG9.10.2.EB3 (KSENROLL-6335)
  @bug @KSENROLL-?
  Scenario: Confirm that the Submit button persists the data after Copy & Paste
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.2.EB3 (KSENROLL-6335)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Copy" button
    And I select node "B" in the tree
    And I click the "Paste" button
    And I click the "Update Rule" button
    And I click the "submit" button on Manage CO Agendas page
    And I go to the Main Menu from Manage CO Agendas
    And I go to the Manage Course Offering Agendas page for ""
    And I click on the "Student Eligibility & Prerequisite" section
    Then the new node "Some free text goes here." should be between two "AND" operators

  #ELIG9.10.3.EB1 (KSENROLL-6336)
  @bug @KSENROLL-?
  Scenario: Confirm that the Cut and Paste buttons works as expected
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.3.EB1 (KSENROLL-6336)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Cut" button
    And I select node "B" in the tree
    And I click the "Paste" button
    Then there should be a new node with text "D. Some free text goes here."
    And there should be a dropdown with value "AND" before node "D."
    And I click the "Edit Rule Logic" tab
    Then the text "A(B AND D AND C(E) AND F)" should be present in the text area

  #ELIG9.10.3.EB2 (KSENROLL-6336)
  @pending
  Scenario: Confirm that the Update Rule after Cut & Paste loads the Agenda Maintenance page
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.3.EB2 (KSENROLL-6336)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Cut" button
    And I select node "B" in the tree
    And I click the "Paste" button
    And I click the "Update Rule" button
    Then the loaded page should have "Enrollment Eligibility" as a heading

  #ELIG9.10.3.EB3 (KSENROLL-6336)
  @bug @KSENROLL-?
  Scenario: Confirm that the Submit button persists the data after Cut & Paste
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.3.EB3 (KSENROLL-6336)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Cut" button
    And I select node "B" in the tree
    And I click the "Paste" button
    And I click the "Update Rule" button
    And I click the "submit" button on Manage CO Agendas page
    And I go to the Main Menu from Manage CO Agendas
    And I go to the Manage Course Offering Agendas page for ""
    And I click on the "Student Eligibility & Prerequisite" section
    Then the new node "Some free text goes here." should be between two "AND" operators

  #ELIG9.10.4.EB1 (KSENROLL-6337)
  @bug @KSENROLL-?
  Scenario: Confirm that the Delete button works as expected
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.4.EB1 (KSENROLL-6337)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Delete" button
    Then there should be no node with letter "D."
    And I click the "Edit Rule Logic" tab
    Then the text "A(B AND C(E) AND F)" should be present in the text area

  #ELIG9.10.4.EB2 (KSENROLL-6337)
  @pending
  Scenario: Confirm that the Update Rule after Delete loads the Agenda Maintenance page
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.4.EB2 (KSENROLL-6337)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Delete" button
    And I click the "Update Rule" button
    Then the loaded page should have "Enrollment Eligibility" as a heading

  #ELIG9.10.4.EB3 (KSENROLL-6337)
  @bug @KSENROLL-?
  Scenario: Confirm that the Submit button persists the data after Delete
    When I go to the Manage Course Offering Agendas page for "ELIG9.10.4.EB2 (KSENROLL-6337)"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Delete" button
    And I click the "Update Rule" button
    And I click the "submit" button on Manage CO Agendas page
    And I go to the Main Menu from Manage CO Agendas
    And I go to the Manage Course Offering Agendas page for ""
    And I click on the "Student Eligibility & Prerequisite" section
    Then there should be no node "Some free text goes here." before an "OR" operator

  #KSENROLL-6383
  @bug @KSENROLL-6381
  Scenario: Test whether the Preview Change button works for Antirequisites
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6383"
    And I click on the "Antirequisite" section
    And I click on the "Add Rule" link
    And I click the "Add Rule Statement" button
    And I select the "Must not have successfully completed any courses from <courses>" option from the "rule" dropdown
    And I select the "Approved Courses" option from the "courses" dropdown
    And I enter "ENGL101" in the "courses" field
    And I click the "add" button
    And I click the "Preview Change" button
    Then there should be a new node with text "A. Must not have successfully completed any courses from ENGL101"

  #KSENROLL-6384
  @pending
  Scenario: Test whether the free form text rule works for Corequisites
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6384"
    And I click on the "Corequisite" section
    And I click on the "Add Rule" link
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text random input value" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "A. Text random input value"

  #KSENROLL-6389
  @pending
  Scenario: Test whether the Compare to Original on an empty tree works as expected
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6389"
    And I click on the "Antirequisite" section
    And I click on the "Add Rule" link
    And I click on the "Compare to Original" link on the Edit Agenda page
    Then the old and new rule should be compared

  #KSENROLL-6387
  @bug @KSENROLL-6483
  Scenario: Confirm whether the changes made with the Edit button persists
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6387"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "C" in the tree
    And I click the "Edit" button
    And I enter "ENGL101" in the "course" field
    And I click the "Preview Change" button
    Then there should be a new node with text "G. Must have successfully completed ENGL101"

  #KSENROLL-6391
  @pending
  Scenario: Confirm whether the cancel button works in edit proposition on Antirequisite page
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6391"
    And I click on the "Antirequisite" section
    And I click on the "Add Rule" link
    And I click on the "Cancel" link on the Edit Agenda page
    Then the loaded page should have "Enrollment Eligibility" as a heading

  #KSENROLL-6393
  @pending
  Scenario: Confirm whether creating a second group does not cause the page to crash
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6393"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "C" in the tree
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Add Parent" button
    Then there should be nothing selected in the rule dropdown

  #KSENROLL-6491
  @bug @KSENROLL-6489
  Scenario: Confirm that the page does not crash when moving nodes around and adding a group
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6491"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select node "B" in the tree
    And I click the "Move Down" button
    And I click the "Add Parent" button
    Then there should be nothing selected in the rule dropdown

  #KSENROLL-6473
  @pending
  Scenario: Confirm that the the compare to original works after a new rule is added
    When I go to the Manage Course Offering Agendas page for "KSENROLL-6473"
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I click on the "Compare to Original" link on the Edit Agenda page
    Then the old and new rule should be compared
