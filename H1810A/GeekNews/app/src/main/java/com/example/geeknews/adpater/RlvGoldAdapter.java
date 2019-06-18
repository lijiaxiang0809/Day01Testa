package com.example.geeknews.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.geeknews.R;
import com.example.geeknews.bean.GoldBean;
import com.example.geeknews.callback.TouchCallBack;

import java.util.Collections;
import java.util.List;

public class RlvGoldAdapter extends RecyclerView.Adapter<RlvGoldAdapter.ViewHolder> implements TouchCallBack {

    private Context mContext;
    private List<GoldBean> mList;

    public RlvGoldAdapter(Context context, List<GoldBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_gold_rlv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final GoldBean goldBean = mList.get(i);
        viewHolder.mTvName.setText(goldBean.getName());
        viewHolder.mSc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               goldBean.setSelected(isChecked);
            }
        });
        viewHolder.mSc.setChecked(goldBean.isSelected());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SwitchCompat mSc;
        TextView mTvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mSc = (SwitchCompat) itemView.findViewById(R.id.sc);
            this.mTvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
