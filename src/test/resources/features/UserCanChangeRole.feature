Feature: [Edit profile] The user or manager can change it's role
  Scenario: Verify that the manager can change it's role to 'user' and then back to 'manager'
    Given Log in as User
    Then Go to the My Profile
    And Check if user has role ROLE_MANAGER in profile
    Then Click on Edit profile
    Then Click on Відвідувач button
    And Click on Зберегти зміни button
    And Check if user has role ROLE_USER in profile
    Then Click on Edit profile
    Then Click on Керівник button
    And Click on Зберегти зміни button
    And Check if user has role ROLE_MANAGER in profile
    And Check all asserts