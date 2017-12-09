
Feature: Check that parameters for 2 selected car, equals to parameters in compare page
    
Scenario: I navigate research page, and select random car.
If there are trims for this page, I save it and select another car and save its trims.
After that I add to compare these two cars, and assert, are the
characteristics in that page correct.

    Given I should see a main page
    When I click button Research
    Then I Should see a research page
    When I choose and save random car number 1 , I  should see trims button, or I return to Research and choose another car
    Then I should see car page for car number 1
    When I click trims button
    Then I should see trims page for car number 1
    Then I collect and save Engine and transmission for car number 1
    Then I return to mainPage

    Given I should see a main page
    When I click button Research
    Then I Should see a research page
    When I choose and save random car number 2 , I  should see trims button, or I return to Research and choose another car
    Then I should see car page for car number 2
    When I click trims button
    Then I should see trims page for car number 2
    Then I collect and save Engine and transmission for car number 2

    When I click button Research
    And I click compare button
    And I add  car number 1 to compare
    Then I should see that car number 1 added to compare
    When I add another car number 2 to compare
    Then I should see that car number 2 added to compare
    Then I check that engines and transmision of  car number 1 are correct
    Then I check that engines and transmision of  car number 2 are correct





