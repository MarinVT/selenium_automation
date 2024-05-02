@intimno

Feature: Intimno latest articles list
  Latest articles list is activated

  Scenario: User is able to pick up an article from list with articles located under the lead news list in Intimno
    Given User opens url "https://hotnews.bg/intimno" to verify that the list with latest articles is presented in Intimno
    Then User is successfully navigated to Intimno page and latest articles list is successfully presented