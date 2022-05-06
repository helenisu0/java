package com.africa.semicolon.shortner.dtos.responses;

public class UrlResponse {
    private String initialUrl;
    private String shortUrl;

    @Override
    public String toString() {
        return "UrlResponse{" +
                "initialUrl='" + initialUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }

    public String getInitialUrl() {
        return initialUrl;
    }

    public void setInitialUrl(String initialUrl) {
        this.initialUrl = initialUrl;
    }



    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
