package com.example.task01;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText etx;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.conButton);
        etx = findViewById(R.id.editTextText);
        text = findViewById(R.id.outputText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = etx.getText().toString(); // Get text from input field

                // Basic validation (optional, but helpful)
                if (!value.isEmpty()) {
                    int mony = Integer.parseInt(value);
                    double out = mony * 300;
                    text.setVisibility(View.VISIBLE);
                    text.setTextColor(Color.BLACK);
                    text.setText(String.valueOf(out)); // Convert double to String properly
                } else {
                    text.setText("Please enter a number.");
                }
            }
        });
    }
}
