@draft
Feature: FE 3.8 Update Exam Offerings

  Background:
    Given I am logged in as admin

#---------Old-----------------
#@draft
#Scenario: Update Course Offering from Final Exam to No final exam or assessment
#  Given There is a course offering set to Final Exam
#    When I select a final exam type of "No Final Exam or assessment"
#   Then there should be a Course Offering table that is in the Cancelled state
#---------Old-----------------

@draft
Scenario: Update Course Offering to No final exam or assessment
    When I view the Exam Offerings for a CO created from an existing CO with a standard final exam driven by Activity Offering
    Then there should be a Course Offering table that is in the Cancelled state

@draft
Scenario: Update Course Offering from Final Exam to Standard Final Exam with Course Offering
    Given There is a Course Offering set to Final Exam
    When I select a final exam type of "Standard Final Exam"
    And a final exam driver of "Course Offering"
    Then there should be a Course Offering table that is in the Draft state

@draft
Scenario: Update Course Offering from Final Exam to Alternate Final Assessment
    Given There is a Course Offering set to Final Exam
    When I select a final exam type of "Alternate Final Assessment"
    Then there should be a Course Offering table that is in the Cancelled state

@draft
Scenario: Update Course Offering from Final Exam to Standard Final Exam with Activity Offering
    Given There is a course offering set to Final Exam
  #When I select a final exam type of "Standard Final Exam"
    When I view the Exam Offerings for a CO with a standard final exam driven by Course Offering
    And a final exam driver of "Activity Offering"
    Then there should be a Course Offering table that is in the Draft state
