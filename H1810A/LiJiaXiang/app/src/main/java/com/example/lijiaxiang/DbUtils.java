package com.example.lijiaxiang;

import com.example.lijiaxiang.db.DaoSession;
import com.example.lijiaxiang.db.RootBeanDao;

import java.util.List;

public class DbUtils {

    public static void insert(RootBean rootBean) {
        DaoSession daoSession = BaseApp.getDaoSession();
        if (queryitem(rootBean) == null) {
            daoSession.insert(rootBean);
        }
    }

    public static List<RootBean> queryAll() {
        DaoSession daoSession = BaseApp.getDaoSession();
        List<RootBean> rootBeans = daoSession.loadAll(RootBean.class);
        return rootBeans;
    }

    public static RootBean queryitem(RootBean rootBean) {
        DaoSession daoSession = BaseApp.getDaoSession();
        RootBean unique = daoSession.queryBuilder(RootBean.class)
                .where(RootBeanDao.Properties.Id.eq(rootBean.getId())).build().unique();

        return unique;
    }

}
