@testHw
Feature: Password Field
  @test4
  Scenario: Password and confirm password should match/Negative
    Given MP open url "http://ask-stage.portnov.com"
    Then MP click Register Now button
    Then MP type "Madhu" in firstName field
    Then MP type "T" in lastName field
    Then MP type "testteer051@gmail.com" in email field
    Then MP type "ABC" in group field
    Then MP type "12345Abc" in password field
    And MP type "12345bc" in confirmPassword field
#    Then MP get text message

  @test292
  Scenario: Password and confirm password should match/Positive
    Given MP open url "http://ask-stage.portnov.com"
    Then MP click Register Now button
    Then MP type all required field
    And MP click Register Me button
    Then MP will wait 3 sec
    Then MP get registered message

#  @test2
#Feature: First Name Field
  @test281
 Scenario: First Name field
    Given MP navigate to url "http://ask-stage.portnov.com"
    Then MP click Register Now button
#    Then MP type "" in firstName field
    Then MP type "T" in lastName field
    Then MP type "testteer051@gmail.com" in email field
    Then MP type "ABC" in group field
    Then MP type "12345Abc" in password field
    And MP type "12345bc" in confirmPassword field
    And MP click Register Me button
    Then MP will wait 1 sec
#    Then MP did not get registered message

  @test20
  Scenario: To validate student my assignment page
    Given MP open url "http://ask-stage.portnov.com"
    Then MP type "testteer050@gmail.com" in email field
    Then MP type "12345Abc" in password field
    Then MP click SignIn button
    And MP wait 5 sec
    Then MP click on Assignments

  @test22
  Scenario: To validate student my grades page
    Given MP open url "http://ask-stage.portnov.com"
    Then MP type "testteer050@gmail.com" in email field
    Then MP type "12345Abc" in password field
    Then MP click SignIn button
    And MP wait 5 sec
    Then MP click on grades










