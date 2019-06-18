package com.example.geeknews.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.geeknews.R;
import com.example.geeknews.V2exActivity;
import com.example.geeknews.base.BaseFragment;

import butterknife.BindView;

public class FragmentV2ex extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.vp)
    ViewPager mVp;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2ex;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected void initListener() {
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), V2exActivity.class));
            }
        });
    }
}
