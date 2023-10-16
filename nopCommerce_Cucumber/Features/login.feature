

Feature: Login

	@sanity
  Scenario: Successful login with valid credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"  
    And User enter Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Login Page Title should be "Your store. Login"
    Then Close the browser

 	@rgression
  Scenario Outline: Successful login with valid credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"  
    And User enter Email as "<email>" and password as "<password>"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Login Page Title should be "Your store. Login"
    Then Close the browser

    Examples: 
      | email  | password |
      | admin@yourstore.com | admin |
      | admin1@yourstore.com | admin123 |
