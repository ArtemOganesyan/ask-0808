@feature1
Feature: My first feature

  @scenario1
  Scenario: Password validation
    Given ZK open url "http://ask-stage.portnov.com/"
    When ZK type "zkonovalova@gmail.com" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//input[@span = 'sing in']"
    And  ZK wait for 1 sec
    Then ZK element with xpath "//h5[contains(text(),'Log Out')]" is displayed
    And click ZK on the element with xpath "//h5[contains(text(), 'Log Out')]"
    #Wrong password
    When ZK type "zkonovalova@gmail.com" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "123" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//input[@span = 'sing in']"
    And  ZK wait for 1 sec
    Then ZK element with xpath "//input[@formcontrolname='password']" is displayed
    #Blank password
    When ZK type "zkonovalova@gmail.com" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//input[@span = 'sing in']"
    Then ZK element with xpath "//mat-error[contains(text()), 'This field is required']" is displayed