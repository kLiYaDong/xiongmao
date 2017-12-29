package com.example.lenovo.xiongmaopindao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.ArrayList;

public class Main7Activity extends AppCompatActivity {
    private NiceVideoPlayer niceVideoPlayer;
//    private ArrayList<String> mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        init();
    }
    private void init() {
//        mList.add("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4");
        niceVideoPlayer = (NiceVideoPlayer) findViewById(R.id.NiceVideoPlayer);
        niceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK);
        niceVideoPlayer.setUp("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", null);

        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle("大熊猫");
        controller.setImage(R.drawable.back);
        niceVideoPlayer.setController(controller);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在 onStop 时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }
    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在 Activity 中 onBackPress 要交给 NiceVideoPlayer 先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
}
