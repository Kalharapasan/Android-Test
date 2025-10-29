////////////////////////////////////////////////////////////Task01///////////////////////////////////////////////////////
DBHelper.java
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

MainActivity.java
package com.example.task01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email, age, address;
    Button add, view, update;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        name = findViewById(R.id.editTextText);
        email = findViewById(R.id.editTextText2);
        age = findViewById(R.id.editTextText3);
        address = findViewById(R.id.editTextText4);
        add = findViewById(R.id.button);
        view = findViewById(R.id.button2);
        update = findViewById(R.id.button3);

        dbHelper = new DBHelper(this);

        // Insert Data
        add.setOnClickListener(v -> {
            String Name = name.getText().toString().trim();
            String Email = email.getText().toString().trim();
            String Age = age.getText().toString().trim();
            String Address = address.getText().toString().trim();

            // Basic validation
            if (Name.isEmpty() || Email.isEmpty() || Age.isEmpty() || Address.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            long rowID = dbHelper.insertData(Name, Email, Age, Address);

            if (rowID != -1) {
                Toast.makeText(MainActivity.this, "Inserted Successfully (ID: " + rowID + ")", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
            }

            // Clear input fields
            name.setText("");
            email.setText("");
            age.setText("");
            address.setText("");
            Intent intent =new Intent(MainActivity.this,View_Data.class);
            startActivity(intent);
        });

        // View Data
        view.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, View_Data.class);
            startActivity(intent);
        });

        // Go to Update/Delete Page
        update.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, update_delete.class);
            startActivity(intent);
        });
    }
}

activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <!-- Title -->
    <TextView
        android:id="@+id/titleText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Data"
        android:textColor="#E70707"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dp" />

    <!-- Name -->
    <EditText
        android:id="@+id/editTextText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/titleText"
        android:layout_marginTop="20dp"
        android:hint="Name"
        android:inputType="textPersonName" />

    <!-- Email -->
    <EditText
        android:id="@+id/editTextText2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextText"
        android:layout_marginTop="16dp"
        android:hint="Email"
        android:inputType="textEmailAddress" />

    <!-- Age -->
    <EditText
        android:id="@+id/editTextText3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextText2"
        android:layout_marginTop="16dp"
        android:hint="Age"
        android:inputType="number" />

    <!-- Address -->
    <EditText
        android:id="@+id/editTextText4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextText3"
        android:layout_marginTop="16dp"
        android:hint="Address"
        android:inputType="textPostalAddress" />

    <!-- Send Button -->
    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Data"
        android:layout_below="@id/editTextText4"
        android:layout_marginTop="24dp"
        android:layout_centerHorizontal="true" />

    <!-- View Button -->
    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="View Data"
        android:layout_below="@id/button"
        android:layout_marginTop="16dp"
        android:layout_centerHorizontal="true" />

    <!-- Update/Delete Button -->
    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Update or Delete Data"
        android:layout_below="@id/button2"
        android:layout_marginTop="16dp"
        android:layout_centerHorizontal="true" />

</RelativeLayout>

View_Data.java
package com.example.task01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class View_Data extends AppCompatActivity {

    Button back;
    DBHelper dbHelper;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        back =findViewById(R.id.button3);
        listView =findViewById(R.id.listViewData);
        dbHelper =new DBHelper(this);

        ArrayList<String> dataList = new ArrayList<>();
        Cursor res =dbHelper.getAllData();

        if (res.getCount() == 0){
            dataList.add("No Data");
        }else {
            while(res.moveToNext()){
                String record = "ID: "+res.getInt(0) +
                        "\nName : "+res.getString(1) +
                        "\nemail : " +res.getString(2)+
                        "\nAge: "+ res.getInt(3)+"" +
                        "\nAddres: " +res.getString(4);

                dataList.add(record);
            }
        }

        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,dataList
        );

        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(View_Data.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
activity_view_data.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".View_Data">

    <ListView
        android:id="@+id/listViewData"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="10dp"
        android:layout_marginTop="25dp"
        android:layout_marginEnd="15dp"
        android:divider="@android:color/darker_gray"
        android:dividerHeight="1dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/button3" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Back To Home"
        android:layout_margin="16dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>

update_delete.java
package com.example.task01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class update_delete extends AppCompatActivity {
    Button update, delete, back;
    EditText id, name, emil, age, address;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        // Initialize views
        back = findViewById(R.id.buttonBack);
        update = findViewById(R.id.buttonUpdate);
        delete = findViewById(R.id.buttonDelete);
        id = findViewById(R.id.editTextID);
        name = findViewById(R.id.editTextName);
        emil = findViewById(R.id.editTextEmail);
        age = findViewById(R.id.editTextAge);
        address = findViewById(R.id.editTextAddress);

        dbHelper = new DBHelper(this);

        // ===== UPDATE BUTTON =====
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIDText = id.getText().toString().trim();
                String userName = name.getText().toString().trim();
                String userEmail = emil.getText().toString().trim();
                String userAge = age.getText().toString().trim();
                String userAddress = address.getText().toString().trim();

                // Validate fields before parsing
                if (userIDText.isEmpty() || userName.isEmpty() || userEmail.isEmpty() ||
                        userAge.isEmpty() || userAddress.isEmpty()) {
                    Toast.makeText(update_delete.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Safely parse ID
                int userID;
                try {
                    userID = Integer.parseInt(userIDText);
                } catch (NumberFormatException e) {
                    Toast.makeText(update_delete.this, "Invalid ID format", Toast.LENGTH_SHORT).show();
                    return;
                }

                //  Update data
                boolean isUpdated = dbHelper.updateData(userID, userName, userEmail, userAge, userAddress);

                if (isUpdated) {
                    Toast.makeText(update_delete.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(update_delete.this, "Update Failed! Check ID", Toast.LENGTH_SHORT).show();
                }

                //  Clear input fields
                clearFields();

                //  Navigate back to view screen
                startActivity(new Intent(update_delete.this, View_Data.class));
            }
        });

        // ===== DELETE BUTTON =====
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIDText = id.getText().toString().trim();

                // Validate before parsing
                if (userIDText.isEmpty()) {
                    Toast.makeText(update_delete.this, "Please enter an ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                int userID;
                try {
                    userID = Integer.parseInt(userIDText);
                } catch (NumberFormatException e) {
                    Toast.makeText(update_delete.this, "Invalid ID format", Toast.LENGTH_SHORT).show();
                    return;
                }

                //  Delete data
                boolean isDeleted = dbHelper.deleteData(userID);

                if (isDeleted) {
                    Toast.makeText(update_delete.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(update_delete.this, "Delete Failed! Check ID", Toast.LENGTH_SHORT).show();
                }

                clearFields();
                startActivity(new Intent(update_delete.this, View_Data.class));
            }
        });

        // ===== BACK BUTTON =====
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(update_delete.this, MainActivity.class));
            }
        });
    }


    private void clearFields() {
        id.setText("");
        name.setText("");
        emil.setText("");
        age.setText("");
        address.setText("");
    }
}

activity_update_delete.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    tools:context=".update_delete">

    <!-- Title -->
    <TextView
        android:id="@+id/titleText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Update and Delete Data"
        android:textColor="#E70707"
        android:textSize="22sp"
        android:textStyle="bold"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="30dp" />

    <!-- ID EditText -->
    <EditText
        android:id="@+id/editTextID"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter ID"
        android:inputType="number"
        app:layout_constraintTop_toBottomOf="@id/titleText"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="20dp" />

    <!-- Name EditText -->
    <EditText
        android:id="@+id/editTextName"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter Name"
        android:inputType="textPersonName"
        app:layout_constraintTop_toBottomOf="@id/editTextID"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp" />

    <!-- Email EditText -->
    <EditText
        android:id="@+id/editTextEmail"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter Email"
        android:inputType="textEmailAddress"
        app:layout_constraintTop_toBottomOf="@id/editTextName"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp" />

    <!-- Age EditText -->
    <EditText
        android:id="@+id/editTextAge"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter Age"
        android:inputType="number"
        app:layout_constraintTop_toBottomOf="@id/editTextEmail"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp" />

    <!-- Address EditText -->
    <EditText
        android:id="@+id/editTextAddress"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter Address"
        android:inputType="textPostalAddress"
        app:layout_constraintTop_toBottomOf="@id/editTextAge"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp" />

    <!-- Update Button -->
    <Button
        android:id="@+id/buttonUpdate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Update Data"
        android:backgroundTint="#1E88E5"
        app:layout_constraintTop_toBottomOf="@id/editTextAddress"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="24dp" />

    <!-- Delete Button -->
    <Button
        android:id="@+id/buttonDelete"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Delete Data"
        android:backgroundTint="#E40707"
        app:layout_constraintTop_toBottomOf="@id/buttonUpdate"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp" />

    <!-- Back Button -->
    <Button
        android:id="@+id/buttonBack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Back to Insert"
        app:layout_constraintTop_toBottomOf="@id/buttonDelete"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
    

////////////////////////////////////////////////////////////Task01///////////////////////////////////////////////////////A


////////////////////////////////////////////////////////////Task01///////////////////////////////////////////////////////A

////////////////////////////////////////////////////////////Task01///////////////////////////////////////////////////////A