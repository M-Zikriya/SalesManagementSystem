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

import java.util.ArrayList;

public class CategoryView extends AppCompatActivity {

    ListView list1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        list1 = findViewById(R.id.lst1);

        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

        final Cursor c = db.rawQuery("select * from Category",null);

        int id = c.getColumnIndex("id");
        int categorye = c.getColumnIndex("category");
        int catedes = c.getColumnIndex("catdes");

        titles.clear();

        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        list1.setAdapter(arrayAdapter);

        final ArrayList<cate> catee = new ArrayList<cate>();

        if (c.moveToFirst())
        {
            do {
                cate ca = new cate();
                ca.id = c.getString(id);
                ca.category = c.getString(categorye);
                ca.des = c.getString(catedes);
                catee.add(ca);
                titles.add( c.getString(id) + "\t" + c.getString(categorye) + "\t" + c.getString(catedes) );
            }while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            list1.invalidateViews();
        }

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aaa = titles.get(position).toString();
                cate ca = catee.get((position));
                Intent i = new Intent(getApplicationContext(),CategoryEdit.class);
                i.putExtra("id",ca.id);
                i.putExtra("category",ca.category);
                i.putExtra("catedes",ca.des);
                startActivity(i);

            }
        });

    }


}
