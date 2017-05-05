package com.vic.base.util;

import android.widget.Toast;

import com.vic.base.profile.Profile;


/**
 * Created by Administrator on 2017/2/22.
 */

public class ToastUtil {
    private static Toast sToast = null;

    public static void showMsg(String msg, int during){
        if(sToast != null){
            sToast.setText(msg);
            sToast.setDuration(during);
            sToast.show();
        }else{
            sToast = Toast.makeText(Profile.sContext,msg,during);
            sToast.show();
        }
    }
}
