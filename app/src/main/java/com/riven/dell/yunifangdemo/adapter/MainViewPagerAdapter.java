package com.riven.dell.yunifangdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author rivenlee
 * @date 2016/12/7 18:44
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragsList;
    public MainViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragsList) {
        super(fm);
        this.fragsList = fragsList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragsList.get(position);
    }

    @Override
    public int getCount() {
        return fragsList.size();
    }
}
