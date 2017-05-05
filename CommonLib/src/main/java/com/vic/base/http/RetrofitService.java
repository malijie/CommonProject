package com.vic.base.http;



import com.vic.base.entity.HttpResultBean;
import com.vic.base.entity.QuestionItem;

import java.util.List;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/22.
 */

public interface RetrofitService {
    @POST("jztk/query")
    Observable<HttpResultBean<List<QuestionItem>>> getQuestions(@Query("subject") int subject, @Query("model") String model, @Query("key") String appKey, @Query("testType") String type);


}
