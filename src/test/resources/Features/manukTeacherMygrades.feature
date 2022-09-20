@homework
Feature: Student - my grades

  Background: Teacher log in
    Given AM open Ask page
    Then AM type "annya.manukyan@gmail.com" into email field
    And AM type "Joseph1" into password field
    Then AM click SignIn button
    And AM wait 5 sec when all elements load

  @test1

  Scenario: Pending Review means Teacher has to grade the Quiz
    And AM goes to Assignments
    Then AM click on Create New Assignment
    And AM choose student Anna Manukyan from list of students
    Then AM select quiz from dropdown menu with name Unique Quiz
    And AM create assignment
    Then AM Log out
    And AM Log in as Student
    And AM go to My Assignments
    And AM choose last assigned quiz
    And AM type "Anna" for textual question
    And AM answer single choice question
    And AM answer multiply choice question
    And AM Submit my answers
    And AM go to My Grades
    Then AM verify that assignment status is "PENDING"

  @test9

  Scenario: Date and time is listed "Automatic" when assignment was submitted by student, but hasn't been reviewed by teacher
    And AM goes to Assignments
    Then AM click on Create New Assignment
    And AM choose student Anna Manukyan from list of students
    Then AM select quiz from dropdown menu with name Unique Quiz
    And AM create assignment
    Then AM Log out
    And AM Log in as Student
    And AM go to My Assignments
    And AM choose last assigned quiz
    And AM type "Anna" for textual question
    And AM answer single choice question
    And AM answer multiply choice question
    And AM Submit my answers
    And AM go to My Grades
    Then AM verify that Graded at is "Automatic"

  @testQuiz

  Scenario: Teacher creates quiz

    Then AM go to Quizzes
    And AM click on Create New Quiz
    Then AM type "My cool quiz" as a title
    And AM click on Add Question button
    And AM choose textual type of question
    Then AM types "What is your name?" in textual question
    And AM click on Add Question button
    Then AM choose single-choice type of question
    And AM types "How many miles in mile?" is single choice question
    And AM type "One" in the first answer option and mark as right question
    And AM type "Two" in the second answer option
    And AM save the Quiz
#    Then AM delete the quiz "My cool quiz"

  @tet56
  Scenario: Teacher delete all quizzes with same name
    Then AM go to Quizzes
    Then AM delete all quizzes "My cool quiz"








