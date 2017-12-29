package com.example.lenovo.xiongmaopindao.sqilts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiongmaopindao.R;

import java.util.List;



/**
 * Created by 丁军明 on 2017/12/26.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private List<MyDuo.LiveBean> live;
    private Context mContext;
    private boolean boo = false;

    public ViewAdapter(List<MyDuo.LiveBean> live, Context mContext) {
        this.live = live;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(mContext).load(live.get(position).getImage()).into(holder.mImg);
        holder.mTitle.setText(live.get(position).getTitle());
        holder.mName.setText(live.get(position).getBrief());
        holder.mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boo) {
                    holder.mName.setVisibility(View.GONE);
                    holder.mBtn.setBackground(mContext.getResources().getDrawable(R.drawable.live_china_detail_down));
                    boo = false;
                } else {
                    holder.mName.setVisibility(View.VISIBLE);
                    holder.mBtn.setBackground(mContext.getResources().getDrawable(R.drawable.live_china_detail_up));
                    boo = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return live.isEmpty() ? 0 : live.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mTitle, mName;
        public Button mBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.Item_img);
            mTitle = (TextView) itemView.findViewById(R.id.Item_Title);
            mName = (TextView) itemView.findViewById(R.id.Item_Content);
            mBtn = (Button) itemView.findViewById(R.id.Item_btn);
        }
    }
}
