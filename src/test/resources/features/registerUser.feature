Feature: Register User

  @smoke
  Scenario: Register a new user successfully
    Given I am on the home page
    When I navigate to the Signup/Login page
    And I enter name "John Doe" and unique email
    And I click Signup
    Then I should see the "ENTER ACCOUNT INFORMATION" page
