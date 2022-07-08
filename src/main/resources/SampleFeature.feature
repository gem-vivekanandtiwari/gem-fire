Feature: Sample feature

  Scenario: Sample Scenario
    Given Request : Create a user :
    """ {
    "url": config.env.baseUrl,
    "path" : "/account/vivek"
     "method" : "get/post/put/delete/",
     "headers" : ""/ readFile(filePath),
     "requestBody" : {}/ readFile(filePath),
     "status" : "expectedStatus"
     }
    """

    Given params : name = vivek
    Given Request : Step description :
      | url           | method      | headers                                                     | requestBody | status |
      | endPointValue | methodValue | requestBody/ readFile(filepath)/ readJsonFile(filePath).key | status      |        |

    Given Request : Step description :
      |url : urlValue| method : methodValue | requestBody  : "{}"/ readFile()/readJsonFile(filePath) | status : expectedStatus| headers : ""|

    Given Request : stepDescription : readfile(filePath)
    Given Request : stepDescription  : { url = urlendPoint , method = methodName }

    Given Assert : Assert Statement :
    """
    { "response.key" : "Assert value"}
    """
    Given Assert : Assert Statement : readFile(filePath)
    Given Assert : Assert Statement : response.key  equals(Assert value)


    Given set name  = Akash
    Given set name  = Vivek

    Given Request : Search Name in the list :
    """
    {"url" : "*?userID=USERid}
    """
    Given set a = readFile(filePath)
    Given set key =
    """
    {"name" : "vivek" }
    """
    Given set key = " hello world"
    Given set name  = Akash


    Scenario: ScenarioName
      Given gemjarKeyWord(Action to be taken) : User Statement  : InputData
      # gemjar keyword (mandatory) : optional :

      Given Set : : name = vivek
      Given Assert : verifying name
