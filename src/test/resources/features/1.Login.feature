Feature: Login User

  @tag1
  Scenario: User login invalid
    When User go to login page
    And User enter username password invalid
    And User click button login invalid
    Then User invalid credentials
   


  @tag2
  Scenario: User login valid
  	When User delete username password
    When User enter username password valid
    And User click button login valid
    Then user on menu homepage
    