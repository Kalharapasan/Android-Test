package com.example.a23sqlite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Update extends AppCompatActivity {

    EditText fName,lName,gender,email;
    DBHelp dbHelp;
    Button update,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        back=findViewById(R.id.backButton);
        update=findViewById(R.id.addButton);

        fName =findViewById(R.id.userFName);
        lName =findViewById(R.id.userLName);
        gender =findViewById(R.id.userGender);
        email =findViewById(R.id.userEmail);

        dbHelp =new DBHelp(this);

    }
}