package com.riven.dell.yunifangdemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.adapter.HomeGridAdapter;
import com.riven.dell.yunifangdemo.adapter.HomePagerAdapter;
import com.riven.dell.yunifangdemo.application.MyApplication;
import com.riven.dell.yunifangdemo.bean.Ad1;
import com.riven.dell.yunifangdemo.bean.Ad5;
import com.riven.dell.yunifangdemo.bean.RequestBean;
import com.riven.dell.yunifangdemo.interfaces.RequestGson;
import com.riven.dell.yunifangdemo.utils.Api;
import com.riven.dell.yunifangdemo.utils.CommonUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @author rivenlee
 * @date 2016/12/7 16:18
 */

public class HomeFragment extends Fragment implements RequestGson{

    private View view;
    private ViewPager home_viewPager;
    private GridView home_gridView;
    private ArrayList<Ad1> ad1 ;
    private ArrayList<Ad5> ad5;
    private ArrayList<View> viewsList;
    private ArrayList<ImageView> pointsList;
    private static final int PAGER_MOVE = 0;
    private int count = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case PAGER_MOVE:
                    count++;
                    home_viewPager.setCurrentItem(count%viewsList.size());
                    handler.sendEmptyMessageDelayed(PAGER_MOVE,3000);
                    break;
            }
        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        MyApplication.getHttpUtils().getRequestData(Api.homeUrl, RequestBean.class,this);
        initView();
        return view;
    }

    private void initViewPagerData() {
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(viewsList);
        home_viewPager.setAdapter(homePagerAdapter);
        home_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                for(int i=0;i<pointsList.size();i++){
                    pointsList.get(i).setSelected(false);
                }
                pointsList.get(arg0).setSelected(true);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    private void initImgsList() {
        viewsList = new ArrayList<>();
        pointsList = new ArrayList<>();
        LinearLayout ll_points = (LinearLayout) view.findViewById(R.id.ll_points);
        for (int i = 0; i < ad1.size(); i++) {
            View v = CommonUtils.inflate(R.layout.home_view_frag);
            ImageView imageView = (ImageView) v.findViewById(R.id.home_view_img);
            Picasso.with(MyApplication.getContext()).load(ad1.get(i).image).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewsList.add(v);
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
        home_gridView = (GridView) view.findViewById(R.id.home_gridView);
    }

    @Override
    public void onGsonSuccess(Object object) {
        RequestBean requestBean = (RequestBean)object;
        Log.d("TAG",requestBean.toString());
        ad1 = requestBean.data.ad1;
        ad5 = requestBean.data.ad5;
        initImgsList();
        initViewPagerData();
        initGridView();
    }

    private void initGridView() {
        HomeGridAdapter homeGridAdapter = new HomeGridAdapter(ad5);
        home_gridView.setAdapter(homeGridAdapter);
    }

    @Override
    public void onGsonFail(String error) {
        Toast.makeText(MyApplication.getContext(),"無網絡連接",Toast.LENGTH_SHORT).show();
    }


}
