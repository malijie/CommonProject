package com.vic.base.api;

/**
 * Created by malijie on 2017/4/20.
 */

public class ApiResponse<T> {
    private String error_code;
    private String reason;
    private T result;
    private T resultList;

    public ApiResponse(String errorCode,String errorMsg){
        this.error_code = errorCode;
        this.reason = errorMsg;
    }

    public boolean isSuccess(){
        return  error_code.equals("0");
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResultList() {
        return resultList;
    }

    public void setResultList(T resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", resultList=" + resultList +
                '}';
    }
}
