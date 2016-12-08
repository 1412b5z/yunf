package com.riven.dell.yunifangdemo.interfaces;


/**
 * @author rivenlee
 * @date 2016/12/7 20:09
 */

public interface RequestGson {
    void onGsonSuccess(Object object);
    void onGsonFail(String error);
}
