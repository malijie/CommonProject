package com.vic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vic.base.core.AppAction;
import com.vic.base.core.AppActionImpl;


/**
 * Created by malijie on 2017/4/20.
 */

public class BaseActivity extends AppCompatActivity{
    protected AppAction mAppAction = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppAction = new AppActionImpl();
    }
}
