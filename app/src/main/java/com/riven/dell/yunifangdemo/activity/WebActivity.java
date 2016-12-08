package com.riven.dell.yunifangdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.riven.dell.yunifangdemo.R;

/**
 * @author rivenlee
 * @date 2016/12/8 20:03
 */

public class WebActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        String urlStr = getIntent().getStringExtra("ad_type_dynamic_data");
        WebView webView = (WebView) findViewById(R.id.webView);
        //加载地址
        webView.loadUrl(urlStr);
        //设置在本页中打开
        webView.setWebViewClient(new WebViewClient());
        //设置js交互开关
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
