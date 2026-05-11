Feature: Login User

  @smoke
  Scenario: Show error message for invalid login
    Given I am on the home page
    When I navigate to the Signup/Login page
    And I enter invalid email and password
    And I click Login
    Then I should see the invalid login error message
