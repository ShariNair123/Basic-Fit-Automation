Feature: Create Investigation Request

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
    And I add Club Managers
    And I verify that the Account Record Type is Club
    And I perform logout

  @InvestigationRequest
  Scenario: Create Investigation Request
    Given I am in the login page of fit bit application
    When I login into fit application as "automation_cm@gmail.com.uat"
    Then I can navigate to Accounts page
    And I search for the created account
    And I click on Request Investigation button
    And I enter Investigation request details
    And I Submit Investigation request
    And I search for the created account
    And I select the Investigation Club Activity record created
    And I verify the Investigation CA record created
