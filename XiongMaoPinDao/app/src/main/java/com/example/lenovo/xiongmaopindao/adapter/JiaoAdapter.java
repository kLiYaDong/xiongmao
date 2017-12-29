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
import com.example.lenovo.xiongmaopindao.bean.Jiao;

import java.util.List;

/**
 * Created by lenovo on 2017/12/22.
 */
public class JiaoAdapter extends RecyclerView.Adapter<JiaoAdapter.HolderOne> implements View.OnClickListener{
    private List<Jiao.VideoBean> mList;
    private Context mContext;

    public JiaoAdapter(List<Jiao.VideoBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public HolderOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testfragment,parent,false);
        HolderOne holderOne = new HolderOne(view);
        view.setOnClickListener(this);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(HolderOne holder, int position) {
        Jiao.VideoBean videoBean = mList.get(position);
        holder.mName.setText(videoBean.getT());
        holder.mName1.setText(videoBean.getPtime());
        holder.mName2.setText(videoBean.getLen());
        String img = videoBean.getImg();
        Glide.with(mContext).load(img).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{
        private TextView mName,mName1,mName2;
        private ImageView mImage;
        public HolderOne(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.NameAdapter);
            mName1 = (TextView) itemView.findViewById(R.id.textView2);
            mName2 = (TextView) itemView.findViewById(R.id.TExtJiao);
            mImage = (ImageView) itemView.findViewById(R.id.ImageAdapter);
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
