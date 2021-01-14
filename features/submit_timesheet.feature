Feature: Submit timesheet
    Login to fill out the timesheet

    Background: User is logged in
        Given User is at the login page
        When User inputs email
        And their password
        And submit the information
        Then the user is redirected to their userhome page

    Scenario Outline: Enter timesheet page and submit hours
        When User clicks timesheet button
        And enters the hours
        And clicks submit button
        Then user should be notified of successful submission