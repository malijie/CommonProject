package com.vic.base.core;

import android.os.AsyncTask;

import com.vic.base.api.Api;
import com.vic.base.api.ApiResponse;

import java.util.Map;

/**
 * Created by malijie on 2017/5/7.
 */

public class HttpRequestAsyncTask<T> extends AsyncTask<Void,Void,ApiResponse<T>>{
    private final Map<String, String> mParamsMap;
    private Api mApi = null;
    private ActionCallbackListener<T> mCallback = null;

    public HttpRequestAsyncTask(Api api,Map<String,String> paramsMap,ActionCallbackListener<T> callback){
        this.mApi = api;
        this.mParamsMap = paramsMap;
        this.mCallback = callback;
    }

    @Override
    protected ApiResponse<T> doInBackground(Void... params) {
        return (ApiResponse<T>) mApi.getQuestionList(mParamsMap);
    }

    @Override
    protected void onPostExecute(ApiResponse<T> apiResponse) {
        super.onPostExecute(apiResponse);
        if(mCallback != null){
            if(apiResponse.isSuccess()){
                mCallback.onSuccess(apiResponse.getResult());
            }else{
                mCallback.onFailure(apiResponse.getError_code(),apiResponse.getReason());
            }
        }

    }
}
