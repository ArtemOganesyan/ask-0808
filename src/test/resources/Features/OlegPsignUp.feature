@ask-portOtherFeatures

Feature: other functionality
  Background: 
    Given OP go to login page "http://ask-stage.portnov.com"

  @teacher1
  Scenario: Teacher login in
    Given OP fill in email "olegteacher@gmail.com" and password "portnov123"
    Then OP  log in as Teacher

  @student1
  Scenario: Sign up
    Given OP fill out all fields required to register new student
    Then OP confirm the registration email

  @student2

  Scenario: Password reset
    Given OP submit email "olegst@gmail.com" for password reset
    And then OP wait for 5 seconds
    Then OP confirm password reset email


  @teacher2
  Scenario: Delete user
    Given OP log with teacher email:"olegteacher@gmail.com" and password "portnov123"
    Then OP delete user profile of student "Oleg Pasish"


   @teacher3
   Scenario: change Student role to Teacher
     Given OP log in Teacher account
     Then OP change Student role to Teacher

   @teacher4
     Scenario: change Teacher role to Student
     Given OP sign in Teacher account
     Then OP change Teacher role to Student






