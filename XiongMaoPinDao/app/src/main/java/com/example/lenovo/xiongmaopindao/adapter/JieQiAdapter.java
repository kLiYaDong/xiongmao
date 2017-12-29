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
import com.example.lenovo.xiongmaopindao.bean.JieQi;

import java.util.List;

/**
 * Created by lenovo on 2017/12/22.
 */
public class JieQiAdapter extends RecyclerView.Adapter<JieQiAdapter.Holders> implements View.OnClickListener{
    private List<JieQi.InteractiveBean> mList;
    private Context mContext;

    public JieQiAdapter(List<JieQi.InteractiveBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public Holders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jieqi,parent,false);
        Holders holders = new Holders(view);
        view.setOnClickListener(this);
        return holders;
    }

    @Override
    public void onBindViewHolder(Holders holder, int position) {
        JieQi.InteractiveBean interactiveBean = mList.get(position);
        holder.mNmae.setText(interactiveBean.getTitle());
        String image = interactiveBean.getImage();
        Glide.with(mContext).load(image).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class Holders extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mNmae;
        public Holders(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.ImageJieQi);
            mNmae = (TextView) itemView.findViewById(R.id.NameJieQi);
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
