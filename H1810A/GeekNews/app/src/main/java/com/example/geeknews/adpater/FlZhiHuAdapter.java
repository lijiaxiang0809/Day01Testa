package com.example.geeknews.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FlZhiHuAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<Fragment> mList;
    private List<Integer> title;

    public FlZhiHuAdapter(FragmentManager fm, Context context, List<Fragment> list, List<Integer> title) {
        super(fm);
        mContext = context;
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
        return mContext.getResources().getString(title.get(position));
    }
}
