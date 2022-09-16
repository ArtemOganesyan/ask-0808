   @feature278:
   Feature: Registration First Name
     @Scenario279
    Scenario: To verify that Alphanumeric and special characters are allowed in First Name
      Given MAP open url "http://ask-stage.portnov.com"
       Then MAP click on Register Now button
       Then MAP type "Madhu" as firstName
       Then MAP type "T" as lastName
       Then MAP type "testteer051@gmail.com" as email
       And MAP type "ABC" as Group Code
       Then MAP type "12345Abc" as Password
       And MAP type "12345Abc" as Confirm Password field
       Then MAP click on Register Me button
       Then MAP get registered message
     @Scenario303
     Scenario: To verify that First Name can have maximum of 254 characters
       Given MAP open url "http://ask-stage.portnov.com"
       Then MAP click on Register Now button
       Then MAP type "itwasinterestingtoseeifitworksornotletmetrythisitwasinterestingtoseeifitworksornotletmetrythisitwasinterestingtoseeifitworksornotletmetrythisitwasinterestingtoseeifitworksornotletmetrythisitwasinterestingtoseeifitworksornotletmetrythisitwasinterestingtoseeifitworksornotletmetrythis" as firstName
       Then MAP type "T" as lastName
       Then MAP type "testteer051@gmail.com" as email
       And MAP type "ABC" as Group Code
       Then MAP type "12345Abc" as Password
       And MAP type "12345Abc" as Confirm Password field
       Then MAP click on Register Me button
       Then MAP did not get registered message

     @feature278:
     Feature: Password
     @Scenario303
       Scenario: To verify that error message is displayed if password field is empty
           Given MAP open url "http://ask-stage.portnov.com"
           Then MAP click on Register Now button
           Then MAP type "Madhu" as firstName
           Then MAP type "T" as lastName
           Then MAP type "testteer051@gmail.com" as email
           And MAP type "ABC" as Group Code
           And MAP type "12345Abc" as Confirm Password field
           Then MAP click on Register Me button
           Then MAP get error message
     @Scenario483
     Scenario: To verify that password and confirm password match
       Given MAP open url "http://ask-stage.portnov.com"
       Then MAP click on Register Now button
       Then MAP type "Madhu" as firstName
       Then MAP type "T" as lastName
       Then MAP type "testteer051@gmail.com" as email
       And MAP type "ABC" as Group Code
       Then MAP type "12345Abc" as Password
       And MAP type "12345bc" as Confirm Password field
       Then MAP click on Register Me button
       Then MAP get error message for mismatch of password




     @feature2:
     Feature: To verify STUDENT and TEACHER role
     @Scenario1
     Scenario:
       Given MAP open url
       And MAP type email and password
       And MAP click on sign in button




