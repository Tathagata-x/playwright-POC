Feature: Login Page feature

  Scenario: Verify User is able to login to Service Now with correct credentials
    Given user navigates to "url"
    When user enters "username" username
    And user enters "password" password
    And user clicks Login button
    Then verify that user is logged in and navigated to Profile page
