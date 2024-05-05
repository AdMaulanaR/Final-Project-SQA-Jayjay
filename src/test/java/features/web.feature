Feature: Test Automation Web www.saucedemo.com

  @web
  Scenario: Login logout using valid user name and password (TC-01)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    When user is on home page
    And user click button menu
    Then user click button logout

  @web
  Scenario: Login with invalid user but valid password (TC-02)
    Given user is on login page
    And user input user name "Tes Invalid User"
    And user input password "secret_sauce"
    And user click button login
    Then user able to see error message "Epic sadface: Username and password do not match any user in this service"

  @web
  Scenario: Login with valid user but invalid password (TC-03)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "tes_invalid"
    And user click button login
    Then user able to see error message "Epic sadface: Username and password do not match any user in this service"

  @web
  Scenario: Click login without input user name and password (TC-04)
    Given user is on login page
    And user click button login
    Then user able to see login error message "Epic sadface: Username is required"

  @web
  Scenario: Click login and shopping cart (TC-05)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    When user click icon shopping cart
    Then user will directed to the your cart page

  @web
  Scenario: Login and add three item to cart (TC-06)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon to cart in home page
    And user add one item to cart
    And user add one item to cart
    And user add one item to cart
    Then user verify cart item is match "3"

  @web
  Scenario: Login and add three item to cart (TC-07)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon to cart in home page
    And user add one item to cart
    And user add one item to cart
    And user add one item to cart
    Then user verify cart item is match "3"
    And user remove one item to cart
    And user remove one item to cart
    Then user verify cart item is match "1"

  @web
  Scenario: login, add item and checkout (TC-08)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon to cart in home page
    And user add one item to cart
    And user add one item to cart
    Then user verify cart item is match "2"
    And user click icon shopping cart
    And user will directed to the your cart page
    And user click btn checkout
    Then user will directed in your information page
    And user input first name "Ad Maulana"
    And user input last name "Rahman"
    And user input postal code "73123"
    And user click btn continue
    And user click btn finish
    Then user will directed in last page and sees the word "Thank you for your order!"

  @web
  Scenario: login, add item, checkout and back home page (TC-09)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon to cart in home page
    And user add one item to cart
    Then user verify cart item is match "1"
    And user click icon shopping cart
    And user will directed to the your cart page
    And user click btn checkout
    Then user will directed in your information page
    And user click btn cancel
    And user click btn continue shopping
    Then user is on home page

  @web
  Scenario: login, add item, checkout, but not input your information (TC-10)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon to cart in home page
    And user add one item to cart
    Then user verify cart item is match "1"
    And user click icon shopping cart
    And user will directed to the your cart page
    And user click btn checkout
    Then user will directed in your information page
    And user click btn continue
    Then user able to see error message "Error: First Name is required"

  @web
  Scenario: Click Home in login page(TC-11)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user click btn burger menu
    And user click btn about
    Then user will directed to the sauce labs page

  @web
  Scenario: Click Home in login page(TC-12)
    Given user is on login page
    And user input user name "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user click icon social media twitter
#    Then user will directed to sauce labs twitter page




