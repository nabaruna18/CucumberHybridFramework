Feature: Search functionality

Scenario: User searches for a valid product
Given User opens the application
When User enters valid product "HP" into search box field
And User clicks on search button 
Then User should get valid product displayed in search results

Scenario: User searches for a invalid product
Given User opens the application
When User enters invalid product "Honda" into search box field
And User clicks on search button 
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the application
When User does not enter any product into the search box field
And User clicks on search button 
Then User should get a message about no product matching
