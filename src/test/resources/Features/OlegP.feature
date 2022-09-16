@ask-port
 Feature: basic functions

  Background:
 Given OP navigate to login page "http://ask-stage.portnov.com"
 Then OP enter email "olegp123@gmail.com"
 Then OP enter password "portnov123"
 Then OP click Sign-in button
 And OP wait for 3 seconds

  
 @student1
 Scenario: My assignments check
  Given OP click "My assignment" button
  Then OP see their assigments within 2 seconds

  @student2
  Scenario: My grades check
   Given OP click on "My grades"
   Then OP see their grades within 2 seconds

   @student3
   Scenario: Log out
    Given OP click "Log out"







 



  