@SmokeTest
Feature: Logged user could add different products to Shopping cart
Background:  open login page
  Given User logged into website
  Scenario: Logged user could add different products to Shopping cart
    When User randomly hover selected category
    And open Sub category if found
    And click random product
    And add item into Cart
    Then check item name in cart
