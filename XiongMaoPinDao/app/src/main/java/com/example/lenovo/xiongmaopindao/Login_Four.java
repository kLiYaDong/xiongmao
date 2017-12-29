package com.example.lenovo.xiongmaopindao;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//设置页面

public class Login_Four extends AppCompatActivity implements View.OnClickListener {
    private ImageView Back_Four;
    private ImageView imageView1;
    private ImageView imageView11;
    private ImageView imageView2;
    private ImageView imageView22;
    private TextView textView3;
    private ImageView imageView3;

    /**
     * 设置页面
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login__four);
        initView();
        initback();
        initchar();

    }

    private void initback() {

        Back_Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回按键   点击返回到登录设置的详情页面
                finish();
            }
        });


    }

    private void initView() {
        Back_Four = (ImageView) findViewById(R.id.Back_Four);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setOnClickListener(this);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView11.setOnClickListener(this);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(this);
        imageView22 = (ImageView) findViewById(R.id.imageView22);
        imageView22.setOnClickListener(this);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(this);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView3.setOnClickListener(this);
    }

    /**
     * 这个是我的设置详情  有按钮  点击开启或者关闭   有两张图片互相切换
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView1:
                imageView1.setVisibility(View.GONE);
                imageView11.setVisibility(View.VISIBLE);
                break;

            case R.id.imageView11:
                imageView1.setVisibility(View.VISIBLE);
                imageView11.setVisibility(View.GONE);
                break;

            case R.id.imageView2:
                imageView2.setVisibility(View.GONE);
                imageView22.setVisibility(View.VISIBLE);
                break;

            case R.id.imageView22:
                imageView2.setVisibility(View.VISIBLE);
                imageView22.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 清除缓存功能
     * DataCleanManager是清除缓存缓存功能的一个工具类
     */
    private void initchar() {
        try {
            textView3.setText(DataCleanManager.getTotalCacheSize(Login_Four.this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login_Four.this);
                builder.setTitle("确认清除缓存吗？")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DataCleanManager.clearAllCache(Login_Four.this);
                                try {
                                    textView3.setText(DataCleanManager
                                            .getTotalCacheSize(Login_Four.this));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                builder.show();
            }
        });
    }

}
