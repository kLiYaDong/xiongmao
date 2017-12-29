package com.example.lenovo.xiongmaopindao.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiongmaopindao.Main4Activity;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.adapter.GunGunAdapter;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.bean.GunGun;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import me.leefeng.lfrecyclerview.LFRecyclerView;

/**
 * Created by lenovo on 2017/12/19.
 */
public class BFragment extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View{
    private LFRecyclerView recyclerView;
    private GunGunAdapter gunadapter;
    private GunGun gunGun;
    private List<GunGun.ListBean> liste;
    private List<GunGun.BigImgBean> bigImg;
    private ImageView mImage;
    private TextView mNmae;
    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = (LFRecyclerView) view.findViewById(R.id.LFRecler);

        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.imagersframgne,null);
        mImage = (ImageView) view1.findViewById(R.id.Imagers);
        mNmae = (TextView) view1.findViewById(R.id.Namerss);
        recyclerView.setLoadMore(true);
        mPresenter.loginData("http://www.ipanda.com/kehuduan/video/index.json");

        recyclerView.setHeaderView(view1);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.bfragment;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        gunGun = gson.fromJson(url, GunGun.class);
        bigImg = gunGun.getBigImg();
        Glide.with(getActivity()).load(bigImg.get(0).getImage()).into(mImage);
        mNmae.setText(bigImg.get(0).getTitle());
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Main4Activity.class);
                intent.putExtra("name",bigImg.get(0).getUrl());
                startActivity(intent);

            }
        });
        liste = gunGun.getList();
        gunadapter = new GunGunAdapter(liste,getActivity().getApplicationContext());
        recyclerView.setAdapter(gunadapter);
        gunadapter.onClick(new GunGunAdapter.OnSetItem() {
            @Override
            public void onItem(View v, int position) {
                GunGun.ListBean listBean = liste.get(position);
                Intent intent = new Intent(getActivity().getApplicationContext(), Main4Activity.class);
                intent.putExtra("name",listBean.getUrl());
                startActivity(intent);
            }
        });
    }
}
