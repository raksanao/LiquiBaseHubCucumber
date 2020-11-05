@testcase2
  Feature: Verifying result
    Scenario: User should be logged in

Given Click on the second option (Projects) in the left nav.
When Click to expand the default project.
Then Click on the Operations tab under this project.
And In the filter options, select Result = Pass.
Then Expand the dropdown below (titled No Operations to display).
#Create assertions for the above test to make sure you are verifying desired behavior.