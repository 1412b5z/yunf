package com.riven.dell.yunifangdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.riven.dell.yunifangdemo.R;

/**
 * Created by Administrator on 2016/12/7 0007.
 */

/**
 * 3秒计时跳转页
 */
public class Guide2Activity extends Activity {
    //声明控件
    private TextView mTime_tv;
   // private SharedPreferences sp;
    //声明Handler用于跳转
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //定义计时变量
            int time = msg.what;
            if (time>0) {
                time--;
                mTime_tv.setText("跳过" + time + "秒");
                handler.sendEmptyMessageDelayed(time,1000);
                //设置TextView监听
                mTime_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Guide2Activity.this, Guide3Activity.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                });
                //设置跳转
                if (time == 0) {
                    Intent intent = new Intent(Guide2Activity.this, Guide3Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide2_layout);
        //初始化控件
        mTime_tv = (TextView) findViewById(R.id.time_tv);
                handler.sendEmptyMessageDelayed(5,0);
       // getSharedPreferences().edit().putBoolean("flag",true).commit();
        }
    }

