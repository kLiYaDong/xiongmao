package com.example.lenovo.xiongmaopindao.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.adapter.MyAdapterTwo;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.bean.SetString;
import com.example.lenovo.xiongmaopindao.bean.StudentTwo;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/19.
 *
 *http://api.cntv.cn/video/videolistById?vsid=VSET100332640004&n=2&serviceId=panda&o=desc&of=time&p=7
 *http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=2&serviceId=panda&o=desc&of=time&p=7
 * VSET100340574858
 *熊猫TOP榜VSET100284428835
 *熊猫那些事儿VSET100237714751
 */
public class AFragment extends BaseFragment<LoginPresenter, LoginModel> implements LoginContract.View {
    private ArrayList<Fragment> list = new ArrayList<>();
    private List<StudentTwo.TablistBean> tablist = new ArrayList<>();
    private ArrayList<String> list1 = new ArrayList<>();
    private MyAdapterTwo myAdapterTwo;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void intiData() {

    }

    @Override
    protected void initView(View view) {
        list1.clear();
        list.clear();
        tabLayout = (TabLayout) view.findViewById(R.id.TabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.ViewPager);
        mPresenter.loginData("http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");



    }

    @Override
    protected int setLayoutId() {
        return R.layout.afragment;
    }

    @Override
    public void show(String url) {
        Log.e("weewdsd", "asdasdas");
        Gson gson = new Gson();
        StudentTwo studentTwo = gson.fromJson(url, StudentTwo.class);
        tablist = studentTwo.getTablist();

        for (int i = 0; i < tablist.size(); i++) {
            list1.add(tablist.get(i).getTitle());

        }
        FragmentTest1 fragmetn = new FragmentTest1();
        Bundle bundler = new Bundle();
        bundler.putString("url",tablist.get(0).getUrl());
        fragmetn.setArguments(bundler);
        list.add(fragmetn);
        for (int z = 1; z < list1.size(); z++) {
            FragmentTest2 fragmentTest2 = new FragmentTest2();
            list.add(fragmentTest2);
        }
        myAdapterTwo = new MyAdapterTwo(getFragmentManager(), list, list1);
        viewPager.setAdapter(myAdapterTwo);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);
        Log.e("weewdsd", "asdasdas");
    }

}
