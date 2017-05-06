package com.vic.base.api;

import com.vic.base.entity.QuestionItem;

import java.util.List;
import java.util.Map;

/**
 * Created by malijie on 2017/4/19.
 */

public interface Api {
    ApiResponse<List<QuestionItem>> getQuestionList(Map<String,String> paramsMap);
}
