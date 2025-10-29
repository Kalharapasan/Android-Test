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
