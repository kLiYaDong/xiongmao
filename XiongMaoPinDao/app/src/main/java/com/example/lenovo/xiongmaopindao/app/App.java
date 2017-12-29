package com.example.lenovo.xiongmaopindao.app;

import android.app.Application;

import com.example.lenovo.xiongmaopindao.base.BaseActivity;
import com.example.lenovo.xiongmaopindao.base.BaseAdapters;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;

/**
 * Created by lenovo on 2017/12/18.
 */
public class App extends Application{
    public static BaseActivity baseActivity;
    public static BaseFragment baseFragment;
    public static BaseAdapters baseAdapter;
}
