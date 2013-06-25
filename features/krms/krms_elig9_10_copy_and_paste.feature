Feature: KRMS ELIG9.10 Copy and Paste

  Background:
    Given I am logged in as admin
    Given I have setup the data for "Student Eligibility & Prerequisite" for term "201301" and course "HIST111"

  #ELIG9.10.EB1 (KSENROLL-7051)
  @pending
  Scenario: Confirm the copy and paste of rule statement is working as expected
    When I want to edit the selected agenda section
    And I copy node "D" and paste it after node "G"
    Then the "edit" tab should have the text "H. Text"
    And there should be a dropdown with value "OR" before node "H."
    When I switch to the other tab on the page
    Then the text "(A AND (B OR C) AND D) OR E OR F OR G OR H" should be present in the text area
    When I switch to the other tab on the page
    And I edit node "H" by changing text to "edit copied prop type 1"
    Then the "edit" tab should have the text "edit copied prop type 1"
    When I commit changes made to the proposition

  #ELIG9.10.EB2 (KSENROLL-7051)
  @bug @KSENROLL-7110
  Scenario: Confirm the copy and paste of compound (group) rule statement is working as expected
    When I want to edit the selected agenda section
    And I copy a "secondary" group and paste it after node "G"
    Then the "edit" tab should have the text "Must meet 1 of the following,Must have successfully completed all courses from (HIST416, ENGL478),Text to copy"
    And there should be a dropdown with value "OR" before node "I."
    When I switch to the other tab on the page
    Then the text "(A AND (B OR C) AND D) OR E OR F OR G OR (I OR J) OR H" should be present in the text area
    When I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    And I switch to the other tab on the page
    Then the text "(A AND (B OR C) AND D) OR E OR F OR G OR (H OR I) OR J" should be present in the text area
