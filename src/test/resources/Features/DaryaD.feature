@darya
Feature:  Test set "Single Choice Question - Other"
  Background: Login as a Teacher and assign the quiz to the Student
    Given DD open url "http://ask-stage.portnov.com"
    Then Type DD the email "da.dreizina@gmail.com" in the email field
    Then Type DD the password "12345Abc" in the password field
    Then Click DD on the Sign In button
    Then DD wait 3 sec when page is loaded for Teacher
    And DD assign the quiz to the student
    And DD logout as a Teacher

  @ASK_Portnov1
  Scenario: "Others" text area accepts Alphanumeric & Sp. characters - login as a student (teacher have assigned a quiz)
    Given DD open url "http://ask-stage.portnov.com"
    Then Type DD the email "dashanancy009@gmail.com" in the email field
    Then Type DD the password "wukqum-1hezny-weVrek" in the password field
    Then Click DD on the Sign In button
    Then DD wait 3 sec when page is loaded for Student
    Then Click DD on the My Assignments
    Then Click DD on the Go To Assessment button
    Then DD Pass the quiz with the text "Letters123!@#$%" in the Other field
    And Click DD on the Submit My Answers button
    Then Click DD on the My Grades
    Then Click DD on the Details button
    And DD verify the Other text area contains provided text "Letters123!@#$%"
    Then I DD take a screenshot
#    And Delete DD assignment