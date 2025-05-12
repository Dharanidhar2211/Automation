
@tag
Feature: ErrorValidation
  I want to use this template for my feature file

 

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    And Logged in with valid username<email> and password <password>
    Then "Incorrect email or password." message is  Displayed 

    Examples: 
      | email    								 | password               | 
      | dharanidhar220@gmail.com | Ilovecricket@1231      |