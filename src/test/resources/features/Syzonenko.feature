@SyzonenkoFeature
  Feature: 'Create Assignment: Students', 'Grading: Quiz with no textual question'
    @TeacherCanAssignQuizForStudentsIndividually
    Scenario: Teacher can assign quiz for students individually
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      Then I should see role as "TEACHER"
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz" from 'Select quiz to assgin' drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      Then I should see quiz "Test quiz" assignment details on Assignments page


    @TeacherCanAssignQuizForStudentsSearchingByGroupCode
    Scenario: Teacher can assign quiz for students searching by group code
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(single-choice: FAILED)" from 'Select quiz to assgin' drop-down list
      And I select group code "TEST90" from Group filter drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      Then I should see quiz "Test quiz(single-choice: FAILED)" assignment details on Assignments page

    @TeacherCanAssignQuizToAllStudents
    Scenario: Teacher can assign quiz to all students
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(single-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And I click 'Select All' button
      And I click Give Assignment button
      Then I should see quiz "Test quiz(single-choice: PASSED)" assignment details on Assignments page

    @TeacherCanNOTAssignQuizIfStudentIsNotSelected
    Scenario: Teacher can NOT assign quiz if student is not selected
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(single-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And I click Give Assignment button
      Then I should see 'Select at least one Student' error message


    @TeacherCanNOTAssignQuizIfQuizIsNotSelected
    Scenario: Teacher can NOT assign quiz if quiz is not selected
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select Student from 'Students list'
      And I click Give Assignment button
      Then I should see 'This field is required' error message


    @Quiz_with_multiple-choice_question_graded_automatically:FAILED
    Scenario: Quiz with multiple-choice question graded automatically:FAILED
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(single-choice and multiple-choice questions: FAILED)" from 'Select quiz to assgin' drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      And I log out from current account
      And I log in as Student
      And I click My Assigments button
      And I click Go to Assessment button
      And I select radio button number 2 as an anwser for question number 1
      And I select check-box number 2 as an anwser for question number 2
      And I click Submit my Answer button
      When I click My Grades button
      Then I should see quiz "Test quiz(single-choice and multiple-choice questions: FAILED)" with Status: "FAILED"


    @Quiz_with_multiple-choice_question_graded_automatically:PASS
    Scenario: Quiz with multiple-choice question graded automatically:PASS
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(single-choice and multiple-choice questions: PASSED)" from 'Select quiz to assgin' drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      And I log out from current account
      And I log in as Student
      And I click My Assigments button
      And I click Go to Assessment button
      And I select radio button number 1 as an anwser for question number 1
      And I select check-box number 1 as an anwser for question number 2
      And I click Submit my Answer button
      When I click My Grades button
      Then I should see quiz "Test quiz(single-choice and multiple-choice questions: PASSED)" with Status: "PASSED"


    @Quiz_with_single-choice_question_graded_automatically:FAILED
    Scenario: Quiz with single-choice question graded automatically:FAILED
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(single-choice: FAILED)" from 'Select quiz to assgin' drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      And I log out from current account
      And I log in as Student
      And I click My Assigments button
      And I click Go to Assessment button
      And I select radio button number 2 as an anwser for question number 1
      And I click Submit my Answer button
      When I click My Grades button
      Then I should see quiz "Test quiz(single-choice: FAILED)" with Status: "FAILED"


    @Quiz_with_single-choice_question_graded_automatically:PASSED
    Scenario: Quiz with single-choice question graded automatically:PASSED
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(single-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      And I log out from current account
      And I log in as Student
      And I click My Assigments button
      And I click Go to Assessment button
      And I select radio button number 1 as an anwser for question number 1
      And I click Submit my Answer button
      When I click My Grades button
      Then I should see quiz "Test quiz(single-choice: PASSED)" with Status: "PASSED"


    @Quiz_with_multiple-choice_question_graded_automatically:FAILED
    Scenario: Quiz with multiple-choice question graded automatically:FAILED
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(multiple-choice: FAILED)" from 'Select quiz to assgin' drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      And I log out from current account
      And I log in as Student
      And I click My Assigments button
      And I click Go to Assessment button
      And I select check-box number 2 as an anwser for question number 1
      And I click Submit my Answer button
      When I click My Grades button
      Then I should see quiz "Test quiz(multiple-choice: FAILED)" with Status: "FAILED"

    @Quiz_with_multiple-choice_question_graded_automatically:PASSED
    Scenario: Quiz with multiple-choice question graded automatically:PASSED
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      And I click Create New Assignment button
      And I select quiz "Test quiz(multiple-choice: PASSED)" from 'Select quiz to assgin' drop-down list
      And I select Student from 'Students list'
      And I click Give Assignment button
      And I log out from current account
      And I log in as Student
      And I click My Assigments button
      And I click Go to Assessment button
      And I select check-box number 1 as an anwser for question number 1
      And I click Submit my Answer button
      When I click My Grades button
      Then I should see quiz "Test quiz(multiple-choice: PASSED)" with Status: "PASSED"


    @DeleteAllAssignmentsCreatedByTeacher
    Scenario: Delete all Assignments created by Teacher
      Given I open page "http://ask-stage.portnov.com/"
      And I log in as Teacher
      And I click Assigments button
      Then I delete Assigments with quiz name "Test quiz"
