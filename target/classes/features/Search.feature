@SmokeTest
Feature: User should be able to login
Background:  open login page
  Given User logged into website
  Scenario: Logged User could search for any product
    When User enter search word and click enter key
    Then related items should be display
