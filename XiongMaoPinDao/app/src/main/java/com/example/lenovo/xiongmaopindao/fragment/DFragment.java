package com.example.lenovo.xiongmaopindao.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.lenovo.xiongmaopindao.AlllistBeanDao;
import com.example.lenovo.xiongmaopindao.MainZgActivity;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.TablistBeanDao;
import com.example.lenovo.xiongmaopindao.adapter.ChildAdapter;
import com.example.lenovo.xiongmaopindao.app.App;
import com.example.lenovo.xiongmaopindao.base.BaseFragment;
import com.example.lenovo.xiongmaopindao.bean.ChilaStudent;
import com.example.lenovo.xiongmaopindao.login.LoginContract;
import com.example.lenovo.xiongmaopindao.login.LoginModel;
import com.example.lenovo.xiongmaopindao.login.LoginPresenter;
import com.example.lenovo.xiongmaopindao.shujuku.BaseZg;
import com.example.lenovo.xiongmaopindao.shujuku.FragmentTabAdapter;
import com.example.lenovo.xiongmaopindao.shujuku.GreenDAo;
import com.example.lenovo.xiongmaopindao.sqilts.AlllistBean;
import com.example.lenovo.xiongmaopindao.sqilts.TablistBean;
import com.example.lenovo.xiongmaopindao.sqilts.TongYFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2017/12/19.
 */
public class DFragment extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View{
    private TabLayout zg_tab;
    private ImageView zg_imge;
    private ViewPager zg_pager;
    private ArrayList<Fragment> listfragmennt = new ArrayList<>();
    private ArrayList<String> lists = new ArrayList<>();
    private AlllistBeanDao dao;
    private TablistBeanDao daos;
    private String title;
    private String titles;
    private FrameLayout zg_fragment;
    @Override
    protected void intiData() {
        mPresenter.loginData( "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");
        zg_imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentBulider.getInstance().init().add(R.id.zg_fragment, DuoFragment.class, false).Builder();
                startActivity(new Intent(getActivity(), MainZgActivity.class));
            }
        });
    }

    @Override
    protected void initView(View view) {
//        App.baseActivity.mImage_yuan.setVisibility(View.GONE);
//        App.baseActivity.mImage_pin.setVisibility(View.GONE);
//        App.baseActivity.mTextZhu.setVisibility(View.GONE);
//        App.baseActivity.mImage_login.setVisibility(View.VISIBLE);
//        App.baseActivity.mTitle.setText("直播中国");
        //----------------------------------
        zg_tab = (TabLayout) view.findViewById(R.id.zg_tab);
        zg_imge = (ImageView) view.findViewById(R.id.zg_imge);
        zg_pager = (ViewPager) view.findViewById(R.id.zg_pager);
        zg_fragment = (FrameLayout) view.findViewById(R.id.zg_fragment);
        dao = GreenDAo.getTan(getActivity()).getDao();
        daos = GreenDAo.getTan(getActivity()).getDaos();
        zg_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mPresenter.loginData( "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");
    }
    @Override
    public void onStart() {
        super.onStart();
        mPresenter.loginData( "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");
        //Toast.makeText(getActivity(), "aaa", Toast.LENGTH_SHORT).show();
//        mPresenter.presenter_Method(0, "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");
    }
    @Override
    protected int setLayoutId() {
        return R.layout.fragment5;
    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        List<TablistBean> tablist = daos.queryBuilder().list();
        if (tablist.size() > 0 && tablist != null) {
            ArrayList<Fragment> tabfragment = new ArrayList<>();
            ArrayList<String> tablists = new ArrayList<>();
            for (int i = 0; i < tablist.size(); i++) {
                String title = tablist.get(i).getTitle();
                tablists.add(title);
                String url1 = tablist.get(i).getUrl();

                TongYFragment tongYFragment =TongYFragment.newInstance(url1);
                tabfragment.add(tongYFragment);

            }
            FragmentTabAdapter fragmentTabAdapter = new FragmentTabAdapter(getActivity().getSupportFragmentManager(), tabfragment, tablists);
            zg_pager.setAdapter(fragmentTabAdapter);
            zg_tab.setupWithViewPager(zg_pager);
        } else {
            ArrayList<Fragment> tab = new ArrayList<>();
            ArrayList<String> tabs= new ArrayList<>();
            BaseZg baseZg = gson.fromJson(url, BaseZg.class);
            List<TablistBean> tablist1 = baseZg.getTablist();
            for (int i = 0; i < tablist1.size(); i++) {
                String title = tablist1.get(i).getTitle();
                tabs.add(title);
                String url1 = tablist1.get(i).getUrl();
                TongYFragment tongYFragment =TongYFragment.newInstance(url1);
                tab.add(tongYFragment);
            }
            FragmentTabAdapter fragmentTabAdapter = new FragmentTabAdapter(getActivity().getSupportFragmentManager(), tab, tabs);
            zg_pager.setAdapter(fragmentTabAdapter);
            zg_tab.setupWithViewPager(zg_pager);
            daos.insertInTx(tablist1);
            BaseZg baseZgs = gson.fromJson(url, BaseZg.class);
            List<AlllistBean> alllist = baseZgs.getAlllist();
            alllist.removeAll(tablist1);
            dao.insertInTx(alllist);
        }
    }
}
