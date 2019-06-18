package com.example.geeknews.adpater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.geeknews.bean.GoldBean;
import com.example.geeknews.fragment.FragmentItemGold;

import java.util.ArrayList;
import java.util.List;

public class VpGoldAdapter extends FragmentPagerAdapter {
    private List<FragmentItemGold> mList;
    private List<String> title;

    public VpGoldAdapter(FragmentManager fm, List<FragmentItemGold> list, List<String> title) {
        super(fm);
        mList = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
