package com.africa.semicolon.shortner.data.models;


import org.springframework.data.annotation.Id;

public class Url {
    @Id
    private String id;

    @Override
    public String toString() {
        return "Url{" +
                "id='" + id + '\'' +
                ", initialUrl='" + initialUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }

    private String initialUrl;
    private String shortUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
