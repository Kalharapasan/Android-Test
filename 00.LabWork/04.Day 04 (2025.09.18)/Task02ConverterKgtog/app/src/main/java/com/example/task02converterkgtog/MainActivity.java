package com.example.task02converterkgtog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    RadioGroup radioGroup1;

    TextView textView;
    EditText editText;

    private double vla = 0.0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        radioGroup1 = findViewById(R.id.radioGroup1);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double x = Double.parseDouble(editText.getText().toString());

                    int selectId1 = radioGroup1.getCheckedRadioButtonId();


                    if (selectId1 == R.id.radioButton) {
                        vla = x * 1000;

                    } else if (selectId1 == R.id.radioButton2) {
                        vla =x/1000;
                    } else {
                        textView.setText("Please select a conversion type.");
                        return;
                    }

                    // Set the result with formatted string
                    textView.setText(String.format("%.4f", vla));
                } catch (NumberFormatException e) {
                    textView.setText("Invalid input");
                }
            }
        });
    }
}
