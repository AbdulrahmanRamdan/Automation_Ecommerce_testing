
@SmokeTest
Feature: Logged User could switch between currencies US-Euro
Background:  open login page
  Given User logged into website
  Scenario: Logged User could switch from US to Euro
    When User switch from US to Euro
    Then current currency should be change to Euro

  Scenario: Logged User could switch from Euro to US
    When User switch from Euro to US
    Then current currency should be change to US