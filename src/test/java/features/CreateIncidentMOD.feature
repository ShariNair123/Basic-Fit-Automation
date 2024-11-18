Feature: Create Incident MOD

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
    #And I add Club Managers
    #And I verify that the Account Record Type is Club
    And I perform logout


  @MODClubClosureUnKnown
  Scenario: Create Unknown type Incident with MOD Club Closure button
    Given I am in the login page of fit bit application
    When I login into fit application as "basicfit_mod@gmail.com.uat"
    Then I can navigate to Accounts page
    And I search for the created account
    And I click on MOD Club Closure button
    And I enter Unknown Incident details
    And I click on Submit UnKnown Incident
    And I verify the Incident creation message
    And I verify that the Club Operational Status icon is updated
    And I select the Incident Club Activity record created
    And I verify the Club Activity details generic for Incidents
    And I verify the Club Activity details specific for Unknown Incidents
    And I perform logout
    And I login into fit application as "basicfittest002@gmail.com"
    And I search for the created account
    And I verify that the club is closed
    And I perform logout


  @MODClubClosureKnown
  Scenario: Create Known type Incident with MOD Club Closure button
    Given I am in the login page of fit bit application
    When I login into fit application as "basicfit_mod@gmail.com.uat"
    Then I can navigate to Accounts page
    And I search for the created account
    And I click on MOD Club Closure button
    And I enter Known Incident details
    And I click on Submit Known Incident
    And I verify the Incident creation message
    And I verify that the Club Operational Status icon is updated
    And I select the Incident Club Activity record created
    And I verify the Club Activity details generic for Incidents
    And I verify the Club Activity details specific for Known Incidents
    And I perform logout
    And I login into fit application as "basicfittest002@gmail.com"
    And I search for the created account
    And I verify that the club is closed
    And I perform logout


