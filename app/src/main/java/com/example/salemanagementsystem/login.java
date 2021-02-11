package com.example.salemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {


    EditText ed1,ed2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        ed1 = findViewById(R.id.user);
        ed2 = findViewById(R.id.pass);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                login();
            }
        });
    }

    public void login()
    {
        String username = ed1.getText().toString();
        String password = ed2.getText().toString();
        if(username.equals("") || password.equals(""))
        {
            Toast.makeText(this, "Username or password is blank", Toast.LENGTH_SHORT).show();
        }
        else if (username.equals("john") && password.equals("123"))
        {
            Intent i = new Intent(login.this, Main.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Username or Password not matched", Toast.LENGTH_SHORT).show();
        }

    }

}