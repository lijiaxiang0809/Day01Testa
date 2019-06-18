package com.example.geeknews.adpater;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chumu.dt.v24.permissions.ChuMuRandomColor;
import com.example.geeknews.R;
import com.example.geeknews.bean.V2exNodeNaviBean;
import com.example.geeknews.widge.FlowLayout;

import java.util.List;

public class RlvV2exAdapter extends RecyclerView.Adapter<RlvV2exAdapter.ViewHolder> {
    private Context mContext;
    private List<V2exNodeNaviBean.DataBean> mList;

    public RlvV2exAdapter(Context context, List<V2exNodeNaviBean.DataBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_node_navi, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        V2exNodeNaviBean.DataBean dataBean = mList.get(i);
        List<V2exNodeNaviBean.DataBean.ArticlesBean> articles = dataBean.getArticles();
        for (int j = 0; j < articles.size(); j++) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_v2ex, null);
            TextView title = inflate.findViewById(R.id.tv_title);
            viewHolder.fl.addView(inflate);
            V2exNodeNaviBean.DataBean.ArticlesBean articlesBean = articles.get(j);
            title.setText(articlesBean.getTitle());
            title.setTextColor(Color.parseColor(ChuMuRandomColor.onRandomColor()));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FlowLayout fl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fl = itemView.findViewById(R.id.fl);
        }
    }
}
