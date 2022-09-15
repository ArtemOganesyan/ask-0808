@ask-port
 Feature: basic functions

  Background:
 Given OP navigate to login page "http://ask-stage.portnov.com"
 Then OP enter email "olegp123@gmail.com"
 Then OP enter password "portnov123"
 Then OP click Sign-in button
 And OP wait for 3 seconds



# @student1
#  Scenario: Student log in
#  Given OP navigate to home page
#  Then OP log in
#
#  @student2
#  Scenario: Student Log out
#   Given OP log out
#
  
 @student3
 Scenario: My assignments check
  Given OP click "My assignment" button
  Then OP see their assigments within 2 seconds

  @student4
  Scenario: My grades check
   Given OP click on "My grades"
   Then OP see their grades within 2 seconds

   @student5
   Scenario: Log out
    Given OP click "Log out"

    @student6
    Scenario: Sign-Up
     Given OP start registering new student
     Then OP fill out all fields required to register a new student
     Then OP confirm registration email






 



  