Feature: Log in Validation

  @Signin
  Scenario Outline: Validating With valid Email And Password
    Given URl opened with URL for login
    Then Clicked on Sign in button
    Then Enter Valid "<email>" and "<Pwd>"
    And click one sign in button
    Then user will redirect to my account page

    Examples: 
      | email                   | Pwd   |
      | msathishkumar109@gmail.com | Sathish@2705 |
