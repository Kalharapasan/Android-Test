package com.example.a04task04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    Button button;
    TextView textView1, textView2, textView3, textView4;
    EditText editText;

    private int val;
    private double seek, dis, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView3);
        textView3 = findViewById(R.id.textView4);
        textView4 = findViewById(R.id.textView5);
        editText = findViewById(R.id.editTextText);

        // Set default discount value initially
        seek = seekBar.getProgress();
        textView1.setText("Discount Rate is: " + (int) seek + "%");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seek = i;
                textView1.setText("Discount Rate is: " + i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No action needed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No action needed
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = editText.getText().toString().trim();

                if (x.isEmpty()) {
                    editText.setError("Enter valid input");
                    editText.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    editText.requestFocus();
                } else {
                    try {
                        val = Integer.parseInt(x);

                        // Set price
                        textView2.setText("Price: " + val);

                        // Calculate discount
                        dis = (val * seek) / 100.0;
                        textView3.setText("Discount: " + String.format("%.2f", dis));

                        // Calculate total
                        total = val - dis;
                        textView4.setText("Total: " + String.format("%.2f", total));
                    } catch (NumberFormatException e) {
                        editText.setError("Invalid number format");
                    }
                }
            }
        });
    }
}
