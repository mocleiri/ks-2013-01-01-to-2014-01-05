Feature: KRMS ELIG9.10 Cut and Paste

  Background:
    Given I am logged in as admin
    And I have setup the data for "Corequisite" for term "201301" and course "ENGL101X"

  #ELIG9.10.EB1 (KSENROLL-7052)
  @pending
  Scenario: Confirm the cut and paste of a rule statement is working as expected
    When I want to edit the selected agenda section
    And I cut node "G" and paste it after node "J"
    Then there should be a dropdown with value "OR" before node "G."
    When I switch to the other tab on the page
    Then the text "A(B(C AND D(E OR F)) OR H OR I OR J OR G)" should be present in the text area
    When I switch to the other tab on the page
    When I edit node "G" in the tree by changing the "text" to "edit cut prop type"
    Then the "edit" tab should have the text "G. edit cut prop type"
    When I commit changes made to the proposition

  #ELIG9.10.EB2 (KSENROLL-7052)
  @pending
  Scenario: Confirm the cut and paste of compound (group) rule statement is working as expected
    When I want to edit the selected agenda section
    And I cut node "D" and paste it after node "J"
    Then there should be a dropdown with value "OR" before node "D."
    When I switch to the other tab on the page
    Then the text "A(C OR G OR H OR I OR J OR D(E OR F))" should be present in the text area
    When I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    And I switch to the other tab on the page
    Then the text "A(B OR C OR D OR E OR F OR G(H OR I))" should be present in the text area