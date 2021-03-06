package com.vic.base.api;

import com.google.gson.reflect.TypeToken;
import com.vic.base.entity.QuestionItem;
import com.vic.base.http.HttpEngine;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by malijie on 2017/4/19.
 */

public class ApiImpl implements Api {
    private final static String TIME_OUT_EVENT = "CONNECT_TIME_OUT";
    private final static String TIME_OUT_EVENT_MSG = "连接服务器失败";

    @Override
    public ApiResponse<List<QuestionItem>> getQuestionList(Map<String,String> paramsMap) {

        Type type = new TypeToken<ApiResponse<List<QuestionItem>>>(){}.getType();
        try {
            return new HttpEngine().postHandle(paramsMap,type);
        } catch (IOException e) {
           return new ApiResponse(TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
        }
    }

}
