Feature: login

  Scenario Outline: loginFunctioninvalidcredential
    And clickOnLoginLink
    Given login credential <user><pass>
    Then getInvalidCredentialError

    Examples: 
      | user                      | pass            |
      | "sonarsameer1@gmail.com"  | "ddff26@DDFF23" |
      | "sonarsameer30@gmail.com" | "ddff26@DDFF"   |
      | "sonarsameer30@gmail.com" | "ddff26@DDFF23" |
      | "sonarsameer30@gmail.com" | "ddff26@DDFF2345" |
