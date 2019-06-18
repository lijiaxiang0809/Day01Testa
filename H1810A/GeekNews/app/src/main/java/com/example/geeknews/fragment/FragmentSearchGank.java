package com.example.geeknews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geeknews.R;
import com.example.geeknews.base.BaseFragment;

import butterknife.BindView;

public class FragmentSearchGank extends BaseFragment {

    @BindView(R.id.tv_show)
    TextView mTvShow;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment_search_gank;
    }

    @Override
    protected void initData() {
        String query = getArguments().getString("query");
        mTvShow.setText(query);
    }
}
