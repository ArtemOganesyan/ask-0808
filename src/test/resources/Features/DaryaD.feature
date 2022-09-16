@darya
Feature:  Test set "Single Choice Question - Other"
  Background: Login as a Teacher and assign the quiz to the Student
    Given DD open url "http://ask-stage.portnov.com"
    Then Type DD the email "da.dreizina@gmail.com" in the email field
    Then Type DD the password "12345Abc" in the password field
    Then Click DD on the Sign In button
    And DD assign the quiz to the student
    And DD logout as a Teacher

  @ASK_Portnov1
  Scenario: "Others" text area accepts Alphanumeric & Sp. characters - login as a student (teacher have assigned a quiz)
    Given DD open url "http://ask-stage.portnov.com"
    Then Type DD the email "dashanancy009@gmail.com" in the email field
    Then Type DD the password "wukqum-1hezny-weVrek1" in the password field
    Then Click DD on the Sign In button
    Then Click DD on the Go To Assessments button
    Then Click DD on the Go To Assessment button
    Then DD Pass the quiz with the text "Letters123!@#$%" in the Other field
    And Click DD on the Submit My Answers button
    Then Click DD on the My Home
    Then Click DD on the Go To My Grades
    Then Click DD on the Details button
    And DD verify the Other text area contains provided text "Letters123!@#$%"

  @ASK_Portnov2
  Scenario: "Others" text area accept Min 1 Characters - login as a student (teacher have assigned a quiz)
    Given DD open url "http://ask-stage.portnov.com"
    Then Type DD the email "dashanancy009@gmail.com" in the email field
    Then Type DD the password "wukqum-1hezny-weVrek1" in the password field
    Then Click DD on the Sign In button
    Then Click DD on the Go To Assessments button
    Then Click DD on the Go To Assessment button
    Then DD Pass the quiz with the text "w" in the Other field
    And Click DD on the Submit My Answers button
    Then Click DD on the My Home
    Then Click DD on the Go To My Grades
    Then Click DD on the Details button
    And DD verify the Other text area contains provided text "w"

  @ASK_Portnov3
  Scenario: "Others" text area accept Max 1000 Characters - login as a student (teacher have assigned a quiz)
    Given DD open url "http://ask-stage.portnov.com"
    Then Type DD the email "dashanancy009@gmail.com" in the email field
    Then Type DD the password "wukqum-1hezny-weVrek1" in the password field
    Then Click DD on the Sign In button
    Then Click DD on the Go To Assessments button
    Then Click DD on the Go To Assessment button
    Then DD Pass the quiz with the text "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. 3What's happened to me?2 he thought.It wasn't a dream. His room, a proper human room although a little too small, lay peacefully between its four familiar walls. A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame.It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towardsrrrr" in the Other field
    And Click DD on the Submit My Answers button
    Then Click DD on the My Home
    Then Click DD on the Go To My Grades
    Then Click DD on the Details button
    And DD verify the Other text area contains provided text "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. 3What's happened to me?2 he thought.It wasn't a dream. His room, a proper human room although a little too small, lay peacefully between its four familiar walls. A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame.It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towardsrrrr"
    And Delete DD ALL assignments
