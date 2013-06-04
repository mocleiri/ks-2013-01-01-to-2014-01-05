@wip
Feature: EC.Toolbar state

  Background:
    Given I am logged in as a Schedule Coordinator

  Scenario: TB_Published.1 Validate CO toolbar button state for published SOC
    Given I am working on a term in "Published" SOC state
    When I manage course offerings for a subject code
    Then the expected initial state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "disabled"
    When I select a course offering in "Offered" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "enabled"

  Scenario: TB_FinalEdits.1 Validate CO toolbar button state for final edits SOC
    Given I am working on a term in "Final Edits" SOC state
    When I manage course offerings for a subject code
    Then the expected initial state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "disabled"
    Then the expected initial state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "disabled"
    When I select a course offering in "Planned" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "enabled"

  Scenario: TB_Locked.1 Validate CO toolbar button state for locked SOC
    Given I am working on a term in "Locked" SOC state
    When I manage course offerings for a subject code
    Then the expected initial state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "disabled"
    When I select a course offering in "Planned" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "enabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    And I select a course offering in "Planned" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "enabled"; Delete: "enabled"

  Scenario: TB_Open.1 Validate initial CO toolbar button state for open SOC
    Given I am working on a term in "Open" SOC state
    When I manage course offerings for a subject code
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "disabled"
    When I select a course offering in "Planned" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "enabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    And I select a course offering in "Planned" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "enabled"; Delete: "enabled"

  Scenario: TB_Draft.1 Validate initial CO toolbar button state for draft SOC - failed
    Given I am working on a term in "Draft" SOC state
    #When I manage course offerings for a subject code
    And there is an "Planned" course offering present
    And there is an "Draft" course offering present
    When I manage course offerings the specified subject code
    Then the expected initial state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "disabled"
    When I select a course offering in "Planned" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "disabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "enabled"; Delete: "enabled"
    When I select a course offering in "Draft" status
    And I select a course offering in "Planned" status
    Then the expected state of the CO toolbar is: Create: "enabled"; Approve: "enabled"; Delete: "enabled"

  Scenario: TB_Published.2A Validate AO toolbar buttons for a CO in Offered status and SOC state Published KK
    Given I am working on a term in "Published" SOC state
    And there is an "Offered" course offering present
    When I manage a course offering in the specified state
    Then the expected initial state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select an activity offering in "Offered" status
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

  Scenario: TB_Published.2B Validate AO toolbar buttons for a CO in Draft status and SOC state Published KK
    Given I am working on a term in "Published" SOC state
    And there is a "Draft" course offering present
    When I manage a course offering in the specified state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select an activity offering in "Draft" status
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

  Scenario: TB_FinalEdits.2A Validate AO toolbar buttons for a CO in Offered status and SOC state Final Edits KK
    Given I am working on a term in "Final Edits" SOC state
    And there is a "Planned" course offering present
    When I manage a course offering in the specified state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select an activity offering in "Approved" status
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

  Scenario: TB_FinalEdits.2B Validate AO toolbar buttons for a CO in Draft status and SOC state Final Edits KK
    Given I am working on a term in "Final Edits" SOC state
    And there is a "Draft" course offering present
    When I manage a course offering in the specified state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select an activity offering in "Draft" status
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

  Scenario: TB_Locked.2A Validate AO toolbar buttons for a CO in Planned status and SOC state Locked KK
    Given I am working on a term in "Locked" SOC state
    And there is a "Planned" course offering present
    When I manage a course offering in the specified state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select an activity offering in "Approved" status
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

    #TODO - add multiple selection to one of the locked tests
  Scenario: TB_Locked.2B Validate AO toolbar buttons for a CO in Draft status and SOC state Locked for multiple AO statuses KK
    Given I am working on a term in "Locked" SOC state
    And there is a "Draft" course offering present
    When I manage a course offering in the specified state
    Then the expected initial state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select an activity offering in "Draft" status
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

  Scenario: TB_Locked.2B - in progress Validate AO toolbar buttons for a CO in Planned status and SOC state Locked for multiple AO statuses
    When I manage a course offering with activity offerings in approved and draft status
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    #When I select an activity offering in "Approved" status
    When I select an activity offering in "Draft" status
     Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    And I select the second activity offering
    And I deselect the second activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

  Scenario: Validate AO toolbar button for initial state and with multiple AOs selected and changed AO status for open SOC
    Given I am working on a term in "Open" SOC state
    When I manage course offerings for a course with the first activity offering in draft state and the second activity offering in approved state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select the first activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    When I select the second activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    When I deselect the first activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    Then I deselect the second activity offering
    When I manage course offerings for a course with the first activity offering in draft state and the second activity offering in draft state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select the first activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    When I approve the first Activity Offering for scheduling
    And I select the first activity offering
    And I select the second activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    When I deselect the second activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"

  Scenario: Validate AO toolbar button for initial state and with multiple AOs selected and changed AO status for draft SOC
    Given I am working on a term in "Draft" SOC state
    And there is a Planned course offering with 2 activity offerings present
    When I manage a course offering in the specified state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select the first activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    When I approve the first Activity Offering for scheduling
    And I select the first activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    When I select the second activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    And there is a Draft course offering with 2 activity offerings present
    When I manage a course offering in the specified state
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "disabled"; Delete: "disabled"; AddCluster: "enabled"; Move: "disabled"
    When I select the first activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "disabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    When I approve the first Activity Offering for scheduling
    When I select the first activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "disabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
    And I select the second activity offering
    Then the expected state of the AO toolbar is: Create: "enabled"; Approve: "enabled"; SetAsDraft: "enabled"; Delete: "enabled"; AddCluster: "enabled"; Move: "enabled"
