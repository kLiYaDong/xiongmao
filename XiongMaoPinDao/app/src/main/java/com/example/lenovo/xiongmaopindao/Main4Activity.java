package com.example.lenovo.xiongmaopindao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lenovo.xiongmaopindao.base.BaseActivity;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;

public class Main4Activity extends BaseActivity<LoginPresenter,LoginModel> {
    private WebView webView;
    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.WebVIew1);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        webView.loadUrl(name);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main4;
    }
}
