package com.example.lenovo.xiongmaopindao.sqilts;

import android.os.Bundle;
import android.support.v4.app.Fragment;;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.request.transition.Transition;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TongYFragment extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View{
    private RecyclerView mRecytong;
    private ViewAdapter mViewAdapter;

    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        mRecytong= (RecyclerView) view.findViewById(R.id.RecyclerView_Tong);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecytong.setLayoutManager(linearLayoutManager);
        String url1 = getArguments().getString("url");
        Log.e("==",url1);
//        Bundle arguments = getArguments();
//        String url = arguments.getString("url");
        mPresenter.loginData(url1);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_tong_y;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        MyDuo myDuo = gson.fromJson(url, MyDuo.class);
        List<MyDuo.LiveBean> live = myDuo.getLive();
        mViewAdapter = new ViewAdapter(live,getActivity());
        mRecytong.setAdapter(mViewAdapter);
    }
    public static TongYFragment newInstance(String s) {

        Bundle args = new Bundle();
        args.putString("url",s);
        TongYFragment fragment = new TongYFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
