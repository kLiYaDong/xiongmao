package com.example.lenovo.xiongmaopindao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lenovo.xiongmaopindao.bean.ChilaStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public class ChildAdapter extends FragmentPagerAdapter {
    private List<String> beanList;
    private ArrayList<Fragment> list;

    public ChildAdapter(FragmentManager fm, List<String> beanList, ArrayList<Fragment> list) {
        super(fm);
        this.beanList = beanList;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return beanList.get(position);
    }
}
