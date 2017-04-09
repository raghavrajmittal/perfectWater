package com.example.thushara.perfectwater.Controller;
//package com.mobilesiri.sqliteexample;


import android.content.Context;


        import android.database.sqlite.SQLiteOpenHelper;

        import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite;

/**
 * Created by baria on 4/6/17.
 */

public class LoginSQLActivity extends SQLiteOpenHelper{



    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Database";
    // Contacts table name
    private static final String TABLE_REPORTS = "Reports";
    // Shops Table Columns names
    private static final String KEY_DATE = "Date";
    private static final String KEY_CONDITION = "Water Condition";
    private static final String KEY_TYPE = "Type";
    public LoginSQLActivity(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override


    /**
     * creates table in database
     * @param SQLiteDatabase that we'll be using
     */
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_REPORTS + "(" + KEY_DATE+
                " INTEGER PRIMARY KEY," + KEY_CONDITION + " TEXT," + KEY_TYPE + "TEXT" +
                ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override

    /**
     * dropping older table if it exists and creating tables again
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPORTS);
        onCreate(db);
    }
}