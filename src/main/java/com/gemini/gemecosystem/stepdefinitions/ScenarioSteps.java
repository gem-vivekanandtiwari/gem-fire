package com.gemini.gemecosystem.stepdefinitions;

import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ApiHealthCheckUtils;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.google.gson.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScenarioSteps {

    Request request = new Request();

    @Given("^baseUrl\\h(.+)")
    public void setBaseUrl(String baseUrl){
        request.setBaseUrl(baseUrl);
    }

    @Given("^path\\h(.+)")
    public void setPath(String path) {
         request.setpath(path);
    }

    @Given("^print\\h(.+)")
    public void printAnything(Object object){
        System.out.println(object);
    }


    @Given("^params\\h([\\w]+)\\h=\\h(.+)$")
    public void setParameters(String key, String value){
        request.setParameter(key,value);
    }
    @Given("^method\\h(get)")
    public void setMethodType(String methodType){
        request.setMethod(methodType);
    }
    @Given("^Assert\\h:\\h(.+)\\h:$")
    public void assertUsingDocString(String assertStatement ,String object) {
        System.out.println(assertStatement);
        System.out.println(object);
    }

    @Given("^Assert\\h:\\h(.+)\\h:\\h(.+)")
    public void inlineAssertion(String assertStep, String inlineAssertStatement) {
        System.out.println(assertStep);
        System.out.println(inlineAssertStatement);
    }


    @Given("^Request\\h:\\h(.+)\\h:$")
    public void requestDocStringDataTable( String step ,Object obj) {
        request.createRequest(obj);
    }

    @Given("^Request\\h:\\h(.+)\\h:\\hreadfile\\((.+)\\)$")
    public void requestReadDataFromFile(String step,String filepath) {
        System.out.println(step);
        System.out.println(filepath);
    }
    @Given("^Request\\h:\\h(.+)\\h:\\h(\\{+.+\\})$")
    public void requestReadDataInline(String step,String requiredData ) {
        System.out.println(step);
        System.out.println(requiredData);
    }

    @Given("^set\\h(.+)\\h=\\h(.+)")
    public void setKeyValueInline(String key , String value) {
        System.out.println(key);
        System.out.println(value);
    }

    @Given("^set\\h(.+)\\h=$")
    public void setKeyValueFromObject(String key , Object object){
        System.out.println(key);
        System.out.println(object);
    }

    //akash

    public JsonElement recentResponse = new JsonObject();
    @Given("^Request\\h:\\h([^\"]*)\\h:$")
    public void request(String testcaseName, Object str) {
        try {
            String className = String.valueOf((str.getClass()));
            if (className.equals("class io.cucumber.docstring.DocString")) {
                GemTestReporter.addTestStep("Create Request", testcaseName, STATUS.INFO);
                str = str.toString().replace("null", "");
                str = str.toString().replace("\"\"\"", "");
                JsonParser parser = new JsonParser();
                JsonObject json = (JsonObject) parser.parse(str.toString());
                json.addProperty("test_name", "");
                JsonArray jsonArray = new JsonArray();
                jsonArray.add(json);
                recentResponse = ApiClientConnect.healthCheckJsonWithoutNewTC(jsonArray).get(0).getAsJsonObject().get("responseBody");

            } else {
                DataTable dataTable = null;
                dataTable = (DataTable) str;
                List<Map<String, String>> mapList = dataTable.asMaps(String.class, String.class);
                GemTestReporter.addTestStep("Create Request", testcaseName, STATUS.INFO);
                JsonArray array = new JsonArray();
                GsonBuilder gsonMapBuilder = new GsonBuilder();
                Gson gsonObject = gsonMapBuilder.create();
                String JSONObject = gsonObject.toJson(mapList.get(0));
                JsonParser parser = new JsonParser();
                JsonObject json = (JsonObject) parser.parse(JSONObject);
                json.addProperty("test_name", "");
                array.add(json);
                recentResponse = ApiClientConnect.healthCheckJsonWithoutNewTC(array).get(0).getAsJsonObject().get("responseBody");
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Some error occurred", "Some error occurred", STATUS.FAIL);
        }
    }

    @Given("^Request\\h:\\h(.+)\\h:\\hreadfile\\((.+)\\)$")
    public void requestReadDataFromFilepath(String step, String filepath) {
        GemTestReporter.addTestStep("Create Request", step, STATUS.INFO);
        try {
            File file = new File(filepath);
            String payload = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            JsonObject req = JsonParser.parseString(payload).getAsJsonObject();
            req.addProperty("test_name", "");
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(req);
            recentResponse = ApiClientConnect.healthCheckJsonWithoutNewTC(jsonArray).get(0).getAsJsonObject().get("responseBody");
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Some error occurred", "Some error occurred", STATUS.FAIL);
        }
    }

    @Given("^Request\\h:\\h(.+)\\h:\\h\\{(.+)\\}$")
    public void request(String step, String str) {
        GemTestReporter.addTestStep("Create Request", step, STATUS.INFO);
        str = "{" + str + "}";
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(str);
        json.addProperty("test_name", "");
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(json);
        recentResponse = ApiClientConnect.healthCheckJsonWithoutNewTC(jsonArray).get(0).getAsJsonObject().get("responseBody");

    }

    @And("^Assert\\h:\\h(.+)\\h:")
    public void Assert(String assertStatement, String str) {
        GemTestReporter.addTestStep("Assert Statement", assertStatement, STATUS.INFO);
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(str);
        Assert.assertion(recentResponse,json);
    }

    @And("^Assert\\h:\\h(.+)\\h:\\hreadfile\\((.+)\\)$")
    public void AssertFile(String assertStatement, String filePath) {
        GemTestReporter.addTestStep("Assert Statement", assertStatement, STATUS.INFO);
        try {
            File file = new File(filePath);
            String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            JsonParser parser = new JsonParser();
            JsonObject json = (JsonObject) parser.parse(content);
            Assert.assertion(recentResponse,json);

        } catch (IOException e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Some error occurred", "Some error occurred", STATUS.FAIL);

        }
    }






}
