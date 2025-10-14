/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

DBHelper.java
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


activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <!-- Title TextView -->
    <TextView
        android:id="@+id/titleText"
        android:layout_width="191dp"
        android:layout_height="36dp"
        android:text="Send Data"
        android:textAlignment="center"
        android:textColor="#E70707"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dp" />

    <!-- Name EditText -->
    <EditText
        android:id="@+id/editTextText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/titleText"
        android:layout_marginTop="20dp"
        android:hint="Name"
        android:inputType="text"
        android:ems="10" />

    <!-- Email EditText -->
    <EditText
        android:id="@+id/editTextText2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextText"
        android:layout_marginTop="16dp"
        android:hint="Email"
        android:inputType="text"
        android:ems="10" />

    <!-- Age EditText -->
    <EditText
        android:id="@+id/editTextText3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextText2"
        android:layout_marginTop="16dp"
        android:hint="Age"
        android:inputType="text"
        android:ems="10" />

    <!-- Button -->
    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Data"
        android:layout_below="@id/editTextText3"
        android:layout_marginTop="24dp"
        android:layout_centerHorizontal="true" />

</RelativeLayout>

MainActivity.java

package com.example.task01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    EditText name,email,age;
    Button add;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editTextText);
        email =findViewById(R.id.editTextText2);
        age=findViewById(R.id.editTextText3);
        add=findViewById(R.id.button);
        dbHelper =new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name =name.getText().toString();
                String Email =email.getText().toString();
                String Age =age.getText().toString();

                long rowID = dbHelper.insertData(Name,Email,Age);
                if(rowID != -1){
                    Toast.makeText(MainActivity.this,"Inserted With ID: "+rowID,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Inserted failed ",Toast.LENGTH_SHORT).show();
                }

                name.setText("");
                email.setText("");
                age.setText("");

            }
        });






    }
}

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////Task01/////////////////////////////////////////////////////////////////////