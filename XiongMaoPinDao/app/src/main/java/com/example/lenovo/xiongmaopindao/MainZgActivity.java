package com.example.lenovo.xiongmaopindao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.xiongmaopindao.shujuku.DragGridView;
import com.example.lenovo.xiongmaopindao.shujuku.GreenDAo;
import com.example.lenovo.xiongmaopindao.shujuku.GridAdapter;
import com.example.lenovo.xiongmaopindao.shujuku.GridsAdapter;
import com.example.lenovo.xiongmaopindao.sqilts.AlllistBean;
import com.example.lenovo.xiongmaopindao.sqilts.TablistBean;

import java.util.Collections;
import java.util.List;



public class MainZgActivity extends AppCompatActivity {
    private ImageView zg_duoimge;
    private TablistBeanDao tabdao;
    private AlllistBeanDao alldao;
    private DragGridView tabrecy;
    private DragGridView allrecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_zg);
        initView();
        initData();
    }

    private void initData() {
        zg_duoimge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(1,intent);
                finish();
            }

        });
        initDian();
    }

    private void initDian() {
        final List<TablistBean> list = tabdao.queryBuilder().list();
        final GridAdapter gridAdapter = new GridAdapter(list, this);
        tabrecy.setAdapter(gridAdapter);

        final List<AlllistBean> lists = alldao.queryBuilder().list();
        final GridsAdapter gridsAdapter = new GridsAdapter(lists,this);
        allrecy.setAdapter(gridsAdapter);
        if (list!=null) {
            tabrecy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   if (list.size() > 4){
                       String title = list.get(i).getTitle();
                       String url = list.get(i).getUrl();
                       AlllistBean alllistBean = new AlllistBean();
                       alllistBean.setTitle(title);
                       alllistBean.setUrl(url);
                       alldao.insert(alllistBean);
                       lists.add(alllistBean);


                       tabdao.delete(list.get(i));
                       list.remove(i);
                       gridAdapter.notifyDataSetChanged();
                       gridsAdapter.notifyDataSetChanged();
                   }else{
                       Toast.makeText(MainZgActivity.this, "栏目区不能少于4个频道", Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }
        if (lists != null) {
            allrecy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String title = lists.get(i).getTitle();
                    String url = lists.get(i).getUrl();
                    TablistBean tablistBean = new TablistBean();
                    tablistBean.setTitle(title);
                    tablistBean.setUrl(url);
                    tabdao.insert(tablistBean);
                    list.add(tablistBean);


                    alldao.delete(lists.get(i));
                    lists.remove(i);
                    gridAdapter.notifyDataSetChanged();
                    gridsAdapter.notifyDataSetChanged();
                }
            });
        }
        tabrecy.setOnChangeListener(new DragGridView.OnChanageListener() {
            @Override
            public void onChange(int form, int to) {
                TablistBean tablistBean = list.get(form);
                if (form < to) {
                    for (int i = form; i < to; i++) {
                        Collections.swap(list, i, i + 1);
                    }
                } else if (form > to) {
                    for (int i = form; i > to; i--) {
                        Collections.swap(list, i, i - 1);
                    }
                }
                list.set(to, tablistBean);
                gridAdapter.notifyDataSetChanged();
            }
        });
        allrecy.setOnChangeListener(new DragGridView.OnChanageListener() {
            @Override
            public void onChange(int form, int to) {
                AlllistBean alllistBean = lists.get(form);
                if (form < to) {
                    for (int i = form; i < to; i++) {
                        Collections.swap(lists, i, i + 1);
                    }
                } else if (form > to) {
                    for (int i = form; i > to; i--) {
                        Collections.swap(lists, i, i - 1);
                    }
                }
                lists.set(to, alllistBean);
                gridsAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        zg_duoimge = (ImageView) findViewById(R.id.zg_duoimge);
        tabrecy = (DragGridView) findViewById(R.id.zg_duorecy);
        allrecy = (DragGridView) findViewById(R.id.zg_duorecys);
        tabdao = GreenDAo.getTan(this).getDaos();
        alldao = GreenDAo.getTan(this).getDao();
    }
}
