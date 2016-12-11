package com.riven.dell.yunifangdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.application.MyApplication;
import com.riven.dell.yunifangdemo.bean.ActivityInfoList;
import com.riven.dell.yunifangdemo.utils.CommonUtils;
import com.riven.dell.yunifangdemo.utils.PhotoLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @author rivenlee
 * @date 2016/12/10 9:16
 */

public class HomeViewPagerGallery extends PagerAdapter {
    ArrayList<ActivityInfoList> activityInfoList;


    public HomeViewPagerGallery(ArrayList<ActivityInfoList> activityInfoList) {
        this.activityInfoList = activityInfoList;
    }

    @Override
    public int getCount() {
        return activityInfoList.size()*100;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = CommonUtils.inflate(R.layout.home_view_gallery);
        ImageView imageView = (ImageView) view.findViewById(R.id.home_view_gallery);
        ActivityInfoList a = activityInfoList.get(position % activityInfoList.size());
//        Picasso.with(MyApplication.getContext()).load(activityInfoList.get(position%activityInfoList.size()).activityImg).into(imageView);
        PhotoLoader.display(container.getContext(), imageView, a.activityImg, CommonUtils.getDrawable(R.mipmap.ic_loading));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
