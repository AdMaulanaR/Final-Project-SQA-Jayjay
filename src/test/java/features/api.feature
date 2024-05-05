Feature: Test Automation API https://dummyapi.io/

  @api
  Scenario: Test get list data normal TC-01
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equals to 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test get user by id (TC-02)
    Given prepare url for "GET_USER_BY_ID"
    And hit api get user by id
    Then validation status code is equals to 200
    Then validation response body user
    Then validation response json with JSONSchema "get_user_by_id.json"

  @api
  Scenario: Test get user by wrong id (TC-03)
    Given prepare url for "GET_USER_WRONG_ID"
    And hit api get user wrong id
    Then validation status code is equals to 400

  @api
  Scenario: Test post create new user (TC-04)
    Given prepare url for "GET_POST_CREATE_NEW_USER"
    And hit api get post create new user
    Then validation status code is equals to 200
    Then validation response json with JSONSchema "post_create_new_user.json"

  @api
  Scenario: Test create new user with minimum criteria firstName, lastName, and Email (TC-05)
  Given prepare url for "GET_POST_CREATE_NEW_USER"
  And hit api get post create new min
  Then validation status code is equals to 200
  Then validation response body user min
  
  @api
  Scenario: Test create new user without email (TC-06)
  Given prepare url for "GET_POST_CREATE_NEW_USER"
  And hit api post create new user without email
  Then validation status code is equals to 400


  @api
  Scenario: Test delete new user (TC-07)
    Given prepare url for "GET_POST_CREATE_NEW_USER"
    And hit api get post create new user
    Then validation status code is equals to 200
    And validation response body user
    Then validation response json with JSONSchema "post_create_new_user.json"
    And hit api delete user
    Then validation status code is equals to 200