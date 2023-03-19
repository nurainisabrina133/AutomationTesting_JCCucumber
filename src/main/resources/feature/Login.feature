Feature: Login User HRM
    Scenario: User valid login into web HRM
        Given User open browser and url
        When User enter valid username
        And User enter valid password
        And User click button login
        Then User go to page dashboard

    Scenario: User test button search into web HRM
        When User click symbol

    Scenario: User invalid login into web HRM
        When User click button logout
        And User enter invalid username
        And User enter invalid password
        And User click button login
        Then User get message invalid credentials