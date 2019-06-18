package com.example.geeknews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.geeknews.base.BaseActivity;
import com.example.geeknews.fragment.FragmentAbout;
import com.example.geeknews.fragment.FragmentCollect;
import com.example.geeknews.fragment.FragmentDailyNews;
import com.example.geeknews.fragment.FragmentGank;
import com.example.geeknews.fragment.FragmentGold;
import com.example.geeknews.fragment.FragmentSearchGank;
import com.example.geeknews.fragment.FragmentSearchWechat;
import com.example.geeknews.fragment.FragmentSettings;
import com.example.geeknews.fragment.FragmentV2ex;
import com.example.geeknews.fragment.FragmentWechat;
import com.example.geeknews.utils.FragmentUtils;
import com.example.geeknews.utils.ToastUtil;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;

//李家祥
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fl)
    FrameLayout mFl;
    @BindView(R.id.na)
    NavigationView mNa;
    @BindView(R.id.dl)
    DrawerLayout mDl;
    @BindView(R.id.msv)
    MaterialSearchView mMsv;
    public ArrayList<Integer> mList = new ArrayList<>();
    private FragmentManager mManager;
    private MenuItem mItem;
    private int LaseType;

    //找组件
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        //给标题的list集合添加数据
        initTitle();
        //替换actionbar
        setSupportActionBar(mToolbar);
        //为toolbar的标题切换颜色
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        //设置布局管理器
        mManager = getSupportFragmentManager();
        //默认添加知乎页面
        FragmentUtils.addFragment(mManager, FragmentDailyNews.class, R.id.fl);

        //旋转开关
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDl, mToolbar, R.string.app_name, R.string.app_name);
        //为旋转开关设置颜色
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        mDl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void initListener() {
        //监听侧滑
        mNa.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mItem.setVisible(false);
                switch (menuItem.getItemId()) {
                    case R.id.zhihu:
                        switchtitle(mList.get(0));
                        FragmentUtils.addFragment(mManager, FragmentDailyNews.class, R.id.fl);
                        break;
                    case R.id.wechat:
                        switchtitle(mList.get(1));
                        FragmentUtils.addFragment(mManager, FragmentWechat.class, R.id.fl);
                        break;
                    case R.id.gank:
                        switchtitle(mList.get(2));
                        FragmentUtils.addFragment(mManager, FragmentGank.class, R.id.fl);
                        break;
                    case R.id.gold:
                        switchtitle(mList.get(3));
                        FragmentUtils.addFragment(mManager, FragmentGold.class, R.id.fl);
                        break;
                    case R.id.v2ex:
                        switchtitle(mList.get(4));
                        FragmentUtils.addFragment(mManager, FragmentV2ex.class, R.id.fl);
                        break;
                    case R.id.collect:
                        switchtitle(mList.get(5));
                        FragmentUtils.addFragment(mManager, FragmentCollect.class, R.id.fl);
                        break;
                    case R.id.settings:
                        switchtitle(mList.get(6));
                        FragmentUtils.addFragment(mManager, FragmentSettings.class, R.id.fl);
                        break;
                    case R.id.ahout:
                        switchtitle(mList.get(7));
                        FragmentUtils.addFragment(mManager, FragmentAbout.class, R.id.fl);
                        break;
                }
                mDl.closeDrawers();
                return false;
            }
        });
        mMsv.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                ToastUtil.showShort("onSearchViewShown");
            }

            @Override
            public void onSearchViewClosed() {
                ToastUtil.showShort("onSearchViewClosed");
                //Fragment关闭页面调回回退栈
                mManager.popBackStack();//搜索关闭同时关Fragment
            }
        });
        mMsv.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ToastUtil.showShort(query);
                Bundle bundle = new Bundle();
                bundle.putString("query", query);
                //fragment 不同时  跳转不同的页面
                if (LaseType == mList.get(1)) {
                    FragmentUtils.addFragment(mManager, FragmentSearchWechat.class, R.id.fl, bundle, true);
                } else {
                    FragmentUtils.addFragment(mManager, FragmentSearchGank.class, R.id.fl, bundle, true);
                }
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ToastUtil.showShort(newText);
                return false;
            }
        });
    }

    private void switchtitle(int type) {
        //当页面为微信精选和我干货的时候显示搜索框
        LaseType = type;
        if (type == mList.get(1) || type == mList.get(2)) {
            mItem.setVisible(true);
        } else {
            mItem.setVisible(false);
        }
        mToolbar.setTitle(type);
    }

    private void initTitle() {
        mList.add(R.string.zhihu);
        mList.add(R.string.wechat);
        mList.add(R.string.gank);
        mList.add(R.string.gold);
        mList.add(R.string.v2ex);
        mList.add(R.string.collect);
        mList.add(R.string.settings);
        mList.add(R.string.about);
        mToolbar.setTitle(mList.get(0));
    }

    //创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.seek_menu, menu);
        //找选项菜单中的组件
        mItem = menu.findItem(R.id.seek);
        //默认设置为不可显示
        mItem.setVisible(false);
        mMsv.setMenuItem(mItem);//与菜单绑定
        return super.onCreateOptionsMenu(menu);
    }

    //监听返回键
    @Override
    public void onBackPressed() {
//        //监听侧滑
//        if (mDl.isDrawerOpen(GravityCompat.START)){
//            mDl.closeDrawer(GravityCompat.START);
//        }else {
//            super.onBackPressed();
//        }
        //监听fragment
        if (mMsv.isSearchOpen()) {
            mMsv.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
