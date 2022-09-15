#@feature1
#Feature: My first feature
#
#  @scenario1
#  Scenario: Password validation
#    Given ZK open url "http://ask-stage.portnov.com/"
#    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
#    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
#    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
#    And  ZK wait for 1 sec
#    Then ZK element with xpath "//h5[contains(text(),'Log Out')]" is displayed
#    And click ZK on the element with xpath "//h5[contains(text(), 'Log Out')]"
#
#  @scenario2
#  Scenario:Wrong password
#    Given ZK open url "http://ask-stage.portnov.com/"
#    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
#    Then type ZK "123" into element with xpath "//input[@formcontrolname='password']"
#    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
#    And  ZK wait for 1 sec
#    Then ZK element with xpath "//input[@formcontrolname='password']" is displayed
#
#  @scenario3
#  Scenario:Blank password
#    Given ZK open url "http://ask-stage.portnov.com/"
#    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
#    Then type ZK "" into element with xpath "//input[@formcontrolname='password']"
#    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
#    Then ZK element with xpath "//input[@id='mat-input-1']" is displayed
#
#  @scenario3
#  Scenario:Blank email
#    Given ZK open url "http://ask-stage.portnov.com/"
#    When ZK type "" into element with xpath "//input[@formcontrolname='email']"
#    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
#    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
#    Then ZK element with xpath "//input[@id='mat-input-1']" is displayed
#  @scenario4
#  Scenario:Wrong email
#    Given ZK open url "http://ask-stage.portnov.com/"
#    When ZK type "z@ya.ru" into element with xpath "//input[@formcontrolname='email']"
#    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
#    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
#    Then ZK element with xpath "//input[@id='mat-input-1']" is displayed
#
#  @scenario5
#  Scenario: Password validation
#    Given ZK open url "http://ask-stage.portnov.com/"
#    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
#    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
#    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
#    And  ZK wait for 1 sec
#    When ZK click on the element with xpath "//a[@href ='/#/assignments']"
#    And  ZK wait for 3 sec
#    Then ZK element with xpath "//a[@href ='/#/assignments']" is displayed
#    When ZK click on the element with xpath "//a[@href ='/#/assign-quiz']"
#    Then ZK element with xpath "//a[@href ='/#/assignments']" is displayed
#    Then ZK click on the element with xpath "//div[contains(text()), 'Zinaida Konovalova']"
#    Then ZK click on the element with xpath "//div[@class = 'mat-select-arrow']"
#    Then ZK click on the element with xpath "//span[contains(text()), 'test1']"
#    Then ZK element with xpath "//span[contains(text()), 'test1']" is displayed
#    When ZK click on the element with xpath "//span[contains(text()), 'Give Assignment']"
#    Then  ZK wait for 3 sec
#    And ZK element with xpath "//h4[contains(text()),'List of Assignments]" is displayed
#    And ZK element with xpath "//span(contains(text()),'test1'" is displayed
#    And click ZK on the element with xpath "//h5[contains(text(), 'Log Out')]"

  @scenario1
  Scenario: Password validation
    Given ZK open url "http://ask-stage.portnov.com/"
    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
    And  ZK wait for 1 sec
    Then ZK element with xpath "//h5[contains(text(),'Log Out')]" is displayed
    And click ZK on the element with xpath "//h5[contains(text(), 'Log Out')]"

  @scenario2
  Scenario:Wrong password
    Given ZK open url "http://ask-stage.portnov.com/"
    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "123" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
    And  ZK wait for 1 sec
    Then ZK element with xpath "//div[@class='cdk-overlay-container']" is displayed

  @scenario3
  Scenario:Blank password
    Given ZK open url "http://ask-stage.portnov.com/"
    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
    Then ZK element with xpath "//*[@role='alert' and contains (string(), 'This field is required')]" is displayed

  @scenario4
  Scenario:Blank email
    Given ZK open url "http://ask-stage.portnov.com/"
    When ZK type "" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
    Then ZK element with xpath "//*[@role='alert' and contains (string(), 'This field is required')]" is displayed

  @scenario5
  Scenario:Wrong email
    Given ZK open url "http://ask-stage.portnov.com/"
    When ZK type "z@ya.ru" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
    Then ZK element with xpath "//input[@id='mat-input-1']" is displayed

  @scenario6
  Scenario: Password validation
    Given ZK open url "http://ask-stage.portnov.com/"
    When ZK type "zkonovalova@ya.ru" into element with xpath "//input[@formcontrolname='email']"
    Then type ZK "teacher" into element with xpath "//input[@formcontrolname='password']"
    And ZK click on the element with xpath "//span[contains(text(),'Sign In')]"
    And  ZK wait for 1 sec
    When ZK click on the element with xpath "//a[@href ='/#/assignments']"
    And  ZK wait for 3 sec
    Then ZK element with xpath "//a[@href ='/#/assignments']" is displayed
    When ZK click on the element with xpath "//a[@href ='/#/assign-quiz']"
    Then ZK element with xpath "//a[@href ='/#/assignments']" is displayed
    Then ZK click on the element with xpath "//div[@class='mat-list-text' and contains (string(),'Zinaida Konovalova')]"
    Then ZK click on the element with xpath "//*[@placeholder = 'Select Quiz To Assign']//*[@class='mat-select-arrow']"
    And  ZK wait for 1 sec
    Then ZK click on the element with xpath "//span[contains(text(),'_ZK')]"
    When ZK click on the element with xpath "//button[@type='submit' and contains(string(),'Give Assignment')]"
    Then  ZK wait for 1 sec
    And ZK element with xpath "//h4[contains(text(),'List of Assignments')]" is displayed
    And ZK element with xpath "//span[contains(text(),'_ZK')]" is displayed
    And click ZK on the element with xpath "//h5[contains(text(), 'Log Out')]"
  @scenario10
  Scenario
