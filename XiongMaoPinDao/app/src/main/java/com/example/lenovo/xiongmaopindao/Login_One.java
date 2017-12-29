package com.example.lenovo.xiongmaopindao;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

//登录页面
public class Login_One extends AppCompatActivity implements View.OnClickListener {

    private Button button_login;
    private ImageView Weichat;
    private ImageView QQ;
    private ImageView Weibo;
    private ImageView Back_Login;
    private EditText edittext_login_user;
    private EditText edittext_login_pwd;

    /**
     * 登录页面
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {

        button_login = (Button) findViewById(R.id.button_login);
        Back_Login = (ImageView) findViewById(R.id.Back_Login);
        button_login.setOnClickListener(this);
        Weichat = (ImageView) findViewById(R.id.Weichat);
        Weichat.setOnClickListener(this);
        QQ = (ImageView) findViewById(R.id.QQ);
        QQ.setOnClickListener(this);
        Weibo = (ImageView) findViewById(R.id.Weibo);
        Weibo.setOnClickListener(this);
        Back_Login = (ImageView) findViewById(R.id.Back_Login);
        Back_Login.setOnClickListener(this);

        edittext_login_user = (EditText) findViewById(R.id.edittext_login_user);
        edittext_login_user.setOnClickListener(this);
        edittext_login_pwd = (EditText) findViewById(R.id.edittext_login_pwd);
        edittext_login_pwd.setOnClickListener(this);
    }

    //第三方那个登陆  QQ  微信  还有微博
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Back_Login:
                finish();
                break;
            case R.id.QQ:
                UMAuthListener authListener = new UMAuthListener() {
                    /**
                     * @desc 授权开始的回调
                     * @param platform 平台名称
                     */
                    @Override
                    public void onStart(SHARE_MEDIA platform) {
                    }

                    /**
                     * @desc 授权成功的回调
                     * @param platform 平台名称
                     * @param action 行为序号，开发者用不上
                     * @param data 用户资料返回
                     */
                    @Override
                    public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

                        Toast.makeText(Login_One.this, "成功了", Toast.LENGTH_LONG).show();

                        String screen_name = data.get("uid");
                        edittext_login_user.setText(screen_name);
                        Log.e("one", screen_name);
                    }

                    /**
                     * @desc 授权失败的回调
                     * @param platform 平台名称
                     * @param action 行为序号，开发者用不上
                     * @param t 错误原因
                     */
                    @Override
                    public void onError(SHARE_MEDIA platform, int action, Throwable t) {

                        Toast.makeText(Login_One.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    /**
                     * @desc 授权取消的回调
                     * @param platform 平台名称
                     * @param action 行为序号，开发者用不上
                     */
                    @Override
                    public void onCancel(SHARE_MEDIA platform, int action) {

                        Toast.makeText(Login_One.this, "取消了", Toast.LENGTH_LONG).show();
                    }
                };
                UMShareAPI mShareAPI = UMShareAPI.get(Login_One.this);
                mShareAPI.doOauthVerify(Login_One.this, SHARE_MEDIA.QQ, authListener);


                break;


            case R.id.Weichat:

                break;


            case R.id.Weibo:

                break;
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

    }

}
