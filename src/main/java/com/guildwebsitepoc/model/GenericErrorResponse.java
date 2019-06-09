package com.guildwebsitepoc.model;

public class GenericErrorResponse {
    private int status;
    private String code;
    private String message;
    private long timeStamp;

    public GenericErrorResponse() {}

    public GenericErrorResponse(int status, String code, String message, long timeStamp) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public long getTimeStamp() { return timeStamp; }

    public void setTimeStamp(long timeStamp) { this.timeStamp = timeStamp; }
}
