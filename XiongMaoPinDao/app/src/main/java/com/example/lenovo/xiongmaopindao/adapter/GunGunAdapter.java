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
import com.example.lenovo.xiongmaopindao.bean.GunGun;

import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public class GunGunAdapter extends RecyclerView.Adapter<GunGunAdapter.HolderOne> implements View.OnClickListener{
    private List<GunGun.ListBean> list;
    private Context mContext;

    public GunGunAdapter(List<GunGun.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public HolderOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gungun,parent,false);
        HolderOne holderOne = new HolderOne(view);
        view.setOnClickListener(this);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(HolderOne holder, int position) {
        GunGun.ListBean listBean = list.get(position);
        holder.mNmae.setText(listBean.getTitle());
        holder.mNamee1.setText(listBean.getBrief());
        holder.mName2.setText(listBean.getVideoLength());
        String image = listBean.getImage();
        Glide.with(mContext).load(image).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mNmae,mNamee1,mName2;
        public HolderOne(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.ImageGun);
            mNmae = (TextView) itemView.findViewById(R.id.NameGuns);
            mNamee1 = (TextView) itemView.findViewById(R.id.NameGuns1);
            mName2 = (TextView) itemView.findViewById(R.id.Nameser);

        }
    }
    public interface OnSetItem{
        void onItem(View v,int position);
    }
    private OnSetItem item;
    @Override
    public void onClick(View view) {
        if (item!=null){
            item.onItem(view,(int)view.getTag());
        }
    }
    public void onClick(OnSetItem item){
        this.item = item;
    }
}
