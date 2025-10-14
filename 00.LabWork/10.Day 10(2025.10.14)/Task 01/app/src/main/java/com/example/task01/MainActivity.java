package com.example.task01;

import android.content.Intent;
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
    Button add,view;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editTextText);
        email =findViewById(R.id.editTextText2);
        age=findViewById(R.id.editTextText3);
        add=findViewById(R.id.button);
        view = findViewById(R.id.button2);

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

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,View_Data.class);
                startActivity(intent);

            }
        });






    }
}