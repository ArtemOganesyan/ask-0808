@ask-0808
  Feature: Assignment submission status
    Background:
      Given MG open url "http://ask-stage.portnov.com"
      When MG input email as "wangui918@gmail.com"
      And Input password as "12345"
      And MG click on the sign-in button
      And MG wait for 3 sec
      Then MG redirected to "TEACHER" homepage
    @test1
    Scenario: View submission status- automatic graded assignment
      When MG click on submissons
      And MG wait for 3 sec
      And MG click on automatic graded column
      And MG click on the filter icon
      And Select group from group list
      And MG clicks on review button for Bella Keys and quiz title is Test Multi-choice Quiz
    @test2
    Scenario: View submission status - assignment yet to be manually graded
      When MG click on submissons
      And MG wait to be redirected to submissions page
      And MG click on For Grade column
      And MG click on the filter icon
      And Select group from group list
      And MG click on Grade button for Bella Keys and quiz title is Test Multi-choice Quiz
      Then MG is redirected to the manually submitted quiz