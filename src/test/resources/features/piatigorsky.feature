@feature1
  Feature: my first feature
    Background:
      Given LPR go to "http://ask-stage.portnov.com" page
      Then LPR type "lptest@chantellegribbon.com" into email field
      And LPR enter "abc123" as password
      Then LPR click SignIn button
      And LPR wait for 5 sec until "//h5[contains(text(),'Settings')]" is displayed

    @scenario1
    Scenario: Validate my assignments page as a student
      When LPR click on assignments

    @scenario2
    Scenario: Validate my grades page as a student
      When LPR click on grades

    @scenario3
    Scenario: Log in as a teacher, create a quiz
      Given LPR go to "http://ask-stage.portnov.com" page
      Then LPR login as a teacher with credentials "dakkagoblin@whymustyarz.com" and "abc123"
      And LPR wait for 5 sec until "//h5[contains(text(),'Settings')]" is displayed
     # Then LPR click on quizzes
     # And LPR create new quiz