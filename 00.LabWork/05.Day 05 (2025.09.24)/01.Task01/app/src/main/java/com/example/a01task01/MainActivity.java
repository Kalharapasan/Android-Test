package com.example.a01task01;

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

    SeekBar seekBar;
    Button button;
    TextView textView1,textView2;
    EditText editText;
    RadioGroup radioGroup;

    private int val,seekValue;
    private double dic,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar =findViewById(R.id.seekBar);
        button =findViewById(R.id.button);
        textView1 =findViewById(R.id.textView2);//Discount Ratw
        textView2 =findViewById(R.id.textView3);//Total
        editText=findViewById(R.id.editTextText);
        radioGroup =findViewById(R.id.radioGroup);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                seekValue =i;
                textView1.setText("Discount Rate: "+i+"%");

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
            public void onClick(View view) {
                String editeTextValue = editText.getText().toString();
                if(editeTextValue.isEmpty()){
                    throw new RuntimeException("Enter Valid INput");
                }else{
                    val = Integer.parseInt(editeTextValue);
                    dic = (val*seekValue)/100;
                    total= val-dic;

                    textView2.setText("Total Value Is :"+total);

                }
            }
        });


    }

}