package com.ricky.fileexplorerapi.model;

public class ErrorResponse {

    private String message;
    private String path;
    private String details;

    public ErrorResponse(String message, String path, String details) {
        this.message = message;
        this.path = path;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public String getDetails() {
        return details;
    }

}
