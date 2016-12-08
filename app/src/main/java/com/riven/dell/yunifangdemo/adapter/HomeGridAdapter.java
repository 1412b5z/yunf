package com.riven.dell.yunifangdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.application.MyApplication;
import com.riven.dell.yunifangdemo.bean.Ad5;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @author rivenlee
 * @date 2016/12/8 19:27
 */

public class HomeGridAdapter extends BaseAdapter {
    private ArrayList<Ad5> ad5;

    public HomeGridAdapter(ArrayList<Ad5> ad5) {
        this.ad5 = ad5;
    }

    @Override
    public int getCount() {
        return ad5.size();
    }

    @Override
    public Object getItem(int i) {
        return ad5.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view==null){
            view = View.inflate(MyApplication.getContext(), R.layout.item_grid_home,null);
            holder = new ViewHolder();
            holder.img = (ImageView) view.findViewById(R.id.home_gird_img);
            holder.text = (TextView) view.findViewById(R.id.home_grid_text);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Ad5 a = ad5.get(i);
        Picasso.with(MyApplication.getContext()).load(a.image).into(holder.img);
        holder.text.setText(a.title);
        return view;
    }

    class ViewHolder{
        ImageView img;
        TextView text;

    }
}
