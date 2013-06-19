Feature: KRMS ELIG9.10 Copy and Paste

  Background:
    Given I am logged in as admin
    Given I have setup the data for "Student Eligibility & Prerequisite" for term "201301" and course "HIST111"

  #ELIG9.10.EB1 (KSENROLL-7051)
  @pending
  Scenario: Confirm the copy and paste of rule statement is working as expected
    When I want to edit the selected agenda section
    And I copy node "G" and paste it after node "I"
    Then the "edit" tab should have the text "K. Text"
    And there should be a dropdown with value "OR" before node "K."
    When I switch to the other tab on the page
    Then the text "A(B(C AND D(E OR F) AND G) OR H OR I OR K OR J)" should be present in the text area
    When I switch to the other tab on the page
    When I edit node "K" in the tree by changing the "text" to "edit copied prop type 1"
    Then the "edit" tab should have the text "K. edit copied prop type 1"
    When I commit changes made to the proposition

  #ELIG9.10.EB2 (KSENROLL-7051)
  @bug @KSENROLL-7110
  Scenario: Confirm the copy and paste of compound (group) rule statement is working as expected
    When I want to edit the selected agenda section
    And I copy node "D" and paste it after node "I"
    Then the "edit" tab should have the text "L. Must meet 1 of the following"
    And the "edit" tab should have the text "M. Must have successfully completed all courses from (HIST416, ENGL478)"
    And the "edit" tab should have the text "N. Text to copy"
    And there should be a dropdown with value "OR" before node "L."
    When I switch to the other tab on the page
    Then the text "A(B(C AND D(E OR F) AND G) OR H OR I OR L(M OR N) OR J OR K)" should be present in the text area
    When I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    And I switch to the other tab on the page
    Then the text "A(B(C AND D(E OR F) AND G) OR H OR I OR J(K OR L) OR M OR N)" should be present in the text area