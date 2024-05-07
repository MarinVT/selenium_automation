@intimno5
Feature: Intimno main list
  Main list is activated from the CMS and contains an article on 1st position

  Scenario: User is able to validate that the first article is listed
    Given User opens url "https://hotnews.bg/intimno" to verify that the first article is listed successfully
    Then User is navigated to Intimno's page and first article is successfully listed