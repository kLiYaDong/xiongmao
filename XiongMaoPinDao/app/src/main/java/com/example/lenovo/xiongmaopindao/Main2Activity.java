package com.example.lenovo.xiongmaopindao;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.xiongmaopindao.base.BaseActivity;
import com.example.lenovo.xiongmaopindao.bean.Mao;
import com.example.lenovo.xiongmaopindao.fragment.AFragment;
import com.example.lenovo.xiongmaopindao.fragment.BFragment;
import com.example.lenovo.xiongmaopindao.fragment.CFragment;
import com.example.lenovo.xiongmaopindao.fragment.DFragment;
import com.example.lenovo.xiongmaopindao.fragment.FragmentTest;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;

public class Main2Activity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View{
    private boolean isQuit = false;
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTest fragmentTest;
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private DFragment dFragment;
    private RadioButton mBut,mBut1,mBut2,mBut3,mBut4;
    private Mao mao;
    @Override
    protected void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        mBut = (RadioButton) radioGroup.findViewById(R.id.RadioButton);
        mBut1 = (RadioButton) radioGroup.findViewById(R.id.RadioButton1);
        mBut2 = (RadioButton) radioGroup.findViewById(R.id.RadioButton2);
        mBut3 = (RadioButton) radioGroup.findViewById(R.id.RadioButton3);
        mBut4 = (RadioButton) radioGroup.findViewById(R.id.RadioButton4);

        fragmentTest = new FragmentTest();
        aFragment = new AFragment();
        bFragment = new BFragment();
        cFragment = new CFragment();
        dFragment = new DFragment();
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayout,fragmentTest);
        fragmentTransaction.commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.RadioButton:
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.FrameLayout,fragmentTest);
                        fragmentTransaction.commit();
                        break;
                    case R.id.RadioButton1:
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                        fragmentTransaction1.replace(R.id.FrameLayout,aFragment);
                        fragmentTransaction1.commit();
                        break;
                    case R.id.RadioButton2:
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.FrameLayout,bFragment);
                        fragmentTransaction2.commit();
                        break;
                    case R.id.RadioButton3:
                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        fragmentTransaction3.replace(R.id.FrameLayout,cFragment);
                        fragmentTransaction3.commit();
                        break;
                    case R.id.RadioButton4:
                        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
                        fragmentTransaction4.replace(R.id.FrameLayout,dFragment);
                        fragmentTransaction4.commit();
                        break;
                }
            }
        });
        mPresenter.loginData("http://www.ipanda.com/kehuduan/dibubiaoqian/index.json");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        mao = gson.fromJson(url, Mao.class);
        mBut.setText(mao.getTab().get(0).getTitle());
        mBut1.setText(mao.getTab().get(1).getTitle());
        mBut2.setText(mao.getTab().get(2).getTitle());
        mBut3.setText(mao.getTab().get(3).getTitle());
        mBut4.setText(mao.getTab().get(4).getTitle());
    }

    @Override
    public void onBackPressed() {
        if (!isQuit){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            isQuit = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        isQuit = false;
                    }
                }
            }).start();
        }else {
            System.exit(0);
        }
    }
}
