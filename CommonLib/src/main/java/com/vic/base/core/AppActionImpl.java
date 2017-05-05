package com.vic.base.core;


import android.os.AsyncTask;

import com.vic.base.api.Api;
import com.vic.base.api.ApiImpl;
import com.vic.base.api.ApiResponse;
import com.vic.base.entity.QuestionItem;
import com.vic.base.util.Logger;

import java.util.List;

/**
 * Created by malijie on 2017/4/19.
 */

public class AppActionImpl implements AppAction {

    private Api api = null;

    public AppActionImpl(){
        api = new ApiImpl();
    }


    @Override
    public void getQuestionList(final String appType, final ActionCallbackListener callback) {
        
        new AsyncTask<Void,Void,ApiResponse<List<QuestionItem>>>(){
            @Override
            protected ApiResponse<List<QuestionItem>> doInBackground(Void... params) {
                return api.getQuestionList(appType);
            }

            @Override
            protected void onPostExecute(ApiResponse<List<QuestionItem>> listApiResponse) {
                if(callback != null){
                    if(listApiResponse.isSuccess()){
                        callback.onSuccess(listApiResponse.getResult());
                    }else{
                        callback.onFailure(listApiResponse.getError_code(),listApiResponse.getReason());
                    }
                }
            }
        }.execute();
    }
}
