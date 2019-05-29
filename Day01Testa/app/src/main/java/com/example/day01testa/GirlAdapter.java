package com.example.day01testa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {

    private Context mContext;
    private List<GirlBean.ResultsBean> mList;

    public GirlAdapter(Context context, List<GirlBean.ResultsBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.init_girl, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GirlBean.ResultsBean resultsBean = mList.get(i);
        viewHolder.mTvDesc.setText(resultsBean.getDesc());
        Glide.with(mContext).load(resultsBean.getUrl()).into(viewHolder.mImgLeft);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImgLeft;
        TextView mTvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mImgLeft = (ImageView) itemView.findViewById(R.id.img_left);
            this.mTvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }
}
