Feature: test homepage
  Scenario: test add to cart functionality
    Given user goes to firefox
    When user goes to the site "http://automationpractice.com/index.php"
    Then check if "No products" are there in a cart
    Then go back to the homepage
    Then Select a dress
    And add it to the cart
    Then check if same "Printed Dress" has been added to the cart
    Then click on checkout
    Then check user is on first "Summary" phase
    And click on proceed to checkout button
    Then check user is on second "Sign in" phase
