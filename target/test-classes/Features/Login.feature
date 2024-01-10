Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into the email field
And User enters valid password <password> into the password field
And User clicks on Login button
Then User should get successfully logged in 
Examples:
|username        |password|
|xyz@yopmail.com |12345   |
|xyz1@yopmail.com|12345   |
|xyz2@yopmail.com|12345   |

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into the email field
And User enters invalid password "1234567" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "qwe@yopmail.com" into the email field
And User enters invalid password "1234567" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into the email field
And User enters valid password "12345" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User do not enter any email address into the email field
And User do not enter any password into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch