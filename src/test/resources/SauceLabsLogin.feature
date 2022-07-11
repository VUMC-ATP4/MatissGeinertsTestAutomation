Feature: Tests all functionality of sauce labs login page

  Scenario: Successful login
    Given user navigates to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters 'standard_user' and 'secret_sauce'
    And user clicks login button
    Then user sees inventory page

    Scenario: User sees error message if username empty
      Given user navigates to 'https://www.saucedemo.com/'
      And user sees page title 'Swag Labs'
      When user enters '' and 'secret_sauce'
      And user clicks login button
      Then user sees error message 'Epic sadface: Username is required'

  Scenario: User sees error message if password empty
    Given user navigates to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters 'standard_user' and ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Password is required'

  Scenario: User sees error message if username and password empty
    Given user navigates to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters '' and ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Username is required'

  Scenario: User sees error message if wrong credentials are provided
    Given user navigates to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters 'test' and 'test'
    And user clicks login button
    Then user sees error message 'Epic sadface: Username and password do not match any user in this service'