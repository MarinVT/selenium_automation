@intimno

Feature: Intimno category
  Category is activated from the CMS

  Scenario: User is able to open category Intimno via hamburger menu
    Given User opens the following url "https://hotnews.bg/" to open Intimno category
    And User clicks on hamburger menu top open Intimno category
    And User clicks on Intimno category
    Then User is navigated to Intimno page
