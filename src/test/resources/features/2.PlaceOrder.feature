Feature: Place Order

  Scenario: User place order 
  
    When User go to web page
    When User search product1
    And User add to cart1
    When User search product2
    And User add to cart2
    And User click checkout
    When User fill billing
    And User click terms
    And User click place order
    Then User sucess order
   
    
