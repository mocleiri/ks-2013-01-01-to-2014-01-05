Feature: KRMS ELIG9.6 AND, OR and Move

  Background:
    Given I am logged in as admin

  #ELIG9.7.5.EB1 (KSENROLL-6310)
  @bug @KSENROLL-6381
  Scenario: Move a node in a group left and confirm that it leaves the group
    When I go to the Manage Course Offering Agendas page
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    Then the node "H" should be a primary node in the tree

  #ELIG9.7.5.EB2 (KSENROLL-6310)
  @bug @KSENROLL-6381
  Scenario: Move a node right and confirm that nothing happens
    When I go to the Manage Course Offering Agendas page
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Right" button
    Then the node "H" should be a primary node in the tree

  #ELIG9.7.5.EB3 (KSENROLL-6310)
  @bug @KSENROLL-6381
  Scenario: Move a node up and confirm that node is moved one position up
    When I go to the Manage Course Offering Agendas page
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    Then node "G" should be after node "H"

  #ELIG9.7.5.EB4 (KSENROLL-6310)
  @bug @KSENROLL-6381
  Scenario: Move a node up then right and confirm that it moves into the group below
    When I go to the Manage Course Offering Agendas page
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
    And I click the "Add Parent" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "Text" in the "free form text" field
    And I click the "Preview Change" button
    And I click the "Move Left" button
    And I click the "Move Up" button
    And I click the "Move Right" button
    Then the node "H" should be a secondary node in the tree

  #KSENROLL-6491
  @bug @KSENROLL-6609
  Scenario: Confirm that the page does not crash when moving nodes around and adding a group
    When I go to the Manage Course Offering Agendas page
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

#KSENROLL-5880
  @pending
  Scenario: The group should change depending on the AND/OR operator
    When I go to the Manage Course Offering Agendas page
    And I click on the "Student Eligibility & Prerequisite" section
    And I click on the "Edit Rule" link
    And I select node "B" in the tree
    And I click the "Add Rule Statement" button
    And I select the "Free Form Text" option from the "rule" dropdown
    And I enter "free form text input value" in the "free form text" field
    And I click the "Preview Change" button
    And I select "OR" from the dropdown before node "2" on the "outer compound"
    Then the first node should match "Must meet 1 of the following"

  #ELIG9.7.1.EB1 (KSENROLL-5777)
  @bug @KSENROLL-6381
  Scenario: The droplist value should be able to be changed
    When I go to the Manage Course Offering Agendas page
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
    And I select "OR" from the dropdown before node "2" on the "outer compound"
    Then there should be a dropdown with value "OR" before node "F"

  #ELIG9.7.1.EB2 (KSENROLL-5777)
  @bug @KSENROLL-6381
  Scenario: The changes should be applied to the rule view on the Edit with Logic tab
    When I go to the Manage Course Offering Agendas page
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
    And I select "OR" from the dropdown before node "2" on the "outer compound"
    And I click the "Edit Rule Logic" tab
    Then the text "A(B(C OR D) OR F OR E)" should be present in the text area

  #ELIG9.7.3.EB1 (KSENROLL-6308)
  @bug @KSENROLL-6609 @KSENROLL-6779
Scenario: AS - Confirm changes to the tree is shown in the sections of the Logic tab
  When I go to the Manage Course Offering Agendas page
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

#ELIG9.7.5.EB1 (KSENROLL-6310)
@bug @KSENROLL-6609
  Scenario: AS - Move a node in a group left and confirm that it leaves the group
    When I go to the Manage Course Offering Agendas page
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
    When I go to the Manage Course Offering Agendas page
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
    When I go to the Manage Course Offering Agendas page
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
    When I go to the Manage Course Offering Agendas page
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

  #ELIG9.7.1.EB1 (KSENROLL-5777)
  @bug @KSENROLL-6609
  Scenario: AS - The droplist value should be able to be changed
    When I go to the Manage Course Offering Agendas page
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
    When I go to the Manage Course Offering Agendas page
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
  When I go to the Manage Course Offering Agendas page
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

