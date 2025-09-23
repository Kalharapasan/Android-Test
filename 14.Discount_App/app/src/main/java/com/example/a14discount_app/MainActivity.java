package com.example.a14discount_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView1,textView2,textView3,textView4;
    SeekBar seekBar;
    RadioGroup radioGroup;
    private int val,seekbarval;
    private double dis,total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        editText=findViewById(R.id.editTextText);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        seekBar=findViewById(R.id.seekBar);
        radioGroup=findViewById(R.id.radioGroup);


        String str=editText.getText().toString();
        int rad=radioGroup.getCheckedRadioButtonId();

        if (str.isEmpty()){
            button.setEnabled(false);
        }
        else{
            button.setEnabled(true);
            val=Integer.parseInt(str);
            if(rad==R.id.cash){
                textView1.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
            }
            else if(rad==R.id.card){
                if (val ==10000){
                    textView1.setVisibility(View.VISIBLE);
                    seekBar.setVisibility(View.VISIBLE);
                }
            }
            else{
                textView1.setVisibility(View.INVISIBLE);
                seekBar.setVisibility(View.INVISIBLE);
            }
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarval=progress;
                textView1.setText(String.valueOf(seekbarval+"%"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis=(val*seekbarval)/100;
                total=val-dis;
                textView2.setVisibility(View.VISIBLE);
                textView2.setText(String.valueOf(val));
                textView3.setVisibility(View.VISIBLE);
                textView3.setText(String.valueOf(dis));
                textView4.setVisibility(View.VISIBLE);
                textView4.setText(String.valueOf(total));
            }
        });






    }
}