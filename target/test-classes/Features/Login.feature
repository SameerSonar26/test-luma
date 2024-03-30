Feature: login

  Scenario Outline: loginFunctioninvalidcredential
    And clickOnLoginLink
    Given loginInvalidcredential <user><pass>
    Then getInvalidCredentialError

    Examples: 
      | user                      | pass            |
      | "sonarsameer1@gmail.com"  | "ddff26@DDFF23" |
      | "sonarsameer30@gmail.com" | "ddff26@DDFF"   |
      | "sonarsameer30@gmail.com" | "ddff26@DDFF23" |

  Scenario Outline: verificationOfTheLoginPageWithAValidUsernameAndPassword
    And clickOnLoginLink
    Given loginValidCredential <user1><pass1>
    Then getValidCredentialMsg

    Examples: 
      | user1                    | pass1         |
      | "sonarsameer1@gmail.com" | "ddff26@DDFF" |
