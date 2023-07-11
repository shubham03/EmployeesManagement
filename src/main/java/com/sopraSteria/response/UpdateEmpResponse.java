package com.sopraSteria.response;

public class UpdateEmpResponse {
    private String statusCode;
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public UpdateEmpResponse() {
    }
    public UpdateEmpResponse(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }


}
