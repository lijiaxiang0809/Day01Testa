package com.example.geeknews.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.geeknews.R;
import com.example.geeknews.adpater.RlvZhiHuHotAdapter;
import com.example.geeknews.adpater.RlvZhiHuNewsAdapter;
import com.example.geeknews.base.BaseMvpFragmetn;
import com.example.geeknews.bean.ZhiHuNewsBean;
import com.example.geeknews.model.ZhiHuModel;
import com.example.geeknews.presenter.ZhiHuPresenter;
import com.example.geeknews.view.ZhihuView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentDatily extends BaseMvpFragmetn<ZhiHuPresenter, ZhiHuModel, ZhihuView> implements ZhihuView {

    @BindView(R.id.rv)
    RecyclerView mRv;
    private ArrayList<ZhiHuNewsBean.StoriesBean> mList;
    private ArrayList<ZhiHuNewsBean.TopStoriesBean> mBanlist;
    private RlvZhiHuNewsAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_datily;
    }

    @Override
    protected ZhihuView initMvpView() {
        return this;
    }

    @Override
    protected ZhiHuModel initMvpModel() {
        return new ZhiHuModel();
    }

    @Override
    protected ZhiHuPresenter initMvpPresenter() {
        return new ZhiHuPresenter();
    }

    @Override
    protected void initView(View inflate) {
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        mBanlist = new ArrayList<>();
        adapter = new RlvZhiHuNewsAdapter(getContext(), mList, mBanlist);
        mRv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        myPresenter.RequestBannerData();
    }

    @Override
    public void onSucceed(ZhiHuNewsBean zhiHuNewsBean) {
        List<ZhiHuNewsBean.StoriesBean> stories = zhiHuNewsBean.getStories();
        mList.addAll(stories);
        adapter.notifyDataSetChanged();
        List<ZhiHuNewsBean.TopStoriesBean> top_stories = zhiHuNewsBean.getTop_stories();
        mBanlist.addAll(top_stories);
        adapter.notifyDataSetChanged();
    }
}
