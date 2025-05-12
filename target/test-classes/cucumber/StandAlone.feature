
@tag
Feature: Purchase the Order from Ecommerce WebSite
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce page 

  @Regression
  Scenario Outline: Postive Test of Submitting the Order 
    Given Logged in with valid username<email> and password <password>
    When I add the product <item> to cart
    And Checkout the item<item> and submit the order
    Then "Thankyou for the order." is Displayed on confirmation page

    Examples: 
      | email    								 | password               | item        |
      | dharanidhar220@gmail.com |   Ilovecricket@123     | ZARA COAT 3 |
      
      
