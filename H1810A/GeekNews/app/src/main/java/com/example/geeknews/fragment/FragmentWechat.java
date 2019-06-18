package com.example.geeknews.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.geeknews.R;
import com.example.geeknews.adpater.RlvWechatAdapter;
import com.example.geeknews.base.BaseMvpFragmetn;
import com.example.geeknews.bean.WechatBean;
import com.example.geeknews.model.WechatModel;
import com.example.geeknews.presenter.WechatPresenter;
import com.example.geeknews.view.WechatView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentWechat extends BaseMvpFragmetn<WechatPresenter, WechatModel, WechatView> implements WechatView {

    @BindView(R.id.rv)
    RecyclerView mRv;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    private ArrayList<WechatBean.NewslistBean> mList;
    private RlvWechatAdapter mAdapter;
    String key = "52b7ec3471ac3bec6846577e79f20e4c";
    int num = 10;
    int page = 1;
    private static final String TAG = "FragmentWechat";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView(View inflate) {
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        mAdapter = new RlvWechatAdapter(getContext(), mList);
        mRv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        myPresenter.RequestData(key, num, page);
    }

    @Override
    protected void initListener() {

        mSrl.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                initData();
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                mList.clear();
                initData();
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected WechatView initMvpView() {
        return this;
    }

    @Override
    protected WechatModel initMvpModel() {
        return new WechatModel();
    }

    @Override
    protected WechatPresenter initMvpPresenter() {
        return new WechatPresenter();
    }

    @Override
    public void onField(String error) {
        Log.i(TAG, "onField: " + error);
    }

    @Override
    public void onSucceed(List<WechatBean.NewslistBean> newslistBeans) {
        mList.addAll(newslistBeans);
        mSrl.finishLoadmore();
        mSrl.finishRefresh();
        mAdapter.notifyDataSetChanged();
    }
}
