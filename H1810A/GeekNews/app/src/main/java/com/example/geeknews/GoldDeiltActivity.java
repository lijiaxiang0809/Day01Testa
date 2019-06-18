package com.example.geeknews;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.geeknews.adpater.RlvGoldAdapter;
import com.example.geeknews.base.BaseActivity;
import com.example.geeknews.bean.GoldBean;
import com.example.geeknews.callback.SimpleItemTouchHelpleCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoldDeiltActivity extends BaseActivity {

    @BindView(R.id.rv)
    RecyclerView mRv;
    private List<GoldBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gold_deilt;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mList = intent.getParcelableArrayListExtra("list");

        mRv.setLayoutManager(new LinearLayoutManager(this));
        RlvGoldAdapter adapter = new RlvGoldAdapter(this, mList);
        mRv.setAdapter(adapter);

        //构造方法可以传子类  adapter实现了 TouchCallBack
        SimpleItemTouchHelpleCallBack simple = new SimpleItemTouchHelpleCallBack(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simple);
        itemTouchHelper.attachToRecyclerView(mRv);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("mList", (ArrayList<? extends Parcelable>) mList);
        setResult(200, intent);
        super.onBackPressed();
    }
}
