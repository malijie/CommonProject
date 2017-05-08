package com.vic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.vic.base.core.ActionCallbackListener;
import com.vic.base.entity.QuestionItem;
import com.vic.base.http.HttpBase;
import com.vic.base.util.Logger;
import com.vic.base.util.ToastManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cameraclient.activity.R;


public class MainActivity extends BaseActivity {
    private Button mButton = null;
    private Button mButtonShare = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.id_button);
        mButtonShare = (Button) findViewById(R.id.id_button_share);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDeviceList();
            }
        });
        mButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(MainActivity.this).withText("hello")
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
            }
        });

    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Logger.mlj("platform"+platform);

            ToastManager.showLongMsg(platform + " 分享成功啦");

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            ToastManager.showLongMsg(platform + " 分享失败啦");
            if(t!=null){
                Logger.mlj("throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            ToastManager.showLongMsg(platform + " 分享取消了");
        }
    };

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
