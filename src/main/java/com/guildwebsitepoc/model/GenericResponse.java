package com.guildwebsitepoc.model;

public class GenericResponse {

    private int status;
    private String message;
    private long timeStamp;

    public GenericResponse() {}

    public GenericResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public long getTimeStamp() { return timeStamp; }

    public void setTimeStamp(long timeStamp) { this.timeStamp = timeStamp; }
}
