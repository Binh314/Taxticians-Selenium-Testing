@Onboarding
Feature: Onboard User

Scenario: Successful Onboard
When I click the create case button
And I click Register Taxpayer
And I enter a valid email
And I enter a valid password

Scenario: Invalid Email
When I click the create case button
And I click Register Taxpayer
And I enter an invalid email
And I enter a valid password
And I click submit
Then I get an error message about the invalid email

Scenario: Password Too Short
When I click the create case button
And I click Register Taxpayer
And I enter a valid email
And I enter a too short password
And I click submit
Then I get an error message about the short password