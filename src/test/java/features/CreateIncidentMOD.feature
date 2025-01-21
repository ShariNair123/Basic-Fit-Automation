Feature: Create Incident MOD




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




