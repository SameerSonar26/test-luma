Feature: forgotPassword

  Scenario: VerificationOfTheForgotYourPasswordLink
    And clickOnLoginLink
    And clickonForgotPassWordLink
    Given validEmailID
    And clickOnResetPasswordButton
    Then GetResetPasswordMsg

  Scenario: VerificationOfTheForgotYourPasswordPageWithEmptyEmailID
    And clickOnLoginLink
    And clickonForgotPassWordLink
    Given emptyEmailID
    And clickOnResetPasswordButton
    Then GetEmptyEmailIDErrorMsg
