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
import com.example.geeknews.bean.ZhiHuNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class RlvZhiHuNewsAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<ZhiHuNewsBean.StoriesBean> mList;
    private List<ZhiHuNewsBean.TopStoriesBean> banList;

    public RlvZhiHuNewsAdapter(Context context, List<ZhiHuNewsBean.StoriesBean> list, List<ZhiHuNewsBean.TopStoriesBean> banList) {
        mContext = context;
        mList = list;
        this.banList = banList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_zhihu_news_banner, null);
            return new BanViewHolder(inflate);
        } else if (i == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_zhihu_news_text, null);
            return new TextViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_zhihu_news_rlv, viewGroup, false);
            return new RlvViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BanViewHolder) {
            BanViewHolder viewHolder1 = (BanViewHolder) viewHolder;
            viewHolder1.mBan.setImages(banList).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    ZhiHuNewsBean.TopStoriesBean path1 = (ZhiHuNewsBean.TopStoriesBean) path;
                    Glide.with(mContext).load(path1.getImage()).into(imageView);
                }
            }).start();
        } else if (viewHolder instanceof RlvViewHolder) {
            int position = i - 1;
            if (banList.size() > 0) {
                position -= 1;
            }
            ZhiHuNewsBean.StoriesBean storiesBean = mList.get(position);
            RlvViewHolder viewHolder1 = (RlvViewHolder) viewHolder;
            viewHolder1.mTv_title.setText(storiesBean.getTitle());
            Glide.with(mContext).load(storiesBean.getImages().get(0)).into(viewHolder1.mImg_left);
        }else if (viewHolder instanceof TextViewHolder){
            TextViewHolder viewHolder1 = (TextViewHolder) viewHolder;
            viewHolder1.mTv_title.setText("今日热文");
        }
    }

    @Override
    public int getItemCount() {
        if (banList.size() > 0) {
            return mList.size() + 2;
        } else {
            return mList.size() + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (banList.size() > 0) {
            if (position == 0) {
                return 0;
            } else if (position == 1) {
                return 1;
            } else {
                return 2;
            }
        } else {
            if (position == 0) {
                return 1;
            } else {
                return 2;
            }
        }
    }
    public class BanViewHolder extends RecyclerView.ViewHolder {

        private final Banner mBan;

        public BanViewHolder(@NonNull View itemView) {
            super(itemView);
            mBan = itemView.findViewById(R.id.ban);
        }
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTv_title;
        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv_title = itemView.findViewById(R.id.tv_title);
        }
    }

    public class RlvViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv_title;
        private final ImageView mImg_left;

        public RlvViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv_title = itemView.findViewById(R.id.tv_title);
            mImg_left = itemView.findViewById(R.id.img_left);
        }
    }


}
