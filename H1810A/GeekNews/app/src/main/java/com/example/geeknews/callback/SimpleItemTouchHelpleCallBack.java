package com.example.geeknews.callback;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleItemTouchHelpleCallBack extends ItemTouchHelper.Callback {


    private TouchCallBack mTouchCallBack;

    //起连接adapter 和 activity 的作用
    public SimpleItemTouchHelpleCallBack(TouchCallBack touchCallBack) {
        mTouchCallBack = touchCallBack;
    }

    //确定可以滑动的方向
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int drageFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swioeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(drageFlags, swioeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        //起点和终点位置
        mTouchCallBack.onItemMove(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //子条目侧滑改变item的位置
        mTouchCallBack.onItemDelete(viewHolder.getAdapterPosition());
    }
}
