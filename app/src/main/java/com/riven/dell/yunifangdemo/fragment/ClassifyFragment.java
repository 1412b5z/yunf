package com.riven.dell.yunifangdemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.adapter.ClassifyListViewAdapter;
import com.riven.dell.yunifangdemo.application.MyApplication;
import com.riven.dell.yunifangdemo.bean.Classify_GridViewBean;
import com.riven.dell.yunifangdemo.interfaces.RequestGson;
import com.riven.dell.yunifangdemo.utils.Api;
import com.riven.dell.yunifangdemo.utils.CommonUtils;
import com.riven.dell.yunifangdemo.utils.HttpUtils;
import com.riven.dell.yunifangdemo.view.MyGridView;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author 陈昶之
 * @date 2016/12/7 16:18
 */

/**
 * 分类页面的展示
 */

public class ClassifyFragment extends Fragment{
    //声明控件
    private MyGridView mGridView;//屏幕下方GridView
    private ArrayList<Classify_GridViewBean.DataBean.GoodsBriefBean> mData;//GridView数据源
    private ClassifyListViewAdapter adapter;
    //构建Handler更新UI
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                adapter = new ClassifyListViewAdapter(MyApplication.getContext(),mData);
                mGridView.setAdapter(adapter);
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //将布局转换成view视图
        View view  = inflater.inflate(R.layout.fragment_classify,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //调用初始化控件的方法
        initViews();
        //调用添加数据的方法
        getData();
    }

    //初始化控件的方法
    private void initViews() {
        mGridView = (MyGridView) getActivity().findViewById(R.id.mxGrid_View);

    }
    //为数据源添加数据的方法
    private void getData(){
        HttpUtils.getHttpUtils().getRequestData(Api.classifyUrL,Classify_GridViewBean.class,new RequestGson() {
            //成功
            @Override
            public void onGsonSuccess(Object object) {
                Classify_GridViewBean Classify_GridViewBean = (com.riven.dell.yunifangdemo.bean.Classify_GridViewBean) object;
                mData = (ArrayList<com.riven.dell.yunifangdemo.bean.Classify_GridViewBean.DataBean.GoodsBriefBean>) Classify_GridViewBean.getData().getGoodsBrief();
                if(mData!=null){
                    Log.d("TAGS",mData.toString());
                    handler.sendEmptyMessage(0);
                }
            }
            //失败
            @Override
            public void onGsonFail(String error) {

            }
        });
    }
}
