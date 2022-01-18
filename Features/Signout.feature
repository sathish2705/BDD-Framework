Feature: signout app

  @SignOut
  Scenario Outline: signout application
    Given URl opened with signout
    Then Clicked on Sign in button in so
    Then Enter Valid "<email>" and "<Pwd>" in so
    And click one sign in button in so
    And click on img and signout
    And check sign out is done successfully
   


    Examples: 
      | email                        | Pwd      |
      | msathishkumar109@gmail.com | Sathish@2705|