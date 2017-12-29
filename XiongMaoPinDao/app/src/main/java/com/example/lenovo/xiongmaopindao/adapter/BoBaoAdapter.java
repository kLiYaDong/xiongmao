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
import com.example.lenovo.xiongmaopindao.bean.BoBao;
import com.example.lenovo.xiongmaopindao.bean.XiongMaoBoBao;

import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public class BoBaoAdapter extends RecyclerView.Adapter<BoBaoAdapter.HolderOne> implements View.OnClickListener{
    private List<XiongMaoBoBao.ListBean> list;
    private Context mContext;

    public BoBaoAdapter(List<XiongMaoBoBao.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public HolderOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gunaan,parent,false);
        HolderOne holderOne = new HolderOne(view);
        view.setOnClickListener(this);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(HolderOne holder, int position) {
        XiongMaoBoBao.ListBean listBean = list.get(position);
        holder.mNmae.setText(listBean.getTitle());
        String picurl = listBean.getPicurl();
        Glide.with(mContext).load(picurl).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mNmae;
        public HolderOne(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.ImageGun);
            mNmae = (TextView) itemView.findViewById(R.id.NameGuns);
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
