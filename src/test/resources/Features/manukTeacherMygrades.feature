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



