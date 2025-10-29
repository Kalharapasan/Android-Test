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


        back = findViewById(R.id.buttonBack);
        update = findViewById(R.id.buttonUpdate);
        delete = findViewById(R.id.buttonDelete);
        id = findViewById(R.id.editTextID);
        name = findViewById(R.id.editTextName);
        emil = findViewById(R.id.editTextEmail);
        age = findViewById(R.id.editTextAge);
        address = findViewById(R.id.editTextAddress);

        dbHelper = new DBHelper(this);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIDText = id.getText().toString().trim();
                String userName = name.getText().toString().trim();
                String userEmail = emil.getText().toString().trim();
                String userAge = age.getText().toString().trim();
                String userAddress = address.getText().toString().trim();


                if (userIDText.isEmpty() || userName.isEmpty() || userEmail.isEmpty() ||
                        userAge.isEmpty() || userAddress.isEmpty()) {
                    Toast.makeText(update_delete.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }


                int userID;
                try {
                    userID = Integer.parseInt(userIDText);
                } catch (NumberFormatException e) {
                    Toast.makeText(update_delete.this, "Invalid ID format", Toast.LENGTH_SHORT).show();
                    return;
                }


                boolean isUpdated = dbHelper.updateData(userID, userName, userEmail, userAge, userAddress);

                if (isUpdated) {
                    Toast.makeText(update_delete.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(update_delete.this, "Update Failed! Check ID", Toast.LENGTH_SHORT).show();
                }


                clearFields();


                startActivity(new Intent(update_delete.this, View_Data.class));
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIDText = id.getText().toString().trim();


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
