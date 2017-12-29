package com.example.lenovo.xiongmaopindao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.xiongmaopindao.adapter.viewpageradapter;

import java.util.ArrayList;

public class Login_Threee extends AppCompatActivity {


    private ArrayList<Fragment> list = new ArrayList<>();
    private viewpageradapter adapter;
    private Onefragment onefragment;
    private Twofragment twofragment;
    private TabLayout Tablyout_Three;
    private ViewPager Viewpager_Three;
    private RecyclerView Back_Login_threee;

    /**
     * 收藏页面
     * 有两个切换的fragment  但是fragment是空的
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__threee);
        initView();
        initdata();
    }

    private void initdata() {
        Tablyout_Three.addTab(Tablyout_Three.newTab().setText("直播"));
        Tablyout_Three.addTab(Tablyout_Three.newTab().setText("精彩看点"));
        onefragment = new Onefragment();
        twofragment = new Twofragment();
        list.add(onefragment);
        list.add(twofragment);
        adapter = new viewpageradapter(getSupportFragmentManager(), list);
        Viewpager_Three.setAdapter(adapter);
        Tablyout_Three.setupWithViewPager(Viewpager_Three);
        Tablyout_Three.getTabAt(0).setText("直播");
        Tablyout_Three.getTabAt(1).setText("精彩看点");
        Back_Login_threee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void initView() {
        Tablyout_Three = (TabLayout) findViewById(R.id.Tablyout_Three);
        Viewpager_Three = (ViewPager) findViewById(R.id.Viewpager_Three);
        Tablyout_Three = (TabLayout) findViewById(R.id.Tablyout_Three);
        Viewpager_Three = (ViewPager) findViewById(R.id.Viewpager_Three);
        Back_Login_threee = (RecyclerView) findViewById(R.id.Recyview_Three);

    }
}
