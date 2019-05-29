package com.example.day01testa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.day01testa.contract.IContract;
import com.example.day01testa.presenter.IPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

//李家祥
public class MainActivity extends AppCompatActivity implements IContract.View {

    private static final String TAG = "--Main--";
    private XRecyclerView mXrv;
    private ArrayList<GirlBean.ResultsBean> mList;
    private GirlAdapter adapter;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        IPresenter iPresenter = new IPresenter(this);
        iPresenter.RequestData(page);
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        adapter = new GirlAdapter(this, mList);
        mXrv.setAdapter(adapter);
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mList.clear();
                initData();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                initData();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void UpDataRequestSucceed(List<GirlBean.ResultsBean> resultsBeans) {
        mList.addAll(resultsBeans);
        adapter.notifyDataSetChanged();
        mXrv.refreshComplete();
        mXrv.loadMoreComplete();
    }

    @Override
    public void UpDataRequestField(String error) {
        Log.i(TAG, "UpDataRequestField: " + error);
    }
}
