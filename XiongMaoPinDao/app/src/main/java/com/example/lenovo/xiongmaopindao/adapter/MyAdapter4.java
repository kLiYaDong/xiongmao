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
import com.example.lenovo.xiongmaopindao.bean.Student2;

import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.Holders> implements View.OnClickListener{
    private List<Student2.ListBean> list;
    private Context mContext;

    public MyAdapter4(List<Student2.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public Holders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment4,parent,false);
        Holders holder = new Holders(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holders holder, int position) {
        Student2.ListBean listBean = list.get(position);
        holder.mName.setText(listBean.getTitle());
        String image = listBean.getImage();
        Glide.with(mContext).load(image).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class Holders extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mName;
        public Holders(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.ImageFIVE);
            mName = (TextView) itemView.findViewById(R.id.NameFIVE);
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
