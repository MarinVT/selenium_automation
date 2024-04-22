@intimno2
Feature: Интино category
  Category is activated from the CMS

  Scenario: User is able to open category Интино
    Given User opens the following url "https://hotnews.bg/" to open Интино category
    And User clicks on hamburger menu top open Интино category
    And User clicks on Intimno category
    Then User is navigated to Intimno page
