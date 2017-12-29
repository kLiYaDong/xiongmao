package com.example.lenovo.xiongmaopindao.login;

import com.example.lenovo.xiongmaopindao.base.BaseModel;
import com.example.lenovo.xiongmaopindao.base.BasePresenter;
import com.example.lenovo.xiongmaopindao.base.BaseView;

import java.util.Map;

/**
 * Created by lenovo on 2017/12/18.
 */
public interface LoginContract {

    interface View extends BaseView {
      void show(String url);
    }

    interface Model extends BaseModel {
        void getData(String url,CallBacks callBacks);
        void setData(String url, Map<String,Object> map,CallBacks callBacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
        public abstract void loginDatas(String url,Map<String,Object> map);
        public abstract void loginData(String url);
    }
}