package com.riven.dell.yunifangdemo.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.riven.dell.yunifangdemo.R;
import com.riven.dell.yunifangdemo.bean.Classify_GridViewBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/10 0010.
 */

public class ClassifyListViewAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Classify_GridViewBean.DataBean.GoodsBriefBean> mData;
    public ClassifyListViewAdapter(Context context,ArrayList<Classify_GridViewBean.DataBean.GoodsBriefBean> mData){
        this.context = context;
        this.mData = mData;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder holder =null;
        if(view == null){
            holder = new Viewholder();
            view = View.inflate(context, R.layout.classify_gridview_item_layout,null);
            holder.largeImage = (ImageView) view.findViewById(R.id.largeImage);
            holder.littleImage = (ImageView) view.findViewById(R.id.littleImage);
            holder.efficacy_tv = (TextView) view.findViewById(R.id.efficacy_tv);
            holder.goods_name_tv = (TextView) view.findViewById(R.id.goods_name_tv);
            holder.shop_price = (TextView) view.findViewById(R.id.shop_price);
            holder.market_price_tv = (TextView) view.findViewById(R.id.market_price_tv);
            view.setTag(holder);
        }else{
            holder = (Viewholder) view.getTag();
        }
        Picasso.with(context).load(mData.get(i).getGoods_img()).into(holder.largeImage);
        Picasso.with(context).load(mData.get(i).getWatermarkUrl()).into(holder.littleImage);
        holder.efficacy_tv.setText(mData.get(i).getEfficacy());
        holder.goods_name_tv.setText(mData.get(i).getGoods_name());
        holder.shop_price.setText(mData.get(i).getShop_price()+"");
        holder.market_price_tv.setText(mData.get(i).getMarket_price()+"");
        return view;
    }
    class Viewholder{
        ImageView largeImage,littleImage;
        TextView efficacy_tv,goods_name_tv,shop_price,market_price_tv;
    }
}
