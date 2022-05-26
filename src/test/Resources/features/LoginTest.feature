Feature: Feature to test login functionality

  Scenario Outline: Validate login to school of rock page is succssful

    Given User is on login page
    When  User enter valid "<Username>" and "<Password>"
    And   User click on login button
    Then  User should be navigate to video window

    Examples:

      | Username         | Password |
      |onvue@testing.com | abc		|



  Scenario Outline: Validate HomePage after successful login to school of rock

    Given User is on login page
    When  User enter valid "<Username>" and "<Password>"
    And   User click on login button
    And   User should be navigate to video window
    And   close video window
    Then  User should navigate to homepage

    Examples:

      | Username         | Password |
      |onvue@testing.com | abc		|



  Scenario Outline: Validate login to school of rock page is not succssful

    Given User is on login page
    When  User enter invalid "<Username>" and "<Password>"
    And   User click on login button
    Then  User should get unsuccessful login error

    Examples:

      | Username         | Password |
      |onvue@testing.com | abc		|

  Scenario Outline: Validate forget password window

    Given User is on login page
    And  User enter invalid "<Username>" and "<Password>"
    And   User click on login button
    And  User should get unsuccessful login error
    When User click on forget password
    Then User should navigate to Forgot Password window

    Examples:

      | Username         | Password |
      |onvue@testing.com | abc		|

  Scenario: Validate user is able to reset password

    Given User is on login page
    And  User click on forget password
    And User should navigate to Forgot Password window
    When User create new password
    Then User should be able to see password reset message

  Scenario: Validate user is able to navigate to login page from forget password page

    Given User is on login page
    And  User click on forget password
    And User should navigate to Forgot Password window
    And User create new password
    And User should be able to see password reset message
    When User  click on signin button
    Then User should navigate to login page

