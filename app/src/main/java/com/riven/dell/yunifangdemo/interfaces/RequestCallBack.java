package com.riven.dell.yunifangdemo.interfaces;

/**
 * @author rivenlee
 * @date 2016/12/6 18:51
 */

public interface RequestCallBack {
    void onSuccess(String response);
    void onFailure(String error);
}
