package com.example.geeknews.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.geeknews.R;
import com.example.geeknews.adpater.FlZhiHuAdapter;
import com.example.geeknews.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;


public class FragmentDailyNews extends BaseFragment {


    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_news;
    }

    @Override
    protected void initView(View inflate) {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new FragmentDatily());
        list.add(new FragmentSpecial());
        list.add(new FragmentHot());
        ArrayList<Integer> title = new ArrayList<>();
        title.add(R.string.daily);
        title.add(R.string.special);
        title.add(R.string.hot);
        FlZhiHuAdapter adapter = new FlZhiHuAdapter(getChildFragmentManager(),getContext(),list,title);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
    }
}
