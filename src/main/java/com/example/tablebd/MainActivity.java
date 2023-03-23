package com.example.tablebd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BD bdhelper;
    SQLiteDatabase sdb;
    EditText name, kalor, belky, jyr, uglevod;
    Button save, info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        kalor = findViewById(R.id.kalor);
        belky = findViewById(R.id.belky);
        jyr = findViewById(R.id.jyr);
        uglevod = findViewById(R.id.uglevod);

        bdhelper = new BD(this);
        sdb = bdhelper.getWritableDatabase();

        save = findViewById(R.id.save);
        info = findViewById(R.id.info);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(BD.COLUMN_NAME, name.getText().toString());
                values.put(BD.COLUMN_KALOR, kalor.getText().toString());
                values.put(BD.COLUMN_BELKY, belky.getText().toString());
                values.put(BD.COLUMN_JYR, jyr.getText().toString());
                values.put(BD.COLUMN_UGLEVOD, uglevod.getText().toString());
                sdb.insert(BD.TABLE_NAME, null, values);
                Toast.makeText(getApplicationContext(), "Информация сохранена",
                        Toast.LENGTH_SHORT).show();
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Info_activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!sdb.isOpen())
            sdb= bdhelper.getWritableDatabase();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sdb.close();
    }
}