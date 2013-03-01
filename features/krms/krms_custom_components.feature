@draft
Feature: KRMS Custom Components

Check to see if result is true when valid course is given and false otherwise

  Background:
    Given I am logged in as admin

#    Scenario: Return true for correct course entered in Single Course component
#      When I search for a "Single Course" with text "mathm"
#      Then the text "MATHM" should exist in the results

#  Scenario Outline: Return true for correct string entered
#    When I search for a "<field>" with text "<text>"
#    Then the text "<result>" should exist in the results
#
#    Examples:
#      | field         | text                         | result                       |
#      | Single Course | aaaa212                      | AAAA212                      |
#      | Department    | political science department | Political Science Department |
#      | Organization  | computer science department  | Computer Science Department  |
#    Examples:
#    | field         | text                     | result                   |
#    | Single Course | mathm                    | MATHM                    |
#    | Department    | cmns-applied mathematics | CMNS-Applied Mathematics |
#    | Organization  | arhu-school of music     | ARHU-School of Music     |

#  Scenario Outline: Return false for incorrect string entered
#    When I search for a "<field>" with text "<text>"
#    Then the text "<result>" should not exist in the results
#
#    Examples:
#    | field         | text                         | result                       |
#    | Single Course | aaaa212                      | AAAA212                      |
#    | Department    | political science department | Political Science Department |
#    | Organization  | computer science department  | Computer Science Department  |

#  Scenario Outline: Return true for correct number entered
#    When I enter "<num>" in the "<field>" text field
#    Then the "<field>" should have no error message
#
#    Examples:
#    | num | field      |
#    | 123 | GPA        |
#    | 20  | Test Score |

#  Scenario Outline: Return false for incorrect number entered
#    When I enter "<num>" in the "<field>" text field
#    Then the "<field>" should have an error message which contains "<error>"
#
#    Examples:
#    | num   | field      | error    |
#    | 1     | GPA        | 3        |
#    | 1.2   | GPA        | whole    |
#    | -12   | GPA        | positive |
#    | 12.3  | Test Score | whole    |
#    | -123  | Test Score | positive |

#  Scenario: Return true for correct Test Name entered
#    When I search for a "Test Name" with text "act math"
#    Then the text "ACT Math" should exist in the results
#
#  Scenario: Return false for incorrect Test Name entered
#    When I search for a "Test Name" with text "adt science"
#    Then the text "ADT Science" should not exist in the results

#  Scenario Outline: Count the number of options for Grade Type
#    When I select "<grade>" for grade
#    Then there should be <number> options for grade
#
#    Examples:
#    | grade              | number |
#    | Completed Notation | 3      |