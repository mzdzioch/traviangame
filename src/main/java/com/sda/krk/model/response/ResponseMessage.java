package com.sda.krk.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseMessage<T> {
    private StatusResponse statusResponse;
    private String message;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T body;

    public ResponseMessage(StatusResponse statusResponse, String message, T body) {
        this.statusResponse = statusResponse;
        this.message = message;
        this.body = body;
    }

    public ResponseMessage() {
    }

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
