package com.example.task01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private  String msg;

    RadioGroup radioGroup;
    EditText editText;
    Button button;
    TextView textView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup= findViewById(R.id.radioGroup);
        editText =findViewById(R.id.editTextText);
        button =findViewById(R.id.button);
        textView =findViewById(R.id.textView1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = "You Name is ";
                String vla=editText.getText().toString();
                msg=msg+vla;

                //Create a varibale for Radio Butten
                int selectId = radioGroup.getCheckedRadioButtonId();
                //Comdition
                if (selectId == R.id.radioButton){
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(msg+",You are Male");
                }
                if(selectId == R.id.radioButton2){
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(msg+",You are Female");
                }
            }
        });



    }
}