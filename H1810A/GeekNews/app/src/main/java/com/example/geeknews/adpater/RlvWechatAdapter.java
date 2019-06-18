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
import com.example.geeknews.bean.WechatBean;

import java.util.List;

public class RlvWechatAdapter extends RecyclerView.Adapter<RlvWechatAdapter.ViewHolder> {

    private Context mContext;
    private List<WechatBean.NewslistBean> mList;

    public RlvWechatAdapter(Context context, List<WechatBean.NewslistBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_wechat_rlv, viewGroup,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        WechatBean.NewslistBean newslistBean = mList.get(i);
        viewHolder.mCtime.setText(newslistBean.getCtime());
        viewHolder.mDescription.setText(newslistBean.getDescription());
        viewHolder.mTvTitle.setText(newslistBean.getTitle());
        Glide.with(mContext).load(newslistBean.getPicUrl()).into(viewHolder.mImgLeft);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImgLeft;
        TextView mTvTitle;
        TextView mDescription;
        TextView mCtime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mImgLeft = (ImageView) itemView.findViewById(R.id.img_left);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mDescription = (TextView) itemView.findViewById(R.id.description);
            this.mCtime = (TextView) itemView.findViewById(R.id.ctime);
        }
    }
}
