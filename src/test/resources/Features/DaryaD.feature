@darya
Feature:  Test set "Single Choice Question - Other"

  @ASK_Portnov1
  Scenario: "Others" text area accepts Alphanumeric & Sp. characters - login as a student (teacher have assigned a quiz)
    Given I DD open url "http://ask-stage.portnov.com"
    Then Assign the quiz to the student
    Then Type DD the text "dashanancy009@gmail.com" in the field with xpath "//input[@formcontrolname='email']"
    Then Type DD the text "wukqum-1hezny-weVrek" in the field with xpath "//input[@formcontrolname='password']"
    Then Click DD on the element with xpath "//span[contains(text(),'Sign In')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Go To My Assignments')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Go To Assessment')]"
    Then I DD wait for 3 sec
    Then Type DD the text "DaryaD" in the field with xpath "//textarea[@placeholder='Enter your answer']"
    Then Click DD on the element with xpath "//label[@for='mat-radio-3-input']"
    Then Click DD on the element with xpath "//label[@for='mat-checkbox-2-input']"
    Then Click DD on the element with xpath "//label[@for='mat-checkbox-3-input']"
    Then Type DD the text "Letters123!@#$%" in the field with xpath "//textarea[@placeholder='Other']"
    Then Click DD on the element with xpath "//span[contains(text(),'Submit My Answers')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Ok')]"
    Then I DD wait for 3 sec
    Then Click DD on the element with xpath "//h5[contains(text(),'My Grades')]"
    Then I DD wait for 3 sec
    Then Click DD the needed element with xpath "//span[contains(text(),'Details')]"
    And Verify DD that element with xpath "//div[@class='ng-star-inserted']" contain text "Letters123!@#$%"
#    Then Click DD the needed element with xpath "//tr[@class='ng-star-inserted']//button"  //tr[@class='ng-star-inserted'][last()]//button
    Then I DD wait for 2 sec
    Then I DD take a screenshot

  @ASK_Portnov2
  Scenario: "Others" text area accept Min 1 Characters - login as a student (teacher have assigned a quiz)
    Given I DD open url "http://ask-stage.portnov.com"
    Then Assign the quiz to the student
    Then Type DD the text "dashanancy009@gmail.com" in the field with xpath "//input[@formcontrolname='email']"
    Then Type DD the text "wukqum-1hezny-weVrek" in the field with xpath "//input[@formcontrolname='password']"
    Then Click DD on the element with xpath "//span[contains(text(),'Sign In')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Go To My Assignments')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Go To Assessment')]"
    Then I DD wait for 3 sec
    Then Type DD the text "DaryaD" in the field with xpath "//textarea[@placeholder='Enter your answer']"
    Then Click DD on the element with xpath "//label[@for='mat-radio-3-input']"
    Then Click DD on the element with xpath "//label[@for='mat-checkbox-2-input']"
    Then Click DD on the element with xpath "//label[@for='mat-checkbox-3-input']"
    Then Type DD the text "w" in the field with xpath "//textarea[@placeholder='Other']"
    Then Click DD on the element with xpath "//span[contains(text(),'Submit My Answers')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Ok')]"
    Then I DD wait for 3 sec
    Then Click DD on the element with xpath "//h5[contains(text(),'My Grades')]"
    Then I DD wait for 3 sec
    Then Click DD the needed element with xpath "//span[contains(text(),'Details')]"
    And Verify DD that element with xpath "//div[@class='ng-star-inserted']" contain text "w"
    Then I DD wait for 2 sec
    Then I DD take a screenshot

  @ASK_Portnov3
  Scenario: "Others" text area accept Min 1 Characters - login as a student (teacher have assigned a quiz)
    Given I DD open url "http://ask-stage.portnov.com"
    Then Assign the quiz to the student
    Then Type DD the text "dashanancy009@gmail.com" in the field with xpath "//input[@formcontrolname='email']"
    Then Type DD the text "wukqum-1hezny-weVrek" in the field with xpath "//input[@formcontrolname='password']"
    Then Click DD on the element with xpath "//span[contains(text(),'Sign In')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Go To My Assignments')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Go To Assessment')]"
    Then I DD wait for 3 sec
    Then Type DD the text "DaryaD" in the field with xpath "//textarea[@placeholder='Enter your answer']"
    Then Click DD on the element with xpath "//label[@for='mat-radio-3-input']"
    Then Click DD on the element with xpath "//label[@for='mat-checkbox-2-input']"
    Then Click DD on the element with xpath "//label[@for='mat-checkbox-3-input']"
    Then Type DD the text "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. 3What's happened to me?2 he thought.It wasn't a dream. His room, a proper human room although a little too small, lay peacefully between its four familiar walls. A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame.It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towardsrrrr" in the field with xpath "//textarea[@placeholder='Other']"
    Then Click DD on the element with xpath "//span[contains(text(),'Submit My Answers')]"
    Then I DD wait for 2 sec
    Then Click DD on the element with xpath "//span[contains(text(),'Ok')]"
    Then I DD wait for 3 sec
    Then Click DD on the element with xpath "//h5[contains(text(),'My Grades')]"
    Then I DD wait for 3 sec
    Then Click DD the needed element with xpath "//span[contains(text(),'Details')]"
    And Verify DD that element with xpath "//div[@class='ng-star-inserted']" contain text "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. 3What's happened to me?2 he thought.It wasn't a dream. His room, a proper human room although a little too small, lay peacefully between its four familiar walls. A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame.It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towardsrrrr"
    Then I DD wait for 2 sec
    Then I DD take a screenshot