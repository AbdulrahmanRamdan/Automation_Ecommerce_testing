@SmokeTest
Feature:  User could reset his/her password successfully
Background:  open login page
  Given navigate to login page
  Scenario: User could reset his/her password successfully
    When User click on forget password
    And enter his or her email
    And click recover
    Then display instruction confirmation message