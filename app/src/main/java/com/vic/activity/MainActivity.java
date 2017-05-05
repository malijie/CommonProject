package com.vic.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.vic.base.core.ActionCallbackListener;
import com.vic.base.entity.QuestionItem;
import com.vic.base.http.RetrofitHttpRequest;
import com.vic.base.http.SubscriberOnNextListener;
import com.vic.base.util.Logger;

import java.util.List;

import cameraclient.activity.R;


public class MainActivity extends BaseActivity {
    private Button mButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.id_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDeviceList();
            }
        });


    }

    private void getDeviceList(){
        String appType = "rand";
        mAppAction.getQuestionList(appType,new ActionCallbackListener<List<QuestionItem>>() {

            @Override
            public void onSuccess(List<QuestionItem> data) {
                Logger.mlj("data=" + data);
            }

            @Override
            public void onFailure(String errorCode, String errorMsg) {
                Logger.mlj("errorCode=" + errorCode + ",errorMsg" + errorMsg);
            }

        });

//        RetrofitHttpRequest.getInstance().getC1Subject1OrderQuestions(new SubscriberOnNextListener<List<QuestionItem>>(){
//            @Override
//            public void onNext(List<QuestionItem> questionItems) {
//                super.onNext(questionItems);
//
//Logger.mlj("questionItems===" + questionItems);
//
//            }
//        });
    }
}
