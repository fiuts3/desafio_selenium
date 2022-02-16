Feature: Forms to Custumers

Scenario: To corretly forms
  Given go to site
  When change the version select
  And click add button
  And write forms
  And click to save
  And check message
  Then click link go back to list
