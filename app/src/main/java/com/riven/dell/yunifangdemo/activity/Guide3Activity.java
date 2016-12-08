package com.riven.dell.yunifangdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.application.MyApplication;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/12/7 0007.
 */

/**
 * 第一次启动应用时ViewPager的展示
 * 并判断第二次启动时不显示该ViewPager
 */
public class Guide3Activity extends Activity {
    //声明变量
    private ViewPager mViewPager;
    //声明数据源
    private ArrayList<View> mImageArr;
    private int[] mImageArrs = new int[]{R.mipmap.guidance_1,
            R.mipmap.guidance_2, R.mipmap.guidance_3,
            R.mipmap.guidance_4, R.mipmap.guidance_5};
    //声明sp
    private SharedPreferences mSp;
    private boolean mFlag;

    // @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获得getSharedPreferences对象
        mSp = MyApplication.getContext().getSharedPreferences("ccz", MODE_PRIVATE);
        //初始化内部类
        final SharedPreferences.Editor editor = mSp.edit();
        boolean b = mSp.getBoolean("mFlag", false);
        if (b) {
            Intent intent = new Intent(Guide3Activity.this, MainActivity.class);
            startActivity(intent);
            //关闭当前Activity
            finish();
        }
        setContentView(R.layout.guide3_layout);
        //初始化控件
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mImageArr = new ArrayList<View>();
        //添加数据
        for (int i = 0; i < mImageArrs.length; i++) {
            ImageView image = new ImageView(this);
            image.setImageResource(mImageArrs[i]);
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageArr.add(image);
        }
        mViewPager.setAdapter(new MyViewPagerAdapter());
        //设置跳转主页监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 4) {
                    Intent intent = new Intent(Guide3Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mFlag = true;
                editor.putBoolean("mFlag", mFlag);
                editor.commit();
            }
        });
    }

    //绑定适配器
    class MyViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mImageArr.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView(mImageArr.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageArr.get(position));
            return mImageArr.get(position);
        }
    }
}
