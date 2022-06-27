package com.gemini.gemecosystem.stepdefinitions;

import io.cucumber.java.en.Given;

public class AssertionStep {


    @Given("^Assert\\h:\\h(.+)\\h:$")
    public void assertUsingDocString(String assertStatement ,String object) {
        System.out.println(assertStatement);
        System.out.println(object);
    }
    @Given("^Assert\\h:\\h(.+)\\h:\\hreadFile\\((.+)\\)$")
    public void assertManyusingFile(String assertStatement, String filePath) {
        System.out.println(assertStatement);
        System.out.println(filePath);
    }
    @Given("^Assert\\h:\\h(.+)\\h:\\h(.+)")
    public void inlineAssertion(String assertStep, String inlineAssertStatement) {
        System.out.println(assertStep);
        System.out.println(inlineAssertStatement);
    }

}
