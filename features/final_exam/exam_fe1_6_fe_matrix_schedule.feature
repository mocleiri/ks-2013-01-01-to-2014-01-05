Feature: SA.FE1-6 Manage the Final Exam Matrix so that FEs can be Scheduled in predetermined ways
  FE 1.6: As a Central Administrator I want to create and manage the final exam matrix so that final examinations
  can be scheduled in predetermined ways

  Background:
    Given I am logged in as admin

  #FE1.6.EB1 (KSENROLL-9796)
  @pending
  Scenario: Test that after submitting to the DB the new rule still exists in the Standard FE section
    When I add a Standard Final Exam timeslot rule to the Final Exam Matrix
    And I submit and return to see my changes
    Then I should be able to see the newly created timeslot rule in the Standard Final Exam table

  #FE1.6.EB2 (KSENROLL-9796)
  @pending
  Scenario: Test that after submitting to the DB the new free form text rule still exists in the Standard FE section
    When I add a Standard Final Exam text rule to the Final Exam Matrix
    And I submit and return to see my changes
    Then I should be able to see the newly created text rule in the Standard Final Exam table

  #FE1.6.EB3 (KSENROLL-9796)
  @pending
  Scenario: Test that editing a previously created rule will be persisted to the DB
    Given I have added a Standard Final Exam timeslot rule to the Final Exam Matrix
    When I edit a Standard Final Exam rule
    And I submit and return to see my changes
    Then I should be able to see the edited timeslot rule in the Standard Final Exam table

  #FE1.6.EB4 (KSENROLL-9796)
  @pending
  Scenario: Test that editing a previously created text rule will be persisted to the DB
    Given I have added a Standard Final Exam text rule to the Final Exam Matrix
    When I edit a Standard Final Exam text rule
    And I submit and return to see my changes
    Then I should be able to see the edited text rule in the Standard Final Exam table

  #FE1.6.EB5 (KSENROLL-9796)
  @pending
  Scenario: Test that the Days are sorted from beginning to end in the table
    When I view the Standard Final Exam rules on the Final Exam Matrix
    Then the rules should be sorted on the Days and Time columns

  #FE1.6.EB6 (KSENROLL-9796)
  @pending
  Scenario: Test that deleting a rule statement and then updating will give a validation message
    Given I have added a Standard Final Exam text rule to the Final Exam Matrix
    When I delete a statement in the Standard Final Exam text rule
    Then there should be a validation message displayed stating "Cannot 'Update Rule' until at least one"

  #FE1.6.EB7 (KSENROLL-9796)
  @pending
  Scenario: Test that multiple statements can be added to one rule on the Final Exam Matrix
    When I add multiple statements to a Common Final Exam rule on the Final Exam Matrix
    And I submit and return to see my changes
    Then I should be able to see the Common Final Exam rule with the multiple statements

  #FE1.6.EB8 (KSENROLL-9796)
  @pending
  Scenario: Test that editing or adding rules and submitting multiple times works as expected
    Given I have added two Standard Final Exam rules to the Final Exam Matrix
    When I submit after editing the newly created Standard Final Exam rules
    Then I should be able to see all the changes I have made on the Final Exam Matrix

  #FE1.6.EB9 (KSENROLL-9796)
  @pending
  Scenario: Test that deleting an existing rule works as expected
    When I delete an existing Standard Final Exam text rule to the Final Exam Matrix
    And I submit and return to see my changes
    Then the deleted text rule should not exist on the Final Exam Matrix
