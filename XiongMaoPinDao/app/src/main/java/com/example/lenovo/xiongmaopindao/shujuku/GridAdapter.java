package com.example.lenovo.xiongmaopindao.shujuku;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.sqilts.TablistBean;

import java.util.List;



/**
 * Created by lenovo on 2017/12/7.
 */

public class GridAdapter extends BaseAdapter{
    private List<TablistBean> list;
    private Context context;

    public GridAdapter(List<TablistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.xmlist, null);
        TextView tex_1=(TextView)view.findViewById(R.id.tex_1);
        tex_1.setText(list.get(i).getTitle());
        return view;
    }
}
