package com.example.lenovo.xiongmaopindao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.xiongmaopindao.app.App;
import com.example.lenovo.xiongmaopindao.utils.Tutils;

/**
 * Created by lenovo on 2017/12/18.
 */
public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    public P mPresenter;
    public M mModle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.baseActivity = this;
        mPresenter = Tutils.setT(this,0);
        mModle = Tutils.setT(this,1);
        if (this instanceof BaseView){
            mPresenter.setVM(mModle,this);
        }
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutId();
}
