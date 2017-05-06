package com.vic.base.core;

import java.util.Map;

/**
 * Created by malijie on 2017/4/19.
 */

public interface AppAction<T> {
    void getQuestionList(Map<String,String> paramsMap, ActionCallbackListener<T> callback);
}
