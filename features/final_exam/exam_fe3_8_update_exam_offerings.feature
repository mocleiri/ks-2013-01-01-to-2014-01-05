@draft
Feature: FE 3.8 Update Exam Offerings

 Background:
   Given I am logged in as admin

@draft
Scenario: Update Course Offering from Final Exam to No final exam or assessment
  Given There is a course offering set to Final Exam
    When I select a final exam type of "No Final Exam or assessment"
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


Scenario: Update Course Offering from Final Exam to Standard Final Exam with Activity Offering
 Given There is a course offering set to Final Exam
    When I select a final exam type of "Standard Final Exam"
    And a final exam driver of "Activity Offering"
    Then there should be a Course Offering table that is in the Draft state
