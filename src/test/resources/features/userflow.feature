@manual
Feature: User Flow

  Scenario: Register and Login
    Given I open the registration page
    When I register a new user
    Then I should see the welcome message

  Scenario: Add to Cart and Checkout
    Given I log in as a user
    When I add items to the cart
    And I proceed to checkout
    Then I complete the purchase
    And I should see the order confirmation
