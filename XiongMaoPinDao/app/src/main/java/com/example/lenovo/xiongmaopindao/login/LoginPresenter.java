package com.example.lenovo.xiongmaopindao.login;

import java.util.Map;

/**
* Created by TMVPHelper on 2017/12/18
*/
public class LoginPresenter extends LoginContract.Presenter{
    @Override
    public void loginDatas(String url, Map<String, Object> map) {
        baseModle.setData(url, map, new CallBacks() {
            @Override
            public void succ(String request) {
                baseView.show(request);
            }
        });
    }

    @Override
    public void loginData(String url) {
        baseModle.getData(url, new CallBacks() {
            @Override
            public void succ(String request) {
                baseView.show(request);
            }
        });
    }
}