package com.example.timetracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "test", null, 1);
    }

    public void createNewRoutine(){

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + "test_table" + "("
                + "_id" + " INTEGER PRIMARY KEY, "
                + "_action" + " TEXT ,"
                + "_quantity" + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "test_table");
        onCreate(db);
    }
}
