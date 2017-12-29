package com.example.lenovo.xiongmaopindao.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiongmaopindao.Main4Activity;
import com.example.lenovo.xiongmaopindao.Main5Activity;
import com.example.lenovo.xiongmaopindao.Main6Activity;
import com.example.lenovo.xiongmaopindao.Main7Activity;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.adapter.MyAdapter;
import com.example.lenovo.xiongmaopindao.adapter.MyAdapter1;
import com.example.lenovo.xiongmaopindao.adapter.MyAdapter2;
import com.example.lenovo.xiongmaopindao.adapter.MyAdapter3;
import com.example.lenovo.xiongmaopindao.adapter.MyAdapter4;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.bean.Student;
import com.example.lenovo.xiongmaopindao.bean.Student1;
import com.example.lenovo.xiongmaopindao.bean.Student2;
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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/12/19.
 */
public class FragmentTest extends BaseFragment<LoginPresenter, LoginModel> implements LoginContract.View,View.OnClickListener {

    private ImageView mImage, mImage1;
    private RecyclerView recyclerView;
    private RecyclerView recycler, recycler1, recycler2,recycler3;
    private Banner banner;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> texts = new ArrayList<>();
    private boolean boo = true;
    private Student student;
    private MyAdapter madapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String name = (String) msg.obj;
            Gson gson1 = new Gson();
            Student1 student1 = gson1.fromJson(name, Student1.class);
            final List<Student1.ListBean> list2 = student1.getList();
            MyAdapter3 myadapter3 = new MyAdapter3(list2,getActivity().getApplicationContext());
            recycler2.setAdapter(myadapter3);
            myadapter3.onClick(new MyAdapter3.OnItemSet() {
                @Override
                public void onItem(View v, int position) {
                    Student1.ListBean listBean = list2.get(position);
                    Intent intent = new Intent(getActivity().getApplicationContext(), Main4Activity.class);
                    intent.putExtra("name",listBean.getUrl());
                    startActivity(intent);
                }
            });
        }
    };
    private Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String name = (String) msg.obj;
            Gson gson2 = new Gson();
            Student2 student2 = gson2.fromJson(name, Student2.class);
            final List<Student2.ListBean> list = student2.getList();
            MyAdapter4 myadapter4 = new MyAdapter4(list,getActivity().getApplicationContext());
            recycler3.setAdapter(myadapter4);
            myadapter4.onClick(new MyAdapter4.OnItemSet() {
                @Override
                public void onItem(View v, int position) {
                    Student2.ListBean listBean = list.get(position);
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
        mImage = (ImageView) view.findViewById(R.id.ImageOne);
        mImage.setOnClickListener(this);
        mImage1 = (ImageView) view.findViewById(R.id.ImageTwo);
        mImage1.setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        recycler = (RecyclerView) view.findViewById(R.id.Recycler);
        recycler1 = (RecyclerView) view.findViewById(R.id.Recycler1);
        recycler2 = (RecyclerView) view.findViewById(R.id.Recycler2);
        recycler3 = (RecyclerView) view.findViewById(R.id.Recycler3);
        banner = (Banner) view.findViewById(R.id.Banner);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayout = new GridLayoutManager(getActivity().getApplicationContext(), 3);
        recycler.setLayoutManager(gridLayout);

        GridLayoutManager gridLayout1 = new GridLayoutManager(getActivity().getApplicationContext(), 3);
        recycler1.setLayoutManager(gridLayout1);


        LinearLayoutManager linear1 = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler2.setLayoutManager(linear1);

        GridLayoutManager gridLayout2 = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recycler3.setLayoutManager(gridLayout2);
        mPresenter.loginData("http://www.ipanda.com/kehuduan/shouye/index.json");
        initDatas();
        intitadas();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void show(String url) {
        Log.e("name", url);
        Gson gson = new Gson();
        student = gson.fromJson(url, Student.class);
        List<Student.DataBean.BigImgBean> bigImg = student.getData().getBigImg();
        if (boo) {
            for (int i = 0; i < bigImg.size(); i++) {
                list.add(bigImg.get(i).getImage());
                texts.add(bigImg.get(i).getTitle());
            }
            boo = false;
        }
        banner.setImages(list)
                .setDelayTime(2000)
                .setImageLoader(new Glides())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setBannerTitles(texts)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();

        final List<Student.DataBean.PandaeyeBean.ItemsBean> items = student.getData().getPandaeye().getItems();
        Student.DataBean.PandaeyeBean pandaeye = student.getData().getPandaeye();
        madapter = new MyAdapter(items, getActivity().getApplicationContext(), pandaeye);
        recyclerView.setAdapter(madapter);
        madapter.onClick(new MyAdapter.OnItemSet() {
            @Override
            public void onItem(View v, int position) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Main7Activity.class);
                startActivity(intent);
            }
        });

        final List<Student.DataBean.PandaliveBean.ListBean> list = student.getData().getPandalive().getList();
        MyAdapter2 myadapter2 = new MyAdapter2(list, getActivity().getApplicationContext());
        recycler.setAdapter(myadapter2);
        myadapter2.onClick(new MyAdapter2.OnItemSet() {
            @Override
            public void onItem(View v, int position) {
                Student.DataBean.PandaliveBean.ListBean listBean = list.get(position);
                Intent intent = new Intent(getActivity().getApplicationContext(), Main4Activity.class);
                intent.putExtra("name",listBean.getUrl());
                startActivity(intent);
            }
        });

        final List<Student.DataBean.ChinaliveBean.ListBeanX> list1 = student.getData().getChinalive().getList();
        MyAdapter1 myadapter = new MyAdapter1(list1, getActivity().getApplicationContext());
        recycler1.setAdapter(myadapter);
        myadapter.onClick(new MyAdapter1.OnItemSet() {
            @Override
            public void onItem(View v, int position) {
                Student.DataBean.ChinaliveBean.ListBeanX listBeanX = list1.get(position);
                Intent intent = new Intent(getActivity().getApplicationContext(), Main4Activity.class);
                intent.putExtra("name",listBeanX.getVid());
                startActivity(intent);
            }
        });

    }

    private void initDatas() {
        OkHttpClient okhttp = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json").build();
        okhttp.newCall(request).enqueue(new Callback() {
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
    private void intitadas(){
        OkHttpClient okhttp = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.ipanda.com/kehuduan/shipinliebieye/jingcaiyike/index.json").build();
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg = new Message();
                msg.obj = response.body().string();
                handler1.sendMessage(msg);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ImageOne:
                Intent intent = new Intent(getActivity().getApplicationContext(), Main5Activity.class);
                startActivity(intent);
                break;
            case R.id.ImageTwo:
                Intent intent1 = new Intent(getActivity().getApplicationContext(),Main6Activity.class);
                startActivity(intent1);
                break;
        }
    }

    class Glides extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
