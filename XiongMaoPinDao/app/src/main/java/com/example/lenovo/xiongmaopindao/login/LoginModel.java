package com.example.lenovo.xiongmaopindao.login;

import com.example.lenovo.xiongmaopindao.app.App;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by TMVPHelper on 2017/12/18
 */
public class LoginModel implements LoginContract.Model {
    public static volatile LoginModel loginModel;
    public OkHttpClient okHttpClient;
    private Set<String> keys;
    private String str = "";

    public static LoginModel getLoginModel() {
        if (loginModel == null) {
            synchronized (LoginModel.class) {
                loginModel = new LoginModel();
            }
        }
        return loginModel;
    }

    public LoginModel() {
        okHttpClient = new OkHttpClient();
    }

    @Override
    public void getData(String url, final CallBacks callBacks) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String name = response.body().string();
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBacks.succ(name);
                    }
                });
            }
        });
    }

    @Override
    public void setData(String url, Map<String, Object> map, final CallBacks callBacks) {
        StringBuffer sb = new StringBuffer(url);
        str = "";
        if (map != null && map.size() > 0) {
            sb.append("?");
            keys = map.keySet();
            for (String key : keys) {
                Object valuey = map.get(key);
                sb.append(key).append("=").append(valuey).append("&");
            }
            str = sb.deleteCharAt(sb.length() - 1).toString();
        }

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String name = response.body().string();
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBacks.succ(name);
                    }
                });
            }
        });
    }
}