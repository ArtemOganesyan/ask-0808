@predefine:
Feature: Internship ask-portnov feature
 // @ask-portnov-student
 //Scenario: login as Student
  //  Given SS go to the "http://ask-stage.portnov.com" page
   // Then SS type "htmljason02@gmail.com" into email field
   // And SS enter "Banana01" as password
   // Then SS click SignIn button
  //  And SS wait for 6 sec

  @ask_portnov-Teacher
    Scenario: Login as Teacher
    Given SS go to the "http://ask-stage.portnov.com" page
    Then SS type "sawantsandhya.ni@gmail.com" into email field
    And SS enter "12345" as password
    Then SS click SignIn button
    And SS wait for 6 sec

  @ask1
  Scenario: Validate my assignment page
    When SS click on assignments

  @ask2
  Scenario: Validate my grades page
      When SS click on grades

  @ask3
  Scenario: create a Quizz
    Then SS go the quizzes

 @ask4
 Scenario: Activate user
    Given SS get activation code
 @ask5
 Scenario: User registration
   Given SS open url ""

