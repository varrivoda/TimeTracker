package com.example.timetracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_ROUTINES = "routines";
    public static final String COLUMN_ROUTINE_ID = "routine_id";
    public static final String COLUMN_ROUTINE_NAME = "routine_name";

    public static final String TABLE_ACTIONS = "actions";
    public static final String COLUMN_ACTION_ID = "_id";
    public static final String COLUMN_ACTION_DATE = "date";
    public static final String COLUMN_ACTION_ROUTINE_ID = "action_id";
    public static final String COLUMN_ACTION_QUANTITY = "quantity";
    public static final String COLUMN_ACTION_TIMESTAMP = "quantity";


    public DBHelper(Context context) {
        super(context, "test", null, 1);
    }

    private void createNewRoutinesTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ROUTINES +" ("
                + COLUMN_ROUTINE_ID + "INTEGER PRIMARY KEY, "
                + COLUMN_ROUTINE_NAME + "TEXT" +")"
        );
    }

    private void createNewActionsTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ACTIONS +" ("
                + COLUMN_ACTION_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_ACTION_TIMESTAMP + " INTEGER , "
                + COLUMN_ACTION_DATE + " TEXT, "
                + COLUMN_ACTION_ROUTINE_ID + " INTEGER , "
                + COLUMN_ACTION_QUANTITY + " INTEGER, "
                + "FOREIGN KEY (" + COLUMN_ROUTINE_ID
                + ") REFERENCES " + TABLE_ROUTINES + "(" + COLUMN_ROUTINE_ID+")"
                +")"
        );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createNewRoutinesTable(db);
        createNewRoutinesTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROUTINES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIONS);
        onCreate(db);
    }
}
