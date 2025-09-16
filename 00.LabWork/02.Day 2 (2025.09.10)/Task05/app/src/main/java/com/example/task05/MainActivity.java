package com.example.task05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView text;
    int x= 10;
    int y=20;
    int z=30;
    int sum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn.findViewById(R.id.button);
        text.findViewById(R.id.textViwe);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sum = x+y+z;

                text.setText(String.valueOf(sum));

            }
        });

    }
}