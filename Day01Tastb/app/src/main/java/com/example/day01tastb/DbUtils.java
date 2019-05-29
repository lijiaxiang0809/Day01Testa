package com.example.day01tastb;

import android.util.Log;

import com.example.day01tastb.db.DaoSession;
import com.example.day01tastb.db.PersonDao;

import java.util.List;

public class DbUtils {

    public static Person selectitem(Person person){
        DaoSession daoSession = BaseApp.getDaoSession();
        Person unique = daoSession.queryBuilder(Person.class)
                .where(PersonDao.Properties.Name.eq(person.getName()))
                .build().unique();
        return unique;
    }

    public static void insert(Person person){
        DaoSession daoSession = BaseApp.getDaoSession();
        if (selectitem(person)==null){
            long insert = daoSession.insert(person);
            Log.i("--Main--", "insert: "+insert);
        }
    }

    public static List<Person> selectAll() {

        DaoSession daoSession = BaseApp.getDaoSession();
        return daoSession.loadAll(Person.class);

    }

}
