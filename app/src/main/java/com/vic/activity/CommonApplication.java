package com.vic.activity;

import android.app.Application;

import com.vic.base.profile.Profile;

/**
 * Created by malijie on 2017/5/5.
 */

public class CommonApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Profile.init(getApplicationContext());
    }
}
