@feature teacher
  Feature: tests for teacher role
    Background: login as a teacher
      Given LPR go to "http://ask-stage.portnov.com" page
      Then LPR login as a teacher with credentials "dakkagoblin@whymustyarz.com" and "abc123"
      And LPR wait for 5 sec until "//h5[contains(text(),'Settings')]" is displayed

    @scenario1
    Scenario: create new quiz
      Then LPR click on quizzes
      And LPR create new quiz
      Then LPR find quiz by name "LPR Selenium Test quiz"
      And LPR delete quiz "LPR Selenium Test quiz" from the list