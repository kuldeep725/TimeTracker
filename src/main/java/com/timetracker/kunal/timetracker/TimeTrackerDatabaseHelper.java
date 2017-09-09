package com.timetracker.kunal.timetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimeTrackerDatabaseHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "timetracker.db";
    private static final String TABLE_NAME = "timerecords";

    public static final String TIMETRACKER_COLUMN_ID = "_id";
    public static final String TIMETRACKER_COLUMN_TIME = "time";
    public static final String TIMETRACKER_COLUMN_NOTE = "note";

    private TimeTrackerOpenHelper openHelper;
    private SQLiteDatabase database;

    public TimeTrackerDatabaseHelper (Context context) {
        openHelper = new TimeTrackerOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public class TimeTrackerOpenHelper extends SQLiteOpenHelper {

        public TimeTrackerOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+TABLE_NAME+ "( "+TIMETRACKER_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TIMETRACKER_COLUMN_TIME+" TEXT, "+TIMETRACKER_COLUMN_NOTE+" TEXT );"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }

    }
    public void saveTimeRecord (String time,String note) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(TIMETRACKER_COLUMN_TIME,time);
        contentValues.put(TIMETRACKER_COLUMN_NOTE,note);

        database.insert(TABLE_NAME,null,contentValues);
    }
    
    public Cursor getTimeRecordList() {
        return database.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    }
}