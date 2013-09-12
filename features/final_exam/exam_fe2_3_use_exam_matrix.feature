Feature: SA.FE2-3 Use Exam Matrix or not
  FE 2.3 As a Central Administrator I want to identify if the exam offering(s) for a course offering will be
  scheduled according to a matrix or another means so that delivery logistics for exam offerings can be
  appropriately populated

  Background:
    Given I am logged in as admin

  #FE2.3.EB1 (KSENROLL-9244)
  @pending
  Scenario: Test whether the Use Exam Matrix checkbox is only available for Standard FE
    When I create a Course Offering from catalog with a final exam period
    Then the Use Exam Matrix checkbox should only be present for the Standard Final Exam

  #FE2.3.EB2 (KSENROLL-9244)
  @pending
  Scenario: Test whether the user can choose between matrix only, no matrix or both after Use Exam Matrix has been selected
    When I create a Course Offering from catalog with a final exam period
    Then there should be three options to choose from after the Use Exam Matrix checkbox has been selected
