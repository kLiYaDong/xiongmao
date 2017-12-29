package com.example.lenovo.xiongmaopindao.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.adapter.ZhiBoAdapter1;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.bean.Student5;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public class ZhiFragment extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View {
    private RecyclerView recyclerView;
    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView3);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        mPresenter.loginData("http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.zhibo;
    }

    @Override
    public void show(String url) {
        Log.e("ZhiBo",url);
        Gson gson = new Gson();
        Student5 student5 = gson.fromJson(url, Student5.class);
        List<Student5.ListBean> list = student5.getList();
        Log.e("jihe",list.size()+"");
        ZhiBoAdapter1 zhadapter = new ZhiBoAdapter1(list,getActivity().getApplicationContext());
        recyclerView.setAdapter(zhadapter);
    }
}
