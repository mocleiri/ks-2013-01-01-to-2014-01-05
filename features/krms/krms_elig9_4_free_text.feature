Feature: KRMS ELIG9.4 Free Text

  Background:
    Given I am logged in as admin
    And I have navigated to the agenda page for "Corequisite" for term "201301" and course "ENGL201"

  #ELIG9.4.EB1 (KSENROLL-7049)
  @pending
  Scenario: Setup one level of data using Add Rule Statement button
    When I want to add a new statement to the selected agenda section
    And I add a new free form text statement with text "Free Text 1"
    And I add a free form text statement after node "A" with text "Free Text 2"
    And I add a free form text statement after node "B" with text "Free Text 3"
    And I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must meet all of the following,Free Text 1,Free Text 2,Free Text 3"

#ELIG9.4.EB2 (KSENROLL-7049)
  @pending
  Scenario: Setup second level of data (Groups) using Create Group button
    When I want to edit the selected agenda section
    And I group free form text statement with node "B" with text "Free Text 1b"
    And I group free form text statement with node "C" with text "Free Text 2b"
    And I group free form text statement with node "D" with text "Free Text 2c"
    And I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    Then the "edit" tab should have the text "Free Text 1b,Free Text 2c,Free Text 2b"