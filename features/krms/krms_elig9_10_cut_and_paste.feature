# cucumber -r features features/krms/krms_elig9_10_cut_and_paste.feature
Feature: KRMS ELIG 9-10 Cut and paste

  Background:
    Given I am logged in as admin



  #krms_elig9_10_cut_and_paste
  @pending
  Scenario: Confirm the cut and paste of a rule statement is working as expected
   When I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Edit Rule" link
#    And I click the "Edit Rule Logic" tab
#    Then the text "A(B(C AND D(E AND F)) AND G AND H(I AND J))" should be present in the text area
    And I select node "G" in the tree
    And I click the "Cut" button
    And I select node "J" in the tree
    And I click the "Paste" button
#    And I click the "Edit Rule Logic" tab
#    Then the text "A(B(C AND D(E AND F)) AND H(I AND J AND G))" should be present in the text area
  #Submit changes
    When I click the "Update Rule" button
    When I click the "submit" button on Manage CO Agendas page

  #krms_elig9_10_cut_and_paste
  @pending
  Scenario: Confirm the cut and paste of compound (group) rule statement is working as expected
    When I navigate to the agenda page for "ENGL304"
    And I click on the "Corequisite" section
    And I click on the "Edit Rule" link
    And I select node "D" in the tree
    And I click the "Cut" button
    And I select node "J" in the tree
    And I click the "Paste" button
 #   And I click the "Edit Rule Logic" tab
 #   Then the text "A(C AND H(I AND J AND D(E AND F) AND G))" should be present in the text area

  #Submit changes
    When I click the "Update Rule" button
    When I click the "submit" button on Manage CO Agendas page