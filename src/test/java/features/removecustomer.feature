Feature: remove costumers


  Scenario: delete costumers
    Given Open Site
    When Select Version
    And click on the search name column
    And click on the checkbox
    And click delete button
    And validate message
    Then click delete popup and check message

