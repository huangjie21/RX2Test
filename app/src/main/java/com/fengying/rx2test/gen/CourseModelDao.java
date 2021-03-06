package com.fengying.rx2test.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.fengying.rx2test.CourseModel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Course".
*/
public class CourseModelDao extends AbstractDao<CourseModel, Long> {

    public static final String TABLENAME = "Course";

    /**
     * Properties of entity CourseModel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property KeyID = new Property(0, Long.class, "keyID", true, "KeyID");
        public final static Property CourseID = new Property(1, int.class, "courseID", false, "CourseID");
        public final static Property CourseName = new Property(2, String.class, "courseName", false, "CourseName");
        public final static Property Memo = new Property(3, String.class, "memo", false, "Memo");
    }


    public CourseModelDao(DaoConfig config) {
        super(config);
    }
    
    public CourseModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Course\" (" + //
                "\"KeyID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: keyID
                "\"CourseID\" INTEGER NOT NULL ," + // 1: courseID
                "\"CourseName\" TEXT," + // 2: courseName
                "\"Memo\" TEXT);"); // 3: memo
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Course\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CourseModel entity) {
        stmt.clearBindings();
 
        Long keyID = entity.getKeyID();
        if (keyID != null) {
            stmt.bindLong(1, keyID);
        }
        stmt.bindLong(2, entity.getCourseID());
 
        String courseName = entity.getCourseName();
        if (courseName != null) {
            stmt.bindString(3, courseName);
        }
 
        String memo = entity.getMemo();
        if (memo != null) {
            stmt.bindString(4, memo);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CourseModel entity) {
        stmt.clearBindings();
 
        Long keyID = entity.getKeyID();
        if (keyID != null) {
            stmt.bindLong(1, keyID);
        }
        stmt.bindLong(2, entity.getCourseID());
 
        String courseName = entity.getCourseName();
        if (courseName != null) {
            stmt.bindString(3, courseName);
        }
 
        String memo = entity.getMemo();
        if (memo != null) {
            stmt.bindString(4, memo);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CourseModel readEntity(Cursor cursor, int offset) {
        CourseModel entity = new CourseModel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // keyID
            cursor.getInt(offset + 1), // courseID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // courseName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // memo
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CourseModel entity, int offset) {
        entity.setKeyID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCourseID(cursor.getInt(offset + 1));
        entity.setCourseName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMemo(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CourseModel entity, long rowId) {
        entity.setKeyID(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CourseModel entity) {
        if(entity != null) {
            return entity.getKeyID();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CourseModel entity) {
        return entity.getKeyID() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
