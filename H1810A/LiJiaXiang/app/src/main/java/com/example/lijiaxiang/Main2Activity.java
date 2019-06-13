package com.example.lijiaxiang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mWeb = (WebView) findViewById(R.id.web);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWeb.loadUrl(url);
        mWeb.setWebChromeClient(new WebChromeClient());
    }
}
