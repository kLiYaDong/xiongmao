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
import com.example.lenovo.xiongmaopindao.bean.Student5;
import java.util.List;
/**
 * Created by lenovo on 2017/12/20.
 */
public class ZhiBoAdapter1 extends RecyclerView.Adapter<ZhiBoAdapter1.HolderOne> {
    private List<Student5.ListBean> mList;
    private Context mContext;

    public ZhiBoAdapter1(List<Student5.ListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public HolderOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zhiframgnet,parent,false);
        HolderOne holderOne = new HolderOne(view);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(HolderOne holder, int position) {
        Student5.ListBean listBean = mList.get(position);
        holder.mNmae.setText(listBean.getTitle());
        String image = listBean.getImage();
        Glide.with(mContext).load(image).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{
        private ImageView mImage;
        private TextView mNmae;
        public HolderOne(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.ImageZhi);
            mNmae = (TextView) itemView.findViewById(R.id.NameZhi);
        }
    }
}
