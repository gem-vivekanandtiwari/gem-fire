Feature: Final Templete

  Scenario: Example BaseURl
#    Given baseUrl https://gorest.co.in/public/v2/users
##    Given path /public/v2/users
    Given url https://gorest.co.in/public/v2/users
    Given params id = 4033
    Given params id = 2667
    Given headers token = abcd
    Given method get
    Given Print #(response)
    Given Assert : verifying name : vivek EQUALS vivek
    Given Assert : verify status : #(status) EQUALS 200
    Given Assert : verify reponse id : #(response[0].id) EQUALS 2667
    Given Assert : verify reponse email : #(response[0].email) EQUALS gill_hon_the_gautama@oreilly-wintheiser.com


Scenario: test Post Request
  Given url https://gorest.co.in/public/v2/users
  Given headers Authorization = Bearer 7641a7fc2462fcfb9892e650aea09008025bbfdc424b9c8a5eabbab24161d63f
  Given headers Accept = application/json
  Given requestBody {"name": "PawanDeep","gender": "male","email": "pawan#epoch#@gmail.com","status":"active"}
  Given method post
  Given Print #(response)
  Given Print #(status)
  Given Print #(responseMessage)
  Given Print #(errorMessage)
  Given Assert : verify name : #(response.name) EQUALS PawanDeep


  Scenario: Request DocString
    Given Set baseURL = https://gorest.co.in
    Given Request : Demo RequestDocString :
      """
      {
      "baseUrl" : "#(baseURL)",
      "path" : "/public/v2/users",
      "method" : "get"
      }
      """
    Given Set var1 = fn(EPOCH)
    Given Print #(var1)
    Given Print #(response[0].id)
    Given Print #(response)
    Given Print #(environment)
    Given Print var2#(var1)
    Given Assert : DO ASSERTION : #(response[0].id) EQUALS #(response[1].id)
    Given Request : Demo RequestDocString with param :
      """
      {
      "baseUrl" : "#(baseURL)",
      "path" : "/public/v2/users",
      "method" : "get",
      "params" :{
        "id" : "#(response[0].id)"
        }
      }
      """
    Given Print #(response)

  Scenario: Request DocString post
    Given Set baseURL = https://gorest.co.in
    Given Request : Demo RequestDocString :
      """
      {
      "url" : "https://gorest.co.in/public/v2/users",
      "headers" : {"Authorization" : "Bearer 7641a7fc2462fcfb9892e650aea09008025bbfdc424b9c8a5eabbab24161d63f" },
      "method" : "post",
      "requestBody" : {"name": "PawanDeep","gender": "male","email": "pawan#epoch#@gmail.com","status":"active"}
      }
      """
    Given Set var1 = fn(EPOCH)
#    Given Print #(var1)
#    Given Print #(response[0].id)
    Given Print #(response)
#    Given Print #(environment)
#    Given Print var2#(var1)
#    Given Assert : DO ASSERTION : #(response[0].id) EQUALS #(response[1].id)
#    Given Request : Demo RequestDocString with param :
#      """
#      {
#      "baseUrl" : "#(baseURL)",
#      "path" : "/public/v2/users",
#      "method" : "get",
#      "params" :{
#        "id" : "#(response[0].id)"
#        }
#      }
#      """
#    Given Print #(response)

#  Scenario: Request DocString2
#    Given Request : Demo RequestDocString :
#      """
#      {
#      "baseUrl" : "#(baseURL)",
#      "path" : "/public/v2/users",
#      "method" : "get"
#      }
#      """
#    Given Set var1 = fn(EPOCH)
#    Given Print #(var1)
#    Given Print #(response[0].id)
#    Given Print #(response)
#    Given Print #(environment)
#    Given Print var2#(var1)
#    Given Assert : verifying name : vivek EQUALS vivek
#

    Given baseUrl https://gorest.co.in
    Given path /public/v2/users
    Given params id = 4033
    Given params id = 4034
    Given headers token = abcd
    Given method get



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


