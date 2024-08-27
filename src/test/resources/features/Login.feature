@Login
Feature: Login

Scenario: Successful Taxpayer Login
When I enter a valid taxpayer username and password combination
And I click login
Then I am in the taxpayer portal

Scenario: Successful Tax Professional Login
When I enter a valid tax professional username and password combination
And I click login
Then I am in the tax professional portal

Scenario: Invalid Username and Password Combination
When I enter an invalid username and password combination
And I click login
Then I get a login error

Scenario: Missing Username
When I enter a password
And I click login
Then the username and password fields are empty


Scenario: Missing Password
When I enter a username
And I click login
Then I get a login error

Scenario: Missing Both Username and Password
When I click login
Then the username and password fields are empty