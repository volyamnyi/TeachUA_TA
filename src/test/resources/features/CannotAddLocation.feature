Feature: Verify that a 'Керівник' can add a location of a club
  Scenario: This test case verifies that a 'Керівник' cannot add a location to the list of locations after leaving all mandatory and optional fields empty.
    Given Log in as Керівник
    Then Go to the Додати центр
    And Click on Додати локацію button
    Then Check if Додати локацію pop up is opened
    And Check if Додати button is disabled.