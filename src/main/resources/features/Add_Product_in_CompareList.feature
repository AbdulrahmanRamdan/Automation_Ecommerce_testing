@SmokeTest
Feature: Logged user could add different products to compare list
Background:  open login page
  Given User logged into website
  Scenario: Logged user could add different products to compare list
    When User randomly hover selected category
    And open Sub category if found
    And click random product
    And add item into CompareList
    And scroll down and click compare list
    Then check item name in Compare List
