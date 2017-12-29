package com.example.lenovo.xiongmaopindao.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiongmaopindao.Main4Activity;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.adapter.BoBaoAdapter;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.bean.BoBao;
import com.example.lenovo.xiongmaopindao.bean.XiongMaoBoBao;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.leefeng.lfrecyclerview.LFRecyclerView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/12/19.
 * http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda
 */
public class CFragment extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View{
    private LFRecyclerView recyclerView;
    private ImageView mImage;
    private TextView mNmae;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String name = (String) msg.obj;
            Gson gsone = new Gson();
            XiongMaoBoBao xiongMaoBoBao = gsone.fromJson(name, XiongMaoBoBao.class);
            final List<XiongMaoBoBao.ListBean> list = xiongMaoBoBao.getList();
            BoBaoAdapter bobaoadapter = new BoBaoAdapter(list,getActivity().getApplicationContext());
            recyclerView.setAdapter(bobaoadapter);
            bobaoadapter.onClick(new BoBaoAdapter.OnSetItem() {
                @Override
                public void onItem(View v, int position) {
                    XiongMaoBoBao.ListBean listBean = list.get(position);
                    Intent intent = new Intent(getActivity().getApplicationContext(), Main4Activity.class);
                    intent.putExtra("name",listBean.getUrl());
                    startActivity(intent);
                }
            });
        }
    };
    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = (LFRecyclerView) view.findViewById(R.id.LFRecler);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.imagersframgne,null);
        mImage = (ImageView) view1.findViewById(R.id.Imagers);
        mNmae = (TextView) view1.findViewById(R.id.Namerss);
        recyclerView.setRefresh(true);
        recyclerView.setAutoLoadMore(true);
        mPresenter.loginData("http://www.ipanda.com/kehuduan/news/index.json");
        intiSetData();
        recyclerView.setHeaderView(view1);

        recyclerView.setLFRecyclerViewListener(new LFRecyclerView.LFRecyclerViewListener() {
            @Override
            public void onRefresh() {
                intiSetData();
            }

            @Override
            public void onLoadMore() {
                   intiSetData();
            }
        });
    }

    @Override
    protected int setLayoutId() {
        return R.layout.bfragment;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        BoBao boBao = gson.fromJson(url, BoBao.class);
        final List<BoBao.DataBean.BigImgBean> bigImg = boBao.getData().getBigImg();
        mNmae.setText(bigImg.get(0).getTitle());
        Glide.with(getActivity()).load(bigImg.get(0).getImage()).into(mImage);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Main4Activity.class);
                intent.putExtra("name",bigImg.get(0).getUrl());
                Log.e("name",bigImg.get(0).getUrl());
                startActivity(intent);
            }
        });
    }
    private void intiSetData(){
        OkHttpClient okhttper = new OkHttpClient();
        Request request = new Request.Builder().url("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda").build();
        okhttper.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = new Message();
                msg.obj = response.body().string();
                handler.sendMessage(msg);
            }
        });

    }
}
