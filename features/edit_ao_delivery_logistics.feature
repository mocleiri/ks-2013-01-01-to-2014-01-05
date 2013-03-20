@draft
Feature: Edit an AO to allow changing of it's actual delivery logistics

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: I am able to access the ActivityOfferingEdit-SchedulePage after the mass scheduling event in order to revise delivery logistics
    When I navigate to the edit activity offering for a course offering for a term in "final edits"
    Then I have access to add new delivery logistics


  #@pending
  #@bjg
  #Scenario: Revise an AO's actual delivery logistics
  #  When I revise an AO's actual delivery logistics
  #  Then the AO's delivery logistics shows the new schedule