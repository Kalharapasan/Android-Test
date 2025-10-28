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
    EditText id, name, email, age, address;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);


        back = findViewById(R.id.buttonBack);
        update = findViewById(R.id.buttonUpdate);
        delete = findViewById(R.id.buttonDelete);
        id = findViewById(R.id.editTextID);
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        age = findViewById(R.id.editTextAge);
        address = findViewById(R.id.editTextAddress);

        dbHelper = new DBHelper(this);


        back.setOnClickListener(v -> {
            Intent intent = new Intent(update_delete.this, MainActivity.class);
            startActivity(intent);
        });


        update.setOnClickListener(v -> {
            String ID = id.getText().toString().trim();
            String Name = name.getText().toString().trim();
            String Email = email.getText().toString().trim();
            String Age = age.getText().toString().trim();
            String Address = address.getText().toString().trim();

            if (ID.isEmpty() || Name.isEmpty() || Email.isEmpty() || Age.isEmpty() || Address.isEmpty()) {
                Toast.makeText(update_delete.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isUpdated = dbHelper.updateData(ID, Name, Email, Age, Address);

            if (isUpdated) {
                Toast.makeText(update_delete.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(update_delete.this, "Update Failed! Check ID", Toast.LENGTH_SHORT).show();
            }

            clearFields();
        });


        delete.setOnClickListener(v -> {
            String ID = id.getText().toString().trim();

            if (ID.isEmpty()) {
                Toast.makeText(update_delete.this, "Please enter an ID to delete", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isDeleted = dbHelper.deleteData(ID);

            if (isDeleted) {
                Toast.makeText(update_delete.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(update_delete.this, "Delete Failed! Check ID", Toast.LENGTH_SHORT).show();
            }


            clearFields();
        });
    }


    private void clearFields() {
        id.setText("");
        name.setText("");
        email.setText("");
        age.setText("");
        address.setText("");
    }
}
