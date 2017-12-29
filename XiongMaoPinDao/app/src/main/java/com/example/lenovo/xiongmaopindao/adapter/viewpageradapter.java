package com.example.lenovo.xiongmaopindao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 郝可心 on 2017/12/7.
 */

public class viewpageradapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public viewpageradapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.isEmpty() ? 0 : list.size();
    }
}
