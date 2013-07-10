Feature: KRMS.Rule Statements

  Background:
    Given I am logged in as admin

  #KSENROLL-7606 EB1
  @pending
  Scenario: Any program rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new any program statement
    Then the edit tab's text should match "Must be admitted to any program offered at the course campus location"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must be admitted to any program offered at the course campus location"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must be admitted to any program offered at the course campus location"

  #KSENROLL-7606 EB2
  @pending
  Scenario: Any program rule - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "ENGL206" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new any program statement
    Then the edit tab's text should match "Must be admitted to any program offered at the course campus location"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must be admitted to any program offered at the course campus location"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must be admitted to any program offered at the course campus location"
    When I commit changes made to the proposition

  #KSENROLL-7607
  @pending
  Scenario: Permission instructor rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new permission of instructor required statement
    Then the edit tab's text should match "Permission of instructor required"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Permission of instructor required"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Permission of instructor required"

  #KSENROLL-7608
  @pending
  Scenario: Program rule - Student Eligibility & Prerequisite
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new program statement with program code "STATM"
    Then the edit tab's text should match "Must have been admitted to the Mathematical Statistics (Master's) program"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have been admitted to the Mathematical Statistics (Master's) program"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have been admitted to the Mathematical Statistics (Master's) program"

  #KSENROLL-7609
  @pending
  Scenario: Program rule - Antirequisite
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new program statement with program code "STATD"
    Then the edit tab's text should match "Must not have been admitted to the Mathematical Statistics (Doctoral) program"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have been admitted to the Mathematical Statistics (Doctoral) program"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have been admitted to the Mathematical Statistics (Doctoral) program"

  #KSENROLL-7610 EB1
  @pending
  Scenario: Course and as of term rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new course and as of term statement with course "BSCI103" and term "201301"
    Then the edit tab's text should match "Must have successfully completed BSCI103 as of Spring 2013"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed BSCI103 as of Spring 2013"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed BSCI103 as of Spring 2013"

  #KSENROLL-7610 EB2
  @pending
  Scenario: Course and as of term rule - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "ENGL201" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new course and as of term statement with course "ENGL101" and term "201108"
    Then the edit tab's text should match "Must have successfully completed ENGL101 as of Fall 2011"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed ENGL101 as of Fall 2011"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed ENGL101 as of Fall 2011"
    When I commit changes made to the proposition

  #KSENROLL-7611 EB1
  @pending
  Scenario: Course and prior to term rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new course and prior to term statement with course "BSCI201" and term "201301"
    Then the edit tab's text should match "Must have successfully completed BSCI201 prior to Spring 2013"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed BSCI201 prior to Spring 2013"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed BSCI201 prior to Spring 2013"

  #KSENROLL-7611 EB2
  @pending
  Scenario: Course and prior to term rule - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "ENGL454" in the historic term
    And I want to edit the selected agenda section
    And I add a course and prior to term statement after node "A" with course "ENGL244" and term "201108"
    Then the edit tab's text should match "Must have successfully completed ENGL244 prior to Fall 2011"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed ENGL244 prior to Fall 2011"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed ENGL244 prior to Fall 2011"
    When I commit changes made to the proposition

  #KSENROLL-7612 EB1
  @pending
  Scenario: Course between two terms rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new course and two terms statement with course "PHYS275" between terms one "201208" and two "201301"
    Then the edit tab's text should match "Must have successfully completed PHYS275 between Fall 2012 and Spring 2013"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed PHYS275 between Fall 2012 and Spring 2013"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed PHYS275 between Fall 2012 and Spring 2013"

  #KSENROLL-7612 EB2
  @pending
  Scenario: Course between two terms rule - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "ENGL202" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new course and two terms statement with course "ENGL101" between terms one "201105" and two "201201"
    Then the edit tab's text should match "Must have successfully completed ENGL101 between Summer I 2011 and Spring 2012"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed ENGL101 between Summer I 2011 and Spring 2012"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed ENGL101 between Summer I 2011 and Spring 2012"
    When I commit changes made to the proposition

  #KSENROLL-7613 EB1
  @pending
  Scenario: Program and class standing rule
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new program and class standing statement with program code "STATD" and class standing "CORE"
    Then the edit tab's text should match "Must not have been admitted to the Mathematical Statistics (Doctoral) Program with a class standing of Core"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have been admitted to the Mathematical Statistics (Doctoral) Program with a class standing of Core"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have been admitted to the Mathematical Statistics (Doctoral) Program with a class standing of Core"

  #KSENROLL-7613 EB2
  @pending
  Scenario: Program and class standing rule - non-UMD
    When I navigate to the Antirequisite section for course "WMST498H" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new program and class standing statement with program code "49905" and class standing "Freshman"
    Then the edit tab's text should match "Must not have been admitted to the Women's Studies Program with a class standing of Freshman"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have been admitted to the Women's Studies Program with a class standing of Freshman"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have been admitted to the Women's Studies Program with a class standing of Freshman"
    When I commit changes made to the proposition

  #KSENROLL-7583 EB1
  @bug @KSENROLL-7811
  Scenario: No more number of courses rule with approved courses
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new no more than number of courses statement with number "1" and courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must have successfully completed no more than 1 course from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed no more than 1 course from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed no more than 1 course from,BSCI103,BSCI202"

  #KSENROLL-7583 EB2
  @bug @KSENROLL-7811
  Scenario: No more number of courses rule with course sets
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new no more than number of courses statement with number "2" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must have successfully completed no more than 2 courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed no more than 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed no more than 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7539
  @pending
  Scenario: No more number of courses rule with approved courses - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "ENGL201" in the historic term
    And I want to edit the selected agenda section
    And I add a no more than number of courses statement after node "A" with number "2" and courses "ENGL205,ENGL206,ENGL305"
    Then the edit tab's text should match "Must have successfully completed no more than 2 courses from (ENGL205, ENGL305, ENGL206)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed no more than 2 courses from,ENGL205,ENGL206,ENGL305"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed no more than 2 courses from,ENGL205,ENGL206,ENGL305"
    When I commit changes made to the proposition

  #KSENROLL-7614
  @pending
  Scenario: Program offered by org rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new program offered by org statement with "Summer Term-PUAF"
    Then the edit tab's text should match "Must have been admitted to a Program offered by EXST-Summer Term"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have been admitted to a Program offered by EXST-Summer Term"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have been admitted to a Program offered by EXST-Summer Term"

  #KSENROLL-7615 EB1
  @pending
  Scenario: Class standing rule - Student Eligibility & Prerequisite
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new class standing statement with class standing "CORE"
    Then the edit tab's text should match "Student must be in a class standing of Core"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Student must be in a class standing of Core"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Student must be in a class standing of Core"

  #KSENROLL-7615 EB2
  @pending
  Scenario: Class standing rule - Student Eligibility & Prerequisite - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "ENGL498" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new class standing statement with class standing "Senior"
    Then the edit tab's text should match "Student must be in a class standing of Senior"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Student must be in a class standing of Senior"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Student must be in a class standing of Senior"
    When I commit changes made to the proposition

  #KSENROLL-7615 EB3
  @pending
  Scenario: Class standing rule - Antirequisite - non-UMD
    When I navigate to the Antirequisite section for course "ENGL409L" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new class standing statement with class standing "Freshman"
    Then the edit tab's text should match "Must not be in a class standing of Freshman"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not be in a class standing of Freshman"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not be in a class standing of Freshman"
    When I commit changes made to the proposition

  #KSENROLL-7616
  @pending
  Scenario: Class standing or greater rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new class standing or greater statement with class standing "CORE"
    Then the edit tab's text should match "Student must be in a class standing of Core or greater"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Student must be in a class standing of Core or greater"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Student must be in a class standing of Core or greater"

  #KSENROLL-7617 EB1
  @pending
  Scenario: Class standing or less rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new class standing or less statement with class standing "CORE"
    Then the edit tab's text should match "Student must be in a class standing of Core or less"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Student must be in a class standing of Core or less"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Student must be in a class standing of Core or less"

  #KSENROLL-7617 EB2
  @pending
  Scenario: Class standing or less rule - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "ENGL241" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new class standing or less statement with class standing "Junior"
    Then the edit tab's text should match "Student must be in a class standing of Junior or less"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Student must be in a class standing of Junior or less"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Student must be in a class standing of Junior or less"
    When I commit changes made to the proposition

  #KSENROLL-7618
  @pending
  Scenario: Class standing rule - Antirequisite
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new class standing statement with class standing "CORE"
    Then the edit tab's text should match "Must not be in a class standing of Core"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not be in a class standing of Core"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not be in a class standing of Core"

  #KSENROLL-7619
  @pending
  Scenario: Permission of administering org rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new permission of administering org statement with org "Beyond the Classroom"
    Then the edit tab's text should match "Permission of UGST-Dean-Beyond the Classroom required"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Permission of UGST-Dean-Beyond the Classroom required"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Permission of UGST-Dean-Beyond the Classroom required"

  #KSENROLL-7588 EB1
  @pending
  Scenario: No more number of credits rule with approved courses
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new no more than credits statement with number "4" and courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must successfully complete no more than 4 credits from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must successfully complete no more than 4 credits from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must successfully complete no more than 4 credits from,BSCI103,BSCI202"

  #KSENROLL-7588 EB2
  @pending
  Scenario: No more number of credits rule with course sets
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new no more than credits statement with number "16" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must successfully complete no more than 16 credits from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must successfully complete no more than 16 credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must successfully complete no more than 16 credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7588 EB3
  @pending
  Scenario: No more number of credits rule with approved courses - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "PHYS174" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new no more than credits statement with number "2" and courses "PHYS112,PHYS141,PHYS171"
    Then the edit tab's text should match "Must successfully complete no more than 2 credits from (PHYS171, PHYS141, PHYS112)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must successfully complete no more than 2 credits from,PHYS112,PHYS141,PHYS171"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must successfully complete no more than 2 credits from,PHYS112,PHYS141,PHYS171"
    When I commit changes made to the proposition

  #KSENROLL-7590 EB1
  @pending
  Scenario: Any credits rule with approved courses
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new any credits statement with courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must not have successfully completed any credits from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have successfully completed any credits from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have successfully completed any credits from,BSCI103,BSCI202"

  #KSENROLL-7590 EB2
  @pending
  Scenario: Any credits rule with course sets
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new any credits statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must not have successfully completed any credits from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have successfully completed any credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have successfully completed any credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7590 EB3
  @pending
  Scenario: Any credits rule with approved courses - non-UMD
    When I navigate to the Antirequisite section for course "ENGL429" in the historic term
    And I want to add a new statement to the selected agenda section
    And I add a new any credits statement with courses "ENGL440,ENGL611,ENGL313,ENGL373"
    Then the edit tab's text should match "Must not have successfully completed any credits from (ENGL611, ENGL313, ENGL373, ENGL440)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have successfully completed any credits from,ENGL313,ENGL373,ENGL440,ENGL611"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have successfully completed any credits from,ENGL313,ENGL373,ENGL440,ENGL611"
    When I commit changes made to the proposition

  #KSENROLL-7602
  @pending
  Scenario: Repeated for credits rule
    When I navigate to the Repeatable for Credit section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new repeated for credits statement with "4" credits
    Then the edit tab's text should match "May be repeated for a maximum of 4 credits"
    When I switch to the other tab on the page
    Then the logic tab's text should match "May be repeated for a maximum of 4 credits"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "May be repeated for a maximum of 4 credits"

  #KSENROLL-7604 EB1
  @pending
  Scenario: Minimum credits and org rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new minimum number of credits and org rule with "4" credits and org "Beyond the Classroom"
    Then the edit tab's text should match "Must have successfully completed a minimum of 4 credits from courses in the UGST-Dean-Beyond the Classroom"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed a minimum of 4 credits from courses in the UGST-Dean-Beyond the Classroom"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed a minimum of 4 credits from courses in the UGST-Dean-Beyond the Classroom"

  #KSENROLL-7604 EB2
  @pending
  Scenario: Minimum credits and org rule - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "PHYS604" in the historic term
    And I want to edit the selected agenda section
    And I add a minimum number of credits and org rule after node "A" with "5" credits and org "Applied Math"
    Then the edit tab's text should match "Must have successfully completed a minimum of 5 credits from courses in the CMNS-Applied Mathematics"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed a minimum of 5 credits from courses in the CMNS-Applied Mathematics"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed a minimum of 5 credits from courses in the CMNS-Applied Mathematics"
    When I commit changes made to the proposition

  #KSENROLL-7597 EB1
  @pending
  Scenario: Gpa and duration rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new gpa and duration statement with GPA of "2.8" and duration type "Week" with duration "10"
    Then the edit tab's text should match "Must have earned a minimum Cumulative GPA of 2.8 in 10 weeks"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum Cumulative GPA of 2.8 in 10 weeks"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum Cumulative GPA of 2.8 in 10 weeks"

  #KSENROLL-7597 EB2
  @pending
  Scenario: Gpa and duration rule - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "PHYS399" in the historic term
    And I want to edit the selected agenda section
    And I add a gpa and duration statement after node "A" with GPA of "3.0" and duration type "Term" with duration "2"
    Then the edit tab's text should match "Must have earned a minimum Cumulative GPA of 3.0 in 2 terms"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum Cumulative GPA of 3.0 in 2 terms"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum Cumulative GPA of 3.0 in 2 terms"
    When I commit changes made to the proposition

  #KSENROLL-7595 EB1
  @pending
  Scenario: Gpa and courses rule with approved courses
    When I navigate to the Recommended Preparation section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new gpa and courses statement with courses "BSCI103,BSCI202" and GPA of "3.3"
    Then the edit tab's text should match "Must have earned a minimum GPA of 3.3 in (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum GPA of 3.3 in,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum GPA of 3.3 in,BSCI103,BSCI202"

  #KSENROLL-7595 EB2
  @pending
  Scenario: Gpa and courses rule with course sets
    When I navigate to the Recommended Preparation section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new gpa and courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing" and GPA of "4.0"
    Then the edit tab's text should match "Must have earned a minimum GPA of 4.0 in (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum GPA of 4.0 in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum GPA of 4.0 in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7595 EB3
  @pending
  Scenario: Gpa and courses rule with approved courses - non-UMD
    When I navigate to the Student Eligibility & Prerequisite section for course "WMST400" in the historic term
    And I want to edit the selected agenda section
    And I add a new gpa and courses statement with courses "WMST336,WMST300" and GPA of "2.5"
    Then the edit tab's text should match "Must have earned a minimum GPA of 2.5 in (WMST336, WMST300)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum GPA of 2.5 in,WMST300,WMST336"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum GPA of 2.5 in,WMST300,WMST336"
    When I commit changes made to the proposition

  #KSENROLL-7527
  @pending
  Scenario: Single course rule - Student Eligibility & Prerequisite
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new course statement with course "BSCI103"
    Then the edit tab's text should match "Must have successfully completed BSCI103"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed BSCI103"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed BSCI103"

  #KSENROLL-7582 EB1
  @pending
  Scenario: All courses rule with approved courses - Recommended Preparation
    When I navigate to the Recommended Preparation section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must have successfully completed all courses from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed all courses from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed all courses from,BSCI103,BSCI202"

  #KSENROLL-7582 EB2
  @pending
  Scenario: All courses rule with course sets - Recommended Preparation
    When I navigate to the Recommended Preparation section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must have successfully completed all courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed all courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed all courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7603
  @pending
  Scenario: Free form text rule
    When I navigate to the Corequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new free form text statement with text "free input value"
    Then the edit tab's text should match "free input value"
    When I switch to the other tab on the page
    Then the logic tab's text should match "free input value"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "free input value"

  #KSENROLL-7601
  Scenario: Minimum total credits rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new minimum total credits statement with "8" credits
    Then the edit tab's text should match "Must have earned a minimum of 8 total credits"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum of 8 total credits"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum of 8 total credits"

  #KSENROLL-7600 EB1
  @pending
  Scenario: Grade and number of courses rule with approved courses
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new grade and number of courses statement with number "1" and courses "BSCI103,BSCI202" and grade type "Percentage" with grade "0-59%"
    Then the edit tab's text should match "Must successfully complete a minimum of 1 course with a minimum grade of 0-59% from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must successfully complete a minimum of 1 course with a minimum grade of 0-59% from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must successfully complete a minimum of 1 course with a minimum grade of 0-59% from,BSCI103,BSCI202"

  #KSENROLL-7600 EB2
  @pending
  Scenario: Grade and number of courses rule with course sets
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new grade and number of courses statement with number "2" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing" and grade type "Letter" with grade "A"
    Then the edit tab's text should match "Must successfully complete a minimum of 2 courses with a minimum grade of A from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must successfully complete a minimum of 2 courses with a minimum grade of A from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must successfully complete a minimum of 2 courses with a minimum grade of A from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7599 EB1
  @pending
  Scenario: Grade and courses rule with approved courses
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new grade and courses statement with courses "BSCI103,BSCI202" and grade type "Completed Notation" with grade "Completed"
    Then the edit tab's text should match "Must have earned a minimum grade of Completed in (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum grade of Completed in,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum grade of Completed in,BSCI103,BSCI202"

  #KSENROLL-7599 EB2
  @pending
  Scenario: Grade and courses rule with course sets
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new grade and courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing" and grade type "Letter" with grade "A"
    Then the edit tab's text should match "Must have earned a minimum grade of A in (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum grade of A in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum grade of A in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7598 EB1
  @pending
  Scenario: Grade and courses rule with approved courses - Antirequisite
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new grade and courses statement with courses "BSCI103,BSCI202" and grade type "Percentage" with grade "0-59%"
    Then the edit tab's text should match "Must not have earned a maximum grade of 0-59% or higher in (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have earned a maximum grade of 0-59% or higher in,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have earned a maximum grade of 0-59% or higher in,BSCI103,BSCI202"

  #KSENROLL-7598 EB2
  @pending
  Scenario: Grade and courses rule with course sets - Antirequisite
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new grade and courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing" and grade type "Letter" with grade "A"
    Then the edit tab's text should match "Must not have earned a maximum grade of A or higher in (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have earned a maximum grade of A or higher in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have earned a maximum grade of A or higher in,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7596
  @pending
  Scenario: Cumulative gpa rule
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new gpa statement with GPA of "2.8"
    Then the edit tab's text should match "Must have earned a minimum cumulative GPA of 2.8"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have earned a minimum cumulative GPA of 2.8"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have earned a minimum cumulative GPA of 2.8"

  #KSENROLL-7594
  @pending
  Scenario: Concurrently enrolled course rule
    When I navigate to the Corequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new course statement with course "BSCI103"
    Then the edit tab's text should match "Must be concurrently enrolled in BSCI103"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must be concurrently enrolled in BSCI103"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must be concurrently enrolled in BSCI103"

  #KSENROLL-7593 EB1
  @pending
  Scenario: Concurrently enrolled courses rule with approved courses
    When I navigate to the Corequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new number of courses statement with number "1" and courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must be concurrently enrolled in a minimum of 1 course from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must be concurrently enrolled in a minimum of 1 course from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must be concurrently enrolled in a minimum of 1 course from,BSCI103,BSCI202"

  #KSENROLL-7593 EB2
  @pending
  Scenario: Concurrently enrolled courses rule with course sets
    When I navigate to the Corequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new number of courses statement with number "2" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must be concurrently enrolled in a minimum of 2 courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must be concurrently enrolled in a minimum of 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must be concurrently enrolled in a minimum of 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7591 EB1
  @pending
  Scenario: Concurrently enrolled all courses rule with approved courses
    When I navigate to the Corequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must be concurrently enrolled in all courses from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must be concurrently enrolled in all courses from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must be concurrently enrolled in all courses from,BSCI103,BSCI202"

  #KSENROLL-7591 EB2
  @pending
  Scenario: Concurrently enrolled all courses rule with course sets
    When I navigate to the Corequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must be concurrently enrolled in all courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must be concurrently enrolled in all courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must be concurrently enrolled in all courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7589 EB1
  @pending
  Scenario: Minimum number of credits rule with approved courses
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new minimum credits statement with number "4" and courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must have successfully completed a minimum of 4 credits from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed a minimum of 4 credits from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed a minimum of 4 credits from,BSCI103,BSCI202"

  #KSENROLL-7588 EB2
  @pending
  Scenario: Minimum number of credits rule with course sets
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new minimum credits statement with number "16" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must have successfully completed a minimum of 16 credits from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed a minimum of 16 credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed a minimum of 16 credits from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7587
  @pending
  Scenario: Single course rule - Antirequisite
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new course statement with course "BSCI103"
    Then the edit tab's text should match "Must not have successfully completed BSCI103"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have successfully completed BSCI103"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have successfully completed BSCI103"

  #KSENROLL-7585 EB1
  @pending
  Scenario: Any courses rule with approved courses
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must not have successfully completed any courses from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have successfully completed any courses from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have successfully completed any courses from,BSCI103,BSCI202"

  #KSENROLL-7585 EB2
  @pending
  Scenario: Any courses rule with course sets
    When I navigate to the Antirequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new courses statement with course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must not have successfully completed any courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must not have successfully completed any courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must not have successfully completed any courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"

  #KSENROLL-7584 EB1
  @pending
  Scenario: Minimum number courses rule with approved courses
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new number of courses statement with number "1" and courses "BSCI103,BSCI202"
    Then the edit tab's text should match "Must have successfully completed a minimum of 1 course from (BSCI103, BSCI202)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed a minimum of 1 course from,BSCI103,BSCI202"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed a minimum of 1 course from,BSCI103,BSCI202"

  #KSENROLL-7593 EB2
  @pending
  Scenario: Minimum number courses rule with course sets
    When I navigate to the Student Eligibility & Prerequisite section for course "BSCI361" in the future term
    And I want to add a new statement to the selected agenda section
    And I add a new number of courses statement with number "2" and course sets "CORE: Life Science Lab-Linked Courses (LL),General Education: Fundamental Studies-Professional Writing"
    Then the edit tab's text should match "Must have successfully completed a minimum of 2 courses from (BSCI124, ENGL381, ENGL390, ENGL392, ENGL395, ENGL391, ENGL393, ENGL394)"
    When I switch to the other tab on the page
    Then the logic tab's text should match "Must have successfully completed a minimum of 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
    When I update the manage course offering agendas page
    Then the agenda page's text should match "Must have successfully completed a minimum of 2 courses from,BSCI124,ENGL381,ENGL390,ENGL391,ENGL392,ENGL393,ENGL394,ENGL395"
