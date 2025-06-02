package com.erik.DavaiLang.controller.dto;

public class ParseResponse {
    private String javaCode;
    private String errorMessage;

    public ParseResponse() {
    }

    public ParseResponse(String javaCode, String errorMessage) {
        this.javaCode = javaCode;
        this.errorMessage = errorMessage;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setJavaCode(String javaCode) {
        this.javaCode = javaCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
