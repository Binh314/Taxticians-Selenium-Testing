@Onboarding
Feature: Onboard User

Scenario: Navigate to User Portal
Given I am on the Pega login page
When I enter valid "username" and "password"
And click the login button
Then I will be in app studio
When I click on App Studio
And click Dev Studio
Then I will be in Dev Studio
When I launch user portal