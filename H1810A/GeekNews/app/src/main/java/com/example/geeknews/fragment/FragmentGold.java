package com.example.geeknews.fragment;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.geeknews.GoldDeiltActivity;
import com.example.geeknews.R;
import com.example.geeknews.adpater.VpGoldAdapter;
import com.example.geeknews.base.BaseFragment;
import com.example.geeknews.bean.GoldBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentGold extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.vp)
    ViewPager mVp;
    private ArrayList<FragmentItemGold> mFragmentlist;
    private List<String> mTitle;
    private List<GoldBean> mList;
    private String[] type = new String[]{"后端", "Android", "iOS", "设计", "拓展资源", "产品", "前端", "设计"};
    private VpGoldAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView(View inflate) {
        mList = new ArrayList<>();
        //假tab
        for (int i = 0; i < type.length; i++) {
            String s = type[i];
            if (i % 3 == 0) {
                mList.add(new GoldBean(s, true));
            } else {
                mList.add(new GoldBean(s, false));
            }
        }
        mTitle = new ArrayList<>();
        mFragmentlist = new ArrayList<>();
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mList.size(); i++) {
            GoldBean goldBean = mList.get(i);
            if (goldBean.isSelected()) {
                mFragmentlist.add(new FragmentItemGold(goldBean.getName()));
                mTitle.add(mList.get(i).getName());
            }
        }
        mAdapter = new VpGoldAdapter(getChildFragmentManager(), mFragmentlist, mTitle);
        mVp.setAdapter(mAdapter);
        mTab.setupWithViewPager(mVp);
    }

    @Override
    protected void initListener() {
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GoldDeiltActivity.class);
                intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) mList);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            mList = data.getParcelableArrayListExtra("mList");
            mFragmentlist.clear();
            mTitle.clear();
            initData();
            mAdapter.notifyDataSetChanged();
        }
    }
}
