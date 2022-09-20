@gichukiHw.feature
Feature: Tests on email and password validation
  @test1
  Scenario: Email validation; no email
    Given MG open site with url "http://ask-stage.portnov.com/"
    And MG type the password "12345"
    And MG clicks on the sign in button
    Then Text is displayed as "This field is required" below email input field
  @test2
  Scenario: Email validation;wrong email format
    Given MG open site with url "http://ask-stage.portnov.com/"
    And MG type email as "wagui918"
    And MG click in password text field
    Then MG text is displayed as "Should be a valid email address" below email input field
  @test3
  Scenario: Correct password validation
    Given MG open site with url "http://ask-stage.portnov.com/"
    And MG input correct email as "wangui918@gmail.com"
    And MG input correct password as "12345"
    And MG clicks on the sign in button
    And MG wait for 5 seconds
    Then MG verify role is "TEACHER"
  @test4
  Scenario: Wrong password validation
    Given MG open site with url "http://ask-stage.portnov.com/"
    And MG input correct email as "wangui918@gmail.com"
    And MG input wrong password as "123"
    And MG clicks on the sign in button
    And MG wait for 5 seconds
    Then MG text is displayed as "Authentication failed. User not found or password does not match"
  @test5
  Scenario: User registration
    Given MG open site with url "http://ask-stage.portnov.com/"
    And MG click on "Register Now" button
    And MG type "Angel" as firstname
    And MG type "Wells" as lastname
    And MG type "angelwells@test.com" as email
    And MG type group as "exp02"
    And MG type password as "12345"
    And MG type confirm password as "12345"
    And MG click on "Register Me"
    Then MG get activation code for user "angelwells@test.com"
    And MG send activation request