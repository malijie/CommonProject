package com.vic.base.core;

/**
 * Created by malijie on 2017/4/20.
 */

public interface ActionCallbackListener<T> {
     void onSuccess(T data);
     void onFailure(String errorCode, String errorMsg);
}
