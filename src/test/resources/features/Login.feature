Feature: Login Test
  #Agile : As a user,  I should be able to login with valid credential

  Background:
    Given The user is on the login page


  Scenario: Positive scenario 1 -user should be able to login
    When The user enters valid credentials
    Then The user verify that welcome message is "Welcome JakeBouver"


  Scenario: Positive scenario 2 -user should be able to login
    When The user enters "JakeBouver" and "Test1234" and click login button
    Then The user verify that welcome message is "Welcome JakeBouver"
  @wip
  Scenario Outline: Positive scenario 3 -user should be able to login
    When The user enters "<username>" and "<password>" and click login button
    Then The user verify that welcome message is "<welcomeMessage>"
    Examples:
      | username   | password | welcomeMessage     |
      | JakeBouver | Test1234 | Welcome JakeBouver |


  Scenario Outline: Positive scenario 4 -user should be able to login
    When The user enters valid username and passowrd
      | username | <username> |
      | password | <password> |
    Then The user verify that welcome message is "<welcomeMessage>"
    Examples:
      | username   | password | welcomeMessage     |
      | JakeBouver | Test1234 | Welcome JakeBouver |

  @negativeLoginTest
  Scenario Outline:Negative Scenario- user should NOT be able to log in with invalid credentials
    When The user enters "<invalidUsername>" and "<invalidPassword>" and click login button
    Then The user verifies that invalid credentials "<message>"
    Examples:
      | invalidUsername | invalidPassword | message                                |
      | JakeBouver      |                 | Please fill out Username and Password. |
      |                 | Test1234        | Please fill out Username and Password. |
      |                 |                 | Please fill out Username and Password. |
      | JakeBouver      | Test12345       | Wrong password.                        |
      | JakeBouvers     | Test1234        | User does not exist.                   |
      | JakeBouvers     | Test12345       | User does not exist.                   |

















