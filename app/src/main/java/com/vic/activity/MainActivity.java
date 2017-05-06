package com.vic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vic.base.core.ActionCallbackListener;
import com.vic.base.entity.QuestionItem;
import com.vic.base.http.HttpBase;
import com.vic.base.util.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put("subject","1");
        paramsMap.put("model","c1");
        paramsMap.put("key", HttpBase.APP_KEY);
        paramsMap.put("testType","rand");

        mAppAction.getQuestionList(paramsMap,new ActionCallbackListener<List<QuestionItem>>() {

            @Override
            public void onSuccess(List<QuestionItem> data) {
                Logger.mlj("data=" + data);
            }

            @Override
            public void onFailure(String errorCode, String errorMsg) {
                Logger.mlj("errorCode=" + errorCode + ",errorMsg=" + errorMsg);
            }

        });
    }
}
