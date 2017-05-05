package com.vic.base.api;

import com.vic.base.entity.QuestionItem;

import java.util.List;

/**
 * Created by malijie on 2017/4/19.
 */

public interface Api {
    ApiResponse<List<QuestionItem>> getQuestionList(String testType);
}
