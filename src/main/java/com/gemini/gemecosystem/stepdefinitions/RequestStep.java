package com.gemini.gemecosystem.stepdefinitions;

import io.cucumber.java.en.Given;

public class RequestStep {

    @Given("^Request\\h:\\h(.+)\\h:$")
    public void requestDocStringDataTable( String step ,Object dataTable) {
        System.out.println(step);
        System.out.println(dataTable);
        System.out.println(dataTable.getClass().getName());
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


}
