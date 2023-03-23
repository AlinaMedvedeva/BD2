package com.example.tablebd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Info_activity extends AppCompatActivity {

    BD bdhelper;
    ListView lw;
    Cursor cursor;
    SQLiteDatabase sdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        lw = findViewById(R.id.db_info_list);

        bdhelper = new BD(this);
        sdb = bdhelper.getWritableDatabase();

        String query = "SELECT* FROM " + BD.TABLE_NAME + ";";
        cursor = sdb.rawQuery(query, null);

        String [] from = {BD.COLUMN_NAME, BD.COLUMN_KALOR, BD.COLUMN_BELKY, BD.COLUMN_JYR, BD.COLUMN_UGLEVOD};
        int [] to = {R.id.name_info, R.id.kalor_info, R.id.belky_info, R.id.jyr_info, R.id.uglevod_info};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.info_item, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lw.setAdapter(cursorAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(!sdb.isOpen())
            sdb = bdhelper.getWritableDatabase();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cursor.close();
        sdb.close();
    }
}