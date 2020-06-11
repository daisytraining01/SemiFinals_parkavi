Feature: Online Banking

Background: 

Given User is able to enter the AccountNumber
And User is able to enter the Password
When User clicks login button
And User enters the PIN Number
Then User clicks validate PIN

@present
Scenario: To validate the Login Functionality(Negative)

Given User is able to enter the Invalid AccountNumber
And User is able to enter the Incorrect Password
When User clicks login button
Then User checks error message is displayed


Scenario: To validate  Account Summary 

 Given User clicks Account Summary
 When User verify page title
 And User gets the transaction details
 Then User checks available credit balance


Scenario: To validate Account Details

Given User clicks Account Details
When User verify Account Details page title
Then User validates UserName and Email id


Scenario: To validate Account Statement	

Given User clicks Account Statement
When User verify Account Statement page title
Then User gets the Account Statement


Scenario: To validate Fund Transfer

Given User clicks Fund Transfer
When User verify Fund Transfer page title
And User provides neccessary details for fund transfer
Then User clicks Fund Transfer button