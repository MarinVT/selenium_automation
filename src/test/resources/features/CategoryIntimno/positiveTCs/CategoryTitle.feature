@intimno1

Feature: Интимно category title
  Preconditions:
  1. Category is activated from the CMS

  Scenario: User gets the title of the category Интимно listed under the hamburger menu
    Given User opens "https://hotnews.bg/intimno" to verify that the category title Интимно is listed
    And User sees the category title Интимно listed above the lead news section