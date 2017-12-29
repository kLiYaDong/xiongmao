package com.example.lenovo.xiongmaopindao.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.lenovo.xiongmaopindao.app.App;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;

/**
 * Created by lenovo on 2017/12/18.
 */
public class FragmentBuilder {
    private static volatile FragmentBuilder fragmentBuilder;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;
    private BaseFragment baseFragment;

    public FragmentBuilder() {
    }
    public static FragmentBuilder getFragmentBuilder(){
        if (fragmentBuilder == null) {
            synchronized (FragmentBuilder.class){
                fragmentBuilder = new FragmentBuilder();
            }
        }
        return fragmentBuilder;
    }
    public FragmentBuilder init(){
        fragmentManager = App.baseActivity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        return this;
    }
    public FragmentBuilder add(int containerId,Class<? extends BaseFragment> fragmentClass,boolean boo){
        String tag = fragmentClass.getSimpleName();
        fragment = (BaseFragment)fragmentManager.findFragmentByTag(tag);
        if (fragment==null){
            try {
                fragment = fragmentClass.newInstance();

                fragmentTransaction.add(containerId,fragment,tag);
                fragmentTransaction.addToBackStack(tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (!boo){
            if (App.baseFragment !=null){
                fragmentTransaction.hide(App.baseFragment);
            }
        }
        fragmentTransaction.show(fragment);
        return this;
    }
    public void Builder(){

        App.baseFragment= (BaseFragment) fragment;

        fragmentTransaction.commit();
    }
}
