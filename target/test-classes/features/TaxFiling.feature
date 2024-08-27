@TaxFiling
Feature: File Individual Taxes

Scenario: Successful Tax Filing

# Filer Information Stage
When I enter my personal information
# And I enter my address
And I click continue
And I choose filing jointly
And I enter my spouse's information
And I click continue
And I click add dependents
And I enter my dependent's information
And I click submit
And I click create

# Income Stage
And I click add w2
And I enter my employer information
And I click social security
And I enter my social security information
And I click income
And I enter my income information
And I click medicare
And I enter my medicare information
And I click submit
And I click continue
And I click no
And I click continue
And I click no
And I click continue
And I click yes
And I enter my 1099R information
And I click continue
And I click no
And I click continue
And I click all no
And I click continue
And I click all no
And I click finish