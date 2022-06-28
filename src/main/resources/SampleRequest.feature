Feature: Sample Request

  Scenario: Sample Request Demo
    Given baseUrl https://google.com
    Given params name = vivek
    Given method get
    Given print anyThing
    Given Request : Create a user1 :
    """
    {
    "url" : "vivek",
    "method" : "Get"
    "headers" : {
    "content" : "application/json",
    "accept" : "*.*"
    "token" : "bearer token"},
    "params" :{
    "id" : "12345",
    "add" : "Noida"}
    "requestBody" : {
    }
    }
    """