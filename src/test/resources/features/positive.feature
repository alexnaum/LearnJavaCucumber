Feature: Check filter by mileage

  @FilterTests
  Scenario Outline: Check mileage fields

    Given Open OLX cars page
    When   set Min mileage = <minMileage> and Max mileage = <maxMileage>
    Then  the values should be displayed Min mileage = <minMileage> and Max mileage = <maxMileage> in the same page
    Examples:
      | minMileage | maxMileage |
      | 30000      | 70000      |
      | 10000      | 200000     |

    @SortingTests
  Scenario: sorting in descending order of price

    Given Open OLX cars page
    When  sort by "<Expensive>" price descending
    Then  check that sorting in descending order of price worked correctly

      @FilterTests
  Scenario: Filter by mileage

    Given Open OLX cars page
    When  set Min mileage = 10000 and Max mileage = 70000
    And   get car mileage
    Then  the values should be displayed Min mileage = 10000 and Max mileage = 70000 in the same page
