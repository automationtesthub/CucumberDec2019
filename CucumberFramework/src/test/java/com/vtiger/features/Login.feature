Feature: Login functionality



@sanity
Scenario: Login with valid credentials
Given user should on login page
When user enters valid userid and password
|admin|admin|
And clicks on login button
Then user should be landing on home page
And verify logout link

@Regression
Scenario Outline: Login with invalid credentials
Given user should on login page
When user enters invalid userid is "<userid>" and password is "<password>"
And clicks on login button
Then user should be get error message on login page

Examples:
|userid | password |
|aaaaaaa|pppppppppp|
|bbbbbbb|ggggggpppp|
|ccccccc|phhhhhpppp|

#Comment
