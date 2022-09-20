@SyzonenkoFeature2
  Feature: Grading - Quiz with textual question
    Background: 
      Given SK open page "http://ask-stage.portnov.com/"
    @FirstScenario
    Scenario: If user failed on Single-Choice question with Showstopper, but Quiz contains textual question, auto grade system grades: Failed
      Then SK type "teacher.account@gmail.com" in email field
      Then SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice, textual, Show-stopper)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      Then SK click Give Assignment button
      And SK log out from current account
      Then SK type "student.account@gmail.com" in email field
      And SK type "Student" in password field
      And SK click Sign In button
      Then SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(single-choice, textual, Show-stopper)"
#      First question is textula, second question is single-choice with show-stopper
      And SK select radio button number 2 as an anwser for question number 2
      And SK type "Anwser" as an anwser for question number 1
      And SK click Submit my Answer button
      And SK click My Grades button
      Then SK should see quiz "Test quiz(single-choice, textual, Show-stopper)" with Status: "FAILED"


    @DeleteAllAssignmentsByQuizName1
    Scenario: Delete 1
      And SK log in as Teacher
      And SK click Assigments button
      Then SK delete Assigments with quiz name "Test quiz(single-choice, textual, Show-stopper)"


    @SecondScenario
      Scenario: If Quiz has textual question with Showstopper, auto-grade system grades: Pending Review
      Then SK type "teacher.account@gmail.com" in email field
      Then SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice, textual, Show-stopper)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      Then SK click Give Assignment button
      And SK log out from current account
      Then SK type "student.account@gmail.com" in email field
      And SK type "Student" in password field
      And SK click Sign In button
      Then SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(single-choice, textual, Show-stopper)"
      And SK type "Anwser" as an anwser for question number 1
      And SK select radio button number 1 as an anwser for question number 2
      And SK click Submit my Answer button
      And SK click My Grades button
      Then SK should see quiz "Test quiz(single-choice, textual, Show-stopper)" with Status: "PENDING"


    @Submissions_ForGrade
      Scenario: Submissions: For Grade - Verify that Submitted Quiz with Textual question appears in For Grade page.
      Then SK type "teacher.account@gmail.com" in email field
      Then SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(textual)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      Then SK click Give Assignment button
      And SK log out from current account
      Then SK type "student.account@gmail.com" in email field
      And SK type "Student" in password field
      And SK click Sign In button
      Then SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(textual)"
      And SK type "Anwser" as an anwser for question number 1
      And SK click Submit my Answer button
      And SK log out from current account
      Then SK type "teacher.account@gmail.com" in email field
      Then SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Submissions button
      And SK click For Grade navigation bar
      And SK should see quiz "Test quiz(textual)" in For Grade page


    @DeleteAllAssignmentsByQuizName2
    Scenario: Delete 2
      And SK log in as Teacher
      And SK click Assigments button
      Then SK delete Assigments with quiz name "Test quiz(textual)"


    @Submissions_ForGrade
      Scenario: Submissions: For Grade - Verify that date and time displayed on For Grade page match date and time when assignment was submitted
      Then SK type "teacher.account@gmail.com" in email field
      Then SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(textual)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      Then SK click Give Assignment button
      And SK log out from current account
      Then SK type "student.account@gmail.com" in email field
      And SK type "Student" in password field
      And SK click Sign In button
      Then SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(textual)"
      And SK type "Anwser" as an anwser for question number 1
      #Time and Date is saved on click of Submit button call submissionDateTime class
      And SK click Submit my Answer button
      And SK log out from current account
      Then SK type "teacher.account@gmail.com" in email field
      Then SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Submissions button
      And SK click For Grade navigation bar
      Then SK should see date and time match submission date and time for quiz name "Test quiz(textual)"


    @Submissions_ForGrade
      Scenario: Submissions: For Grade - Verify that after teacher graded submitted assignment manually it is moved to Reviewed page
      Then SK type "teacher.account@gmail.com" in email field
      Then SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Submissions button
      And SK click For Grade navigation bar
      And SK click Grade button for quiz name "Test quiz(textual)"
      And SK grade question number 1 as 5 points
      And SK click Save quiz button
      And SK click Reviewed navigation menu
      Then SK should see quiz "Test quiz(textual)" in Reviewed page


    @DeleteAllAssignmentsByQuizName3
    Scenario: Delete 3
      And SK log in as Teacher
      And SK click Assigments button
      Then SK delete Assigments with quiz name "Test quiz"






      
