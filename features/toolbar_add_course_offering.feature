@pending
Feature: Add Course Offering toolbar button

  As a user, I want to Add Courses from the Subject Code display of the Manage Course Offerings process by means of a Toolbar Button
  so I can more easily manage my Course Offerings.

Background:
  Given I am logged in as admin

Scenario: Add Course Offering via Subject Code display toolbar
  When I manage a valid course offering
  And I click the "Add Course" toolbar button
  Then the term is retained in the term field on the Create Course Offering page
  And I am able to create a Course Offering with this term
