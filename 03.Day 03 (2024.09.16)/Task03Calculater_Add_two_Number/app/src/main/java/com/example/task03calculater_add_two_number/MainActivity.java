package com.example.task03calculater_add_two_number;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    EditText editText1;
    EditText editText2;
    TextView textView;


    public void clear(){
        textView.setText("");
        editText1.setText("");
        editText2.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        textView = findViewById(R.id.textViwe);
        editText1 = findViewById(R.id.editTextNumber);
        editText2 = findViewById(R.id.editTextNumber2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();

                // Check if inputs are not empty
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    int num1 = Integer.parseInt(input1);
                    int num2 = Integer.parseInt(input2);
                    int output = num1 + num2;

                    textView.setVisibility(View.VISIBLE);
                    textView.setText(String.valueOf(output));
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Please enter both numbers.");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();

                // Check if inputs are not empty
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    int num1 = Integer.parseInt(input1);
                    int num2 = Integer.parseInt(input2);
                    int output = num1 - num2;

                    textView.setVisibility(View.VISIBLE);
                    textView.setText(String.valueOf(output));
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Please enter both numbers.");
                }
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();

                // Check if inputs are not empty
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    int num1 = Integer.parseInt(input1);
                    int num2 = Integer.parseInt(input2);
                    int output = num1 * num2;

                    textView.setVisibility(View.VISIBLE);
                    textView.setText(String.valueOf(output));
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Please enter both numbers.");
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();

                // Check if inputs are not empty
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    int num1 = Integer.parseInt(input1);
                    int num2 = Integer.parseInt(input2);
                    double output = num1 / num2;

                    textView.setVisibility(View.VISIBLE);
                    textView.setText(String.valueOf(output));
                } else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Please enter both numbers.");
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               clear();
            }
        });



    }
}
