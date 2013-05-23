# cucumber -r features features/krms/krms_elig9_10_cut_and_paste.feature
Feature: KRMS ELIG 9-10 Cut and paste

  Background:
    Given I am logged in as admin

  #krms_elig9_10_cut_and_paste
  @pending
  Scenario: Confirm the cut and paste of a rule statement is working as expected
    When I set up the data for "Corequisite" for the course "ENGL304" with Advanced Search
    And I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Edit Rule" link
    And I select node "G" in the tree
    And I click the "Cut" button
    And I select node "J" in the tree
    And I click the "Paste" button
    Then there should be a dropdown with value "OR" before node "G."
    When I click the "Edit Rule Logic" tab
    Then the text "A(B(C AND D(E OR F)) OR H OR I OR J OR G)" should be present in the text area
    When I click the "Edit Rule" tab
    And I select node "G" in the tree
    And I click the "Edit" button
    And I enter "edit copied prop type" in the "free form text" field
    And I click the "Preview Change" button
    Then there should be a new node with text "G. edit copied prop type"
  #Submit changes
    When I click the "Update Rule" button
    And I click the "submit" button on Manage CO Agendas page

  #krms_elig9_10_cut_and_paste
  @pending
  Scenario: Confirm the cut and paste of compound (group) rule statement is working as expected
    When I set up the data for "Corequisite" for the course "ENGL304" with Advanced Search
    And I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Cut" button
    And I select node "J" in the tree
    And I click the "Paste" button
    Then there should be a dropdown with value "OR" before node "D."
    And I click the "Edit Rule Logic" tab
    Then the text "A(C OR G OR H OR I OR J OR D(E OR F))" should be present in the text area
    When I click the "Update Rule" button
    And I click the "submit" button on Manage CO Agendas page
    And I go to the Main Menu from Manage CO Agendas
    And I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Edit Rule" link
    And I click the "Edit Rule Logic" tab
    Then the text "A(B OR C OR D OR E OR F OR G(H OR I))" should be present in the text area