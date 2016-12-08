package com.riven.dell.yunifangdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.adapter.MainViewPagerAdapter;
import com.riven.dell.yunifangdemo.fragment.ClassifyFragment;
import com.riven.dell.yunifangdemo.fragment.HomeFragment;
import com.riven.dell.yunifangdemo.fragment.ShoppingFragment;
import com.riven.dell.yunifangdemo.fragment.UserFragment;
import com.riven.dell.yunifangdemo.utils.CommonUtils;
import com.riven.dell.yunifangdemo.view.MainViewPager;

import java.util.ArrayList;

/**
 * 主界面Activity
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    private MainViewPager viewPager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> fragsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件方法
        initViews();
        //初始化fragment类集合
        initFragsList();
        //创建适配器并绑定给ViewPager
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),fragsList);
        viewPager.setAdapter(mainViewPagerAdapter);
        //radioGroup按钮切换监听事件
        radioGroup.setOnCheckedChangeListener(this);

    }

    /**
     * 初始化fragment类集合
     */
    private void initFragsList() {
        fragsList = new ArrayList<>();
        fragsList.add(new HomeFragment());
        fragsList.add(new ClassifyFragment());
        fragsList.add(new ShoppingFragment());
        fragsList.add(new UserFragment());
    }

    /**
     * 初始化控件方法
     */
    private void initViews() {
        viewPager = (MainViewPager) findViewById(R.id.main_viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
    }


    /**
     * 重写radioGroup监听事件
     * @param radioGroup
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        for (int i = 0; i < 4; i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            if(radioButton.getId()==checkedId){
                viewPager.setCurrentItem(i);
                radioButton.setTextColor(CommonUtils.getColor(R.color.deeppink));
            }else {
                radioButton.setTextColor(CommonUtils.getColor(R.color.black));
            }
        }
    }


}
