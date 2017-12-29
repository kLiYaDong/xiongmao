package com.example.lenovo.xiongmaopindao.testcount;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.xiongmaopindao.R;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by lvxinxin on 2017/10/29.
 */

public class TestCountActivity extends Activity {
    private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        mText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(TestCountActivity.this, "heheda", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("sdf","dsfsfd");
        MobclickAgent.onPageStart("TestCountActivity");
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        Log.e("onPause","onPause");
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
