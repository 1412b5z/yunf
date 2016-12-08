package com.riven.dell.yunifangdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * @author rivenlee
 * @date 2016/12/8 14:28
 */

public class HomePagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> viewsList;

    public HomePagerAdapter(ArrayList<ImageView> viewsList) {
        this.viewsList = viewsList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewsList.get(position%viewsList.size()));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewsList.get(position%viewsList.size());
        container.addView(view);
        return view;
    }
}
