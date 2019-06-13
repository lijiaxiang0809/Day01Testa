package com.example.lijiaxiang;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lijiaxiang.contract.IContract;
import com.example.lijiaxiang.presenter.IPresenter;

import java.util.ArrayList;
import java.util.List;


public class Fragment_home extends Fragment implements IContract.View {


    private View view;
    private RecyclerView mRv;
    private ArrayList<RootBean> mList;
    private RlvAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initData();
        initMvp();
        return inflate;
    }

    private void initMvp() {
        IPresenter iPresenter = new IPresenter(this);
        iPresenter.RequestData();
    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            RootBean mRootBean = new RootBean();
            mRootBean.setLid(null);
            mRootBean.setId(i);
            mRootBean.setImage(R.mipmap.ic_launcher);
            mRootBean.setTitle("标题" + i);
            mRootBean.setUrl("https://home.firefoxchina.cn/?from=extra_start");
            mRootBean.setType(i);
            DbUtils.insert(mRootBean);
        }
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        adapter = new RlvAdapter(getContext(), mList);
        mRv.setAdapter(adapter);
        adapter.setOnitemclick(new RlvAdapter.onitemclick() {
            @Override
            public void onitem(int position) {
                RootBean rootBean = mList.get(position);
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("url", rootBean.getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSucceed(List<RootBean> succeed) {
        Log.i("--Main--", "onSucceed: " + succeed);
        mList.addAll(succeed);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onField(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
