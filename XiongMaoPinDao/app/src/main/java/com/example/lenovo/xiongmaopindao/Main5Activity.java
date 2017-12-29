package com.example.lenovo.xiongmaopindao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.xiongmaopindao.adapter.JieQiAdapter;
import com.example.lenovo.xiongmaopindao.base.BaseActivity;
import com.example.lenovo.xiongmaopindao.bean.JieQi;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.google.gson.Gson;

import java.util.List;

public class Main5Activity extends BaseActivity<LoginPresenter,LoginModel> implements LoginContract.View {
    private RecyclerView recyclerView;

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerActivity5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Main5Activity.this);
        recyclerView.setLayoutManager(layoutManager);

        mPresenter.loginData("http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main5;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        JieQi jieQi = gson.fromJson(url, JieQi.class);
        final List<JieQi.InteractiveBean> interactive = jieQi.getInteractive();
        JieQiAdapter jieqiadapter = new JieQiAdapter(interactive,Main5Activity.this);
        recyclerView.setAdapter(jieqiadapter);
        jieqiadapter.onClick(new JieQiAdapter.OnItemSet() {
            @Override
            public void onItem(View v, int position) {
                JieQi.InteractiveBean interactiveBean = interactive.get(position);
                Intent intent = new Intent(Main5Activity.this,Main4Activity.class);
                intent.putExtra("name",interactiveBean.getUrl());
                startActivity(intent);
            }
        });
    }
}
