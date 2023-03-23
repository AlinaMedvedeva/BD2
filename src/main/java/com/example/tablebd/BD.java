package com.example.tablebd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "kalor.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "table_kalor";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_KALOR = "kalor";
    static final String COLUMN_BELKY = "belky";
    static final String COLUMN_JYR = "jyr";
    static final String COLUMN_UGLEVOD = "uglevod";
    public BD(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String str = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " integer primary key autoincrement, " +
                COLUMN_NAME + " text, " +
                COLUMN_KALOR + " real, " +
                COLUMN_BELKY + " real, " +
                COLUMN_JYR + " real, " +
                COLUMN_UGLEVOD + " real);";
        sqLiteDatabase.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
