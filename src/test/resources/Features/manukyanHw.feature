@homework
Feature: Student - my grades

  Background: Teacher log in
    Given AM open Ask page
    Then AM type "annya.manukyan@gmail.com" into email field
    And AM type "Joseph1" into password field
    Then AM click SignIn button
    And AM wait 5 sec when all elements load

#  Background: Student log in
#    Given AM open Ask page
#    Then AM type "extreme66@cbarata.pro" into email field
#    And AM type "12345" into password field
#    Then AM click SignIn button
#    And AM wait 3 sec when all elements load



  @test1
#    use Background with Teacher log in
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

#
#  @test2
#  Scenario: last (not for testing)
#    Given I open url "http://ask-stage.portnov.com/"
#    And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
#    And I type "12345" into element with xpath "//input[@formcontrolname='password']"
#    Then I click on element with xpath "//span[contains(text(),'Sign In')]"
#    And I wait for 1 sec
#    And I click on element with xpath "//h5[contains(text(),'My Grades')]"
#    And I wait for 3 sec
#    And I press on element with xpath "//tr[@class='ng-star-inserted'][last()]//button"
#    And element with xpath "//div[contains (text(),'ASSESSMENT FAILED')]" is displayed
#

   @test3
    #    use Background with Student log in
   Scenario: My Grades info accessible through fixed navigation menu
     And AM go to My Grades
     Then My Grades page is displayed
#
   @test4
    #    use Background with Student log in
   Scenario: My Grades info accessible through home page
     And AM go to My Grades
     Then My Grades page is displayed
#
   @test5
#        use Background with Student log in
   Scenario: Number of graded assignments is listed on the home page
     Then AM see number of graded assignments in Grades statistics

   @test6
#        use Background with Student log in
   Scenario: Number of submitted, but that need to be reviewed by teacher assignments is listed on the home page
     Then AM see number of assignments that need to be reviewed by teacher in Grades statistic

   @test7
#        use Background with Student log in
   Scenario: Date and time of assignment submission is listed in my grades
     And AM go to My Grades
     Then AM see column named Submitted At
     And AM see that first assignment was submitted at "08/31/22 16:51"

   @test8
#        use Background with Student log in
   Scenario: Date and time when assignment was graded by teacher is listed in my grades
     And AM go to My Grades
     Then AM see column named Graded At

#   @test9
##         use Background with Teacher log in
#   Scenario: Date and time is listed "Automatic" when assignment was submitted by student, but hasn't been reviewed by teacher
#     And AM goes to Assignments
#     Then AM click on Create New Assignment
#     And AM choose student Anna Manukyan from list of students
#     Then AM select quiz from dropdown menu with name Unique Quiz
#     And AM create assignment
#     Then AM Log out
#     And AM Log in as Student
#     And AM go to My Assignments
#     And AM choose last assigned quiz
#     And AM type "Anna" for textual question
#     And AM answer single choice question
#     And AM answer multiply choice question
#     And AM Submit my answers
#     And AM go to My Grades
#     Then AM verify that Graded at is "Automatic"

   @test10
#          use Background with Student log in
   Scenario: Name of the graded Quiz is listed in the My Grades page
     And AM go to My Grades
     And AM see column Quiz with quizzes names

   @test11
#          use Background with Student log in
   Scenario: Status of the graded assignment is listed in the My grades page
     And AM go to My Grades
     And AM see column Status











