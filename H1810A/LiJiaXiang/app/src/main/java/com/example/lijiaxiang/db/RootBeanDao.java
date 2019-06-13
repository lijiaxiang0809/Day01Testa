package com.example.lijiaxiang.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.lijiaxiang.RootBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ROOT_BEAN".
*/
public class RootBeanDao extends AbstractDao<RootBean, Long> {

    public static final String TABLENAME = "ROOT_BEAN";

    /**
     * Properties of entity RootBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Lid = new Property(0, Long.class, "lid", true, "lid");
        public final static Property Id = new Property(1, int.class, "id", false, "ID");
        public final static Property Image = new Property(2, int.class, "image", false, "IMAGE");
        public final static Property Title = new Property(3, String.class, "title", false, "TITLE");
        public final static Property Url = new Property(4, String.class, "url", false, "URL");
        public final static Property Type = new Property(5, int.class, "type", false, "TYPE");
    }


    public RootBeanDao(DaoConfig config) {
        super(config);
    }
    
    public RootBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ROOT_BEAN\" (" + //
                "\"lid\" INTEGER PRIMARY KEY ," + // 0: lid
                "\"ID\" INTEGER NOT NULL ," + // 1: id
                "\"IMAGE\" INTEGER NOT NULL ," + // 2: image
                "\"TITLE\" TEXT," + // 3: title
                "\"URL\" TEXT," + // 4: url
                "\"TYPE\" INTEGER NOT NULL );"); // 5: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ROOT_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RootBean entity) {
        stmt.clearBindings();
 
        Long lid = entity.getLid();
        if (lid != null) {
            stmt.bindLong(1, lid);
        }
        stmt.bindLong(2, entity.getId());
        stmt.bindLong(3, entity.getImage());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(4, title);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(5, url);
        }
        stmt.bindLong(6, entity.getType());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RootBean entity) {
        stmt.clearBindings();
 
        Long lid = entity.getLid();
        if (lid != null) {
            stmt.bindLong(1, lid);
        }
        stmt.bindLong(2, entity.getId());
        stmt.bindLong(3, entity.getImage());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(4, title);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(5, url);
        }
        stmt.bindLong(6, entity.getType());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RootBean readEntity(Cursor cursor, int offset) {
        RootBean entity = new RootBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // lid
            cursor.getInt(offset + 1), // id
            cursor.getInt(offset + 2), // image
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // title
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // url
            cursor.getInt(offset + 5) // type
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RootBean entity, int offset) {
        entity.setLid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setId(cursor.getInt(offset + 1));
        entity.setImage(cursor.getInt(offset + 2));
        entity.setTitle(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUrl(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setType(cursor.getInt(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RootBean entity, long rowId) {
        entity.setLid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RootBean entity) {
        if(entity != null) {
            return entity.getLid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RootBean entity) {
        return entity.getLid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
