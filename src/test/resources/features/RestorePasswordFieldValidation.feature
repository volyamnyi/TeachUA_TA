Feature: Verify if user can change the password entering incorrect email

  Scenario Outline: Restore password with invalid email test
    Given Click on Guest DropDown icon
    And Select Увійти option
    And Click on Забули пароль? button
    When Enter <email> in the Email field
    And Click on the Відновити button
    Then Frame of the field becomes <color> color

    Examples:
      | email                    | color            |
      | kjfdhgiuerehgo           | rgb(255, 77, 79) |
      |                          | rgb(255, 77, 79) |
      | val@valera.valeriyovychk | rgb(0, 0, 0)     |