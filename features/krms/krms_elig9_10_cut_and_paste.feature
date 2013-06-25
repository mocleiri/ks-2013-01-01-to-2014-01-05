Feature: KRMS ELIG9.10 Cut and Paste

  Background:
    Given I am logged in as admin
    And I have setup the data for "Corequisite" for term "201301" and course "ENGL101X"

  #ELIG9.10.EB1 (KSENROLL-7052)
  @pending
  Scenario: Confirm the cut and paste of a rule statement is working as expected
    When I want to edit the selected agenda section
    And I cut node "D" and paste it after node "G"
    Then there should be a dropdown with value "OR" before node "D."
    When I switch to the other tab on the page
    Then the text "(A AND (B OR C)) OR E OR F OR G OR D" should be present in the text area
    When I switch to the other tab on the page
    When I edit node "D" by changing text to "edit cut prop type"
    Then the "edit" tab should have the text "edit cut prop type"
    When I commit changes made to the proposition

  #ELIG9.10.EB2 (KSENROLL-7052)
  @pending
  Scenario: Confirm the cut and paste of compound (group) rule statement is working as expected
    When I want to edit the selected agenda section
    And I cut a "secondary" group and paste it after node "F"
    Then there should be a dropdown with value "OR" before node "B."
    When I switch to the other tab on the page
    Then the text "(A) OR D OR E OR F OR (B OR C) OR G" should be present in the text area
    When I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    And I switch to the other tab on the page
    Then the text "(A) OR B OR C OR D OR (E OR F) OR G" should be present in the text area