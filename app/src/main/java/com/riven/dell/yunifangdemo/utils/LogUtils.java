package com.riven.dell.yunifangdemo.utils;

import android.util.Log;

/**
 * @author rivenlee
 * @date 2016/12/6 15:56
 */

public class LogUtils {
    public static final  boolean isDebug = true;

    public static void i(String TAG,String info){
        if(isDebug){
            Log.i(TAG,info);
        }
    }
    public static void d(String TAG,String info){
        if(isDebug){
            Log.d(TAG,info);
        }
    }
    public static void e(String TAG,String info){
        if(isDebug){
            Log.e(TAG,info);
        }
    }
}
