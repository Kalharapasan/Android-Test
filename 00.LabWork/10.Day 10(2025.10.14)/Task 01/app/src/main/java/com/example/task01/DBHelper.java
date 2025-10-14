package com.example.task01;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //Create Database
    public static final  String  DBName = "User.db";



    public DBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT ," +
                "email text,"+
                "age INTEGER )"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVertion, int newVertion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

    }

    public long insertData(String name, String email, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("age", age);
        return db.insert("users", null, contentValues);
    }


}
