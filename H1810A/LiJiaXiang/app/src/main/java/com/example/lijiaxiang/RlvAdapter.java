package com.example.lijiaxiang;

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

public class RlvAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<RootBean> mList;

    public RlvAdapter(Context context, List<RootBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_one, null);
            return new OneViewHolder(inflate);
        } else if (i == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_two, null);
            return new TwoViewHolder(inflate);
        } else if (i == 2) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_three, null);
            return new ThreeViewHolder(inflate);
        } else if (i == 3) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_four, null);
            return new FourViewHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        RootBean rootBean = mList.get(i);
        if (viewHolder instanceof OneViewHolder) {
            OneViewHolder viewHolder1 = (OneViewHolder) viewHolder;
            Glide.with(mContext).load(rootBean.getImage()).into(viewHolder1.mImage);
            viewHolder1.mTvTitle.setText(rootBean.getTitle());
        } else if (viewHolder instanceof TwoViewHolder) {
            TwoViewHolder viewHolder1 = (TwoViewHolder) viewHolder;
            viewHolder1.mTvTitle1.setText(rootBean.getTitle());
            viewHolder1.mTvTitle2.setText(rootBean.getTitle());
            Glide.with(mContext).load(rootBean.getImage()).into(viewHolder1.mImage1);
            Glide.with(mContext).load(rootBean.getImage()).into(viewHolder1.mImage2);
        } else if (viewHolder instanceof ThreeViewHolder) {
            ThreeViewHolder viewHolder1 = (ThreeViewHolder) viewHolder;
            viewHolder1.mTvTitle.setText(rootBean.getTitle());
            Glide.with(mContext).load(rootBean.getImage()).into(viewHolder1.mImage);
        } else if (viewHolder instanceof FourViewHolder) {
            FourViewHolder viewHolder1 = (FourViewHolder) viewHolder;
            viewHolder1.mTvTitle.setText(rootBean.getTitle());
            Glide.with(mContext).load(rootBean.getImage()).into(viewHolder1.mImage);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnitemclick!=null){
                    mOnitemclick.onitem(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        }
        return super.getItemViewType(position);
    }

    public class OneViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle;
        ImageView mImage;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mImage = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public class TwoViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle1;
        TextView mTvTitle2;
        ImageView mImage1;
        ImageView mImage2;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTvTitle1 = (TextView) itemView.findViewById(R.id.tv_title1);
            this.mTvTitle2 = (TextView) itemView.findViewById(R.id.tv_title2);
            this.mImage1 = (ImageView) itemView.findViewById(R.id.img_a);
            this.mImage2 = (ImageView) itemView.findViewById(R.id.img_b);

        }
    }

    public class ThreeViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle;
        ImageView mImage;

        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mImage = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public class FourViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle;
        ImageView mImage;

        public FourViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mImage = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public interface onitemclick {
        void onitem(int position);
    }
    private onitemclick mOnitemclick;

    public void setOnitemclick(onitemclick onitemclick) {
        mOnitemclick = onitemclick;
    }
}
