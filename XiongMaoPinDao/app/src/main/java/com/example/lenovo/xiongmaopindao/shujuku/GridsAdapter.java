package com.example.lenovo.xiongmaopindao.shujuku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.sqilts.AlllistBean;

import java.util.List;



/**
 * Created by lenovo on 2017/12/7.
 */

public class GridsAdapter extends BaseAdapter {
    private List<AlllistBean> list;
    private Context context;

    public GridsAdapter(List<AlllistBean> list, Context context) {
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
        view = LayoutInflater.from(context).inflate(R.layout.xmlists, null);
        TextView tex_2=(TextView)view.findViewById(R.id.tex_2);
        tex_2.setText(list.get(i).getTitle());
        return view;
    }
}
