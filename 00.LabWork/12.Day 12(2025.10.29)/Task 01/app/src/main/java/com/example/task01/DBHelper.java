package com.example.task01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //Create Database
    public static final  String  DBName = "User.db";



    public DBHelper(Context context) {
        super(context, DBName, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT ," +
                "email TEXT,"+
                "age INTEGER ," +
                "address TEXT)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVertion, int newVertion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

    }

    //Insert Data
    public long insertData(String name, String email, String age,String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("age", age);
        contentValues.put("address",address);
        return db.insert("users", null, contentValues);
    }

    //View Data
    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM users",null);
    }


    //update data
    public boolean updateData(int id, String name, String email, String age,String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("age", age);
        contentValues.put("address",address);

        int result = db.update("users", contentValues, "ID = ?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    //delete data
    public boolean deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete("users", "ID = ?", new String[]{String.valueOf(id)});
        return result > 0;
    }

}
