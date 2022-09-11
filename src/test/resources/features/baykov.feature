@feature1
  Feature: Test change password feature

    @scenario1
    Scenario:
      Given AB open ask page
      Then AB type login "one3all@cloudscredit.com" by link "//input[@formcontrolname='email']"
      # Old password
      And AB type password "qwe123" by link "//input[@formcontrolname='password']"
      Then AB click button login by link "//button[@type='submit']"
      And AB wait 2 sec
      And AB click menu settings by link "//h5[text()='Settings']"
      And AB wait 1 sec
      Then AB click change your password by link "//button[./span[text()='Change Your Password']]"
      And AB wait 2 sec
      # Old password
      Then AB type current password "qwe123" in field by link "//input[@formcontrolname='password']"
      And AB wait 1 sec
      # New password
      And AB type new password "qwe1234" in field by link "//input[@formcontrolname='newPassword']"
      # New password
      When AB type confirm new password "qwe1234" in field by link "//input[@formcontrolname='confirmPassword']"
      Then AB click button change by link "//button[./span[text()='Change']]"
      And AB wait 2 sec
      Then AB logout
      And AB wait 2 sec
      Then AB type login "one3all@cloudscredit.com" by link "//input[@formcontrolname='email']"
      # New password
      And AB type password "qwe1234" by link "//input[@formcontrolname='password']"
      Then AB click button login by link "//button[@type='submit']"
      And AB wait 2 sec
      Then AB verify login with new password