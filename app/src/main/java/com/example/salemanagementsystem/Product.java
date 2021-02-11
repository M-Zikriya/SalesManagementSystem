package com.example.salemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Product extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Spinner spinner,spinner1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> titles1 = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    ArrayAdapter arrayAdapter1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ed1 = findViewById(R.id.product);
        ed2 = findViewById(R.id.productdes);
        spinner = findViewById(R.id.catid);
        spinner1 = findViewById(R.id.brandid);
        ed3 = findViewById(R.id.qty);
        ed4 = findViewById(R.id.price);

        b1 = findViewById(R.id.btn1);

        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

        final Cursor c = db.rawQuery("select * from Category",null);

        int categorye = c.getColumnIndex("category");


        titles.clear();

        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        spinner.setAdapter(arrayAdapter);

        final ArrayList<cate> catee = new ArrayList<cate>();

        if (c.moveToFirst())
        {
            do {
                cate ca = new cate();
                ca.category = c.getString(categorye);

                catee.add(ca);
                titles.add(c.getString(categorye));
            }while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();

        }



    final Cursor b = db.rawQuery("select * from Brand",null);

    int brand = b.getColumnIndex("brand");


        titles1.clear();

    arrayAdapter1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles1);
        spinner1.setAdapter(arrayAdapter1);

    final ArrayList<bran> brann = new ArrayList<bran>();

        if (b.moveToFirst())
    {
        do {
            bran ba = new bran();
            ba.brand = b.getString(brand);

            brann.add(ba);
            titles1.add(b.getString(brand));
        }while (b.moveToNext());
        
        arrayAdapter.notifyDataSetChanged();

    }
}
}