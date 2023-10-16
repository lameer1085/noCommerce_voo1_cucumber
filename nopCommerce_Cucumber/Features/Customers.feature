
Feature: Customers

  Background: Common steps
  	Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"  
    And User enter Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User csn view the dashboard
    When User click on customers menu
    And Click on customers menu Item

  @sanity
  Scenario: Add a new customer
    #Given User Launch Chrome browser
    #When User opens URL "http://admin-demo.nopcommerce.com/login"  
    #And User enter Email as "admin@yourstore.com" and password as "admin"
    #And Click on login
    #Then User csn view the dashboard
    #When User click on customers menu
    #And Click on customers menu Item
    And click on add new button
    Then User can view add new customer page
    When user enter customer info
    And Click on save button 
    Then User can view confirmation message "The new customer has been addded successfully."
    And Close the browser
   
   @regression 
   Scenario: Search customer by EmailID
    #Given User Launch Chrome browser
    #When User opens URL "http://admin-demo.nopcommerce.com/login"  
    #And User enter Email as "admin@yourstore.com" and password as "admin"
    #And Click on login
    #Then User csn view the dashboard
    #When User click on customers menu
    #And Click on customers menu Item
    And Enter customer Email
    When Clickon search button
    Then User should found Email in the search table
    And Close the browser 
    
    @Sanity
    Scenario: Search customer by Name
    #Given User Launch Chrome browser
    #When User opens URL "http://admin-demo.nopcommerce.com/login"  
    #And User enter Email as "admin@yourstore.com" and password as "admin"
    #And Click on login
    #Then User csn view the dashboard
    #When User click on customers menu
    #And Click on customers menu Item
    And Enter the customer firstName
    And Enter the customer lastName
    When Clickon search button
    Then User should found name in seacrh table
    And Close the browser 
    
    
    
    
