@SmokeTest
Feature: User should be able to login
Background:  open login page
  Given navigate to login page
  Scenario: User could log in with valid email and password
    #all data should be valid
    When User enter "Email" and "Password"
    And Click login button
    Then go to home page and logout button is displayed
