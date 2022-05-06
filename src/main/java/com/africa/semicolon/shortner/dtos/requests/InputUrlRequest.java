package com.africa.semicolon.shortner.dtos.requests;

public class InputUrlRequest {
    @Override
    public String toString() {
        return "InputUrlRequest{" +
                "initialUrl='" + initialUrl + '\'' +
                '}';
    }

    private String initialUrl;

    public String getInitialUrl() {
        return initialUrl;
    }

    public void setInitialUrl(String initialUrl) {
        this.initialUrl = initialUrl;
    }
}
