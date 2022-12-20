@SmokeTest
Feature: User should be able to register
Background:  open register page
  Given navigate to register page
  Scenario: User could register with valid data
    #all data should be valid
    When User choose gender
    And User should enter "First Name" and "Last Name"
    And User should enter BirthDate
    And User should enter Email and Company
    And User should enter Password and Confirm Password
    And click register button
    Then display register confirmation message