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
public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.Holder> implements View.OnClickListener{
    private List<Student.DataBean.ChinaliveBean.ListBeanX> list;
    private Context mContext;

    public MyAdapter1(List<Student.DataBean.ChinaliveBean.ListBeanX> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment2,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Student.DataBean.ChinaliveBean.ListBeanX listBeanX = list.get(position);
        holder.mNmae.setText(listBeanX.getTitle());
        String image = listBeanX.getImage();
        Glide.with(mContext).load(image).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mNmae;
        public Holder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.ImageJing);
            mNmae = (TextView) itemView.findViewById(R.id.NameJIng);
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
