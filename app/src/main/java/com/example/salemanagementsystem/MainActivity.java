package com.example.salemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list15=(ListView)findViewById(R.id.li);
        ArrayList<String > arrayList = new ArrayList<>();

        arrayList.add("android");
        arrayList.add("android1");
        arrayList.add("android2");
        arrayList.add("android3");
        arrayList.add("android4");
        arrayList.add("android5");
        arrayList.add("android6");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        list15.setAdapter(arrayAdapter);
    }
}