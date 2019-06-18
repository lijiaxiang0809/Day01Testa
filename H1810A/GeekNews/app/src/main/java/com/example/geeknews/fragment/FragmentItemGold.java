package com.example.geeknews.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;

@SuppressLint("ValidFragment")
public class FragmentItemGold extends Fragment {

    public FragmentItemGold(String name) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment_item_gold, container, false);
        return inflate;
    }

}
