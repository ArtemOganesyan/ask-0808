@homework
Feature: Student - my grades

  @test1
  Scenario: Pending Review means Teacher has to grade the Quiz
    Given I open url "http://ask-stage.portnov.com/"
    And I type "annya.manukyan@gmail.com" into element with xpath "//input[@formcontrolname='email']"
    And I type "Joseph1" into element with xpath "//input[@formcontrolname='password']"
    Then I click on element with xpath "//span[contains(text(),'Sign In')]"
    And I wait for 2 sec
    Then I click on element with xpath "//mat-sidenav//a[@href='/#/assignments']"
    And I wait for 2 sec
    Then I click on element with xpath "//span[contains(text(),'Create New Assignment')]"
    And I click on element with xpath "//div[@class='mat-list-text' and contains (string(),'Anna Manukyan')]"
    Then I click on element with xpath "//span[contains(text(), 'Select Quiz To Assign')]"
    And I click on element with xpath "//span[contains(text(),'Unique Quiz')]"
    And I click on element with xpath "//span[contains (text(), 'Give Assignment')]"
    And I wait for 3 sec
    Then I click on element with xpath "//h5[contains(text(), 'Log Out')]"
    Then I click on element with xpath "//span[contains(text(), 'Log Out')]"
    And I wait for 2 sec
    And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
    And I type "12345" into element with xpath "//input[@formcontrolname='password']"
    Then I click on element with xpath "//span[contains(text(),'Sign In')]"
    And I wait for 1 sec
    And I click on element with xpath "//h5[contains(text(),'My Assignments')]"
    And I wait for 2 sec
    And I click on element with xpath "//tr[@class='ng-star-inserted'][1]//button"
    And I wait for 2 sec
    And I type "Anna" into element with xpath "//textarea[@placeholder='Enter your answer']"
    And I click on element with xpath "//label[@for='mat-radio-2-input']"
    And I click on element with xpath "//label[@for='mat-checkbox-1-input']"
    And I click on element with xpath "//span[contains (text(),'Submit My Answers')]"
    And I wait for 2 sec
    And I click on element with xpath "//span[contains (text(),'Ok')]"
    And I click on element with xpath "//h5[contains (text(),'My Grades')]"
    Then element with xpath "//tr[@class='ng-star-inserted'][last()]//span" should contain text "PENDING"

#  @test2
#  Scenario: last
#    Given I open url "http://ask-stage.portnov.com/"
#    And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
#    And I type "12345" into element with xpath "//input[@formcontrolname='password']"
#    Then I click on element with xpath "//span[contains(text(),'Sign In')]"
#    And I wait for 1 sec
#    And I click on element with xpath "//h5[contains(text(),'My Grades')]"
#    And I press on element with xpath "//tr[@class='ng-star-inserted'][last()]//button"
#    And element with xpath "//div[contains (text(),'ASSESSMENT FAILED')]" is displayed

   @test3
   Scenario: My Grades info accessible through fixed navigation menu
     Given I open url "http://ask-stage.portnov.com/"
     And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
     And I type "12345" into element with xpath "//input[@formcontrolname='password']"
     Then I click on element with xpath "//span[contains(text(),'Sign In')]"
     And I wait for 1 sec
     And I click on element with xpath "//h5[contains(text(),'My Grades')]"
     Then element with xpath "//ac-student-grades-page" is displayed

   @test4
   Scenario: My Grades info accessible through home page
     Given I open url "http://ask-stage.portnov.com/"
     And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
     And I type "12345" into element with xpath "//input[@formcontrolname='password']"
     Then I click on element with xpath "//span[contains(text(),'Sign In')]"
     And I wait for 1 sec
     And I click on element with xpath "//span[contains(text(),'Go To My Grades')]"
     Then element with xpath "//ac-student-grades-page" is displayed

   @test5
   Scenario: Number of graded assignments is listed on the home page
     Given I open url "http://ask-stage.portnov.com/"
     And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
     And I type "12345" into element with xpath "//input[@formcontrolname='password']"
     Then I click on element with xpath "//span[contains(text(),'Sign In')]"
     And I wait for 1 sec
     Then element with xpath "//p[contains (.,'graded')]/span[@class='bold'][1]" is displayed

   @test6
   Scenario: Number of submitted, but that need to be reviewed by teacher assignments is listed on the home page
     Given I open url "http://ask-stage.portnov.com/"
     And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
     And I type "12345" into element with xpath "//input[@formcontrolname='password']"
     Then I click on element with xpath "//span[contains(text(),'Sign In')]"
     And I wait for 1 sec
     Then element with xpath "//p[contains (.,'but was(re) not reviewed by teacher yet.')]/span[@class='bold'][2]" is displayed

   @test7
   Scenario: Date and time of assignment submission is listed in my grades
     Given I open url "http://ask-stage.portnov.com/"
     And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
     And I type "12345" into element with xpath "//input[@formcontrolname='password']"
     Then I click on element with xpath "//span[contains(text(),'Sign In')]"
     And I wait for 1 sec
     And I click on element with xpath "//span[contains(text(),'Go To My Grades')]"
     Then element with xpath "//th[contains(text(),'Submitted At')]" is displayed
     And element with xpath "//tr[@class='ng-star-inserted'][1]/td[1]" should contain text "08/31/22 16:51"

   @test8
   Scenario: Date and time when assignment was graded by teacher is listed in my grades
     Given I open url "http://ask-stage.portnov.com/"
     And I type "extreme66@cbarata.pro" into element with xpath "//input[@formcontrolname='email']"
     And I type "12345" into element with xpath "//input[@formcontrolname='password']"
     Then I click on element with xpath "//span[contains(text(),'Sign In')]"
     And I wait for 1 sec
     And I click on element with xpath "//span[contains(text(),'Go To My Grades')]"
     Then element with xpath "//th[contains(text(),'Graded At')]" is displayed









