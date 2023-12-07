package com.miaxis.demo.util;

public class DataState<T> {
    private final Status status;
    private final T data;
    private final String errorMessage;

    public DataState(Status status, T data, String errorMessage) {
        this.status = status;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public Status getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public enum Status {
        LOADING,
        SUCCESS,
        ERROR
    }
}