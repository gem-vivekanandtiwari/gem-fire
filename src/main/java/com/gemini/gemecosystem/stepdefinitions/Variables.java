package com.gemini.gemecosystem.stepdefinitions;

import java.util.Map;

public class Variables extends ScenarioSteps{


    // map object

    // config FileReading
    // Config.$environment.baseURl
    // confing.beta.baseURL
    private Map<String, String> variableMap;

    public Map<String, String> Variables() {
        return ScenarioSteps.globalVariable ;
    }

    public static String getResultantJson(String requestBody, Map<String, String> globalVariable) {
        String requestBodyString = requestBody.toString();
        char search = '#';             // Character to search is '#'.
        int HashCount = 0;
        for (int i = 0; i < requestBodyString.length(); i++) {
            if (requestBodyString.charAt(i) == search)
                HashCount++;
        }
        int number = HashCount / 2;
        for (int k = 0; k < number; k++) {
            String tempString = getResultantString(requestBodyString, globalVariable);
            requestBodyString = tempString;
        }
        return requestBodyString;
    }

    public static String getResultantString(String requestBodyString, Map<String, String> globalVariable) {
        int first = requestBodyString.indexOf("#");
        int second = requestBodyString.indexOf("#", first + 1);
        String start = requestBodyString.substring(0, first);
        String end = requestBodyString.substring(second + 1);
        String buffer = requestBodyString.substring(first + 1, second);
        if (globalVariable.containsKey(buffer)) {
            String t = globalVariable.get(buffer);
            return start + t + end;
        }
        return requestBodyString;
    }


}
