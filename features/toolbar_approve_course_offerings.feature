@wip
Feature: Approve Course Offering Toolbar Button

  As a user, I want to Approve my Course Offerings from the Subject Code display of the Manage Course Offerings process
  by means of a Toolbar Button so I can more easily manage my Course Offerings.

Background:
  Given I am logged in as admin
  And term contains COs in Draft state

Scenario: Approve single Course Offering via Subject Code display toolbar (CANCEL action)
  When I select a course offering containing at least one activity in Draft state
  And I click the "Approve" toolbar button
  And I cancel the action
  Then the list of courses remains unchanged
  And Draft activity offerings remain in Draft state

Scenario: Approve single Course Offering via Subject Code display toolbar
  When I select a course offering containing at least one activity in Draft state
  And I click the "Approve" toolbar button
  And I confirm the operation
  Then the course offering is in Planned state
  And its activity offerings are in Approved state

Scenario: Approve multiple Course Offerings via Subject Code display toolbar (CANCEL action)
  When I select multiple course offerings each containing at least one activity in Draft state
  And I click the "Approve" toolbar button
  And I cancel the action
  Then the list of courses remains unchanged
  And Draft activity offerings remain in Draft state

Scenario: Approve multiple Course Offerings via Subject Code display toolbar
  When I select multiple course offerings each containing at least one activity in Draft state
  And I click the "Approve" toolbar button
  And I confirm the operation
  Then the selected course offerings are in Planned state
  And their activity offerings are in Approved state
