Feature: UnPlanned UnStaffed Request To MARC


  @RequestToMARCUnPlannedUnStaffed
  Scenario: Create UnPlanned UnStaffed request with Request to MARC button
    Given I am in the login page of fit bit application
    When I login into fit application as "basicfit_mod@gmail.com.uat"
    Then I can navigate to Accounts page
    And I search for the created account
    And I click on Request to MARC button
    And I enter UnPlanned UnStaffed request details
    And I confirm the request creation

