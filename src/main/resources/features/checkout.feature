@checkout
Feature: Checkout
  In order to checkout my purchase
  As a user
  I want to add items to cart

  @ll @viewCart @prod
  Scenario: View Cart Total
    Given I Am At Page: 'https://www.liquorland.com.au/'
    When I Add Items To Cart
      | name   | price | qty |
      | Corona | 46.00 |   1 |
    Then I Should See Total Cost: 46.00
