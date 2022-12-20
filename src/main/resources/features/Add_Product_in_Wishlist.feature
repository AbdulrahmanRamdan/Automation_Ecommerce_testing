@SmokeTest
Feature: Logged user could add different products to Wishlist
Background:  open login page
  Given User logged into website
  Scenario: Logged user could add different products to Wishlist
    When User randomly hover selected category
    And open Sub category if found
    And click random product
    And add item into WishList
    And click WishList button
    Then check item name in WishList
