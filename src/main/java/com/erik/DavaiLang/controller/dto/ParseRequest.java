package com.erik.DavaiLang.controller.dto;

public class ParseRequest {
    private String code;

    public ParseRequest() {
    }

    public ParseRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
