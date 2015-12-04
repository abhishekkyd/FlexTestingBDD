Feature: adda52 mobile web testing
  In order to verify adda52 mobile web application
  As a gamer	
  I want to specify test conditions

  #@web
  Scenario: New User Registration
    Given user is on adda52 login Page
    When user clicks on REGISTER NOW
    Then user is presented the signup form
    When user enters following details
      | username | shnake3         |
      | password | Test@123       |
      | email    | shane@hmail.com |
      | gender   | Male           |
    Then user is displayed confirmation message

  #@web
  Scenario: login
    Given user is on adda52 login Page
    When user enters follwoing details for login
      | username | mohitjn  |
      | password | work4fun |
    Then user is diaplyed home page

  #@web
  Scenario: join Game
    Given user is on adda52 login Page
    When user enters follwoing details for login
      | username | mohitjn  |
      | password | work4fun |
    Then user is diaplyed home page
    When user selects to list all Freeroll RING Games
    Then user is displayed Freeroll RING Games Details
    When user selects a game to play
    Then user is displayed Game Dashboard
    And user is also displayed all seats info

  #@web
  Scenario: Different Screen Sizes : Samsung Galaxy Note
    Given user is on adda52 login Page
    Then user resizes the window to 400 x 640
    And system takes snapshot of homepage
    And following error is displayed "Please play in landscape mode for better view."
    Then user resizes the window to 640 x 400
    And system takes snapshot of homepage
    And user is on adda52 login Page

  #@web
  Scenario: join Game - ipad
    Given user is on adda52 login Page
    Then user resizes the window to 1024 x 768
    When user enters follwoing details for login
      | username | mohitjn  |
      | password | work4fun |
    Then user is diaplyed home page
    When user selects to list all Freeroll RING Games
    Then user is displayed Freeroll RING Games Details
    When user selects a game to play
    Then user is displayed Game Dashboard
    And user is also displayed all seats info

  #@web
  Scenario: Verification of snapshot with expected one
    Given user is on adda52 login Page
    And system cuts image from screenshot
    And system compares the snapshot with expected image
