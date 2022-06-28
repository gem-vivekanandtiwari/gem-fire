Feature: Sample feature

  Scenario: Sample Scenario
    Given Request : Step description :
    """ {
    "url": declaredKey,
     "method" : "get/post/put/delete/",
     "headers" : ""/ readFile(filePath),
     "requestBody" : {}/ readFile(filePath),
     "status" : "expectedStatus"
     }
    """
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


    Given set key = value
    Given set key = readFile(filePath)
    Given set key = readJsonFile(filePath)
    Given set key =
    """
    {name = vivek }

    """