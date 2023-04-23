Feature: Buy a House at Origin
  As an Origin Exercise user
  Joseph wants to buy a house through the app
  So he can manage better his savings

  Background:
    Given Joseph is at Origin Saving Goals application

  Scenario: Saving a goal
    When he defines his goal with an amount of "1000" to be reached by the date of "June" month
    Then he should see that the monthly amount information is filled
    And he should see that the text below the monthly amount shows the month to be reached

  Scenario: Trying to save a goal with zero amount
    When he defines his goal with an amount of "0" to be reached by the date of "April" month
    Then he should see that the monthly amount information is equals zero
