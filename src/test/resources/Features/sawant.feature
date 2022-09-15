@Predefined
  Feature: My first feature
    @ask-portnov
    Scenario: Login the Github
     Given I like to verify
      Then I do some other stuff


    @ask-portnov1
      Scenario: : :Login as Teacher
      Given SS go to "http://ask-stage.portnov.com" page
      Then SS type "sawantsandhya.ni@gmail.com" into email field
      Then SS enter "12345" as password
      Then SS click SignIn button
      And SS wait for 5 sec