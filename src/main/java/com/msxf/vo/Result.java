package com.example.vo;

import lombok.Data;

@Data
public class Result {

    private boolean success;
    private String message;
    private Object data;

    public static Result success(Object data){
        Result result = new Result();
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static Result fail(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }


}
