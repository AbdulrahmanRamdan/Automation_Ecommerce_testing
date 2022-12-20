@SmokeTest
Feature: Logged user could filter with color
Background:  open login page
  Given User logged into website
  Scenario: Logged user could filter with color
    When User hover selected Apparel category and open Shoes Sub category
    And choose color filter
     Then check Item color
