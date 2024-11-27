Feature: Case Creation MOD

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
    And I add Club Cost Center and Club SAP name
    #And I add Openings Type and Language
    #And I add Club Managers
    #And I verify that the Account Record Type is Club
    And I perform logout

  @CaseCreationMOD
  Scenario: Create a Case with Record Type as MOD
    Given I am in the login page of fit bit application
    When I login into fit application as "basicfit_mod@gmail.com.uat"
    Then I can navigate to Cases page
    Then I click on New button
    And I verify that the MOD Record Type is automatically selected
    And I verify the auto populated case details for MOD Record Type
    And I enter the required case test data for MOD Record Type
    And I submit the case
    And I verify the success toast message for case creation
    And I verify the MOD Case Club Activity record details

