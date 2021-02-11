package com.example.salemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CategoryEdit extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_edit);

        ed1 = findViewById(R.id.catID);
        ed2 = findViewById(R.id.cate);
        ed3 = findViewById(R.id.catdes);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);

        Intent i = getIntent();
        String id = i.getStringExtra("id").toString();
        String category = i.getStringExtra("category").toString();
        String des = i.getStringExtra("catdes").toString();

        ed1.setText(id);
        ed2.setText(category);
        ed3.setText(des);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });

    }

    public void edit()
    {
        try {
            String catid = ed1.getText().toString();
            String categoryname = ed2.getText().toString();
            String catdescriptionn = ed3.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

            //String sql = "insert into catergory(category,catdes)values(?,?)";
            String sql = "update Category set category =?,catedes = ? where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,categoryname);
            statement.bindString(2,catdescriptionn);
            statement.bindString(3,catid);
            statement.execute();
            Toast.makeText(this, "Category updated", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),Main.class);
            startActivity(i);
        }

        catch (Exception ex)
        {
            Toast.makeText(this, "Category Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete()
    {
        try {
            String catid = ed1.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

            String sql = "delete from Category where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,catid);
            statement.execute();
            Toast.makeText(this, "Category deleted", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),Main.class);
            startActivity(i);


        }
        catch (Exception ex) {

            Toast.makeText(this, "Delete failed", Toast.LENGTH_SHORT).show();
        }
    }
}