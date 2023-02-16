package com.lazarspa.customer.dto;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class OperationResult <T>{

    private Boolean success;
    private final T responseObject;
    private List<String> messages;
    private final String errorCode;



    public OperationResult<T> success(T responseObject){
        return new OperationResult<>(true,responseObject);
    }

    public OperationResult<T> failure(){
        return new OperationResult<>(false);
    }

    public OperationResult<T> failure(String message){
        return new OperationResult<>(false,null, Arrays.asList(message));
    }

    public OperationResult<T> failureCode(String errorCode){
        return new OperationResult<>(false,null,new ArrayList<>(),errorCode);
    }

    public OperationResult<T> failureCode(String errorCode,String message){
        return new OperationResult<>(false,null,Arrays.asList(message),errorCode);
    }

    public OperationResult(Boolean success){
        this(success,null);
    }
    public OperationResult(Boolean success, T responseObject) {
        this(success,responseObject,new ArrayList<>());
    }

    public OperationResult(Boolean success, T responseObject, List<String> messages) {
        this(success,responseObject,messages,null);
    }

    public OperationResult(Boolean success, T responseObject, List<String> messages, String errorCode) {
        this.success = success;
        this.responseObject = responseObject;
        this.messages = messages;
        this.errorCode = errorCode;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public boolean success() {
        return Boolean.TRUE.equals(this.getSuccess());
    }


    public List<String> getMessages() {
        return this.messages;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
