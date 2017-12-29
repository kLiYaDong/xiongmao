package com.example.lenovo.xiongmaopindao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiongmaopindao.Main4Activity;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.adapter.GunGunAdapter;
import com.example.lenovo.xiongmaopindao.adapter.JiaoAdapter;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.bean.GunGun;
import com.example.lenovo.xiongmaopindao.bean.Jiao;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/22.
 */
public class FragmentTest2 extends BaseFragment<LoginPresenter, LoginModel> implements LoginContract.View {
    private RecyclerView recyclerView;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList.add("http://172.16.52.12/LYD/b.json");
        arrayList.add("http://172.16.52.12/LYD/a.json");
        arrayList.add("http://172.16.52.12/LYD/d.json");
        arrayList.add("http://172.16.52.12/LYD/g.json");
        arrayList.add("http://172.16.52.12/LYD/c.json");
        arrayList.add("http://172.16.52.12/LYD/g.json");
        arrayList.add("http://172.16.52.12/LYD/a.json");
        arrayList.add("http://172.16.52.12/LYD/h.json");
        for (int i=0;i<arrayList.size();i++){
            mPresenter.loginData(arrayList.get(i));
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.test2;
    }

    @Override
    public void show(String url) {
        Log.e("name", url);
        Gson gson = new Gson();
        GunGun gunGun = gson.fromJson(url, GunGun.class);
        List<GunGun.ListBean> list = gunGun.getList();
        GunGunAdapter gun = new GunGunAdapter(list, getActivity().getApplicationContext());
        recyclerView.setAdapter(gun);
        Jiao jiao = gson.fromJson(url, Jiao.class);
        final List<Jiao.VideoBean> video = jiao.getVideo();
        JiaoAdapter jiaoadapter = new JiaoAdapter(video,getActivity().getApplicationContext());
        recyclerView.setAdapter(jiaoadapter);
        jiaoadapter.onClick(new JiaoAdapter.OnItemSet() {
            @Override
            public void onItem(View v, int position) {
                Jiao.VideoBean videoBean = video.get(position);
                Intent intent = new Intent(getActivity().getApplicationContext(),Main4Activity.class);
                intent.putExtra("name",videoBean.getUrl());
                startActivity(intent);
            }
        });
    }
}
