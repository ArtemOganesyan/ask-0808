@ask-portOtherFeatures

Feature: other functionality
  Background: 
    Given OP go to login page "http://ask-stage.portnov.com"

  @student1
  Scenario: Sign up
    Given OP fill out all fields required to register new student
    Then OP confirm the registration email

  @teacher1
  Scenario: Teacher login in
    Given OP fill in email "olegteacher@gmail.com" and password "portnov123"
    Then OP  log in as Teacher


   @teacher2
   Scenario: change Student role to Teacher
     Given OP log in Teacher account
     Then OP change Student role to Teacher

   @teacher3
     Scenario: change Teacher role to Student
     Given OP sign in Teacher account
     Then OP change Teacher role to Student

  @teacher4
  Scenario: Delete user
    Given OP log with teacher email:"olegteacher@gmail.com" and password "portnov123"
    Then OP delete user profile of student "Oleg Pasish"


#
#  @student2
##    need to use url http://ask-stage.portnov.com/api/v1/reset-password/ and apply "POST" method instead of "GET" as in HOOKS
#
#  Scenario: Password reset
#    Given OP submit email "olegst@gmail.com" for password reset
#    And then OP wait for 3 seconds
#    Then OP confirm password reset email
#



