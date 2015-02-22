package com.example.gear.myapplication3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CourseDBHelper extends SQLiteOpenHelper {

    private static final String name = "calculate.sqlite3";
    private static final int version = 2;


    public CourseDBHelper(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE calculate (" +
                "_id integer primary key autoincrement," +
                "name text not null," +             // name
                "age int default 0," +              // age
                "height int default 0," +           //height
                "weight int default 0," +           //weight
                "gender text not null);";           //gender
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS calculate;";
        db.execSQL(sql);
        this.onCreate(db);
    }
}
