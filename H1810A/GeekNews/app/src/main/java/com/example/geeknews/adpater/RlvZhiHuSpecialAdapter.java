package com.example.geeknews.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.bean.ZhiHuSpecialBean;

import java.util.List;

public class RlvZhiHuSpecialAdapter extends RecyclerView.Adapter<RlvZhiHuSpecialAdapter.ViewHolder> {
    private Context mContext;
    private List<ZhiHuSpecialBean.DataBean> mList;

    public RlvZhiHuSpecialAdapter(Context context, List<ZhiHuSpecialBean.DataBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_zhihu_specical, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZhiHuSpecialBean.DataBean dataBean = mList.get(i);
        viewHolder.mTvDescription.setText(dataBean.getDescription());
        viewHolder.mTvName.setText(dataBean.getName());
        Glide.with(mContext).load(dataBean.getThumbnail()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvDescription;
        TextView mTvName;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            this.mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            this.image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
