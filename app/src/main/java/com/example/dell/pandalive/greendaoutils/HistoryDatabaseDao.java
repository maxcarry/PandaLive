package com.example.dell.pandalive.greendaoutils;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.dell.pandalive.greendaoform.HistoryDatabase;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HISTORY_DATABASE".
*/
public class HistoryDatabaseDao extends AbstractDao<HistoryDatabase, Long> {

    public static final String TABLENAME = "HISTORY_DATABASE";

    /**
     * Properties of entity HistoryDatabase.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Dimg = new Property(1, String.class, "dimg", false, "DIMG");
        public final static Property Dname = new Property(2, String.class, "dname", false, "DNAME");
        public final static Property Dtime = new Property(3, String.class, "dtime", false, "DTIME");
        public final static Property Ddate = new Property(4, String.class, "ddate", false, "DDATE");
    };


    public HistoryDatabaseDao(DaoConfig config) {
        super(config);
    }
    
    public HistoryDatabaseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HISTORY_DATABASE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"DIMG\" TEXT," + // 1: dimg
                "\"DNAME\" TEXT," + // 2: dname
                "\"DTIME\" TEXT," + // 3: dtime
                "\"DDATE\" TEXT);"); // 4: ddate
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HISTORY_DATABASE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HistoryDatabase entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String dimg = entity.getDimg();
        if (dimg != null) {
            stmt.bindString(2, dimg);
        }
 
        String dname = entity.getDname();
        if (dname != null) {
            stmt.bindString(3, dname);
        }
 
        String dtime = entity.getDtime();
        if (dtime != null) {
            stmt.bindString(4, dtime);
        }
 
        String ddate = entity.getDdate();
        if (ddate != null) {
            stmt.bindString(5, ddate);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HistoryDatabase entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String dimg = entity.getDimg();
        if (dimg != null) {
            stmt.bindString(2, dimg);
        }
 
        String dname = entity.getDname();
        if (dname != null) {
            stmt.bindString(3, dname);
        }
 
        String dtime = entity.getDtime();
        if (dtime != null) {
            stmt.bindString(4, dtime);
        }
 
        String ddate = entity.getDdate();
        if (ddate != null) {
            stmt.bindString(5, ddate);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public HistoryDatabase readEntity(Cursor cursor, int offset) {
        HistoryDatabase entity = new HistoryDatabase( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // dimg
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // dname
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // dtime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // ddate
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HistoryDatabase entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDimg(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDname(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDtime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDdate(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(HistoryDatabase entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(HistoryDatabase entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}