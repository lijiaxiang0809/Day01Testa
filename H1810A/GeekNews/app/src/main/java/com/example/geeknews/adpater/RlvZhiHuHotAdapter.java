package com.example.geeknews.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.bean.ZhihuHotBean;

import java.util.List;

public class RlvZhiHuHotAdapter extends RecyclerView.Adapter<RlvZhiHuHotAdapter.ViewHolder> {

    private Context mContext;
    private List<ZhihuHotBean.RecentBean> mList;

    public RlvZhiHuHotAdapter(Context context, List<ZhihuHotBean.RecentBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_zhihuhot, viewGroup,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZhihuHotBean.RecentBean recentBean = mList.get(i);
        viewHolder.mTvTitle.setText(recentBean.getTitle());
        Glide.with(mContext).load(recentBean.getThumbnail()).into(viewHolder.mImgLeft);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImgLeft;
        TextView mTvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mImgLeft = (ImageView) itemView.findViewById(R.id.img_left);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

}
