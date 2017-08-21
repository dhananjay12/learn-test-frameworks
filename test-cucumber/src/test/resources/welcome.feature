Feature: Check the welcome rest endpoint
  Scenario: client makes a GET call
    When the client calls /employee/welcome 
    Then the client receives status code of 200
    And the client receives string containing Welcome