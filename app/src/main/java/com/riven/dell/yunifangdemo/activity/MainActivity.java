package com.riven.dell.yunifangdemo.activity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.application.MyApplication;
import com.riven.dell.yunifangdemo.interfaces.RequestCallBack;
import com.riven.dell.yunifangdemo.utils.Api;
import com.riven.dell.yunifangdemo.view.MainViewPager;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    private MainViewPager viewPager;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getRequestData();
        radioGroup.setOnCheckedChangeListener(this);


    }

    private void initViews() {
        viewPager = (MainViewPager) findViewById(R.id.main_viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
    }

    private void getRequestData() {
        httpUtils.getRequest(Api.homeUrl, new RequestCallBack() {
            @Override
            public void onSuccess(String response) {
                String content = response.substring(0,20);
                Toast.makeText(MyApplication.getContext(),content,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(MyApplication.getContext(),error,Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
