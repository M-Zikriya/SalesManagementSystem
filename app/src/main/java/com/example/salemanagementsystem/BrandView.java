package com.example.salemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BrandView extends AppCompatActivity {

    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_view);

        lst1 = (ListView)findViewById(R.id.list12);
       // SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

        final Cursor c = db.rawQuery("select * from Brand",null);

        int id = c.getColumnIndex("id");
        int brand = c.getColumnIndex("brand");
        int branddes = c.getColumnIndex("branddes");

        titles.clear();

        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final ArrayList<bran> brann = new ArrayList<bran>();

        if (c.moveToFirst()){
            do {
                bran br = new bran();
                br.id = c.getString(id);
                br.brand = c.getString(brand);
                br.des = c.getString(branddes);
                brann.add(br);

                titles.add( c.getString(id) + "\t" + c.getString(brand) + "\t" + c.getString(branddes) );

            }while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
       }
        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aaa = titles.get(position).toString();
                bran br = brann.get((position));
                Intent i = new Intent(getApplicationContext(),BrandEdit.class);
                i.putExtra("id",br.id);
                i.putExtra("brand",br.brand);
                i.putExtra("branddes",br.des);
                startActivity(i);
            }
        });
    }

}