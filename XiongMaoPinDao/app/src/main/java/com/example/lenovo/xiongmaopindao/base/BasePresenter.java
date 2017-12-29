package com.example.lenovo.xiongmaopindao.base;

/**
 * Created by lenovo on 2017/12/18.
 */
public abstract class BasePresenter<M,V> {
    public M baseModle;
    public V baseView;
    public void setVM(M m,V v){
        baseModle = m;
        baseView = v;
        this.onStart();
    }

    public abstract void onStart();
}
