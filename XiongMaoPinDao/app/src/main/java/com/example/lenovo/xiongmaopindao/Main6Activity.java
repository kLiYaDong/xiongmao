package com.example.lenovo.xiongmaopindao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lenovo.xiongmaopindao.base.BaseActivity;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;

public class Main6Activity extends BaseActivity<LoginPresenter, LoginModel> implements View.OnClickListener {
    private LinearLayout mLinear, mLinear1, mLinear2, mLinear3;
    private Toolbar toolbar;

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.ToolBar);
        toolbar.setNavigationIcon(R.drawable.personal_back_img);
        setSupportActionBar(toolbar);
        mLinear = (LinearLayout) findViewById(R.id.Lineaar1);
        mLinear.setOnClickListener(this);
        mLinear1 = (LinearLayout) findViewById(R.id.Lineaar2);
        mLinear1.setOnClickListener(this);
        mLinear2 = (LinearLayout) findViewById(R.id.Lineaar3);
        mLinear2.setOnClickListener(this);
        mLinear3 = (LinearLayout) findViewById(R.id.Lineaar4);
        mLinear3.setOnClickListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main6;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Lineaar1:
                Intent intent = new Intent(Main6Activity.this, Login_One.class);
                startActivity(intent);
                break;
            case R.id.Lineaar2:
                Intent intent1 = new Intent(Main6Activity.this, Login_Two.class);
                startActivity(intent1);
                break;
            case R.id.Lineaar3:
                //登录设置页面跳转到收藏的页面
                Intent intent3 = new Intent(Main6Activity.this, Login_Threee.class);
                startActivity(intent3);
                break;
            case R.id.Lineaar4:
                Intent intent4 = new Intent(Main6Activity.this, Login_Four.class);
                startActivity(intent4);
                break;
        }
    }
}
