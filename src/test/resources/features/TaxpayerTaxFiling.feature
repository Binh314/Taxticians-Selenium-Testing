@TaxpayerTaxFiling
Feature: File Individual Taxes by Taxpayer

Scenario: Successful Tax Filing

# Filer Information Stage
When I change my ssn
And I click continue
And I choose filing jointly
And I enter my spouse's information
And I click continue
And I click add dependents
And I enter my dependent's information
And I click submit on overlay
And I click create

# Income Stage
## W2
And I click add w2
And I enter my employer information
And I click social security
And I enter my social security information
And I click income
And I enter my income information
And I click medicare
And I enter my medicare information
And I click submit on overlay
And I click continue

## Government Payment Information
And I click no
And I click continue

## Interest Income
And I click no
And I click continue

## Retirement Plans
And I click yes
And I enter my 1099R information
And I click continue

# Social Security Income
And I click no
And I click continue

## Additional Income Scenarios
And I click all no
And I click continue

## Additional Income Scenarios Continued
And I click all no
And I click finish

# Deductions Stage

## Medical
And I click no
And I click continue
## Mortage
And I click no
And I click continue
## Charitable Gifts
And I click no
And I click continue
## Real Estate
And I click no
And I click continue
## State and Local Income
And I click no
And I click continue
## Self Employment
And I click no
And I click continue
## Review
And I click advance this case

# Tax and Credits Stage
## Educaton Tax Credits
# TODO: ADD DEPENDENT CURRENT NOT WORKING
And I click continue
## Student?
And I click no
And I click continue
## Review
And I click finish

# Resolution Stage
And I enter my payment information
And I click submit