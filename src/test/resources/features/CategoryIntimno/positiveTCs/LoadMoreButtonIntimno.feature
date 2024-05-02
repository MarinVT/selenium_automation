@intimno

Feature: Intimno "Load More" button is listed under the list with latest articles
  Preconditions:
  1. Category has more than 15 articles created to generate Load More button

  Scenario: User is able to see "Load More" button listed on the page in Intimno
    Given User opens "https://hotnews.bg/intimno" to verify that the view all button listed in Intimno
    And User sees Load more button listed on the page successfully with text "Виж още"