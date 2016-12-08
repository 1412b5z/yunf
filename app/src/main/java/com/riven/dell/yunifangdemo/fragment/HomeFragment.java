package com.riven.dell.yunifangdemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.activity.BaseActivity;
import com.riven.dell.yunifangdemo.adapter.HomePagerAdapter;
import com.riven.dell.yunifangdemo.application.MyApplication;
import com.riven.dell.yunifangdemo.bean.Ad1;
import com.riven.dell.yunifangdemo.bean.RequestData;
import com.riven.dell.yunifangdemo.interfaces.RequestCallBack;
import com.riven.dell.yunifangdemo.interfaces.RequestGson;
import com.riven.dell.yunifangdemo.utils.Api;
import com.riven.dell.yunifangdemo.utils.CommonUtils;
import com.riven.dell.yunifangdemo.utils.HttpUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @author rivenlee
 * @date 2016/12/7 16:18
 */

public class HomeFragment extends Fragment {

    private View view;
    private ViewPager home_viewPager;
    private ArrayList<Ad1> ad1 ;
    private ArrayList<ImageView> viewsList;
    private ArrayList<ImageView> pointsList;
    private static final int PAGER_MOVE = 0;
    private int count = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case PAGER_MOVE:
                    home_viewPager.setCurrentItem(++count);
                    handler.sendEmptyMessageDelayed(PAGER_MOVE,3000);
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        initImgsList();
        getNetData();
        return view;
    }

    private void getNetData() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(viewsList);
        home_viewPager.setAdapter(homePagerAdapter);
        home_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                for(int i=0;i<pointsList.size();i++){
                    pointsList.get(i).setSelected(false);
                }
                pointsList.get(arg0%pointsList.size()).setSelected(true);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        handler.sendEmptyMessageDelayed(PAGER_MOVE,5000);
    }
    private void initImgsList() {
        viewsList = new ArrayList<>();
        pointsList = new ArrayList<>();
        LinearLayout ll_points = (LinearLayout) view.findViewById(R.id.ll_points);
        for (int i = 0; i < ad1.size(); i++) {
            ImageView imageView = new ImageView(MyApplication.getContext());
            Picasso.with(MyApplication.getContext()).load(ad1.get(i).image).into(imageView);
            viewsList.add(imageView);
            ImageView point = new ImageView(MyApplication.getContext());
            point.setImageResource(R.drawable.shape_selector);
            point.setPadding(10, 0, 10, 0);
            ll_points.addView(point);
            pointsList.add(point);
        }
        pointsList.get(0).setSelected(true);

    }

    private void initView() {
        home_viewPager = (ViewPager) view.findViewById(R.id.home_viewPager);
    }

}
