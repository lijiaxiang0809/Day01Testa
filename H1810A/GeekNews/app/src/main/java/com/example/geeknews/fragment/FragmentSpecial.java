package com.example.geeknews.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.adpater.RlvZhiHuHotAdapter;
import com.example.geeknews.adpater.RlvZhiHuSpecialAdapter;
import com.example.geeknews.base.BaseMvpFragmetn;
import com.example.geeknews.bean.ZhiHuSpecialBean;
import com.example.geeknews.model.ZhiHuSpeciaModel;
import com.example.geeknews.presenter.ZhiHuSpeciaPrsenter;
import com.example.geeknews.view.ZhiHuSpeciaView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentSpecial extends BaseMvpFragmetn<ZhiHuSpeciaPrsenter, ZhiHuSpeciaModel, ZhiHuSpeciaView> implements ZhiHuSpeciaView {

    @BindView(R.id.rv)
    RecyclerView mRv;
    private ArrayList<ZhiHuSpecialBean.DataBean> mList;
    private RlvZhiHuSpecialAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_special;
    }

    @Override
    protected ZhiHuSpeciaView initMvpView() {
        return this;
    }

    @Override
    protected ZhiHuSpeciaModel initMvpModel() {
        return new ZhiHuSpeciaModel();
    }

    @Override
    protected ZhiHuSpeciaPrsenter initMvpPresenter() {
        return new ZhiHuSpeciaPrsenter();
    }

    @Override
    protected void initView(View inflate) {
        mRv.setLayoutManager(new StaggeredGridLayoutManager(2, ViewGroup.SCROLL_AXIS_HORIZONTAL));
        mList = new ArrayList<>();
        mAdapter = new RlvZhiHuSpecialAdapter(getContext(), mList);
        mRv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getRequestData();
    }

    @Override
    public void onSucceed(ZhiHuSpecialBean zhiHuSpecialBean) {
        List<ZhiHuSpecialBean.DataBean> data = zhiHuSpecialBean.getData();
        mList.addAll(data);
        mAdapter.notifyDataSetChanged();
    }
}
