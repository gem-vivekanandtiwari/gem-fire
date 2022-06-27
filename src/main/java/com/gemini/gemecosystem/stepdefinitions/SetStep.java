package com.gemini.gemecosystem.stepdefinitions;

import io.cucumber.java.en.Given;

public class SetStep {


    @Given("^set (.+) = (.+)")
    public void setKeyValueInline(String key , String value) {
        System.out.println(key);
        System.out.println(value);
    }
    @Given("^set (.+) = readFile\\((.+)\\)$")
    public void setKeyValueFromTextFile(String key , String filePath) {
        System.out.println(key);
        System.out.println(filePath);
    }
    @Given("^set (.+) = readJsonFile\\((.+)\\)$")
    public void setKeyValueFromJsonFile(String key, String jsonFilePath) {
        System.out.println(key);
        System.out.println(jsonFilePath);
    }
    @Given("^set (.+) = {(.+)}$")
    public void setInLineJsonValue(String key, String valueString) {
        System.out.println(key);
        System.out.println(valueString);
    }
}
