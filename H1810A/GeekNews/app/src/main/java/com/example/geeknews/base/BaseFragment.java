package com.example.geeknews.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this,inflate);
        initMvp();
        initView(inflate);
        initData();
        initListener();
        return inflate;
    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView(View inflate) {

    }

    protected void initMvp() {

    }

    protected abstract int getLayoutId();
}
