Feature:Pet Store web services tests

  @addPet @petStore @automationTest
  Scenario: Add a Pet
    Given User build a web service request for "addPet"
    When User make a "addPet" request
    Then User verify status code is "200"
    And User verify "addpet" details

  @availablePets @petStore @automationTest
  Scenario: Get a Pet details
    Given User make a "availablePets" request
    Then User verify status code is "200"
    And User verify "availablePets" details

  @soldPet @petStore @automationTest
  Scenario: Sold a Pet
    Given User build a web service request for "soldPet"
    When User make a "soldPet" request
    Then User verify status code is "200"
    And User verify "soldPet" details

  @deletePet @petStore @automationTest
  Scenario: Get a Pet details
    Given User make a "deletePet" request
    Then User verify status code is "200"
    And User verify "deletePet" details
