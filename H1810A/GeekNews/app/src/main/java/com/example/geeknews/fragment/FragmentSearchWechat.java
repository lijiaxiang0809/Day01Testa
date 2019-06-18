package com.example.geeknews.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.geeknews.R;
import com.example.geeknews.adpater.RlvWechatAdapter;
import com.example.geeknews.base.BaseMvpFragmetn;
import com.example.geeknews.bean.WechatBean;
import com.example.geeknews.model.WeChatSearchModel;
import com.example.geeknews.presenter.WeChatSearchPresenter;
import com.example.geeknews.view.WeChatSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentSearchWechat extends BaseMvpFragmetn<WeChatSearchPresenter, WeChatSearchModel, WeChatSearchView> implements WeChatSearchView {

    @BindView(R.id.rv)
    RecyclerView mRv;
    private RlvWechatAdapter mAdapter;
    private ArrayList<WechatBean.NewslistBean> mList;
    String key = "52b7ec3471ac3bec6846577e79f20e4c";
    int num;
    int page;
    private static final String TAG = "FragmentSearchWechat";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_wechat;
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
        String query = getArguments().getString("query");
        myPresenter.RequestData(key, num, page, query);
    }

    @Override
    protected WeChatSearchView initMvpView() {
        return this;
    }

    @Override
    protected WeChatSearchModel initMvpModel() {
        return new WeChatSearchModel();
    }

    @Override
    protected WeChatSearchPresenter initMvpPresenter() {
        return new WeChatSearchPresenter();
    }

    @Override
    public void onField(String error) {
        Log.i(TAG, "onField: " + error);
    }

    @Override
    public void onSucceed(List<WechatBean.NewslistBean> newslistBean) {
        mList.addAll(newslistBean);
        mAdapter.notifyDataSetChanged();
    }
}
