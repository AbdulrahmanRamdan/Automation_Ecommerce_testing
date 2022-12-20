@SmokeTest
Feature: Create successful Order
Background:  open login page
  Given User logged into website
  Scenario: Create successful Order
    When User choose item and add to cart
    And Accept the term and click Checkout
    And fill checkout data
    And choose Shipping Method
    And choose Payment Method
    And read Payment information
    And confirm payment
    Then confirm order message should be display


