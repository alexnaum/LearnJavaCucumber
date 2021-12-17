@NegativeTests
Feature: Google image search
  Scenario: user can search images by keyword

    Given Open OLX cars page
    When  sort by "<Expensive>" price descending
    Then  check that sorting in descending order of price worked correctly