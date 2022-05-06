package com.africa.semicolon.shortner.dtos.responses;

public class UrlErrorResponse {
    private String status;
    private String errorMessage;

    @Override
    public String toString() {
        return "UrlErrorResponse{" +
                "status='" + status + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
