@homework
Feature: Grading - Quiz with textual question

  Background: Teacher log in
    Given AM open Ask page
    Then AM type "annya.manukyan@gmail.com" into email field
    And AM type "Joseph1" into password field
    Then AM click SignIn button
    And AM wait 5 sec when all elements load

 @test1

 Scenario: Auto-grade system grades automatically Quiz with textual question: Pending Review
    Then AM goes to Assignments
    And AM click on Create New Assignment
    And AM choose student Anna Manukyan from list of students
    And AM select quiz from dropdown menu with name Unique Quiz
    And AM create assignment
    Then AM Log out
    And AM Log in as Student
    And AM go to My Assignments
    And AM choose last assigned quiz
    Then AM type "Anna" for textual question
    And AM answer single choice question
    And AM answer multiply choice question
    And AM Submit my answers
    Then AM go to My Grades
    And AM verify that assignment status is "PENDING"

 
    
    
