Feature: Temporary feature file to test every rule statement with every associated option

  Background:
    Given I am logged in as admin

  @pending
  Scenario: Single course rule
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new course statement with course "BSCI103"
    Then the "edit" tab should have the text "Must not have successfully completed BSCI103"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not have successfully completed BSCI103"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not have successfully completed BSCI103"

  @pending
  Scenario: Free form text rule
    When I navigate to the agenda page for "Corequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new free form text statement with text "free input value"
    Then the "edit" tab should have the text "free input value"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "free input value"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "free input value"

  @pending
  Scenario: All courses rule with approved courses
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with courses "BSCI103,BSCI202"
    Then the "edit" tab should have the text "Must have successfully completed all courses from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed all courses from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed all courses from,BSCI103,BSCI202"

  @pending
  Scenario: All courses rule with course sets
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must have successfully completed all courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed all courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed all courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #Add a scenario for courses rule with course ranges

  @pending
  Scenario: Number of courses rule with approved courses
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new number of courses statement with number "1" and courses "BSCI103,BSCI202"
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 1 course from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed a minimum of 1 course from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed a minimum of 1 course from,BSCI103,BSCI202"

  @pending
  Scenario: Number of courses rule with course sets
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new number of courses statement with number "2" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 2 courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed a minimum of 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed a minimum of 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #Add a scenario for number of courses rule with course ranges

  @pending
  Scenario: Grade and courses rule with approved courses
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new grade and courses statement with courses "BSCI103,BSCI202" and grade type "Completed Notation" with grade "Completed"
    Then the "edit" tab should have the text "Must not have earned a maximum grade of Completed or higher in (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not have earned a maximum grade of Completed or higher in,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not have earned a maximum grade of Completed or higher in,BSCI103,BSCI202"

  @pending
  Scenario: Grade and courses rule with course sets
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new grade and courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing" and grade type "Letter" with grade "A"
    Then the "edit" tab should have the text "Must not have earned a maximum grade of A or higher in (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not have earned a maximum grade of A or higher in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not have earned a maximum grade of A or higher in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  @pending
  Scenario: Grade and number of courses rule with approved courses
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new grade and number of courses statement with number "1" and courses "BSCI103,BSCI202" and grade type "Percentage Grading Scale" with grade "0-59%"
    Then the "edit" tab should have the text "Must successfully complete a minimum of 1 course with a minimum grade of 0-59% from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must successfully complete a minimum of 1 course with a minimum grade of 0-59% from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must successfully complete a minimum of 1 course with a minimum grade of 0-59% from,BSCI103,BSCI202"

  @pending
  Scenario: Grade and number of courses rule with course sets
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new grade and number of courses statement with number "2" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing" and grade type "Letter" with grade "A"
    Then the "edit" tab should have the text "Must successfully complete a minimum of 2 courses with a minimum grade of A from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must successfully complete a minimum of 2 courses with a minimum grade of A from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must successfully complete a minimum of 2 courses with a minimum grade of A from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7606
  @pending
  Scenario: Any program rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new any program statement
    Then the "edit" tab should have the text "Must be admitted to any program offered at the course campus location"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must be admitted to any program offered at the course campus location"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must be admitted to any program offered at the course campus location"

  #KSENROLL-7607
  @pending
  Scenario: Permission instructor rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new permission of instructor required statement
    Then the "edit" tab should have the text "Permission of instructor required"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Permission of instructor required"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Permission of instructor required"

  #KSENROLL-7608
  @pending
  Scenario: Program rule - Student Eligibility & Prerequisite
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new program statement with program code "STATM"
    Then the "edit" tab should have the text "Must have been admitted to the Mathematical Statistics (Master's) program"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have been admitted to the Mathematical Statistics (Master's) program"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have been admitted to the Mathematical Statistics (Master's) program"

  #KSENROLL-7609
  @pending
  Scenario: Program rule - Antirequisite
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new program statement with program code "STATD"
    Then the "edit" tab should have the text "Must not have been admitted to the Mathematical Statistics (Doctoral) program"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not have been admitted to the Mathematical Statistics (Doctoral) program"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not have been admitted to the Mathematical Statistics (Doctoral) program"

  #KSENROLL-7610
  @pending
  Scenario: Course and as of term rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new course and as of term statement with course "BSCI103" and term "201301"
    Then the "edit" tab should have the text "Must have successfully completed BSCI103 as of Spring 2013"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed BSCI103 as of Spring 2013"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed BSCI103 as of Spring 2013"

  #KSENROLL-7611
  @pending
  Scenario: Course and prior to term rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new course and prior to term statement with course "BSCI201" and term "201301"
    Then the "edit" tab should have the text "Must have successfully completed BSCI201 prior to Spring 2013"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed BSCI201 prior to Spring 2013"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed BSCI201 prior to Spring 2013"

  #KSENROLL-7612
  @bug @KSENROLL-7427
  Scenario: Course between two terms rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new course and two terms statement with course "PHYS275" between terms one "201208" and two "201301"
    Then the "edit" tab should have the text "Must have successfully completed PHYS275 between Fall 2012 and Spring 2013"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed PHYS275 between Fall 2012 and Spring 2013"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed PHYS275 between Fall 2012 and Spring 2013"

  #KSENROLL-7613
  @pending
  Scenario: Program and class standing rule
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new program and class standing statement with program code "STATD" and class standing "CORE"
    Then the "edit" tab should have the text "Must not have been admitted to the Mathematical Statistics (Doctoral) Program with a class standing of Core"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not have been admitted to the Mathematical Statistics (Doctoral) Program with a class standing of Core"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not have been admitted to the Mathematical Statistics (Doctoral) Program with a class standing of Core"

  #KSENROLL-7583 EB1
  @bug @KSENROLL-7811
  Scenario: No more number of courses rule with approved courses
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new no more than number of courses statement with number "1" and courses "BSCI103,BSCI202"
    Then the "edit" tab should have the text "Must have successfully completed no more than 1 course from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed no more than 1 course from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed no more than 1 course from,BSCI103,BSCI202"

  #KSENROLL-7583 EB2
  @bug @KSENROLL-7811
  Scenario: No more number of courses rule with course sets
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new no more than number of courses statement with number "2" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must have successfully completed no more than 2 courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed no more than 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed no more than 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #Add a scenario for number of courses rule with course ranges
  ##############################################
  #KSENROLL-7614
  @pending
  Scenario: Program offered by org rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new program offered by org statement with "Summer Term-PUAF"
    Then the "edit" tab should have the text "Must have been admitted to a Program offered by EXST-Summer Term"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have been admitted to a Program offered by EXST-Summer Term"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have been admitted to a Program offered by EXST-Summer Term"

  #KSENROLL-7615
  @pending
  Scenario: Class standing rule - Student Eligibility & Prerequisite
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new class standing statement with class standing "CORE"
    Then the "edit" tab should have the text "Student must be in a class standing of Core"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Student must be in a class standing of Core"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Student must be in a class standing of Core"

  #KSENROLL-7616
  @pending
  Scenario: Class standing or greater rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new class standing or greater statement with class standing "CORE"
    Then the "edit" tab should have the text "Student must be in a class standing of Core or greater"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Student must be in a class standing of Core or greater"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Student must be in a class standing of Core or greater"

  #KSENROLL-7617
  @pending
  Scenario: Class standing or less rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new class standing or less statement with class standing "CORE"
    Then the "edit" tab should have the text "Student must be in a class standing of Core or less"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Student must be in a class standing of Core or less"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Student must be in a class standing of Core or less"

  #KSENROLL-7618
  @pending
  Scenario: Class standing rule - Antirequisite
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new class standing statement with class standing "CORE"
    Then the "edit" tab should have the text "Must not be in a class standing of Core"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not be in a class standing of Core"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not be in a class standing of Core"

  #KSENROLL-7619
  @pending
  Scenario: Permission of administering org rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new permission of administering org statement with org "Beyond the Classroom"
    Then the "edit" tab should have the text "Permission of UGST-Dean-Beyond the Classroom required"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Permission of UGST-Dean-Beyond the Classroom required"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Permission of UGST-Dean-Beyond the Classroom required"

  #KSENROLL-7588 EB1
  @pending
  Scenario: No more number of credits rule with approved courses
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new no more than credits statement with number "4" and courses "BSCI103,BSCI202"
    Then the "edit" tab should have the text "Must successfully complete no more than 4 credits from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must successfully complete no more than 4 credits from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must successfully complete no more than 4 credits from,BSCI103,BSCI202"

  #KSENROLL-7588 EB2
  @pending
  Scenario: No more number of credits rule with course sets
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new no more than credits statement with number "16" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must successfully complete no more than 16 credits from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must successfully complete no more than 16 credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must successfully complete no more than 16 credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7590 EB1
  @pending
  Scenario: Any credits rule with approved courses
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new any credits statement with courses "BSCI103,BSCI202"
    Then the "edit" tab should have the text "Must not have successfully completed any credits from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not have successfully completed any credits from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not have successfully completed any credits from,BSCI103,BSCI202"

  #KSENROLL-7590 EB2
  @pending
  Scenario: Any credits rule with course sets
    When I navigate to the agenda page for "Antirequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new any credits statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the "edit" tab should have the text "Must not have successfully completed any credits from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must not have successfully completed any credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must not have successfully completed any credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7602
  @pending
  Scenario: Repeated for credits rule
    When I navigate to the agenda page for "Repeatable for Credit" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new repeated for credits statement with "4" credits
    Then the "edit" tab should have the text "May be repeated for a maximum of 4 credits"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "May be repeated for a maximum of 4 credits"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "May be repeated for a maximum of 4 credits"

  #KSENROLL-7604
  @pending
  Scenario: Minimum credits and org rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a minimum number of credits and org rule with "4" credits and org "Beyond the Classroom"
    Then the "edit" tab should have the text "Must have successfully completed a minimum of 4 credits from courses in the UGST-Dean-Beyond the Classroom"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have successfully completed a minimum of 4 credits from courses in the UGST-Dean-Beyond the Classroom"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have successfully completed a minimum of 4 credits from courses in the UGST-Dean-Beyond the Classroom"

  #KSENROLL-7597
  @pending
  Scenario: Gpa and duration rule
    When I navigate to the agenda page for "Student Eligibility & Prerequisite" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new gpa and duration statement with GPA of "2.8" and duration type "Week" with duration "10"
    Then the "edit" tab should have the text "Must have earned a minimum Cumulative GPA of 2.8 in 10 weeks"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have earned a minimum Cumulative GPA of 2.8 in 10 weeks"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have earned a minimum Cumulative GPA of 2.8 in 10 weeks"

  #KSENROLL-7595 EB1
  @pending
  Scenario: Gpa and courses rule with approved courses
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new gpa and courses statement with courses "BSCI103,BSCI202" and GPA of "3.3"
    Then the "edit" tab should have the text "Must have earned a minimum GPA of 3.3 in (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have earned a minimum GPA of 3.3 in,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have earned a minimum GPA of 3.3 in,BSCI103,BSCI202"

  #KSENROLL-7595 EB2
  @pending
  Scenario: Gpa and courses rule with course sets
    When I navigate to the agenda page for "Recommended Preparation" for term "201301" and course "BSCI361"
    And I want to add a new statement to the selected agenda section
    And I add a new gpa and courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing" and GPA of "4.0"
    Then the "edit" tab should have the text "Must have earned a minimum GPA of 4.0 in (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the "logic" tab should have the text "Must have earned a minimum GPA of 4.0 in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page should have the text "Must have earned a minimum GPA of 4.0 in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

