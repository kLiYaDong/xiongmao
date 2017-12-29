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

import java.util.List;

/**
 * Created by lenovo on 2017/12/19.
 */
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Holder> implements View.OnClickListener{
    private List<Student.DataBean.PandaliveBean.ListBean> list;
    private Context mContext;

    public MyAdapter2(List<Student.DataBean.PandaliveBean.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment1,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Student.DataBean.PandaliveBean.ListBean listBean = list.get(position);
        holder.mNmae.setText(listBean.getTitle());
        String image = listBean.getImage();
        Glide.with(mContext).load(image).into(holder.mImgae);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ImageView  mImgae;
        private TextView mNmae;
        public Holder(View itemView) {
            super(itemView);
            mImgae = (ImageView) itemView.findViewById(R.id.Image1);
            mNmae = (TextView) itemView.findViewById(R.id.Name1s);
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
