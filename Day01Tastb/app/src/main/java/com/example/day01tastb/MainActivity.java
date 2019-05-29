package com.example.day01tastb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//李家祥
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private ArrayList<Person> mList;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Person mPerson = null;
        for (int i = 0; i < 20; i++) {
            mPerson = new Person();
            mPerson.setLid(null);
            mPerson.setImage(R.mipmap.ic_launcher);
            mPerson.setName("张三" + i);
            DbUtils.insert(mPerson);
        }
        List<Person> people = DbUtils.selectAll();
        mList.addAll(people);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        adapter = new PersonAdapter(this, mList);
        mRv.setAdapter(adapter);
    }
}
