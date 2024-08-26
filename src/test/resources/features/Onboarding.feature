@Onboarding
Feature: Onboard User

Scenario: Successful Onboard
When I enter a valid email
And I enter a valid password

Scenario: Invalid Email
When I enter an invalid email
And I enter a valid password
And I click submit
Then I get an error message about the invalid email

Scenario: Password Too Short
When I enter a valid email
And I enter a too short password
And I click submit
Then I get an error message about the short password

Scenario: Missing Email
When I enter a valid password
And I click submit
Then I get an error message about a blank value

Scenario: Missing Password
When I enter a valid email
And I click submit
Then I get an error message about a blank value