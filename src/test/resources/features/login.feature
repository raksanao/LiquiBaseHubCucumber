@testcase1
  Feature: Testing login page functionality
    Scenario: User should be logged in
   Given User in Login page
    When Click on the third option (Settings) in the left nav.
   And   Click on the User Info tab.
   Then  Edit the user info fields to add updated info for your user account.
   #and
    #Create assertions for the above test to make sure you are verifying desired behavior.

     |firstname|middlename |lastname       |url     |company    |bio  |
     |user     |John       |Strickland     |okk.com |liquebase  |hub  |


