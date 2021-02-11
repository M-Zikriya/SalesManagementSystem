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

public class brand extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        ed1 = findViewById(R.id.cate);
        ed2 = findViewById(R.id.catdes);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(brand.this,Main.class);
                startActivity(i);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            insertb();
            }
        });
    }

    public void insertb()
    {
        try {
            String brand = ed1.getText().toString();
            String branddescription = ed2.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);

            db.execSQL("CREATE TABLE IF NOT EXISTS Brand("
                    +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"brand VARCHAR,"
                    +"branddes VARCHAR);");

            String sql = "INSERT INTO Brand (brand,branddes)values(?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,brand);
            statement.bindString(2,branddescription);
            statement.execute();
            Toast.makeText(this, "brand Created", Toast.LENGTH_SHORT).show();
            ed1.setText("");
            ed2.setText("");
            ed1.requestFocus();
        }

        catch (Exception ex)
        {
            Toast.makeText(this, "brand Failed", Toast.LENGTH_SHORT).show();
        }
    }


}