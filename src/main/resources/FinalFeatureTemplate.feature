Feature: Final Templete

  Scenario: Example BaseURl
    Given baseUrl https://gorest.co.in
    Given path /public/v2/users
    Given params id = 4033
    Given params id = 4034
    Given headers token = abcd
    Given method get
    Given print #response#


  Scenario: Request DocString
    Given Request : Demo RequestDocString :
      """
      {
      "baseUrl" : "https://gorest.co.in",
      "path" : "/public/v2/users",
      "params" : "4034",
      "method" : "get"
      }
      """
    Given print #response#


    Scenario: Set Test
      Given set URL = https://gorest.co.in
      Given print #name.# sunaja2