package com.example.task03inputontextview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView text;

    int a=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn.findViewById(R.id.button);
        text.findViewById(R.id.testFiled);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a++;

                text.setText(String.valueOf(a));

            }
        });

    }
}