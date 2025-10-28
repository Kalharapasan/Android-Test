package com.example.a23sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelp extends SQLiteOpenHelper {

    public static final String dbName = "User.db";
    public DBHelp(Context context) {
        super(context,dbName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "fristName TEXT ," +
                "lastName TEXT," +
                "gender TEXT," +
                "mail TEXT)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

    }
}
