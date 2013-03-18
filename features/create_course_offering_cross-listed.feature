@pending
Feature: Create Course Offering cross-listed
  CCO 1.1 "As a Department Scheduling Coordinator, I want to Create from Catalog a Course Offering which is defined
  in the CLU as Cross-listed so that I may complete my Course Offerings inventory for the Term."

Background:
  Given I am logged in as admin

  @Wip
  @brandon.gresham
  Scenario: Create a cross-listed Course Offering
    When I designate a valid term and cross-listed Catalog Course Code
    And I create a Course Offering with selected cross-listed Catalog Course Code
    And the cross-listing is indicated for the alias Course Offering
    And the cross-listing is indicated for the owner Course Offering
    And the copy-link is not showing for the alias

  Scenario: Remove a cross-listed Course Offering
    When I designate a valid term and cross-listed Catalog Course Code
    And I create a Course Offering without selected cross-listed Catalog Course Code
    Then the alias course does not exist
    And no cross-listing is indicated for the owner course

