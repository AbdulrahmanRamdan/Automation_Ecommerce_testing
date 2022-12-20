@SmokeTest
Feature: Logged user could select different Categories
Background:  open login page
  Given User logged into website
  Scenario: Logged user could select different Categories
    When User randomly hover selected category
    And open Sub category if found
    Then check page title
