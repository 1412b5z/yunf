package com.riven.dell.yunifangdemo.utils;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.riven.dell.yunifangdemo.application.MyApplication;
import com.riven.dell.yunifangdemo.interfaces.RequestCallBack;

/**
 * @author rivenlee
 * @date 2016/12/6 18:36
 */

public class HttpUtils {

    private final RequestQueue requestQueue;
    private static HttpUtils httpUtils;

    public static HttpUtils getHttpUtils(){
        if (httpUtils == null){
            synchronized (HttpUtils.class){
                if (httpUtils == null){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    private HttpUtils(){
        requestQueue = Volley.newRequestQueue(MyApplication.getContext());
    }
    public void getRequest(String url, final RequestCallBack callBack){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(callBack!=null){
                    callBack.onSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    callBack.onFailure("无网络连接");
            }
        });
        requestQueue.add(request);
    }

}
