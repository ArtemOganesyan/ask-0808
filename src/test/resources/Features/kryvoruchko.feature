
  @feature1
    Feature: TestSet - Student: Setting - Full Name


      @scenario1
      Scenario: Login operation
        Given I open page "http://ask-stage.portnov.com"

        @scenario2
        Scenario: Password
          Given VK open "http://ask-stage.portnov.com" page
          Then VK type "thesix1980@santonicrotone.it" into email field
          And VK type "12345Abc" into password field
          Then VK click SignIn button
          And VK wait 5 sec








