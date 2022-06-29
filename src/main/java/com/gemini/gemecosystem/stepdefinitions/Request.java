package com.gemini.gemecosystem.stepdefinitions;




import io.cucumber.datatable.DataTable;
import io.cucumber.docstring.DocString;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Request {


    private  String BASE_URL ;
    private  String PATH;
    private String URL;
    private String METHOD;
    private URL url;
    private  Map<String, String> PARAMS = new HashMap<String,String>();

    public Request(){

    }

    public  String getBaseUrl() {
        return this.BASE_URL;
    }

    public  void setBaseUrl(String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    public  String getPATH() {
        return this.PATH;
    }

    public  void setpath(String path) {
        this.PATH = PATH;
    }

    public void buildUrl(){
        try {
            URIBuilder builder = new URIBuilder(this.BASE_URL);
            builder.setPath(this.PATH);

            for (String paramKey:PARAMS.keySet()) {
                builder.setParameter(paramKey,PARAMS.get(paramKey));
            }
            this.url = builder.build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public void buildUrl(String url){
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setParameter(String key, String value) {
        PARAMS.put(key,value);
    }

    public void setMethod(String methodType) {
        this.METHOD = methodType.toLowerCase();
    }

    public void createRequest(Object obj) {
        String dataType = obj.getClass().getSimpleName().toLowerCase();
        switch (dataType){
            case "DataTable" :
                createRequestFromDataTable((DataTable)obj);
                break;

            case "DocString" :
                createRequestFromDocString((DocString)obj);
                break;
        }
    }

    private void createRequestFromDocString(DocString obj) {
    }

    private void createRequestFromDataTable(DataTable obj) {
    }
}
