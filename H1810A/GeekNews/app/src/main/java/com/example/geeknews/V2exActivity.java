package com.example.geeknews;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.geeknews.adpater.RlvV2exAdapter;
import com.example.geeknews.base.BaseMvpActivity;
import com.example.geeknews.bean.V2exNodeNaviBean;
import com.example.geeknews.model.V2exModel;
import com.example.geeknews.presenter.V2exPresenter;
import com.example.geeknews.view.V2eView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import qdx.stickyheaderdecoration.NormalDecoration;


public class V2exActivity extends BaseMvpActivity<V2exPresenter, V2exModel, V2eView> implements V2eView {


    private static final String TAG = "V2exActivity";
    @BindView(R.id.rv)
    RecyclerView mRv;
    private ArrayList<V2exNodeNaviBean.DataBean> mList;
    private RlvV2exAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_v2ex;
    }

    @Override
    protected V2eView initMvpView() {
        return this;
    }

    @Override
    protected V2exModel initMvpModel() {
        return new V2exModel();
    }

    @Override
    protected V2exPresenter initMvpPresenter() {
        return new V2exPresenter();
    }

    @Override
    protected void initView() {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        adapter = new RlvV2exAdapter(this, mList);
        mRv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        myPresenter.RequestData();
    }

    @Override
    public void onField(String error) {
        Log.i(TAG, "onField: " + error);
    }

    @Override
    public void onSucceed(final List<V2exNodeNaviBean.DataBean> articlesBeans) {
        NormalDecoration normalDecoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                String name = articlesBeans.get(i).getName();
                return name;
            }
        };
        mRv.addItemDecoration(normalDecoration);
        mList.addAll(articlesBeans);
        adapter.notifyDataSetChanged();
    }
}
