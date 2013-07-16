Feature: KRMS.ELIG9-10 Copy and Paste

  Background:
    Given I am logged in as admin
    And I have setup the Student Eligibility & Prerequisite section for course "HIST111" in the future term

  #ELIG9.10.EB1 (KSENROLL-7051)
  @pending
  Scenario: Confirm the copy and paste of rule statement is working as expected
    When I want to edit the selected agenda section
    And I copy node "D" and paste it after node "G"
    Then the edit tab's text should match "H. Text"
    And there should be a dropdown with value "OR" before node "H."
    When I switch to the other tab on the page
    Then the text area should contain "(A AND (B OR C) AND D) OR E OR F OR G OR H"
    When I switch to the other tab on the page
    And I edit node "H" by changing text to "edit copied prop type 1"
    Then the edit tab's text should match "edit copied prop type 1"
    When I commit changes made to the proposition

  #ELIG9.10.EB2 (KSENROLL-7051)
  @bug @KSENROLL-7110
  Scenario: Confirm the copy and paste of compound (group) rule statement is working as expected
    When I want to edit the selected agenda section
    And I copy the group containing node "C" and paste it after node "G"
    Then the edit tab's text should match "I. Must have successfully completed all courses from (HIST416, ENGL478),J. Text to copy"
    And there should be a dropdown with value "OR" before node "I."
    When I switch to the other tab on the page
    Then the text area should contain "(A AND (B OR C) AND D) OR E OR F OR G OR (I OR J) OR H"
    When I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    And I switch to the other tab on the page
    Then the text area should contain "(A OR (B OR C) OR D) OR E OR F OR G OR (H OR I) OR J"
