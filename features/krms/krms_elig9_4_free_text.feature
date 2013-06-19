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
    And I add a free form text statement after node "C" with text "Free Text 3"
    Then the "edit" tab should have the text "B. Must meet all of the following"
    And the "edit" tab should have the text "A. Free Text 1"
    And the "edit" tab should have the text "C. Free Text 2"
    And the "edit" tab should have the text "D. Free Text 3"
    When I commit changes made to the proposition

#ELIG9.4.EB2 (KSENROLL-7049)
  @pending
  Scenario: Setup second level of data (Groups) using Create Group button
    When I want to edit the selected agenda section
    And I group free form text statement with node "B" with text "Free Text 1b"
    And I group free form text statement with node "D" with text "Free Text 2b"
    And I group free form text statement with node "F" with text "Free Text 2c"
    When I commit and return to see the changes made to the proposition
    And I want to edit the selected agenda section
    Then the "edit" tab should have the text "A. Must meet all of the following"
    And the "edit" tab should have the text "B. Must meet all of the following"
    And the "edit" tab should have the text "D. Must meet all of the following"
    And the "edit" tab should have the text "H. Must meet all of the following"
    And the "edit" tab should have the text "E. Free Text 1b"
    And the "edit" tab should have the text "F. Free Text 2c"
    And the "edit" tab should have the text "J. Free Text 2b"