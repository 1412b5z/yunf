package com.riven.dell.yunifangdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.riven.dell.yunifangdemo.R;

/**
 * ccz
 * Created by Administrator on 2016/12/7 0007.
 */

/**
 * 引导页展示
 */

public class GuideActivity extends Activity {
    //定义Handler计时跳转
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                Intent intent = new Intent(GuideActivity.this,Guide2Activity.class);
                startActivity(intent);
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);
        handler.sendEmptyMessageDelayed(0,3000);
    }
}
