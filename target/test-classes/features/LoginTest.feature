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

