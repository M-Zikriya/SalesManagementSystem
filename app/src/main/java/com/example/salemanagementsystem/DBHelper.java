package com.example.salemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;

//public class DBHelper extends SQLiteOpenHelper {


    /*public DBHelper(Context context) {
        super(context, "userdata.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE Table Brand(id INTEGER PRIMARY KEY AUTOINCREMENT,category TEXT primary key,catedes TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop Table if exists Brand");

    }

    //insert
    public boolean insert(String category, String catedes) {
        SQLiteDatabase DB = this.getWritableDatabase();

        //create contectvalue
        ContentValues contentValues = new ContentValues();
        contentValues.put("category", category);
        contentValues.put("catedes", catedes);
        long result = DB.insert("Brand", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    public boolean update(String category, String catedes) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category", category);
        contentValues.put("catedes", catedes);
        Cursor cursor = DB.rawQuery("select * from Brand", null);
        if (cursor.getCount() > 0) {
            long result = DB.update("Brand", contentValues, "id=?", null);
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Brand", null);
        return cursor;

    }
*/
//}