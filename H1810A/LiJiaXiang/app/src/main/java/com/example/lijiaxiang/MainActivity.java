package com.example.lijiaxiang;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Fragment_home());
        list.add(new Fragment_love());
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("校门");
        mTab.getTabAt(1).setText("关注");
    }
}
