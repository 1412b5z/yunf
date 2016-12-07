package com.riven.dell.yunifangdemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.riven.dell.yunifangdemo.utils.HttpUtils;

/**
 * @author rivenlee
 * @date 2016/12/6 18:34
 */

public class BaseActivity extends FragmentActivity {

    protected HttpUtils httpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpUtils = HttpUtils.getHttpUtils();
    }
}
