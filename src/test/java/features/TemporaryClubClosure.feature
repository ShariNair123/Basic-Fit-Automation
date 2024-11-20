Feature: Temporary Close Club

  Background:
    Given I am in the login page of fit bit application
    When I login into fit application as "basicfittest001@gmail.com"
    Then I can navigate to Accounts page
    And then creates a new account with following details
      | RecordType     | AccountName | Broker         | ExpansionManager | FieldExpansionManager | Street          | City | PostalCode | Country |
      | Potential Club | ss          | SSCV Actigenay | Automation User  | Automation User       | Test Automation | Lyon | 75001      | France  |
    And I verify that the account is successfully created
    And I verify the account is getting created with Record Type as "Potential Club"
    And I perform logout
    And I login into fit application as "basicfit_business_support@gmail.com.uat"
    And I search for the created account
    And I add the Club to GM
    And I verify that the account is added to the GM
    And I perform logout
    And I login into fit application as "basicfittest002@gmail.com"
    And I search for the created account
    And I add Club Id and Status
    And I add Openings Type and Language
    #And I add Club Managers
    #And I verify that the Account Record Type is Club
    And I perform logout

  @CloseClubTemporarilyWithoutPartialReopening
  Scenario: Temporary Club Closure without Partial reopening using Close Club button
    Given I am in the login page of fit bit application
    When I login into fit application as "basicfit_business_support@gmail.com.uat"
    Then I can navigate to Accounts page
    And I search for the created account
    And I click on Close Club button for Temporary Club Closure
    And I enter Temporary Closure details
    And I check the Partial Reopening fields for Without Partial Reopening scenario
    And I click Next for Temporary Club Closure
    And I click Save for Temporary Club Closure
    And I search for the created account
    And I verify that the club is closed temporarily
    And I select the Club Activity record created for temporary club closure
    And I verify the Club Activity record generic details created for temporary club closure
    And I verify the Club Activity record specific details created without Partial reopening

  @CloseClubTemporarilyWithPartialReopening
  Scenario: Temporary Club Closure with Partial reopening using Close Club button
    Given I am in the login page of fit bit application
    When I login into fit application as "basicfit_business_support@gmail.com.uat"
    Then I can navigate to Accounts page
    And I search for the created account
    And I click on Close Club button for Temporary Club Closure
    And I enter Temporary Closure details
    And I enter the Partial Reopening field values
    And I click Next for Temporary Club Closure
    And I click Save for Temporary Club Closure
    And I search for the created account
    And I verify that the club is closed temporarily
    And I select the Club Activity record created for temporary club closure
    And I verify the Club Activity record generic details created for temporary club closure
    And I verify the Club Activity record specific details for Partial reopening