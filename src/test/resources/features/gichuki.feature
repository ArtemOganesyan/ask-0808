@gichuki.feature
  Feature: Multiple choice question-points and submissions status
    @scenario1
    Scenario: Multiple choice question;points per question positive testing
      When I open the Portnov page
      And I input valid teacher email
      And I input valid teacher password
      And I click on sign in button
      And I wait for 3 sec
      Then I should be redirected to teacher's homepage
      When I select Quizzes on the sidebar menu
      And I wait for 3 sec
      And I create a new quiz
      And I wait for 3 sec
      And I input quiz title