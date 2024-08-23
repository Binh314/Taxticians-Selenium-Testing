@Onboarding
Feature: Onboard User

Scenario: Navigate to user portal
Given I am on the Pega login page
When I enter valid "username" and "password"
And click the login button
Then I will be in app studio