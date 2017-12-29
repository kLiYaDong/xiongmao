package com.example.lenovo.xiongmaopindao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.lenovo.xiongmaopindao.bean.StudentTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/19.
 */
public class MyAdapterTwo extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private List<String> tablist;

    public MyAdapterTwo(FragmentManager fm, ArrayList<Fragment> list, List<String> tablist) {
        super(fm);
        this.list = list;
        this.tablist = tablist;
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
        return tablist.get(position);
    }
}
