#########################################Task01#######################

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

#########################################Task02#######################

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
                        vla = x * 1000; // grams to kg

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


#########################################Task03#######################

package com.example.task03seekbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        seekBar =findViewById(R.id.seekBar);
        textView =findViewById(R.id.textViwe);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                textView.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

}

#########################################Task01#######################

