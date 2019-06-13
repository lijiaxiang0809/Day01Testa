package com.example.lijiaxiang.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.lijiaxiang.RootBean;

import com.example.lijiaxiang.db.RootBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig rootBeanDaoConfig;

    private final RootBeanDao rootBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        rootBeanDaoConfig = daoConfigMap.get(RootBeanDao.class).clone();
        rootBeanDaoConfig.initIdentityScope(type);

        rootBeanDao = new RootBeanDao(rootBeanDaoConfig, this);

        registerDao(RootBean.class, rootBeanDao);
    }
    
    public void clear() {
        rootBeanDaoConfig.clearIdentityScope();
    }

    public RootBeanDao getRootBeanDao() {
        return rootBeanDao;
    }

}
