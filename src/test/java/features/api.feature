Feature: Test Automation API https://dummyapi.io/

  @api
  Scenario: Test get list data normal
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equals to 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"