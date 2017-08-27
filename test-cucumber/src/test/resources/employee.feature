@Employee
Feature: EMPLOYEE  
	Check the Employee Controllers APIs

Background: 
	Given employee services are up
	
	@Welcome
  Scenario: client calls the welcome api
    When the client calls /employee/welcome 
    Then the client receives status code of 200
    And the client receives string containing "Welcome"
    
  @Search
  Scenario Outline: Client searches employee with some input
  	When the client calls the search api with an <id>
  	Then the client receives status code of <statusCode>
  	
  	Examples:
  		| id  | statusCode |
  		| 2   | 200        |
  		| 3   | 200        |
  		| asd | 400        |
  		| 123 | 404        |
  		
  @Search
  Scenario: Client wants to search employees having salary greater than 
  	When the client calls search employees whose salary is greater than 95000.00
  	Then the client receives status code of 200
  	And the client receives an array of eployees whose salary is greater than 95000.00
  	
  	
  	
  	
  	