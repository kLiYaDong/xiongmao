package com.example.lenovo.xiongmaopindao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.bean.Student;
import com.example.lenovo.xiongmaopindao.bean.Student1;

import java.util.List;

/**
 * Created by lenovo on 2017/12/19.
 */
public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.Holderes> implements View.OnClickListener{
    private List<Student1.ListBean> list;
    private Context mContext;

    public MyAdapter3(List<Student1.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public Holderes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment3,parent,false);
        Holderes holderes = new Holderes(view);
        view.setOnClickListener(this);
        return holderes;
    }

    @Override
    public void onBindViewHolder(Holderes holder, int position) {
        Student1.ListBean listBean = list.get(position);
        holder.mName.setText(listBean.getTitle());
        String image = listBean.getImage();
        Glide.with(mContext).load(image).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holderes extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mName;
        public Holderes(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.ImageGun);
            mName = (TextView) itemView.findViewById(R.id.NameGun);
        }
    }
    public interface OnItemSet{
        void onItem(View v,int position);
    }
    private OnItemSet item;
    @Override
    public void onClick(View view) {
        if (item!=null){
            item.onItem(view,(int)view.getTag());
        }
    }
    public void onClick(OnItemSet item){
        this.item = item;
    }
}
