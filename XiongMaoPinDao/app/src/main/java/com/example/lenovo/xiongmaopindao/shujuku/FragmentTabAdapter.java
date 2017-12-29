package com.example.lenovo.xiongmaopindao.shujuku;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/12/20.
 */

public class FragmentTabAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> lists;

    public FragmentTabAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> lists) {
        super(fm);
        this.list = list;
        this.lists = lists;
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
        return lists.get(position);
    }
}
