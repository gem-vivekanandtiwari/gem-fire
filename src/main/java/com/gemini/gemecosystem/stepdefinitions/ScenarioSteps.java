package com.gemini.gemecosystem.stepdefinitions;

import io.cucumber.java.en.Given;

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




}
