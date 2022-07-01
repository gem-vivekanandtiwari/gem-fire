Feature: Example

  Scenario: Create user and get all by DocString
    Given Request : Create User :
    """
    {
    "method": "POST",
    "endpoint": "https://gorest.co.in/public/v2/users",
    "expected_status": 201,
    "request_body": {
      "name": "Raghav",
      "email": "User_#curr-ddMMyyyyhhmmss#@org.com",
      "gender": "Male",
      "status": "active"
    },
    "headers": {
      "Authorization": "Bearer e44ac095d53abb1da69ff4cdc9c0bc24ea741dbc7cbe6f2ba2dfdbec9cb1ecd4"
    }
    }
    """
    And Assert : sample assertion  :
    """
    {
    "response(name)":"to Raghav",
    "deepsearch(gender)":"in [male,f]"
    }
    """

    And Request : Get all user :
     """
    {
    "method": "Get",
    "endpoint": "https://gorest.co.in/public/v2/users",
    "expected_status": 200
    }
    """

  Scenario: Get All user using pipe
    Given Request : Get All user using pipe :
      | endpoint                             | method | expected_status |
      | https://gorest.co.in/public/v2/users | GET    | 200             |

  Scenario: get all user using readFile Function
    Given Request : Get User using readFile : readfile(src/main/resources/CreateUser.json)

  Scenario: get all user by json in same line
    Given Request : get user  : {"method": "Get",  "endpoint": "https://gorest.co.in/public/v2/users","expected_status": 200}

  Scenario: Create user and get all by DocString
    Given Request : Create User :
    """
    {
    "method": "POST",
    "endpoint": "https://gorest.co.in/public/v2/users",
    "expected_status": 201,
    "request_body": {
      "name": "AKASH",
      "email": "User_#curr-ddMMyyyyhhmmss#@org.com",
      "gender": "Male",
      "status": "active"
    },
    "headers": {
      "Authorization": "Bearer e44ac095d53abb1da69ff4cdc9c0bc24ea741dbc7cbe6f2ba2dfdbec9cb1ecd4"
    }
    }
    """
    And Assert : sample assertion  :
    """
    {
    "response(name)":"to AKASH",
    "deepsearch(name)":"contains ASH"
    }
    """
    And Assert : Assertion By  : readfile(src/main/resources/assertion.json)
