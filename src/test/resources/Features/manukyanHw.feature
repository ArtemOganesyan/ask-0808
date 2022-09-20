@homework
Feature: Student - my grades



  Background: Student log in
    Given AM open Ask page
    Then AM type "extreme66@cbarata.pro" into email field
    And AM type "12345" into password field
    Then AM click SignIn button
    And AM wait 3 sec when all elements load





  @test3
  Scenario: My Grades info accessible through fixed navigation menu
    And AM go to My Grades
    Then My Grades page is displayed

  @test4
  Scenario: My Grades info accessible through home page
    And AM go to My Grades
    Then My Grades page is displayed

  @test5
  Scenario: Number of graded assignments is listed on the home page
    Then AM see number of graded assignments in Grades statistics

  @test6

  Scenario: Number of submitted, but that need to be reviewed by teacher assignments is listed on the home page
    Then AM see number of assignments that need to be reviewed by teacher in Grades statistic

  @test7

  Scenario: Date and time of assignment submission is listed in my grades
    And AM go to My Grades
    Then AM see column named Submitted At
    And AM see that first assignment was submitted at "08/31/22 16:51"

  @test8

  Scenario: Date and time when assignment was graded by teacher is listed in my grades
    And AM go to My Grades
    Then AM see column named Graded At


  @test10

  Scenario: Name of the graded Quiz is listed in the My Grades page
    And AM go to My Grades
    And AM see column Quiz with quizzes names

  @test11

  Scenario: Status of the graded assignment is listed in the My grades page
    And AM go to My Grades
    And AM see column Status

  @test12

  Scenario: Score of the graded assignment is listed in the My grades page
    And AM go to My Grades
    Then AM see column Score
    And Score is listed if Status is PASSED or FAILED


  @test13

  Scenario: Details button is present in My grades page if Quiz has status PASSED
    And AM go to My Grades
    Then AM see "Details" button next to Passed quiz

  @test14

  Scenario: Details button is present in My grades page if Quiz has status FAILED
    And AM go to My Grades
    Then AM see "Details" button next to Failed quiz

  @test15

  Scenario: Details button is not present in My grades page if Quiz has status PENDING
    And AM go to My Grades
    Then Am do not see "Details" button next to Pending quiz

  @test16

  Scenario: Student can review his answers and earned points by clicking details button
    And AM go to My Grades
    When AM click Details button
    Then AM see Grades details page
    And AM can see answers
    And AM can see points earned











