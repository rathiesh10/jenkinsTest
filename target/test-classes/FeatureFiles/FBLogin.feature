Feature: to validate the login functionality of the facebook page
Scenario: validate the facebook page wih invalid username and password
Given user should launch the browser and load the fb page
When user should type the username in the facebook page 
And  user should type the password in the facebook page
And user should click the login button
Then user should navigate to incorrect credentials page
