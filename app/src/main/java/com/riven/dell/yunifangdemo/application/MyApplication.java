package com.riven.dell.yunifangdemo.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * @author rivenlee
 * @date 2016/12/6 15:51
 */

public class MyApplication extends Application{
    private static Context context;
    private static Handler handler;
    private static int mainThreadId;
    @Override
    public void onCreate() {
        super.onCreate();
        //获取应用的上下文
        context = getApplicationContext();
        //handler线程
        handler = new Handler();
        //获取主线程的线程号
        mainThreadId = Process.myTid();
    }
    /**
     * 获取上下文
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取Handler对象
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 获取主线程号
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }

    /**
     * 获取主线程
     */
    public static Thread getMainThread() {
        return Thread.currentThread();
    }
}
