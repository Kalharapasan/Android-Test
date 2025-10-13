package com.example.a21sqlite_text;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper data;
    EditText name,surname,marks;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data =new DatabaseHelper(this);
        name =findViewById(R.id.name);
        surname =findViewById(R.id.surname);
        marks =findViewById(R.id.mark);
        add =findViewById(R.id.add);

        public void addData(){
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.insertData(name.getText().toString(),
                            surname.getText().toString(),
                            marks.getText());
                }
            });
        }

    }
}