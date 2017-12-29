package com.example.lenovo.xiongmaopindao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * Created by lenovo on 2017/12/20.
 */
public class MyZhiBoAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> arrayList;

    public MyZhiBoAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> arrayList) {
        super(fm);
        this.list = list;
        this.arrayList = arrayList;
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
        return arrayList.get(position);
    }
}
