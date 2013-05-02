@nightly
Feature: Add Activity Offerings to existing Course Offerings

  As a Departmental administrator, I want to be able to add additional Activity Offerings either by copying or creating
  new Activity Offerings so that the Course Offering will have additional associated Activity Offerings for the term.

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: Add new Activity Offerings - COC view
    When I manage an existing Course Offering in "Course Offering Code" view
    Then I am able to add an Activity Offering
    And verify the new Activity Offering appears on the list

  Scenario: Add new Activity Offerings - Subject Code view
    When I manage an existing Course Offering in "Subject Code" view
    Then I am able to add an Activity Offering
    And verify the new Activity Offering appears on the list

  Scenario: Copy Activity Offerings - COC view
    When I manage an existing Course Offering in "Course Offering Code" view
    Then I am able to copy an Activity Offering
    And verify the new Activity Offering appears on the list

  Scenario: Copy Activity Offerings - Subject Code view
    When I manage an existing Course Offering in "Subject Code" view
    Then I am able to copy an Activity Offering
    And verify the new Activity Offering appears on the list

### INTEGRATE THIS:
#  Feature: populate RDLs in various copying processes and rollover process

#  As a Schedule Coordinator, when copying a source AO to a new AO in the same term, I want actual or requested
#  delivery-logistics to be copied into the new AO's requested delivery logistics.

#  Background:
#    Given I am logged in as a Schedule Coordinator
#    Given I am managing a course offering that has Offered AOs

#  Scenario: Copy ADL from a source AO to RDL of a new AO from the current term
#    When I copy an AO with ADL to a new AO in the same term
#    Then The new AO is Successfully created
#REWORD:    And The ADL is Successfully copied to the new AO
#TO (see step in below scenario): And the ADL is Successfully copied to RDL in the new AO

#  Scenario: Copy RDL from a source AO to RDL of a new AO from the current term
#    When I copy an AO with RDL to a new AO in the same term
  #SUBSTITUTE FROM:    Then The new AO with RDL is Successfully created
  #TO (see step in above scenario): Then the new AO is Successfully created
#    And The RDL is Successfully copied to RDL in the new AO