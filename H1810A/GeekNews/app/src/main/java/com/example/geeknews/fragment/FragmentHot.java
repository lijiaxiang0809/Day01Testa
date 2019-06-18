package com.example.geeknews.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.geeknews.R;
import com.example.geeknews.adpater.RlvZhiHuHotAdapter;
import com.example.geeknews.base.BaseMvpFragmetn;
import com.example.geeknews.bean.ZhihuHotBean;
import com.example.geeknews.model.ZhiHuHotModel;
import com.example.geeknews.presenter.ZhiHuHotPresenter;
import com.example.geeknews.utils.ToastUtil;
import com.example.geeknews.view.ZhiHuHotView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FragmentHot extends BaseMvpFragmetn<ZhiHuHotPresenter, ZhiHuHotModel, ZhiHuHotView> implements ZhiHuHotView {

    @BindView(R.id.rv)
    RecyclerView mRv;
    private ArrayList<ZhihuHotBean.RecentBean> mList;
    private RlvZhiHuHotAdapter adapter;

    @Override
    protected ZhiHuHotView initMvpView() {
        return this;
    }

    @Override
    protected ZhiHuHotModel initMvpModel() {
        return new ZhiHuHotModel();
    }

    @Override
    protected ZhiHuHotPresenter initMvpPresenter() {
        return new ZhiHuHotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        adapter = new RlvZhiHuHotAdapter(getContext(), mList);
        mRv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.RequestData();

    }

    @Override
    public void onSucceed(ZhihuHotBean recentBean) {
        List<ZhihuHotBean.RecentBean> recent = recentBean.getRecent();
        mList.addAll(recent);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onField(String error) {
        ToastUtil.showShort(error);
    }
}
