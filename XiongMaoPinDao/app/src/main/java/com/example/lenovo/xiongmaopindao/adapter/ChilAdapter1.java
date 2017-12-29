package com.example.lenovo.xiongmaopindao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiongmaopindao.R;
import com.example.lenovo.xiongmaopindao.bean.Childa1;

import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public class ChilAdapter1 extends RecyclerView.Adapter<ChilAdapter1.HolderOne> {
    private List<Childa1.LiveBean> list;
    private Context mContext;

    public ChilAdapter1(List<Childa1.LiveBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public HolderOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dfragment,parent,false);
        HolderOne holderOne = new HolderOne(view);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(HolderOne holder, int position) {
        Childa1.LiveBean liveBean = list.get(position);
        holder.mName.setText("[正在直播]"+liveBean.getTitle());
        holder.mName1.setText(liveBean.getBrief());
        String image = liveBean.getImage();
        Glide.with(mContext).load(image).into(holder.mImage);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class HolderOne extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mName,mName1;
        public HolderOne(View itemView){
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.Image5);
            mName = (TextView) itemView.findViewById(R.id.Name5);
            mName1 = (TextView) itemView.findViewById(R.id.Name7);
        }
    }
}
