package com.vic.base.core;

/**
 * Created by malijie on 2017/4/19.
 */

public interface AppAction<T> {
    void getQuestionList(String testTpe, ActionCallbackListener<T> callback);
}
