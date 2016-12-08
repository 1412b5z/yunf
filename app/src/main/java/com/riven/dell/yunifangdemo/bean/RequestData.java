package com.riven.dell.yunifangdemo.bean;

import java.util.ArrayList;

/**
 * @author rivenlee
 * @date 2016/12/7 15:54
 */

public class RequestData {
    public ArrayList<Ad1> ad1;
    public ArrayList<Ad5> ad5;
    public ArrayList<DefaultGoodsList> defaultGoodsList;
    public ArrayList<Subjects> subjects;
    public ActivityInfo activityInfo;

    @Override
    public String toString() {
        return "RequestData{" +
                "ad1=" + ad1 +
                ", ad5=" + ad5 +
                ", defaultGoodsList=" + defaultGoodsList +
                ", subjects=" + subjects +
                ", activityInfo=" + activityInfo +
                '}';
    }
}
