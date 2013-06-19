Feature: KRMS ELIG9.2 Natural Language

  Background:
    Given I am logged in as admin

  #ELIG9.2.EB1.1 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Recommended Preparation - rule one
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "ENGL304"
    And I want to add a new statement to the selected agenda section
    And I add a new course statement with course "HIST210"
    Then the text "Must have successfully completed HIST210" should show correctly on all pages

  #ELIG9.2.EB1.2 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Recommended Preparation - rule two
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "ENGL304"
    And I want to edit the selected agenda section
    And I add a courses statement after node "A" with courses "HIST110,HIST210" and course sets "CORE: Life Science Lab-Linked Courses (LL)"
    Then the "edit" tab should have the text "Must have successfully completed all courses from (HIST210, HIST110, BSCI124)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed all courses from,HIST110,HIST210,CORE: Life Science Lab-Linked Courses"
    When I update the manage course offering agendas page
    Then the "agenda" page should have the text "Must have successfully completed all courses from,HIST110,HIST210,CORE: Life Science Lab-Linked Courses"
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should have the text "Must have successfully completed all courses from,HIST110,HIST210,CORE: Life Science Lab-Linked Courses"
    When I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must have successfully completed all courses from (BSCI124, HIST210, HIST110)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed all courses from,HIST110,HIST210,CORE: Life Science Lab-Linked Courses"

  #ELIG9.2.EB1.3 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Recommended Preparation - rule three
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "ENGL304"
    And I want to edit the selected agenda section
    And I add a number of courses statement after node "C" with number "1" and courses "HIST213,HIST204,HIST208" and course sets "CORE: Life Science Lab-Linked Courses (LL)"
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 1 course from (HIST204, HIST213, HIST208, BSCI124)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed a minimum of 1 course from,HIST204,HIST208,HIST213,CORE: Life Science Lab-Linked Courses"
    When I update the manage course offering agendas page
    Then the "agenda" page should have the text "Must have successfully completed a minimum of 1 course from,HIST204,HIST208,HIST213,CORE: Life Science Lab-Linked Courses"
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should have the text "Must have successfully completed a minimum of 1 course from,HIST204,HIST208,HIST213,CORE: Life Science Lab-Linked Courses"
    When I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 1 course from (BSCI124, HIST204, HIST213, HIST208)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed a minimum of 1 course from,HIST204,HIST208,HIST213,CORE: Life Science Lab-Linked Courses"

  #ELIG9.2.EB1.4 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Recommended Preparation - rule four
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "ENGL304"
    And I want to edit the selected agenda section
    And I add a number of courses statement after node "D" with number "1" and courses "HIST250,HIST798" and course sets "General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 1 course from (HIST798, HIST250, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed a minimum of 1 course from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"
    When I update the manage course offering agendas page
    Then the "agenda" page should have the text "Must have successfully completed a minimum of 1 course from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should have the text "Must have successfully completed a minimum of 1 course from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"
    When I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 1 course from (ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394, HIST798, HIST250)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed a minimum of 1 course from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"

  #ELIG9.2.EB2 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Antirequisite - rule one
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "ENGL304"
    And I want to add a new statement to the selected agenda section
    And I add a new course statement with course "HIST250"
    Then the text "Must not have successfully completed HIST250" should show correctly on all pages

  #ELIG9.2.EB3.1 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Corequisite - rule one
    When I navigate to the agenda page for "Corequisite" for term "201301" and course "HIST110"
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with courses "HIST250,HIST798" and course sets "General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must be concurrently enrolled in all courses from (HIST798, HIST250, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must be concurrently enrolled in all courses from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"
    When I update the manage course offering agendas page
    Then the "agenda" page should have the text "Must be concurrently enrolled in all courses from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should have the text "Must be concurrently enrolled in all courses from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"
    When I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must be concurrently enrolled in all courses from (ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394, HIST798, HIST250)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must be concurrently enrolled in all courses from,HIST250,HIST798,General Education: Fundamental Studies-Professional Writing"

  #ELIG9.2.EB3.2 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Corequisite - rule two
    When I navigate to the agenda page for "Corequisite" for term "201301" and course "HIST110"
    And I want to edit the selected agenda section
    And I add a number of courses statement after node "A" with number "1" and courses "HIST250,HIST210" and course sets "General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must be concurrently enrolled in a minimum of 1 course from (HIST210, HIST250, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must be concurrently enrolled in a minimum of 1 course from,HIST210,HIST250,General Education: Fundamental Studies-Professional Writing"
    When I update the manage course offering agendas page
    Then the "agenda" page should have the text "Must be concurrently enrolled in a minimum of 1 course from,HIST210,HIST250,General Education: Fundamental Studies-Professional Writing"
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should have the text "Must be concurrently enrolled in a minimum of 1 course from,HIST210,HIST250,General Education: Fundamental Studies-Professional Writing"
    When I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must be concurrently enrolled in a minimum of 1 course from (ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394, HIST210, HIST250)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must be concurrently enrolled in a minimum of 1 course from,HIST210,HIST250,General Education: Fundamental Studies-Professional Writing"

  #ELIG9.2.EB3.3 (KSENROLL-6954)
  @pending
  Scenario: Confirm that the natural language displays all rules correctly for Corequisite - rule three
    When I navigate to the agenda page for "Corequisite" for term "201301" and course "HIST110"
    And I want to edit the selected agenda section
    And I add a course statement after node "B" with course "HIST798"
    Then the "edit" tab should have the text "Must be concurrently enrolled in HIST798"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must be concurrently enrolled in HIST798"
    When I update the manage course offering agendas page
    Then the "agenda" page should have the text "Must be concurrently enrolled in HIST798"
    When I commit and return to see the changes made to the proposition
    Then the "agenda" page should have the text "Must be concurrently enrolled in HIST798"
    When I want to edit the selected agenda section
    Then the "edit" tab should have the text "Must be concurrently enrolled in HIST798"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must be concurrently enrolled in HIST798"
