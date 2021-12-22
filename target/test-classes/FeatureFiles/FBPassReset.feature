Feature: to validate  the login functionality of the facebook page
Scenario: to validate the forgot password function in the facebook page
Given user should launch chrome and load facebook page
When user should select the forgot password button
And  user should type the valid number in the password reset page
And user should click enter
Then user should navigate to the reset password page

