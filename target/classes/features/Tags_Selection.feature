@SmokeTest
Feature: Logged user could select different tags
Background:  open login page
  Given User logged into website
  Scenario: Logged user could select different tags
    When User randomly hover selected category
    And open Sub category if found
    And scroll down and select random tag
    And click random item
    Then check item if belong to tag
