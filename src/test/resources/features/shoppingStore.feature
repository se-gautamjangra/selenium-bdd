@login
Feature: Login Functionality

  @navigationProducts @shoppingTest @automationTest
  Scenario:  Verify Product categories
    Given User is on Homepage of the application
    When User selects "Phones" from homepage
    Then Verify "Samsung galaxy s6" present on homepage
    When User selects "Laptops" from homepage
    Then Verify "Sony vaio i5" present on homepage
    When User selects "Monitors" from homepage
    Then Verify "Apple monitor 24" present on homepage

  @productSelect @shoppingTest @automationTest
  Scenario Outline: Select Products
    Given User navigated to "Home" page of the application
    When User selects "Laptops" from homepage
    And User selects product "<laptopName>" from homepage
    And User Add product to cart

    Examples:
      | laptopName   |
      | Dell i7 8gb  |
      | Sony vaio i5 |

  @confirmOrder @shoppingTest @automationTest
  Scenario Outline: Confirm order and verify cart
    Given User navigated to "Cart" page of the application
    When User remove product "Dell i7 8gb" from CartPage
    Then Verify product count in cart is "1"
    And User click on Place Order
    And User provide details "<name>","<country>","<city>","<card>","<month>","<year>" and purchase products
    Then Verify product price on CartPage
    And User confirm order


    Examples:
      | name   | country | city     | card       | month | year |
      | Gautam | India   | Gurugram | 9012345678 | 10    | 2020 |













    #  @Test
#   Scenario Outline: Verify error message on invalid user user login
#     Given User is on Homepage of the application
#