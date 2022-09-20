@SyzonenkoFeature1
  Feature: 'Create Assignment: Students', 'Grading: Quiz with no textual question', 'Textual Question: Points'
    Background:
      Given SK open page "http://ask-stage.portnov.com/"


    @TeacherCanAssignQuizForStudentsIndividually
    Scenario: Teacher can assign quiz for students individually
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      Then SK should see role as "TEACHER"
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      Then SK should see quiz "Test quiz" assignment details on Assignments page


    @TeacherCanAssignQuizForStudentsSearchingByGroupCode
    Scenario: Teacher can assign quiz for students searching by group code
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice: FAILED)" from 'Select quiz to assgin' drop-down list
      And SK select group code "TEST90" from Group filter drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      Then SK should see quiz "Test quiz(single-choice: FAILED)" assignment details on Assignments page

    @TeacherCanAssignQuizToAllStudents
    Scenario: Teacher can assign quiz to all students
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And SK click 'Select All' button
      And SK click Give Assignment button
      Then SK should see quiz "Test quiz(single-choice: PASSED)" assignment details on Assignments page

    @TeacherCanNOTAssignQuizIfStudentIsNotSelected
    Scenario: Teacher can NOT assign quiz if student is not selected
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And SK click Give Assignment button
      Then SK should see 'Select at least one Student' error message


    @TeacherCanNOTAssignQuizIfQuizIsNotSelected
    Scenario: Teacher can NOT assign quiz if quiz is not selected
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      Then SK should see 'This field is required' error message


    @Quiz_with_multiple-choice_question_graded_automatically:FAILED
    Scenario: Quiz with multiple-choice question graded automatically:FAILED
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice and multiple-choice questions: FAILED)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      And SK log out from current account
      And SK log in as Student
      And SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(single-choice and multiple-choice questions: FAILED)"
      And SK select radio button number 2 as an anwser for question number 1
      And SK select check-box number 2 as an anwser for question number 2
      And SK click Submit my Answer button
      When SK click My Grades button
      Then SK should see quiz "Test quiz(single-choice and multiple-choice questions: FAILED)" with Status: "FAILED"


    @Quiz_with_multiple-choice_question_graded_automatically:PASS
    Scenario: Quiz with multiple-choice question graded automatically:PASS
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice and multiple-choice questions: PASSED)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      And SK log out from current account
      And SK log in as Student
      And SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(single-choice and multiple-choice questions: PASSED)"
      And SK select radio button number 1 as an anwser for question number 1
      And SK select check-box number 1 as an anwser for question number 2
      And SK click Submit my Answer button
      When SK click My Grades button
      Then SK should see quiz "Test quiz(single-choice and multiple-choice questions: PASSED)" with Status: "PASSED"


    @Quiz_with_single-choice_question_graded_automatically:FAILED
    Scenario: Quiz with single-choice question graded automatically:FAILED
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice: FAILED)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      And SK log out from current account
      And SK log in as Student
      And SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(single-choice: FAILED)"
      And SK select radio button number 2 as an anwser for question number 1
      And SK click Submit my Answer button
      When SK click My Grades button
      Then SK should see quiz "Test quiz(single-choice: FAILED)" with Status: "FAILED"


    @Quiz_with_single-choice_question_graded_automatically:PASSED
    Scenario: Quiz with single-choice question graded automatically:PASSED
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(single-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      And SK log out from current account
      And SK log in as Student
      And SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(single-choice: PASSED)"
      And SK select radio button number 1 as an anwser for question number 1
      And SK click Submit my Answer button
      When SK click My Grades button
      Then SK should see quiz "Test quiz(single-choice: PASSED)" with Status: "PASSED"


    @Quiz_with_multiple-choice_question_graded_automatically:FAILED
    Scenario: Quiz with multiple-choice question graded automatically:FAILED
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(multiple-choice: FAILED)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      And SK log out from current account
      And SK log in as Student
      And SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(multiple-choice: FAILED)"
      And SK select check-box number 2 as an anwser for question number 1
      And SK click Submit my Answer button
      When SK click My Grades button
      Then SK should see quiz "Test quiz(multiple-choice: FAILED)" with Status: "FAILED"

    @Quiz_with_multiple-choice_question_graded_automatically:PASSED
    Scenario: Quiz with multiple-choice question graded automatically:PASSED
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Test quiz(multiple-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      And SK log out from current account
      And SK log in as Student
      And SK click My Assigments button
      And SK click Go to Assessment button for quiz "Test quiz(multiple-choice: PASSED)"
      And SK select check-box number 1 as an anwser for question number 1
      And SK click Submit my Answer button
      When SK click My Grades button
      Then SK should see quiz "Test quiz(multiple-choice: PASSED)" with Status: "PASSED"


    @ChangePasswordStudentAccount
    Scenario: Student can change Password in Settings
      And SK type "student.account@gmail.com" in email field
      And SK type "Student" in password field
      And SK click Sign In button
      And SK click Settings button
      And SK click Change Your Password
      Then SK type "Student" in current Password field
      Then SK type "StudentABC" in New Password field
      Then SK type "StudentABC" in Confirm New Password
      Then SK click Change button
      Then SK log out from current account
      Then SK type "student.account@gmail.com" in email field
      Then SK type "StudentABC" in password field
      Then SK click Sign In button
      Then SK should see role as "STUDENT"

    @ForgotPassword
    Scenario: Verify user able to reset password using Forgot Password
      Then SK click I forgot my password link
      Then SK type "student.account@gmail.com" into Reset password email field
      Then SK click Request Password Reset button
      Then SK should see 'Your request is confirmd' message
      Then SK click browser Back button
      Then SK clikc 'Back to Log In' button
      And SK get Reset Password activation code for user with email "student.account@gmail.com"
      Then SK set new password as "Student"
      Then SK type "student.account@gmail.com" in email field
      Then SK type "Student" in password field
      Then SK click Sign In button
      Then SK should see role as "STUDENT"


    @TextualQuestionPointsTeacherAbleToAddANumberOfPointsWhileCreatingQuiz
    Scenario: Textual Question, Points - Teacher able to add a number of points while creating quiz
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Quizzes button
      And SK click 'Create New Quiz' button
      And SK type "Automation Test Quiz" in 'Title Of The Quiz' field
      And SK click 'Add Question' button 1 times
      And SK select Question Type "Textual" for question number 1
      And SK type "Test question" for textual Question name field for question number 1
      And SK set points to 8 for question number 1
      And SK click Save quiz button
      Then SK select quiz "Automation Test Quiz" from List Of Quizzes
      Then SK should see 'Maximum possible score' for quiz "Automation Test Quiz" is 8


    @TextualQuestionPointsTeacherAbleToEditPointsAfterQuizBeenCreated
    Scenario: Textual Question, Points - Teacher able to Edit points after quiz been created
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Quizzes button
      And SK click 'Create New Quiz' button
      And SK type "Automation Test Quiz" in 'Title Of The Quiz' field
      And SK click 'Add Question' button 1 times
      And SK select Question Type "Textual" for question number 1
      And SK type "Test question" for textual Question name field for question number 1
      And SK set points to 8 for question number 1
      And SK click Save quiz button
      Then SK select quiz "Automation Test Quiz" from List Of Quizzes
      Then SK click Edit button from drop down menu for quiz "Automation Test Quiz"
#      Select question number from quiz-builder page
      And SK select question number 1
      And SK set points to 3 for question number 1
      And SK click Save quiz button
      Then SK select quiz "Automation Test Quiz" from List Of Quizzes
      Then SK should see 'Maximum possible score' for quiz "Automation Test Quiz" is 3


    @TextualQuestionPointsStudentsCanSeePointsForGradedQuiz
      Scenario: Textual Question, Points - Students can see points for graded quiz
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Assigments button
      And SK click Create New Assignment button
      And SK select quiz "Automation Test Quiz" from 'Select quiz to assgin' drop-down list
      And SK select Student from 'Students list'
      And SK click Give Assignment button
      And SK log out from current account
      And SK type "student.account@gmail.com" in email field
      And SK type "Student" in password field
      And SK click Sign In button
      And SK click My Assigments button
      And SK click Go to Assessment button for quiz "Automation Test Quiz"
      And SK type "Anwser" as an anwser for question number 1
      And SK click Submit my Answer button
      And SK log out from current account
      And SK type "teacher.account@gmail.com" in email field
      And SK type "Teacher" in password field
      And SK click Sign In button
      And SK click Submissions button
      And SK click For Grade navigation bar
      And SK click Grade button for quiz name "Automation Test Quiz"
      And SK grade question number 1 as 3 points
      And SK click Save quiz button
      And SK log out from current account
      And SK type "student.account@gmail.com" in email field
      And SK type "Student" in password field
      And SK click Sign In button
      And SK click My Grades button
      And SK click Details button for graded quiz name "Automation Test Quiz"
      Then SK shoulde see question number 1 graded as 3 points



    @DeleteAllAssignmentsByQuizName
    Scenario: Delete all Assignments by Quiz name (deletes all assignments with that quiz name)
      And SK log in as Teacher
      And SK click Assigments button
      Then SK delete Assigments with quiz name "Test quiz"

    @DeleteAllAssignmentsByQuizName1
    Scenario: Delete all Assignments by Quiz name (deletes all assignments with that quiz name)
      And SK log in as Teacher
      And SK click Assigments button
      Then SK delete Assigments with quiz name "Automation Test Quiz"

    @DeleteQuizByName
    Scenario: Delete quiz by name (useful for quiz clean up after tests)
      And SK log in as Teacher
      And SK click Quizzes button
      Then SK delete Quiz with name "Automation Test Quiz"