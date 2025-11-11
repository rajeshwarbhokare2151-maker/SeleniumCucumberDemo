Feature: Login with single user from Excel

    Scenario: Check login is successful with valid creds
    Given User reads credentials from Excel file
    When User Open URL "https://www.saucedemo.com" and navigate to Login page
    And User enters username as "standard_user" and password as "secret_sauce" 
    And Clicks on Login button
    Then User should be logged in successfully
    When User adds product to the cart
    And User should see in the cart
   
  
 Scenario Outline:Successful login with multiple users 
    Given User reads credentials from Excel file
    When User Open URL "<url>" and navigate to Login page
    And User enters username as "<username>" and password as "<password>" 
    And Clicks on Login button
    Then User should be logged in successfully
    When User adds product to the cart
    And User should see in the cart

    Examples:
Examples:
  | url                          | username               | password     |
  | https://www.saucedemo.com    | standard_user          | secret_sauce |
  | https://www.saucedemo.com    | locked_out_user        | secret_sauce |
  | https://www.saucedemo.com    | problem_user           | secret_sauce |
  | https://www.saucedemo.com    | performance_glitch_user| secret_sauce |

 
  