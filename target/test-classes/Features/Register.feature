Feature: Register functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the below fields
|firstName|Dove					  |
|lastName |Sandy          |
|telephone|999999999			|
|password |12345					|
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the below fields
|firstName|Dove					  |
|lastName |Sandy          |
|telephone|999999999			|
|password |12345					|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the below fields with duplicate email
|firstName|Dove					  |
|lastName |Sandy          |
|email    |xyz@yopmail.com|
|telephone|999999999			|
|password |12345					|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get a proper warning message about duplicate email 

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User does not enter any details into any fields
And User clicks on Continue button
Then User should get a proper warning message for every mandatory fields
