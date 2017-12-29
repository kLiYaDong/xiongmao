package com.example.lenovo.xiongmaopindao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lenovo.xiongmaopindao.base.BaseActivity;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;

/*http://news.ipanda.com/2017/06/12/ARTIBdwYiZE71cob9CQLUz79170612.shtml*/
public class Main3Activity extends BaseActivity<LoginPresenter,LoginModel> {
    private WebView webView;

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.WebVIew);
        webView.loadUrl("http://news.ipanda.com/2017/06/12/ARTIBdwYiZE71cob9CQLUz79170612.shtml");
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
        return R.layout.activity_main3;
    }
}
