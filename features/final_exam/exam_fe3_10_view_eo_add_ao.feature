Feature: SA.FE3-10 View Exam Offerings after added more Activity Offerings
  FE 3.10: As a Central Administrator I want to create AO driven exam offerings dynamically after the bulk creation
  so that new exam offerings will be created as new Activity Offerings are created

  Background:
    Given I am logged in as admin

  #FE3.10.EB1 (KSENROLL-9789)
  @pending
  Scenario: Test whether the View EO table loads the correct number of Activity Offerings
    When I view the Exam Offerings for a CO with multiple AOs and a standard final exam driven by Activity Offering
    Then there should be 2 Exam Offerings for the CO

  #FE3.10.EB2 (KSENROLL-9789)
  @pending
  Scenario: Test whether adding more AOs updates the number of Exam Offerings when the driver is Activity Offering
    When I view the Exam Offerings for a CO with two new AOs and a standard final exam driven by Activity Offering
    Then there should be 4 Exam Offerings for the CO

  #FE3.10.EB3 (KSENROLL-9789)
  @pending
  Scenario: Test whether creating a CO adding more AOs updates the number of Exam Offerings when the driver is Activity Offering
    When I create a CO with two new AOs and then view the Exam Offerings where the CO has a standard final exam driven by Activity Offering
    Then there should be 3 Exam Offerings for the CO