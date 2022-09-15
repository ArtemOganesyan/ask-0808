@feature1
  Feature: My first feature
#    Background:
#      Given OAV go to "http://ask-stage.portnov.com" page
#      Then OAV type "artem.oganesyan@gmail.com" into email field
#      And OAV enter "12345Abc" as password
#      Then OAV click SignIn button
#      And OAV wait for 5 sec


#    Background:
#      Given OAV go to "http://ask-stage.portnov.com" page
#      Then OAV type "annya.manukyan@gmail.com" into email field
#      And OAV enter "Joseph1" as password
#      Then OAV click SignIn button
#      And OAV wait for 5 sec

#    @scenario1
#    Scenario: Validate my assignments page
#      When OAV click on assignments
#
#    @scenario2
#    Scenario: Validate my grades page
#      When OAV click on grades

#    @scenario3
#    Scenario: Create a quiz
#      Then OAV goto Quizzes
#
#
#    @scenario4
#    Scenario: Activate user
#      Given OAV get activation code

    @scenario5
    Scenario: User registration
      Given OAV open url "http://ask-stage.portnov.com/#/registration"
      Then OAV type "Art" as firstname
      Then OAV type "Oganesyan" as lastname
      Then OAV type "artogan@tesst.com" as email
      Then OAV type "ABC123" as group code
      Then OAV type "12345Abc" as password
      Then OAV type "12345Abc" as confirm password
      And OAV click on signup button
      Then OAV get activation token for user "artogan@tesst.com"
      And OAV send activation request
